package pl.skiba.tekkenrankings.polskipunish.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.ObjectUtils;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Player;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;

import javax.persistence.EntityNotFoundException;
import java.net.URL;
import java.util.*;

@Service
public class ChallongeService {

    private final PlayerService playerService;
    private final GameService gameService;

    public ChallongeService(PlayerService playerService, GameService gameService) {
        this.playerService = playerService;
        this.gameService = gameService;
    }

    public List<ChallongeParticipant> makeChallongeParticipantsList(String url) {

        List<ChallongeParticipant> participantList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node2 = objectMapper.readTree(new URL(url));
            node2.forEach(element -> {
                String participant = element.at("/participant").toString();
                try {
                    participantList.add(objectMapper.readValue(participant, ChallongeParticipant.class));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            });
        } catch (Exception e) {
            throw new EntityNotFoundException("Nie znaleziono turnieju o tej nazwie na Challonge");
        }


        participantList.sort(new Comparator<>() {
            @Override
            public int compare(ChallongeParticipant o1, ChallongeParticipant o2) {
                if (o1.getPlacement() == 0) {
                    return (o2.getPlacement() == 0) ? 0 : 1;
                }
                if (o2.getPlacement() == 0) {
                    return -1;
                }
                return o1.getPlacement() - (o2.getPlacement());
            }
        });

        return participantList;
    }

    public Tournament getTourmanetFromParticipantList(List<TournamentParticipant> participantList, TournamentCategoryEnum tournamentType, String tournamentName, String gamename, String country, Date eventDate) {
        Tournament tournament = new Tournament(tournamentName, tournamentType, gameService.getGameByName(gamename), participantList, country, eventDate);
        participantList.forEach(element -> {
            element.setTournament(tournament);
            Player player = element.getPlayer();
            if (playerService.ifExists(element.getPlayer().getName())) {
                player = playerService.getByName(element.getPlayer().getName()).orElseThrow(); //Don't need handle exceptions because of if statement
            }

            if(Objects.nonNull(element.getChallongeId())){
                player.setChallongeId(element.getChallongeId());
            }

            if (element.getPlacement() <= 9) {
                if (tournamentType == TournamentCategoryEnum.Offline) {
                    element.pointsFromPlacement(element.getPlacement());
                    player.setOfflinePoints(element.getPoints() + player.getOfflinePoints());

                } else {
                    element.pointsFromPlacement(element.getPlacement());
                    player.setOnlinePoints(element.getPoints() + player.getOnlinePoints());
                }
            }

            element.setPlayer(player);

        });
        tournament.setParticipants(participantList);
        return tournament;
    }
}
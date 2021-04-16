package pl.skiba.tekkenrankings.polskipunish.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentPointsEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Integer.parseInt;

@Service
public class ChallongeService {

    private PlayerService playerService;
    private GameService gameService;

    public ChallongeService(PlayerService playerService, GameService gameService) {
        this.playerService = playerService;
        this.gameService = gameService;
    }

    public List<ChallongeParticipant> makeChallongeParticipantsList(String url, String tournamentname) throws IOException {

        List<ChallongeParticipant> participantList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        JSONArray response = JsonReader.readJsonFromUrl(url , tournamentname);

        response.forEach(element -> {
            JSONObject obj = (JSONObject) element;
            String participantJSON = ((JSONObject) element).getJSONObject("participant").toString();
            try {
                participantList.add(objectMapper.readValue(participantJSON, ChallongeParticipant.class));
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }

        });

        participantList.sort(new Comparator<ChallongeParticipant>() {
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

    public Tournament getTourmanetFromParticipantList(List<TournamentParticipant> participantList, TournamentCategoryEnum tournamentType , String tournamentName, String gamename) {
        Tournament tournament = new Tournament(tournamentName,tournamentType, gameService.getGameByName(gamename), participantList);
        participantList.forEach(element -> {
            element.setTournament(tournament);
            Player player = element.getPlayer();
            if (playerService.ifExists(element.getPlayer().getName())) {
                player = playerService.getByName(element.getPlayer().getName()).orElseThrow(); //Don't need handle exceptions because of if statement
            }

            if(element.getPlacement() <=9)
            {
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
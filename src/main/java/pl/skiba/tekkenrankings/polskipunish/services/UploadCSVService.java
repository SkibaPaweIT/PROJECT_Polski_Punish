package pl.skiba.tekkenrankings.polskipunish.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.TournamentFromCSV;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class UploadCSVService {

    TournamentService tournamentService;
    GameService gameService;
    PlayerService playerService;

    public UploadCSVService(TournamentService tournamentService, GameService gameService, PlayerService playerService) {
        this.tournamentService = tournamentService;
        this.gameService = gameService;
        this.playerService = playerService;
    }

    public List<TournamentFromCSV> UploadPlayersToCSV(MultipartFile file) {
        List<TournamentFromCSV> list = new ArrayList<>();
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<TournamentFromCSV> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(TournamentFromCSV.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();
            list = csvToBean.parse();
            return list;
            // create csv bean reader

        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;

    }

    public Tournament CreateTournamentFromCSV(String name, String gamename , TournamentCategoryEnum tournamentType , List<TournamentParticipant> participants, String country, Date eventDate){
        Tournament tournament = new Tournament(name,tournamentType,gameService.getGameByName(gamename),participants , country, eventDate);

        participants.forEach(tournamentPlayer -> {
            int pointsContainer = 0;
            tournamentPlayer.setTournament(tournament);

            if(playerService.ifExists(tournamentPlayer.getPlayer().getName())){
                int offlinePointsContainer = tournamentPlayer.getPoints();
                tournamentPlayer.setPlayer(playerService.getByName(tournamentPlayer.getPlayer().getName()).orElseThrow());
            }

            if(tournamentType == TournamentCategoryEnum.Offline){
                tournamentPlayer.getPlayer().setOfflinePoints(tournamentPlayer.getPoints()+pointsContainer);

            }
            else {
                tournamentPlayer.getPlayer().setOnlinePoints(tournamentPlayer.getPoints()+pointsContainer);
            }


        });
        tournament.setParticipants(participants);
        tournamentService.save(tournament);
        return tournament;

    }
}

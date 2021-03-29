package pl.skiba.tekkenrankings.polskipunish.services;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.MyModelMapper;
import pl.skiba.tekkenrankings.polskipunish.models.CSVTournamentDTO;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.tournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
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

    public List<CSVTournamentDTO> UploadPlayersToCSV(MultipartFile file) {
        List<CSVTournamentDTO> list = new ArrayList<>();
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            CsvToBean<CSVTournamentDTO> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVTournamentDTO.class)
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

    public Tournament CreateTournamentFromCSV(String name, String gamename , tournamentCategoryEnum tournamentType , List<TournamentParticipant> participants){
        Tournament tournament = new Tournament(name,tournamentType,gameService.getGameByName(gamename),participants);

        participants.forEach(tournamentPlayer -> {
            int pointsContainer = 0;
            tournamentPlayer.setTournament(tournament);

            if(playerService.ifExists(tournamentPlayer.getPlayer().getName())){
                int offlinePointsContainer = tournamentPlayer.getPoints();
                tournamentPlayer.setPlayer(playerService.getByName(tournamentPlayer.getPlayer().getName()));
            }

            if(tournamentType == tournamentCategoryEnum.Offline){
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

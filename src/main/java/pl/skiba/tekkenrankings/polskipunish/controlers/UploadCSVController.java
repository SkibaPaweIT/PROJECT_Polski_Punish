package pl.skiba.tekkenrankings.polskipunish.controlers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.models.*;
import pl.skiba.tekkenrankings.polskipunish.repo.TournamentRepo;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;
import pl.skiba.tekkenrankings.polskipunish.services.PlayerService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UploadCSVController {

    TournamentService tournamentService;
    GameService gameService;
    PlayerService playerService;

    public UploadCSVController(TournamentService tournamentService, GameService gameService, PlayerService playerService) {
        this.tournamentService = tournamentService;
        this.gameService = gameService;
        this.playerService = playerService;
    }

    @GetMapping("/csv")
    public String csvFileUpload(Model model){
        return "csv-file-upload";
    }

    @PostMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("gamename") String gamename ,
                                @RequestParam("tournamentType") tournamentCategoryEnum tournamentType,
                                Model model){

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<CSVTournamentDTO> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CSVTournamentDTO.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            List<CSVTournamentDTO> tournamentPlayers = csvToBean.parse();
            List<TournamentParticipant> participants = new ArrayList<>();
            tournamentPlayers.forEach(tournamentPlayer -> {
                if(playerService.ifExists(tournamentPlayer.getPlayer())){
                    Player selectedPlayer = playerService.getByName(tournamentPlayer.getPlayer());
                    participants.add(new TournamentParticipant(
                            tournamentPlayer.getPlacement(),
                            selectedPlayer,
                            tournamentPlayer.getPoints()));

                    if(tournamentType == tournamentCategoryEnum.Offline){
                        selectedPlayer.setOfflinePoints(tournamentPlayer.getPoints()+selectedPlayer.getOfflinePoints());
                        playerService.save(selectedPlayer);
                    }
                    else
                    {
                        selectedPlayer.setOnlinePoints(tournamentPlayer.getPoints()+selectedPlayer.getOnlinePoints());
                        playerService.save(selectedPlayer);
                    }
                }
                else{
                        Player newPlayer = new Player(tournamentPlayer.getPlayer());
                    if(tournamentType == tournamentCategoryEnum.Offline){
                        newPlayer.setOfflinePoints(tournamentPlayer.getPoints()+newPlayer.getOfflinePoints());
                        playerService.save(newPlayer);
                        participants.add(new TournamentParticipant(
                                tournamentPlayer.getPlacement(),
                                newPlayer,
                                tournamentPlayer.getPoints()));
                    }
                    else
                    {
                        newPlayer.setOnlinePoints(tournamentPlayer.getPoints()+newPlayer.getOnlinePoints());
                        playerService.save(newPlayer);
                    }
                }

            });
            Tournament tournament = new Tournament(name,tournamentType,gameService.getGameByName(gamename),participants);
            tournamentService.save(tournament);



            model.addAttribute("players", tournamentPlayers);
            model.addAttribute("status", true);

        } catch (Exception ex) {
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }

        return "csv-file-upload";
    }

}

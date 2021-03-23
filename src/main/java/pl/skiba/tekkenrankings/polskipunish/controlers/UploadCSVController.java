package pl.skiba.tekkenrankings.polskipunish.controlers;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.tournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.repo.TournamentRepo;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Controller
public class UploadCSVController {

    TournamentService tournamentService;
    GameService gameService;

    public UploadCSVController(TournamentService tournamentService, GameService gameService) {
        this.tournamentService = tournamentService;
        this.gameService = gameService;
    }

    @GetMapping("/csv")
    public String csvFileUpload(Model model){
        return "csv-file-upload";
    }

    @PostMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("gamename") String gamename ,
                                Model model){

        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {

            // create csv bean reader
            CsvToBean<TournamentParticipant> csvToBean = new CsvToBeanBuilder(reader)
                    .withType(TournamentParticipant.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            // convert `CsvToBean` object to list of users
            List<TournamentParticipant> users = csvToBean.parse();
            Tournament tournament = new Tournament(name,tournamentCategoryEnum.Offline,gameService.getGameByName(gamename),users);
            tournamentService.save(tournament);



            model.addAttribute("users", users);
            model.addAttribute("status", true);

        } catch (Exception ex) {
            model.addAttribute("message", "An error occurred while processing the CSV file.");
            model.addAttribute("status", false);
        }

        return "csv-file-upload";
    }

}

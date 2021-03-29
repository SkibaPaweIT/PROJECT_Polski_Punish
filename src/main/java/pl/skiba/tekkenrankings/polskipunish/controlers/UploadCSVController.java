package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.modelmapper.TypeToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.MyModelMapper;
import pl.skiba.tekkenrankings.polskipunish.models.CSVTournamentDTO;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.tournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.UploadCSVService;

import java.util.List;

@Controller
public class UploadCSVController {

    UploadCSVService uploadCSVService;

    public UploadCSVController(UploadCSVService uploadCSVService) {
        this.uploadCSVService = uploadCSVService;
    }

    @GetMapping("/csv")
    public String csvFileUpload(Model model){
        return "csv-file-upload";
    }

    @GetMapping("/upload-csv")
    public String uploadCSVFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("gamename") String gamename ,
                                @RequestParam("tournamentType") tournamentCategoryEnum tournamentType){


            MyModelMapper myModelMapper = new MyModelMapper();
            List<CSVTournamentDTO> tournamentPlayers = uploadCSVService.UploadPlayersToCSV(file);
            List<TournamentParticipant> participants = myModelMapper.modelMapper.map(tournamentPlayers , new TypeToken<List<TournamentParticipant>>() {}.getType());
            Tournament tournament = uploadCSVService.CreateTournamentFromCSV(name,gamename,tournamentType,participants);

        return "csv-file-upload";
    }

}

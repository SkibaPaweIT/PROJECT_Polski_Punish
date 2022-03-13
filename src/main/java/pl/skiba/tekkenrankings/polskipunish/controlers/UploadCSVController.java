package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.TournamentFromCSV;
import pl.skiba.tekkenrankings.polskipunish.services.UploadCSVService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/admin")
public class UploadCSVController {

    UploadCSVService uploadCSVService;

    public UploadCSVController(UploadCSVService uploadCSVService) {
        this.uploadCSVService = uploadCSVService;
    }

    @GetMapping("/csv")
    public String csvFileUpload() {
        return "csv-file-upload";
    }

    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCSVFile(@RequestParam("file") MultipartFile file,
                                @RequestParam("name") String name,
                                @RequestParam("gamename") String gamename,
                                @RequestParam("tournamentType") TournamentCategoryEnum tournamentType,
                                @RequestParam("country") String country,
                                @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date eventDate) {


        List<TournamentFromCSV> tournamentPlayers = uploadCSVService.UploadPlayersToCSV(file);
        List<TournamentParticipant> participants = SimpleMapper.INSTANCE.toTournamentParticipantsListFromCSV(tournamentPlayers);
        Tournament tournament = uploadCSVService.CreateTournamentFromCSV(name, gamename, tournamentType, participants, country, eventDate);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

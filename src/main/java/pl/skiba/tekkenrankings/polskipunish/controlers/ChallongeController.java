package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.MyModelMapper;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.tournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.ChallongeService;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;

import java.io.IOException;
import java.util.List;


@Controller
public class ChallongeController {


    private ChallongeService challongeService;

    public ChallongeController(ChallongeService challongeService) {
        this.challongeService = challongeService;
    }

    @Value("${challonge_api_key}")
    private String challonge_api_key;

    @GetMapping("/challonge")
    public String csvFileUpload(Model model){
        return "challonge-upload";
    }

    @GetMapping("/api/challonge/tournament")
    public String getTournamentFromChallonge(@RequestParam String tournamentName,
                                                                 @RequestParam tournamentCategoryEnum tournamentType ,
                                                                 @RequestParam String gamename) throws IOException {
        MyModelMapper myModelMapper = new MyModelMapper();
        String url= "https://api.challonge.com/v1/tournaments/" + tournamentName + "/participants.json?api_key=" + challonge_api_key;
        List<ChallongeParticipant> participantList = challongeService.makeChallongeParticipantsList(url);
        List<TournamentParticipant> participants = myModelMapper.modelMapper.map(participantList,  new TypeToken<List<TournamentParticipant>>() {}.getType());
        Tournament tournament = challongeService.getTourmanetFromChallonge(participants , tournamentType, tournamentName , gamename);

        return "challonge-upload";
    }
}
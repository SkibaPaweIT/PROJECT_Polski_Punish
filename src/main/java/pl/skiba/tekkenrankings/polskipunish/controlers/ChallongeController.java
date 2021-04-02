package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.MyModelMapper;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.ChallongeService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.IOException;
import java.util.List;


@Controller
public class ChallongeController {


    private ChallongeService challongeService;
    private TournamentService tournamentService;

    public ChallongeController(ChallongeService challongeService, TournamentService tournamentService) {
        this.challongeService = challongeService;
        this.tournamentService = tournamentService;
    }

    @Value("${challonge_api_key}")
    private String challonge_api_key;

    @GetMapping("/api/challonge")
    public String challongeUpload(Model model){
        return "challonge-upload";
    }

    @GetMapping("/api/challonge/tournament")
    public String getTournamentFromChallonge(@RequestParam String tournamentName,
                                                                 @RequestParam TournamentCategoryEnum tournamentType ,
                                                                 @RequestParam String gamename) throws IOException {
        MyModelMapper myModelMapper = new MyModelMapper();
        String url= "https://api.challonge.com/v1/tournaments/" + tournamentName + "/participants.json?api_key=" + challonge_api_key;
        List<ChallongeParticipant> participantList = challongeService.makeChallongeParticipantsList(url);
        List<TournamentParticipant> participants = myModelMapper.modelMapper.map(participantList,  new TypeToken<List<TournamentParticipant>>() {}.getType());
        Tournament tournament= challongeService.getTourmanetFromParticipantList(participants , tournamentType, tournamentName , gamename);
        tournamentService.save(tournament);

        return "challonge-upload";
    }
}
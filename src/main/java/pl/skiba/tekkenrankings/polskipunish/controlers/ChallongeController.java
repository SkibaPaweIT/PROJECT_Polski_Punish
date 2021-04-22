package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.ChallongeService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.IOException;
import java.util.List;


@Controller
@RequestMapping("/api/admin")
public class ChallongeController {


    private ChallongeService challongeService;
    private TournamentService tournamentService;

    public ChallongeController(ChallongeService challongeService, TournamentService tournamentService) {
        this.challongeService = challongeService;
        this.tournamentService = tournamentService;
    }

    @Value("${challonge_api_key}")
    private String challonge_api_key;

    @GetMapping("/challonge")
    public String challongeUpload(){
        return "challonge-upload";
    }

    @GetMapping("/challonge/tournament")
    public String getTournamentFromChallonge(@RequestParam String tournamentName,
                                                                 @RequestParam TournamentCategoryEnum tournamentType ,
                                                                 @RequestParam String gamename) throws IOException {
        String url= "https://api.challonge.com/v1/tournaments/" + tournamentName + "/participants.json?api_key=" + challonge_api_key;
        List<ChallongeParticipant> participantList = challongeService.makeChallongeParticipantsList(url);
        List<TournamentParticipant> participants = SimpleMapper.INSTANCE.toTournamentParticipantsList(participantList);
        Tournament tournament= challongeService.getTourmanetFromParticipantList(participants , tournamentType, tournamentName , gamename);
        tournamentService.save(tournament);

        return "challonge-upload";
    }
}
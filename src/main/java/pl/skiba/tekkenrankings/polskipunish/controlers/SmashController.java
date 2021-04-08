package pl.skiba.tekkenrankings.polskipunish.controlers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.services.SmashService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.IOException;

@Controller
@RequestMapping("/api/admin")
public class SmashController {


    private SmashService smashService;
    private TournamentService tournamentService;

    public SmashController(SmashService smashService, TournamentService tournamentService) {
        this.smashService = smashService;
        this.tournamentService = tournamentService;
    }

    @GetMapping("/smash")
    public String SmashUpload(Model model){
        return "smash-upload";
    }

    @GetMapping("/smash/tournament")
    public String GetSmashTournament(@RequestParam String tournamentName,
                           @RequestParam TournamentCategoryEnum tournamentType ,
                           @RequestParam String gamename) throws IOException {

        //icfc-eu-season-1-week-5
        String slug= "{\"slug\":\""+tournamentName+"\"}";
        String query="query TournamentQuery($slug: String){tournament(slug: $slug){name,events{name standings(query: {}) {nodes {placement entrant {name}}}}}}";

        JsonNode root = smashService.getSmashTournamentFromHttpRequest(slug,query);
        Tournament tournament= smashService.getTournament(root ,tournamentName, tournamentType, gamename );

        tournamentService.save(tournament);

        return "smash-upload";
    }
}

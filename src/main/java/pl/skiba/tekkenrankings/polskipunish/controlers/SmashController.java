package pl.skiba.tekkenrankings.polskipunish.controlers;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.services.SmashService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.IOException;
import java.util.Date;

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
    public String SmashUpload() {
        return "smash-upload";
    }

    @GetMapping("/smash/tournament")
    public String GetSmashTournament(@RequestParam String tournamentName,
                                     @RequestParam TournamentCategoryEnum tournamentType,
                                     @RequestParam String gamename,
                                     @RequestParam String country,
                                     @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date eventDate) throws IOException {

        //icfc-eu-season-1-week-5
        String slug = "{\"slug\":\"" + tournamentName + "\"}";
        String query = "query TournamentQuery($slug: String){tournament(slug: $slug){name,events{name standings(query: {}) {nodes {placement entrant {name}}}}}}";

        JsonNode root = smashService.getSmashTournamentFromHttpRequest(slug, query);
        Tournament tournament = smashService.getTournament(root, tournamentName, tournamentType, gamename, country, eventDate);

        tournamentService.save(tournament);

        return "smash-upload";
    }
}

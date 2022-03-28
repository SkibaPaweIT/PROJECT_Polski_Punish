package pl.skiba.tekkenrankings.polskipunish.controlers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongePlayerMatch;
import pl.skiba.tekkenrankings.polskipunish.services.ChallongeService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import java.io.IOException;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("/api/admin")
@RequiredArgsConstructor
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
    public String challongeUpload() {
        return "challonge-upload";
    }

    @GetMapping("/challonge/tournament")
    public ResponseEntity<String> getTournamentFromChallonge(@RequestParam String tournamentName,
                                                     @RequestParam TournamentCategoryEnum tournamentType,
                                                     @RequestParam String gamename,
                                                     @RequestParam String country,
                                                     @RequestParam @DateTimeFormat(pattern="MM/dd/yyyy") Date eventDate) throws IOException {
        String url = "https://api.challonge.com/v1/tournaments/" + tournamentName + "/participants.json?api_key=" + challonge_api_key;
        List<ChallongeParticipant> participantList = challongeService.makeChallongeParticipantsList(url);
        List<TournamentParticipant> participants = SimpleMapper.INSTANCE.toTournamentParticipantsList(participantList);
        Tournament tournament = challongeService.getTourmanetFromParticipantList(participants, tournamentType, tournamentName, gamename, country, eventDate);
        tournamentService.save(tournament);

        String matchesUrl = "https://api.challonge.com/v1/tournaments/" + tournamentName + "/matches.json?api_key=" + challonge_api_key + "&tournament=" + tournamentName;
        List<ChallongePlayerMatch> allMatches = challongeService.makeChallongeMatchesList(matchesUrl);
        challongeService.saveChallongeMatches(allMatches , tournament);

        return new ResponseEntity<>(HttpStatus.OK);
    }





}
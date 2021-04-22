package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentParticipantService;

@RestController
@RequestMapping("/api/participants")
public class TournamentParticipantController {

    private TournamentParticipantService tournamentParticipantService;

    public TournamentParticipantController(TournamentParticipantService tournamentParticipantService) {
        this.tournamentParticipantService = tournamentParticipantService;
    }

    @GetMapping
    public Iterable<String> getPlayerTournaments(@RequestParam String name) {
        return tournamentParticipantService.getPlayerTournamnets(name);
    }

    @GetMapping("participant")
    public ChallongeParticipant getParticipant(@RequestParam Long id){
        TournamentParticipant tournamentParticipant =  tournamentParticipantService.findByPlace(id).orElseThrow();
        return SimpleMapper.INSTANCE.toChallongeParticipant(tournamentParticipant);
    }

}

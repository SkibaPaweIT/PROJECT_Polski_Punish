package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentParticipantService;

import java.util.List;

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

    @GetMapping("all")
    public Iterable<TournamentParticipant> getParticipant(){
        Iterable<TournamentParticipant> tournamentParticipant =  tournamentParticipantService.findALl();
        Iterable<ChallongeParticipant> challongeParticipants =  SimpleMapper.INSTANCE.toChallongeParticipants(tournamentParticipant);
        return SimpleMapper.INSTANCE.toTournamentParticipants(challongeParticipants);
    }


}

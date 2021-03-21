package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentParticipantService;

@RestController
@RequestMapping("/api/players")
public class TournamentParticipantController {

    private TournamentParticipantService tournamentParticipantService;

    public TournamentParticipantController(TournamentParticipantService tournamentParticipantService) {
        this.tournamentParticipantService = tournamentParticipantService;
    }

    @GetMapping("/all")
    public Iterable<TournamentParticipant> getAll() {
        return tournamentParticipantService.findALl();
    }
}

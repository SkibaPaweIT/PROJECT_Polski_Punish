package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.PlayerTournaments;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels.ChallongeParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentParticipantService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class TournamentParticipantController {

    private TournamentParticipantService tournamentParticipantService;

    public TournamentParticipantController(TournamentParticipantService tournamentParticipantService) {
        this.tournamentParticipantService = tournamentParticipantService;
    }

    @GetMapping("participantTournaments")
    public Iterable<PlayerTournaments> getPlayerTournaments(@RequestParam String name) {
        return tournamentParticipantService.getPlayerTournamnets(name);
    }

    @GetMapping
    public List<ChallongeParticipant> getAllParticipants(){
        List<ChallongeParticipant> list = new ArrayList<>();
        tournamentParticipantService.findALl().forEach(element -> list.add(SimpleMapper.INSTANCE.toChallongeParticipant(element)));
        return list;
    }

    @GetMapping("participant")
    public ChallongeParticipant getParticipant(@RequestParam Long id){
        TournamentParticipant tournamentParticipant =  tournamentParticipantService.findByPlace(id).orElseThrow();
        return SimpleMapper.INSTANCE.toChallongeParticipant(tournamentParticipant);
    }

}

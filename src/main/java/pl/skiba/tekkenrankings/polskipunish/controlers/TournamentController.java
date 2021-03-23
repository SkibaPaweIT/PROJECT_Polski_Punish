package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    private TournamentService tournamentService;
    private GameService gameService;

    public TournamentController(TournamentService tournamentService, GameService gameService) {
        this.tournamentService = tournamentService;
        this.gameService = gameService;
    }

    @GetMapping("/all")
    public Iterable<Tournament> getAll(){
        return tournamentService.findAll();
    }

    @GetMapping("/all/name")
    public Iterable<String> getAllTourmanetNames(){
        return tournamentService.findAllNames();
    }

    @GetMapping("/game-tournaments")
    public Iterable<String> getAllTourmanetNamesFromGame(@RequestParam String gamename){
        return tournamentService.findAllTournamentsToGame(gamename);
    }


    @PostMapping()
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.save(tournament);

    }

}

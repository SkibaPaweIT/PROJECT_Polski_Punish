package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.skiba.tekkenrankings.polskipunish.exceptions.TournamentNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.TournamentNames;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    private TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping(value="/{id}")
    public Tournament findById(@PathVariable("id") Long id , HttpServletResponse response){
            return tournamentService.findById(id).orElseThrow(()->new TournamentNotFoundException(id) );
    }


    @GetMapping("/all")
    public Iterable<Tournament> getAll(){
        return tournamentService.findAll();
    }

    @GetMapping("/all/name")
    public Iterable<TournamentNames> getAllTourmanetNames(){
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

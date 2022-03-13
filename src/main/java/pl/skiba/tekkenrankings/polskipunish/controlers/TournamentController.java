package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.TournamentNames;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentDTO;
import pl.skiba.tekkenrankings.polskipunish.services.TournamentService;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/api/tournament")
public class TournamentController {

    private TournamentService tournamentService;

    public TournamentController(TournamentService tournamentService) {
        this.tournamentService = tournamentService;
    }

    @GetMapping(value="/{id}")
    public Tournament findById(@PathVariable("id") Long id , HttpServletResponse response){
            return tournamentService.findById(id).orElseThrow(()->new EntityNotFoundException("Tournament "+id+" not Found") );
    }


    @GetMapping("/all")
    public Iterable<TournamentDTO> getAll(){

        Iterable<TournamentDTO> result = SimpleMapper.INSTANCE.TournamentListToDto(tournamentService.findAll());
        if(((Collection<TournamentDTO>) result).size()== 0){
            throw new EntityNotFoundException("Tournaments not found");
        }
        else return result;
    }

    @GetMapping("/all/name")
    public Iterable<TournamentNames> getAllTourmanetNames(){
        return tournamentService.findAllNames();
    }

    @GetMapping("/game-tournaments")
    public Iterable<String> getAllTourmanetNamesFromGame(@RequestParam String gamename){
        return tournamentService.findAllTournamentsToGame(gamename);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteByTournamentid(@RequestParam Long id){
        tournamentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping()
    public Tournament addTournament(@RequestBody Tournament tournament){
        return tournamentService.save(tournament);

    }

}

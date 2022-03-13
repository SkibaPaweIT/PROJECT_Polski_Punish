package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.GameDTO;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;

@RestController
@RequestMapping("/api/games")
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public Iterable<GameDTO> getAllGames() {
        return gameService.getAll();
    }

    @GetMapping("/game")
    public GameDTO getByGameName(@RequestParam String gameName) {
        return gameService.getGameDTOByName(gameName);
    }

    @GetMapping("/game/delete/{id}")
    public ResponseEntity<String> DeleteByGameId(@PathVariable("id") Long gameId) {
        gameService.deleteByGameId(gameId);
        return new ResponseEntity<>(HttpStatus.OK);
    }



}

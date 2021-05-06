package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Game;
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
    public Iterable<GameDTO> getAllGames(){
        return gameService.getAll();
    }

    @GetMapping("/game")
    public GameDTO getByGameName(@RequestParam String gameName) { return gameService.getGameDTOByName(gameName); }

}

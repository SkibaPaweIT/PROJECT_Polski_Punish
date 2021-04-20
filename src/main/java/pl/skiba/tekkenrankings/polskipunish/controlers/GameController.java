package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.GameDTO;
import pl.skiba.tekkenrankings.polskipunish.services.GameService;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameController {

    GameService gameService;

    @Autowired
    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping()
    public List<GameDTO> getAllGames(){
        return this.gameService.getAll();
    }

}

package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.services.PlayerService;

import java.util.List;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/offline-ranking")
    public List<String> getOfflineRanking(){
        return playerService.getOfflineRanking();
    }

    @GetMapping("/online-ranking")
    public List<String> getOnlineRanking(){
        return playerService.getOnlineRanking();
    }
}

package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
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
    public Iterable<OfflineRanking> getOfflineRanking(){
        return playerService.getOfflineRanking();
    }

    @GetMapping("/online-ranking")
    public Iterable<OnlineRanking> getOnlineRanking(){
        return playerService.getOnlineRanking();
    }

    @GetMapping("/all")
    public Iterable<Player> getAll() {
        return playerService.findAll();
    }
}

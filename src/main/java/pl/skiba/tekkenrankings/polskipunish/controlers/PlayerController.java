package pl.skiba.tekkenrankings.polskipunish.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.skiba.tekkenrankings.polskipunish.exceptions.PlayerNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO;
import pl.skiba.tekkenrankings.polskipunish.services.PlayerService;

import javax.servlet.http.HttpServletResponse;

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
    public Iterable<PlayerDTO> getAll() {
        return playerService.findAll();
    }

    @GetMapping(value="/{id}")
    public PlayerDTO findById(@PathVariable("id") Long id){
        return SimpleMapper.INSTANCE.PlayerToDTO(playerService.getById(id));
    }
}

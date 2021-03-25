package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Game;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.repo.GameRepo;

import java.util.ArrayList;
import java.util.List;

@Service
public class GameService {

    GameRepo gameRepo;

    public GameService(GameRepo gameRepo) {
        this.gameRepo = gameRepo;
    }

    public Game getGameByName(String gameName) {
        return gameRepo.findByGameName(gameName).orElse(null);
    }

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDB() {
//        List<Tournament> list = new ArrayList<Tournament>();
//        gameRepo.save(new Game("Tekken 7", list));
//        gameRepo.save(new Game("Soul Calibur 6", list));
//        gameRepo.save(new Game("Street Fighter 5", list));//   }
//    }
}

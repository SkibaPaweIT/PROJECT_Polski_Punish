package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.exceptions.GameNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Game;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.GameDTO;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
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
        return gameRepo.findByGameName(gameName).orElseThrow(() -> new GameNotFoundException(gameName));
    }

    public GameDTO getGameDTOByName(String gameName) {
        Game game= gameRepo.findByGameName(gameName).orElseThrow(() -> new GameNotFoundException(gameName));
        return SimpleMapper.INSTANCE.GameToDTO(game);
    }

    public Iterable<GameDTO> getAll(){
        return SimpleMapper.INSTANCE.GameListToDTO(gameRepo.findAll());
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {
        List<Tournament> list = new ArrayList<>();
        gameRepo.save(new Game("Tekken 7", list));
        gameRepo.save(new Game("Soul Calibur 6", list));
        gameRepo.save(new Game("Street Fighter 5", list));
    }
}

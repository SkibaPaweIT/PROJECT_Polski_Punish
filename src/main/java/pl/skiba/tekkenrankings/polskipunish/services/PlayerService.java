package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.repo.PlayerRepo;

@Service
public class PlayerService {

    PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public boolean ifExists(String name){
        return playerRepo.existsByName(name);
    }

    public Player getByName(String name){
        return playerRepo.getByName(name);
    }

    public Player save(Player player){
        return playerRepo.save(player);
    }
}

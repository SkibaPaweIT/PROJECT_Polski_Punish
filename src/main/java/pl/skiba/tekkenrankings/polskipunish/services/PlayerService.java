package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.repo.PlayerRepo;

import java.util.List;

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

    public Iterable<OfflineRanking> getOfflineRanking(){
        return playerRepo.findAllProjectedBy(Sort.by(Sort.Direction.DESC,"offlinePoints"));
    }

    public Iterable<Player> findAll(){
        return playerRepo.findAll();
    }

    public Iterable<OnlineRanking> getOnlineRanking(){
        return playerRepo.findAllBy(Sort.by(Sort.Direction.DESC,"onlinePoints"));
    }
}

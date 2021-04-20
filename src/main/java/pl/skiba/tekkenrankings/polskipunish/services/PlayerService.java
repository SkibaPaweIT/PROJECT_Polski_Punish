package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Player;
import pl.skiba.tekkenrankings.polskipunish.models.PlayerDTO;
import pl.skiba.tekkenrankings.polskipunish.repo.PlayerRepo;

import java.util.Optional;

@Service
public class PlayerService {

    PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public boolean ifExists(String name){
        return playerRepo.existsByName(name);
    }

    public Optional<Player> getByName(String name){
        return playerRepo.getByName(name);
    }

    public Optional<Player> getById(Long id){
        return playerRepo.getById(id);
    }

    public Player save(Player player){
        return playerRepo.save(player);
    }

    public Iterable<OfflineRanking> getOfflineRanking(){
        return playerRepo.findAllProjectedBy(Sort.by(Sort.Direction.DESC,"offlinePoints"));
    }

    public Iterable<PlayerDTO> findAll(){
        return SimpleMapper.INSTANCE.PlayerListToListDTO(playerRepo.findAll());
    }

    public Iterable<OnlineRanking> getOnlineRanking(){
        return playerRepo.findAllBy(Sort.by(Sort.Direction.DESC,"onlinePoints"));
    }
}

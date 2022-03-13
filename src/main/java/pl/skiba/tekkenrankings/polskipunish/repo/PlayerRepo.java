package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Player;

import java.util.Optional;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

    boolean existsByName(String name);

    Optional<Player> getByName(String name);

    Optional<Player> getById(Long id);

    //@Query("Select p.name, p.offlinePoints from Player p order by p.offlinePoints desc")


    Iterable<OfflineRanking>findAllProjectedBy(Sort sort);

    Iterable<OnlineRanking>findAllBy(Sort sort);



    //@Query("Select p.name, p.onlinePoints from Player p order by p.onlinePoints desc")
    //List<String> findAllOnline();

}

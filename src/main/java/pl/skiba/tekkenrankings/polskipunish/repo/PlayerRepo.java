package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Player;

import java.util.List;


@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

    boolean existsByName(String name);

    Player getByName(String name);

    @Query("Select p.name, p.offlinePoints from Player p order by p.offlinePoints desc")
    List<String> findAllOffline();

    @Query("Select p.name, p.onlinePoints from Player p order by p.onlinePoints desc")
    List<String> findAllOnline();

}

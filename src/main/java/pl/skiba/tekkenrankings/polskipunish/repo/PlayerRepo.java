package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Player;

@Repository
public interface PlayerRepo extends JpaRepository<Player,Long> {

    boolean existsByName(String name);

    Player getByName(String name);
}

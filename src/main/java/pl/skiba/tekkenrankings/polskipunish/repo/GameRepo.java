package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Game;

import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

        Optional<Game> findByGameName(String gameName);

}

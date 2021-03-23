package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Game;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;

import java.util.Optional;

@Repository
public interface GameRepo extends JpaRepository<Game, Long> {

        Optional<Game> findByGameName(String gameName);

}

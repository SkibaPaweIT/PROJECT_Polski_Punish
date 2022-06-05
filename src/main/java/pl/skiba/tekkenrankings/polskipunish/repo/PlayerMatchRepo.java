package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerMatch;

import java.util.List;

public interface PlayerMatchRepo extends JpaRepository<PlayerMatch, Long> {

    List<PlayerMatch> findAllByPlayer1(Long id);

}

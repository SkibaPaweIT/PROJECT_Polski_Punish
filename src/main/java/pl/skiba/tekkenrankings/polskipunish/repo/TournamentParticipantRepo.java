package pl.skiba.tekkenrankings.polskipunish.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

import java.util.Optional;

@Repository
public interface TournamentParticipantRepo extends JpaRepository<TournamentParticipant , Long> {

    Optional<TournamentParticipant> findTournamentParticipantByPlayer(String name);
}

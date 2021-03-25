package pl.skiba.tekkenrankings.polskipunish.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;

import java.util.Optional;

@Repository
public interface TournamentParticipantRepo extends JpaRepository<TournamentParticipant , Long> {

    Optional<TournamentParticipant> findTournamentParticipantByPlayer(String name);

    @Query("select t.tournamentName, tp.placement , tp.points from TournamentParticipant tp join tp.tournament t join tp.player p where p.name=:name")
    Iterable<String> findAllPlayerTournamentsByPlayerName(@Param("name") String name);
}

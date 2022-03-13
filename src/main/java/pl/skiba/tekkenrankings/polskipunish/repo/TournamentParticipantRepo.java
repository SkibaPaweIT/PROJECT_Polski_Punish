package pl.skiba.tekkenrankings.polskipunish.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.PlayerTournaments;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Player;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;

import java.util.Optional;

@Repository
public interface TournamentParticipantRepo extends JpaRepository<TournamentParticipant , Long> {

    Optional<TournamentParticipant> findTournamentParticipantByPlayer(String name);

    @Query(value = "select tour.TOURNAMENT_NAME as tournamentName, tp.PLACEMENT , tp.POINTS from TOURNAMENT_PARTICIPANT tp " +
            "join TOURNAMENT tour on tp.TOURNAMENT_ID = tour.ID " +
            "join PLAYER p on tp.PLAYER_ID = p.ID " +
            "where p.NAME = :name" , nativeQuery = true)
    Iterable<PlayerTournaments> findAllPlayerTournamentsByPlayerName(@Param("name") String name);
}
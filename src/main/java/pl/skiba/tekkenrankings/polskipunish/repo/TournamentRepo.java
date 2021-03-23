package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Game;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;



@Repository
public interface TournamentRepo extends JpaRepository<Tournament , Long> {


    @Query(value = "Select tournamentName from Tournament")
    public Iterable<String> findAllNames();

    @Query("select t.tournamentName from Tournament t join t.game g where g.gameName= :gameName")
    Iterable<String> findTournamentByGame_GameName(@Param("gameName") String gameName);

//    @Query("select t.tournamentName from Tournament t where t.game = :game")
//    Iterable<String> findTournamentNameByGame(@Param("game")Game game);



}

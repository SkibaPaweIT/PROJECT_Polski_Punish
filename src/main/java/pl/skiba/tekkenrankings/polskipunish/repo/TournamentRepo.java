package pl.skiba.tekkenrankings.polskipunish.repo;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;

import java.util.List;


@Repository
public interface TournamentRepo extends JpaRepository<Tournament , Long> {

    @Query(value = "Select tournamentName from Tournament")
    public Iterable<String> findAllNames();


}

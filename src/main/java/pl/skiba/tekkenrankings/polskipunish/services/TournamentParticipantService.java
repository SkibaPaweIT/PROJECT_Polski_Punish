package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.repo.TournamentParticipantRepo;

import java.util.Optional;

@Service
public class TournamentParticipantService {

    private TournamentParticipantRepo tournamentParticipantRepo;

    @Autowired
    public TournamentParticipantService(TournamentParticipantRepo tournamentParticipantRepo) {
        this.tournamentParticipantRepo = tournamentParticipantRepo;
    }

    public Iterable<TournamentParticipant> findALl(){
        return tournamentParticipantRepo.findAll();
    }

    public Optional<TournamentParticipant> findByPlace(long id){
        return tournamentParticipantRepo.findById(id);
    }

    public Optional<TournamentParticipant> findByName (String name){
        return tournamentParticipantRepo.findTournamentParticipantByPlayer(name);
    }

}

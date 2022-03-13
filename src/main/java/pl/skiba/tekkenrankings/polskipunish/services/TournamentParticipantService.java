package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.PlayerTournaments;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.TournamentParticipant;
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

    public Optional<TournamentParticipant> findByPlace(long placement){
        return tournamentParticipantRepo.findById(placement);
    }

    public Optional<TournamentParticipant> findByName (String name){
        return tournamentParticipantRepo.findTournamentParticipantByPlayer(name);
    }

    public Iterable<PlayerTournaments> getPlayerTournamnets (String name){
        return tournamentParticipantRepo.findAllPlayerTournamentsByPlayerName(name);
    }

}

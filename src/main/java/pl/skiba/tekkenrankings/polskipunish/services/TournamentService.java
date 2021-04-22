package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.TournamentNames;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Tournament;
import pl.skiba.tekkenrankings.polskipunish.repo.TournamentRepo;

import java.util.List;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepo tournamentRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    public List<Tournament> findAll() {
        return tournamentRepo.findAll();
    }

    public Iterable<TournamentNames> findAllNames() {
        return tournamentRepo.findAllBy();
    }

    public Iterable<String> findAllTournamentsToGame(String gameName){
        return tournamentRepo.findTournamentByGame_GameName(gameName);
    }

    public Optional<Tournament> findById(Long id) {
        return tournamentRepo.findById(id);
    }

    public Tournament save(Tournament tournament) {
        return tournamentRepo.save(tournament);
    }

    public void deleteById(Long id) {
        tournamentRepo.deleteById(id);
    }

}
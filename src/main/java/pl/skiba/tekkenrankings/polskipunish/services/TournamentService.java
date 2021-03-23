package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.models.Game;
import pl.skiba.tekkenrankings.polskipunish.models.Tournament;
import pl.skiba.tekkenrankings.polskipunish.models.TournamentParticipant;
import pl.skiba.tekkenrankings.polskipunish.models.tournamentCategoryEnum;
import pl.skiba.tekkenrankings.polskipunish.repo.TournamentRepo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

@Service
public class TournamentService {

    private final TournamentRepo tournamentRepo;

    @Autowired
    public TournamentService(TournamentRepo tournamentRepo) {
        this.tournamentRepo = tournamentRepo;
    }

    public Iterable<Tournament> findAll() {
        return tournamentRepo.findAll();
    }

    public Iterable<String> findAllNames() {
        return tournamentRepo.findAllNames();
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

//    @EventListener(ApplicationReadyEvent.class)
//    public void fillDb() {
//        ArrayList<TournamentParticipant> list = new ArrayList<>();
//        list.add(new TournamentParticipant("1", "why", "200"));
//        list.add(new TournamentParticipant("2", "blau", "100"));
//        save(new Tournament("Pierwszy", tournamentCategoryEnum.Offline, list));
//        ArrayList<TournamentParticipant> list2 = new ArrayList<>();
//        list2.add(new TournamentParticipant("1", "Arek", "200"));
//        list2.add(new TournamentParticipant("2", "blau", "100"));
//        save(new Tournament("Drugi", tournamentCategoryEnum.Online, list2));
//    }
}
package pl.skiba.tekkenrankings.polskipunish.services;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import pl.skiba.tekkenrankings.polskipunish.exceptions.PlayerNotFoundException;
import pl.skiba.tekkenrankings.polskipunish.modelMappers.SimpleMapper;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OfflineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.Interfaces.OnlineRanking;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.DataAnalysisDTO;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.Player;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerDTO;
import pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels.PlayerMatch;
import pl.skiba.tekkenrankings.polskipunish.repo.PlayerRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PlayerService {

    PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }

    public boolean ifExists(String name) {
        return playerRepo.existsByName(name);
    }

    public Optional<Player> getByName(String name) {
        return playerRepo.getByName(name);
    }

    public Player getById(Long id) {
        return playerRepo.getById(id).orElseThrow(() -> new PlayerNotFoundException(id));
    }

    public void deleteById(Long id) {
        var player = playerRepo.getById(id).orElseThrow(() -> new PlayerNotFoundException(id));
        playerRepo.delete(player);
    }


    public Player save(Player player) {
        return playerRepo.save(player);
    }

    public Iterable<OfflineRanking> getOfflineRanking() {
        return playerRepo.findAllProjectedBy(Sort.by(Sort.Direction.DESC, "offlinePoints"));
    }

    public Iterable<PlayerDTO> findAll() {
        return SimpleMapper.INSTANCE.PlayerListToListDTO(playerRepo.findAll());
    }

    public Iterable<OnlineRanking> getOnlineRanking() {
        return playerRepo.findAllBy(Sort.by(Sort.Direction.DESC, "onlinePoints"));
    }

    public List<DataAnalysisDTO> prepareData() {
        List<DataAnalysisDTO> dataSet = new ArrayList<>();
        var players = playerRepo.findAll();

        players.forEach(player -> {
            var playerMatches = player.getPlayerMatches();
            playerMatches.forEach(playerMatch -> {
                DataAnalysisDTO dataRecord = new DataAnalysisDTO();
                dataRecord.setPlayer_nickname(player.getName());
                dataRecord.setPlayer_offfline_points(player.getOfflinePoints());
                dataRecord.setPlayer_online_points(player.getOnlinePoints());
                dataRecord.setResult(playerMatch.getWinner());
                dataRecord.setRounds(playerMatch.getRound());
                dataRecord.setPlayer_seed(playerMatch.getSeed().intValue());
                dataRecord.setPlayer_tournaments_winrate(player.getPlayerTournamentsWinrate());
                dataRecord.setPlayer_vs_opponent_winrate(player.getPlayerVsPlayerWinrate(playerMatch.getPlayer2()));
                dataRecord.setPlayer_number_of_all_matches_played(player.getNumberOfAllMatches());
                dataRecord.setPlayer_number_of_matches_played_in_torunament(player.getNumOfTournamentMatches(playerMatch.getTournament()));
                getOpponentData(dataRecord, playerMatch);

                dataSet.add(dataRecord);
            });
        });

        return dataSet;
    }

    public void getOpponentData(DataAnalysisDTO dataRecord, PlayerMatch playerMatch){
        var opponent = playerMatch.getPlayer2();
        dataRecord.setOpponent_nickname(opponent.getName());
        dataRecord.setOpponent_offline_points(opponent.getOfflinePoints());
        dataRecord.setOpponent_online_points(opponent.getOnlinePoints());
        dataRecord.setOpponent_tournaments_winrate(opponent.getPlayerTournamentsWinrate());
        dataRecord.setOpponent_number_of_all_matches_played(opponent.getNumberOfAllMatches());
        dataRecord.setOpponent_number_of_matches_played_in_torunament(opponent.getNumOfTournamentMatches(playerMatch.getTournament()));
    }

}

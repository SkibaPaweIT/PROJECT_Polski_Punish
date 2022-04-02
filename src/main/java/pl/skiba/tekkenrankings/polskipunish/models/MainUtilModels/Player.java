package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;


import javax.persistence.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    Long id;
    String name;
    int onlinePoints = 0;
    int offlinePoints = 0;
    Long challongeId;
    Long smashId;

    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL} , mappedBy = "player1" , fetch = FetchType.LAZY)
    private List<PlayerMatch> playerMatches = new ArrayList<>();

    public Player() {
    }

    public Player(String name, int onlinePoints, int offlinePoints, Long challongeId, Long smashId) {
        this.name = name;
        this.onlinePoints = onlinePoints;
        this.offlinePoints = offlinePoints;
        this.challongeId = challongeId;
        this.smashId = smashId;
    }

    public Integer getNumberOfAllMatches(){
        return playerMatches.size();
    }

    public Integer getNumOfTournamentMatches(Tournament tournament){
        return (int) playerMatches.stream().filter(elemement -> tournament.equals(elemement.getTournament())).count();
    }

    public Double getPlayerTournamentsWinrate(){
        var matchesWon = (int) playerMatches.stream().filter(element -> element.getWinner().equals(1L)).count();
        var value = ((double)matchesWon /(double) playerMatches.size());
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Double getPlayerVsPlayerWinrate(Player opponent){
        var matchesVsPlayer = playerMatches.stream().filter(element -> opponent.equals(element.getPlayer2())).collect(Collectors.toList());
        var matchesWon = (int) matchesVsPlayer.stream().filter(element -> element.getWinner().equals(1L)).count();
        var value = ((double) matchesWon/ (double)matchesVsPlayer.size());
        return new BigDecimal(value).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOnlinePoints() {
        return onlinePoints;
    }

    public void setOnlinePoints(int onlinePoints) {
        this.onlinePoints = onlinePoints;
    }

    public int getOfflinePoints() {
        return offlinePoints;
    }

    public void setOfflinePoints(int offlinePoints) {
        this.offlinePoints = offlinePoints;
    }

    public Long getChallongeId() {
        return challongeId;
    }

    public void setChallongeId(Long challongeId) {
        this.challongeId = challongeId;
    }

    public Long getSmashId() {
        return smashId;
    }

    public void setSmashId(Long smashId) {
        this.smashId = smashId;
    }

    public List<PlayerMatch> getPlayerMatches() {
        return playerMatches;
    }

    public void setPlayerMatches(List<PlayerMatch> playerMatches) {
        this.playerMatches = playerMatches;
    }
}

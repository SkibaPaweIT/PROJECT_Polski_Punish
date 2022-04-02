package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class PlayerMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL} , fetch = FetchType.LAZY)
    @JoinColumn(name = "player_1_id", nullable = true)
    private Player player1;


    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
    @JoinColumn(name = "player_2_id", nullable = true)
    private Player player2;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tournament_id", nullable = true)
    private Tournament tournament;
    private Long round;
    private Long winner;
    private Long seed;
    private Long placement;

    public PlayerMatch() {

    }

    public PlayerMatch(Long id, Player player1, Player player2, Tournament tournament, Long round) {
        this.id = id;
        this.player1 = player1;
        this.player2 = player2;
        this.tournament = tournament;
        this.round = round;
    }

    public Long getSeed() {
        return seed;
    }

    public void setSeed(Long seed) {
        this.seed = seed;
    }

    public Long getPlacement() {
        return placement;
    }

    public void setPlacement(Long placement) {
        this.placement = placement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public Long getRound() {
        return round;
    }

    public void setRound(Long round) {
        this.round = round;
    }

    public Long getWinner() {
        return winner;
    }

    public void setWinner(Long winner) {
        this.winner = winner;
    }
}

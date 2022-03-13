package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentPointsEnum;

import javax.persistence.*;

@Entity
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long id;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "player_id")
    private Player player;

    private int placement;
    private int points;
    private int seed;
    private Long challongeId;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tournament_id" , nullable = true)
    private Tournament tournament;

    public TournamentParticipant() {
    }

    public TournamentParticipant(Player player,int placement, Tournament tournament , int points , int seed, Long challongeId) {
        this.placement = placement;
        this.player = player;
        this.tournament = tournament;
        this.points = points;
        this.challongeId = challongeId;
        this.seed = seed;
        this.pointsFromPlacement(placement);
    }


    public void pointsFromPlacement(int placement) {
            this.points = TournamentPointsEnum.valueOf(placement).getPoints();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getSeed() {
        return seed;
    }

    public void setSeed(int seed) {
        this.seed = seed;
    }

    public Long getChallongeId() {
        return challongeId;
    }

    public void setChallongeId(Long challongeId) {
        this.challongeId = challongeId;
    }

    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }
}

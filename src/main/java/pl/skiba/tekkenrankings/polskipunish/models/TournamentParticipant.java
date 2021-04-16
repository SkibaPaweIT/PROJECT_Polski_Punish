package pl.skiba.tekkenrankings.polskipunish.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name="tournament_id" , nullable = true)
    private Tournament tournament;

    public TournamentParticipant() {
    }

    public TournamentParticipant(Player player,int placement, Tournament tournament) {
        this.placement = placement;
        this.player = player;
        this.tournament = tournament;

        this.setPoints(placement);
    }



    public Tournament getTournament() {
        return tournament;
    }

    public void setTournament(Tournament tournament) {
        this.tournament = tournament;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int placement) {
        this.points = TournamentPointsEnum.valueOf(placement).getPoints();
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

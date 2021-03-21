package pl.skiba.tekkenrankings.polskipunish.models;

import javax.persistence.*;

@Entity
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int placement;
    private String player;
    private int points;

    public TournamentParticipant() {
    }

    public TournamentParticipant(int placement, String player, int points) {
        this.placement = placement;
        this.player = player;
        this.points = points;
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

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

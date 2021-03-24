package pl.skiba.tekkenrankings.polskipunish.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placement;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "player_id")
    private Player player;
    private int points;

    public TournamentParticipant() {
    }

    public TournamentParticipant(String placement, Player player, int points) {
        this.placement = placement;
        this.player = player;
        this.points = points;
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
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

    public void setPoints(int points) {
        this.points = points;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}

package pl.skiba.tekkenrankings.polskipunish.models;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

import javax.persistence.*;

@Entity
public class TournamentParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CsvBindByName(column = "Miejsce")
    private String placement;
    @CsvBindByName(column = "Zawodnik")
    private String player;
    @CsvBindByName(column = "Punkty")
    private String points;

    public TournamentParticipant() {
    }

    public TournamentParticipant(String placement, String player, String points) {
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

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }
}

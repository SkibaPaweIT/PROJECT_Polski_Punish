package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

import javax.persistence.*;
import java.util.List;

@Entity
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String gameName;

    @OneToMany(cascade = {CascadeType.ALL} , mappedBy="game")
    private List<Tournament> tournaments;

    public Game(String gameName, List<Tournament> tournaments) {
        this.gameName = gameName;
        this.tournaments = tournaments;
    }

    public Game() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Tournament> getTournaments() {
        return tournaments;
    }

    public void setTournaments(List<Tournament> tournaments) {
        this.tournaments = tournaments;
    }
}

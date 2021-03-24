package pl.skiba.tekkenrankings.polskipunish.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournamentName;

    @Enumerated(EnumType.STRING)
    private tournamentCategoryEnum tournamentCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="game_id" , nullable = true)
    private Game game;


    @JsonIgnore
    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tournament_id")
    private List<TournamentParticipant> participants;

    public Tournament(String tournamentName, tournamentCategoryEnum tournamentCategory, Game game, List<TournamentParticipant> participants) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.game = game;
        this.participants = participants;
    }

    public Tournament() {
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public tournamentCategoryEnum getTournamentCategory() {
        return tournamentCategory;
    }

    public void setTournamentCategory(tournamentCategoryEnum tournamentCategory) {
        this.tournamentCategory = tournamentCategory;
    }

    public List<TournamentParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TournamentParticipant> participants) {
        this.participants = participants;
    }
}

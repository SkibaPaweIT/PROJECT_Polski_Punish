package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;


import com.fasterxml.jackson.annotation.JsonIgnore;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;

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
    private TournamentCategoryEnum tournamentCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="game_id" , nullable = true)
    private Game game;


    @OneToMany(cascade = {CascadeType.ALL} , mappedBy="tournament")
    private List<TournamentParticipant> participants;

    public Tournament(String tournamentName, TournamentCategoryEnum tournamentCategory, Game game, List<TournamentParticipant> participants) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.game = game;
        this.participants = participants;
    }

    public Tournament() {
    }

    public Tournament(String tournamentName, TournamentCategoryEnum tournamentCategory, Game game) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.game = game;
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

    public TournamentCategoryEnum getTournamentCategory() {
        return tournamentCategory;
    }

    public void setTournamentCategory(TournamentCategoryEnum tournamentCategory) {
        this.tournamentCategory = tournamentCategory;
    }

    public List<TournamentParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TournamentParticipant> participants) {
        this.participants = participants;
    }
}

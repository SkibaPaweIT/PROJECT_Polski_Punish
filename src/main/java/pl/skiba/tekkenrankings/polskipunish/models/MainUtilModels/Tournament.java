package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cascade;
import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Tournament {

    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournamentName;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date eventDate;
    private String country;

    @Enumerated(EnumType.STRING)
    private TournamentCategoryEnum tournamentCategory;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "game_id", nullable = true)
    private Game game;

    @OneToMany(cascade = {CascadeType.ALL} , mappedBy = "tournament")
    private List<PlayerMatch> playerMatches =  new ArrayList<>(); ;


    @OneToMany(cascade = {CascadeType.ALL}, mappedBy = "tournament")
    private List<TournamentParticipant> participants =  new ArrayList<>(); ;

    public Tournament(String tournamentName, TournamentCategoryEnum tournamentCategory, Game game, List<TournamentParticipant> participants, String country, Date eventDate) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.game = game;
        this.participants = participants;
        this.eventDate = eventDate;
        this.country = country;
    }

    public Tournament(String tournamentName, TournamentCategoryEnum tournamentCategory, Game game, Date eventDate, String country) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.game = game;
        this.eventDate = eventDate;
        this.country = country;
    }

    public Date getDataWydarzenia() {
        return eventDate;
    }

    public void setDataWydarzenia(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getKraj() {
        return country;
    }

    public void setKraj(String country) {
        this.country = country;
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

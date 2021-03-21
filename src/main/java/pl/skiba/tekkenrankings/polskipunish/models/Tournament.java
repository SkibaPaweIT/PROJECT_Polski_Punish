package pl.skiba.tekkenrankings.polskipunish.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tournamentName;
    private tournamentCategoryEnum tournamentCategory;

    @OneToMany(cascade = {CascadeType.ALL})
    @JoinColumn(name = "tournament_id")
    private List<TournamentParticipant> participants;

    public Tournament(String tournamentName, tournamentCategoryEnum tournamentCategory, List<TournamentParticipant> participants) {
        this.tournamentName = tournamentName;
        this.tournamentCategory = tournamentCategory;
        this.participants = participants;
    }



    public Tournament() {
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

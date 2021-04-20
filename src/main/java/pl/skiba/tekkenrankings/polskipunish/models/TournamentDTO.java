package pl.skiba.tekkenrankings.polskipunish.models;

import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;

import java.util.List;

public class TournamentDTO {

    private String tournamentName;
    private TournamentCategoryEnum tournamentCategory;
    private GameDTO game;
    private List<TournamentParticipantDTO> participants;

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

    public GameDTO getGame() {
        return game;
    }

    public void setGame(GameDTO game) {
        this.game = game;
    }

    public List<TournamentParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(List<TournamentParticipantDTO> participants) {
        this.participants = participants;
    }
}

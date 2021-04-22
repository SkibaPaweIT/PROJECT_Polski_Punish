package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

import pl.skiba.tekkenrankings.polskipunish.models.Enums.TournamentCategoryEnum;

public class TournamentDTO {

    private String tournamentName;
    private TournamentCategoryEnum tournamentCategory;
    private GameDTO game;
    private Iterable<TournamentParticipantDTO> participants;

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

    public Iterable<TournamentParticipantDTO> getParticipants() {
        return participants;
    }

    public void setParticipants(Iterable<TournamentParticipantDTO> participants) {
        this.participants = participants;
    }
}

package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

public class GameDTO {

    private String gameName;

    public GameDTO(String gameName) {
        this.gameName = gameName;
    }

    public GameDTO() {
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }
}

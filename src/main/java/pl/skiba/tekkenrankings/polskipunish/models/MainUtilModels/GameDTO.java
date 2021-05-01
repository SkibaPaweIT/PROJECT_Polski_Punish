package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

public class GameDTO {

    private Long id;
    private String gameName;

    public GameDTO(Long id, String gameName) {
        this.id = id;
        this.gameName = gameName;
    }

    public GameDTO() {
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
}

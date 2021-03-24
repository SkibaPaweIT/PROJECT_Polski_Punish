package pl.skiba.tekkenrankings.polskipunish.models;

import com.opencsv.bean.CsvBindByName;


public class CSVTournamentDTO {

    @CsvBindByName(column = "Miejsce")
    private String placement;
    @CsvBindByName(column = "Zawodnik")
    private String player;
    @CsvBindByName(column = "Punkty")
    private int points;

    public CSVTournamentDTO(String placement, String player, int points) {
        this.placement = placement;
        this.player = player;
        this.points = points;
    }

    public CSVTournamentDTO() {
    }

    public String getPlacement() {
        return placement;
    }

    public void setPlacement(String placement) {
        this.placement = placement;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

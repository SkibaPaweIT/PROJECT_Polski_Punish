package pl.skiba.tekkenrankings.polskipunish.models;

import com.opencsv.bean.CsvBindByName;


public class CSVTournamentDTO {

    @CsvBindByName(column = "Miejsce")
    private int placement;
    @CsvBindByName(column = "Zawodnik")
    private String player;
    @CsvBindByName(column = "Punkty")
    private int points;

    public CSVTournamentDTO(int placement, String player, int points) {
        this.placement = placement;
        this.player = player;
        this.points = points;
    }

    public CSVTournamentDTO() {
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
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

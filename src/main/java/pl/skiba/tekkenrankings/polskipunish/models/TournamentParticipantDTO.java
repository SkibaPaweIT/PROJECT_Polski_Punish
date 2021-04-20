package pl.skiba.tekkenrankings.polskipunish.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TournamentParticipantDTO {

    private PlayerDTO player;
    private int placement;
    private int points;


    public PlayerDTO getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDTO player) {
        this.player = player;
    }

    public int getPlacement() {
        return placement;
    }

    public void setPlacement(int placement) {
        this.placement = placement;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}

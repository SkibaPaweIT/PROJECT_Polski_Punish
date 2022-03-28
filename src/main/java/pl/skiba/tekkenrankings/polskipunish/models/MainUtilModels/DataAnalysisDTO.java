package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

public class DataAnalysisDTO {
    Long player_id;
    Long player_rank;
    Double player_tournaments_winrate;
    String player_character;
    Long player_points;
    Double player_vs_opponent_winrate;
    Long opponent_id;
    Long opponent_rank;
    Double opponent_tournaments_winrate;
    Long opponent_points;
    Long result;

    public DataAnalysisDTO() {
    }

    public Long getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Long player_id) {
        this.player_id = player_id;
    }

    public Long getPlayer_rank() {
        return player_rank;
    }

    public void setPlayer_rank(Long player_rank) {
        this.player_rank = player_rank;
    }

    public Double getPlayer_tournaments_winrate() {
        return player_tournaments_winrate;
    }

    public void setPlayer_tournaments_winrate(Double player_tournaments_winrate) {
        this.player_tournaments_winrate = player_tournaments_winrate;
    }

    public String getPlayer_character() {
        return player_character;
    }

    public void setPlayer_character(String player_character) {
        this.player_character = player_character;
    }

    public Long getPlayer_points() {
        return player_points;
    }

    public void setPlayer_points(Long player_points) {
        this.player_points = player_points;
    }

    public Double getPlayer_vs_opponent_winrate() {
        return player_vs_opponent_winrate;
    }

    public void setPlayer_vs_opponent_winrate(Double player_vs_opponent_winrate) {
        this.player_vs_opponent_winrate = player_vs_opponent_winrate;
    }

    public Long getOpponent_id() {
        return opponent_id;
    }

    public void setOpponent_id(Long opponent_id) {
        this.opponent_id = opponent_id;
    }

    public Long getOpponent_rank() {
        return opponent_rank;
    }

    public void setOpponent_rank(Long opponent_rank) {
        this.opponent_rank = opponent_rank;
    }

    public Double getOpponent_tournaments_winrate() {
        return opponent_tournaments_winrate;
    }

    public void setOpponent_tournaments_winrate(Double opponent_tournaments_winrate) {
        this.opponent_tournaments_winrate = opponent_tournaments_winrate;
    }

    public Long getOpponent_points() {
        return opponent_points;
    }

    public void setOpponent_points(Long opponent_points) {
        this.opponent_points = opponent_points;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}

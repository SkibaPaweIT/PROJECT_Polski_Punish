package pl.skiba.tekkenrankings.polskipunish.models.MainUtilModels;

public class DataAnalysisDTO {
    String player_nickname;
    Long player_rank;
    Long rounds;

    Double player_tournaments_winrate;
    String player_character;
    Integer player_offfline_points;
    Integer player_online_points;
    Integer player_number_of_all_matches_played;
    Integer player_number_of_matches_played_in_torunament;
    Integer player_seed;
    Integer player_placement;


    Double player_vs_opponent_winrate;

    String opponent_nickname;
    Long opponent_rank;
    Double opponent_tournaments_winrate;
    Integer opponent_offline_points;
    Integer opponent_online_points;
    Integer opponent_number_of_all_matches_played;
    Integer opponent_number_of_matches_played_in_torunament;
    Long result;


    public DataAnalysisDTO() {
    }


    public Integer getPlayer_seed() {
        return player_seed;
    }

    public void setPlayer_seed(Integer player_seed) {
        this.player_seed = player_seed;
    }

    public Integer getPlayer_placement() {
        return player_placement;
    }

    public void setPlayer_placement(Integer player_placement) {
        this.player_placement = player_placement;
    }

    public String getPlayer_nickname() {
        return player_nickname;
    }

    public void setPlayer_nickname(String player_nickname) {
        this.player_nickname = player_nickname;
    }

    public String getOpponent_nickname() {
        return opponent_nickname;
    }

    public void setOpponent_nickname(String opponent_nickname) {
        this.opponent_nickname = opponent_nickname;
    }

    public Integer getPlayer_number_of_all_matches_played() {
        return player_number_of_all_matches_played;
    }

    public void setPlayer_number_of_all_matches_played(Integer player_number_of_all_matches_played) {
        this.player_number_of_all_matches_played = player_number_of_all_matches_played;
    }

    public Integer getPlayer_number_of_matches_played_in_torunament() {
        return player_number_of_matches_played_in_torunament;
    }

    public void setPlayer_number_of_matches_played_in_torunament(Integer player_number_of_matches_played_in_torunament) {
        this.player_number_of_matches_played_in_torunament = player_number_of_matches_played_in_torunament;
    }

    public Integer getOpponent_number_of_all_matches_played() {
        return opponent_number_of_all_matches_played;
    }

    public void setOpponent_number_of_all_matches_played(Integer opponent_number_of_all_matches_played) {
        this.opponent_number_of_all_matches_played = opponent_number_of_all_matches_played;
    }

    public Integer getOpponent_number_of_matches_played_in_torunament() {
        return opponent_number_of_matches_played_in_torunament;
    }

    public void setOpponent_number_of_matches_played_in_torunament(Integer opponent_number_of_matches_played_in_torunament) {
        this.opponent_number_of_matches_played_in_torunament = opponent_number_of_matches_played_in_torunament;
    }


    public Long getPlayer_rank() {
        return player_rank;
    }

    public void setPlayer_rank(Long player_rank) {
        this.player_rank = player_rank;
    }

    public Long getRounds() {
        return rounds;
    }

    public void setRounds(Long rounds) {
        this.rounds = rounds;
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

    public Integer getPlayer_offfline_points() {
        return player_offfline_points;
    }

    public void setPlayer_offfline_points(Integer player_offfline_points) {
        this.player_offfline_points = player_offfline_points;
    }

    public Integer getPlayer_online_points() {
        return player_online_points;
    }

    public void setPlayer_online_points(Integer player_online_points) {
        this.player_online_points = player_online_points;
    }

    public Double getPlayer_vs_opponent_winrate() {
        return player_vs_opponent_winrate;
    }

    public void setPlayer_vs_opponent_winrate(Double player_vs_opponent_winrate) {
        this.player_vs_opponent_winrate = player_vs_opponent_winrate;
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

    public Integer getOpponent_offline_points() {
        return opponent_offline_points;
    }

    public void setOpponent_offline_points(Integer opponent_offline_points) {
        this.opponent_offline_points = opponent_offline_points;
    }

    public Integer getOpponent_online_points() {
        return opponent_online_points;
    }

    public void setOpponent_online_points(Integer opponent_online_points) {
        this.opponent_online_points = opponent_online_points;
    }

    public Long getResult() {
        return result;
    }

    public void setResult(Long result) {
        this.result = result;
    }
}

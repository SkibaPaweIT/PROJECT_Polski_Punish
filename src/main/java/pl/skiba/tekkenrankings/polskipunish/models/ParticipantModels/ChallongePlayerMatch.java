package pl.skiba.tekkenrankings.polskipunish.models.ParticipantModels;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChallongePlayerMatch {

    private Long id;
    private Long player1_id;
    private Long player2_id;
    private Long round;
    private String scores_csv;
    private Long winner_id;

    public ChallongePlayerMatch() {
    }

    public ChallongePlayerMatch(Long id, Long player1_id, Long player2_id, Long round) {
        this.id = id;
        this.player1_id = player1_id;
        this.player2_id = player2_id;
        this.round = round;
    }

    public String getScores_csv() {
        return scores_csv;
    }

    public void setScores_csv(String scores_csv) {
        this.scores_csv = scores_csv;
    }

    public Long getWinner_id() {
        return winner_id;
    }

    public void setWinner_id(Long winner_id) {
        this.winner_id = winner_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlayer1_id() {
        return player1_id;
    }

    public void setPlayer1_id(Long player1_id) {
        this.player1_id = player1_id;
    }

    public Long getPlayer2_id() {
        return player2_id;
    }

    public void setPlayer2_id(Long player2_id) {
        this.player2_id = player2_id;
    }

    public Long getRound() {
        return round;
    }

    public void setRound(Long round) {
        this.round = round;
    }
}

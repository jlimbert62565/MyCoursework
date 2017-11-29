package Model;

public class Scores {

    private int ScoreID;
    private int playerID;
    private int score;
    private String date;

    public Scores(int playerID, int ScoreID, int score, String date) {
        this.playerID = playerID;
        this.ScoreID = ScoreID;
        this.score = score;
        this.date = date;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getScoreID() {
        return ScoreID;
    }

    public void setScoreID(int ScoreID) {
        this.ScoreID = ScoreID;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}

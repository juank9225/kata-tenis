
public class TennisGame3 implements TennisGame {
    
    private int playerTwoPoints;
    private int playerOnePoints;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame3(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public String getScore() {
        String score;
        if (playerOnePoints < 4 && playerTwoPoints < 4 && !(playerOnePoints + playerTwoPoints == 6)) {
            String[] points = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            score = points[playerOnePoints];
            return tieOrAdventage(score, points);
        } else {
            return findWinner();
        }
    }

    private String tieOrAdventage(String score, String[] points) {
        return (playerOnePoints == playerTwoPoints) ? score + "-All" : score + "-" + points[playerTwoPoints];
    }

    private String findWinner() {
        String score;
        if (playerOnePoints == playerTwoPoints){
            return "Deuce";
        }

        score = chosePlayerName();
        return winner(score);
    }

    private String winner(String score) {
        return ((playerOnePoints - playerTwoPoints) * (playerOnePoints - playerTwoPoints) == 1) ? "Advantage " + score : "Win for " + score;
    }

    private String chosePlayerName() {
        return playerOnePoints > playerTwoPoints ? playerOneName : playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.playerOnePoints += 1;
        else
            this.playerTwoPoints += 1;
        
    }

}

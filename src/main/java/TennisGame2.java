public class TennisGame2 implements TennisGame
{
    public int pointsPlayerOne = 0;
    public int pointsPlayerTwo = 0;

    public String resultPlayer = "";
    public String resultPlayerOne = "";
    public String resultPlayerTwo = "";
    private String namePlayerOne;
    private String namePlayerTwo;

    private final String THIRTY = "Thirty";
    private final String FIFTEEN = "Fifteen";
    private final String FORTY = "Forty";
    private final String LOVE = "Love";

    public TennisGame2(String namePlayerOne, String namePlayerTwo) {
        this.namePlayerOne = namePlayerOne;
        this.namePlayerTwo = namePlayerTwo;
    }

    public String getScore(){
        String score = "";
        score = tiePoints(score);

        score = deuceCase(score);

        score = playerOneAdventage(score);
        score = playerTwoAdventage(score);

        score = pointsOnGameForBothPlayers(score);

        score = adventageMessage(score);

        score = winnerMessage(score);

        return score;
    }

    private String pointsOnGameForBothPlayers(String score) {
        score = pointsForPlayerOne(score);
        if (pointsPlayerTwo > pointsPlayerOne && pointsPlayerTwo < 4)
        {
            onGamePlayerTwoAdventage();
            score = resultPlayerOne + "-" + resultPlayerTwo;
        }
        return score;
    }

    private String pointsForPlayerOne(String score) {
        if (pointsPlayerOne > pointsPlayerTwo && pointsPlayerOne < 4)
        {
            onGamePlayerOneAdventage(pointsPlayerOne, pointsPlayerTwo);
            score = resultPlayerOne + "-" + resultPlayerTwo;
        }
        return score;
    }

    private String playerTwoAdventage(String score) {
        if (pointsPlayerTwo > 0 && pointsPlayerOne ==0)
        {
            playerAdventage(pointsPlayerTwo);
            resultPlayerTwo = resultPlayer;
            resultPlayerOne = LOVE;
            score = resultPlayerOne + "-" + resultPlayerTwo;
        }
        return score;
    }

    private String playerOneAdventage(String score) {
        if (pointsPlayerOne > 0 && pointsPlayerTwo ==0)
        {
            playerAdventage(pointsPlayerOne);
            resultPlayerOne = resultPlayer;
            resultPlayerTwo = LOVE;
            score = resultPlayerOne + "-" + resultPlayerTwo;
        }
        return score;
    }

    private String deuceCase(String score) {
        if (pointsPlayerOne == pointsPlayerTwo && pointsPlayerOne >=3)
            score = "Deuce";
        return score;
    }

    private String tiePoints(String score) {
        if (pointsPlayerOne == pointsPlayerTwo && pointsPlayerOne < 4)
        {
            score = tiePointsCases(score);
            score += "-All";
        }
        return score;
    }

    private String tiePointsCases(String score) {
        if (pointsPlayerOne ==0)
            score = LOVE;
        if (pointsPlayerOne ==1)
            score = FIFTEEN;
        if (pointsPlayerOne ==2)
            score = THIRTY;
        return score;
    }

    private String winnerMessage(String score) {
        score = playerOneWon(score);
        score = playerTwoWon(score);
        return score;
    }

    private String playerTwoWon(String score) {
        if (pointsPlayerTwo >=4 && pointsPlayerOne >=0 && (pointsPlayerTwo - pointsPlayerOne)>=2)
        {
            score = "Win for player2";
        }
        return score;
    }

    private String playerOneWon(String score) {
        if (pointsPlayerOne >=4 && pointsPlayerTwo >=0 && (pointsPlayerOne - pointsPlayerTwo)>=2)
        {
            score = "Win for player1";
        }
        return score;
    }

    private String adventageMessage(String score) {
        score = adventagePlayerOneOnGame(score);

        if (pointsPlayerTwo > pointsPlayerOne && pointsPlayerOne >= 3)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String adventagePlayerOneOnGame(String score) {
        if (pointsPlayerOne > pointsPlayerTwo && pointsPlayerTwo >= 3)
        {
            score = "Advantage player1";
        }
        return score;
    }

    private void onGamePlayerTwoAdventage() {
        if (pointsPlayerTwo ==2)
            resultPlayerTwo =THIRTY;
        if (pointsPlayerTwo ==3)
            resultPlayerTwo =FORTY;
        if (pointsPlayerOne ==1)
            resultPlayerOne =FIFTEEN;
        if (pointsPlayerOne ==2)
            resultPlayerOne =THIRTY;
    }

    private void onGamePlayerOneAdventage(int pointsPlayerOne, int pointsPlayerTwo) {
        if (pointsPlayerOne ==2)
            resultPlayerOne =THIRTY;
        if (pointsPlayerOne ==3)
            resultPlayerOne =FORTY;
        if (pointsPlayerTwo ==1)
            resultPlayerTwo =FIFTEEN;
        if (pointsPlayerTwo ==2)
            resultPlayerTwo =THIRTY;
    }

    private void playerAdventage(int pointsPlayer) {
        if (pointsPlayer ==1)
            resultPlayer = FIFTEEN;
        if (pointsPlayer ==2)
            resultPlayer = THIRTY;
        if (pointsPlayer ==3)
            resultPlayer = FORTY;
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        pointsPlayerOne++;
    }

    public void P2Score(){
        pointsPlayerTwo++;
    }

    public void wonPoint(String player) {
        if (player == "player1"){
            P1Score();
        }

        if(player == "player2"){
            P2Score();
        }

    }
}
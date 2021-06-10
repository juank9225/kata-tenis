
public class TennisGame1 implements TennisGame {
    
    private int scorePlayerOne = 0;
    private int scorePlayerTwo = 0;
    private String player1Name;
    private String player2Name;
    private String score = "";

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            scorePlayerOne += 1;
        else
            scorePlayerTwo += 1;
    }

    public String getScore() {

        //int tempScore=0;
        if (scorePlayerOne == scorePlayerTwo)
        {
            score = deadHeat();
        }
        else if (scorePlayerOne >=4 || scorePlayerTwo >=4)
        {
            int minusResult = scorePlayerOne - scorePlayerTwo;
            adventagePoints(minusResult);
        }
        else
        {
            pointsOnTheMatch();
        }
        return score;
    }

    private void pointsOnTheMatch() {
        int temporalScore;
        for (int i = 1; i<3; i++)
        {
            if (i==1) temporalScore = scorePlayerOne;
            else { score+="-"; temporalScore = scorePlayerTwo;}
            assignPoints(temporalScore);
        }
    }

    private void assignPoints(int tempScore) {
        switch(tempScore)
        {
            case 0:
                score+="Love";
                break;
            case 1:
                score+="Fifteen";
                break;
            case 2:
                score+="Thirty";
                break;
            case 3:
                score+="Forty";
                break;
        }
    }

    private String deadHeat() {
        String score;
        switch (scorePlayerOne)
        {
            case 0:
                    score = "Love-All";
                break;
            case 1:
                    score = "Fifteen-All";
                break;
            case 2:
                    score = "Thirty-All";
                break;
            default:
                    score = "Deuce";
                break;

        }
        return score;
    }

    public void adventagePoints(int minusResult){

        if (minusResult==1) score ="Advantage player1";
        else if (minusResult ==-1) score ="Advantage player2";
        else if (minusResult>=2) score = "Win for player1";
        else score ="Win for player2";
    }
}

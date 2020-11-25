package Homework.Homework7.model;

public abstract class Footballer extends Sportsman  {
    protected boolean appeared;
    protected boolean minutesPlayed60Plus;
    protected int goals;
    protected int assists;
    protected boolean yellowCards;
    protected int penaltiesConceded;
    protected int ownGoal;
    protected boolean redCard;
    protected int penaltiesEarned;
    protected int fantasyScore;
    public boolean isAppeared() {
        return appeared;
    }

    public void setAppeared(boolean appeared) {
        this.appeared = appeared;
    }

    public boolean isMinutesPlayed60Plus() {
        return minutesPlayed60Plus;
    }

    public void setMinutesPlayed60Plus(boolean minutesPlayed60Plus) {
        this.minutesPlayed60Plus = minutesPlayed60Plus;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }

    public boolean hasYellowCard() {
        return yellowCards;
    }

    public void setYellowCards(boolean yellowCards) {
        this.yellowCards = yellowCards;
    }

    public int getPenaltiesConceded() {
        return penaltiesConceded;
    }

    public void setPenaltiesConceded(int penaltiesConceded) {
        this.penaltiesConceded = penaltiesConceded;
    }

    public int getOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(int ownGoal) {
        this.ownGoal = ownGoal;
    }

    public boolean hasRedCard() {
        return redCard;
    }

    public void setRedCard(boolean redCard) {
        this.redCard = redCard;
    }

    public int getPenaltiesEarned() {
        return penaltiesEarned;
    }

    public void setPenaltiesEarned(int penaltiesEarned) {
        this.penaltiesEarned = penaltiesEarned;
    }

    public void setFantasyScore(int fantasyScore) {
        this.fantasyScore += fantasyScore;
    }

    public int getFantasyScore() {
        return fantasyScore;
    }

}

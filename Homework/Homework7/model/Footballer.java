package Homework.Homework7.model;

import java.io.IOException;
import java.util.Objects;

public class Footballer extends Sportsman implements Comparable<Footballer> {
    protected String firstName;
    protected String lastName;
    protected boolean appeared;
    protected boolean minutesPlayed60Plus;
    protected int goals;
    protected int assists;
    protected boolean yellowCards;
    protected int penaltiesConceded;
    protected int ownGoal;
    protected boolean redCard;
    protected int penaltiesEarned;
    public int fantasyScore;

    public Footballer(String firstName,String lastName,int fantasyScore){
        this.firstName = firstName;
        this.lastName = lastName;
        this.fantasyScore = fantasyScore;
    }

    public Footballer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.matches("[A-Z][a-z]+")) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName.matches("[A-Z][a-z]+")) {
            this.lastName = lastName;
        }
    }

    public boolean isAppeared() {
        return appeared;
    }

    public void setAppeared(boolean appeared) {
        fantasyScore += appeared ? 1 : 0;
        this.appeared = appeared;
    }

    public boolean isMinutesPlayed60Plus() {
        return minutesPlayed60Plus;
    }

    public void setMinutesPlayed60Plus(boolean minutesPlayed60Plus) {
        fantasyScore += minutesPlayed60Plus ? 2 : 0;
        this.minutesPlayed60Plus = minutesPlayed60Plus;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        if (this instanceof GoalKeeper) {
            fantasyScore += goals * 8;
        } else {
            if (this instanceof Defender) {
                fantasyScore += goals * 6;
            } else {
                if (this instanceof Midfielder) {
                    fantasyScore += goals * 5;
                } else {
                    fantasyScore += goals * 4;
                }
            }
        }
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        if (this instanceof GoalKeeper) {
            fantasyScore += assists * 5;
        } else {
            fantasyScore += assists * 3;
        }
        this.assists = assists;
    }

    public boolean hasYellowCard() {
        return yellowCards;
    }

    public void setYellowCards(boolean yellowCards) {
        fantasyScore += yellowCards ? -1 : 0;
        this.yellowCards = yellowCards;
    }

    public int getPenaltiesConceded() {
        return penaltiesConceded;
    }

    public void setPenaltiesConceded(int penaltiesConceded) {
        fantasyScore += penaltiesConceded * -1;
        this.penaltiesConceded = penaltiesConceded;
    }

    public int getOwnGoal() {
        return ownGoal;
    }

    public void setOwnGoal(int ownGoal) {
        fantasyScore += ownGoal * -2;
        this.ownGoal = ownGoal;
    }

    public boolean hasRedCard() {
        return redCard;
    }

    public void setRedCard(boolean redCard) {
        fantasyScore += redCard ? -3 : 0;
        this.redCard = redCard;
    }

    public int getPenaltiesEarned() {
        return penaltiesEarned;
    }

    public void setPenaltiesEarned(int penaltiesEarned) {
        fantasyScore += penaltiesEarned * 2;
        this.penaltiesEarned = penaltiesEarned;
    }

    public void setFantasyScore(int fantasyScore) {
        this.fantasyScore = fantasyScore;
    }

    public int getFantasyScore() {
        return fantasyScore;
    }


    @Override
    public int compareTo(Footballer o) {
        return this.getFantasyScore() - o.getFantasyScore();
    }

    public static Footballer stringToObject(String str) {
        if (str.charAt(0) == 'G') {
            return GoalKeeper.goalkeeperInfoToObject(str);
        } else {
            if (str.charAt(0) == 'D') {
                return Defender.defenderInfoToObject(str);
            } else {
                if (str.charAt(0) == 'M') {
                    return Midfielder.midFielderInfoToObject(str);
                } else {
                    return Forward.forwardInfoToObject(str);

                }
            }
        }
    }

    public void writeToFile(String path) throws IOException {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footballer that = (Footballer) o;
        return firstName.equals(that.firstName) &&
                lastName.equals(that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }
}

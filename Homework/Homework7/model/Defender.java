package Homework.Homework7.model;

import java.util.StringJoiner;

public class Defender extends Footballer {
    private boolean cleanSheet;

    public boolean isCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(boolean cleanSheet) {
        fantasyScore += cleanSheet ? 4 : 0;
        this.cleanSheet = cleanSheet;
    }

    public static Footballer defenderInfoToObject(String defender) {
        String[] s = defender.split(" ");
        Defender currentDefender = new Defender();
        currentDefender.setFirstName(s[1]);
        currentDefender.setLastName(s[2]);
        currentDefender.setAppeared(Boolean.parseBoolean(s[3]));
        currentDefender.setMinutesPlayed60Plus(Boolean.parseBoolean(s[4]));
        currentDefender.setGoals(Integer.parseInt(s[5]));
        currentDefender.setAssists(Integer.parseInt(s[6]));
        currentDefender.setPenaltiesEarned(Integer.parseInt(s[7]));
        currentDefender.setYellowCards(Boolean.parseBoolean(s[8]));
        currentDefender.setRedCard(Boolean.parseBoolean(s[9]));
        currentDefender.setPenaltiesConceded(Integer.parseInt(s[10]));
        currentDefender.setOwnGoal(Integer.parseInt(s[11]));
        currentDefender.setCleanSheet(Boolean.parseBoolean(s[12]));
        return currentDefender;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(getFantasyScore()).append("]");
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("DF");
        stringJoiner.add(getFirstName());
        stringJoiner.add(getLastName());
        stringJoiner.add(isAppeared() + "");
        stringJoiner.add(isMinutesPlayed60Plus() + "");
        stringJoiner.add(getGoals() + "");
        stringJoiner.add(getAssists() + "");
        stringJoiner.add(getPenaltiesEarned() + "");
        stringJoiner.add(hasYellowCard() + "");
        stringJoiner.add(hasRedCard() + "");
        stringJoiner.add(getPenaltiesConceded() + "");
        stringJoiner.add(getOwnGoal() + "");
        stringJoiner.add(isCleanSheet() + "");
        stringBuilder.append(stringJoiner.toString());
        return stringBuilder.toString();
    }
}

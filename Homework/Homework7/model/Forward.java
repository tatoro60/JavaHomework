package Homework.Homework7.model;

import java.util.StringJoiner;

public class Forward extends Footballer {
    public static Footballer forwardInfoToObject(String forward){
        String[] s = forward.split(" ");
        Forward currentForward = new Forward();
        currentForward.setFirstName(s[1]);
        currentForward.setLastName(s[2]);
        currentForward.setAppeared(Boolean.parseBoolean(s[3]));
        currentForward.setMinutesPlayed60Plus(Boolean.parseBoolean(s[4]));
        currentForward.setGoals(Integer.parseInt(s[5]));
        currentForward.setAssists(Integer.parseInt(s[6]));
        currentForward.setPenaltiesEarned(Integer.parseInt(s[7]));
        currentForward.setYellowCards(Boolean.parseBoolean(s[8]));
        currentForward.setRedCard(Boolean.parseBoolean(s[9]));
        currentForward.setPenaltiesConceded(Integer.parseInt(s[10]));
        currentForward.setOwnGoal(Integer.parseInt(s[11]));
        return currentForward;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(getFantasyScore()).append("]");
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("FW");
        stringJoiner.add(getFirstName());
        stringJoiner.add(getLastName());
        stringJoiner.add(isAppeared()+"");
        stringJoiner.add(isMinutesPlayed60Plus()+"");
        stringJoiner.add(getGoals()+"");
        stringJoiner.add(getAssists()+"");
        stringJoiner.add(getPenaltiesEarned()+"");
        stringJoiner.add(hasYellowCard()+"");
        stringJoiner.add(hasRedCard()+"");
        stringJoiner.add(getPenaltiesConceded()+"");
        stringJoiner.add(getOwnGoal()+"");
        stringBuilder.append(stringJoiner.toString());
        return stringBuilder.toString();
    }
}

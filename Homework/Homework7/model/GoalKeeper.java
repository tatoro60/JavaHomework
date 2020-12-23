package Homework.Homework7.model;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringJoiner;

public class GoalKeeper extends Footballer {
    private boolean cleanSheet;
    private int penaltyKickSaves;
    private int concededGoals;
    private int saves;

    public GoalKeeper(String firstName,String lastName,int fantasyScore) {
        super(firstName,lastName,fantasyScore);
    }
    public GoalKeeper(){

    }

    public boolean wasCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(boolean cleanSheet) {
        fantasyScore += cleanSheet ? 4 : 0;
        this.cleanSheet = cleanSheet;
    }

    public int getPenaltyKickSaves() {
        return penaltyKickSaves;
    }

    public void setPenaltyKickSaves(int penaltyKickSaves) {
        fantasyScore += penaltyKickSaves * 5;
        this.penaltyKickSaves = penaltyKickSaves;
    }

    public int getConcededGoals() {
        return concededGoals;
    }

    public void setConcededGoals(int concededGoals) {
        fantasyScore -= concededGoals / 2;
        this.concededGoals = concededGoals;
    }

    public int getSaves() {
        return saves;
    }

    public void setSaves(int saves) {
        fantasyScore += saves / 3;
        this.saves = saves;
    }


    public static Footballer goalkeeperInfoToObject(String goalkeeper) {
        String[] s = goalkeeper.split(" ");
        GoalKeeper currentGoalkeeper = new GoalKeeper();
        currentGoalkeeper.setFirstName(s[1]);
        currentGoalkeeper.setLastName(s[2]);
        currentGoalkeeper.setAppeared(Boolean.parseBoolean(s[3]));
        currentGoalkeeper.setMinutesPlayed60Plus(Boolean.parseBoolean(s[4]));
        currentGoalkeeper.setGoals(Integer.parseInt(s[5]));
        currentGoalkeeper.setAssists(Integer.parseInt(s[6]));
        currentGoalkeeper.setPenaltiesEarned(Integer.parseInt(s[7]));
        currentGoalkeeper.setYellowCards(Boolean.parseBoolean(s[8]));
        currentGoalkeeper.setRedCard(Boolean.parseBoolean(s[9]));
        currentGoalkeeper.setPenaltiesConceded(Integer.parseInt(s[10]));
        currentGoalkeeper.setOwnGoal(Integer.parseInt(s[11]));
        currentGoalkeeper.setCleanSheet(Boolean.parseBoolean(s[12]));
        currentGoalkeeper.setPenaltyKickSaves(Integer.parseInt(s[13]));
        currentGoalkeeper.setSaves(Integer.parseInt(s[14]));
        currentGoalkeeper.setConcededGoals(Integer.parseInt(s[15]));
        return currentGoalkeeper;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(getFantasyScore()).append("]");
        StringJoiner stringJoiner = new StringJoiner(",", "[", "]");
        stringJoiner.add("GK");
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
        stringJoiner.add(wasCleanSheet() + "");
        stringJoiner.add(getPenaltyKickSaves() + "");
        stringJoiner.add(getSaves() + "");
        stringJoiner.add(getConcededGoals() + "");
        stringBuilder.append(stringJoiner.toString());
        return stringBuilder.toString();
    }

    public void writeToFile(String path) throws IOException {
        Files.write(Paths.get(path), (getFirstName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getLastName() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (isAppeared() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (isMinutesPlayed60Plus() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getAssists() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getPenaltiesEarned() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (hasYellowCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (hasRedCard() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getPenaltiesConceded() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getOwnGoal() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (wasCleanSheet() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getPenaltyKickSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getSaves() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getConcededGoals() + " ").getBytes(), StandardOpenOption.APPEND);
        Files.write(Paths.get(path), (getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}

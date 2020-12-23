package Homework.Homework7.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.StringJoiner;

public class Midfielder extends Footballer {
    public Midfielder(String firstName,String lastName,int fantasyScore) {
        super(firstName,lastName,fantasyScore);
    }
    public Midfielder() {

    }
    public static Footballer midFielderInfoToObject(String midfielder){
        String[] s = midfielder.split(" ");
        Midfielder currentMidfielder = new Midfielder();
        currentMidfielder.setFirstName(s[1]);
        currentMidfielder.setLastName(s[2]);
        currentMidfielder.setAppeared(Boolean.parseBoolean(s[3]));
        currentMidfielder.setMinutesPlayed60Plus(Boolean.parseBoolean(s[4]));
        currentMidfielder.setGoals(Integer.parseInt(s[5]));
        currentMidfielder.setAssists(Integer.parseInt(s[6]));
        currentMidfielder.setPenaltiesEarned(Integer.parseInt(s[7]));
        currentMidfielder.setYellowCards(Boolean.parseBoolean(s[8]));
        currentMidfielder.setRedCard(Boolean.parseBoolean(s[9]));
        currentMidfielder.setPenaltiesConceded(Integer.parseInt(s[10]));
        currentMidfielder.setOwnGoal(Integer.parseInt(s[11]));
        return currentMidfielder;
    }
    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[").append(getFantasyScore()).append("]");
        StringJoiner stringJoiner = new StringJoiner(",","[","]");
        stringJoiner.add("MF");
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
        Files.write(Paths.get(path), (getFantasyScore() + "").getBytes(), StandardOpenOption.APPEND);
    }
}

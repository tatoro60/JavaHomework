package Homework.Homework7;

import Homework.Homework7.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;

public class FootballersData {
    public static final String footballersPath = "C:\\Users\\Admin\\Desktop\\FootInfo.txt";
    public static  HashSet<Footballer> allFootballers = new HashSet<>();

    public static void readDataFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(footballersPath));
        Footballer current = null;
        for (String string : strings) {
            String[] split = string.split(" ");
            switch (split[0]) {
                case "GK":
                    current = new GoalKeeper(split[1], split[2], Integer.parseInt(split[3]));
                    break;
                case "DF":
                    current = new Defender(split[1], split[2], Integer.parseInt(split[3]));
                    break;
                case "MF":
                    current = new Midfielder(split[1], split[2], Integer.parseInt(split[3]));
                    break;
                case "FW":
                    current = new Forward(split[1], split[2], Integer.parseInt(split[3]));
                    break;
            }
            allFootballers.add(current);
        }


    }
}

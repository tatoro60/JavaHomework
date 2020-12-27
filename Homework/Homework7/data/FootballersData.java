package Homework.Homework7.data;

import Homework.Homework7.model.Footballer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class FootballersData {
    public static final String footballersPath = "C:\\Users\\Admin\\Desktop\\FootInfo.txt";
    public static HashMap<Integer,Footballer> allFootballers = new HashMap<>();

    public static void readDataFromFile() throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(footballersPath));
        for (String string : strings) {
            String[] split = string.split(" ");
            allFootballers.put(Integer.parseInt(split[0]),new Footballer(Integer.parseInt(split[0]),split[1],split[2],split[3],Integer.parseInt(split[4])));
        }
    }

}

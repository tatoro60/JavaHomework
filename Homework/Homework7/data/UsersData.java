package Homework.Homework7.data;

import Homework.Homework7.model.Footballer;
import Homework.Homework7.model.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class UsersData {
    public static final String path = "C:\\Users\\Admin\\Desktop\\Javafolder\\JavaHomework\\Homework\\Homework7\\data\\database.txt";
    public static HashMap<String, User> usernames = new HashMap<>();

    public static void readCurrentUserInfoFromFile(String path, User current) throws IOException {
        List<String> strings = Files.readAllLines(Paths.get(path));
        for (String string : strings) {
            String[] split = string.split(" ");
            current.myTeam.put(Integer.parseInt(split[0]),new Footballer(Integer.parseInt(split[0]),split[1],split[2],split[3],Integer.parseInt(split[4])));
            current.addFantasyScore(Integer.parseInt(split[4]));
        }
    }
}

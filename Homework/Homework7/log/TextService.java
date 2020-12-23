package Homework.Homework7.log;

import Homework.Homework7.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.List;

public class TextService {
    public static void fillUsernamesMap(HashMap<String, User> map,String path) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        for (String string : strings) {
            String[] info = string.split(" ");
            User currentUser = new User();
            currentUser.setName(info[0]);
            currentUser.setSurname(info[1]);
            currentUser.setUsername(info[2]);
            currentUser.setEmail(info[3]);
            currentUser.setPassword(info[4]);
            map.put(currentUser.getUsername(),currentUser);
        }
    }
    public static void writeToFile(String path,String info) throws IOException {
        Files.write(Paths.get(path), (info+ "\n").getBytes(), StandardOpenOption.APPEND);
    }
}

package Homework.Homework7.service;

import Homework.Homework7.model.User;

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
            User currentUser = new User(info[0],info[1],info[2],info[3],info[4]);
            map.put(currentUser.getUsername(),currentUser);
        }
    }
    public static void writeToFile(String path,String info) throws IOException {
        Files.write(Paths.get(path), (info+ "\n").getBytes(), StandardOpenOption.APPEND);
    }
    public static void removeFileInfo(String path) throws IOException {
        Files.write(Paths.get(path), ("").getBytes());
    }
}

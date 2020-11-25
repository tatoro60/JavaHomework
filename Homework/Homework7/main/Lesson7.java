package Homework.Homework7.main;

import Homework.Homework7.CreateFantasyTeam;

import java.io.*;

public class Lesson7 {
    public static void main(String[] args) throws IOException {
        CreateFantasyTeam cft = new CreateFantasyTeam();

        cft.creteFile();
        cft.freeToFile();
    }
}

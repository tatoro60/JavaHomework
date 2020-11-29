package Homework.Homework7.main;

import Homework.Homework7.CreateFantasyTeam;

import java.io.*;

public class Lesson7 {
    public static void main(String[] args) {
        CreateFantasyTeam createFantasyTeam = new CreateFantasyTeam();
        try {
            createFantasyTeam.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

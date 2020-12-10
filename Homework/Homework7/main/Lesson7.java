package Homework.Homework7.main;

import Homework.Homework7.CreateFantasyTeam;

import java.io.IOException;

public class Lesson7 {
    public static void main(String[] args) {
        CreateFantasyTeam createFantasyTeam = new CreateFantasyTeam();

        try {
            createFantasyTeam.sortFootballersByFantasyScore();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

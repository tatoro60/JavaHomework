package Homework.Homework7.main;

import Homework.Homework7.log.Registration_Project;

import java.io.IOException;

public class Lesson7 {
    public static void main(String[] args) {
        Registration_Project login = new Registration_Project();
        try {
            login.begin();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

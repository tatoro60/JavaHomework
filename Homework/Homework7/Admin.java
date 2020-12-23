package Homework.Homework7;

import Homework.Homework7.model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Admin {

    public void addNewFootballers() throws IOException {
        Scanner s = new Scanner(System.in);
        boolean a = true;
        while (a) {
            System.out.println("Enter footballer position");
            System.out.println("1. Goalkeeper");
            System.out.println("2. Defender");
            System.out.println("3. Midfielder");
            System.out.println("4. Forward");
            System.out.println("Type any other number to end");
            Footballer current = new GoalKeeper();
            switch (s.nextInt()) {
                case 1:
                    current = new GoalKeeper();
                    break;
                case 2:
                    current = new Defender();
                    break;
                case 3:
                    current = new Midfielder();
                    break;
                case 4:
                    current = new Forward();
                    break;
                default:
                    a = false;
            }
            if (a) {
                s.nextLine();
                System.out.println("Enter footballers firstname");
                current.setFirstName(s.nextLine());
                System.out.println("Enter footballers lastname");
                current.setLastName(s.nextLine());
                Files.write(Paths.get(FootballersData.footballersPath), (current.toString()+"\n").getBytes(), StandardOpenOption.APPEND);
            }
        }
    }
}

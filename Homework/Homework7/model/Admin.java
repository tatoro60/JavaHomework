package Homework.Homework7.model;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.enums.AdminCommands;
import Homework.Homework7.enums.FOOTBALLERS_Position;
import Homework.Homework7.service.Helper;
import Homework.Homework7.service.TextService;
import Homework.Homework7.service.ValidationService;

import java.io.IOException;

public class Admin {

    public Admin(){
        try {
            FootballersData.readDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void chooseAdminCommand() throws IOException {
        boolean pointer = true;
        while (pointer) {
            System.out.println("Enter your command");
            System.out.println("ADD REMOVE SHOW SAVE EXIT");
            AdminCommands command = AdminCommands.fromString(Helper.scanner.next());
            if (command != null) {
                switch (command) {
                    case ADD:
                        addNewFootballer();
                        break;
                    case REMOVE:
                        remove();
                        break;
                    case SHOW:
                        showAllFootballers();
                        break;
                    case SAVE:
                        saveInfoInFile();
                        break;
                    case EXIT:
                        pointer = false;
                        break;
                }

            }
        }
    }

    private void showAllFootballers() {
        for (Footballer footballer : FootballersData.allFootballers.values()) {
            System.out.println(footballer);
        }
    }

    private void remove() {
        System.out.println("If you want see footballers list type show,otherwise type anything");
        if(Helper.scanner.next().equalsIgnoreCase("show")){
            showAllFootballers();
        }

        System.out.println("Enter footballer's ID");
        FootballersData.allFootballers.remove(Helper.scanner.nextInt());
    }

    private void addNewFootballer() throws IOException {
        boolean a = true;
        System.out.println("Enter footballer position");
        System.out.println("GK      DF      MF      FW");
        FOOTBALLERS_Position position = FOOTBALLERS_Position.fromString(Helper.scanner.next());
        if (position == null) {
            System.out.println("Position is wrong");
            return;
        }
        Footballer current = new Footballer();
        current.setPosition(position.getPosition());
        String currentName;
        System.out.println("Enter footballers firstname");
        currentName = Helper.scanner.next();
        while (!ValidationService.nameValidator(currentName)) {
            System.out.println("Footballer's firstname is not valid please write again!");
            currentName = Helper.scanner.next();
        }
        current.setFirstName(currentName);
        System.out.println("Enter footballers lastname");
        currentName = Helper.scanner.next();
        while (!ValidationService.nameValidator(currentName)) {
            System.out.println("Footballer's lastname is not valid please write again!");
            currentName = Helper.scanner.next();
        }
        current.setLastName(currentName);
        int score;
        System.out.println("Enter fantasy score");
        score = Helper.scanner.nextInt();
        while (score < 0) {
            System.out.println("Fantasy score  must be non negative");
            score = Helper.scanner.nextInt();
        }
        current.setFantasyScore(score);
        current.setID(current.hashCode());
        FootballersData.allFootballers.put(current.getID(), current);
    }

    private void saveInfoInFile() throws IOException {
        TextService.removeFileInfo(FootballersData.footballersPath);
        for (Footballer x : FootballersData.allFootballers.values()) {
            try {
                TextService.writeToFile(FootballersData.footballersPath, x.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

package Homework.Homework7.model;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.data.UsersData;
import Homework.Homework7.enums.FootballerCommands;
import Homework.Homework7.enums.FOOTBALLERS_Position;
import Homework.Homework7.enums.GeneralCommands;
import Homework.Homework7.service.Helper;
import Homework.Homework7.service.TextService;
import Homework.Homework7.service.ValidationService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Admin {
    public static boolean usersAccessToSeeScores;
    public void begin() throws IOException {
        System.out.println("Do you want end tour ? YES/NO");
        if(Helper.scanner.next().equalsIgnoreCase("yes")){
            usersAccessToSeeScores = true;
        }
        boolean pointer = true;
        while (pointer) {
            System.out.println("Enter your command");
            System.out.println("Edit footballers - FOOT");
            System.out.println("See users - USER");
            System.out.println("For exit - EXIT");
            GeneralCommands command = GeneralCommands.fromString(Helper.scanner.next());
            if (command != null) {
                switch (command) {
                    case FOOT:
                        editFootballers();
                        break;
                    case USER:
                        seeUsers();
                        break;
                    case EXIT:
                        pointer = false;
                        break;
                }

            }
        }
    }

    public static void seeUsers() {
        List<User> list = new ArrayList<>(UsersData.usernames.values());
        list.sort(Collections.reverseOrder());
        while (true) {
            for (User user : list) {
                System.out.println(user.getUsername() + " : " + user.getSumOfFantasyScore());
            }
            System.out.println("Write user's username to see team");
            System.out.println("Or type exit");
            String username = Helper.scanner.next();
            if(username.equalsIgnoreCase("exit")){
                return;
            }
            while (!UsersData.usernames.containsKey(username)) {
                System.out.println("Username doesn't exist");
                username = Helper.scanner.next();
            }
            List<Footballer> footballers = new ArrayList<>(UsersData.usernames.get(username).myTeam.values());
            footballers.sort(Collections.reverseOrder());
            System.out.println("-----------------------------");
            for (Footballer footballer : footballers) {
                System.out.println(footballer.toString());
            }
            System.out.println("-----------------------------");
        }
    }

    private void editFootballers() throws IOException {
        if(usersAccessToSeeScores){
            System.out.println("You can not edit footballers ,because tour is ended");
            seeUsers();
            return;
        }
        boolean pointer = true;
        while (pointer) {
            System.out.println("Enter your command");
            System.out.println("ADD REMOVE SHOWALL EXIT");
            FootballerCommands command = FootballerCommands.fromString(Helper.scanner.next());
            if (command != null) {
                switch (command) {
                    case ADD:
                        addNewFootballer();
                        break;
                    case REMOVE:
                        remove();
                        break;
                    case SHOWALL:
                        showAllFootballers();
                        break;
                    case EXIT:
                        saveInfoInFile();
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
        if(!UsersData.usernames.isEmpty()){
            System.out.println("You can not remove");
            return;
        }
        System.out.println("Do you want see footballers list?");
        System.out.println("Type YES if you want");
        if (Helper.scanner.next().equalsIgnoreCase("YES")) {
            showAllFootballers();
        }

        System.out.println("Enter footballer's ID");
        FootballersData.allFootballers.remove(Helper.scanner.nextInt());
    }

    private void addNewFootballer() {
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

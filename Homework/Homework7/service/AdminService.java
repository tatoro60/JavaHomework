package Homework.Homework7.service;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.data.UsersData;
import Homework.Homework7.Constants.FootballerCommands;
import Homework.Homework7.Constants.FootballerPosition;
import Homework.Homework7.Constants.GeneralCommands;
import Homework.Homework7.model.Footballer;
import Homework.Homework7.model.User;
import Homework.Homework7.service.Helper;
import Homework.Homework7.service.TextService;
import Homework.Homework7.service.ValidationService;

import java.io.IOException;
import java.util.*;

public class AdminService {
    public static boolean matchDayWasEnded;
    private final LinkedHashMap<Integer, Footballer> curr =new LinkedHashMap<>();

    public void begin() throws IOException {
        System.out.println("Do you want to end match day ? YES/NO");
        if (Helper.scanner.next().equalsIgnoreCase("yes")) {
            matchDayWasEnded = true;
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
            if (username.equalsIgnoreCase("exit")) {
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

    private void editFootballers(){
        if (matchDayWasEnded) {
            System.out.println("You can not edit footballers ,because match day finished");
            seeUsers();
            return;
        }
        boolean pointer = true;
        while (pointer) {
            System.out.println("Enter your command");
            System.out.println("ADD REMOVE SHOWALL SHOWMY EXIT");
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
                        showFootballers(FootballersData.allFootballers);
                        break;
                    case SHOWMY://see current footballers that will be added
                        showFootballers(curr);
                        break;
                    case EXIT:
                        saveInfoInFile();
                        pointer = false;
                        break;
                }

            }
        }
    }

    private void showFootballers(Map<Integer,Footballer> map) {
        for (Footballer footballer : map.values()) {
            System.out.println(footballer);
        }
    }

    private void remove() {
        showFootballers(curr);
        System.out.println("Enter footballer's ID");
        curr.remove(Helper.scanner.nextInt());
    }

    private void addNewFootballer() {
        System.out.println("Enter footballer position");
        System.out.println("GK      DF      MF      FW");
        FootballerPosition position = FootballerPosition.fromString(Helper.scanner.next());
        if (position == null) {
            System.out.println("Position is wrong");
            return;
        }
        Footballer current = new Footballer();
        current.setPosition(position.getPosition());
        String currentName;
        System.out.println("Enter footballers firstname");
        currentName = Helper.scanner.next();
        while (!ValidationService.validateName(currentName)) {
            System.out.println("Footballer's firstname is not valid please write again!");
            currentName = Helper.scanner.next();
        }
        current.setFirstName(currentName);
        System.out.println("Enter footballers lastname");
        currentName = Helper.scanner.next();
        while (!ValidationService.validateName(currentName)) {
            System.out.println("Footballer's lastname is not valid please write again!");
            currentName = Helper.scanner.next();
        }
        current.setLastName(currentName);
        System.out.println("Enter fantasy score");
        current.setFantasyScore(Helper.scanner.nextInt());
        current.setID(FootballersData.getLastID());
        curr.put(current.getID(), current);
    }

    private void saveInfoInFile(){
        FootballersData.allFootballers.putAll(curr);
        for (Footballer x : curr.values()) {
            try {
                TextService.writeToFile(FootballersData.footballersPath, x.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        curr.clear();
    }


}

package Homework.Homework7.service;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.Constants.FootballerCommands;
import Homework.Homework7.model.Admin;
import Homework.Homework7.model.Footballer;
import Homework.Homework7.model.User;

import java.io.IOException;

public class UserService {
    private static final int TEAM_SIZE = 11;
    User current;

    public UserService(User user) {
        this.current = user;
    }

    public void begin() {
        if (Admin.matchDayWasEnded) {// if match day finished you can not edit team
            Admin.seeUsers();
            return;
        }
        while (true) {
            System.out.println("Enter your command");
            System.out.println("ADD REMOVE SHOWALL SHOWMY EXIT");
            FootballerCommands cmd = FootballerCommands.fromString(Helper.scanner.next());
            if (cmd != null) {
                switch (cmd) {
                    case ADD:
                        addFootballer();
                        break;
                    case REMOVE:
                        removeFootballer();
                        break;
                    case SHOWALL:
                        showAll();
                        break;
                    case SHOWMY:
                        showMy();
                        break;
                    case EXIT:
                        try {
                            save();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return;
                }
            }
        }
    }

    private void save() throws IOException {
        current.addFantasyScore(current.getSumOfFantasyScore() * -1);
        TextService.removeFileInfo(current.getUserPath());
        for (Footballer f : current.myTeam.values()) {
            current.addFantasyScore(f.getFantasyScore());
            TextService.writeToFile(current.getUserPath(), f.toString());

        }
    }

    private void showAll() {
        for (Footballer footballer : FootballersData.allFootballers.values()) {
            if (!current.myTeam.containsKey(footballer.getID())) {
                System.out.println(footballer.toStringForUsers());
            }
        }
    }

    private void removeFootballer() {
        showMy();
        System.out.println("Enter footballer's ID");
        int id = Helper.scanner.nextInt();
        if (FootballersData.allFootballers.containsKey(id)) {
            current.myTeam.remove(id);
        } else {
            System.out.println("ID doesn't exist");
        }
    }

    private void addFootballer() {
        showAll();
        System.out.println("Enter footballer's ID");
        int id = Helper.scanner.nextInt();
        if (FootballersData.allFootballers.containsKey(id)) {
            if (TEAM_SIZE != current.myTeam.size()) {
                current.myTeam.put(id, FootballersData.allFootballers.get(id));
            } else {
                System.out.println("Team is full");
            }
        } else {
            System.out.println("ID doesn't exist");
        }
    }

    private void showMy() {

        for (Footballer footballer : current.myTeam.values()) {
            System.out.println(footballer.toStringForUsers());
        }

    }
}

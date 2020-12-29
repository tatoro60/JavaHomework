package Homework.Homework7.main;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.data.UsersData;
import Homework.Homework7.Constants.Role;
import Homework.Homework7.model.Admin;
import Homework.Homework7.service.AccessAsUser;
import Homework.Homework7.service.Helper;
import Homework.Homework7.service.TextService;

import java.io.File;
import java.io.IOException;

public class Lesson7 {
    public static void main(String[] args) {
        try {
            //read all data
            TextService.fillUsernamesMap(UsersData.usernames, UsersData.path);
            FootballersData.readDataFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            System.out.println("Type your command");
            System.out.println("ADMIN   USER   END");
            Role role = Role.fromString(Helper.scanner.next());
            if (role != null) {
                switch (role) {
                    case ADMIN:
                        try {
                            new Admin().begin();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case USER:
                        try {
                            new AccessAsUser().begin();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case END:
                        if (Admin.matchDayWasEnded) {//Cleared all data if match day finished
                            File file;
                            for (String username : UsersData.usernames.keySet()) {
                                file = new File(UsersData.usernames.get(username).getUserPath());
                                file.delete();
                            }
                            try {
                                TextService.removeFileInfo(UsersData.path);
                                TextService.removeFileInfo(FootballersData.footballersPath);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        return;
                }
            }
        }
    }
}



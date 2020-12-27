package Homework.Homework7.main;

import Homework.Homework7.enums.ROLE;
import Homework.Homework7.log.Registration;
import Homework.Homework7.model.Admin;
import Homework.Homework7.service.Helper;

import java.io.IOException;

public class Lesson7 {
    public static void main(String[] args) {
        boolean pointer = true;
        while (pointer) {
            System.out.println("Type your command");
            System.out.println("ADMIN   USER   END");
            ROLE role = ROLE.fromString(Helper.scanner.next());
            if (role != null) {
                switch (role) {
                    case ADMIN:
                        try {
                            new Admin().chooseAdminCommand();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case USER:
                        try {
                            new Registration().begin();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        break;
                    case END:
                        pointer = false;
                        break;
                }
            }
        }
    }

}

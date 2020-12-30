package Homework.Homework7.service;

import Homework.Homework7.data.FootballersData;
import Homework.Homework7.data.UsersData;
import Homework.Homework7.Constants.AccessCommands;
import Homework.Homework7.model.User;

import java.io.File;
import java.io.IOException;

public class AccessAsUser {
    public static User currentUser = null;

    public AccessAsUser() {

    }

    public void begin() throws IOException {
        while (true) {
            System.out.println("Type your command");
            System.out.println("LOGIN   SIGNUP   EXIT");
            AccessCommands cmd = AccessCommands.fromString(Helper.scanner.next());
            if (cmd != null) {
                switch (cmd) {
                    case SIGNUP:
                        signUp();
                        break;
                    case LOGIN:
                        if (!login()) {
                            continue;
                        }
                        break;
                    case EXIT:
                        return;
                }
                FootballersData.readDataFromFile();
                new UserService(currentUser).begin();
            }
        }
    }

    private void signUp() throws IOException {
        currentUser = new User();
        String current;
        System.out.println("Please write your name");
        current = Helper.scanner.next();
        while (!ValidationService.validateName(current)) {
            System.out.println("Your name is not valid please write again!");
            current = Helper.scanner.next();
        }
        currentUser.setName(current);
        System.out.println("Please write your surname");
        current = Helper.scanner.next();
        while (!ValidationService.validateName(current)) {
            System.out.println("Your surname is not valid please write again!");
            current = Helper.scanner.next();
        }
        currentUser.setSurname(current);
        System.out.println("Please write your username");
        current = Helper.scanner.next();
        while (!ValidationService.validateUsername(current, UsersData.usernames)) {
            if (current.length() <= 10) {
                System.out.println("Username length must be longer than 10");
            } else {
                System.out.println("Username already exists. Write new username");
            }
            current = Helper.scanner.next();
        }
        currentUser.setUsername(current);
        currentUser.makeLink();
        System.out.println("Please write your email");
        current = Helper.scanner.next();
        while (!ValidationService.validateEmail(current)) {
            System.out.println("Email validation is wrong .Write right email");
            current = Helper.scanner.next();
        }
        currentUser.setEmail(current);
        System.out.println("Please write your password");
        current = Helper.scanner.next();
        while (!(ValidationService.validatePassword(current) && current.length() > 8)) {
            if (current.length() <= 8) {
                System.out.println("Your password length must be longer than 8");
            } else {
                System.out.println("Your password must have at least 3 digits and 2 Uppercases");
            }
            current = Helper.scanner.next();
        }
        currentUser.setPassword(Helper.getMd5(current));
        UsersData.usernames.put(currentUser.getUsername(), currentUser);
        TextService.writeToFile(UsersData.path, currentUser.toString());

    }

    private boolean login() {
        System.out.println("Anytime you can write exit");
        System.out.println("Write username");
        String username = Helper.scanner.next();
        while (!UsersData.usernames.containsKey(username)) {
            if (username.equalsIgnoreCase("exit")) return false;
            System.out.println("Username doesn't exist");
            username = Helper.scanner.next();
        }
        currentUser = UsersData.usernames.get(username);
        System.out.println("Write your password");
        String pass = Helper.scanner.next();
        while (!(Helper.getMd5(pass).equals(currentUser.getPassword()))) {
            if (pass.equalsIgnoreCase("exit")) return false;
            System.out.println("Password is wrong.Please write again!");
            pass = Helper.scanner.next();
        }
        return true;
    }
}

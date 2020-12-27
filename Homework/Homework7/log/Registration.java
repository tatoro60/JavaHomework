package Homework.Homework7.log;

import Homework.Homework7.enums.Command;
import Homework.Homework7.model.User;
import Homework.Homework7.service.Helper;
import Homework.Homework7.service.TextService;
import Homework.Homework7.service.ValidationService;

import java.io.IOException;
import java.util.HashMap;

public class Registration {
    private static final String path = "C:\\Users\\Admin\\Desktop\\Javafolder\\JavaHomework\\Homework\\Homework7\\data\\database.txt";
    private static HashMap<String, User> usernames;
    private static User currentUser = null;

    public Registration() {
        usernames = new HashMap<>();
        try {
            TextService.fillUsernamesMap(usernames, path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void begin() throws IOException {
        boolean pointer = true;
        while (pointer) {
            System.out.println("Type your command");
            System.out.println("LOGIN   SIGNUP   EXIT");
            Command cmd = Command.fromString(Helper.scanner.next());
            if (cmd != null) {
                switch (cmd) {
                    case SIGNUP:
                        signUp();
                        break;
                    case LOGIN:
                        login();
                        break;
                    case EXIT:
                        pointer = false;
                        break;
                }
            }
        }
    }

    private void signUp() throws IOException {
        currentUser = new User();
        String current;
        System.out.println("Please write your name");
        current = Helper.scanner.next();
        while (!ValidationService.nameValidator(current)) {
            System.out.println("Your name is not valid please write again!");
            current = Helper.scanner.next();
        }
        currentUser.setName(current);
        System.out.println("Please write your surname");
        current = Helper.scanner.next();
        while (!ValidationService.nameValidator(current)) {
            System.out.println("Your surname is not valid please write again!");
            current = Helper.scanner.next();
        }
        currentUser.setSurname(current);
        System.out.println("Please write your username");
        current = Helper.scanner.next();
        while (!ValidationService.usernameValidator(current, usernames)) {
            if (current.length() <= 10) {
                System.out.println("Username length must be longer than 10");
            } else {
                System.out.println("Username already exists. Write new username");
            }
            current = Helper.scanner.next();
        }
        currentUser.setUsername(current);
        System.out.println("Please write your email");
        current = Helper.scanner.next();
        while (!ValidationService.emailValidator(current)) {
            System.out.println("Email validation is wrong .Write right email");
            current = Helper.scanner.next();
        }
        currentUser.setEmail(current);
        System.out.println("Please write your password");
        current = Helper.scanner.next();
        while (!(ValidationService.passwordValidator(current) && current.length() > 8)) {
            if (current.length() <= 8) {
                System.out.println("Your password length must be longer than 8");
            } else {
                System.out.println("Your password must have at least 3 digits and 2 Uppercases");
            }
            current = Helper.scanner.next();
        }
        currentUser.setPassword(Helper.getMd5(current));
        usernames.put(currentUser.getUsername(), currentUser);
        TextService.writeToFile(path, currentUser.toString());
    }

    private void login() {
        System.out.println("Write username");
        String username = Helper.scanner.next();
        while (!usernames.containsKey(username)) {
            System.out.println("Username doesn't exist");
            username = Helper.scanner.next();
        }
        currentUser = usernames.get(username);
        System.out.println("Write your password");
        String pass = Helper.scanner.next();
        while (!(Helper.getMd5(pass).equals(currentUser.getPassword()))) {
            System.out.println("Password is wrong.Please write again!");
            pass = Helper.scanner.next();
        }

    }
}

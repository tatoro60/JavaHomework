package Homework.Homework7.log;

import Homework.Homework7.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.Scanner;

public class Registration_Project {
    private static final Scanner s = new Scanner(System.in);
    private static final String path = "C:\\Users\\Admin\\Desktop\\database.txt";
    public static HashMap<String, User> usernames;
    private static User currentUser = null;

    public Registration_Project() {
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
            Command cmd = Command.fromString(s.next());
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
        current = s.next();
        while (!Validator.nameValidator(current)) {
            System.out.println("Your name is not valid please write again!");
            current = s.next();
        }
        currentUser.setName(current);
        System.out.println("Please write your surname");
        current = s.next();
        while (!Validator.nameValidator(current)) {
            System.out.println("Your surname is not valid please write again!");
            current = s.next();
        }
        currentUser.setSurname(current);
        System.out.println("Please write your username");
        current = s.next();
        while (!Validator.usernameValidator(current, usernames)) {
            if (current.length() <= 10) {
                System.out.println("Username length must be longer than 10");
            } else {
                System.out.println("Username already exists. Write new username");
            }
            current = s.next();
        }
        currentUser.setUsername(current);
        System.out.println("Please write your email");
        current = s.next();
        while (!Validator.emailValidator(current)) {
            System.out.println("Email validation is wrong .Write right email");
            current = s.next();
        }
        currentUser.setEmail(current);
        System.out.println("Please write your password");
        current = s.next();
        while (!(Validator.passwordValidator(current) && current.length() > 8)) {
            if (current.length() <= 8) {
                System.out.println("Your password length must be longer than 8");
            } else {
                System.out.println("Your password must have at least 3 digits and 2 Uppercases");
            }
            current = s.next();
        }
        currentUser.setPassword(Helper.getMd5(current));
        usernames.put(currentUser.getUsername(), currentUser);
        TextService.writeToFile(path,currentUser.toString());
    }

    private void login() {
        System.out.println("Write username");
        String username = s.next();
        while (!usernames.containsKey(username)) {
            System.out.println("Username doesn't exist");
            username = s.next();
        }
        currentUser = usernames.get(username);
        System.out.println("Write your password");
        String pass = s.next();
        while (!(Helper.getMd5(pass).equals(currentUser.getPassword()))) {
            System.out.println("Password is wrong.Please write again!");
            pass = s.next();
        }

    }
}

package Homework.Homework7.log;

import Homework.Homework7.User;

import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration_Project {
    private static final Scanner s = new Scanner(System.in);
    private static final String path = "C:\\Users\\Admin\\Desktop\\database.txt";
    public static HashMap<String,User> usernames;
    private static User currentUser = null;

    public static String getMd5(String input) {
        try {

            MessageDigest md = MessageDigest.getInstance("MD5");

            byte[] messageDigest = md.digest(input.getBytes());

            BigInteger no = new BigInteger(1, messageDigest);

            StringBuilder hashtext = new StringBuilder(no.toString(16));
            while (hashtext.length() < 32) {
                hashtext.insert(0, "0");
            }
            return hashtext.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public Registration_Project() {
        usernames = new HashMap<>();
        try {
            fillUsernamesMap(usernames);
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
        while (!nameValidator(current)) {
            System.out.println("Your name is not valid please write again!");
            current = s.next();
        }
        currentUser.setName(current);
        System.out.println("Please write your surname");
        current = s.next();
        while (!nameValidator(current)) {
            System.out.println("Your surname is not valid please write again!");
            current = s.next();
        }
        currentUser.setSurname(current);
        System.out.println("Please write your username");
        current = s.next();
        while (!usernameValidator(current)) {
            if (current.length() <= 10) {
                System.out.println("Username length must be longer than 10");
            } else {
                System.out.println("Username already exists .Write new username");
            }
            current = s.next();
        }
        currentUser.setUsername(current);
        System.out.println("Please write your email");
        current = s.next();
        while (!emailValidator(current)) {
            System.out.println("Email validation is wrong .Write right email");
            current = s.next();
        }
        currentUser.setEmail(current);
        System.out.println("Please write your password");
        current = s.next();
        while (!(passwordValidator(current) && current.length() > 8)) {
            if (current.length() <= 8) {
                System.out.println("Your password length must be longer than 8");
            } else {
                System.out.println("Your password must have at least 3 digits and 2 Uppercases");
            }
            current = s.next();
        }
        currentUser.setPassword(getMd5(current));
        usernames.put(currentUser.getUsername(),currentUser);
        Files.write(Paths.get(path), (currentUser.toString()+"\n").getBytes(), StandardOpenOption.APPEND);
    }

    private boolean nameValidator(String name) {
        return name.matches("[A-Z][a-z]*");
    }

    private boolean usernameValidator(String username) {
        return username.length() > 10 && !usernames.containsKey(username);
    }

    private boolean emailValidator(String email) {
        Pattern p = Pattern.compile("^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
    }

    private boolean passwordValidator(String pass) {
        Pattern num = Pattern.compile(".*\\d.*\\d.*\\d.*");
        Pattern upper = Pattern.compile(".*[A-Z].*[A-Z].*");
        return upper.matcher(pass).find() && num.matcher(pass).find() && pass.length() > 8;
    }

    private static void fillUsernamesMap(HashMap<String,User> map) throws IOException {
        List<String> strings = Files.readAllLines(Path.of(path));
        for (String string : strings) {
            String[] info = string.split(" ");
            currentUser = new User();
            currentUser.setName(info[0]);
            currentUser.setSurname(info[1]);
            currentUser.setUsername(info[2]);
            currentUser.setEmail(info[3]);
            currentUser.setPassword(info[4]);
            map.put(currentUser.getUsername(),currentUser);
        }
    }

    private void login() {
        System.out.println("Write username");
        String username = s.next();
        while (!usernames.containsKey(username)){
            System.out.println("Username doesn't exist");
            username = s.next();
        }
        currentUser = usernames.get(username);
        System.out.println("Write your password");
        String pass = s.next();
        while(!(getMd5(pass).equals(currentUser.getPassword()))){
            System.out.println("Password is wrong.Please write again!");
            pass= s.next();
        }

    }
}

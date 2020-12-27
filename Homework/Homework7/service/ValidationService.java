package Homework.Homework7.service;

import Homework.Homework7.model.User;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public static boolean nameValidator(String name) {
        return name.matches("[A-Z][a-z]+");
    }

    public static boolean usernameValidator(String username, HashMap<String, User> usernames) {
        return username.length() > 10 && !usernames.containsKey(username);
    }

    public static boolean emailValidator(String email) {
        Pattern p = Pattern.compile("^[\\w-+]+(\\.[\\w]+)*@[\\w-]+(\\.[\\w]+)*(\\.[a-z]{2,})$", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        return m.find();
    }

    public static boolean passwordValidator(String pass) {
        Pattern num = Pattern.compile(".*\\d.*\\d.*\\d.*");
        Pattern upper = Pattern.compile(".*[A-Z].*[A-Z].*");
        return upper.matcher(pass).find() && num.matcher(pass).find() && pass.length() > 8;
    }
}

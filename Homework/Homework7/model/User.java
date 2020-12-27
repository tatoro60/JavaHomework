package Homework.Homework7.model;

import Homework.Homework7.data.FootballersData;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private int sumOfFantasyScore;
    private static final String ADMIN_PATH = FootballersData.footballersPath;
    private static HashMap<Integer, Footballer> allFootballers = FootballersData.allFootballers;
    private String userPath;

    public User(String username){
        this.username = username;
    }

    public User(){

    }

    public User(String name, String surname, String username, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private boolean setNickName(String nickName) {
        String USERNAME_PATTERN = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$";
        if (nickName.matches(USERNAME_PATTERN)) {
            StringBuilder sb = new StringBuilder();
            sb.append("C:\\Users\\Admin\\Desktop\\Users\\");
            sb.append(nickName);
            sb.append(".txt");
            File file = new File(sb.toString());
            if (file.exists()) {
                System.out.println("Nickname already exists");
                return false;
            }
            this.username = nickName;
            userPath = sb.toString();
            return true;
        } else {
            System.out.println("Your nickname is invalid! Please type correct nickname");
            return false;
        }
    }


    public void chooseFootballers() throws IOException {
        if(allFootballers.isEmpty()){
            FootballersData.readDataFromFile();
        }
    }

    public void footballersList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" ");
        sb.append(getSurname()).append(" ");
        sb.append(getUsername()).append(" ");
        sb.append(getEmail()).append(" ");
        sb.append(getPassword());
        return  sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }
}

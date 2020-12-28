package Homework.Homework7.model;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Objects;

public class User implements Comparable<User>{
    private String name;
    private String surname;
    private String username;
    private String email;
    private String password;
    private int sumOfFantasyScore = 0;
    private String userPath;
    public LinkedHashMap<Integer,Footballer> myTeam = new LinkedHashMap<>();

    public User() {

    }

    public User(String name, String surname, String username, String email, String password,String userPath) {
        this.name = name;
        this.surname = surname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userPath = userPath;
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

    public int getSumOfFantasyScore() {
        return sumOfFantasyScore;
    }

    public void addFantasyScore(int sumOfFantasyScore) {
        this.sumOfFantasyScore += sumOfFantasyScore;
    }

    public String getUserPath() {
        return userPath;
    }
    public String makeLink() throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("C:\\Users\\Admin\\Desktop\\Users\\");
        sb.append(getUsername());
        sb.append(".txt");
        File file = new File(sb.toString());
        file.createNewFile();
        userPath = sb.toString();
        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(" ");
        sb.append(getSurname()).append(" ");
        sb.append(getUsername()).append(" ");
        sb.append(getEmail()).append(" ");
        sb.append(getPassword()).append(" ");
        sb.append(getUserPath());
        return sb.toString();
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

    @Override
    public int compareTo(User o) {
        return this.sumOfFantasyScore-o.sumOfFantasyScore;
    }
}

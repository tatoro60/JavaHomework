package Homework.Homework7.model;

import Homework.Homework7.service.ValidationService;

import java.util.StringJoiner;

public class Footballer implements Comparable<Footballer> {
    private String firstName;
    private String lastName;
    private String position;
    private int fantasyScore;
    private int ID;

    public Footballer(int ID,String position,String firstName,String lastName,int fantasyScore){
        this.ID = ID;
        this.position = position;
        this.firstName = firstName;
        this.lastName = lastName;
        this.fantasyScore = fantasyScore;
    }

    public Footballer() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (ValidationService.validateName(firstName)) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (ValidationService.validateName(lastName)) {
            this.lastName = lastName;
        }
    }

    public void setFantasyScore(int fantasyScore) {
        this.fantasyScore = fantasyScore;
    }

    public int getFantasyScore() {
        return fantasyScore;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    @Override
    public int compareTo(Footballer o) {
        return this.getFantasyScore() - o.getFantasyScore();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(this.ID+"");
        stringJoiner.add(this.position);
        stringJoiner.add(this.firstName);
        stringJoiner.add(this.lastName);
        stringJoiner.add(this.fantasyScore+"");
        return stringJoiner.toString();
    }
    public String toStringForUsers(){
        StringJoiner stringJoiner = new StringJoiner(" ");
        stringJoiner.add(this.ID+"");
        stringJoiner.add(this.position);
        stringJoiner.add(this.firstName);
        stringJoiner.add(this.lastName);
        return stringJoiner.toString();
    }
}

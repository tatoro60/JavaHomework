package Homework.Homework6.model;

public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private String gender;
    private double mark;

    public  Student(){
        firstName = "Sasha";
        lastName = "Tsatryan";
        year = 2001;
        gender = "m";
        mark = 40.0;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        int index = 0;
        int count = 0;
        while (index < firstName.length()) {
            if (Character.isLetter(firstName.charAt(index++))) {
                count++;
            }
        }
        if (count == index) {
            this.firstName = firstName;
        } else {
            System.out.println("Firstname is not valid");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        int index = 0;
        int count = 0;
        while (index < lastName.length()) {
            if (Character.isLetter(lastName.charAt(index++))) {
                count++;
            }
        }
        if (count == index) {
            this.lastName = lastName;
        } else {
            System.out.println("Lastname is not valid");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1900) {
            this.year = year;
        }
    }

    public String getGender() {
        return gender;
    }


    public void setGender(String gender) {
        if (gender.equals("m") || gender.equals("f")) {
            this.gender = gender;
        }
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (!(mark < 0 || mark > 100)) {
            this.mark = mark;
        }
    }

}
package model;

public class Human {
    protected String firstName;
    protected String lastName;
    protected int year;

    public Human() {
        firstName = "";
        lastName = "";
        year = 1900;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 0) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 0) {
            this.lastName = lastName;
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year >= 1900 && year <= 2020) {
            this.year = year;
        }
    }
}

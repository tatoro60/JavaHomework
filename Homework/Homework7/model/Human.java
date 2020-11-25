package Homework.Homework7.model;

public  class Human {
    protected String firstName;
    protected String lastName;
    protected int year;

    public Human() {
        firstName = "babken";
        lastName = "";
        year = 1900;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.matches("[A-Z][a-z]*")) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName.matches("[A-Z][a-z]*")) {
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

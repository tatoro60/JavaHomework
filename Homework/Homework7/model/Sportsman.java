package Homework.Homework7.model;

public  abstract class Sportsman {
    protected String firstName;
    protected String lastName;

    public Sportsman() {
        firstName = "Sasha";
        lastName = "Tsatryan";
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

        if (firstName.matches("[A-Z][a-z]+")) {
            this.firstName = firstName;
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (firstName.matches("[A-Z][a-z]+")) {
            this.lastName = lastName;
        }
    }

}

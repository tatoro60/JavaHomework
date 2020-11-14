package model;

public class Sportsman extends Human {
    protected boolean retired;
    protected String nationality;

    public Sportsman() {
        retired = false;
        nationality = "";
    }

    public boolean wasRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        if (nationality.length() > 0) {
            this.nationality = nationality;
        }
    }
}

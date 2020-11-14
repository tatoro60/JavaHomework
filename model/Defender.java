package model;

public class Defender extends Footballer {
    protected int successfulTackles;
    public Defender (){
        successfulTackles = 0;
    }
    public int getSuccessfulTackles() {
        return successfulTackles;
    }

    public void setSuccessfulTackles(int successfulTackles) {
        this.successfulTackles = successfulTackles;
    }
}

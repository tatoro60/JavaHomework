package model;

public class Midfielder extends Footballer {
    protected int assists;
    public Midfielder(){
        assists = 0;
    }
    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }
}

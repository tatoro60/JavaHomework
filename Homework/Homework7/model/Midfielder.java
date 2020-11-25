package Homework.Homework7.model;

import Homework.Homework7.model.Footballer;

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

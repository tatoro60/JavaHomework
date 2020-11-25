package Homework.Homework7.model;

public class Defender extends Footballer {
    private boolean cleanSheet;
    public Defender(){
        cleanSheet =true;
    }
    public boolean isCleanSheet() {
        return cleanSheet;
    }

    public void setCleanSheet(boolean cleanSheet) {
        this.cleanSheet = cleanSheet;
    }
}

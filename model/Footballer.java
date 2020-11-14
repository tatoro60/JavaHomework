package model;

public class Footballer extends Sportsman {
    protected int transferValue;

    public Footballer() {
        transferValue = 0;
    }

    public int getTransferValue() {
        return transferValue;
    }

    public void setTransferValue(int transferValue) {
        if (transferValue >= 0) {
            this.transferValue = transferValue;
        }
    }
}

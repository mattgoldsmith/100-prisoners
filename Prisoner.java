public class Prisoner {
    private final int number;
    private int nextNumber;
    private int timesChecked;

    public Prisoner (int number) {
        timesChecked = 0;
        this.number = number;
        this.nextNumber = -1;
    }

    public int getNumber() {
        return number;
    }

    public int getTimesChecked() {
        return timesChecked;
    }

    public void setTimesChecked(int timesChecked) {
        this.timesChecked = timesChecked;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public void setNextNumber(int nextNumber) {
        this.nextNumber = nextNumber;
    }
}

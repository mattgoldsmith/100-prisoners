import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Controller {

    LinkedList<Box> boxes = new LinkedList<>(); // Maintain Order
    ArrayList<Prisoner> prisoners = new ArrayList<>();
    public Controller() {
        createBoxes();
        createPrisoners();
        runOriginal();
    }

    private void createBoxes() {
        for (int i = 0; i < 100; i++) {
            boxes.add(new Box(i+1) );
        }
    }

    private void createPrisoners() {
        for (int i = 0; i < 100; i++) {
            prisoners.add(new Prisoner(i+1) );
        }
    }

    private void runOriginal() {
        Collections.shuffle(boxes);

        for (Prisoner prisoner : prisoners) {
            int number = prisoner.getNumber();
            if(prisoner.getNextNumber() == -1) {
                prisoner.setNextNumber(number);
            }

            while(prisoner.getTimesChecked() < 50) {
                if(checkBox(number, prisoner.getNextNumber() ) ){
                    System.out.println("SUCCESS! PRISONER NUMBER: " + number + " - BOX NUMBER: " + prisoner.getNextNumber());
                    break;
                }
                prisoner.setTimesChecked(prisoner.getTimesChecked()+1);
                prisoner.setNextNumber(boxes.get(prisoner.getNextNumber()-1).getNumber());
            }
            if(prisoner.getTimesChecked() >= 50) {
                System.out.println("FAIL! PRISONER DID NOT FIND NUMBER - PRISONER NUMBER: " + number);
            }
        }
    }

    private boolean checkBox(int number, int nextNumber) {
        return boxes.get(nextNumber-1).getNumber() == number;
    }
}

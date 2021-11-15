
package nim;

/**
 * ***************************************
 * A template for a Human Nim player
 ***************************************
 */
import java.util.Scanner;

public class Human {

    private int choice;
    private Scanner input;
    public int pileSize;

    public Human() {
        input = new Scanner(System.in);
        choice = -1;
    }

    public void move(int pileSize) {

        // your code here
        System.out.println("How many marbles are you taking?");
        choice = input.nextInt();

        if (pileSize > 1) {
            boolean wrongMove = choice < 1 || choice > pileSize / 2 || (pileSize < choice);

            if (wrongMove) {
                System.out.println("sorry thats a wrong move");
                do {

                    System.out.println("Try again. how many mables are you taking?");

                    choice = input.nextInt();
                    wrongMove = choice < 1 || choice > pileSize / 2 || (pileSize < choice);

                } while (wrongMove);
            }
        } else {
            choice = 1;
        }

    }

    public int getChoice() {
        return choice;
    }

}

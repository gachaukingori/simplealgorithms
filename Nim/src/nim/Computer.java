
package nim;

import java.util.Random;

/**
 * ***************************************
 * A template for a computer Nim player
 ***************************************
 */
public class Computer {

    private int mode;
    private int choice;

    public Computer(int m) {
        mode = m;
        choice = -1;
    }

    public void move(int marblesLeft) {
        if (mode == 0) { // stupid mode
            
            stupidComputerMove(marblesLeft);
        } else { // smartmode
            
            smartComputerMove(marblesLeft);

        }
        

    }

    public int getChoice() {
        return choice;
    }

    public void stupidComputerMove(int marblesLeft) {

        Random random = new Random();
        if (marblesLeft > 1) {
            choice = random.nextInt(marblesLeft / 2) + 1;
        } else {
            choice = 1;  

        }

    }

    public void smartComputerMove(int marblesLeft) {
        int marbleTaken;
        Random random = new Random();
        if (marblesLeft > 1) {
            boolean smartMove = marblesLeft == 3 || marblesLeft == 7 || marblesLeft == 15 || marblesLeft == 31 || marblesLeft == 63;
            if (smartMove) { // computer makes a legal move now
                marbleTaken = random.nextInt(marblesLeft / 2) + 1;
            } else { // make the remaining marble power of 2 - 1
                int[] smartNumbers = {1, 3, 7, 15, 31, 63};
                // pick marbles that will ensure the pile is either of this size 
                do {

                    marbleTaken = marblesLeft - smartNumbers[random.nextInt(6)];

                } while (marbleTaken > (marblesLeft / 2) || marbleTaken < 1);
            }

        } else {
            marbleTaken = 1;
        }
        choice = marbleTaken;
    }
}

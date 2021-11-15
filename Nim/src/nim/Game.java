
package nim;

import java.util.Random;

/**
 * ***************************************
 * A template for a Nim game **************************************
 */
public class Game {

    private int marbles;
    private Human humanPlayer;
    private Computer computerPlayer;
    private int difficulty;
    int mode;

    public Game(int difficulty) {
        // your code here
        difficulty = this.difficulty;
        mode = smartOrStupidComp();

        computerPlayer = new Computer(mode);
        humanPlayer = new Human();

    }

    public void play() {
        // your code here

        humanPlayer = new Human();

        int pileSize = generateInitialPileSize(); // randomly generate a pile of  range 10 -100 

        System.out.println("The initial size of the pile is " + pileSize);

        mode = smartOrStupidComp(); // randomly decides computer mode if stupid or smart

        int determineWhoStarts = determineComputerOrHuman(); // randomly selects between computer and human to start  1 for human 0 for computer

        computerPlayer = new Computer(mode);
        int tempMarbles;
        if (determineWhoStarts == 1) {
            System.out.println("Human will starting this round");
        } else {
            System.out.println("The computer will starting this round");
        }

        if (mode == 0) {
            System.out.println("Computer will be playing in stupid mode this round");
        } else {
            System.out.println("Computer will be playing in smart mode this round");
        }

        do {
            if (determineWhoStarts == 1) {  // human  first 
                System.out.println("Human's turn to play: ");
                humanPlayer.move(pileSize);

                tempMarbles = humanPlayer.getChoice();

                pileSize = pileSize - tempMarbles;
                System.out.println("You have Selected " + tempMarbles);
                System.out.println("Remaining marbles are " + pileSize);
                if (pileSize == 0) {
                    System.out.println("Computer wins and you have lost ");
                    break;
                } else {

                    computerPlayer.move(pileSize);
                    int computerMarbles = computerPlayer.getChoice();
                    pileSize = pileSize - computerMarbles;
                    System.out.println("Computer has taken " + computerMarbles + " Marbles");
                    System.out.println("Remaining marbles are " + pileSize + " Marbles");
                    if (pileSize == 0) {
                        System.out.println("Congrats you have won the game");
                        break;
                    }

                }

            } else { // computer starts
                System.out.println("Computer's turn to play: ");

                computerPlayer.move(pileSize);
                int computerMarbles = computerPlayer.getChoice();
                System.out.println("Computer has taken " + computerMarbles + " Marbles");

                pileSize = pileSize - computerMarbles;
                System.out.println("Remaining marbles are " + pileSize + " Marbles");
                if (pileSize == 0) {
                    System.out.println("Congrats you have won the game");
                    break;
                } else { // game continues
                    humanPlayer.move(pileSize);
                    tempMarbles = humanPlayer.getChoice();

                    pileSize = pileSize - tempMarbles;
                    System.out.println("You have Selected: " + tempMarbles);
                    System.out.println("Remaining marbles are: " + pileSize);
                    if (pileSize == 0) {
                        System.out.println("Computer wins and you have lost ");
                        break;
                    }
                }
            }

        } while (pileSize != 0);

    }

    // you may wish to add more methods here
    public static int generateInitialPileSize() { // randomly generates a random integer between 10 and 100
        int low = 10;
        int high = 100;

        Random random = new Random();
        int pileSize = random.nextInt(high - low) + low;
        return pileSize;
        //   return int;
    }

    public static int determineComputerOrHuman() { // randomly generates an integer between 0 and 1 to deteremine whether human or computer starts
        Random random = new Random();

        int compOrHuman = random.nextInt(2);
        return compOrHuman;
    }

    public static int smartOrStupidComp() {  // randomly generates an integer between 0 and 1 to deteremine whether computer in stupid or smart mode
        Random random = new Random();
        int smartOrStupid = random.nextInt(2);
        return smartOrStupid;

    }

}

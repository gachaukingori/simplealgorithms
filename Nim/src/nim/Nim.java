/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nim;
/*****************************************
 * Test class for Nim game
 ****************************************/ 
import java.util.Scanner;

public class Nim{
    public static void main(String[] args){
        
        System.out.println("Welcome to Nim death match!");
        
        Scanner input = new Scanner(System.in);
        System.out.println("What difficulty level do you want to playt 1/2?");
        int level = input.nextInt();
        Game g = new Game(level);
        g.play();
        
        System.out.println("Thanks for playing!");
    }
}
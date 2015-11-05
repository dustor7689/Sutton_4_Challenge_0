/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sutton_4_guessinggame;

import java.util.Random;
import java.util.Scanner;

public class Sutton_4_GuessingGame {

    static String username;
    static int uguess;
    static int restart;
    static int magicnumber;
    static Random rand = new Random ();
    static boolean playagain;
    static int counter = 5;
    //the statics are shared with the entire program

    public static void main(String[] args) {
        playagain = true;
        Scanner name = new Scanner(System.in);
        Scanner guess = new Scanner(System.in);
        magicnumber = rand.nextInt(100);
        System.out.println("Hello, would you like to play a game?");
        System.out.println("What is your name?");
        username = name.nextLine();
        while (counter > 0) {
            thegame();
        }

    }

    public static void thegame() {
        while (playagain) {
            Scanner username = new Scanner(System.in);
            Scanner restart = new Scanner(System.in);
            System.out.println("Please pick a number between 1 and 100");
            uguess = username.nextInt();
            if (magicnumber == uguess) {
                System.out.println("You win!");
                counter--;
            } else if (uguess != magicnumber);
            {
                System.out.println("You lose!");
                counter--;
            }            
        }
    }
}

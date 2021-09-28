
/*
 *  UCF COP3330 Fall 2021 Exercise 32 Solution
 *  Copyright 2021 Timothy Azinord
 */

package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Let's play Guess the Number!\n");
        Scanner scan = new Scanner(System.in);
        String answer = "y";
        while (answer.equals("y")) {
            game();
            System.out.print("Do you wish to play again (Y/N)? ");
            answer = scan.next();
        }
    }
    public static void game() {
        System.out.print("Enter the difficulty level (1, 2, or 3): ");
        Scanner input = new Scanner(System.in);
        int diff = input.nextInt();
        Random value = new Random();
        int target = 0;


        if (diff == 1) {
            target = value.nextInt(11);
            target++; //so that target cannot be 0
        }
        if (diff == 2) {
            target = value.nextInt(101);
            target++;
        }
        if (diff == 3) {
            target = value.nextInt(1001);
            target++;
        }

        System.out.print("I have my number. What's your guess? ");
        int guess;
        int counter = 0;
        boolean e = true;
        while(e) {
            guess = input.nextInt();
            if (guess < target) {
                counter++;
                System.out.print("Too low. Guess again: ");
            }
            else if (guess > target) {
                counter++;
                System.out.print("Too high. Guess again: ");
            }
            else {
                e = false;
            }
        }
        System.out.printf("You got it in %d guesses!\n", counter + 1);
    }
}
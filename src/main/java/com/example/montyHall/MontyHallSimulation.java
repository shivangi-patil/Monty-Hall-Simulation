package com.example.montyHall;
import java.util.Random;
import java.util.Scanner;
public class MontyHallSimulation {
        public static void main(String[] args) {
            Scanner scan = new Scanner (System.in);
            Random generator = new Random();

            // Initialize Variables
            int user_door,
                    open_door,
                    other_door,
                    prize_door;

            // Generate random value 1-3
            prize_door = generator.nextInt(3)+1;
            open_door = prize_door;

            while(open_door == prize_door){
                open_door = generator.nextInt(3)+1;
            }

            other_door = open_door;

            while (other_door == open_door || other_door == prize_door){
                other_door = generator.nextInt(3)+1;
            }

            // Begin Game
            System.out.println("*** Welcome to the game show! ***");
            System.out.println("Select the door (1, 2, or 3): ");
            user_door = scan.nextInt();


            // User Validation
            if (user_door > 3 || user_door < 0) {
                System.out.println("Please select door 1, 2, or 3");
                user_door = scan.nextInt();
            } else if(user_door == 1 || user_door == 2 ||  user_door == 3) {

                //Continue Game
                System.out.println("\nIn a moment, I will show you where the prize is located,");
                System.out.println("but first I will show you what is behind one of the other doors");

                //Continue Dialogue
                System.out.println("\nBehind door number " + open_door + " are goats!");
                System.out.println("You selected door number " + user_door);
                System.out.println("\nWould you like to switch your door(y/n)? ");

                //User Input Yes or No
                char userReply = scan.next().charAt(0);

                //If statement with nested while statements for user input
                while(userReply != 'y' && userReply != 'n')
                {
                    //User Validation
                    System.out.println("Please enter either y/n");
                    userReply = scan.next().charAt(0);
                }
                if (userReply == 'y')
                {
                    user_door = other_door;
                }

                System.out.println("The prize is behind door number: " + prize_door);

                //Check to see if user won or lost
                if(user_door == prize_door){
                    System.out.println("Congratulations! You won the prize!");
                } else {
                    System.out.println("Sorry. You lost.");
                }

            }
        }

}

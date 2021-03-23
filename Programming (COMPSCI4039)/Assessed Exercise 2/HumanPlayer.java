/**
    This class implements the `HumanPlayer` class that extends from the `Player` class.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 2
*/

import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player {
    // MARK: - Attributes
    private Scanner userInput = null;

    // MARK: - Constructor
    /**
     The constructor of a `HumanPlayer` object.
     @param identifier The identifier character.
     */
    public HumanPlayer(char identifier) {
        super(identifier);
        userInput = new Scanner(System.in);
    }

    // MARK: - Game Logic Function
    /**
     The moving logic for HumanPlayer class is the only thing different from that of the Player class;
     thus, here we just override the `nextMoveGenerator` method to take user input.
     */
    public int nextMoveGenerator() {
        int count = 0;
        while (count > 6 || count < 1) {
            try {
                System.out.println("Please input a number between 1 and 6: ");
                count = userInput.nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Oops! It seems you didn't enter a number!");
                userInput.nextLine();   // Empty the inputs to take another input.
            }
        }
        return count;
    }
}

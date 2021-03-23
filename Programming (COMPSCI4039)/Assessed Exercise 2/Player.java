/**
    This class implements the `Player` class of the Snakes Ladders game.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 2
*/

import java.util.Random;

public class Player {
    public static void main(String[] args) {
        Player myPlayer = new Player('S');
        Square demoSquare = new Square(0);

        // Add the player to the player list of `Square`.
        demoSquare.addToPlayerList(myPlayer);

        System.out.println(myPlayer);
        System.out.println(demoSquare);
    }

    // MARK: - Attributes
    private char identifier;        // The identifying character of the `Player`.
    private Square position;        // The reference to the `Square` where the player is.

    // MARK: - Constructor
    /**
     The constructor of a `Player` object.
     @param identifier The identifier character.
     */
    public Player(char identifier) {
        this.identifier = identifier;
    }

    // MARK: - Getters & Setters
    public void setPosition(Square newPosition) {
        position = newPosition;
    }

    public char getIdentifier() {
        return identifier;
    }

    // MARK: - Overriding Function
    /**
     The toString method returns the identifier char as a `String`.
     */
    public String toString() {
        return ""+identifier;
    }

    // MARK: - Game Logic
    /**
     The moving handler function, taking reference to the Board to find the position to be moved.
     @param board Reference to the board where the Player is.
     */
    public boolean move(Board board) {
        int nextMove = nextMoveGenerator(), nextPosition = position.getPosition() + nextMove;
        System.out.println(this.toString() + " is at " + position.getPosition() + ".");
        if (nextPosition < board.getMax()) {
            Square newLocation = board.getSquare(nextPosition);
            // Handle delta until there is no more ladders or snakes in the new position.
            System.out.println(this.toString() + " is moving " + nextMove + " unit(s) ahead, to " + nextPosition + ".");
            while (newLocation.getDelta() != 0) {
                int delta = newLocation.getDelta();
                newLocation = board.getSquare(newLocation.getPosition() + delta);
                if (delta > 0) {
                    System.out.println("Oh! There is a ladder, " + this.toString() + " is moving to " + newLocation.getPosition());
                } else {
                    System.out.println("Uh-oh! There is a snake, " + this.toString() + " is moving to " + newLocation.getPosition());
                }
            }
            playerMoveHelper(newLocation);
        } else {
            // As the new position is over the max position in the map, so there must be a winner.
            // Therefore, just move that Player to the max square and declare winner.
            Square newLocation = board.getSquare(board.getMax());
            System.out.println(this.toString() + " is moving to the finishing line!");
            playerMoveHelper(newLocation);
            return true;
        }
        // There must not be a winner declared if this line is reached.
        return false;
    }

    // MARK: Helpers
    /**
     A helper function to generate the next move by returning a random number between 1 and 6.
     */
    public int nextMoveGenerator() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }

    /**
     A helper function to move the `Player` from the current square to the new `Square`.
     @param newPosition The square to be moved to.
     */
    private void playerMoveHelper(Square newPosition) {
        // Move character from the current position to new position.
        position.removePlayerFromList(this);
        newPosition.addToPlayerList(this);
        
        // Reference the square to the new position.
        position = newPosition;
    }
}

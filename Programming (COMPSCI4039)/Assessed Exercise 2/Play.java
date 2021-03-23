/**
    This class implements the starting point `Play` class of the Snakes Ladders game.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 2
*/

public class Play {
    public static void main(String[] args) {
        // Game Setup
        Board myBoard = new Board(10, 5);

        Player player1 = new Player('E');
        Player player2 = new HumanPlayer('S');

        // Add Players to the Board
        myBoard.addPlayer(player1);
        myBoard.addPlayer(player2);

        // Add deltas
        // This part I used a helper method to handle cases when the `Square` cannot be found.
        // If the specified `Square` is outside of the board, it would print an error message and return.

        // Add ladders
        safelyGetSquareAndSetDelta(myBoard, 18, 4);
        safelyGetSquareAndSetDelta(myBoard, 33, 2);

        // Add snakes
        safelyGetSquareAndSetDelta(myBoard, 15, -1);
        safelyGetSquareAndSetDelta(myBoard, 29, -4);
        safelyGetSquareAndSetDelta(myBoard, 30, -1);
        safelyGetSquareAndSetDelta(myBoard, 32, -4);
        safelyGetSquareAndSetDelta(myBoard, 34, -1);
        safelyGetSquareAndSetDelta(myBoard, 48, -3);
        
        // Game Start
        boolean gameEnds = false;
        while (!gameEnds) {
            gameEnds = myBoard.takeTurns();
        }

        // Annouce the winner
        System.out.println("Winner: " + myBoard.getSquare(myBoard.getMax()).getPlayerListString());
    }
    /**
     A helper method to get `Square` from `Board` and `setDelta`.
     When the `Square` cannot be found, it would print an error.
     @param board The reference to the `Board` object.
     @param position The position to be found.
     @param delta The delta value to be set.
     */
    private static void safelyGetSquareAndSetDelta(Board board, int position, int delta) {
        Square found = board.getSquare(position);
        if (found.getPosition() == -1) {
            System.err.println("Cannot find `Square` of position " + position + ", so delta cannot be set.");
        } else {
            found.setDelta(delta);
        }
    }
}

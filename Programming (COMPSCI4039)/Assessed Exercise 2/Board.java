/**
    This class implements the `Board` class of the Snakes Ladders game.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 2
*/

public class Board {
    public static void main(String[] args) {
        // Game setup
        Board board = new Board(10, 5);
        Player player1 = new Player('E');
        Player player2 = new Player('S');

        // Add Players to the board
        board.addPlayer(player1);
        board.addPlayer(player2);

        System.out.println(board);
    }

    // MARK: - Attributes
    private Player[] players;    // An array of players added to the game.
    private Square[][] map;      // The entire board stored in a 2D array of `Square` objects called the map.
                                 // The map is designed to have position 0 at the lower left of the map,
                                 // and the map will be mapped in the exact order as it should be printed.

    // MARK: Additional attributes for convenience 
    private int playerCount = 0; // The count of the players in the game.
    private int max;             // The largest `position` of `Square`.
    private int spacing = 0;     // The spaces in between items in the `Board` map.

    // MARK: - Constructor
    /**
     The constructor of the `Board` class.
     @param rows The rows of the map.
     @param cols The columns of the map.
     */
    public Board(int rows, int cols) {
        map = new Square[rows][cols];
        players = new Player[5];

        max = rows * cols - 1;

        int pos = 0;               // Keeps track of the position on the row
        int counter = 0;           // Keeps track of the progress of mapping, going up from 0 to `rows * cols - 1`.
        boolean signal = true;     // The signal to decide the direction of `Square` initialisation within the `map`.

        // Initialisation of map.
        // Starting from the lower-left of the entire map,
        // going right until the edge and go up and going in the opposite direction.
        // Repeat this until the 2D array is entirely mapped.
        
        // The outer loop goes from the last row (rows-1) to the first (0).
        for (int idx = rows - 1; idx >= 0; idx--) {
            signal = !signal;       // Switch the direction
            if (!signal)
                pos = 0;            // Start from left if `signal` is false
            else
                pos = cols - 1;     // Start from right if `signal` is true

            // The loop repeats until the row is entirely mapped.
            while (pos >= 0 && pos < cols) {
                map[idx][pos] = new Square(counter++);
                if (!signal) {
                    pos++;      // Go right if `signal` is false
                } else {
                    pos--;      // Go left if `signal` is true
                }
            }

        }
    }

    // MARK: - Getters & Setters
    /**
     This getter function returns the largest `position` of all the `Square` in map.
     */
    public int getMax() {
        return max;
    }
    
    /**
     Get the [row, col] pair of the target `Square` of the specified `int` position in the `map`.
     The `map` starts from the lower left corner of the map (position 0 at [map.length - 1, 0]).
     An array of length 0 would be returned in the case of nothing found.
     @param position The int position of the target `Square`.
     */
    public int[] getRowAndCol(int position) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (position == map[i][j].getPosition()) {
                    int[] output = {i,j};
                    return output;
                }
            }
        }
        return new int[0];
    }

    /**
     Get the `int` position of the specified `Square` at the row and column in the map.
     The map starts from the lower left corner of the map (position 0 at [map.length - 1, 0]).
     It will return -1 if nothing found.
     @param row The row of the `Square` in the `map`.
     @param col The column of the `Square` in the `map`.
     */
    public int getPosition(int row, int col) {
        if (row < map.length && col < map[0].length)
            return map[row][col].getPosition();
        
        return -1;
    }

    /**
     Get `Square` reference by passing in the `position` of the target `Square`.
     It is implemented by looking up the row & col with getRowAndCol and return the reference at that place.
     It will return a square with Position -1 if nothing found.
     @param position The int position of the target `Square`.
     */
    public Square getSquare(int position) {
        int[] rowcol = getRowAndCol(position);
        
        if (rowcol.length > 0)
            return map[rowcol[0]][rowcol[1]];

        return new Square(-1);   // Return a square with Position -1 if nothing found.
    }
    
    /**
     A method to add `Player` reference to the `Board`. It would add the `Player` to the beginning `Square` on the `map`, to the `players` array, and set the `Player` to reference to the `Square`.
     The map starts from the lower left corner of the map (position 0 at [map.length - 1, 0]).
     @param player The reference to the Player object to be added.
     */
    public void addPlayer(Player player) {
        // Prevent two Players with the same identifier to be added.
        for (int i = 0; i < playerCount; i++) {
            if (players[i].getIdentifier() == player.getIdentifier()) {
                System.err.println("Failed to add Player to the Board. You already have a Player named `" + player.getIdentifier() + "`.");
                return;
            }
        }
        
        // Extend player array if the array is filled up.
        if (playerCount >= players.length) {
            Player[] newList = new Player[players.length * 2];
            for (int i = 0; i < players.length; i++) {
                newList[i] = players[i];
            }
            players = newList;
        }

        // Player always starts at position 0, which is designed to be fixed at position [map.length - 1, 0]
        players[playerCount++] = player;                // Add player to the player list
        map[map.length - 1][0].addToPlayerList(player); // Add player to the map, at the starting position
        player.setPosition(map[map.length - 1][0]);     // Set player's reference to the square

        spacing = map[map.length-1][0].toString().length() + 1;    // Update the spacing for the format of the items to be printed.
    }

    // MARK: - Overriding Functions
    /**
     The toString method of the Board class returns a String representation of the Board map.
     Each Square was generated by the toString methods of the Square, formatted by a helper method.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                output += spacingMaker(map[i][j].toString());
            }
            output += "\n";
        }
        return output;
    }

    // MARK: Helpers
    /**
     A helper method to format and make the spaces between items when printed in the toString method.
     @param str The String to be formatted.
     */
    private String spacingMaker(String str) {
        String output = "";
        for (int i = 0; i < spacing - str.length(); i++) {
            output += " ";
        }
        return output + str;
    }

    // MARK: - Game Logic Function
    /**
     The method loops through all the `Players`. If any `Player` wins, it would return `true` immediately;
     otherwise, it would return `false` if no one wins in this round.
     */
    public boolean takeTurns() {
        for (int i = 0; i < playerCount; i++) {
            boolean playerWins = players[i].move(this);
            System.out.println(this);
            if (playerWins) {
                return true;
            }
        }
        return false;
    }
}

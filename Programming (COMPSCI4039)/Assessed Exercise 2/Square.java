/**
    This class implements the `Square` class of the Snakes Ladders game.

    Author: Yu-Sung Hsu
    Email: 2540296H@student.gla.ac.uk
    Student ID: 2540296H
    COMPSCI4039 Programming (IT) Assessed Exercise 2
*/

public class Square {
    // MARK: - Attributes
    private int position;           // The integer position.
    private Player[] playerList;    // The array of references to players on the `Square`.
    private int delta;              // The integer delta value.
    
    // MARK: Additional attributes for convenience 
    private int playerCount;        // The count of the players on the `Square`.
    
    // MARK: - Constructors
    /**
     A `Square` constructor if the `delta` is not yet decided (or 0) at the time of construction.
     @param position The position of the `Square` in the map.
     */
    public Square(int position) {
        this.position = position;
        this.delta = 0;
        playerList = new Player[5];
        playerCount = 0;
    }

    /**
     A overloaded `Square` constructor for the cases when a `delta` is decided at the time of construction.
     @param position The position of the `Square` in the map.
     @param delta The delta of the `Square`.
     */
    public Square(int position, int delta) {
        this.position = position;
        this.delta = delta;
        playerList = new Player[5];
        playerCount = 0;
    }

    // MARK: - Getters & Setters
    public int getPosition() {
        return position;
    }

    public void setDelta(int value) {
        delta = value;
    }

    public int getDelta() {
        return delta;
    }
    
    /**
     A method to add `Player` to `playerList` of the `Square`.
     @param player The reference to the Player object to be added.
     */
    public void addToPlayerList(Player player) {
        // Extend the array when the spaces are not enough.
        if (playerCount + 1 >= playerList.length) {
            Player[] newArray = new Player[playerList.length * 2];
            for (int i = 0, n = playerList.length; i < n; i++) {
                newArray[i] = playerList[i];
            }
            playerList = newArray;
        }
        playerList[playerCount++] = player;
    } 

    /**
     A method to remove a `Player` from the `playerList` of the `Square`.
     @param player The reference to the player to be removed.
     */
    public void removePlayerFromList(Player player) {
        Player[] newArray = new Player[playerList.length];
        int idx = 0;    // The index for the new array.
        // Copy all other items to the new array.
        for (int i = 0, n = playerCount; i < n; i++) {
            if (playerList[i].getIdentifier() != player.getIdentifier()) {
                newArray[idx++] = playerList[i];
            }
        }
        playerList = newArray;  // Replace the array with the new array.
        playerCount = idx;      // Replace the count with the count of copied items.
    }

    /**
     A method to get the `Player` list on the `Square` in `String` format.
     The returned string would be separated by commas if there are more than one `Player` on the `Square`.
     This is used to annouce the winner of the game (in the `Play` class) and in the toString method (of this class).
     */
    public String getPlayerListString() {
        String output = "";
        for (int i = 0; i < playerCount; i++) {
            output += playerList[i];
            if (i != playerCount - 1) {
                output += ",";
            }
        }
        return output;
    }

    // MARK: - Overriding Function
    /**
    The toString method would show the square in the format: `players position (delta)`
    */
    public String toString() {
        String output = "";

        output += this.getPlayerListString();
        output += String.format("%3d", position);

        // The `delta` would be empty if it equals to 0
        if (delta != 0) {
            output += String.format("(%3d)", delta);
        } else {
            output += "(   )";
        }

        return output;
    }
}

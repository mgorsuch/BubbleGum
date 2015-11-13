/**
 * The programmatic interface for the Battleship Model class.
 * This interface supports communication with both the view
 * and controller classes in the Battleship application.
 * 
 * @author Michael Gorsuch
 * @author Anne Thorsteinson
 * @author Joe McLaughlin
 * @author Brandon Heinrich
 */
public interface BattleshipModelInterface {
    
     /**
     * Clears the board to get ready for new game, resets current turn to
     * Player 1, resets counters for ships to zero, switches mode to setup mode,
     * clears ship array objects
     */
	public void resetGame();	
	
     /**
     * Places Battleships on board in Setup mode, fills ship array objects
     * with location coordinates
     * @param  row the character of the row
     * @param  column the number of the column
     * @param  direction for ship placement, see the direction constants
     * @throws IllegalStateException The game is not in setup Mode
     */
	public void placeBattleShips(char row, int column, Direction direction);

     /**
     * Checks that coordinates are valid for ship placement.
     * @param  row the character of the row
     * @param  column the number of the column
     * @param direction for ship placement, see the direction constants
     * @return true if ship placement is valid	
     * @throws IllegalStateException The game is not in setup Mode
     */
     public boolean validateShipPlacement(char row, int column, Direction direction);

     /**
     * Keeps track of the current player.
     * @return true if Player 1 (false if Player 2)
     */
     public boolean player1Turn();
	
     /**
     * Makes a shot during Play Mode.
     * @param  row the row of shot
     * @param  column the column of the shot
     * @return the status of the shot, see the status constants 
     * @throws IllegalStateException The game is not in Play Mode
     */
     public int void makeShot(char row, int column);

     /**
     * Checks that coordinates are valid for a new shot.
     * @param  row the character of the shot
     * @param  column the column of the shot
     * @return true if shot is valid	
     * @throws IllegalStateException if the game is not in play mode
     */
     public boolean validateShot(char row, int column);
	
     /**
     * Checks if a ship has been sunk, increments counter if ship is sunk
     * @param ship to check status of
     * @throws IllegalStateException if the game is not in play mode
     */
     public boolean isShipSunk(Ship theShip);
	
     /**
     * Checks if the game has been won
     * @throws IllegalStateException if the game is not in play mode 
     */
     public boolean isGameOver();

     /**
     * Returns the winner of the game
     * @throws IllegalStateException if game is not over
     * @throws IllegalStateException if game is not in play mode
     */
     public String gameWinner();
	 
}

/**
 * Helper enumerated type for the direction of placement.
 * The direction will determine the method and tests for legality
 * when placing the ship.
 */
 enum Direction {
     //place ship horizonally
     NORTH,
     //place ship vertically
     SOUTH,
     //place ship diagonally upwards
     NW,
     //place ship diagonally downwards}
     SW
}

/**
 * Helper enumerated type for the status of the shot.
 */
 enum Status {
     //return status for miss
     MISS,
     //return status for hit
     HIT,
     //return status for last hit on aircraft carrier
     SUNK_AC,
     //return status for last hit on Battleship
     SUNK_B,
     //return status for last hit on a Cruiser
     SUNK_C,
     //return status for last hit on Destroyer1
     SUNK_D1,
     //return status for last hit on Destroyer2
     SUNK_D2
 }
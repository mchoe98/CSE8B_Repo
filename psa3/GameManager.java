/* File Header:
 * This file contains methods that setup the game board.
 * This file also contains the method that actually
 * plays the game.
 *
 * Mark Choe
 * A13917840
 * mychoe@ucsd.edu
 *
 * Class Header:
 * The purpose of this class is to setup the game
 * and allow it to be played.
 */ 

import java.util.*;
import java.io.*;

public class GameManager {
    // Instance variables
    private Board board; // The actual 2048 board
    private String outputBoard; // File to save the board to when exiting

    /*ec*/
    private String outputRecord; // file to save the record file, format: [size] wasdwasdwasdawsd
    StringBuilder history = new StringBuilder(); // a string of commands history
    /*ce*/


    // TODO PSA3
    // GameManager Constructor
    // Generate new game
    // Input: the file to be saved to once the game is exited, the size of the
    // board, and a random object
    // Return: a new game board
    public GameManager(String outputBoard, int boardSize, Random random){
      this.board = new Board(random, boardSize);
      this.outputBoard = outputBoard;
      System.out.println(board);
    }

    // TODO PSA3
    // GameManager Constructor
    // Load a saved game
    // Input: the file to be saved to once the game is exited, the file with
    // the saved board, and a random object
    // Return: a loaded game board
    public GameManager(String inputBoard, String outputBoard, Random random) throws IOException {
      this.board = new Board(random, inputBoard);
      this.outputBoard = outputBoard;
      System.out.println(board);
    }

    
    // TODO PSA3
    // Main play loop
    // Takes in input from the user to specify moves to execute
    // valid moves are:
    //      w - Move up
    //      s - Move Down
    //      a - Move Left
    //      d - Move Right
    //      q - Quit and Save Board
    //
    //  If an invalid command is received then print the controls
    //  to remind the user of the valid moves.
    //
    //  Once the player decides to quit or the game is over,
    //  save the game board to a file based on the outputBoard
    //  string that was set in the constructor and then return
    //
    //  If the game is over print "Game Over!" to the terminal
    //  Input: N/A
    //  Return: N/A
    public void play() throws Exception {
      // Printing the controls
      printControls(); 
      // Game Over?
      if (board.isGameOver() == true){
        System.out.println("Game Over!");
        board.saveBoard(outputBoard);
        return;
      }
      int count = 0;
      Scanner input = new Scanner(System.in);
      while(count < 1){
        char letter = input.next().charAt(0);
        // Moving the tiles and adding a random tile
        if (letter == 'w' &&
            board.move(Direction.UP)==true){
          board.move(Direction.UP);
          board.addRandomTile();
          System.out.println(board);
        } else if (letter == 's' &&
                   board.move(Direction.DOWN)==true){
          board.move(Direction.DOWN);
          board.addRandomTile();
          System.out.println(board);
        } else if (letter == 'a' &&
                   board.move(Direction.LEFT)==true){
          board.move(Direction.LEFT);
          board.addRandomTile();
          System.out.println(board);
        } else if (letter == 'd' &&
                   board.move(Direction.RIGHT)==true){
          board.move(Direction.RIGHT);
          board.addRandomTile();
          System.out.println(board);
        }
        // Quitting the game
        else if (letter == 'q'){
          board.saveBoard(outputBoard);
          return;
        }
        // Printing the controls
        else {
          System.out.println(board);
          printControls();
        } 
      }
    }

    // Print the Controls for the Game
    private void printControls() {
        System.out.println("  Controls:");
        System.out.println("    w - Move Up");
        System.out.println("    s - Move Down");
        System.out.println("    a - Move Left");
        System.out.println("    d - Move Right");
        System.out.println("    q - Quit and Save Board");
        System.out.println();
    }
}

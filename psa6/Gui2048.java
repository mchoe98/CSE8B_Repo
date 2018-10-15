/* File Name:
 * This file creates the GUI for the 2048 game.
 * This file contains methods to setup the starting board display,
 * check to see whether the game is over or not, and matches the 
 * GUI to the hidden board.
 *
 * Mark Choe
 * mychoe@ucsd.edu
 *
 * Class Header:
 * The purpose of this class is to create the GUI for the 2048 game.
 * Important instance variables for this class are "scene", "stage",
 * and "gameOver" because these variables are used to create the 
 * game over stack pane and prevent further inputs once the game is
 * over.
 */
import javafx.application.*;
import javafx.scene.control.*;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.layout.*;
import javafx.stage.*;
import javafx.event.*;
import javafx.scene.input.*;
import javafx.scene.text.*;
import javafx.geometry.*;
import java.util.*;

import java.io.*;

public class Gui2048 extends Application
{
   private String outputBoard; // The filename for where to save the Board
   private Board board; // The 2048 Game Board

   private GridPane pane;

   /** Add your own Instance Variables here */
   private Scene scene;
   private Stage stage;
   private boolean gameOver;

   /** This method creates the starting board for the game
    * @param: The stage to place the scene and stage in
    * @return: N/A
    * */
   @Override
      public void start(Stage primaryStage)
      {
         // Process Arguments and Initialize the Game Board
         processArgs(getParameters().getRaw().toArray(new String[0]));

         // Create the pane that will hold all of the visual objects
         pane = new GridPane();
         pane.setAlignment(Pos.CENTER);
         pane.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
         pane.setStyle("-fx-background-color: rgb(187, 173, 160)");
         // Set the spacing between the Tiles
         pane.setHgap(15); 
         pane.setVgap(15);

         /** Add your Code for the GUI Here */
         //Adding the game title
         Text title = new Text("2048");
         title.setFont(Font.font("Times New Roman",
                  FontWeight.BOLD, FontPosture.ITALIC, 50));
         title.setFill(Color.BLACK);
         GridPane.setHalignment(title, HPos.CENTER);
         pane.add(title,0,0,2,1); 
         //Adding the score display
         Text scoreTxt = new Text("Score: " + board.getScore());
         scoreTxt.setFont(Font.font("Times New Roman",
                  FontWeight.BOLD, FontPosture.ITALIC, 30));
         scoreTxt.setFill(Color.BLACK);
         GridPane.setHalignment(scoreTxt, HPos.CENTER);
         pane.add(scoreTxt,board.getGrid()[0].length-2,0,2,1);      
         //Adding the tiles
         for (int row = 0; row < board.getGrid()[0].length; row++){
            for (int column = 0; column < board.getGrid()[row].length;
            column++){
               // Handling Rectangles
               Rectangle rectangle = new Rectangle();
               rectangle.setWidth(100);
               rectangle.setHeight(100);
               // Selecting the Color of the Rectangle
               Color color;
               switch(board.getGrid()[row][column]){
                  case 0:
                     color = Constants2048.COLOR_EMPTY; break;
                  case 2:
                     color = Constants2048.COLOR_2; break;
                  case 4:
                     color = Constants2048.COLOR_4; break;
                  case 8:
                     color = Constants2048.COLOR_8; break;             
                  case 16:
                     color = Constants2048.COLOR_16; break;            
                  case 32:
                     color = Constants2048.COLOR_32; break;            
                  case 64:
                     color = Constants2048.COLOR_64; break;
                  case 128:
                     color = Constants2048.COLOR_128; break;
                  case 256:
                     color = Constants2048.COLOR_256; break;
                  case 512:
                     color = Constants2048.COLOR_512; break;
                  case 1024:
                     color = Constants2048.COLOR_1024; break;
                  case 2048:
                     color = Constants2048.COLOR_2048; break;
                  default:
                     color = Constants2048.COLOR_OTHER; break;
               }
               rectangle.setFill(color);
               pane.add(rectangle,column,1+row);
               // Text
               String number= new String
               (Integer.toString(board.getGrid()[row][column]));
               if (board.getGrid()[row][column] == 0){
                  number = "";
               }
               if (board.getGrid()[row][column] < 8){
                  color = Constants2048.COLOR_VALUE_DARK;
               } else {
                  color = Constants2048.COLOR_VALUE_LIGHT;
               }
               Text text = new Text(number);
               text.setFont(Font.font("Times New Roman",
                        FontWeight.BOLD, 30));
               text.setFill(color);
               GridPane.setHalignment(text, HPos.CENTER);
               pane.add(text,column,1+row);
            }
         }
         // Setting up the scene and stage to display
         this.stage = primaryStage;
         Scene myScene = new Scene(pane);
         this.scene = myScene;
         primaryStage.setTitle("Gui2048");
         primaryStage.setScene(myScene);
         primaryStage.show();

         myScene.setOnKeyPressed(new KeyHandler());
      }

   /** This method matches the GUI to the board
    * @param: N/A
    * @return: N/A
    * */
   private void updateGUI(){
      pane.getChildren().clear();
      //Adding the game title
      Text title = new Text("2048");
      title.setFont(Font.font("Times New Roman",
               FontWeight.BOLD, FontPosture.ITALIC, 50));
      title.setFill(Color.BLACK);
      GridPane.setHalignment(title, HPos.CENTER);
      pane.add(title,0,0,2,1); 
      //Adding the score display
      Text scoreTxt = new Text("Score: " + board.getScore());
      scoreTxt.setFont(Font.font("Times New Roman",
               FontWeight.BOLD, FontPosture.ITALIC, 30));
      scoreTxt.setFill(Color.BLACK);
      GridPane.setHalignment(scoreTxt, HPos.CENTER);
      pane.add(scoreTxt,board.getGrid()[0].length-2,0,2,1);      
      //Adding the tiles
      for (int row = 0; row < board.getGrid()[0].length; row++){
         for (int column = 0; column < board.getGrid()[row].length;
         column++){
            // Handling Rectangles
            Rectangle rectangle = new Rectangle();
            rectangle.setWidth(100);
            rectangle.setHeight(100);
            // Selecting the Color of the Rectangle
            Color color;
            switch(board.getGrid()[row][column]){
               case 0:
                  color = Constants2048.COLOR_EMPTY; break;
               case 2:
                  color = Constants2048.COLOR_2; break;
               case 4:
                  color = Constants2048.COLOR_4; break;
               case 8:
                  color = Constants2048.COLOR_8; break;             
               case 16:
                  color = Constants2048.COLOR_16; break;            
               case 32:
                  color = Constants2048.COLOR_32; break;            
               case 64:
                  color = Constants2048.COLOR_64; break;
               case 128:
                  color = Constants2048.COLOR_128; break;
               case 256:
                  color = Constants2048.COLOR_256; break;
               case 512:
                  color = Constants2048.COLOR_512; break;
               case 1024:
                  color = Constants2048.COLOR_1024; break;
               case 2048:
                  color = Constants2048.COLOR_2048; break;
               default:
                  color = Constants2048.COLOR_OTHER; break;
            }
            rectangle.setFill(color);
            pane.add(rectangle,column,1+row);
            // Text
            String number= new String(Integer.toString
            (board.getGrid()[row][column]));
            if (board.getGrid()[row][column] == 0){
               number = "";
            }
            if (board.getGrid()[row][column] < 8){
               color = Constants2048.COLOR_VALUE_DARK;
            } else {
               color = Constants2048.COLOR_VALUE_LIGHT;
            }
            Text text = new Text(number);
            text.setFont(Font.font("Times New Roman",
                     FontWeight.BOLD, 30));
            text.setFill(color);
            GridPane.setHalignment(text, HPos.CENTER);
            pane.add(text,column,1+row);
         }
      }
   }

   /** This method checks to see whether or the game is over
    * and displays a game over screen if so
    * @param: N/A
    * @return: N/A
    * */
   private void checkGameOver(){
      if (board.canMove(Direction.UP)==false &&
            board.canMove(Direction.DOWN)==false &&
            board.canMove(Direction.LEFT)==false &&
            board.canMove(Direction.RIGHT)==false){
         gameOver = true;
         // Starting the stack pane with the grid pane
         StackPane stack = new StackPane();
         stack.setAlignment(Pos.CENTER);
         stack.getChildren().add(pane);
         // Game Over Screen Color
         Rectangle rectangle = new Rectangle();
         rectangle.setWidth(pane.getWidth());
         rectangle.setHeight(pane.getHeight());
         rectangle.setFill(Constants2048.COLOR_GAME_OVER);
         stack.getChildren().add(rectangle);
         // Game Over Text
         Text text = new Text("Game Over!");
         text.setFont(Font.font("Times New Roman",
                  FontWeight.BOLD, 60));
         text.setFill(Constants2048.COLOR_VALUE_DARK);
         GridPane.setHalignment(text, HPos.CENTER);
         stack.getChildren().add(text);
         // Displaying the stack pane
         scene = new Scene(stack);
         stage.setScene(scene);
         stage.show();
      }
   }

   private class KeyHandler implements EventHandler<KeyEvent>{
      /** This method allows for the user's inputs to affect the game
       * @param: the KeyEvent that gets the user's inputs
       * @return: N/A
       * */
      @Override
         public void handle(KeyEvent e){
            switch(e.getCode()){
               case UP: if (board.move(Direction.UP)==true
                              && gameOver == false){
                           board.addRandomTile();
                           System.out.println("Moving Up");
                           updateGUI();
                           checkGameOver();
                           break;
                        }else{
                           break;
                        }
               case DOWN: if (board.move(Direction.DOWN)==true
                                && gameOver == false){
                             board.addRandomTile();
                             System.out.println("Moving Down");
                             updateGUI();
                             checkGameOver();
                             break;
                          }else{
                             break;
                          }
               case LEFT: if (board.move(Direction.LEFT)==true
                                && gameOver == false){
                             board.addRandomTile();
                             System.out.println("Moving Left");
                             updateGUI();
                             checkGameOver();
                             break;
                          }else{
                             break;
                          }
               case RIGHT: if (board.move(Direction.RIGHT)==true
                                 && gameOver == false){
                              board.addRandomTile();
                              System.out.println("Moving Right");
                              updateGUI();
                              checkGameOver();
                              break;
                           }else{
                              break;
                           }
               case S: try {
                          System.out.println("M");
                          board.saveBoard(outputBoard);
                       } catch (IOException e2) { 
                          System.out.println("saveBoard threw an Exception");
                       }
                       break;
               default: break;
            }
         }
   }

   /** Add your own Instance Methods Here */

   /** DO NOT EDIT BELOW */

   // The method used to process the command line arguments
   private void processArgs(String[] args)
   {
      String inputBoard = null;   // The filename for where to load the Board
      int boardSize = 0;          // The Size of the Board

      // Arguments must come in pairs
      if((args.length % 2) != 0)
      {
         printUsage();
         System.exit(-1);
      }

      // Process all the arguments 
      for(int i = 0; i < args.length; i += 2)
      {
         if(args[i].equals("-i"))
         {   // We are processing the argument that specifies
            // the input file to be used to set the board
            inputBoard = args[i + 1];
         }
         else if(args[i].equals("-o"))
         {   // We are processing the argument that specifies
            // the output file to be used to save the board
            outputBoard = args[i + 1];
         }
         else if(args[i].equals("-s"))
         {   // We are processing the argument that specifies
            // the size of the Board
            boardSize = Integer.parseInt(args[i + 1]);
         }
         else
         {   // Incorrect Argument 
            printUsage();
            System.exit(-1);
         }
      }

      // Set the default output file if none specified
      if(outputBoard == null)
         outputBoard = "2048.board";
      // Set the default Board size if none specified or less than 2
      if(boardSize < 2)
         boardSize = 4;

      // Initialize the Game Board
      try{
         if(inputBoard != null)
            board = new Board(new Random(), inputBoard);
         else
            board = new Board(new Random(), boardSize);
      }
      catch (Exception e)
      {
         System.out.println(e.getClass().getName() + 
               " was thrown while creating a " +
               "Board from file " + inputBoard);
         System.out.println("Either your Board(String, Random) " +
               "Constructor is broken or the file isn't " +
               "formated correctly");
         System.exit(-1);
      }
   }

   // Print the Usage Message 
   private static void printUsage()
   {
      System.out.println("Gui2048");
      System.out.println("Usage:  Gui2048 [-i|o file ...]");
      System.out.println();
      System.out.println("  Command line arguments come in pairs of the "+ 
            "form: <command> <argument>");
      System.out.println();
      System.out.println("  -i [file]  -> Specifies a 2048 board that " + 
            "should be loaded");
      System.out.println();
      System.out.println("  -o [file]  -> Specifies a file that should be " + 
            "used to save the 2048 board");
      System.out.println("                If none specified then the " + 
            "default \"2048.board\" file will be used");  
      System.out.println("  -s [size]  -> Specifies the size of the 2048" + 
            "board if an input file hasn't been"); 
      System.out.println("                specified.  If both -s and -i" + 
            "are used, then the size of the board"); 
      System.out.println("                will be determined by the input" +
            " file. The default size is 4.");
   }
}

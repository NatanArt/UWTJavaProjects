/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 1
* 
* File Name:   WhereIsWaldo.java
*/
import java.util.Random;

/**
* This class is intended to be used with the PlayWaldoGame.java file 
* which is a driver program in which two players will be able to take 
* turns guessing at Waldo's location by choosing a row and a seat. The  
* below example shows what an auditorium with 5 rows and 4 seats could 
* look like.
*   E   D   C   B   A     |S|
*   (  |(  |(  |(  |(  |  |T| <-1
*   (  |(  |(  |(  |(  |  |A| <-2
*   (  |(  |(  |(  |(  |  |G| <-3
*   (  |(  |(  |(  |(  |  |E| <-4
* In the above auditorium indices [0][0] will be Row A and seat number 1. 
* Rows are marked aplhabetically with letters and each row has seats that
* are numbered in ascending order starting from where the letter appears.
* 
* This program is a class that represents Waldo hiding in a seat in an
* auditorium which the program will output for the player to see. 
* The auditormium will appear blank at first as seen above, and then the
* empty seats will be filled in with their player number once
* it has been guessed by a player. Once a person finds the seat with Waldo 
* the character "W" will be displayed and the player who guessed his
* location will be named the winner. 
*
* @author Natan Artemiev
* @version 8 April 2023
*/
public class WhereIsWaldo {
   /**
   * An array that can store characters to mark certain seats in the 
   * auditorium. For example,  we assin 'W' to the cell where Waldo is 
   * hiding and we assign '1' and '2' to the seats that a certain player
   * has guessd (Player 1 or Player 2). 
   */
   private char myAuditorium[][];
   
   /**
   * This stores Waldo's row location in our auditorium.
   */
   private int myRowLocation;
   
   /**
   * This stores Waldo's seat location in our auditorium.
   */
   private int mySeatLocation;
   
   /**
   * This stores the character that represents the number of the winning 
   * player.
   */
   private char myWinner;
   
   /**
   * This indicates if Waldo has been found. 
   */ 
   private boolean myFound = false;
   
   /**
   * Where is Waldo is a constructor method. It's purpose is to construct
   * the WhereIsWaldo game. To complete this it must instantiate the 
   * myAuditorium array with the parameters of theRows and theSeats  
   * (I had to flip these to give the array the correct bounds according
   * to the instructions). 
   * It also has to set each cell to the char ' ', and for this purpose
   * I decided to use the Row Major Access Paradigm to do this. It also
   * sets myRowLocation and mySeatLocation to a random value between 0
   * and the given bounds (theRows and theSeats respectively). This is
   * why we instantiate a new Random object at the top of the contructor.
   * Next we assign the myAuditorium cell at 
   * [myRowLocation][mySeatLocation] to be 'W' for where Waldo is hiding.
   * Finally we assing myWinner to ' ' for now and myFound to false since
   * Waldo has not yet been found.
   *
   * @param theSeats (Holds the number of Rows that the player wants. I
   *                  had to flip these becuase of a specific parameter
   *                  order the instructions required for the  
   *                  myAuditorium cells)
   * @param theRows (Holds the number of Seats that the player wants. I
   *                 had to flip these becuase of a specific parameter
   *                 order the instructions required for the myAuditorium
   *                 cells.)
   * 
   *
   */
   public WhereIsWaldo(int theSeats, int theRows) {
     Random rand = new Random();
     myAuditorium = new char[theRows][theSeats];
     
     for (int row = 0; row < myAuditorium.length; row++) {
       for (int col = 0; col < myAuditorium[row].length; col++) {
         myAuditorium[row][col] = ' ';
       } 
     } 
     
     myRowLocation = rand.nextInt(theRows);
     mySeatLocation = rand.nextInt(theSeats);
     
     myAuditorium[myRowLocation][mySeatLocation] = 'W';
     
     myWinner = ' ';
     
     myFound = false;
   }
   
   /**
   * This method checks to see if a seat has already been searched and
   * will return true if it has. False otherwise.
   * 
   * @param theRow holds the char that represents the row the player
   *               wants to search.
   * @param theSeat holds the seat number that the player wants to 
   *                guess.
   *
   * @return true if the seat has already been searched and
   *         false if it has not.
   */
   public boolean seatSearchedAlready(char theRow, int theSeat) {
      int rowIndex = (int) theRow - 65;
      theSeat -= 1;
      
      if (myAuditorium[theSeat][rowIndex] == '1'|| 
          myAuditorium[theSeat][rowIndex] == '2') {
            return true;
          }
      else {
         return false;
      }
   }
   
   /**
   * waldoLocation checks if the given row and seat is the same as
   * Waldo's hiding place. Returns true if it is and false otherwise.
   *
   * @param theRow holds the char that represents the row the player
   *               wants to search.
   * @param theSeat holds the seat number that the player wants to 
   *                guess. 
   *
   * @return true if the seat has already been searched and
   *         false if it has not.
   */
   public boolean waldoLocation(char theRow, int theSeat) {
      int rowIndex = (int) theRow - 65;
      theSeat -= 1;
      
      if (myAuditorium[theSeat][rowIndex] == 'W') {
         return true;
      }
      else {
         return false;
      }
   }
   
   /**
   * indicesOK checks to see if the row and seat fall within the bounds 
   * of the array. Return false if the indices are out of bounds, true 
   * if the indices are OK.
   *
   * @param theRow holds the char that represents the row the player
   *               wants to search.
   * @param theSeat holds the seat number that the player wants to 
   *                guess. 
   *
   * @return true if the indices fall within array bounds, false
   * otherwise.
   */
   public boolean indicesOK(char theRow, int theSeat) {
      int rowIndex = (int) theRow - 65;
      theSeat -= 1;
      if (rowIndex < 0 || rowIndex >= myAuditorium[0].length) {
         return false;
      } else if (theSeat < 0 || theSeat >= myAuditorium.length) {
         return false;
      } else {
         return true;
      }
   }
   
   /**
   * Getter method that returns the number of rows (actually columns!) in
   * myAuditorium.
   *
   * @return the number of columns in myAuditorium.
   */
   public int numberOfRows() {
      return myAuditorium[0].length;
   }
   
   /**
   * Getter method that returns the number of seats (actually rows!) in
   * myAuditorium.
   *
   * @return the number of rows in myAuditorium.
   */
   public int numberOfSeats() {
      return myAuditorium.length;
   }
   
   /**
   * serachSeat is a method that allows the player to search an in
   * myAuditorium by passing in a Row letter and seat number. This 
   * will check the index of those numbers to see if Waldo is there.
   * if so the player is set as the winner, myFound is set to true, and
   * we return true. Otherwise, the myAuditorium index is set to 
   * thePlayer and we reutrn false.
   *
   * @param theRow holds the char that represents the row the player
   *               wants to search.
   * @param theSeat holds the seat number that the player wants to 
   *                guess.
   * @param thePlayer holds the char that represents the player number.
   *
   * @return true if myAuditorium index at [theSeat][rowIndex] is true.
   *         false if otherwise.
   */
   public boolean searchSeat(char theRow, int theSeat, char thePlayer) {
      int rowIndex = (int) theRow - 65;
      theSeat -= 1;
      if (myAuditorium[theSeat][rowIndex] == 'W') {
         myWinner = thePlayer;
         myFound = true;
         return true;
      }
      else {
         myAuditorium[theSeat][rowIndex] = thePlayer;
         return false;
      }
   }
   
   /**
   * toString method that print out myAuditorium cell values in a
   * certain formatting so that players can see what they have guessed.
   *
   * @return formatted string containg myAuditorium cell values.
   */
   public String toString() {
      String EqualsSigns = "";
      for (int i = 0; i  < myAuditorium[0].length; i++) {
         EqualsSigns += "====";
      }
      
      String auditoriumBody = "";
      for (int row = 0; row < myAuditorium.length; row++) {
         for (int col = myAuditorium[0].length - 1; col >= 0 ; col--) {
            if (myAuditorium[row][col] == 'W' && myFound == false) {
               myAuditorium[row][col] = ' ';
               auditoriumBody += "(" + myAuditorium[row][col] + " |";
               myAuditorium[row][col] = 'W';
            }
            else if (myAuditorium[row][col] == 'W' && myFound == true){
               auditoriumBody += "(" + myAuditorium[row][col] + 
                                 myWinner + "|";
            }
            else {
               auditoriumBody += "(" + myAuditorium[row][col] + " |";
            } 
         }
         
         auditoriumBody += "\n";
      }

      return EqualsSigns + "\n" + auditoriumBody + EqualsSigns;
   }
}

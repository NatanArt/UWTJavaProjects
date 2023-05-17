/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Frog.java
*/

/**
* The Frog class represents the frog animal. It extends Abstract Critter.
* Frogs tend to move in the same direction for a while and then change. And
* they can never be killed by rocks.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Frog extends AbstractCritter {
   
   /**
   * This field represents the current direction of the object.
   */
   private int myDirection;
   
   /**
   * This stores an int that helps us to count to a certain target. 
   * This will help us space out events or put a limit on some action.
   */
   private int myCount;
   
   /**
   * This method constructs a Frog object and calls the super class with a
   * char to represent the Frog on the panel, so that we can identify it. It
   * also set all of our fields to the appropriate starting values.
   */
   public Frog() {
      super('F');
      myDirection = CENTER;
      myCount = 0;
   }
   
   /**
   * The getMove method provides the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This method
   * simulates how a frog moves by changing it's direction with each call in a
   * particular pattern.
   * 
   * @param theInfo is a class that contains information about this particular
   *                critter. Used in this method to check if there is a stone
   *                in the direction we are moving, and if there is we stop.
   *
   * @return the next direction based on certian criteria.
   */
   public int getMove(CritterInfo theInfo) {
      
      double randomVal;
      int result = 0;
     
      if (myCount == 0) {
         randomVal = Math.random();
         if (randomVal < 0.25) {
            myDirection = NORTH;
         }
         else if (randomVal < 0.5 && randomVal > 0.25) {
            myDirection = SOUTH;         
         }
         else if (randomVal < 0.75 && randomVal > 0.5) {
            myDirection = EAST;
         }
         else {
           myDirection = WEST;
         }
       }
         
       myCount++;     
       if (myCount == 3) {
            myCount = 0;
       }
         
       if (theInfo.getNeighbor(myDirection) == 'S') {
            result = CENTER;
       }
       else {
         result = myDirection;
       }
      return result;
   }
}
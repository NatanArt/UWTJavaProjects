/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Wolf.java
*/

/**
* The Wolf class represents the wolf animal. It extends Abstract Critter.
* Wolf tend to move in packs so all wolf object move in sync, in "rings"
* that expand further and further.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Wolf extends AbstractCritter {
   
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
   * Holds a bool that toggles when the direction changes.
   */
   private boolean myFirst;
   
   /**
   * An int that represents a target value that myCount must reach.
   */
   private int myTarget;
   
   /**
   * This method constructs a Wolf object and calls the super class with a
   * char to represent the Wolf on the panel, so that we can identify it. It
   * also set all of our fields to the appropriate starting values.
   */
   public Wolf() {
      super('W');
      myDirection = EAST;
      myCount = 0;
      myFirst = true;
      myTarget = 1;
   }
   
   /**
   * The getMove method provides the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This method
   * simulates how a Wolf moves by changing it's direction with each call 
   * in a particular pattern.
   * 
   * @param theInfo is a class that contains information about this particular
   *                critter. Not used in this method.
   *
   * @return the next direction based on certain criteria.
   */
   public int getMove(CritterInfo theInfo) {
      int direction = myDirection;
      myCount++;
      if (myCount == myTarget) {
         if (!myFirst) {
            myTarget++;
         }
         myFirst = !myFirst;
         myCount = 0;
         if (myDirection == NORTH) {
            myDirection = EAST;
         }
         else if (myDirection == EAST) {
            myDirection = SOUTH;
         }
         else if (myDirection == SOUTH) {
            myDirection = WEST;
         }
         else if (myDirection == WEST) {
            myDirection = NORTH;
         }
      }
      return direction;
   }
}
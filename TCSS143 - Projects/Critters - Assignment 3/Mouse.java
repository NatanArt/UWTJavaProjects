/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Mouse.java
*/

import java.util.Random;

/**
* The Mouse class represents the mouse animal. It extends Abstract Critter.
* Mice tend to move in a diagonal direction (i.e. NorthWest) and will change
* direction at random intervals.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Mouse extends AbstractCritter {
   
   /**
   * This field holds an object of type Random. Will be used to
   * generate random numbers.
   */
   private Random random;
   
   /**
   * An int that represents a target value that myCount must reach.
   */
   private int myTarget;
   
   /**
   * Holds a bool that represents whether this is our first time moving or not.
   */
   private boolean myFirst;
   
   /**
   * Holds the int value of the next direction.
   */
   private int myNewDirection;
   
   /**
   * Holds the int value of my first direction.
   */
   private int myDirection1;
   
   /**
   * Holds the int value of my second direction, which will be set based on
   * on my first direction.
   */
   private int myDirection2;
   
   /**
   * This stores an int that helps us to count to a certain target. 
   * This will help us space out events or put a limit on some action.
   */
   private int myCount;
   
   /**
   * This method constructs a Mouse object and calls the super class with a
   * char to represent the Mouse on the panel, so that we can identify it. It
   * also set all of our fields to the appropriate starting values.
   */
   public Mouse() {
      super('M');
      random = new Random();
      myTarget = 6 + random.nextInt(19);
      myFirst = true;
      myDirection1 = random.nextInt(CENTER);
      myDirection2 = 0;
      myNewDirection = 0;
      myCount = 0;     
   }
   
   /**
   * The getMove method provides the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This method
   * simulates how a Mouse moves by changing it's direction with each call in a
   * particular pattern.
   * 
   * @param theInfo is a class that contains information about this particular
   *                critter. Not used in this method.
   *
   * @return the next direction based on certain criteria.
   */
   public int getMove(CritterInfo theInfo) {
      
      if (myCount == myTarget) {
         myCount = 0;
         myTarget = 6 + random.nextInt(29);
         myDirection1 = random.nextInt(CENTER);
         myFirst = true;
      }
      
      if (myDirection1 == NORTH) {
         myDirection2 = WEST;
      }
      else if (myDirection1 == WEST) {
         myDirection2 = SOUTH;
      }
      else if (myDirection1 == SOUTH) {
         myDirection2 = EAST;
      }
      else if (myDirection1 == EAST) {
         myDirection2 = NORTH;
      }
      
      if (myDirection1 == NORTH && myDirection2 == WEST) {
         if (myFirst) {
            myNewDirection = NORTH;
         }
         else if (myNewDirection == NORTH) {
            myNewDirection = WEST;
         }
         else if (myNewDirection == WEST) {
            myNewDirection = NORTH;
         }
      }
      else if (myDirection1 == WEST && myDirection2 == SOUTH) {
         if (myFirst) {
            myNewDirection = WEST;
         }
         else if (myNewDirection == WEST) {
            myNewDirection = SOUTH;
         }
         else if (myNewDirection == SOUTH) {
            myNewDirection = WEST;
         }
      }
      else if (myDirection1 == SOUTH && myDirection2 == EAST) {
         if (myFirst) {
            myNewDirection = SOUTH;
         }
         else if (myNewDirection == SOUTH) {
            myNewDirection = EAST;
         }
         else if (myNewDirection == EAST) {
            myNewDirection = SOUTH;
         }
      }
      else if (myDirection1 == EAST && myDirection2 == NORTH) {
         if (myFirst) {
            myNewDirection = EAST;
         }
         else if (myNewDirection == EAST) {
            myNewDirection = NORTH;
         }
         else if (myNewDirection == NORTH) {
            myNewDirection = EAST;
         }
      }
      
      if (myFirst) {
         myFirst = false;
      }
      myCount++;
      return myNewDirection;
      
      
   }
}
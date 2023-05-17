/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Turtle.java
*/

import java.util.Random;

/**
* The Turtle class represents the turtle animal. It extends Abstract Critter.
* Mice tend to move 1/3 the speed of other creatures and will pick a new 
* direction every 3 moves, based on certain criteria.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Turtle extends AbstractCritter {
   
   /**
   * This constant defines a certain wait time for turtles, between choosing a
   * new move.
   */
   public static final int TURTLE_WAIT = 3;
   
   /**
   * This field holds an object of type Random. Will be used to
   * generate random numbers.
   */
   private Random random;
   
   /**
   * This stores an int that helps us to count to a certain target. 
   * This will help us space out events or put a limit on some action.
   */
   private int myCount;
   
   /*
   * This is a start delay time specific only to turtles, so that they
   * do not all start moving at the same time.
   */
   private int myStartDelay;
   
   /**
   * Holds a bool that represents whether this is our first time moving or not.
   */
   private boolean myFirst;
   
   
   /**
   * This method constructs a Turtle object and calls the super class with 
   * a char to represent the Turtle on the panel, so that we can identify it.
   * It also set all of our fields to the appropriate starting values.
   */
   public Turtle() {
      super('T');
      random = new Random();
      myCount = 0;
      myStartDelay = random.nextInt(10);
      myFirst = true;
   }
   
   /**
   * The getMove method provides the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This method
   * simulates how a Turtle moves by changing it's direction with each call 
   * in a particular pattern.
   * 
   * @param theInfo is a class that contains information about this particular
   *                critter. Not used in this method.
   *
   * @return the next direction based on certain criteria.
   */
   public int getMove(CritterInfo theInfo) {
      int newDirection = CENTER;
     
      if (myCount != myStartDelay && myFirst == true) {
         newDirection = CENTER;
         myCount++;
      }
      else if (myFirst) {
         newDirection = random.nextInt(CENTER);
         myFirst = false;
         myCount = 0;
      }
      
      if (myCount >= TURTLE_WAIT && !myFirst) {
         boolean randomVal1 = random.nextBoolean();
         int randomVal2;
         if (randomVal1) {
            randomVal2 = random.nextInt(13);
            if (randomVal2 < 2 && randomVal2 >= 0) {
               newDirection = NORTH;
            }
            else if (randomVal2 < 4 && randomVal2 >= 2) {
               newDirection = EAST;
            }
            else if (randomVal2 == 4) {
               newDirection = SOUTH;
            }
            else if (randomVal2 < 8 && randomVal2 >= 5) {
               newDirection = WEST;
            }
            else if (randomVal2 < 13 && randomVal2 >= 8) {
               newDirection = CENTER;
            }
            myCount++;
         }
         else if (!randomVal1) {
            randomVal2 = random.nextInt(10);
            if (randomVal2 < 4 && randomVal2 >= 0) {
               newDirection = NORTH;
            }
            else if (randomVal2 < 6 && randomVal2 >= 4) {
               newDirection = EAST;
            }
            else if (randomVal2 < 8 && randomVal2 >= 6) {
               newDirection = SOUTH;
            }
            else if (randomVal2 < 11 && randomVal2 >= 8) {
               newDirection = WEST;
            }
         }
         myCount = 0;
      }
      else if (!myFirst) {
         newDirection = CENTER;
         myCount++;
      }
      return newDirection;
   }
}
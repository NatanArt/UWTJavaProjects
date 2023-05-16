/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Critter.java
*/

/**
* The Critter interface defines what it means to be a Critter. It sets each
* one up with the constants each critter will implemment in their code and
* also defines abstract methods that each critter must override to be a 
* critter.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public interface Critter {
  
   /**
   * This constant sets a NORTH to a particular number that can be used by
   * critters to represent NORTH.
   */
   public static final int NORTH = 0;
   
   /**
   * This constant sets a WEST to a particular number that can be used by
   * critters to represent WEST.
   */
   public static final int WEST = 1;
   
   /**
   * This constant sets a SOUTH to a particular number that can be used by
   * critters to represent SOUTH.
   */
   public static final int SOUTH = 2;
   
   /**
   * This constant sets a EAST to a particular number that can be used by
   * critters to represent EAST.
   */
   public static final int EAST = 3;
   
   /**
   * This constant sets a CENTER to a particular number that can be used by
   * critters to represent CENTER.
   */
   public static final int CENTER = 4;
   
   /**
   * This method is a getter method who's intended pupose is to obtain the 
   * CritterChar of this particular object. The body will be written by the
   * AbstractCritter class to accomplish this.
   */
   public char getChar();
   
   /**
   * The getMove method will provide the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This will
   * simulate how each critter moves by returning different moves in a certain
   * pattern.
   */
   public int getMove(CritterInfo theInfo);
}
/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   AbstractCritter.java
*/

/**
* This program is an abstract class intended to overrite the getChar() method 
* implemented from the Critter Interface. This method is then inherited by each
* Critter object under this one.
* 
*
* @author Natan Artemiev
* @version 25 April 2023
*/
public abstract class AbstractCritter implements Critter {
   
   /**
   * Hold a char to identify each critter.
   */ 
   private char myCritterChar;
   
   /**
   * This method constructs an AbstractCritter object and assigns a char
   * to represent the Critter on the panel, so that we can identify it. It
   * also set all of our fields to the appropriate starting values.
   *
   * @param theChar is the character passed in by the subclasses to represent
   *                the Critter on the panel.
   */
   public AbstractCritter(final char theChar) {
      myCritterChar = theChar;
   }
   
   /**
   * This method is a getter method used to obtain the CritterChar of this
   * particular object.
   *
   * @return the CritterChar of this particular object.
   */
   public char getChar() {
      return myCritterChar;
   } 
}
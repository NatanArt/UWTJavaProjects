/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Stone.java
*/

/**
* The Stone class represents the stone. It extends Abstract Critter.
* Stones dont move (duh, well at least not by themselves) and they can never
* be killed by stones.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Stone extends AbstractCritter {
   
   /**
   * This method constructs a Stone object and calls the super class with a
   * char to represent the Stone on the panel, so that we can identify it.
   */
   public Stone() {
      super('S');
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
   * @return CENTER always.
   */
   public int getMove(CritterInfo theInfo) {
      return CENTER;
   }
}
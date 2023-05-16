/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 3
* 
* File Name:   Bat.java
*/

import java.util.Random;

/**
* The Bat class represents the bat animal. It extends Abstract Critter.
* It's intended to simply simulate the somewhat chaotic fluttering of a
* bat's movement.
*
* @author Natan Artemiev 
* @version 25 April 2023
*/
public class Bat extends AbstractCritter {
   
   /**
   * This field holds an object of type Random. Will be used to
   * generate random numbers.
   */
   private Random random;
   
   /**
   * This method constructs a Bat object and calls the super class with a char
   * to represent the Bat on the panel, so that we can identify it. It
   * also set all of our fields to the appropriate starting values.
   */
   public Bat() {
      super('B');
      random = new Random();
   }
   
   /**
   * The getMove method provides the next move of a critter so that the
   * frame can be updated with the new positions of each critter. This method
   * simulates how a bat moves by changing it's direction with each call in a
   * particular pattern.
   * 
   * @param theInfo is a class that contains information about this particular
   *                critter. Not used in this method.
   *
   * @return the next direction chosen randomly.
   */
   public int getMove(CritterInfo theInfo) {
      return random.nextInt(EAST + 1);
   }
}
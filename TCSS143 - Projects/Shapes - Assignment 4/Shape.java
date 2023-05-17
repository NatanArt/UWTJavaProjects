/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   Shape.java
*/

/**
 * This program is an interface called Shape. It defines the abstract methods
 * that every shape must implement to be considered a shape.
 * 
 * @author Natan Artemiev
 * @version 5/3/23
 */
public interface Shape extends Comparable<Shape> {

    /**
     * This method will calculate an object's area. It will be overrriten by
     * all instantiable classes because different shapes will have different 
     * areas.
     * 
     * @return will return a double that is the area of the object.
     */
    public double calculateArea();

    /**
     * 
     * @returns a deep copy of an existing shape. This will be used to create 
     * a list of deep copies that can be sorted.
     */
    public Shape copyShape();

    /**
     * This method will provide access to the name of the object.
     * 
     * @return will return the name of the object.
     */
    public String getName();    
}
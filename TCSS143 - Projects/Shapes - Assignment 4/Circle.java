/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   Circle.java
*/

import java.lang.Math;

/**
 * This method represents a circle object. Circles have a unique ID and a 
 * radius. A circle can calculate it's area, can provide a copy of itself and
 * defines a String representation of itself to convey information.
 * 
 * @author Natan Artemiev
 * @version 2/28/23
 */
public class Circle extends AbstractShape {

    /**
     * This field holds the circle's radius.
     */
    private double myRadius;

    /**
     * Holds an ID unique to this particular object.
     */
    private static int myID;

    /**
     * This is a constructor for the Circle shape, that will call the 
     * parameterized constructor with a base value of one.
     */
    public Circle() {
        this(1.0);
    }

    /**
     * This method constructs a Circle object. It calls the super constructor
     * to set the object name and pass in the ID. It will then check to see if
     * the radius value passed in is valid and assign it to the radius. 
     * Otherwise will throw an IllegalArgumentException.
     * 
     * @param theRadius
     */
    public Circle(double theRadius) {
        super("Circle", myID++);
        if (theRadius <= 0.0) {
            myID--;
            throw new IllegalArgumentException("ERROR! Negative or 0" +
                            " value can't be applied" +
                            " to a circle radius.");
        }
        myRadius = theRadius;
    }

    
    /**
     * Sets the radius of the circle to the value of the passed in paremeter.
     * 
     * @param theRadius holds the new radius.
     */
    public void setRadius(double theRadius) {
        myRadius = theRadius;
    }

    
    /**
     * This method calculates the area of the circle.
     * 
     * @return the double that holds the objects area.
     */
    public double calculateArea() {
        return Math.PI * (Math.pow(myRadius, 2.0));
    }

    /**
     * This method creates a deep copy of this circle object to be used 
     * for sorting.
     * 
     * @return the copy of the shape.
     */
    public final Shape copyShape() {
        Circle newC = new Circle();
        newC.myRadius = myRadius;
        return newC;
    }
    
    /**
     * This method defines a String representation of a Circle object.
     * 
     * @return the String that represents the Circle object.
     */
    public String toString() {
        return myName + " [Radius: " + String.format("%.2f", myRadius) +
               "] Area: " + String.format("%.2f", calculateArea());
    }
}

/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   Rectangle.java
*/

/**
 * This method represents a rectangle object. Rectangles have a unique ID and a
 * length and width. A Rectangle can calculate it's area, provide a copy of 
 * itself, and defines a String representation of itself to convey information.
 * 
 * @author Natan Artemiev
 * @version 5/3/23
 */
public class Rectangle extends AbstractShape {
    /**
     * Holds the length of this Rectangle. 
     */
    private double myLength;

    /**
     * Holds the width of this rectangle.
     */
    private double myWidth;

    /**
     * Holds an ID unique to this particular object.
     */
    private static int myID;

    /**
     * This is a constructor for the Rectangle Shape, that will call the
     * parameterized constructor with base values of one.
     */
    public Rectangle() {
        this(1.0, 1.0);
    }

     /**
     * This method constructs a Rectangle object. It calls the super
     * constructor to set the object name and pass in the ID. It will then
     * check to see if the Length and Width values passed in are valid and 
     * assign them to myLength and myWidth repectively. Otherwise will throw
     * an IllegalArgumentException. 
     * 
     * @param theLength holds the Rectangles new Length.
     * @param theWidth holds the Rectangles new Width.
     */
    public Rectangle(final double theLength, final double theWidth) {
        super("Rectangle", myID++);
        if (theLength <= 0 || theWidth <= 0) {
            myID--;
            throw new IllegalArgumentException("ERROR! Negative or 0" + 
                            " value(s) can't be applied to a rectangle.");
                            
        }
        myLength = theLength;
        myWidth = theWidth;
    }

    /**
     * Sets the Length of the Rectangle to the value of the passed in 
     * paremeter.
     * 
     * @param theLenght holds the new length.
     */
    public void setLength(final double theLength) {
        myLength = theLength;
    }

    /**
     * Sets the Width of the Rectangle to the value of thepassed in paremeter.

     * @param theWidth holds the new Width.
     */
    public void setWidth(final double theWidth) {
        myWidth = theWidth;
    }

    
    
    /**
     * This method calculates the area of the rectangle.
     * 
     * @return the double that holds the object's area.
     */
    public double calculateArea() {
        return myLength * myWidth; 
    }

    /**
     * This method creates a deep copy of this rectangle object to be used 
     * for sorting.
     * 
     * @return the copy of the shape.
     */
    public final Shape copyShape() {
        Rectangle newR = new Rectangle();
        newR.myLength = myLength;
        newR.myWidth = myWidth;
        return newR;
    }

    /**
     * This method defines a String representation of a Circle object.
     * 
     * @return the toString format that represents the Rectangle object.
     */
    public String toString() {
        return myName + " [Length: " + String.format("%.2f", myLength) +
               ", Width: " + String.format("%.2f", myWidth) +
               "] Area: " + String.format("%.2f", calculateArea());
    }
}

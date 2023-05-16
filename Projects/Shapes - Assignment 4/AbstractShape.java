/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   AbstractShape.java
*/

/**
 * This program is an abstract class that overrides some of the methods defined
 * by the Shape interface. The methods defined here represent functionality 
 * that can be used by all other classes that inherit this class.
 * @author Natan Artemiev
 * @version 5/3/23
 */
public abstract class AbstractShape implements Shape {

    /**
     * myName holds a String that is the the name of the Shape.
     */
    protected String myName = "";

    /**
     * This method is a constructor for Abstract Shape. It concatenates the 
     * ID parameter to theName parameter.
     * 
     * @param theName holds a String representing the Shape's name.
     * @param theID An int that holds an ID unique to each shape.
     */
    public AbstractShape(String theName, int theID) {
        myName = theName + theID;
    }

    
    /** 
     * This compare to method helps the Collections class to sort between
     * items within the collection. We define our own compareTo method to 
     * sort our lists in a specific.
     * 
     * @param theOther holds the Shape that is passed to this method when it is
     *                 called by the Collections class.
     * @return an int that helps the Collections class to sort our list in the proper way.
     */
    public int compareTo(Shape theOther) {
        double value = getClass().getSimpleName().compareTo
                       (theOther.getClass().getSimpleName());
        if (value == 0) {
            value = theOther.calculateArea() - calculateArea();
        }
        return (int) value;
    }

    
    /** 
     * A getter method to provide access to the name of an object.
     * @return String returns the objects name to the caller.
     */
    public String getName() {
        return myName;
    }
}
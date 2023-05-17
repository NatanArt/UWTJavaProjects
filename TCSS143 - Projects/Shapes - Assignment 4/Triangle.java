/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   Triangle.java
*/

/**
 * This method represents a Trianlge object. Triangles have a unique ID and a
 * 3 side lengths A, B, and C. A Trianlge can calculate it's area, provide
 * a copy of itself, and defines a String representation of itself to convey
 * information.
 * 
 * @author Natan Artemiev
 * @version 5/3/23
 */
public class Triangle extends AbstractShape {

    /**
     * Holds the length of Side A.
     */
    private double mySideA;

    /**
     * Holds the length of Side B.
     */
    private double mySideB;

    /**
     * Holds the length of Side C.
     */
    private double mySideC;

    /**
     * Holds an ID unique to this particular object.
     */
    private static int myID = 0;

    /**
     * This is a constructor for the Trianlge Shape, that will call the
     * parameterized constructor with base values of one.
     */
    public Triangle() {
        this(1.0, 1.0, 1.0);
    }

    /**
     * This method constructs a Trianlge object. It calls the super
     * constructor to set the object name and pass in the ID. It will then
     * check to see if the Side values passed in are valid and 
     * assign them to sides A, B, and C respectively. Otherwise will throw
     * an IllegalArgumentException appropriate for the situation.
     * 
     * @param theSideA holds the length of Side A.
     * @param theSideB holds the length of Side B.
     * @param theSideC holds the length of SideC.
     */
    public Triangle(final double theSideA, final double theSideB, 
                    final double theSideC) {
        super("Trianlge", myID++);
        if (theSideA <= 0 || theSideB <= 0 || theSideC <= 0) {
            myID--;
            throw new IllegalArgumentException("ERROR! Negative or 0" +
                            " value(s) can't be applied to a triangle.");
        }
        else if (theSideA >= theSideB + theSideC ||
                 theSideB >= theSideA + theSideC ||
                 theSideC >= theSideA + theSideB) {
                    myID--;
                    throw new IllegalArgumentException("ERROR!" + 
                                    " Not a triangle. " + 
                                    "Longest side too long.");
                 }
        mySideA = theSideA;
        mySideB = theSideB;
        mySideC = theSideC;
    }

    /**
     * Sets the length of Side A to the value of the parameter passed in.
     * 
     * @param theSideA holds the length of Side A.
     */
    public void setSideA(final double theSideA) {
        mySideA = theSideA;
    }

    /**
     * Sets the length of Side B to the value of the parameter passed in.
     * 
     * @param theSideB holds the length of Side B.
     */
    public void setSideB(final double theSideB) {
        mySideB = theSideB;
    }

    /**
     * Sets the length of Side C to the value of the parameter passed in.
     * 
     * @param theSideC holds the Lenght of Side C.
     */
    public void setSideC(final double theSideC) {
        mySideC = theSideC;
    }

    /**
     * This method calculates the area of the triangle.
     * 
     * @return the double that holds the object's area.
     */
    public double calculateArea() {
        double s = (mySideA + mySideB + mySideC) / 2.0;
        return Math.sqrt((s * (s - mySideA) * (s - mySideB) * (s- mySideC)));
    }

    /**
     * This method creates a deep copy of this triangle object to be used
     * for sorting.
     * 
     * @return the copy of the shape.
     */
    public final Shape copyShape() {
        Triangle newT = new Triangle();
        newT.mySideA = mySideA;
        newT.mySideB = mySideB;
        newT.mySideC = mySideC;
        return newT;
    }

    /**
     * This method defines a String representation of a Circle object.
     * 
     * @return the toString format that represents the triangle object.
     *         
     */
    public String toString() {
        return myName + " [SideA: " + String.format("%.2f", mySideA) +
               ", SideB: " + String.format("%.2f", mySideB) + 
               ", SideC: " + String.format("%.2f", mySideC) +
               "] Area: " + String.format("%.2f", calculateArea());
    }
}

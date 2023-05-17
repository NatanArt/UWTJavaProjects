/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 4
* 
* File Name:   Assignment4.java
*/

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This class is the driver program to test the Shape classes.
 */
public class Assignment4 {
    /**
    * The driver
    * assigns a Scanner with an input file that holds input values for the shapes.
    * We then fill a Linked list with the (valid) values from the input file and
    * create a copy of that list. Then our program will out put the original list,
    * a sorted copy, and another output of the original list.
    * 
    * @param theArgs is used for command-line input arguments. We don't use it
    *                here.
    */
    public static void main(String[] theArgs) throws FileNotFoundException { 
      File  myFile = new File("C:\\TCSS143\\Projects\\Shapes - Assignment 4\\in4.txt");
      PrintStream myOutput = new PrintStream(new File("out4.txt"));
      Scanner  myScanner = new Scanner(myFile);
      List<Shape> myList = new LinkedList<Shape>();
      ArrayList<Shape> myCopyList = inputToList(myScanner, myList);

      Collections.sort(myCopyList);

      myOutput.println("Original List [unsorted]:");
      outputList(myOutput, myList);
      myOutput.println();
      
      myOutput.println("Copied List [sorted-Ascending Class first, " + 
                       "descending area second]:");
      outputList(myOutput, myCopyList);
      myOutput.println();

      myOutput.println("Original List[unsorted]:");
      outputList(myOutput, myList);
      myOutput.println();

    }

    /**
     * This method fills a given List with shapes that are created from values
     * in a given file. This method will also create a deep copy of this list 
     * and return it to Main.
     * 
     * @param theScanner holds the file with the input value.
     * @param theList is a list to hold the Shapes we create with input.
     * @return A list that is a copy of the myList.
     */
    public static ArrayList<Shape> inputToList(Scanner theScanner,
                                        List<Shape> theList) {
        ArrayList<Double> paramList;
        while (theScanner.hasNextLine()) {
            Scanner line = new Scanner(theScanner.nextLine());
            paramList = new ArrayList<Double>();
            while (line.hasNext()) {
                if (line.hasNextDouble()) {
                    paramList.add(line.nextDouble());
                }
                else {
                    if(theScanner.hasNextLine()) {
                        line = new Scanner(theScanner.nextLine());
                        paramList.clear();
                    }
                }
            }
            if (paramList.size() == 1) {
                try {
                    Shape aCircle = new Circle(paramList.get(0));
                    theList.add(aCircle);
                } catch (IllegalArgumentException theE) {
                    System.out.println(theE);
                }
            }
            if (paramList.size() == 2) {
            try {
                Shape aRectangle = new Rectangle(paramList.get(0), 
                                             paramList.get(1));
                theList.add(aRectangle);
            } catch (IllegalArgumentException theE) {
                System.out.println(theE);
            }
            }
            if (paramList.size() == 3) {
                try {
                    Shape aTriangle = new Triangle(paramList.get(0),
                                               paramList.get(1),
                                               paramList.get(2));
                    theList.add(aTriangle);
                } catch (IllegalArgumentException theE) {
                    System.out.println(theE);
                }
            }
        }
        ArrayList<Shape> newList = new ArrayList<Shape>();
            for (Shape element : theList) {
            Shape s = element.copyShape();
            newList.add(s);
        }
        return newList;
    }

    /**
     * This method will iterate through a given list and print the toString 
     * representation of each Shape within the list to the given output file.
     * 
     * @param theOutputFile is the file that we will be printing to.
     * @param theList is the list of Shapes that is passed in to be printed.
     */
    public static void outputList(PrintStream theOutputFile, List<Shape> theList) {
        for (Shape element : theList) {
            theOutputFile.println(element.toString());
        }
    }
}
/*
* Course:      TCSS143 - Fundamentals of Object-Oriented Programming -
*                        Theory and Application.
* Name:        Natan Artemiev
* Instructor:  David Schuessler 
* Assignment:  Programming Assignment 5
* 
* File Name:   LostPuppy.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This program is a class that uses recursive backtracking to simulate
 * a lost puupy trying to find it's way through a maze. We are given a maze
 * with a Start and End location and our program (a.k.a. the Puppper) will
 * attempt to find an exit. If it succeeds it will present the maze with 
 * all of it's attempts to solve it to the console.
 */
public class LostPuppy {
    
    /**
    * This is our driver class. It takes our input file and instantiates a 
    * Scanner with it. We store this maze in a 2D array with a call to getMaze.
    * We then obtain the Start and Exit coordinates and store them in a 2D
    * array to get all of the answers at once, and then split them into 
    * two Arrays for readability's sake. Once we have these components we
    * set a boolean variable equal to the return value of doMaze. If true,
    * the maze is solved and will output a maze to the console with all
    * attempts to solve. Otherwise will print "No Path Found" to the console.
    * 
    * @param theArgs is used for command-line input arguments. We don't use it
    *                here.
    */
    public static void main(String[] theArgs) throws FileNotFoundException {
        File myInput = new File("MazeData1.txt");
        Scanner myScanner = new Scanner(myInput);
        
        char[][] mazeArray = getMaze(myScanner);
        int startExitCoords[][] = getExitStartlocation(mazeArray);
        int startCoords[] = {startExitCoords[0][0], startExitCoords[0][1]};
        int exitCoords[] = {startExitCoords[1][0], startExitCoords[1][1]};

        boolean wayFound = doMaze(mazeArray, startCoords, exitCoords);
        if (!wayFound) {
            System.out.println("No Path Found");
        }
        else {
            outputMaze(mazeArray);
        }
    }

    /**
     * The getMaze method takes our input file and reads throught it ONE time
     * to store the entire thing into a String, while keeping track of the
     * lines and the line length. Once we have finished our read, we take our
     * String and input each character into a 2D array to be returned to main.
     * 
     * @param theScanner is a Scanner instantiated with the Maze file.
     * @return Returns a 2D array representation of our maze to main.
     */
    public static char[][] getMaze(Scanner theScanner) {
        boolean firstLine = true;
        int lineCount = 0;
        int colCount = 0;
        int stringCount = 0;
        String readFile = "";
        char[][] result;
        while (theScanner.hasNextLine()) {
            if (firstLine) {
                readFile += theScanner.nextLine();
                lineCount++;
                colCount = readFile.length();
                firstLine = false;
            }
            else {
                readFile += theScanner.nextLine();
                lineCount++;
            }
        }
        result = new char[lineCount][colCount];
        for (int row = 0; row < lineCount; row++) {
            for (int col = 0; col < colCount; col++) {
                    result[row][col] = readFile.charAt(stringCount);
                    stringCount++;
            }
        }
         
        return result;
    }

    /**
     * The getExitStartLocation method recievs our maze array and iterates
     * through it with a nested for-loop to find the start and exit locations
     * of our maze, marked by the chars "S" and "E" respectively. We store
     * these array location ("coords") in a 2D array and return to main.
     * 
     * @param theMaze is the Maze array obtained from getMaze.
     * @return Returns a 2D array with the start and exit locations.
     */
    public static int[][] getExitStartlocation(char[][] theMaze) {
        int[][] startExitCoords= new int[2][2];
        for (int row = 0; row < theMaze.length; row++) {
            for (int col = 0; col < theMaze[0].length; col++) {
                if (theMaze[row][col] == 'S') {
                    startExitCoords[0][0] = row;
                    startExitCoords[0][1] = col;
                    theMaze[row][col] = '*'; 
                }
                else if (theMaze[row][col] == 'E') {
                    startExitCoords[1][0] = row;
                    startExitCoords[1][1] = col;
                }
            }
        }
        return startExitCoords;
    }

    /**
     * The canMove method recieves our maze array, and also a row and column
     * to check to see if they are valid "moves." We take the row and column
     * values to see if they are within the bounds of our array and check
     * the value at those indices to see if the character there represents a
     * valid move location. If these are true then we return true, 
     * false otherwise. This is used by the doMaze method to check if moves are
     * valid before they are made.
     * 
     * @param theMaze is the Maze array obtained from getMaze.
     * @param theRow represtents a row location to test.
     * @param theCol represents a column location to test.
     * @return returns true if our row and column represent valid moves,
     *         false otherwise.
     */
    public static boolean canMove(char[][] theMaze, int theRow, int theCol) {
        boolean moveOK = true;
        if (theRow < 0 || theRow >= theMaze.length) {
            moveOK = false;
        }
        else if (theCol < 0 || theCol >= theMaze[0].length) {
            moveOK = false;
        }
        else {
            if (theMaze[theRow][theCol] == ' ' || 
                theMaze[theRow][theCol] == 'E') {
                    moveOK = true;
                }
            else {
                moveOK = false;
            }
        }
        return moveOK;
    }

    /**
     * This is the big one. The doMaze method is the method that solves 
     * our mazes. It recieves our Maze array and the Start and End coordinates.
     * This is a recursive method, thus we have a base case and a general case.
     * Our base case checks to see if our current location is equal to the end 
     * location. If so we return true to main. Otherwise we move to our general
     * case which essentially checks to see which directions we can move in,
     * and if we can, we move there and recursively call do maze again to check
     * for our next move. We repeat this until we find the exit. If we have no
     * more valid moves to make and we have not found an exit, we backtrack
     * until we make it to a spot where we can make a valid move, 
     * and continue on. Once the maze is solved, we return true to main, if
     * no exit exists we return false.
     * 
     * @param theMaze is the Maze array obtained from getMaze.
     * @param theStart is an array that represents out starting location
     *                 and/or our current location.
     * @param theEnd is an array that represents our end location 
     *               (never changes).
     * @return true if exit exists and is found, false otherwise.
     */
    public static boolean doMaze(char[][] theMaze, 
                                 int[] theStart, int[] theEnd)  {
        boolean wayFound = false;
        
        if (theMaze[theEnd[0]][theEnd[1]] == 
            theMaze[theStart[0]][theStart[1]]) {
            theMaze[theStart[0]][theStart[1]] = '*';
            wayFound = true;
        }
        else {
            if(!wayFound) {
                if(canMove(theMaze, theStart[0] - 1, theStart[1])) {
                    if (theMaze[theStart[0] - 1][theStart[1]] != 'E') {
                        theMaze[theStart[0] - 1][theStart[1]] = '*';
                    }
                    int[] North = {theStart[0] - 1, theStart[1]};
                    wayFound = doMaze(theMaze, North, theEnd);
                    if (!wayFound) {
                        theMaze[theStart[0] - 1][theStart[1]] = '-';
                    }
                }
            }
            if(!wayFound) {
                if(canMove(theMaze, theStart[0], theStart[1] - 1)) {
                    if (theMaze[theStart[0]][theStart[1] - 1] != 'E') {
                        theMaze[theStart[0]][theStart[1] - 1] = '*';
                    }
                    int[] West = {theStart[0], theStart[1] - 1};
                    wayFound = doMaze(theMaze, West, theEnd);
                    if (!wayFound) {
                        theMaze[theStart[0]][theStart[1] - 1] = '-';
                    }
                }
            }
            if(!wayFound) {
                if(canMove(theMaze, theStart[0] + 1, theStart[1])) {
                    if (theMaze[theStart[0] + 1][theStart[1]] != 'E') {
                        theMaze[theStart[0] + 1][theStart[1]] = '*';
                    }
                    int[] South = {theStart[0] + 1, theStart[1]};
                    wayFound = doMaze(theMaze, South, theEnd);
                    if (!wayFound) {
                        theMaze[theStart[0] + 1][theStart[1]] = '-';
                    }
                }
            }
            if(!wayFound) {
                if(canMove(theMaze, theStart[0], theStart[1] + 1)) {
                    if (theMaze[theStart[0]][theStart[1] + 1] != 'E') {
                        theMaze[theStart[0]][theStart[1] + 1] = '*';
                    }
                    int[] East = {theStart[0], theStart[1] + 1};
                    wayFound = doMaze(theMaze, East, theEnd);
                    if (!wayFound) {
                        theMaze[theStart[0]][theStart[1] + 1] = '-';
                    }
                }
            }
        }
        return wayFound;
    }

    /**
     * The outputMaze method takes our maze array and outputs it to the
     * consile by iterating through each cell to and printing the char
     * held inside.
     * 
     * @param theMaze is the Maze array obtained from getMaze.
     */
    public static void outputMaze(char[][] theMaze) {
        for (int row = 0; row < theMaze.length; row++) {
            for (int col = 0; col < theMaze[0].length; col++) {
                System.out.print(theMaze[row][col]);
            }
            System.out.println();
        }
    }
}
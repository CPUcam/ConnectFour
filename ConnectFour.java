/*
 * CS312 Assignment 10
 * A program to play Connect Four.
 *
 * On my honor this program is my own work:
 * Raul Camacho
 *
 *  email address: rcamacho96@gmail.com
 *  UTEID: rac3983
 *  Section 5 digit ID: 51705
 *  Grader name: Basil
 *  Number of slip days used on this assignment: 1
 */

import java.util.Arrays;
import java.util.Scanner;
public class ConnectFour {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);
    	String p1 = p1Name(in);
    	String p2 = p2Name(in);
       	char[][] board = new char[6][7];
    	boardHeader();
    	printInitialBoard(board);
    	boolean win = false;
    	int turnCount = 1;
        char char1 = 'r';
        char char2 = 'b';
    	while (!win) {
            int p1Choice = play(in, p1, board, char1);
            win = win(p1Choice, board, char1);
    		printBoard(board, win, turnCount, p1, p2);
            if (win) break;
            turnCount++;
            int p2Choice = play(in, p2, board, char2);
            win = win(p2Choice, board, char2);
            printBoard(board, win, turnCount, p1, p2);
    	}
    }
    //returns first player's name as string
    public static String p1Name(Scanner in) {
    	System.out.print("Player 1 enter your name: ");
    	String p1 = in.next();
    	return p1;
    }
    //returns second player's name as string
    public static String p2Name(Scanner in) {
    	System.out.print("Player 2 enter your name: ");
    	String p2 = in.next();
    	return p2;
    }
    //first board header
    public static void boardHeader() {
        System.out.println("\nCurrent Board");
        System.out.println("1 2 3 4 5 6 7 column numbers");
    }
    //prints first board
    public static void printInitialBoard(char[][] b) {
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 7; j++) {
    			b[i][j] = '.';
    			System.out.print(b[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
    //player move
    public static int play(Scanner K, String p, char[][] array, char r) {
        System.out.println(p + " it is your turn.");
        System.out.println("Your pieces are the " + r + "'s");
        System.out.print(p + ", enter the column to drop your checker: ");
        boolean valid = true;
        int entry = 0;
        while (valid) {
            //checks for int value
            if (!K.hasNextInt()) {
                System.out.println(K.next() + " is not an integer.");
                System.out.print(p + ", enter the column to drop your checker: ");
            } else {
                entry = K.nextInt();
                //checks for valid int value
                if (entry < 1 || entry > 7) {
                    System.out.println(entry + " is not a valid column.");
                    System.out.print(p + ", enter the column to drop your checker: ");
                } 
                //checks for full columns
                else if (array[0][entry - 1] != '.') {
                    System.out.println("Column " + entry + " is full");
                    System.out.print(p + ", enter the column to drop your checker: ");
                }
                //replaces '.' with player's checker
                else {
                    for (int i = 5; i >= 0; i--) {
                        if (array[i][entry - 1] == '.') {
                            array[i][entry - 1] = r;
                            valid = false;
                            i = -1;
                        }
                    }
                    
                }
            }
        }
        return entry - 1;
    }
    //prints current board
    public static void printBoard(char[][] b, boolean win, int count, String p1, String p2) {
        if (!win) {
            System.out.println();
            System.out.println("Current Board");
        }
        else {
            if (count % 2 != 0) {
                System.out.println(p1 + " wins!!");
            }
            else {
                System.out.println(p2 + " wins!!");
            }
            System.out.println();
            System.out.println("Final Board");
        }
        System.out.println("1 2 3 4 5 6 7 column numbers");
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 7; j++) {
    			System.out.print(b[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
    //checks for win, returns boolean
    public static boolean win (int choice, char[][] b, char r) {
        //checks is board is full
        int fillCount = 0;
        boolean win = false;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 7; j++) {
                if (b[i][j] != '.') {
                    fillCount++;
                }
            }
        }
        if (fillCount == 42)
            win = true;   
        else if (fillCount != 42) {
            //check vertical line
            for (int i = 0; i < 3; i++) {
                if ((b[i][choice] == r) && (b[i][choice] == b[i+1][choice]) 
                    && (b[i][choice] == b[i+2][choice]) && (b[i][choice] == b[i+3][choice])) {
                    win = true;
                }
            }
            //check horizontal line
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((b[i][j] == r) && (b[i][j] == b[i][j+1]) 
                        && (b[i][j] == b[i][j+2]) && (b[i][j] == b[i][j+3])) {
                        win = true;
                    }
                }
            }
            //check down and left line
            for (int i = 0; i < 3; i++) {
                for (int j = 3; j < 7; j++) {
                    if ((b[i][j] == r) && (b[i][j] == b[i+1][j-1]) 
                        && (b[i][j] == b[i+2][j-2]) && (b[i][j] == b[i+3][j-3])) {
                        win = true;
                    } 
                }
            }
            //check down and right line
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 4; j++) {
                    if ((b[i][j] == r) && (b[i][j] == b[i+1][j+1]) 
                        && (b[i][j] == b[i+2][j+2]) && (b[i][j] == b[i+3][j+3])) {
                        win = true;
                    }
                }
            }
        }
        fillCount = 0;
        return win;
    }
}





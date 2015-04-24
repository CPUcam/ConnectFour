/*
 * CS312 Assignment 10
 * A program to play Connect Four.
 *
 * On my honor this program is my own work:
 * Raul Camacho
 *
 *  email address: rcamacho96@gmail.com
 *  UTEID: rac3983
 *  Section 5 digit ID:
 *  Grader name:
 *  Number of slip days used on this assignment: 0
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
    	boolean win = true;
    	int turnCount = 0;
    	while (win) {
    		turnCount++;
            int p1Choice = play(in, p1, board);
    		printBoard(board);
            int p2Choice = play(in, p2, board);
            printBoard(board);

    	}
    }
    public static String p1Name(Scanner in) {
    	System.out.print("Player 1 enter your name: ");
    	String p1 = in.next();
    	return p1;
    }
    public static String p2Name(Scanner in) {
    	System.out.print("Player 2 enter your name: ");
    	String p2 = in.next();
    	return p2;
    }
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
    public static void boardHeader() {
    	System.out.println("\nCurrent Board");
    	System.out.println("1 2 3 4 5 6 7 column numbers");
    }
    public static int turnHeader(Scanner in, int count, String p1, String p2) {
    	int column = 0;
    	if (count % 2 != 0) {
    		System.out.println("\n" + p1 + " it is your turn.");
    		System.out.println("Your pieces are the r's.");
    		System.out.print(p1 + " , enter the column to drop your checker: ");
    		column = in.nextInt();
    	}
    	else {
    		System.out.println("\n" + p2 + " it is your turn.");
    		System.out.println("Your pieces are the b's.");
    		System.out.print(p2 + " , enter the column to drop your checker: ");
    		column = in.nextInt();
    	}
    	return column - 1;
    }
    //player move
    public static int play(Scanner K, String p, char[][] array) {
        System.out.println(p + " it is your turn.");
        System.out.println("Your pieces are the r's");
        System.out.print(p + ", enter the column to drop your checker: ");
        boolean valid = true;
        int entry = 0;
        while (valid) {
            if (!K.hasNextInt()) {
                System.out.println(K.next() + " is not an integer.");
                System.out.print(p + ", enter the column to drop your checker: ");
            } else {
                entry = K.nextInt();
                if (entry < 1 || entry > 7) {
                    System.out.println(entry + " is not a valid column.");
                    System.out.print(p + ", enter the column to drop your checker: ");
                } else {
                    for (int i = 5; i >= 0; i--) {
                        if (array[i][entry - 1] == '.') {
                            array[i][entry - 1] = 'b';
                            valid = false;
                            i = -1;
                        }
                    }
                    if (array[0][entry - 1] != '.') {
                        System.out.println("Column " + entry + " is full");
                        System.out.print(p + ", enter the column to drop your checker: ");
                    }
                }
                System.out.println();
            }
        }
        return entry - 1;
    }
    public static void printBoard(char[][] b) {
        System.out.println();
        System.out.println("Current Board");
        System.out.println("1 2 3 4 5 6 7 column numbers");
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 7; j++) {
    			System.out.print(b[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
    public static boolean win (int choice, char[][] b) {
        int rCount = 0;
        for (int i = 0; i < 6; i++) {
            if (b[i][choice] == 'r') {
                rCount++;
            }
        }
    }
}
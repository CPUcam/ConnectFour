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
    		int choice = turnHeader(in, turnCount, p1, p2);
    		board(board, choice, turnCount, p1, p2);
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
    public static char[][] board(char[][] b, int choice, int count, String p1, String p2) {
    	int errCount = 0;
    	for (int i = 5; i >= 0; i--) {
    		if (b[i][choice] == '.' && count % 2 != 0) {
    			b[i][choice] = 'r';
    			errCount++;
    		}
    		else if (b[i][choice] == '.' && count % 2 == 0) {
    			b[i][choice] = 'b';
    			errCount++;
    		}
    		if (errCount == 1) break;
    	}
    	if (errCount == 0 && count % 2 != 0) {
    		System.out.println("Column " + (choice + 1) + " is full.");
    		System.out.println(p1 + " , enter the column to drop your checker: ");
    	}
    	else if (errCount == 0 && count % 2 == 0) {
    		System.out.println("Column " + (choice + 1) + " is full.");
    		System.out.println(p2 + " , enter the column to drop your checker: ");
    	}
    	return b;
    }
    public static void printBoard(char[][] b) {
    	for (int i = 0; i < 6; i++) {
    		for (int j = 0; j < 7; j++) {
    			System.out.print(b[i][j]);
    			System.out.print(" ");
    		}
    		System.out.println();
    	}
    }
}
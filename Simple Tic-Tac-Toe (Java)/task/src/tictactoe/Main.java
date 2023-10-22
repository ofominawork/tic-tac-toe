package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int xCoordinate, yCoordinate;
        int turn = 0;
        String[][] ticTacToeArray = new String[3][3];
        Scanner scanner = new Scanner(System.in);

        initializeArray(ticTacToeArray);
        printArray(ticTacToeArray);

        do {
            try {
                yCoordinate = Integer.parseInt(scanner.next()) - 1;
                xCoordinate = Integer.parseInt(scanner.next()) - 1;
                if (xCoordinate < 0 || xCoordinate > 2 || yCoordinate < 0 || yCoordinate > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (!ticTacToeArray[xCoordinate][yCoordinate].equals(" ")) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if (turn % 2 == 0) {
                        ticTacToeArray[xCoordinate][yCoordinate] = "X";
                    } else {
                        ticTacToeArray[xCoordinate][yCoordinate] = "O";
                    }
                    printArray(ticTacToeArray);
                    if (checkWinner(ticTacToeArray, xCoordinate, yCoordinate)) {
                        System.out.println(ticTacToeArray[xCoordinate][yCoordinate] + " wins");
                        break;
                    }
                    turn++;
                    if (turn == 9) {
                        System.out.println("Draw");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("You should enter numbers!");
            }

        } while (turn != 9);
    }

    private static void initializeArray(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) array[i][j] = " ";
        }
    }

    private static void printArray(String[][] array) {
        System.out.println("---------");
        for (String[] strings : array) {
            System.out.print("| ");
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(strings[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    private static boolean checkWinner(String[][] ticTacToeArray, int xPosition, int yPosition) {
        if (!ticTacToeArray[1][1].equals(" ")) {
            if (ticTacToeArray[0][0].equals(ticTacToeArray[1][1]) && ticTacToeArray[0][0].equals(ticTacToeArray[2][2])) {
                return true;
            }
            if (ticTacToeArray[2][0].equals(ticTacToeArray[1][1]) && ticTacToeArray[2][0].equals(ticTacToeArray[0][2])) {
                return true;
            }
        }
        if (ticTacToeArray[xPosition][0].equals(ticTacToeArray[xPosition][1]) && ticTacToeArray[xPosition][0].equals(ticTacToeArray[xPosition][2])) {
            return true;
        }
        return ticTacToeArray[0][yPosition].equals(ticTacToeArray[1][yPosition]) && ticTacToeArray[0][yPosition].equals(ticTacToeArray[2][yPosition]);
    }
}

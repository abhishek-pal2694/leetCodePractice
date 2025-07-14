package com.example.leetCodeProbs;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        startGame();
    }

    public static void startGame(){
        char[][] board = new char[3][3];
        for (char[] chars : board) {
            Arrays.fill(chars, ' ');
        }
        
        char player ='X';
        boolean gameOver = false;
        Scanner scanner = new Scanner(System.in);
        
        while(!gameOver){
            printBoard(board);
            System.out.print("Please input row & col: ");
            int rowIndex = scanner.nextInt();
            int colIndex = scanner.nextInt();

            if(rowIndex> board.length -1 || colIndex > board.length-1)
                System.out.println("invalid input try again");
            else if(board[rowIndex][colIndex] == ' '){
                board[rowIndex][colIndex] = player;
                gameOver = gameWon(player, board);
                if(!gameOver)
                    player = player == 'X'? '0': 'X';
                else System.out.println("player "+ player + " Has won");
            }else{
                System.out.println("This row and col has data: "+ board[rowIndex][colIndex]);
            }
        }
        
        printBoard(board);
    }

    private static boolean gameWon(char player, char[][] board) {
        for(int row=0; row<board.length; row++){
            if(board[row][0] == player && board[row][1]== player && board[row][2]== player){
                return true;
            }
        }

        for(int col=0; col<board.length; col++){
            if(board[0][col] == player && board[1][col]== player && board[2][col]== player){
                return true;
            }
        }

        if(board[0][0] == player && board[1][1] == player && board[2][2] == player){
            return true;
        }

        return board[2][0] == player && board[1][1] == player && board[0][2] == player;
    }

    private static void printBoard(char[][] board) {
        for (char[] chars : board) {
            for (char aChar : chars) {
                System.out.print(aChar + " | ");
            }
            System.out.println();
        }
    }
}

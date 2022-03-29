package com.alex.tictactoe.view;


import java.util.ArrayList;
import java.util.List;


public class GameBoard {

    public static List<char[][]> list = new ArrayList<>();

    //отображение игрового поля
    public static void printBoard(char[][] boardView){

        System.out.println("--------------------------------");

        for(char [] row : boardView){
            for(char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void printBoardBody(char[][] boardView){

        char[][] str = new char[5][7];

        for(int i= 0; i<5;i++){
            for(int j = 0; j<7;j++){
                str[i][j]= boardView[i][j];

            }
        }
        list.add(str);
    }
}

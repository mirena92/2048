package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Game {

    private final int boardDimensions = 4;
    private int[][] board = new int[boardDimensions][boardDimensions];
    
    public Game() {
        placeRandomNumber();
        placeRandomNumber();
    }
    
    public int[][] getBoard() {
        return board;
    }
    
    public void setBoard(int[][] newBoard){
        this.board = newBoard;
    }
    
    public void moveDown() {
        
        List<Integer> column = new ArrayList<>();
        List<Integer> newColumn = new ArrayList<>();
        for(int y=0; y<boardDimensions; y++) {
            
            column.clear();
            newColumn.clear();
            for(int x=boardDimensions-1; x>=0; x--) {
                if(board[x][y]!=0) {
                    column.add(board[x][y]);
                }
            }
            
            if(!column.isEmpty()) {
                for(int i=0; i<column.size(); i++) {
                    if(i<column.size()-1 && column.get(i)==column.get(i+1)) {
                        newColumn.add(column.get(i)*2);
                        column.remove(i+1);
                        column.add(0);                        
                    }
                    else {
                        newColumn.add(column.get(i));
                    }
                }
            }
            
            for(int x=boardDimensions-1; x>=0; x--) {
                if (!newColumn.isEmpty()) {
                    board[x][y] = newColumn.get(0);
                    newColumn.remove(0);
                }
                else {
                    board[x][y] = 0;
                }
            }
        }
    }
    
    private void placeRandomNumber() {
        int number;
        Random random = new Random();
        int randomX = random.nextInt(boardDimensions);
        int randomY = random.nextInt(boardDimensions);
        int randomNum = random.nextInt(99);
        if(randomNum<90) {
            number=2;
        }
        else {
            number=4;
        }
        if(board[randomX][randomY]==0) {
            board[randomX][randomY] = number;
        }
        else {
            placeRandomNumber();
        }
    }
    
}

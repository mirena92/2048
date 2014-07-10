package com.hackbulgaria.corejava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Stack;


public class Game {

    private final int boardDimensions = 4;
    private int[][] board = new int[boardDimensions][boardDimensions];
    private Stack<int[][]> undo = new Stack<>();
    private Stack<int[][]> redo = new Stack<>();
    
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
            createNewList(column, newColumn);   
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
        if (!undo.isEmpty()) {
            if (!Arrays.deepEquals(undo.peek(), board)) {
                if (hasZeroElements()) {
                    placeRandomNumber();
                    undo.push(board);
                }
            }
        }
    }
    
    public void moveUp() {      
        List<Integer> column = new ArrayList<>();
        List<Integer> newColumn = new ArrayList<>();
        for(int y=0; y<boardDimensions; y++) {           
            column.clear();
            newColumn.clear();           
            for(int x=0; x<boardDimensions; x++) {
                if(board[x][y]!=0) {
                    column.add(board[x][y]);
                }
            }
            createNewList(column, newColumn);            
            for(int x=0; x<boardDimensions; x++) {
                if (!newColumn.isEmpty()) {
                    board[x][y] = newColumn.get(0);
                    newColumn.remove(0);
                }
                else {
                    board[x][y] = 0;
                }
            }
        }
        if (!undo.isEmpty()) {
            if (!Arrays.deepEquals(undo.peek(), board)) {
                if (hasZeroElements()) {
                    placeRandomNumber();
                    undo.push(board);
                }
            }
        }
    }
    
    public void moveLeft() {      
        List<Integer> row = new ArrayList<>();
        List<Integer> newRow = new ArrayList<>();
        for(int x=0; x<boardDimensions; x++) {           
            row.clear();
            newRow.clear();           
            for(int y=0; y<boardDimensions; y++) {
                if(board[x][y]!=0) {
                    row.add(board[x][y]);
                }
            }
            createNewList(row, newRow);            
            for(int y=0; y<boardDimensions; y++) {
                if (!newRow.isEmpty()) {
                    board[x][y] = newRow.get(0);
                    newRow.remove(0);
                }
                else {
                    board[x][y] = 0;
                }
            }
        }
        if (!undo.isEmpty()) {
            if (!Arrays.deepEquals(undo.peek(), board)) {
                if (hasZeroElements()) {
                    placeRandomNumber();
                    undo.push(board);
                }
            }
        }
    }
    
    public void moveRight() {    
        List<Integer> row = new ArrayList<>();
        List<Integer> newRow = new ArrayList<>();
        for(int x=0; x<boardDimensions; x++) {            
            row.clear();
            newRow.clear();
            for(int y=boardDimensions-1; y>=0; y--) {
                if(board[x][y]!=0) {
                    row.add(board[x][y]);
                }
            }            
            createNewList(row, newRow);   
            for(int y=boardDimensions-1; y>=0; y--) {
                if (!newRow.isEmpty()) {
                    board[x][y] = newRow.get(0);
                    newRow.remove(0);
                }
                else {
                    board[x][y] = 0;
                }
            }
        }
        if (!undo.isEmpty()) {
            if (!Arrays.deepEquals(undo.peek(), board)) {
                if (hasZeroElements()) {
                    placeRandomNumber();
                    undo.push(board);
                }
            }
        }
    }
    
    private void createNewList (List<Integer> currentList, List<Integer> newList) {
        if(!currentList.isEmpty()) {
            for(int i=0; i<currentList.size(); i++) {
                if(i<currentList.size()-1 && currentList.get(i)==currentList.get(i+1)) {
                    newList.add(currentList.get(i)*2);
                    currentList.remove(i+1);
                    currentList.add(0);                        
                }
                else {
                    newList.add(currentList.get(i));
                }
            }
        }
    }
    
    public boolean hasZeroElements() {
        
        for(int i=0; i<boardDimensions; i++) {
            for(int j=0; j<boardDimensions; j++) {
                if(board[i][j]==0) {
                    return true;                    
                }
            }
        }
        return false;
    }
    
    public boolean isLost() {        
        if(!hasZeroElements()) {
            for(int x=0; x<boardDimensions; x++) {
                for(int y=0; y<boardDimensions-1; y++) {
                    if(board[x][y]==board[x][y+1]) {
                        return false;
                    }
                }
            }
            for(int y=0; y<boardDimensions; y++) {
                for(int x=0; x<boardDimensions-1; x++) {
                    if(board[x][y]==board[x+1][y]) {
                        return false;
                    }
                }
            }
        }
        return false;
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

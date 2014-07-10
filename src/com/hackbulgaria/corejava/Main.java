package com.hackbulgaria.corejava;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        
        int[][] x = game.getBoard();
        
        for(int i=0; i<4; i++) {
            for(int j=0; j<4; j++) {
                System.out.print(x[i][j]);
            }
            System.out.println();
        }
    }
}

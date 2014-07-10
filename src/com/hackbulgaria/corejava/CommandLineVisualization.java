package com.hackbulgaria.corejava;

import java.io.IOException;

public class CommandLineVisualization implements Visualization {
    private Controller cntrl = new Controller();

    @Override
    public void displayBoard() throws IOException {
        while (true) {
            cntrl.keyTyped();
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(cntrl.game.getBoard()[i][j] + "  ");
                }
                System.out.println();
            }
        }
    }

    @Override
    public void displayWinMessage() {

    }

}

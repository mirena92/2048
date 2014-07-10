package com.hackbulgaria.corejava;

import java.io.IOException;

public class CommandLineVisualization implements Visualization {
    private Controller cntrl = new Controller();

    @Override
    public void displayBoard() throws IOException {
        while (true) {
            if (displayWinMessage()) {
                System.out.println("You won");
                break;
            } else {
                cntrl.keyTyped();
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.print(cntrl.game.getBoard()[i][j] + "  ");
                    }
                    System.out.println();
                }
                cntrl.setPlayerScore();
            }
        }
    }

    @Override
    public boolean displayWinMessage() {
        return cntrl.player.isWinning();
    }
}

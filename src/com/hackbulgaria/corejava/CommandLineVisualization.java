package com.hackbulgaria.corejava;

import java.io.IOException;

import jline.ConsoleReader;

public class CommandLineVisualization implements Visualization {
    private Controller cntrl = new Controller();

    @Override
    public void displayBoard() throws IOException {
        ConsoleReader console = new ConsoleReader();
        printBoard();
        while (true) {
            if (displayWinMessage()) {
                System.out.println("You won");
                break;
            } else {
                cntrl.keyTyped();
                console.clearScreen();
                printBoard();
                cntrl.setPlayerScore();
            }
        }
    }

    @Override
    public boolean displayWinMessage() {
        return cntrl.player.isWinning();
    }

    private void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(cntrl.game.getBoard()[i][j] + "  ");
            }
            System.out.println();
        }
    }
}

package com.hackbulgaria.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Controller {
    public Game game = new Game();
    private Player player = new Player();

    public void keyTyped() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String control = br.readLine();
        if (control.equals("s")) {
            this.game.moveDown();
        } else if (control.equals("w")) {
            this.game.moveUp();
        } else if (control.equals("a")) {
            this.game.moveLeft();
        } else if (control.equals("d")) {
            this.game.moveRight();
        } else if (control.equals("u")) {
            this.game.undo();
        } else if (control.equals("r")) {
            this.game.redo();
        }
    }
}

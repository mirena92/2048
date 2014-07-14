package com.hackbulgaria.corejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import jline.Terminal;

public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;
    public Game game = new Game();
    public Player player = new Player();
    private transient Terminal terminal = Terminal.setupTerminal();
    private int x;

    public void keyTyped() throws IOException {

        x = terminal.readVirtualKey(System.in);
        if (x == Keys.DOWN_ARROW.getNumber()) {
            this.game.moveDown();
        } else if (x == Keys.UP_ARROW.getNumber()) {
            this.game.moveUp();
        } else if (x == Keys.LEFT_ARROW.getNumber()) {
            this.game.moveLeft();
        } else if (x == Keys.RIGHT_ARROW.getNumber()) {
            this.game.moveRight();
        } else if (x == Keys.U.getNumber()) {
            this.game.undo();
        } else if (x == Keys.R.getNumber()) {
            this.game.redo();
        } else if (x == Keys.N.getNumber()) {
            this.game = new Game();
        } else if (x == Keys.Q.getNumber()) {
            System.exit(0);
        } else if (x == Keys.S.getNumber()) {
            save();
        } else if (x == Keys.L.getNumber()) {
            load();
        }
    }
    
    public void keyTypedGUI(int keyType) {    
        if (keyType == Keys.DOWN_ARROW.getNumber()) {
            this.game.moveDown();
        } else if (keyType == Keys.UP_ARROW.getNumber()) {
            this.game.moveUp();
        } else if (keyType == Keys.LEFT_ARROW.getNumber()) {
            this.game.moveLeft();
        } else if (keyType == Keys.RIGHT_ARROW.getNumber()) {
            this.game.moveRight();
        }
    }
    

    public void load() {
        try {
            FileInputStream fileIn = new FileInputStream("/home/emilian/tmp/game.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            Controller newController = (Controller) in.readObject();
            game.setBoard(newController.game.getBoard());
            player = newController.player;
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }

    public void save() {
        try {
            FileOutputStream fileOut = new FileOutputStream("/home/emilian/tmp/game.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(this);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }

    }

    public void setPlayerScore() {
        int max = game.getBoard()[0][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (max < game.getBoard()[i][j]) {
                    max = game.getBoard()[i][j];
                }
            }
        }
        player.setScore(max);
    }
}

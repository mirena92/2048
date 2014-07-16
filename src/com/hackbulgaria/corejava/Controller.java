package com.hackbulgaria.corejava;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Controller implements Serializable {

    private static final long serialVersionUID = 1L;
    public Game game = new Game();
    public Player player = new Player();

    public void keyTyped(int keyType) {

        if (keyType == Keys.DOWN_ARROW.getNumber()) {
            game.moveDown();
        } else if (keyType == Keys.UP_ARROW.getNumber()) {
            game.moveUp();
        } else if (keyType == Keys.LEFT_ARROW.getNumber()) {
            game.moveLeft();
        } else if (keyType == Keys.RIGHT_ARROW.getNumber()) {
            game.moveRight();
        } else if (keyType == Keys.U.getNumber()) {
            game.undo();
        } else if (keyType == Keys.R.getNumber()) {
            game.redo();
        } else if (keyType == Keys.N.getNumber()) {
            game = new Game();
        } else if (keyType == Keys.Q.getNumber()) {
            System.exit(0);
        } else if (keyType == Keys.S.getNumber()) {
            save();
        } else if (keyType == Keys.L.getNumber()) {
            load();
        }

    }

    public void load() {
        FileInputStream fileIn = null;
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                fileIn = new FileInputStream(System.getProperty("user.dir") + "\\game.ser");
            } else {
                fileIn = new FileInputStream(System.getProperty("user.dir") + "/game.ser");
            }
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
        FileOutputStream fileOut = null;
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                fileOut = new FileOutputStream(System.getProperty("user.dir") + "\\game.ser");
            } else {
                fileOut = new FileOutputStream(System.getProperty("user.dir") + "/game.ser");
            }
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

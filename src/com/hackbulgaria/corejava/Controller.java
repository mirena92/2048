package com.hackbulgaria.corejava;

import java.io.IOException;

import jline.ConsoleOperations;
import jline.ConsoleReader;
import jline.Terminal;
import jline.WindowsTerminal;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Controller implements Serializable {
    public Game game = new Game();
    public Player player = new Player();

    public void keyTyped() throws IOException {

        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String control = br.readLine();
        
        Terminal terminal = Terminal.setupTerminal();            
        int x = terminal.readVirtualKey(System.in);
        System.out.println(x);
        x = terminal.readCharacter(System.in);
        System.out.println(x);

//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String control = br.readLine();
//        if (control.equals("s")) {
//            this.game.moveDown();
//        } else if (control.equals("w")) {
//            this.game.moveUp();
//        } else if (control.equals("a")) {
//            this.game.moveLeft();
//        } else if (control.equals("d")) {
//            this.game.moveRight();
//        } else if (control.equals("u")) {
//            this.game.undo();
//        } else if (control.equals("r")) {
//            this.game.redo();
//        } else if (control.equals("n")) {
//            this.game = new Game();
//        } else if (control.equals("q")) {
//            System.exit(0);
//        } else if (control.equals("k")) {
//            save();
//        } else if (control.equals("l")) {
//            load();
//        }
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

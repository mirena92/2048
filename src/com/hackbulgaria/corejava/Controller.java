package com.hackbulgaria.corejava;

import java.io.IOException;

import jline.ConsoleOperations;
import jline.ConsoleReader;
import jline.Terminal;
import jline.WindowsTerminal;

public class Controller {
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
        
        //Terminal terminal = Terminal.setupTerminal();
        //int x = terminal.readVirtualKey(System.in);
        //System.out.println(x);
        
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
//        }
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

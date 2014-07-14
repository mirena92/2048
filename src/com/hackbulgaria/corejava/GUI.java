package com.hackbulgaria.corejava;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI extends JFrame implements Visualization {

    private static final long serialVersionUID = 1L;
    private final static Map<Integer, String> mapImages = new HashMap<>();
    static {
        try {
            initializeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Controller cntrl = new Controller();
    GridLayout gridLayout = new GridLayout(4, 4);
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    
    private JLabel createLabel(int x, int y) {
        ImageIcon icon = new ImageIcon(mapImages.get(cntrl.game.getBoard()[x][y]));
        JLabel label = new JLabel(icon);
        return label;
    }

    @Override
    public void displayBoard() throws IOException { 
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(gridLayout);
        
        this.addKeyListener(new MyKeyListener());        
        printBoard();
    }

    @Override
    public boolean displayLoseMessage() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean displayWinMessage() {
        // TODO Auto-generated method stub
        return false;
    }

    private void printBoard() {
        getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                add(createLabel(i, j));
                System.out.print(cntrl.game.getBoard()[i][j] + "  ");
            }
            System.out.println();
       }
        System.out.println();
    }
    
//    public class MyKeyListener implements KeyListener {
        public class MyKeyListener extends KeyAdapter {        

        public int keyType;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            System.out.println("In keyPressed");
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                keyType = Keys.DOWN_ARROW.getNumber();
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                keyType = Keys.UP_ARROW.getNumber();
            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                keyType = Keys.LEFT_ARROW.getNumber();
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                keyType = Keys.RIGHT_ARROW.getNumber();
            } else if (e.getKeyCode() == KeyEvent.VK_N) {
                keyType = Keys.N.getNumber();
            }
            cntrl.keyTypedGUI(keyType);
            printBoard();     
        }
    }     
    
    private static void initializeMap() throws IOException {
        String parent = "C:\\Users\\RUSHI\\Desktop\\coreJava\\2048\\images\\";
        mapImages.put(0, String.format("%s%s", parent, "empty.png"));
        mapImages.put(2, String.format("%s%s", parent, "2.png"));
        mapImages.put(4, String.format("%s%s", parent, "4.png"));
        mapImages.put(8, String.format("%s%s", parent, "8.png"));
        mapImages.put(16, String.format("%s%s", parent, "16.png"));
        mapImages.put(32, String.format("%s%s", parent, "32.png"));
        mapImages.put(64, String.format("%s%s", parent, "64.png"));
        mapImages.put(128, String.format("%s%s", parent, "128.png"));
        mapImages.put(256, String.format("%s%s", parent, "256.png"));
        mapImages.put(512, String.format("%s%s", parent, "512.png"));
        mapImages.put(1024, String.format("%s%s", parent, "1024.png"));
        mapImages.put(2048, String.format("%s%s", parent, "2048.png"));
    }
}

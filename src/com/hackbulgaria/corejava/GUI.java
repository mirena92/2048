package com.hackbulgaria.corejava;

import java.awt.AWTEvent;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ComponentEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

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
        return false;
    }

    @Override
    public boolean displayWinMessage() {
        return false;
    }

    private void printBoard() {
        getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                add(createLabel(i, j));
            }
        }
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                // TODO Auto-generated method stub
                // getContentPane().repaint();
                repaint();
                setVisible(true);
                // getContentPane().dr

            }
        });
    }

    public class MyKeyListener extends KeyAdapter {
        public int keyType;

        @Override
        public void keyPressed(KeyEvent e) {
            super.keyPressed(e);
            switch (e.getKeyCode()) {
                case KeyEvent.VK_DOWN:
                    keyType = Keys.DOWN_ARROW.getNumber();
                    break;
                case KeyEvent.VK_UP:
                    keyType = Keys.UP_ARROW.getNumber();
                    break;
                case KeyEvent.VK_LEFT:
                    keyType = Keys.LEFT_ARROW.getNumber();
                    break;
                case KeyEvent.VK_RIGHT:
                    keyType = Keys.RIGHT_ARROW.getNumber();
                    break;
                case KeyEvent.VK_N:
                    keyType = Keys.N.getNumber();
                    break;
                case KeyEvent.VK_S:
                    keyType = Keys.S.getNumber();
                    break;
                case KeyEvent.VK_U:
                    keyType = Keys.U.getNumber();
                    break;
                case KeyEvent.VK_R:
                    keyType = Keys.R.getNumber();
                    break;
                case KeyEvent.VK_Q:
                    keyType = Keys.Q.getNumber();
                    break;
                case KeyEvent.VK_L:
                    keyType = Keys.L.getNumber();
                    break;
            }

            cntrl.keyTyped(keyType);

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

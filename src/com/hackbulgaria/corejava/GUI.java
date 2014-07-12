package com.hackbulgaria.corejava;

import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GUI extends JFrame implements Visualization {
    private Controller cntrl = new Controller();
    Map<Integer, String> mapImages = new HashMap<>();
    GridLayout gridLayout = new GridLayout(4, 4);
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    @Override
    public void displayBoard() throws IOException {
        initializeMap();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);
        this.setLayout(gridLayout);
       
        printBoard();
    }

    @Override
    public boolean displayWinMessage() {
        // TODO Auto-generated method stub
        return false;
    }

    private void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                add(createLabel(i, j));
            }
        }
    }

    private JLabel createLabel(int x, int y) {
        ImageIcon icon = new ImageIcon(mapImages.get(cntrl.game.getBoard()[x][y]));
        JLabel label = new JLabel(icon);
        return label;
    }

    private void initializeMap() throws IOException {
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

    @Override
    public boolean displayLoseMessage() {
        // TODO Auto-generated method stub
        return false;
    }

}

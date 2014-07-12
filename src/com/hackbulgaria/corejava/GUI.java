package com.hackbulgaria.corejava;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GUI extends JFrame implements Visualization {
    private Controller cntrl = new Controller();
    Map<Integer, BufferedImage> map = new HashMap<>();
    //JFrame frame;
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    @Override
    public void displayBoard() throws IOException {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationByPlatform(true);
        this.pack();
        this.setVisible(true);
        this.setSize(WIDTH, HEIGHT);
        this.setLocationRelativeTo(null);     

        Graphics gr = this.getGraphics();
        gr.draw
    }

    @Override
    public boolean displayWinMessage() {
        // TODO Auto-generated method stub
        return false;
    }
    
    private void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
               
            }
            System.out.println();
        }
    }
    
    private void initializeMap() {
//        map.push(0, new BufferedImage(new File()));
//        map.push(2, new BufferedImage(new File()));
//        map.push(4, new BufferedImage(new File()));
//        map.push(8, new BufferedImage(new File()));
//        map.push(16, new BufferedImage(new File()));
//        map.push(32, new BufferedImage(new File()));
//        map.push(64, new BufferedImage(new File()));
//        map.push(128, new BufferedImage(new File()));
//        map.push(256, new BufferedImage(new File()));
//        map.push(512, new BufferedImage(new File()));
//        map.push(1024, new BufferedImage(new File()));
//        map.push(2048, new BufferedImage(new File()));        
    }

    @Override
    public boolean displayLoseMessage() {
        // TODO Auto-generated method stub
        return false;
    }

}

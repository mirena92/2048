package com.hackbulgaria.corejava;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class GUI implements Visualization {
    private Controller cntrl = new Controller();
    Map<Integer, BufferedImage> map = new HashMap<>();

    @Override
    public void displayBoard() throws IOException {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);     
        
        List<BufferedImage> listNumbers = new ArrayList<>();
               
        
    }

    @Override
    public boolean displayWinMessage() {
        // TODO Auto-generated method stub
        return false;
    }
    
    private void printBoard() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(cntrl.game.getBoard()[i][j] + "  ");
            }
            System.out.println();
        }
    }
    
    private void initializeMap() {
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

}

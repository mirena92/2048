package com.hackbulgaria.corejava;

import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class GUI extends JFrame implements Visualization {
    private static void extracted() throws IOException {
        BufferedImage image = ImageIO.read(new File("/home/emilian/Pictures/danger-doom.jpg"));
    }

    private Controller cntrl = new Controller();
    Map<Integer, String> mapImages = new HashMap<>();
    GridLayout gridLayout = new GridLayout(4, 4);
    private final int WIDTH = 400;

    private final int HEIGHT = 400;

    private JLabel crateLabel() {
        try {
            extracted();
            // ImageIcon icon = new
            // ImageIcon("C:\\Users\\RUSHI\\Desktop\\dog.jpg");
            JLabel label = new JLabel("dadadadada");
            return label;
        } catch (IOException e) {
            // // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

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
    public boolean displayLoseMessage() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean displayWinMessage() {
        // TODO Auto-generated method stub
        return false;
    }

    private void initializeMap() throws IOException {
        // File parent = new
        // File("C:\\Users\\RUSHI\\Desktop\\coreJava\\2048\\images\\");
        // mapImages.put(0, ImageIO.read(new File(parent, "empty.png")));
        // mapImages.put(2, ImageIO.read(new File(parent, "2.png")));
        // mapImages.put(4, ImageIO.read(new File(parent, "4.png")));
        // mapImages.put(8, ImageIO.read(new File(parent, "8.png")));
        // mapImages.put(16, ImageIO.read(new File(parent, "16.png")));
        // mapImages.put(32, ImageIO.read(new File(parent, "32.png")));
        // mapImages.put(64, ImageIO.read(new File(parent, "64.png")));
        // mapImages.put(128, ImageIO.read(new File(parent, "128.png")));
        // mapImages.put(256, ImageIO.read(new File(parent, "256.png")));
        // mapImages.put(512, ImageIO.read(new File(parent, "512.png")));
        // mapImages.put(1024, ImageIO.read(new File(parent, "1024.png")));
        // mapImages.put(2048, ImageIO.read(new File(parent, "2048.png")));

        String parent = "/home/emilian/workspace/2048/images/";
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

    private void printBoard() {
        JLabel label = new JLabel();
        String currentImage;
        // for (int i = 0; i < 4; i++) {
        // for (int j = 0; j < 4; j++) {
        // currentImage = mapImages.get(cntrl.game.getBoard()[i][j]);
        // currentImage = mapImages.get(2);
        // label.setIcon(new ImageIcon(currentImage));
        // this.add(label);
        // this.add(label);
        // currentImage = mapImages.get(8);
        // label.setIcon(new ImageIcon(currentImage));
        // this.add(label);
        // this.add(label);
        // this.add(label);
        // this.add`
        // }

        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());
        add(crateLabel());

    }

}

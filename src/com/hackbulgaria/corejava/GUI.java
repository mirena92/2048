package com.hackbulgaria.corejava;

import java.awt.GridLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
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
    JMenuBar menubar;
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
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setLayout(gridLayout);
        this.addKeyListener(new MyKeyListener());
        this.setIconImage(ImageIO.read(new File(mapImages.get(2048))));
        this.setTitle("2048");
        addMenuBar();        
        
        printBoard();
    }

    @Override
    public boolean displayLoseMessage() {
        return cntrl.game.isLost();
    }

    @Override
    public boolean displayWinMessage() {
        return cntrl.player.isWinning();
    }

    private void printBoard() {
        getContentPane().removeAll();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                add(createLabel(i, j));
            }
        }
        cntrl.setPlayerScore();
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                repaint();
                setVisible(true);
            }
        });
    }

    public class MyKeyListener extends KeyAdapter {
        public int keyType;

        @Override
        public void keyPressed(KeyEvent e) {

            if (displayWinMessage()) {
                JOptionPane.showMessageDialog(getParent(), "You win!!!");
            } else if (displayLoseMessage()) {
                JOptionPane.showMessageDialog(getParent(), "You lose!!!");
            } else {
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
                }
            }
            cntrl.keyTyped(keyType);
            printBoard();
        }
    }

    private void addMenuBar() {
        menubar = new JMenuBar();
       
        JMenu menu = new JMenu("File");
        
        JMenuItem newGame = new JMenuItem("New game");
        newGame.setFocusable(true);
        newGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.N.getNumber());
                printBoard();
            }
        });
        
        JMenuItem saveGame = new JMenuItem("Save game");
        saveGame.setFocusable(true);
        saveGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.S.getNumber());
                printBoard();
            }
        });
        
        JMenuItem loadGame = new JMenuItem("Load game");
        loadGame.setFocusable(true);
        loadGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.L.getNumber());
                printBoard();
            }
        });
        
        JMenuItem quit = new JMenuItem("Quit");
        quit.setFocusable(true);
        quit.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.Q.getNumber());
                printBoard();
            }
        });
        
        menu.add(newGame);
        menu.add(saveGame);
        menu.add(loadGame);
        menu.add(quit);
        menubar.add(menu);
        
        JMenu edit = new JMenu("Edit");
        
        JMenuItem undo = new JMenuItem("Undo");
        undo.setFocusable(true);
        undo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.U.getNumber());
                printBoard();
            }
        });
        
        JMenuItem redo = new JMenuItem("Redo");
        redo.setFocusable(true);
        redo.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                cntrl.keyTyped(Keys.R.getNumber());
                printBoard();
            }
        });
        
        edit.add(undo);
        edit.add(redo);
        menubar.add(edit);
        
        JMenu help = new JMenu("Help");
        
        JMenuItem about = new JMenuItem("About...");
        about.setFocusable(true);
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                    JDialog f = new AboutDialog(new JFrame());
                    f.setLocationRelativeTo(null);
                    f.show();
            }
        });
        
        help.add(about);
        menubar.add(help);
        
        setJMenuBar(menubar);
    }
    
    private void addAboutBox() {

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

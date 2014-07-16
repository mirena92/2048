package com.hackbulgaria.corejava;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

    public class MyKeyListener extends KeyAdapter {
        public int keyType;

        @Override
        public void keyPressed(KeyEvent e) {

            if (displayWinMessage()) {
                try {
                    JOptionPane.showMessageDialog(getParent(), "You win!!!", "Congratulations!",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/winIcon.png"))));
                } catch (HeadlessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            } else if (displayLoseMessage()) {

                try {
                    JOptionPane.showMessageDialog(getParent(), "You lose, try again!", "Sorry!",
                            JOptionPane.INFORMATION_MESSAGE,
                            new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/loseIcon.png"))));
                } catch (HeadlessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
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

    private static final long serialVersionUID = 1L;
    private final static Map<Integer, Image> mapImages = new HashMap<>();
    static {
        try {
            initializeMap();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void initializeMap() throws IOException {

        mapImages.put(0, ImageIO.read(GUI.class.getResourceAsStream("/empty.png")));
        mapImages.put(2, ImageIO.read(GUI.class.getResourceAsStream("/2.png")));
        mapImages.put(4, ImageIO.read(GUI.class.getResourceAsStream("/4.png")));
        mapImages.put(8, ImageIO.read(GUI.class.getResourceAsStream("/8.png")));
        mapImages.put(16, ImageIO.read(GUI.class.getResourceAsStream("/16.png")));
        mapImages.put(32, ImageIO.read(GUI.class.getResourceAsStream("/32.png")));
        mapImages.put(64, ImageIO.read(GUI.class.getResourceAsStream("/64.png")));
        mapImages.put(128, ImageIO.read(GUI.class.getResourceAsStream("/128.png")));
        mapImages.put(256, ImageIO.read(GUI.class.getResourceAsStream("/256.png")));
        mapImages.put(512, ImageIO.read(GUI.class.getResourceAsStream("/512.png")));
        mapImages.put(1024, ImageIO.read(GUI.class.getResourceAsStream("/1024.png")));
        mapImages.put(2048, ImageIO.read(GUI.class.getResourceAsStream("/2048.png")));
    }

    private Controller cntrl = new Controller();
    GridLayout gridLayout = new GridLayout(4, 4);
    JMenuBar menubar;

    private final int WIDTH = 400;

    private final int HEIGHT = 400;

    private void addMenuBar() throws IOException {
        menubar = new JMenuBar();

        JMenu menu = new JMenu("File");

        JMenuItem newGame = new JMenuItem("New game");
        newGame.setFocusable(true);
        newGame.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/newIcon.png"))));
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
        saveGame.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/saveIcon.png"))));
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
        loadGame.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/loadIcon.png"))));
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
        quit.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/quitIcon.png"))));
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
        undo.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/undoIcon.png"))));
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
        redo.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/redoIcon.png"))));
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
        about.setIcon(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/questionIcon.png"))));
        about.setFocusable(true);
        about.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                JDialog f = null;
                try {
                    f = new AboutDialog(new JFrame());
                } catch (HeadlessException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                f.setLocationRelativeTo(null);
                f.setVisible(true);
            }
        });

        help.add(about);
        menubar.add(help);

        setJMenuBar(menubar);
    }

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
        this.setIconImage(mapImages.get(2048));
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
}

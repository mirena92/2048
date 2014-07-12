package com.hackbulgaria.corejava;

import java.io.IOException;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) throws IOException {

        SwingUtilities.invokeLater(new Runnable() {
            
            @Override
            public void run() {
                Visualization gui = new GUI();
                try {
                    gui.displayBoard();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });

    }
}

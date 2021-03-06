package com.hackbulgaria.corejava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AboutDialog extends JDialog {

    private static final long serialVersionUID = 1L;

    public AboutDialog(JFrame parent) throws IOException {
        super(parent, "About...", true);

        Box b = Box.createVerticalBox();
        try {
            setIconImage(ImageIO.read(getClass().getResourceAsStream("/question.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        b.add(Box.createGlue());
        b.add(new JLabel(new ImageIcon(ImageIO.read(getClass().getResourceAsStream("/HackBulgariaIcon.png")))));
        b.add(new JLabel(" "));
        b.add(new JLabel(" Course Core Java in Hack Bulgaria"));
        b.add(new JLabel(" Web-site: https://hackbulgaria.com/"));
        b.add(new JLabel(" Facebook: https://www.facebook.com/HackBulgaria"));
        b.add(new JLabel(" "));
        b.add(new JLabel(" Lecturer: Georgi Pachov"));
        b.add(new JLabel(" Email: georgi.patchov@gmail.com"));
        b.add(new JLabel(" "));
        b.add(new JLabel(" "));
        b.add(new JLabel(" Developers:"));
        b.add(new JLabel(" "));
        b.add(new JLabel("   Emilian Stankov, Sofia University"));
        b.add(new JLabel("   Email: eminstine@abv.bg"));
        b.add(new JLabel(" "));
        b.add(new JLabel("   Mirena Kermilska, Technical University of Sofia"));
        b.add(new JLabel("   Email: mirena.k@abv.bg"));
        b.add(Box.createGlue());
        getContentPane().add(b, "Center");

        JPanel p2 = new JPanel();
        JButton ok = new JButton("Ok");
        p2.add(ok);
        getContentPane().add(p2, "South");

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setVisible(false);
            }
        });

        setSize(415, 450);
    }
}

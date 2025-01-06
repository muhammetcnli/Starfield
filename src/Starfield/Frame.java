package Starfield;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;


public class Frame extends JFrame {

    public Frame(){
        setTitle("Starfield");

        setSize(800, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StarfieldCanvas canvas = new StarfieldCanvas();
        add(canvas, BorderLayout.CENTER);
    }

    public static void main(String[] args) {

        Frame frame = new Frame();
        frame.setVisible(true);
    }

}

package Starfield;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarfieldCanvas extends JPanel{

    private int width;
    private int height;
    private Timer timer;

    private final int DELAY = 5;
    private final int STAR_TRACE_COUNT = 50;

    public StarfieldCanvas(int width, int height){
        setBounds(0,0,width,height);
        setBackground(Color.BLACK);
        this.width=width;
        this.height=height;


    }

}

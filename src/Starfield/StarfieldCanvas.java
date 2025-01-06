package Starfield;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.Timer;

public class StarfieldCanvas extends JPanel{

    private static final int STAR_COUNT = 1000;
    private static final int STAR_SPEED = 15;
    private int[] starX = new int[STAR_COUNT];
    private int[] starY = new int[STAR_COUNT];
    private int[] starZ = new int[STAR_COUNT];
    private final Random rand = new Random();
    private Color[] starColors = new Color[STAR_COUNT]; //Optional, for coloring purposes
    private static final int SCREEN_WIDTH = 800;
    private static final int SCREEN_HEIGHT = 600;
    private static final int MAX_Z = 800;

    public StarfieldCanvas() {


        for (int i = 0; i < STAR_COUNT; i++) {
            // Random star locations
            resetStar(i);
        }

        Timer timer = new Timer(30, e -> {
            updateStars();
            repaint();
        });
        timer.start();
    }

    private void resetStar(int i){
        starX[i] = rand.nextInt(SCREEN_WIDTH) - SCREEN_WIDTH / 2;
        starY[i] = rand.nextInt(SCREEN_HEIGHT) - SCREEN_HEIGHT / 2;
        starZ[i] = rand.nextInt(MAX_Z) + 1;

        starColors[i] = new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256));
    }

    private void updateStars(){
        for(int i = 0; i < STAR_COUNT; i++){

            //Update z dimention based on StarSpeed
            starZ[i] -= STAR_SPEED;

            if (starZ[i] <= 0){
                resetStar(i);
            }
        }
    }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            // Black background
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, getWidth(), getHeight());



            for (int i = 0; i < STAR_COUNT; i++) {
                int screenX = (int) (getWidth() / 2 +(starX[i] / (double) starZ[i]) * getWidth());
                int screenY = (int) (getHeight() / 2 + (starY[i] / (double) starZ[i]) * getHeight());


                int prevScreenX = (int) (getWidth() / 2 + (starX[i] / (double) (starZ[i] + 5)) * getWidth());
                int prevScreenY = (int) (getHeight() / 2 + (starY[i] / (double) (starZ[i] + 5)) * getHeight());


                int traceLength = Math.max(10, (int) (MAX_Z - starZ[i]) / 5);

                float lineThickness = Math.max(1f, 10f - (float) starZ[i] / (MAX_Z / 10)); // Z increases as stars get close
                g2d.setStroke(new BasicStroke(lineThickness));

                g.setColor(Color.white );//starColors[i]

                // Draw Star Trace
                for (int j = 0; j < traceLength; j++) {
                    int intermediateX = (int) (prevScreenX + (screenX - prevScreenX) * (j / (float) traceLength));
                    int intermediateY = (int) (prevScreenY + (screenY - prevScreenY) * (j / (float) traceLength));


                    // Draw star trace
                    g.drawLine(intermediateX, intermediateY, screenX, screenY);
                }


                // float size = Math.max(1f, 10f - (float) starZ[i] / (MAX_Z / 10));

                // Draw the star as .
                // g.fillOval(screenX, screenY, (int) size, (int) size);

            }

        }
}

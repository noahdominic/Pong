package pong.Index2;

/**
 * Created by Noah Dominic on 26/10/2016.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PongGame2 extends JPanel {

    int x = 0;
    int y = 0;

    private void moveBall() {
        x = x + 1;
        y = y + 1;
    }

    @Override
    public void paint(Graphics g) {
        //This line erases the previous shape.
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, 30, 30);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Pong");
        PongGame2 game = new PongGame2();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            /**
             * This loop allows the ball to change position and be repainted. The last line allows the processor to
             * rest for 10 milliseconds or execute other threads.
             */
            game.moveBall();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
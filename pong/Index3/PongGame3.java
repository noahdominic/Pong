package pong.Index3;

/**
 * Created by Noah Dominic on 26/10/2016.
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Instead of writing everything in one file, the "ball" has its own class file. This allows for better efficiency
 * especially when more object begin to appear on screen.
 */

@SuppressWarnings("serial")
public class PongGame3 extends JPanel {

    Ball ball = new Ball(this); //this is required to let ball access getWidth() & getLength()

    private void move() {
        ball.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        PongGame3 game = new PongGame3();
        frame.add(game);
        frame.setSize(300, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
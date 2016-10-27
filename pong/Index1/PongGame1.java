package pong.Index1;

/**
 * Created by Noah Dominic on 26/10/2016.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class PongGame1 extends JPanel{

    @Override
    public void paint (Graphics g) {
        /**
         * This function is called every time there is a change in the window (i.e. minimising, maximising, change of
         * window size via mouse) and when the window is first created.
         *
         * Before doing anything, g is casted as a Graphics2D object because, according to the website, it has
         * "more and better functionality." I haven't really read about them much but I'll trust the site's word.
         * After all, more recent versions of anything should be better, right?
         *
         * The objects are painted here using either a "fill" function which draws a filled shape or a "draw" function
         * which draws an empty shape. The arguments are as follows: (x-pos, y-pos(positive numbers indicate down),
         * width, height). I've  observed that the objects are not drawn in reference to their centre point. Instead,
         * their top corner is used (if we imagine the shape encased in a square.)
         */
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillOval(0, 0, 30, 30);
        g2d.drawOval(0, 50, 30, 30);
        g2d.fillRect(50, 0, 30, 30);
        g2d.drawRect(50, 50, 30, 30);

        g2d.draw(new Ellipse2D.Double(0, 100, 30, 30));
    }

    public static void main(String[] args) {

        JFrame frame = new JFrame("Pong");
        //Line below is called when the windows is first created.
        frame.add(new PongGame1());
        frame.setSize(300, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}


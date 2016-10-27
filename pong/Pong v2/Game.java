

/**
 * Created by Noah Dominic on 27/10/2016.
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import static com.sun.deploy.uitoolkit.ToolkitStore.dispose;
import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;

@SuppressWarnings("serial")
public class Game extends JPanel {

    Ball ball = new Ball(this);
    Racquet racquet = new Racquet(this, KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, 330);
    Racquet racquet2 = new Racquet(this, KeyEvent.VK_A, KeyEvent.VK_D, 50);
    //Racquet racquet2 = new Racquet(this, KeyEvent.VK_A, KeyEvent.VK_D, 330);
    int speed = 1;

    public Game() {
        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                racquet.keyReleased(e);
                racquet2.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                racquet.keyPressed(e);
                racquet2.keyPressed(e);
            }
        });
        setFocusable(true);
        Sound.BACK.loop();
    }

    private void move() throws InterruptedException {
        ball.move();
        racquet.move();
        racquet2.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        ball.paint(g2d);
        racquet.paint(g2d, Color.red);
        racquet2.paint(g2d, Color.blue);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        g2d.drawString(String.valueOf(racquet.getScore()), 10, 30);

        g2d.setColor(Color.GRAY);
        g2d.setFont(new Font("Segoe UI Semilight", Font.BOLD, 30));
        g2d.drawString(String.valueOf(racquet2.getScore()), 250, 30);
    }

    public void gameOver() {
        Sound.BACK.stop();
        Sound.GAMEOVER.play();

        Object[] options = { "OK", "CANCEL" };
        int result = JOptionPane.showConfirmDialog(null,
                "Red: " + racquet.getScore() + "\nBlue: " + racquet2.getScore() + "\nDo you want to restart?", "GAME OVER", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION){
            gameReset();
        } else {
            System.exit(ABORT);
        }


    }

    public void gameReset() {
        racquet.reset();
        racquet2.reset();
        ball.reset();
        Sound.GAMEOVER.stop();
        Sound.BACK.loop();
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame = new JFrame("Mini Tennis");
        Game game = new Game();
        frame.add(game);
        frame.setSize(300, 450);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(10);
        }
    }
}
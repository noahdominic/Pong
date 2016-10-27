package pong.Index5;

/**
 * Created by Noah Dominic on 27/10/2016.
 */

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

public class Racquet {
    int x = 0;
    int xa = 0;
    private Game game;

    public Racquet(Game game) {
        //received game is copied to the Game object in Racquet class. This is to access getWidth()
        this.game = game;
    }

    public void move() {
        //With xa serving as the racquet speed, this moves the raquet.
        if (x + xa > 0 && x + xa < game.getWidth()-60)
            x = x + xa;
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, 330, 60, 10);
    }

    public void keyReleased(KeyEvent e) {
        //sets the racquet speed to 0 because it's not moving anymore.
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        //depending on the key pressed, the speed is changed. (xa<0 for left, xa>0 for right.)
        if (e.getKeyCode() == KeyEvent.VK_LEFT)
            xa = -1;
        if (e.getKeyCode() == KeyEvent.VK_RIGHT)
            xa = 1;
    }
}
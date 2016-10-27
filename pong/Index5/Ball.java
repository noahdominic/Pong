package pong.Index5;

/**
 * Created by Noah Dominic on 27/10/2016.
 */

import java.awt.Graphics2D;

//This implementation is the same as in Index3
public class Ball {
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;

    public Ball(Game game) {
        this.game= game;
    }

    void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - 30)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - 30)
            ya = -1;

        x = x + xa;
        y = y + ya;
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, 30, 30);
    }
}
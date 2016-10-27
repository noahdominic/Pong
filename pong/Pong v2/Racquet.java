

/**
 * Created by Noah Dominic on 27/10/2016.
 */
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Racquet {
    private int Y;
    private static final int WITH = 60;
    private static final int HEIGHT = 10;
    int x = 100;
    int xa = 0;
    private Game game;
    int l, r;
    private int points = 0;
    Color c;

    public Racquet(Game game, int l, int r, int Y) {
        this.l = l;
        this.r = r;
        this.Y = Y;
        this.game = game;
    }
    public void reset(){
        points = 0;
        x = 0;
        xa = 0;
    }

    public void move() {
        if (x + xa > 0 && x + xa < game.getWidth() - WITH)
            x = x + xa;
    }

    public void upPoints(){
        points++;
    }

    public void paint(Graphics2D g, Color c) {
        this.c = c;
        g.setColor(c);
        g.fillRect(x, Y, WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == l)
            xa = -game.speed;
        if (e.getKeyCode() == r)
            xa = game.speed;
    }

    public int getScore(){ return points;}

    public Rectangle getBounds() {
        return new Rectangle(x, Y, WITH, HEIGHT);
    }

    public int getTopY() {
        return Y - HEIGHT;
    }

    public int getBotY() {
        return Y;
    }
}

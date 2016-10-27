package pong.Index7;

/**
 * Created by Noah Dominic on 27/10/2016.
 */

/**
 * I TRIED to implement the audio independently without copying the exact code from the website.
 */

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;


public class Ball {
    private static final int DIAMETER = 30;
    int x = 0;
    int y = 0;
    int xa = 1;
    int ya = 1;
    private Game game;
    URL url;
    AudioClip clip;

    public Ball(Game game) throws MalformedURLException {
        //this sends the location of the poink sfx and gives it to url
        url = Ball.class.getResource("poink2.wav");
        //clip now stores whatever sound that the location in url stores
        clip = Applet.newAudioClip(url);
        this.game= game;
    }

    void move() {
        if (x + xa < 0)
            xa = 1;
        if (x + xa > game.getWidth() - DIAMETER)
            xa = -1;
        if (y + ya < 0)
            ya = 1;
        if (y + ya > game.getHeight() - DIAMETER)
            game.gameOver();
        if (collision()){
            clip.play();
            ya = -1;
            y = game.racquet.getTopY() - DIAMETER;
        }
        x = x + xa;
        y = y + ya;
    }

    private boolean collision() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}

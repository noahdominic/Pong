

/**
 * Created by Noah Dominic on 27/10/2016.
 */
import java.awt.*;

public class Ball {
    private static final int DIAMETER = 30;

    int x = 150;
    int y = 225;
    int xa = -2;
    int ya = -1;
    private Game game;

    public Ball(Game game) {
        this.game = game;
    }

    void move() throws InterruptedException {
        boolean changeDirection = true;
        if (x + xa < 0)
            xa = game.speed;
        else if (x + xa > game.getWidth() - DIAMETER)
            xa = -game.speed;
        else if (y + ya < 0) {
            game.racquet.upPoints();
            Thread.sleep(200);
            reset();
        }
        else if (y + ya > game.getHeight() - DIAMETER) {
            game.racquet2.upPoints();
            Thread.sleep(200);
            reset();
        }
        else if (collisionA() || collisionB()){
            System.out.println("YES");
            if(collisionA() == true) {
                ya = -game.speed;
                y = game.racquet.getTopY() - DIAMETER;
            } else if (collisionB() == true) {
                ya = game.speed;
                y = game.racquet2.getBotY() + DIAMETER;
            }
            game.speed++;

        } else
            changeDirection = false;

        if (changeDirection)
            Sound.BALL.play();
        x = x + xa;
        y = y + ya;
        if(game.racquet.getScore() >= 3 || game.racquet2.getScore()>=3){
            game.gameOver();
        }
    }

    public void reset() {
        x = 150;
        y = 225;
        xa = -1;
        ya = -1;
    }

    private boolean collisionA() {
        return game.racquet.getBounds().intersects(getBounds());
    }

    private boolean collisionB() {
        return game.racquet2.getBounds().intersects(getBounds());
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.black);
        g.fillOval(x, y, DIAMETER, DIAMETER);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, DIAMETER, DIAMETER);
    }
}
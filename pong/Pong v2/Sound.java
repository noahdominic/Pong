

/**
 * Created by Noah Dominic on 27/10/2016.
 */
import java.applet.Applet;
import java.applet.AudioClip;

//this was created to provide a more efficient reuse of sounds
public class Sound {
    public static final AudioClip BALL = Applet.newAudioClip(Sound.class.getResource("poink2.wav"));
    public static final AudioClip GAMEOVER = Applet.newAudioClip(Sound.class.getResource("gameover.wav"));
    public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("game.wav")); // Shovel Knight OST
    //public static final AudioClip BACK = Applet.newAudioClip(Sound.class.getResource("back.wav")); // Kirby OST
}

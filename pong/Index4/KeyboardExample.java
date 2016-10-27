package pong.Index4;

/**
 * Created by Noah Dominic on 27/10/2016.
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class KeyboardExample extends JPanel {

    public KeyboardExample() {
        /**
         * This constructor creates a KeyListener object that is added in 'Index4.' Setting focusable as true
         * is necessary to allow listener to accept keyboard inputs.
         */
        KeyListener listener = new MyKeyListener();
        addKeyListener(listener);
        setFocusable(true);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Mini Tennis");
        KeyboardExample keyboardExample = new KeyboardExample();
        frame.add(keyboardExample);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public class MyKeyListener implements KeyListener {
        /**
         * These are the functions in KeyListener.
         * keyTyped() <- pressed and released. keyboard shortcuts and shift + letter/ number are considered as one
         * keyPressed() <- pressed alone
         * keyReleased() <- released alone
         */
        @Override
        public void keyTyped(KeyEvent e) {
            //must be implemented because KeyListener is abstract. This function can be empty though.
            //this is my own addition. I wanted to see what the difference between the three functions are.
            System.out.println("keyTyped="+KeyEvent.getKeyText(e.getKeyChar()));
        }

        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
        }
    }
}
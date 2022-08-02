package Xaropinho-Ratinho-Attacks-main;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Spaceship extends Sprite {

    private int dx;
    private int dy;
    private List<Missile> missiles;

    public Spaceship(int x, int y) {
        super(x, y);

        initCraft();
    }

    private void initCraft() {
        
        missiles = new ArrayList<>();
        loadImage("src/xaropinho.png");
        getImageDimensions();
    }

    public void move() {

        x += dx;
        y += dy;

        if (x < 1) {
            x = 1;
        }

        if (y < 1) {
            y = 1;
        }
    }

    public List<Missile> getMissiles() {
        return missiles;
    }

    public void keyPressed(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_SPACE) {
            fire();
        }

        if (key == KeyEvent.VK_LEFT) {
            dx = -10;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 10;
        }

        if (key == KeyEvent.VK_UP) {
            dy = -10;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 10;
        }
    }  

    public void fire() {
        missiles.add(new Missile(x + width, y + height / 2));
    }

    public void keyReleased(KeyEvent e) {

        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_RIGHT) {
            dx = 0;
        }

        if (key == KeyEvent.VK_UP) {
            dy = 0;
        }

        if (key == KeyEvent.VK_DOWN) {
            dy = 0;
        }
    }
}

package Xaropinho-Ratinho-Attacks-main;
public class Alien extends Sprite {

    private final int INITIAL_X = 1920;

    public Alien(int x, int y) {
        super(x, y);

        initAlien();
    }

    private void initAlien() {

        loadImage("src/ratinho.png");
        getImageDimensions();
    }

    public void move() {

        if (x < 0) {
            x = INITIAL_X;
        }

        x -= 5;
    }
}    

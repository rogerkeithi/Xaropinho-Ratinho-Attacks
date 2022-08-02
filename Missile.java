
package com.roger.xaropinho;
public class Missile extends Sprite {

    private final int BOARD_WIDTH = 1920;
    private final int MISSILE_SPEED = 10;

    public Missile(int x, int y) {
        super(x, y);

        initMissile();
    }
    
    private void initMissile() {
        
        loadImage("src/queijo.png");
        getImageDimensions();        
    }

    public void move() {
        
        x += MISSILE_SPEED;
        
        if (x > BOARD_WIDTH)
            visible = false;
    }
}
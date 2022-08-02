package Xaropinho-Ratinho-Attacks-main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    private Timer timer;
    private Spaceship spaceship;
    private List<Alien> aliens;
    private int kills;
    private boolean ingame;
    private final int ICRAFT_X = 40;
    private final int ICRAFT_Y = 60;
    private final int B_WIDTH = 1920;
    private final int B_HEIGHT = 1080;
    private final int DELAY = 15;

    private final int[][] pos = {
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)},
        {(int)((Math.random()*(3080 - 1000)) + 1000), (int)(Math.random()*1080)}
    };



    public Board() {

        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        ingame = true;

        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));

        spaceship = new Spaceship(ICRAFT_X, ICRAFT_Y);

        initAliens();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void initAliens() {
        
        aliens = new ArrayList<>();
        for (int[] p : pos) {
            aliens.add(new Alien(p[0], p[1]));
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (ingame) {

            drawObjects(g);

        } else {

            drawGameOver(g);
        }

        Toolkit.getDefaultToolkit().sync();
    }

    private void drawObjects(Graphics g) {

        if (spaceship.isVisible()) {
            g.drawImage(spaceship.getImage(), spaceship.getX(), spaceship.getY(),
                    this);
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile missile : ms) {
            if (missile.isVisible()) {
                g.drawImage(missile.getImage(), missile.getX(), 
                        missile.getY(), this);
            }
        }

        for (Alien alien : aliens) {
            if (alien.isVisible()) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }
        }

        g.setColor(Color.WHITE);
        Font small = new Font("Helvetica", Font.BOLD, 25);
        g.setFont(small);
        g.drawString("Ratinhos atacando: " + aliens.size(), 5, 20);
        g.drawString("Pontos: " + kills, 5, 50);
    }

    private void drawGameOver(Graphics g) {

        String msg = "RAPAZ!!!";
        String msg2 = "Seus pontos: " + kills;
        Font small = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fm = getFontMetrics(small);

        g.setColor(Color.white);
        g.setFont(small);
        g.drawString(msg, (B_WIDTH - fm.stringWidth(msg)) / 2,
                B_HEIGHT / 2);
        g.drawString(msg2, (B_WIDTH - fm.stringWidth(msg2)) / 2,
                B_HEIGHT - 100);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        inGame();

        updateShip();
        updateMissiles();
        updateAliens();

        checkCollisions();

        repaint();
    }

    private void inGame() {

        if (!ingame) {
            timer.stop();
        }
    }

    private void updateShip() {

        if (spaceship.isVisible()) {
            
            spaceship.move();
        }
    }

    private void updateMissiles() {

        List<Missile> ms = spaceship.getMissiles();

        for (int i = 0; i < ms.size(); i++) {

            Missile m = ms.get(i);

            if (m.isVisible()) {
                m.move();
            } else {
                ms.remove(i);
            }
        }
    }

    private void updateAliens() {
        if (aliens.isEmpty()) {

            ingame = false;
            return;
        }

        for (int i = 0; i < aliens.size(); i++) {

            Alien a = aliens.get(i);
            
            if (a.isVisible()) {
                a.move();
            } else {
                aliens.remove(i);
                kills = kills + 1;
            }
        }
    }

    public void checkCollisions() {

        Rectangle r3 = spaceship.getBounds();

        for (Alien alien : aliens) {
            
            Rectangle r2 = alien.getBounds();

            if (r3.intersects(r2)) {
                
                spaceship.setVisible(false);
                alien.setVisible(false);
                ingame = false;
            }
        }

        List<Missile> ms = spaceship.getMissiles();

        for (Missile m : ms) {

            Rectangle r1 = m.getBounds();

            for (Alien alien : aliens) {

                Rectangle r2 = alien.getBounds();

                if (r1.intersects(r2)) {
                    
                    m.setVisible(false);
                    alien.setVisible(false);
                }
            }
        }
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            spaceship.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            spaceship.keyPressed(e);
        }
    }
}

package Xaropinho-Ratinho-Attacks-main;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class Xaropinho extends JFrame {

    public Xaropinho() {
        
        initUI();
    }
    
    private void initUI() {
        
        add(new Board());
        
        setResizable(false);
        pack();
        
        setTitle("Collision");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        
        EventQueue.invokeLater(() -> {
            Xaropinho ex = new Xaropinho();
            ex.setVisible(true);
        });
    }
}

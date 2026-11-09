package GameWindow;

import core.KeyInputs;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel implements Runnable{

    //Screen Size by tiles
    final int tileSize = 48;
    final int screenColom = 16;
    final int screenRow = 12;
    final int screenWidth = tileSize * screenColom;
    final int screenHight = tileSize * screenRow;

    KeyInputs keyInputs = new KeyInputs();

    Thread gameThread;

    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    public GamePanel () {

        this.setPreferredSize(new Dimension(screenWidth, screenHight));
        this.setBackground(Color.black);
        this.addKeyListener(keyInputs);
        this.setFocusable(true); //Optional - Nur damit es mehr fokussiert ist bei den suchen der Tasten
    }

    public void startGameThread (){

        gameThread = new Thread(this);
        gameThread.start();
    }

    public void run() {

        while (gameThread != null){

            update();

            repaint();
        }
    }

    public void update (){

    }
    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(100,100, tileSize, tileSize);

        g2.dispose();
    }
}

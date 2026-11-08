package GameWindow;

import javax.swing.*;
import java.awt.*;


public class GamePanel extends JPanel {

    //Screen Size by tiles
    final int tileSize = 48;
    final int screenColom = 16;
    final int screenRow = 12;
    final int screenWidth = tileSize * screenColom;
    final int screenHight = tileSize * screenRow;

    public GamePanel () {

        this.setPreferredSize(new Dimension(screenWidth, screenHight));
        this.setBackground(Color.black);
    }
}

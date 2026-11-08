package main;
import core.GamePanel;

import javax.swing.*;

public class Main {
    void main() {

        SwingUtilities.invokeLater(() -> {

            JFrame window = new JFrame("Mini-Games");

            window.setSize(1200, 1000);
            window.setDefaultCloseOperation(
                    JFrame.EXIT_ON_CLOSE
            );

            window.setLocationRelativeTo(null);
            window.setResizable(false);

            GamePanel panel = new GamePanel();

            window.add(panel);

            window.setVisible(true);
        });
    }
}

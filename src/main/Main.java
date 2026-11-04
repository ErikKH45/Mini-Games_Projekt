package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            JFrame window = new JFrame("Gauntlet");

            window.setSize(800, 600);
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

}

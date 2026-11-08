package core;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private CardLayout cardLayout;

    public GamePanel() {

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Startseite erstellen
        MainMenu mainMenu = new MainMenu(
                () -> showPlaceholder("SURVIVAL"),
                () -> showPlaceholder("PVP / MULTIPLAYER"),
                () -> System.exit(0)
        );

        add(mainMenu, "MAIN_MENU");
    }

    // Zeigt einen anderen Bildschirm an
    private void showPlaceholder(String mode) {

        JPanel panel = new JPanel();
        panel.setBackground(new Color(20, 20, 35));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(mode);
        title.setFont(new Font("Arial", Font.BOLD, 35));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel info = new JLabel("Wird noch entwickelt.");
        info.setFont(new Font("Arial", Font.PLAIN, 16));
        info.setForeground(Color.LIGHT_GRAY);
        info.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton backButton = new JButton("ZURÜCK");

        backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        backButton.addActionListener(e ->
                cardLayout.show(this, "MAIN_MENU")
        );

        panel.add(Box.createVerticalGlue());
        panel.add(title);
        panel.add(Box.createVerticalStrut(20));
        panel.add(info);
        panel.add(Box.createVerticalStrut(30));
        panel.add(backButton);
        panel.add(Box.createVerticalGlue());

        // Alten Bildschirm entfernen und neuen hinzufügen
        if (getComponentCount() > 1) {
            remove(1);
        }

        add(panel, mode);
        cardLayout.show(this, mode);

        revalidate();
        repaint();
    }
}

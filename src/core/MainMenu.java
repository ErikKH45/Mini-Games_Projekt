package core;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel {

    public MainMenu(Runnable survivalAction,
                    Runnable pvpAction,
                    Runnable quitAction) {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Titel
        JLabel title = new JLabel("MINI-GAMES");
        title.setFont(new Font("Arial", Font.BOLD, 65));
        title.setForeground(Color.WHITE);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel subtitle = new JLabel("MAIN MENU");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 17));
        subtitle.setForeground(new Color(170, 170, 190));
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Große Modus-Buttons
        JButton survivalButton = createModeButton(
                "SURVIVAL",
                new MenuIcon(MenuIcon.Type.MAP)
        );

        JButton pvpButton = createModeButton(
                "PVP / MULTIPLAYER",
                new MenuIcon(MenuIcon.Type.PVP)
        );

        survivalButton.addActionListener(e -> survivalAction.run());
        pvpButton.addActionListener(e -> pvpAction.run());

        // Buttons nebeneinander anordnen
        JPanel modesPanel = new JPanel(new FlowLayout(
                FlowLayout.CENTER, 35, 0
        ));

        modesPanel.setOpaque(false);
        modesPanel.add(survivalButton);
        modesPanel.add(pvpButton);

        // Kleiner Quit-Button
        JButton quitButton = new JButton("QUIT");
        quitButton.setFont(new Font("Arial", Font.BOLD, 14));
        quitButton.setForeground(Color.LIGHT_GRAY);
        quitButton.setBackground(new Color(45, 45, 65));
        quitButton.setFocusPainted(false);
        quitButton.setBorderPainted(false);
        quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        quitButton.setPreferredSize(new Dimension(130, 38));
        quitButton.setMaximumSize(new Dimension(130, 38));

        quitButton.addActionListener(e -> quitAction.run());

        // Elemente anordnen
        add(Box.createVerticalGlue());

        add(title);
        add(Box.createVerticalStrut(10));
        add(subtitle);

        add(Box.createVerticalStrut(65));

        add(modesPanel);

        add(Box.createVerticalStrut(35));
        add(quitButton);

        add(Box.createVerticalGlue());
    }

    // Erstellt einen großen Modus-Button
    private JButton createModeButton(String title,
                                     Icon icon) {

        JButton button = new JButton(title, icon);

        button.setFont(new Font("Arial", Font.BOLD, 21));
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(45, 48, 78));

        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Icon oberhalb des Textes
        button.setVerticalTextPosition(SwingConstants.BOTTOM);
        button.setHorizontalTextPosition(SwingConstants.CENTER);
        button.setIconTextGap(20);

        button.setPreferredSize(new Dimension(320, 250));
        button.setMaximumSize(new Dimension(320, 250));

        return button;
    }

    // Hintergrund
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(
                0, 0, new Color(15, 15, 30),
                getWidth(), getHeight(), new Color(40, 35, 75)
        );

        g2.setPaint(gradient);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
}


// Eigene Icons für die Spielmodi
class MenuIcon implements Icon {

    enum Type {
        MAP,
        PVP
    }

    private Type type;

    public MenuIcon(Type type) {
        this.type = type;
    }

    @Override
    public int getIconWidth() {
        return 110;
    }

    @Override
    public int getIconHeight() {
        return 110;
    }

    @Override
    public void paintIcon(Component c, Graphics g,
                          int x, int y) {

        Graphics2D g2 = (Graphics2D) g.create();

        g2.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );

        if (type == Type.MAP) {
            drawMap(g2, x, y);
        } else {
            drawPlayers(g2, x, y);
        }

        g2.dispose();
    }

    // Survival: Weg mit Stationen und Boss am Ende
    private void drawMap(Graphics2D g, int x, int y) {

        g.setStroke(new BasicStroke(
                5, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND
        ));

        // Verbindung zwischen den Stationen
        g.setColor(new Color(130, 145, 190));

        g.drawLine(x + 20, y + 85, x + 45, y + 65);
        g.drawLine(x + 45, y + 65, x + 65, y + 45);
        g.drawLine(x + 65, y + 45, x + 88, y + 25);

        // Normale Stationen
        g.setColor(new Color(90, 180, 210));

        g.fillOval(x + 12, y + 77, 16, 16);
        g.fillOval(x + 37, y + 57, 16, 16);
        g.fillOval(x + 57, y + 37, 16, 16);

        // Boss-Station
        g.setColor(new Color(220, 75, 75));
        g.fillOval(x + 77, y + 14, 25, 25);
    }

    // PvP: Zwei Spieler
    private void drawPlayers(Graphics2D g, int x, int y) {

        // Linker Spieler
        g.setColor(new Color(90, 170, 230));
        g.fillOval(x + 17, y + 20, 32, 32);
        g.fillRoundRect(x + 10, y + 55, 48, 38, 15, 15);

        // Rechter Spieler
        g.setColor(new Color(230, 125, 100));
        g.fillOval(x + 62, y + 20, 32, 32);
        g.fillRoundRect(x + 55, y + 55, 48, 38, 15, 15);

    }
}

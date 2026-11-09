
package core; // Ordnet die Klasse demselben Package wie Main und GamePanel zu.

import javax.swing.*; // Importiert Swing-Komponenten wie JPanel, JButton und JLabel.
import javax.swing.border.EmptyBorder; // Ermöglicht uns, Innenabstände für Komponenten festzulegen.
import javax.swing.border.LineBorder; // Ermöglicht uns, eine einfache farbige Umrandung zu erstellen.
import java.awt.*; // Importiert grafische Funktionen wie Farben, Schriftarten und Layouts.
import java.awt.image.BufferedImage; // Ermöglicht uns, Bilder zu laden und auf eine bestimmte Größe zu skalieren.
import java.io.IOException; // Wird benötigt, um mögliche Fehler beim Laden von Bildern abzufangen.
import java.net.URL; // Ermöglicht uns, die Speicheradresse unserer eingebundenen Bilder zu erhalten.
import javax.imageio.ImageIO; // Importiert die Funktionalität zum Einlesen von PNG- und anderen Bilddateien.

public class MainMenu extends JPanel { // MainMenu ist ein eigenes Panel, das ausschließlich unsere Startseite darstellt.

    private static final Color BACKGROUND_COLOR = new Color(13, 13, 25); // Speichert die dunkle Hintergrundfarbe, die wir im gesamten Menü verwenden.
    private static final Color BUTTON_COLOR = new Color(30, 32, 55); // Speichert die Hintergrundfarbe unserer großen Modus-Buttons.
    private static final Color ACCENT_COLOR = new Color(100, 220, 180); // Speichert eine Akzentfarbe für Umrandungen und Retro-Details.
    private static final Color TEXT_COLOR = new Color(235, 235, 245); // Speichert die helle Textfarbe für gute Lesbarkeit.

    public MainMenu(Runnable survivalAction, Runnable pvpAction, Runnable quitAction) { // Konstruktor: Wird aufgerufen, wenn GamePanel eine neue Startseite erstellt; die drei Aktionen kommen von GamePanel.

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Ordnet die Bestandteile der Startseite vertikal untereinander an.
        setBorder(new EmptyBorder(40, 40, 40, 40)); // Fügt einen Innenabstand hinzu, damit die Elemente nicht direkt am Fensterrand liegen.
        setBackground(BACKGROUND_COLOR); // Legt die Hintergrundfarbe des Panels fest.

        JLabel title = new JLabel("MINI-GAMES"); // Erstellt die Überschrift unserer Startseite.
        title.setFont(new Font("Monospaced", Font.BOLD, 72)); // Verwendet eine dicke Monospace-Schrift in großer Größe für den Retro-Look.
        title.setForeground(ACCENT_COLOR); // Färbt den Titel in unserer Akzentfarbe.
        title.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentriert den Titel horizontal innerhalb des vertikalen Layouts.

        JLabel subtitle = new JLabel("SELECT YOUR GAME MODE"); // Erstellt einen Untertitel, der dem Spieler die Auswahl erklärt.
        subtitle.setFont(new Font("Monospaced", Font.PLAIN, 19)); // Verwendet eine kleinere Monospace-Schrift für den Untertitel.
        subtitle.setForeground(TEXT_COLOR); // Setzt die Textfarbe des Untertitels.
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentriert den Untertitel horizontal.

        JButton survivalButton = createModeButton( // Erstellt den großen Button für den Survival-Modus.
                "SURVIVAL", // Legt den Namen fest, der auf dem Button angezeigt wird.
                "Fight your way to the final boss", // Beschreibt kurz das Ziel des Survival-Modus.
                "/images/survival.png" // Gibt den Pfad zum Survival-Bild im Ressourcenordner an.
        ); // Beendet den Aufruf der Methode createModeButton.

        JButton pvpButton = createModeButton( // Erstellt den großen Button für den Mehrspieler-Modus.
                "PVP / MULTIPLAYER", // Legt den Namen des zweiten Buttons fest.
                "Challenge another player", // Beschreibt kurz, worum es im PvP-Modus geht.
                "/images/pvp.png" // Gibt den Pfad zum PvP-Bild im Ressourcenordner an.
        ); // Beendet den Aufruf der Methode createModeButton.

        survivalButton.addActionListener(e -> survivalAction.run()); // Führt die von GamePanel übergebene Survival-Aktion aus, wenn der Spieler diesen Button anklickt.
        pvpButton.addActionListener(e -> pvpAction.run()); // Führt die von GamePanel übergebene PvP-Aktion aus, wenn der Spieler diesen Button anklickt.

        JPanel modesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 0)); // Erstellt ein eigenes Panel, das die beiden Modus-Buttons horizontal nebeneinander anordnet.
        modesPanel.setOpaque(false); // Macht den Hintergrund dieses Panels durchsichtig, damit der Hintergrund von MainMenu sichtbar bleibt.
        modesPanel.add(survivalButton); // Fügt den Survival-Button links in das Panel ein.
        modesPanel.add(pvpButton); // Fügt den PvP-Button rechts neben dem Survival-Button ein.
        modesPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentriert das gesamte Button-Panel innerhalb der Startseite.

        JButton quitButton = new JButton("QUIT"); // Erstellt den kleineren Button zum Beenden des Spiels.
        quitButton.setFont(new Font("Monospaced", Font.BOLD, 16)); // Verwendet eine fette Monospace-Schrift für den Quit-Button.
        quitButton.setForeground(TEXT_COLOR); // Legt die helle Schriftfarbe des Quit-Buttons fest.
        quitButton.setBackground(new Color(45, 35, 50)); // Gibt dem Quit-Button einen dunklen, leicht rötlichen Hintergrund.
        quitButton.setFocusPainted(false); // Entfernt den standardmäßigen Fokusrahmen von Swing.
        quitButton.setBorder(new LineBorder(new Color(130, 75, 85), 2)); // Zeichnet einen zwei Pixel breiten Rand um den Quit-Button.
        quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Ändert den Mauszeiger in eine Hand, wenn man über den Button fährt.
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Zentriert den Quit-Button horizontal.

        quitButton.setPreferredSize(new Dimension(160, 45)); // Legt die bevorzugte Größe des Quit-Buttons fest.
        quitButton.setMaximumSize(new Dimension(160, 45)); // Verhindert, dass der Button durch das Layout größer gezogen wird.

        quitButton.addActionListener(e -> quitAction.run()); // Führt die von GamePanel übergebene Beenden-Aktion aus, wenn der Spieler den Button anklickt.

        add(Box.createVerticalGlue()); // Fügt flexiblen freien Platz oberhalb der Elemente ein, damit der Inhalt vertikal zentriert wird.
        add(title); // Fügt den Titel zur Startseite hinzu.
        add(Box.createVerticalStrut(15)); // Fügt einen festen Abstand von 15 Pixeln unterhalb des Titels ein.
        add(subtitle); // Fügt den Untertitel unter dem Titel ein.
        add(Box.createVerticalStrut(85)); // Fügt einen größeren Abstand zwischen Überschrift und Modus-Auswahl ein.
        add(modesPanel); // Fügt beide großen Modus-Buttons nebeneinander zur Startseite hinzu.
        add(Box.createVerticalStrut(45)); // Fügt Abstand zwischen den Modus-Buttons und dem Quit-Button ein.
        add(quitButton); // Fügt den Quit-Button unterhalb der beiden Modus-Buttons ein.
        add(Box.createVerticalGlue()); // Fügt flexiblen freien Platz unterhalb der Elemente ein, um sie vertikal zu zentrieren.
    } // Beendet den Konstruktor von MainMenu.

    private JButton createModeButton(String title, String description, String imagePath) { // Hilfsmethode: Erstellt einen einheitlich gestalteten Button für einen Spielmodus.

        ImageIcon icon = loadImageIcon(imagePath, 150, 150); // Lädt das jeweilige PNG-Bild und skaliert es auf 150 x 150 Pixel.

        String buttonText = "<html><div style='text-align:center'>" + title // Beginnt einen HTML-Text, damit Titel und Beschreibung untereinander angezeigt werden.
                + "<br><br><font size='3' color='#B8C2D8'>" + description // Fügt unter dem Titel die kleinere Beschreibung in einer hellgrauen Farbe ein.
                + "</font></div></html>"; // Beendet die HTML-Formatierung des Button-Textes.

        JButton button = new JButton(buttonText, icon); // Erstellt einen Button, der sowohl den Text als auch das geladene Bild enthält.

        button.setFont(new Font("Monospaced", Font.BOLD, 20)); // Legt die Retro-Schriftart und die Schriftgröße des Button-Titels fest.
        button.setForeground(TEXT_COLOR); // Legt die Textfarbe des Buttons fest.
        button.setBackground(BUTTON_COLOR); // Legt die dunkle Hintergrundfarbe des Buttons fest.
        button.setFocusPainted(false); // Entfernt den standardmäßigen Fokusrahmen.
        button.setContentAreaFilled(true); // Sorgt dafür, dass der Hintergrund des Buttons gezeichnet wird.
        button.setBorder(new LineBorder(ACCENT_COLOR, 3)); // Gibt dem Button eine auffällige, kantige Akzent-Umrandung.
        button.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Zeigt eine Hand als Mauszeiger, wenn der Spieler über den Button fährt.

        button.setVerticalTextPosition(SwingConstants.BOTTOM); // Platziert den Text unterhalb des Bildes.
        button.setHorizontalTextPosition(SwingConstants.CENTER); // Zentriert den Text horizontal unter dem Bild.
        button.setIconTextGap(20); // Legt den Abstand zwischen Bild und Text fest.

        button.setPreferredSize(new Dimension(390, 390)); // Legt die bevorzugte Größe der großen Modus-Buttons fest.
        button.setMaximumSize(new Dimension(390, 390)); // Verhindert, dass die Buttons durch das Layout größer werden.

        return button; // Gibt den fertig gestalteten Button zurück, damit der Konstruktor ihn verwenden kann.
    } // Beendet die Methode createModeButton.

    private ImageIcon loadImageIcon(String imagePath, int width, int height) { // Hilfsmethode: Lädt ein Bild aus dem Ressourcenordner und skaliert es für einen Button.

        URL imageURL = getClass().getResource(imagePath); // Sucht die Bilddatei anhand ihres Pfades im Ressourcenordner des Projekts.

        if (imageURL == null) { // Prüft, ob die angegebene Bilddatei überhaupt gefunden wurde.
            System.err.println("Bild konnte nicht gefunden werden: " + imagePath); // Gibt eine Fehlermeldung in der Konsole aus, wenn der Pfad falsch ist.
            return null; // Gibt kein Icon zurück, damit das Programm trotz fehlendem Bild weiterlaufen kann.
        } // Beendet die Überprüfung auf einen fehlenden Bildpfad.

        try { // Beginnt einen try-Block, um mögliche Fehler beim Einlesen des Bildes abzufangen.

            BufferedImage originalImage = ImageIO.read(imageURL); // Liest die Bilddatei ein und speichert sie als BufferedImage.

            if (originalImage == null) { // Prüft, ob die Datei ein unterstütztes Bildformat enthält.
                System.err.println("Datei ist kein lesbares Bild: " + imagePath); // Gibt eine Fehlermeldung aus, falls die Datei nicht als Bild gelesen werden kann.
                return null; // Gibt kein Icon zurück, damit das Programm nicht wegen eines ungültigen Bildes abstürzt.
            } // Beendet die Überprüfung des Bildformats.

            BufferedImage scaledImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // Erstellt ein neues Bild mit der gewünschten Größe und unterstützt Transparenz.

            Graphics2D g2 = scaledImage.createGraphics(); // Erstellt ein Zeichenwerkzeug, mit dem wir das Originalbild in das neue Bild übertragen können.

            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_NEAREST_NEIGHBOR); // Verwendet Pixel-nearest-neighbor-Skalierung, damit Pixel-Art beim Vergrößern scharf und kantig bleibt.

            g2.drawImage(originalImage, 0, 0, width, height, null); // Zeichnet das Originalbild in der neuen Größe auf das skalierte Bild.

            g2.dispose(); // Gibt die Zeichenressourcen frei, nachdem das Bild fertig skaliert wurde.

            return new ImageIcon(scaledImage); // Erstellt ein Swing-Icon aus dem skalierten Bild und gibt es an den Button zurück.

        } catch (IOException e) { // Fängt Fehler ab, die beim Einlesen der Bilddatei auftreten können.
            System.err.println("Fehler beim Laden des Bildes: " + imagePath); // Gibt aus, welches Bild nicht geladen werden konnte.
            e.printStackTrace(); // Gibt technische Informationen zum Fehler in der Konsole aus, die beim Debuggen helfen.
            return null; // Gibt kein Icon zurück, damit das restliche Menü trotzdem angezeigt werden kann.
        } // Beendet den try-catch-Block.
    } // Beendet die Methode loadImageIcon.

    @Override // Kennzeichnet, dass wir eine vorhandene Methode aus JPanel überschreiben.
    protected void paintComponent(Graphics g) { // Wird von Swing aufgerufen, wenn der Hintergrund dieses Panels gezeichnet werden muss.

        super.paintComponent(g); // Führt zunächst die normale Hintergrund-Zeichenroutine von JPanel aus.

        Graphics2D g2 = (Graphics2D) g.create(); // Erstellt eine eigene Zeichenkopie, damit unsere Zeichenänderungen andere Komponenten nicht beeinflussen.

        g2.setColor(BACKGROUND_COLOR); // Legt die Hintergrundfarbe fest.
        g2.fillRect(0, 0, getWidth(), getHeight()); // Füllt die gesamte Fläche des Panels mit der Hintergrundfarbe.

        g2.setColor(new Color(35, 40, 60)); // Legt eine dezente Farbe für das Hintergrundraster fest.

        for (int x = 0; x < getWidth(); x += 40) { // Durchläuft die horizontale Fläche des Panels in Abständen von 40 Pixeln.
            g2.drawLine(x, 0, x, getHeight()); // Zeichnet an jeder Position eine senkrechte Rasterlinie.
        } // Beendet die Schleife für die senkrechten Linien.

        for (int y = 0; y < getHeight(); y += 40) { // Durchläuft die vertikale Fläche des Panels in Abständen von 40 Pixeln.
            g2.drawLine(0, y, getWidth(), y); // Zeichnet an jeder Position eine waagerechte Rasterlinie.
        } // Beendet die Schleife für die waagerechten Linien.

        g2.dispose(); // Gibt die verwendeten Zeichenressourcen frei.
    } // Beendet die Methode paintComponent.
} // Beendet die Klasse MainMenu.

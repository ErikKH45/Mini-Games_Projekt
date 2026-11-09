package core;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class Main { // Hauptklasse unseres Programms: Hier beginnt die Ausführung des Spiels.

    public static void main(String[] args) { // Einstiegspunkt von Java: Diese Methode wird beim Programmstart automatisch ausgeführt.

        SwingUtilities.invokeLater(() -> { // Startet den folgenden GUI-Code auf dem Event Dispatch Thread von Swing.

            JFrame frame = new JFrame("Mini_Games"); // Erstellt das Hauptfenster und legt den Fenstertitel fest.

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beendet das gesamte Programm, wenn das Fenster geschlossen wird.
            frame.setSize(1200, 1000);
            frame.setLocationRelativeTo(null); // Positioniert das Fenster in der Mitte des Bildschirms.
            frame.setResizable(false); // Verhindert, dass der Spieler die Fenstergröße verändern kann.

            GamePanel gamePanel = new GamePanel(); // Erstellt unser GamePanel, das später die verschiedenen Spielbildschirme verwaltet.

            frame.add(gamePanel); // Fügt das GamePanel in das Fenster ein, damit es darin angezeigt wird.
            frame.setVisible(true); // Macht das Fenster sichtbar und zeigt damit unser Spiel an.
        });
    }
}

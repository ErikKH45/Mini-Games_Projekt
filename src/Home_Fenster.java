import javax.swing.JFrame;

public class Home_Fenster {
     void main(String[] args) {
        // Neues Fenster erstellen und Titel übergeben
        JFrame fenster = new JFrame("Mini-Games");

        // Größe des Fensters festlegen (Breite x Höhe in Pixeln)
        fenster.setSize(1500, 900);

        // Verhalten beim Schließen festlegen (damit das Programm stoppt)
        fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Fenster sichtbar machen (standardmäßig unsichtbar)
        fenster.setVisible(true);
    }
} //test
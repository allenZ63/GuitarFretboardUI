package my.guitarfretboard;

import NoteInput.NoteScript;
import NoteInput.SwingLayout;

public class Driver {

    public static void main(String[] args) {
        final GuitarFretboardUI g = new GuitarFretboardUI();
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                g.setVisible(true);
            }
        });
    }
}

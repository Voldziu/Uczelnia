package StrategiaGUI.Wyszukaj;

import GUI.GUI;
import StrategiaGUI.Tworzenie.TworzenieInterfejs;

import javax.swing.*;

public class WyszukajStudentaGUI  implements WyszukajGUI {
    @Override
    public void Szukaj(GUI g) {
        String napis = "Studenta";
        String napis2= "Podaj Wartości";
        JLabel tytul = new JLabel("Wyszukujesz: "+napis);
        g.setZatwierdzWyszukajStudent(new JButton("Zatwierdz"));
        g.setWyjdzWyszukaj(new JButton("Wyjdz"));
        g.getZatwierdzWyszukajStudent().addActionListener(g);
        g.getWyjdzWyszukaj().addActionListener(g);


        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().add(tytul);







    }
}

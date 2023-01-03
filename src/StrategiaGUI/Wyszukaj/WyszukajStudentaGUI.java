package StrategiaGUI.Wyszukaj;

import GUI.GUI;
import SkladoweUczelni.Student;
import Strategia.Wyszukaj.WyszukajStudenta;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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

        g.setListaTextow(new ArrayList<JTextField>());



        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().add(tytul,BorderLayout.WEST);
        g.getCentrumNaglowek().add(new JLabel(napis2));
        JTextField tekst = new JTextField();
        tekst.setPreferredSize(new Dimension(150,30));
        g.getListaTextow().add(tekst);
        g.getCentrumNaglowek().add(tekst);
        g.getCentrumNaglowek().add(g.getZatwierdzWyszukajStudent());
        g.getCentrumNaglowek().add(g.getWyjdzWyszukaj());



        g.revalidate();
        g.repaint();



















    }
}

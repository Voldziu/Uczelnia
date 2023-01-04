package StrategiaGUI.Podwyzka;

import GUI.GUI;
import StrategiaGUI.Wyszukaj.WyszukajGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class DajPodwyzke implements PodwyzkaGUI {
    @Override
    public void DajPodwyzke(GUI g) {
        g.getCentrumMain().removeAll();
        String napis = "pracownika, któremu chcesz dać podwyżkę";
        String napis2= "Wpisz ID";
        JLabel tytul = new JLabel("Wyszukujesz "+napis);

        g.setZatwierdzPodwyzka(new JButton("Zatwierdz"));
        g.setWyjdzPodwyzka(new JButton("Wyjdz"));
        g.getZatwierdzPodwyzka().addActionListener(g);
        g.getWyjdzPodwyzka().addActionListener(g);

        g.setListaTextow(new ArrayList<JTextField>());



        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().setLayout(new FlowLayout());
        g.getCentrumNaglowek().add(tytul);
        g.getCentrumNaglowek().add(Box.createRigidArea(new Dimension(30,0)));
        g.getCentrumNaglowek().add(new JLabel(napis2));
        JTextField tekst = new JTextField();
        tekst.setPreferredSize(new Dimension(150,30));
        g.getListaTextow().add(tekst);
        g.getCentrumNaglowek().add(tekst);
        g.getCentrumNaglowek().add(g.getZatwierdzPodwyzka());
        g.getCentrumNaglowek().add(g.getWyjdzPodwyzka());



        g.revalidate();
        g.repaint();



















    }
}


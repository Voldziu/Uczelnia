package StrategiaGUI.Usun;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UsunPracownika implements Usun{
    @Override
    public void Usun(GUI g) {
        String napis = "Pracownika";
        String napis2= "Podaj Wartości";
        JLabel tytul = new JLabel("Usuwasz: "+napis);
        g.setZatwierdzUsunPracownik(new JButton("Zatwierdz"));
        g.setWyjdzUsun(new JButton("Wyjdz"));
        g.getZatwierdzUsunPracownik().addActionListener(g);
        g.getWyjdzUsun().addActionListener(g);

        g.setListaTextow(new ArrayList<JTextField>());



        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().add(tytul, BorderLayout.WEST);
        g.getCentrumNaglowek().add(new JLabel(napis2));
        JTextField tekst = new JTextField();
        tekst.setPreferredSize(new Dimension(150,30));
        g.getListaTextow().add(tekst);
        g.getCentrumNaglowek().add(tekst);
        g.getCentrumNaglowek().add(g.getZatwierdzUsunPracownik());
        g.getCentrumNaglowek().add(g.getWyjdzUsun());



        g.revalidate();
        g.repaint();





    }



}

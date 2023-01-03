package StrategiaGUI.Usun;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class UsunKurs implements Usun{
    @Override
    public void Usun(GUI g) {
        String napis = "Kurs";
        String napis2= "Podaj Wartości";
        JLabel tytul = new JLabel("Usuwasz: "+napis);
        g.setZatwierdzUsunStudent(new JButton("Zatwierdz"));
        g.setWyjdzUsun(new JButton("Wyjdz"));
        g.getZatwierdzUsunStudent().addActionListener(g);
        g.getWyjdzUsun().addActionListener(g);

        g.setListaTextow(new ArrayList<JTextField>());



        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().add(tytul, BorderLayout.WEST);
        g.getCentrumNaglowek().add(new JLabel(napis2));
        JTextField tekst = new JTextField();
        tekst.setPreferredSize(new Dimension(150,30));
        g.getListaTextow().add(tekst);
        g.getCentrumNaglowek().add(tekst);
        g.getCentrumNaglowek().add(g.getZatwierdzUsunStudent());
        g.getCentrumNaglowek().add(g.getWyjdzUsun());



        g.revalidate();
        g.repaint();





    }


}

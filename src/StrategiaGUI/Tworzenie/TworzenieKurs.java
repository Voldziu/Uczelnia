package StrategiaGUI.Tworzenie;

import GUI.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import SkladoweUczelni.*;

public class TworzenieKurs implements Tworzenie{

    @Override
    public void Stworz(GUI g) {
        ArrayList<String> nazwy = new ArrayList<>(Arrays.asList("ID", "Nazwa Kursu","ECTS"));
        String napis = "Kurs";


        g.getCentrumNaglowek().removeAll();
        int LiczbaZmiennych = nazwy.size();

        JLabel labelglowny = new JLabel("Tworzysz: "+napis);
        g.setZatwierdzStworzKurs(new JButton("Zatwierdz"));
        g.setWyjdzStworz(new JButton("Wyjdz"));
        g.getZatwierdzStworzKurs().addActionListener(g);
        g.getWyjdzStworz().addActionListener(g);


        g.setListaTextow(new ArrayList<JTextField>());
        g.setListaCheckBoxow(new ArrayList<Checkbox>());

        JPanel PanelLewus  = new JPanel();
        PanelLewus.setLayout(new GridLayout(LiczbaZmiennych,1));

        JPanel PanelDonos = new JPanel();
        PanelDonos.setLayout(new GridLayout(LiczbaZmiennych,1));

        JPanel PanelPrawus = new JPanel();
        PanelPrawus.setPreferredSize(new Dimension(200,100));
        PanelPrawus.setLayout(new GridLayout(-1,2));

        for (int i = 0; i <g.getUczelnia().getDane().getPracownicy().size(); i++) {
            PracownikUczelni obecnyPracownik = g.getUczelnia().getDane().getPracownicy().get(i);

            Checkbox checkbox =new Checkbox();

            PanelPrawus.add(checkbox);
            g.getListaCheckBoxow().add(checkbox);

            PanelPrawus.add(new JLabel(obecnyPracownik.getID()+" "+obecnyPracownik.getNazwisko()));

        }


        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumNaglowek().add(labelglowny);
        g.getCentrumNaglowek().add(g.getZatwierdzStworzKurs());
        g.getCentrumNaglowek().add(g.getWyjdzStworz());

        g.getCentrumMain().add(PanelLewus,BorderLayout.WEST);
        g.getCentrumMain().add(PanelDonos,BorderLayout.CENTER);
        g.getCentrumMain().add(PanelPrawus,BorderLayout.EAST);

        for (int i = 0; i <LiczbaZmiennych ; i++) {

            JLabel label = new JLabel(nazwy.get(i));

            JTextField text = new JTextField();


            PanelDonos.add(text);
            PanelLewus.add(label);


            g.getListaTextow().add(text);

        }







        g.revalidate();
        g.repaint();

    }


}


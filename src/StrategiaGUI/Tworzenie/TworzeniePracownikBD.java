package StrategiaGUI.Tworzenie;

import GUI.GUI;
import SkladoweUczelni.PracownikBD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class TworzeniePracownikBD implements Tworzenie{
    @Override
    public void Stworz(GUI g) {
        ArrayList<String> nazwy = new ArrayList<>(Arrays.asList("ID", "Imie", "Nazwisko", "Pesel", "wiek","plec","stanowisko","stazPracy","pensja","LiczbaPublikacji"));
        String napis = "Pracownika Badawczo-Dydaktycznego";


        g.getCentrumNaglowek().removeAll();
        int LiczbaZmiennych = nazwy.size();

        JLabel labelglowny = new JLabel("Tworzysz: "+napis);
        g.setZatwierdzStworzBD(new JButton("Zatwierdz"));
        g.setWyjdzStworz(new JButton("Wyjdz"));
        g.getZatwierdzStworzBD().addActionListener(g);
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


        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumNaglowek().add(labelglowny);
        g.getCentrumNaglowek().add(g.getZatwierdzStworzBD());
        g.getCentrumNaglowek().add(g.getWyjdzStworz());

        g.getCentrumMain().add(PanelLewus,BorderLayout.WEST);
        g.getCentrumMain().add(PanelDonos,BorderLayout.CENTER);


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

    public void StworzAlgorytmy(GUI g, boolean czyDobreStanowisko, ActionEvent e){
        if (czyDobreStanowisko){
            g.ZwrocListeTekstow(e);
            JPanel PanelPrawus = new JPanel();
            PanelPrawus.setPreferredSize(new Dimension(200,100));
            JLabel text = new JLabel("Wszystko git");
            text.setPreferredSize(new Dimension(200,100));
            PanelPrawus.add(text,BorderLayout.WEST);
            g.getCentrumMain().add(PanelPrawus,BorderLayout.EAST);


            g.getUczelnia().getDane().Add(new PracownikBD(Integer.parseInt((String) g.ZwrocListeTekstow(e).get(0)),(String) g.ZwrocListeTekstow(e).get(1),(String) g.ZwrocListeTekstow(e).get(2),(String)g.ZwrocListeTekstow(e).get(3),Integer.parseInt((String) g.ZwrocListeTekstow(e).get(4)),(String)g.ZwrocListeTekstow(e).get(5),(String)g.ZwrocListeTekstow(e).get(6), Double.parseDouble((String) g.ZwrocListeTekstow(e).get(7)), Double.parseDouble((String) g.ZwrocListeTekstow(e).get(8)),Integer.parseInt((String) g.ZwrocListeTekstow(e).get(9))));

            System.out.println(g.ZwrocListeTekstow(e));

        }else {
            JPanel PanelPrawus = new JPanel();
            PanelPrawus.add(new JLabel("Coś poszło nietak"));
            g.getCentrumMain().add(PanelPrawus,BorderLayout.EAST);

        }

        g.revalidate();
        g.repaint();



    }

}


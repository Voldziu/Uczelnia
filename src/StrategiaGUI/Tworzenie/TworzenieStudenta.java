package StrategiaGUI.Tworzenie;

import GUI.GUI;
import SkladoweUczelni.Kurs;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TworzenieStudenta implements Tworzenie {
    @Override
    public void Stworz(GUI g) {
        ArrayList<String> nazwy = new ArrayList<>(Arrays.asList("ID", "Imie", "Nazwisko", "Pesel", "wiek","plec","index","rok"));
        ArrayList<String> nazwyBoolean = new ArrayList<>(Arrays.asList("Erasmus","1 Stopien","2 Stopien","Stacjonarne","Niestacjonarne"));
        String napis = "Studenta";



        g.getCentrumNaglowek().removeAll();
        int LiczbaZmiennych = nazwy.size();
        int LiczbaBoolean =nazwyBoolean.size();

        JLabel labelglowny = new JLabel("Tworzysz: "+napis);
        g.setZatwierdzStworzStudent(new JButton("Zatwierdz"));
        g.setWyjdzStworz(new JButton("Wyjdz"));
        g.getZatwierdzStworzStudent().addActionListener(g);
        g.getWyjdzStworz().addActionListener(g);


        g.setListaTextow(new ArrayList<JTextField>());
        g.setListaCheckBoxow(new ArrayList<Checkbox>());
        g.setListaCheckBoxowStudenta(new ArrayList<Checkbox>());

        JPanel PanelLewus  = new JPanel();
        PanelLewus.setLayout(new GridLayout(LiczbaZmiennych+LiczbaBoolean,1));

        JPanel PanelDonos = new JPanel();
        PanelDonos.setLayout(new GridLayout(LiczbaZmiennych+LiczbaBoolean,1));

        JPanel PanelPrawus = new JPanel();
        PanelPrawus.setPreferredSize(new Dimension(200,100));
        PanelPrawus.setLayout(new GridLayout(-1,2));

        for (int i = 0; i <g.getUczelnia().getDane().getKursy().size(); i++) {
            Kurs obecnyKurs = g.getUczelnia().getDane().getKursy().get(i);

            Checkbox checkbox =new Checkbox();

            PanelPrawus.add(checkbox);
            g.getListaCheckBoxow().add(checkbox);
            PanelPrawus.add(new JLabel(obecnyKurs.getID()+" "+obecnyKurs.getNazwaKursu()+" "+obecnyKurs.getProwadzacy().getNazwisko()));

        }


        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumNaglowek().add(labelglowny);
        g.getCentrumNaglowek().add(g.getZatwierdzStworzStudent());
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
        for (int i = 0; i <LiczbaBoolean ; i++) {
            JLabel label = new JLabel(nazwyBoolean.get(i));
            Checkbox checkbox = new Checkbox();
            g.getListaCheckBoxowStudenta().add(checkbox);
            PanelDonos.add(checkbox);
            PanelLewus.add(label);


        }







        g.revalidate();
        g.repaint();

    }

}

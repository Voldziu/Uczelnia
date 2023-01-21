package StrategiaGUI.Wyprintuj;

import GUI.GUI;
import SkladoweUczelni.Kurs;
import Strategia.Komparatory.KomparatorECTSNazwisko;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Random;

public class WyprintujKursy implements Wyprintuj{
    @Override
    public void Wyprintuj(GUI g, ArrayList a ) {
        g.getCentrumMain().removeAll();
        String columnns[] ={"ID","Nazwa Kursu","Nazwisko","ECTS"};
        String[][] dane = new String[a.size()][columnns.length];
        for (int i = 0; i <a.size() ; i++) {
            Kurs element = (Kurs)a.get(i);
            dane[i][0]= String.valueOf(element.getID());
            dane[i][1]= String.valueOf(element.getNazwaKursu());
            dane[i][2]=String.valueOf(element.getProwadzacy().getNazwisko());
            dane[i][3]=String.valueOf(element.getECTS());
        }
        JTable tablica = new JTable(dane,columnns);
//        tablica.setPreferredSize(new Dimension(500,50));
        JScrollPane sp =new JScrollPane(tablica);

        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumMain().add(sp, BorderLayout.CENTER);




        g.getCentrumMain().revalidate();
        g.getCentrumMain().repaint();
    }
    public void Posortuj(ArrayList a,int wybor){
        switch (wybor){
            case 1:
                Collections.sort(a,new KomparatorECTSNazwisko());
                break;
            case 2:
                Collections.shuffle(a, new Random(3));
                break;
        }


    }
    public void AllWyprintuj(GUI g){
        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().setLayout(new BorderLayout());
        JPanel panelgura = new JPanel();
        panelgura.add(new JLabel("Kursy"));

        g.getCentrumNaglowek().add(panelgura,BorderLayout.CENTER);

        JPanel WyjdzHashuj = new JPanel();
        WyjdzHashuj.setLayout(new GridLayout(2,1));
        g.getCentrumNaglowek().add(WyjdzHashuj,BorderLayout.EAST);

        JButton Wyjdz = new JButton("Wyjdz");
        JButton Hashuj = new JButton("Hashuj");




        g.setWyjdzWyprintuj(Wyjdz);
        g.setHashujKurs(Hashuj);
        WyjdzHashuj.add(Wyjdz);
        WyjdzHashuj.add(Hashuj);



        g.getWyjdzWyprintuj().addActionListener(g);
        g.getHashujKurs().addActionListener(g);





        JPanel PanelPrawo = new JPanel();
        g.setSortowanieECTSNazwisko(new JButton("Sortowanie ECTS, Nazwisko"));

        g.getSortowanieECTSNazwisko().addActionListener(g);

        PanelPrawo.setLayout(new GridLayout(1,1));
        PanelPrawo.add(g.getSortowanieECTSNazwisko());




        g.getCentrumMain().add(PanelPrawo,BorderLayout.EAST);

        g.revalidate();
        g.repaint();

    }
}

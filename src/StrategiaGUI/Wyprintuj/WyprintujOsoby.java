package StrategiaGUI.Wyprintuj;

import GUI.GUI;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.Osoba;
import Strategia.Komparatory.KomparatorNazwisko;
import Strategia.Komparatory.KomparatorNazwiskoImie;
import Strategia.Komparatory.KomparatorNazwiskoWiek;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class WyprintujOsoby implements Wyprintuj{
    protected Comparator<Osoba> osobaComparator;
    @Override
    public void Wyprintuj(GUI g, ArrayList a ) {
        g.getCentrumMain().removeAll();
        String columnns[] ={"ID","Imie","Nazwisko","PESEL","Wiek","plec"};

        String[][] dane = new String[a.size()][columnns.length];
        for (int i = 0; i <a.size() ; i++) {
            Osoba element = (Osoba) a.get(i);
            dane[i][0]= String.valueOf(element.getID());
            dane[i][1]= String.valueOf(element.getImie());
            dane[i][2]=String.valueOf(element.getNazwisko());
            dane[i][3]=String.valueOf(element.getPESEL());
            dane[i][4]=String.valueOf(element.getWiek());
            dane[i][5]=String.valueOf(element.getPlec());
        }
        JTable tablica = new JTable(dane,columnns);
//        tablica.setPreferredSize(new Dimension(500,50));
        JScrollPane sp =new JScrollPane(tablica);
        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumMain().add(sp, BorderLayout.CENTER);




        g.getCentrumMain().revalidate();
        g.getCentrumMain().repaint();
    }

    public void Posortuj(ArrayList a, int wybor){

        switch (wybor) {
            case 1:
                osobaComparator = new KomparatorNazwisko();

                break;
            case 2:
                osobaComparator = new KomparatorNazwiskoImie();

                break;
            case 3:
                osobaComparator = new KomparatorNazwiskoWiek();

                break;
        }
        Collections.sort(a,osobaComparator);


    }

    public void AllWyprintuj(GUI g){
        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().setLayout(new BorderLayout());
        JPanel panelgura = new JPanel();
        panelgura.add(new JLabel("Osoby"));

        g.getCentrumNaglowek().add(panelgura,BorderLayout.CENTER);

        JPanel WyjdzHashuj = new JPanel();
        WyjdzHashuj.setLayout(new GridLayout(2,1));
        g.getCentrumNaglowek().add(WyjdzHashuj,BorderLayout.EAST);

        JButton Wyjdz = new JButton("Wyjdz");
        JButton Hashuj = new JButton("Hashuj");




        g.setWyjdzWyprintuj(Wyjdz);
        g.setHashujOsoby(Hashuj);
        WyjdzHashuj.add(Wyjdz);
        WyjdzHashuj.add(Hashuj);



        g.getWyjdzWyprintuj().addActionListener(g);
        g.getHashujOsoby().addActionListener(g);







        JPanel PanelPrawo = new JPanel();
        g.setSortowanieNazwisko(new JButton("Sortowanie Nazwisko"));
        g.setSortowanieNazwiskoImie(new JButton("Sortowanie Nazwisko, Imie"));
        g.setSortowanieNazwiskoWiek(new JButton("Sortowanie Nazwisko, Wiek"));
        g.getSortowanieNazwisko().addActionListener(g);
        g.getSortowanieNazwiskoImie().addActionListener(g);
        g.getSortowanieNazwiskoWiek().addActionListener(g);
        PanelPrawo.setLayout(new GridLayout(3,1));
        PanelPrawo.add(g.getSortowanieNazwisko());
        PanelPrawo.add(g.getSortowanieNazwiskoImie());
        PanelPrawo.add(g.getSortowanieNazwiskoWiek());



        g.getCentrumMain().add(PanelPrawo,BorderLayout.EAST);

        g.revalidate();
        g.repaint();

    }
}

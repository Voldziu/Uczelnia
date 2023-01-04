package StrategiaGUI.Wyprintuj;

import GUI.GUI;
import SkladoweUczelni.Osoba;
import SkladoweUczelni.PracownikA;
import SkladoweUczelni.PracownikBD;
import SkladoweUczelni.PracownikUczelni;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class WyprintujPracownikow implements Wyprintuj{
    public void Wyprintuj(GUI g, ArrayList a ) {
        g.getCentrumMain().removeAll();
        String columnns[] ={"ID","Imie","Nazwisko","PESEL","Wiek","plec","stanowisko","StazPracy","pensja","Nadgodziny/Publikacje"};


        String[][] dane = new String[a.size()][columnns.length];
        for (int i = 0; i <a.size() ; i++) {
            PracownikUczelni element = (PracownikUczelni) a.get(i);
            dane[i][0]= String.valueOf(element.getID());
            dane[i][1]= String.valueOf(element.getImie());
            dane[i][2]=String.valueOf(element.getNazwisko());
            dane[i][3]=String.valueOf(element.getPESEL());
            dane[i][4]=String.valueOf(element.getWiek());
            dane[i][5]=String.valueOf(element.getPlec());
            dane[i][6]=String.valueOf(element.getStanowisko());
            dane[i][7]=String.valueOf(element.getStazPracy());
            dane[i][8]=String.valueOf(element.getPensja());
            if(element instanceof PracownikBD){
                dane[i][9]=String.valueOf(((PracownikBD) element).getLiczbaPublikacji());
            } else{
                dane[i][9]=String.valueOf(((PracownikA)element).getLiczbaNadgodzin());
            }
        }
        JTable tablica = new JTable(dane,columnns);
//        tablica.setPreferredSize(new Dimension(500,50));
        JScrollPane sp =new JScrollPane(tablica);
        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumMain().add(sp,BorderLayout.CENTER);




        g.getCentrumMain().revalidate();
        g.getCentrumMain().repaint();
    }
}

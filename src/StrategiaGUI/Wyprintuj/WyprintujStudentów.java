package StrategiaGUI.Wyprintuj;

import GUI.GUI;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.Osoba;
import SkladoweUczelni.Student;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashSet;

public class WyprintujStudentów implements Wyprintuj{
    @Override
    public void Wyprintuj(GUI g, ArrayList a ) {
        g.getCentrumMain().removeAll();
        String columnns[] ={"ID","Imie","Nazwisko","PESEL","Wiek","plec","index","rok","Lista Kursów (ID,Nazwa)","Erasmus","1 spn","2spn","Stacjo","NStacjo"};


        String[][] dane = new String[a.size()][columnns.length];

        for (int i = 0; i <a.size() ; i++) {
            Student element = (Student) a.get(i);
            dane[i][0]= String.valueOf(element.getID());
            dane[i][1]= String.valueOf(element.getImie());
            dane[i][2]=String.valueOf(element.getNazwisko());
            dane[i][3]=String.valueOf(element.getPESEL());
            dane[i][4]=String.valueOf(element.getWiek());
            dane[i][5]=String.valueOf(element.getPlec());
            dane[i][6]=String.valueOf(element.getIndex());
            dane[i][7]=String.valueOf(element.getRok());
            dane[i][8]="";
            for (int j = 0; j < element.getListaKursow().size(); j++) {
                dane[i][8]+="("+String.valueOf(element.getListaKursow().get(j).getID())+","+String.valueOf(element.getListaKursow().get(j).getNazwaKursu())+")";

            }
            dane[i][9]=String.valueOf(element.GetCzyErasmus());
            dane[i][10]=String.valueOf(element.GetCzyPierwszyStopien());
            dane[i][11]=String.valueOf(element.GetCzyDrugiStopien());
            dane[i][12]=String.valueOf(element.GetCzyStacjonarne());
            dane[i][13]=String.valueOf(element.GetCzyNiestacjonarne());

        }
        JTable tablica = new JTable(dane,columnns);

//        tablica.setPreferredSize(new Dimension(500,50));
        JScrollPane sp =new JScrollPane(tablica);
        g.getCentrumMain().setLayout(new BorderLayout());
        g.getCentrumMain().add(sp,BorderLayout.CENTER);




        g.getCentrumMain().revalidate();
        g.getCentrumMain().repaint();
    }

    public ArrayList<Student> Hashuj(ArrayList<Student> a){
        HashSet<Student> StudentSet = new HashSet<Student>(a);
        return new ArrayList<Student>(StudentSet);
    }


    public void AllWyprintuj(GUI g){
        g.getCentrumNaglowek().removeAll();
        g.getCentrumNaglowek().setLayout(new BorderLayout());
        JPanel panelgura = new JPanel();
        panelgura.add(new JLabel("Studenci"));

        g.getCentrumNaglowek().add(panelgura,BorderLayout.CENTER);

        JPanel WyjdzHashuj = new JPanel();
        WyjdzHashuj.setLayout(new GridLayout(2,1));
        g.getCentrumNaglowek().add(WyjdzHashuj,BorderLayout.EAST);

        JButton Wyjdz = new JButton("Wyjdz");
        JButton Hashuj = new JButton("Hashuj");




        g.setWyjdzWyprintuj(Wyjdz);
        g.setHashujStudenta(Hashuj);
        WyjdzHashuj.add(Wyjdz);
        WyjdzHashuj.add(Hashuj);



        g.getWyjdzWyprintuj().addActionListener(g);
        g.getHashujStudenta().addActionListener(g);



        g.revalidate();
        g.repaint();

    }

}

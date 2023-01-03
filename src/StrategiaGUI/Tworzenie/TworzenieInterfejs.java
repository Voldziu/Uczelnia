package StrategiaGUI.Tworzenie;

import SkladoweUczelni.Kurs;
import GUI.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TworzenieInterfejs {
    JPanel PanelLewus  = new JPanel();
    JPanel PanelDonos = new JPanel();
    JPanel PanelPrawus = new JPanel();

    public void StworzPodwaliny(GUI g){




        g.getCentrumNaglowek().removeAll();
//        g.setZatwierdzStworzStudent(new JButton("Zatwierdz"));
//        g.setWyjdzStworz(new JButton("Wyjdz"));
//        g.getZatwierdzStworzStudent().addActionListener(g);
//        g.getWyjdzStworz().addActionListener(g);
        g.setListaTextow(new ArrayList<JTextField>());

//        PanelPrawus.setPreferredSize(new Dimension(200,100));
//        PanelPrawus.setLayout(new GridLayout(-1,2));



        g.getCentrumMain().setLayout(new BorderLayout());
//        g.getCentrumNaglowek().add(labelglowny);
//        g.getCentrumNaglowek().add(g.getZatwierdzStworzStudent());
//        g.getCentrumNaglowek().add(g.getWyjdzStworz());

        g.getCentrumMain().add(PanelLewus,BorderLayout.WEST);
        g.getCentrumMain().add(PanelDonos,BorderLayout.CENTER);
        g.getCentrumMain().add(PanelPrawus,BorderLayout.EAST);

//        for (int i = 0; i <LiczbaZmiennych ; i++) {
//
//            JLabel label = new JLabel(nazwy.get(i));
//
//            JTextField text = new JTextField();
//
//
//            PanelDonos.add(text);
//            PanelLewus.add(label);
//
//
//            g.getListaTextow().add(text);
//
//        }
//        for (int i = 0; i <LiczbaBoolean ; i++) {
//            JLabel label = new JLabel(nazwyBoolean.get(i));
//            Checkbox checkbox = new Checkbox();
//            g.getListaCheckBoxowStudenta().add(checkbox);
//            PanelDonos.add(checkbox);
//            PanelLewus.add(label);
//
//
//        }









    }
    }




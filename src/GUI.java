

import Observable.Uczelnia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI {
    Uczelnia pwr = new Uczelnia();




    JButton przycisk1 = new JButton("Kliknij mnie 1");
    JButton przycisk2 = new JButton("Kliknij mnie 2");
    JButton przycisk3 = new JButton("Kliknij mnie 3");
    JButton przycisk4 = new JButton("Kliknij mnie 4");
    JButton przycisk5 = new JButton("Kliknij mnie 5");

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    JTextField text = new JTextField(20);

    private JFrame ramka  = new JFrame();

    class ReakcjaNaprzycisk1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            przycisk1.setText(text.getText());
            ramka.getContentPane().add(BorderLayout.EAST,panel1);
            ramka.getContentPane().add(BorderLayout.WEST,panel2);
            panel1.add(przycisk1);
            panel2.add(przycisk2);
            pwr.Wyprintuj(pwr.getStanowiskaA());



        }
    }


    public void Graj(){
        panel3.setLayout(new BoxLayout(panel3, BoxLayout.Y_AXIS));
        ramka.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ramka.getContentPane().add(BorderLayout.NORTH, panel1);
        ramka.getContentPane().add(BorderLayout.WEST, panel2);

        //Tu dodamy dwa kolejne komponenty - tj. do panelu 3 w centralnej cz�ci
        ramka.getContentPane().add(BorderLayout.CENTER, panel3);

        ramka.getContentPane().add(BorderLayout.EAST, panel4);
        ramka.getContentPane().add(BorderLayout.SOUTH, panel5);
        text.setText("chuj");
        panel1.add(przycisk1);
        panel2.add(przycisk2);
        panel3.add(przycisk3);
        panel4.add(przycisk4);
        panel5.add(przycisk5);
        przycisk1.addActionListener(new ReakcjaNaprzycisk1());


        ramka.setSize(1000,1000);
        ramka.pack();

        ramka.setResizable(false);
        ramka.setVisible(true);



    }



}

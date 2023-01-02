import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class GUI extends JFrame implements ActionListener {
    private ArrayList<JButton> ListaButtonow;
    private ArrayList<JTextField> ListaTextow;

    private JButton Stworz;

    private JButton StworzStudenta;
    private JButton StworzPracownikaBD;
    private JButton StworzPracownikaA;
    private JButton StworzKurs;

    private JButton Usun;
    private JButton UsunStudenta;
    private JButton UsunPracownika;
    private JButton UsunKurs;

    private JButton Wyprintuj;

    private JButton WyprintujStudenta;
    private JButton WyprintujPracownika;
    private JButton WyprintujOsoby;

    private JButton WyprintujKurs;

    private JButton Wyszukaj;

    private JButton WyszukajStudenta;
    private JButton WyszukajPracownika;
    private JButton WyszukajKurs;

    private JButton Cofnij;
    private JPanel polnoc;
    private JPanel poludnie;
    private JPanel wschod;
    private JPanel zachod;
    private JPanel centrum;
    private JPanel centrumNaglowek;
    private JPanel centrumMain;

    private JLabel naglowek;
    private JLabel whattodo;




    public GUI(){
         Stworz = new JButton("Stwórz");
         StworzStudenta = new JButton("Stwórz Studenta");
         StworzPracownikaA = new JButton("Stwórz Pracownika Administracji");
         StworzPracownikaBD = new JButton("Stwórz Pracownika Badawczo-Dydaktycznego");
         StworzKurs = new JButton("Stwórz Kurs");


         Usun = new JButton("Usuń");
         UsunStudenta = new JButton("Usuń Studenta");
         UsunPracownika = new JButton("Usuń Pracownika");
         UsunKurs = new JButton("Usuń Kurs");


         Wyprintuj = new JButton("Wyprintuj");
        WyprintujStudenta = new JButton("Wyprintuj Studentów");
        WyprintujPracownika = new JButton("Wyprintuj Pracowników");
        WyprintujKurs = new JButton("Wyprintuj Kursy");
        WyprintujOsoby = new JButton("Wyprintuj Osoby");

         Wyszukaj = new JButton("Wyszukaj");
         WyszukajStudenta = new JButton("Wyszukaj Studenta");
        WyszukajPracownika = new JButton("Wyszukaj Pracownika");
        WyszukajKurs = new JButton("Wyszukaj Kurs");
         Cofnij = new JButton("Cofnij");




         naglowek = new JLabel();
         naglowek.setText("Witaj w Pe Wu Er");
         naglowek.setFont(new Font(null,1,20));

         whattodo = new JLabel();
         whattodo.setText("Co chcesz zrobić?");
         whattodo.setFont(new Font(null,1,10));






         polnoc = new JPanel();
         poludnie = new JPanel();
         wschod = new JPanel();
         zachod = new JPanel();
         centrum = new JPanel();
         centrumNaglowek = new JPanel();

         centrumMain = new JPanel();


    // Layouty

         zachod.setLayout(new GridLayout(5,1));
         centrum.setLayout(new BorderLayout());


    // Action Listernery

        Stworz.addActionListener(this);
        Cofnij.addActionListener(this);
        Wyszukaj.addActionListener(this);
        Wyprintuj.addActionListener(this);
        Usun.addActionListener(this);



    //Kolorki



         polnoc.setBackground(Color.red);
         poludnie.setBackground(Color.blue);
         wschod.setBackground(Color.yellow);
         zachod.setBackground(Color.green);

         centrumNaglowek.setBackground(Color.lightGray);
         centrumMain.setBackground(Color.darkGray);

    // Rozmiary


         polnoc.setPreferredSize(new Dimension(100,50));
         poludnie.setPreferredSize(new Dimension(100,50));
         wschod.setPreferredSize(new Dimension(100,100));
         zachod.setPreferredSize(new Dimension(100,100));
         centrum.setPreferredSize(new Dimension(100,100));
         centrumNaglowek.setPreferredSize(new Dimension(100,40));




    // Dodawanie

        polnoc.add(naglowek);
        zachod.add(Stworz);
        zachod.add(Usun);
        zachod.add(Wyprintuj);
        zachod.add(Wyszukaj);
        zachod.add(Cofnij);
        centrum.add(centrumNaglowek,BorderLayout.NORTH);
        centrum.add(centrumMain,BorderLayout.CENTER);
        centrumNaglowek.add(whattodo);



    // Kontruktor


         this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         this.setLayout(new BorderLayout());
         this.setSize(1000,500);
//         this.pack();
         this.setVisible(true);
         this.add(polnoc,BorderLayout.NORTH);
         this.add(poludnie,BorderLayout.SOUTH);
         this.add(wschod,BorderLayout.EAST);
         this.add(zachod,BorderLayout.WEST);
         this.add(centrum,BorderLayout.CENTER);




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Stworz){
            StworzMenu();
            InterfejsTworzenia(5, new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajnyuuuuu", "ProfesorZwyczajny", "Wykladowca")));


        } else if (e.getSource()==Cofnij) {
            CofnijMenu();
            centrumNaglowek.add(whattodo);


        } else if (e.getSource()==Usun) {
            UsunMenu();
        } else if (e.getSource()==Wyszukaj) {
            WyszukajMenu();


        } else if (e.getSource()==Wyprintuj) {
            WyprintujMenu();

        } else if (ListaButtonow.contains(e.getSource())) {
            OdczytajTekst(e);


            
        }


    }



    public void StworzMenu(){
        CofnijMenu();

        centrumNaglowek.setLayout(new FlowLayout());
        centrumNaglowek.add(StworzStudenta);
        centrumNaglowek.add(StworzPracownikaA);
        centrumNaglowek.add(StworzPracownikaBD);
        centrumNaglowek.add(StworzKurs);
        this.revalidate();
        this.repaint();
    }


    public void CofnijMenu(){
        centrumNaglowek.removeAll();
        centrumMain.removeAll();

        this.revalidate();
        this.repaint();
    }
    public void WyszukajMenu(){
        CofnijMenu();

        centrumNaglowek.setLayout(new FlowLayout());
        centrumNaglowek.add(WyszukajStudenta);
        centrumNaglowek.add(WyszukajPracownika);
        centrumNaglowek.add(WyszukajKurs);
        this.revalidate();
        this.repaint();

    }

    public void WyprintujMenu(){
        CofnijMenu();
        centrumNaglowek.setLayout(new FlowLayout());
        centrumNaglowek.add(WyszukajStudenta);
        centrumNaglowek.add(WyprintujPracownika);
        centrumNaglowek.add(WyprintujKurs);
        centrumNaglowek.add(WyprintujOsoby);

        this.revalidate();
        this.repaint();

    }
    public void UsunMenu(){
       CofnijMenu();

        centrumNaglowek.setLayout(new FlowLayout());
        centrumNaglowek.add(UsunStudenta);
        centrumNaglowek.add(UsunPracownika);
        centrumNaglowek.add(UsunKurs);

        this.revalidate();
        this.repaint();
    }

    public void OdczytajTekst(ActionEvent e){
        int index = ListaButtonow.indexOf(e.getSource());
        ((JButton)e.getSource()).setEnabled(false);


        System.out.println(ListaTextow.get(index).getText());
    }



    public void InterfejsTworzenia(int LiczbaZmiennych,ArrayList<String> nazwy){





        ListaButtonow = new ArrayList<JButton>();
        ListaTextow = new ArrayList<JTextField>();

        JPanel PanelLewus  = new JPanel();
        PanelLewus.setLayout(new GridLayout(LiczbaZmiennych,1));

        JPanel PanelDonos = new JPanel();
        PanelDonos.setLayout(new GridLayout(LiczbaZmiennych,1));

        JPanel PanelPrawak = new JPanel();
        PanelPrawak.setLayout(new GridLayout(LiczbaZmiennych,1));



        centrumMain.setLayout(new BorderLayout());

        centrumMain.add(PanelLewus,BorderLayout.WEST);
        centrumMain.add(PanelDonos,BorderLayout.CENTER);
        centrumMain.add(PanelPrawak,BorderLayout.EAST);
        for (int i = 0; i <LiczbaZmiennych ; i++) {
            JButton button = new JButton("Zatwierdz");
            JLabel label = new JLabel(nazwy.get(i));
            button.addActionListener(this);
            JTextField text = new JTextField();

            PanelPrawak.add(button);
            PanelDonos.add(text);
            PanelLewus.add(label);

            ListaButtonow.add(button);
            ListaTextow.add(text);

        }







        this.revalidate();
        this.repaint();

    }
}




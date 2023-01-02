import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class GUI extends JFrame implements ActionListener {
    private ArrayList<JButton> ListaButtonow;
    private ArrayList<JTextField> ListaTextow;

    private JButton wyjdzStworz;

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

    private JButton zatwierdz;
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
        StworzPracownikaA.addActionListener(this);
        StworzPracownikaBD.addActionListener(this);




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
         this.setSize(1200,500);
//         this.pack();
         this.setVisible(true);
         this.add(polnoc,BorderLayout.NORTH);
         this.add(poludnie,BorderLayout.SOUTH);
         this.add(wschod,BorderLayout.EAST);
         this.add(zachod,BorderLayout.WEST);
         this.add(centrum,BorderLayout.CENTER);

        this.revalidate();
        this.repaint();




    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==Stworz){
            StworzMenu();


        } else if (e.getSource()==StworzPracownikaA) {
            InterfejsTworzenia(new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykladowca")),"lol");

        } else if (e.getSource()==StworzPracownikaBD) {
            InterfejsTworzenia(new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykladowca","6")),"BD");

        } else if (e.getSource()==Cofnij) {
            CofnijMenu();
            centrumNaglowek.add(whattodo);


        } else if (e.getSource()==Usun) {
            UsunMenu();
        } else if (e.getSource()==Wyszukaj) {
            WyszukajMenu();


        } else if (e.getSource()==Wyprintuj) {
            WyprintujMenu();

        } else if (e.getSource()==zatwierdz) {
            ZwrocListeTekstow(e);
            System.out.println(ZwrocListeTekstow(e));


            
        } else if (e.getSource()== wyjdzStworz) {
            StworzMenu();




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

    public ArrayList ZwrocListeTekstow(ActionEvent e){
        ((JButton)e.getSource()).setEnabled(false);
        ArrayList<String> lista = new ArrayList<String>();
        for (int i = 0; i <ListaTextow.size(); i++) {
            lista.add(ListaTextow.get(i).getText());



        }

        return lista;
    }



    public void InterfejsTworzenia(ArrayList<String> nazwy,String napis){
        centrumNaglowek.removeAll();
        int LiczbaZmiennych = nazwy.size();

        JLabel labelglowny = new JLabel("Tworzysz: "+napis);
        zatwierdz = new JButton("Zatwierdz");
        wyjdzStworz = new JButton("Wyjdz");
        zatwierdz.addActionListener(this);
        wyjdzStworz.addActionListener(this);


        ListaTextow = new ArrayList<JTextField>();

        JPanel PanelLewus  = new JPanel();
        PanelLewus.setLayout(new GridLayout(LiczbaZmiennych,1));

        JPanel PanelDonos = new JPanel();
        PanelDonos.setLayout(new GridLayout(LiczbaZmiennych,1));





        centrumMain.setLayout(new BorderLayout());
        centrumNaglowek.add(labelglowny);
        centrumNaglowek.add(zatwierdz);
        centrumNaglowek.add(wyjdzStworz);

        centrumMain.add(PanelLewus,BorderLayout.WEST);
        centrumMain.add(PanelDonos,BorderLayout.CENTER);

        for (int i = 0; i <LiczbaZmiennych ; i++) {

            JLabel label = new JLabel(nazwy.get(i));

            JTextField text = new JTextField();


            PanelDonos.add(text);
            PanelLewus.add(label);


            ListaTextow.add(text);

        }







        this.revalidate();
        this.repaint();

    }
}




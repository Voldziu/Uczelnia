package GUI;

import Observable.Uczelnia;
import Observers.ObslugaUczelni;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.PracownikBD;
import SkladoweUczelni.Student;
import Strategia.Usun.*;
import StrategiaGUI.Tworzenie.TworzenieStudenta;
import StrategiaGUI.Tworzenie.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;


public class GUI extends JFrame implements ActionListener {

    protected Tworzenie tworzenie;
    protected Usun usun;

    private ObslugaUczelni uczelnia = new ObslugaUczelni(new Uczelnia());
    private ArrayList<JButton> ListaButtonow;
    private ArrayList<JTextField> ListaTextow;
    private  ArrayList<Checkbox> ListaCheckBoxow;
    private ArrayList<Checkbox> ListaCheckBoxowStudenta;

    private JButton wyjdzStworz;
    private JButton wyjdzWyszukaj;
    private JButton wyjdzUsun;
    private JButton wyjdzWprintuj;

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
    private JButton zatwierdzStworzStudent;
    private JButton zatwierdzStworzA;
    private JButton zatwierdzStworzBD;
    private JButton zatwierdzStworzKurs;
    private JButton zatwierdzUsunKurs;
    private JButton zatwierdzUsunStudent;
    private JButton zatwierdzUsunPracownik;
    private JButton zatwierdzWyszukajKurs;
    private JButton zatwierdzWyszukajStudent;
    private JButton zatwierdzWyszukajPracownik;
    private JButton zatwierdzWyszukajOsoby;



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
        uczelnia.getDane().odczytaj();
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
        StworzStudenta.addActionListener(this);
        StworzKurs.addActionListener(this);





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


         this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent e) {   //----------- Zapisywanie pod wyłączeniem

                e.getWindow().dispose();
                uczelnia.getDane().zapisz();
            }
        });

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
             new TworzeniePracownikA().Stworz(this);

        } else if (e.getSource()==StworzPracownikaBD) {
            new TworzeniePracownikBD().Stworz(this);

        } else if (e.getSource()==StworzStudenta) {
            new TworzenieStudenta().Stworz(this);

        } else if (e.getSource()==StworzKurs) {
            new TworzenieKurs().Stworz(this);

        } else if (e.getSource()==Cofnij) {
            CofnijMenu();
            centrumNaglowek.add(whattodo);


        } else if (e.getSource()==Usun) {
            UsunMenu();
        } else if (e.getSource()==UsunStudenta) {
            new UsunStudenta().Usun((String) ZwrocListeTekstow(e).get(0),uczelnia.getDane());


        } else if (e.getSource()==UsunKurs) {


        } else if (e.getSource() == UsunPracownika) {



        } else if (e.getSource()==Wyszukaj) {
            WyszukajMenu();


        } else if (e.getSource()==Wyprintuj) {
            WyprintujMenu();

        } else if (e.getSource()==zatwierdzStworzStudent) {
            ZwrocListeTekstow(e);
            ZwrocCheckBoxy(ListaCheckBoxow);

            uczelnia.getDane().Add(new Student(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),(String) ZwrocListeTekstow(e).get(2),(String)ZwrocListeTekstow(e).get(3),Integer.parseInt((String) ZwrocListeTekstow(e).get(4)),(String)ZwrocListeTekstow(e).get(5),Integer.parseInt((String) ZwrocListeTekstow(e).get(6)),Integer.parseInt((String) ZwrocListeTekstow(e).get(7)), (ArrayList<Kurs>) ZwrocListeKursow(ZwrocCheckBoxy(ListaCheckBoxow)), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(0), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(1), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(2), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(3), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(4)));
            System.out.println(ZwrocListeTekstow(e));
            System.out.println(ZwrocCheckBoxy(ListaCheckBoxow));
            System.out.println(ZwrocCheckBoxy(ListaCheckBoxowStudenta));
            uczelnia.getDane().Wyprintuj(uczelnia.getDane().getOsoby());


            
        } else if (e.getSource()==zatwierdzStworzA) {
            ZwrocListeTekstow(e);
            uczelnia.getDane().Add(new PracownikBD(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),(String) ZwrocListeTekstow(e).get(2),(String)ZwrocListeTekstow(e).get(3),Integer.parseInt((String) ZwrocListeTekstow(e).get(4)),(String)ZwrocListeTekstow(e).get(5),(String)ZwrocListeTekstow(e).get(6), Double.parseDouble((String) ZwrocListeTekstow(e).get(7)), Double.parseDouble((String) ZwrocListeTekstow(e).get(8)),Integer.parseInt((String) ZwrocListeTekstow(e).get(9))));

            System.out.println(ZwrocListeTekstow(e));




        }else if (e.getSource()==zatwierdzStworzBD) {
            ZwrocListeTekstow(e);
            uczelnia.getDane().Add(new PracownikBD(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),(String) ZwrocListeTekstow(e).get(2),(String)ZwrocListeTekstow(e).get(3),Integer.parseInt((String) ZwrocListeTekstow(e).get(4)),(String)ZwrocListeTekstow(e).get(5),(String)ZwrocListeTekstow(e).get(6), Double.parseDouble((String) ZwrocListeTekstow(e).get(7)), Double.parseDouble((String) ZwrocListeTekstow(e).get(8)),Integer.parseInt((String) ZwrocListeTekstow(e).get(9))));

            System.out.println(ZwrocListeTekstow(e));




        }else if (e.getSource()==zatwierdzStworzKurs) {
            ZwrocListeTekstow(e);
            ZwrocCheckBoxy(ListaCheckBoxow);
            uczelnia.getDane().Add(new Kurs(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),uczelnia.getDane().getPracownicy().get((Integer) ZwrocCheckBoxy(ListaCheckBoxow).get(0)),Integer.parseInt((String) ZwrocListeTekstow(e).get(2))));
            System.out.println(ZwrocListeTekstow(e));
            System.out.println(ZwrocCheckBoxy(ListaCheckBoxow));



        }else if (e.getSource()== wyjdzStworz) {
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
    public ArrayList ZwrocCheckBoxy(ArrayList a){
        ArrayList<Integer> lista = new ArrayList<Integer>();
        if(!(a==null)){
            for (int i = 0; i <a.size() ; i++) {
                Checkbox checkbox = (Checkbox) a.get(i);
                if(checkbox.getState()){
                    lista.add(a.indexOf(checkbox));

                }
            }
        }



        return lista;

    }   //--To wyeksportowac gdzie indziej, jakos mądrzej
    public ArrayList ZwrocListeKursow(ArrayList a){
        ArrayList<Kurs> lista = new ArrayList<Kurs>();
        for (int i = 0; i <a.size() ; i++) {
            lista.add(uczelnia.getDane().getKursy().get((Integer) a.get(i)));


        }
        return lista;
    }
    public ArrayList ZwrocListeBoolean(ArrayList a){
        ArrayList<Boolean> lista = new ArrayList<Boolean>(Arrays.asList(false,false,false,false,false));
        for (int i = 0; i <a.size() ; i++) {
            lista.set((Integer) a.get(i),true);
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

        JPanel PanelPrawus = new JPanel();
        PanelPrawus.setPreferredSize(new Dimension(200,100));
        PanelPrawus.setLayout(new GridLayout(-1,2));







        centrumMain.setLayout(new BorderLayout());
        centrumNaglowek.add(labelglowny);
        centrumNaglowek.add(zatwierdz);
        centrumNaglowek.add(wyjdzStworz);

        centrumMain.add(PanelLewus,BorderLayout.WEST);
        centrumMain.add(PanelDonos,BorderLayout.CENTER);
        centrumMain.add(PanelPrawus,BorderLayout.EAST);

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





















    //gettery


    public JButton getWyjdzWyszukaj() {
        return wyjdzWyszukaj;
    }

    public void setWyjdzWyszukaj(JButton wyjdzWyszukaj) {
        this.wyjdzWyszukaj = wyjdzWyszukaj;
    }

    public JButton getWyjdzUsun() {
        return wyjdzUsun;
    }

    public void setWyjdzUsun(JButton wyjdzUsun) {
        this.wyjdzUsun = wyjdzUsun;
    }

    public JButton getWyjdzWprintuj() {
        return wyjdzWprintuj;
    }

    public void setWyjdzWprintuj(JButton wyjdzWprintuj) {
        this.wyjdzWprintuj = wyjdzWprintuj;
    }

    public JButton getZatwierdzUsunKurs() {
        return zatwierdzUsunKurs;
    }

    public void setZatwierdzUsunKurs(JButton zatwierdzUsunKurs) {
        this.zatwierdzUsunKurs = zatwierdzUsunKurs;
    }

    public JButton getZatwierdzUsunStudent() {
        return zatwierdzUsunStudent;
    }

    public void setZatwierdzUsunStudent(JButton zatwierdzUsunStudent) {
        this.zatwierdzUsunStudent = zatwierdzUsunStudent;
    }

    public JButton getZatwierdzUsunPracownik() {
        return zatwierdzUsunPracownik;
    }

    public void setZatwierdzUsunPracownik(JButton zatwierdzUsunPracownik) {
        this.zatwierdzUsunPracownik = zatwierdzUsunPracownik;
    }

    public JButton getZatwierdzWyszukajKurs() {
        return zatwierdzWyszukajKurs;
    }

    public void setZatwierdzWyszukajKurs(JButton zatwierdzWyszukajKurs) {
        this.zatwierdzWyszukajKurs = zatwierdzWyszukajKurs;
    }

    public JButton getZatwierdzWyszukajStudent() {
        return zatwierdzWyszukajStudent;
    }

    public void setZatwierdzWyszukajStudent(JButton zatwierdzWyszukajStudent) {
        this.zatwierdzWyszukajStudent = zatwierdzWyszukajStudent;
    }

    public JButton getZatwierdzWyszukajPracownik() {
        return zatwierdzWyszukajPracownik;
    }

    public void setZatwierdzWyszukajPracownik(JButton zatwierdzWyszukajPracownik) {
        this.zatwierdzWyszukajPracownik = zatwierdzWyszukajPracownik;
    }

    public JButton getZatwierdzWyszukajOsoby() {
        return zatwierdzWyszukajOsoby;
    }

    public void setZatwierdzWyszukajOsoby(JButton zatwierdzWyszukajOsoby) {
        this.zatwierdzWyszukajOsoby = zatwierdzWyszukajOsoby;
    }

    public ArrayList<Checkbox> getListaCheckBoxowStudenta() {
        return ListaCheckBoxowStudenta;
    }

    public void setListaCheckBoxowStudenta(ArrayList<Checkbox> listaCheckBoxowStudenta) {
        ListaCheckBoxowStudenta = listaCheckBoxowStudenta;
    }

    public Tworzenie getTworzenie() {
        return tworzenie;
    }

    public void setTworzenie(Tworzenie tworzenie) {
        this.tworzenie = tworzenie;
    }

    public ArrayList<Checkbox> getListaCheckBoxow() {
        return ListaCheckBoxow;
    }

    public void setListaCheckBoxow(ArrayList<Checkbox> listaCheckBoxow) {
        ListaCheckBoxow = listaCheckBoxow;
    }

    public ObslugaUczelni getUczelnia() {
        return uczelnia;
    }

    public void setUczelnia(ObslugaUczelni uczelnia) {
        this.uczelnia = uczelnia;
    }

    public ArrayList<JButton> getListaButtonow() {
        return ListaButtonow;
    }

    public void setListaButtonow(ArrayList<JButton> listaButtonow) {
        ListaButtonow = listaButtonow;
    }

    public ArrayList<JTextField> getListaTextow() {
        return ListaTextow;
    }

    public void setListaTextow(ArrayList<JTextField> listaTextow) {
        ListaTextow = listaTextow;
    }

    public JButton getWyjdzStworz() {
        return wyjdzStworz;
    }

    public void setWyjdzStworz(JButton wyjdzStworz) {
        this.wyjdzStworz = wyjdzStworz;
    }

    public JButton getStworz() {
        return Stworz;
    }

    public void setStworz(JButton stworz) {
        Stworz = stworz;
    }

    public JButton getStworzStudenta() {
        return StworzStudenta;
    }

    public void setStworzStudenta(JButton stworzStudenta) {
        StworzStudenta = stworzStudenta;
    }

    public JButton getStworzPracownikaBD() {
        return StworzPracownikaBD;
    }

    public void setStworzPracownikaBD(JButton stworzPracownikaBD) {
        StworzPracownikaBD = stworzPracownikaBD;
    }

    public JButton getStworzPracownikaA() {
        return StworzPracownikaA;
    }

    public void setStworzPracownikaA(JButton stworzPracownikaA) {
        StworzPracownikaA = stworzPracownikaA;
    }

    public JButton getStworzKurs() {
        return StworzKurs;
    }

    public void setStworzKurs(JButton stworzKurs) {
        StworzKurs = stworzKurs;
    }

    public JButton getUsun() {
        return Usun;
    }

    public void setUsun(JButton usun) {
        Usun = usun;
    }

    public JButton getUsunStudenta() {
        return UsunStudenta;
    }

    public void setUsunStudenta(JButton usunStudenta) {
        UsunStudenta = usunStudenta;
    }

    public JButton getUsunPracownika() {
        return UsunPracownika;
    }

    public void setUsunPracownika(JButton usunPracownika) {
        UsunPracownika = usunPracownika;
    }

    public JButton getUsunKurs() {
        return UsunKurs;
    }

    public void setUsunKurs(JButton usunKurs) {
        UsunKurs = usunKurs;
    }

    public JButton getWyprintuj() {
        return Wyprintuj;
    }

    public void setWyprintuj(JButton wyprintuj) {
        Wyprintuj = wyprintuj;
    }

    public JButton getWyprintujStudenta() {
        return WyprintujStudenta;
    }

    public void setWyprintujStudenta(JButton wyprintujStudenta) {
        WyprintujStudenta = wyprintujStudenta;
    }

    public JButton getWyprintujPracownika() {
        return WyprintujPracownika;
    }

    public void setWyprintujPracownika(JButton wyprintujPracownika) {
        WyprintujPracownika = wyprintujPracownika;
    }

    public JButton getWyprintujOsoby() {
        return WyprintujOsoby;
    }

    public void setWyprintujOsoby(JButton wyprintujOsoby) {
        WyprintujOsoby = wyprintujOsoby;
    }

    public JButton getWyprintujKurs() {
        return WyprintujKurs;
    }

    public void setWyprintujKurs(JButton wyprintujKurs) {
        WyprintujKurs = wyprintujKurs;
    }

    public JButton getWyszukaj() {
        return Wyszukaj;
    }

    public void setWyszukaj(JButton wyszukaj) {
        Wyszukaj = wyszukaj;
    }

    public JButton getWyszukajStudenta() {
        return WyszukajStudenta;
    }

    public void setWyszukajStudenta(JButton wyszukajStudenta) {
        WyszukajStudenta = wyszukajStudenta;
    }

    public JButton getWyszukajPracownika() {
        return WyszukajPracownika;
    }

    public void setWyszukajPracownika(JButton wyszukajPracownika) {
        WyszukajPracownika = wyszukajPracownika;
    }

    public JButton getWyszukajKurs() {
        return WyszukajKurs;
    }

    public void setWyszukajKurs(JButton wyszukajKurs) {
        WyszukajKurs = wyszukajKurs;
    }

    public JButton getCofnij() {
        return Cofnij;
    }

    public void setCofnij(JButton cofnij) {
        Cofnij = cofnij;
    }

    public JButton getZatwierdz() {
        return zatwierdz;
    }

    public void setZatwierdz(JButton zatwierdz) {
        this.zatwierdz = zatwierdz;
    }

    public JPanel getPolnoc() {
        return polnoc;
    }

    public void setPolnoc(JPanel polnoc) {
        this.polnoc = polnoc;
    }

    public JPanel getPoludnie() {
        return poludnie;
    }

    public void setPoludnie(JPanel poludnie) {
        this.poludnie = poludnie;
    }

    public JPanel getWschod() {
        return wschod;
    }

    public void setWschod(JPanel wschod) {
        this.wschod = wschod;
    }

    public JPanel getZachod() {
        return zachod;
    }

    public void setZachod(JPanel zachod) {
        this.zachod = zachod;
    }

    public JPanel getCentrum() {
        return centrum;
    }

    public void setCentrum(JPanel centrum) {
        this.centrum = centrum;
    }

    public JPanel getCentrumNaglowek() {
        return centrumNaglowek;
    }

    public void setCentrumNaglowek(JPanel centrumNaglowek) {
        this.centrumNaglowek = centrumNaglowek;
    }

    public JPanel getCentrumMain() {
        return centrumMain;
    }

    public void setCentrumMain(JPanel centrumMain) {
        this.centrumMain = centrumMain;
    }

    public JLabel getNaglowek() {
        return naglowek;
    }

    public void setNaglowek(JLabel naglowek) {
        this.naglowek = naglowek;
    }

    public JLabel getWhattodo() {
        return whattodo;
    }

    public void setWhattodo(JLabel whattodo) {
        this.whattodo = whattodo;
    }

    public JButton getZatwierdzStworzStudent() {
        return zatwierdzStworzStudent;
    }

    public void setZatwierdzStworzStudent(JButton zatwierdzStworzStudent) {
        this.zatwierdzStworzStudent = zatwierdzStworzStudent;
    }

    public JButton getZatwierdzStworzA() {
        return zatwierdzStworzA;
    }

    public void setZatwierdzStworzA(JButton zatwierdzStworzA) {
        this.zatwierdzStworzA = zatwierdzStworzA;
    }

    public JButton getZatwierdzStworzBD() {
        return zatwierdzStworzBD;
    }

    public void setZatwierdzStworzBD(JButton zatwierdzStworzBD) {
        this.zatwierdzStworzBD = zatwierdzStworzBD;
    }

    public JButton getZatwierdzStworzKurs() {
        return zatwierdzStworzKurs;
    }

    public void setZatwierdzStworzKurs(JButton zatwierdzStworzKurs) {
        this.zatwierdzStworzKurs = zatwierdzStworzKurs;
    }
}




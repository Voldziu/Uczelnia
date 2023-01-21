package GUI;

import Observable.Uczelnia;
import Observers.ObslugaUczelni;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.PracownikBD;
import SkladoweUczelni.Student;
import Strategia.Podwyzka.PodwyzkaProcent;
import Strategia.Podwyzka.PodwyzkaStala;
import Strategia.Usun.*;
import Strategia.Wyszukaj.WyszukajKurs;
import Strategia.Wyszukaj.WyszukajPracownika;
import Strategia.Wyszukaj.WyszukajStudenta;
import Strategia.WyszukajID.WyszukajPracownikaID;
import StrategiaGUI.Podwyzka.DajPodwyzke;
import StrategiaGUI.Tworzenie.TworzenieStudenta;
import StrategiaGUI.Tworzenie.*;
import StrategiaGUI.Wyprintuj.WyprintujKursy;
import StrategiaGUI.Wyprintuj.WyprintujOsoby;
import StrategiaGUI.Wyprintuj.WyprintujPracownikow;
import StrategiaGUI.Wyprintuj.WyprintujStudentów;
import StrategiaGUI.Wyszukaj.WyszukajKursGUI;
import StrategiaGUI.Wyszukaj.WyszukajPracownikaGUI;
import StrategiaGUI.Wyszukaj.WyszukajStudentaGUI;

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

    private JButton sortowanieNazwisko;
    private JButton sortowanieNazwiskoImie;
    private JButton sortowanieNazwiskoWiek;
    private JButton sortowanieECTSNazwisko;






    private JButton wyjdzStworz;
    private JButton wyjdzWyszukaj;
    private JButton wyjdzUsun;
    private JButton wyjdzWyprintuj;

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
    private JButton DajPodwyzke;
    private JButton zatwierdzPodwyzka;


    private JButton WyjdzPodwyzka;
    private  JButton PodwyzkaProcent;
    private  JButton PodwyzkaStała;


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

    private JButton zatwierdzWyprintujStudent;
    private JButton zatwierdzWyprintujPracownik;
    private JButton zatwierdzWyprintujKurs;
    private JButton zatwierdzWyprintujOsoby;

    private JButton HashujStudenta;
    private JButton HashujPracownika;
    private JButton HashujKurs;
    private JButton HashujOsoby;




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

         DajPodwyzke = new JButton("Daj Podwyżkę");





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

         zachod.setLayout(new GridLayout(6,1));
         centrum.setLayout(new BorderLayout());


    // Action Listernery

        Stworz.addActionListener(this);
        Cofnij.addActionListener(this);
        DajPodwyzke.addActionListener(this);
        Wyszukaj.addActionListener(this);
        Wyprintuj.addActionListener(this);
        Usun.addActionListener(this);
        StworzPracownikaA.addActionListener(this);
        StworzPracownikaBD.addActionListener(this);
        StworzStudenta.addActionListener(this);
        StworzKurs.addActionListener(this);
        WyszukajStudenta.addActionListener(this);
        WyszukajPracownika.addActionListener(this);
        WyszukajKurs.addActionListener(this);
        WyprintujKurs.addActionListener(this);
        WyprintujOsoby.addActionListener(this);
        WyprintujPracownika.addActionListener(this);
        WyprintujStudenta.addActionListener(this);
        UsunStudenta.addActionListener(this);
        UsunPracownika.addActionListener(this);
        UsunKurs.addActionListener(this);
        






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
        zachod.add(DajPodwyzke);
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
//            new TworzeniePracownikBD().Stworz(this);
            new TworzeniePracownikBD().Stworz(this);

        } else if (e.getSource()==StworzStudenta) {
            new TworzenieStudenta().Stworz(this);

        } else if (e.getSource()==StworzKurs) {
            new TworzenieKurs().Stworz(this);

        } else if (e.getSource()==DajPodwyzke) {

            new DajPodwyzke().DajPodwyzke(this);
            new WyprintujPracownikow().Wyprintuj(this,uczelnia.getDane().getPracownicy());

        } else if (e.getSource()==zatwierdzPodwyzka) {
            ZwrocListeTekstow(e);

            new WyprintujPracownikow().Wyprintuj(this,new ArrayList<>(Arrays.asList(new WyszukajPracownikaID().WyszukajID(ListaTextow.get(0).getText(), uczelnia.getDane()))));
            new DajPodwyzke().PoZatwierdzeniu(this);


        } else if (e.getSource()==WyjdzPodwyzka) {
            new DajPodwyzke().DajPodwyzke(this);
            new WyprintujPracownikow().Wyprintuj(this,uczelnia.getDane().getPracownicy());


        } else if (e.getSource()==PodwyzkaProcent) {
            ZwrocListeTekstow(e);
            new PodwyzkaProcent().DajPodwyzke(new WyszukajPracownikaID().WyszukajID(ListaTextow.get(0).getText(), uczelnia.getDane()),ListaTextow.get(1).getText());



        } else if (e.getSource()==PodwyzkaStała) {
            ZwrocListeTekstow(e);
            new PodwyzkaStala().DajPodwyzke(new WyszukajPracownikaID().WyszukajID(ListaTextow.get(0).getText(), uczelnia.getDane()),ListaTextow.get(1).getText());



        } else if (e.getSource()==Cofnij) {
            CofnijMenu();
            centrumNaglowek.add(whattodo);


        } else if (e.getSource()==Usun) {
            UsunMenu();
        } else if (e.getSource()==UsunStudenta) {
            new StrategiaGUI.Usun.UsunStudenta().Usun(this);


        } else if (e.getSource()==zatwierdzUsunStudent) {
            ZwrocListeTekstow(e);

            new WyprintujStudentów().Wyprintuj(this, new WyszukajStudenta().Wyszukaj(ListaTextow.get(0).getText(), uczelnia.getDane()));
            new UsunStudenta().Usun(ListaTextow.get(0).getText(), uczelnia.getDane());


        }else if (e.getSource()==UsunPracownika) {
            new StrategiaGUI.Usun.UsunPracownika().Usun(this);


        } else if (e.getSource()==zatwierdzUsunPracownik) {
            ZwrocListeTekstow(e);

            new WyprintujPracownikow().Wyprintuj(this, new WyszukajPracownika().Wyszukaj(ListaTextow.get(0).getText(), uczelnia.getDane()));
            new UsunPracownika().Usun(ListaTextow.get(0).getText(), uczelnia.getDane());


        } else if (e.getSource()==UsunKurs) {
            new StrategiaGUI.Usun.UsunKurs().Usun(this);


        } else if (e.getSource()==zatwierdzUsunKurs) {
            ZwrocListeTekstow(e);

            new WyprintujKursy().Wyprintuj(this, new WyszukajKurs().Wyszukaj(ListaTextow.get(0).getText(), uczelnia.getDane()));
            new UsunKurs().Usun(ListaTextow.get(0).getText(), uczelnia.getDane());


        }
        else if (e.getSource()==Wyszukaj) {
            WyszukajMenu();





        } else if (e.getSource()==WyszukajStudenta) {

           new WyszukajStudentaGUI().Szukaj(this);


        } else if (e.getSource()==zatwierdzWyszukajStudent) {
            ZwrocListeTekstow(e);
            new WyprintujStudentów().Wyprintuj(this,new WyszukajStudenta().Wyszukaj(ListaTextow.get(0).getText(),uczelnia.getDane()));






        } else if (e.getSource()==WyszukajPracownika) {
            new WyszukajPracownikaGUI().Szukaj(this);


        } else if (e.getSource()==zatwierdzWyszukajPracownik) {
            ZwrocListeTekstow(e);
            new WyprintujPracownikow().Wyprintuj(this,new WyszukajPracownika().Wyszukaj(ListaTextow.get(0).getText(),uczelnia.getDane()));





        } else if (e.getSource()==WyszukajKurs) {
            new WyszukajKursGUI().Szukaj(this);


        } else if (e.getSource()==zatwierdzWyszukajKurs) {
            ZwrocListeTekstow(e);
            new WyprintujKursy().Wyprintuj(this,new WyszukajKurs().Wyszukaj(ListaTextow.get(0).getText(), uczelnia.getDane()));

        } else if (e.getSource()==wyjdzWyszukaj) {
            WyszukajMenu();

        } else if (e.getSource()==Wyprintuj) {
            WyprintujMenu();

        } else if (e.getSource()==WyprintujKurs) {
            new WyprintujKursy().Wyprintuj(this,uczelnia.getDane().getKursy());
            new WyprintujKursy().AllWyprintuj(this);

        } else if (e.getSource() == wyjdzWyprintuj) {
            WyprintujMenu();

        } else if (e.getSource()==sortowanieECTSNazwisko) {
            WyprintujKursy wyprintujKursy = new WyprintujKursy();
            System.out.println("1");
            ArrayList a = uczelnia.getDane().getKursy();
            wyprintujKursy.Posortuj(a,1);
            wyprintujKursy.Wyprintuj(this,a);
            wyprintujKursy.AllWyprintuj(this);

        } else if (e.getSource()==WyprintujOsoby) {

            new WyprintujOsoby().Wyprintuj(this,uczelnia.getDane().getOsoby());
            new WyprintujOsoby().AllWyprintuj(this);


        } else if (e.getSource()==sortowanieNazwisko) {

            SortowanieOsob(1);

        } else if (e.getSource()==sortowanieNazwiskoImie) {
            SortowanieOsob(2);

        } else if (e.getSource()==sortowanieNazwiskoWiek) {
            SortowanieOsob(3);

        } else if (e.getSource()== WyprintujStudenta) {
            new WyprintujStudentów().AllWyprintuj(this);
            new WyprintujStudentów().Wyprintuj(this,uczelnia.getDane().getStudenci());


        } else if (e.getSource()==WyprintujPracownika) {
            new WyprintujPracownikow().AllWyprintuj(this);
            new WyprintujPracownikow().Wyprintuj(this,uczelnia.getDane().getPracownicy());

        } else if (e.getSource()==HashujPracownika) {
            new WyprintujPracownikow().Wyprintuj(this,new WyprintujPracownikow().Hashuj(uczelnia.getDane().getPracownicy()));


        } else if (e.getSource() == HashujStudenta) {
            new WyprintujStudentów().Wyprintuj(this,new WyprintujStudentów().Hashuj(uczelnia.getDane().getStudenci()));

        } else if (e.getSource()==zatwierdzStworzStudent) {
            ZwrocListeTekstow(e);
            ZwrocCheckBoxy(ListaCheckBoxow);

            uczelnia.getDane().Add(new Student(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),(String) ZwrocListeTekstow(e).get(2),(String)ZwrocListeTekstow(e).get(3),Integer.parseInt((String) ZwrocListeTekstow(e).get(4)),(String)ZwrocListeTekstow(e).get(5),Integer.parseInt((String) ZwrocListeTekstow(e).get(6)),Integer.parseInt((String) ZwrocListeTekstow(e).get(7)), (ArrayList<Kurs>) ZwrocListeKursow(ZwrocCheckBoxy(ListaCheckBoxow)), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(0), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(1), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(2), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(3), (Boolean) ZwrocListeBoolean(ZwrocCheckBoxy(ListaCheckBoxowStudenta)).get(4)));

            uczelnia.getDane().Wyprintuj(uczelnia.getDane().getOsoby());


            
        } else if (e.getSource()==zatwierdzStworzA) {
//            ZwrocListeTekstow(e);
//            CzyDobreStanowisko(2,e);
//            uczelnia.getDane().Add(new PracownikBD(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),(String) ZwrocListeTekstow(e).get(2),(String)ZwrocListeTekstow(e).get(3),Integer.parseInt((String) ZwrocListeTekstow(e).get(4)),(String)ZwrocListeTekstow(e).get(5),(String)ZwrocListeTekstow(e).get(6), Double.parseDouble((String) ZwrocListeTekstow(e).get(7)), Double.parseDouble((String) ZwrocListeTekstow(e).get(8)),Integer.parseInt((String) ZwrocListeTekstow(e).get(9))));
//
//            System.out.println(ZwrocListeTekstow(e));
            new TworzeniePracownikA().StworzAlgorytmy(this,CzyDobreStanowisko(2,e),e);




        }else if (e.getSource()==zatwierdzStworzBD) {
            new TworzeniePracownikBD().StworzAlgorytmy(this,CzyDobreStanowisko(1,e),e);




        }else if (e.getSource()==zatwierdzStworzKurs) {
            ZwrocListeTekstow(e);
            ZwrocCheckBoxy(ListaCheckBoxow);
            uczelnia.getDane().Add(new Kurs(Integer.parseInt((String) ZwrocListeTekstow(e).get(0)),(String) ZwrocListeTekstow(e).get(1),uczelnia.getDane().getPracownicy().get((Integer) ZwrocCheckBoxy(ListaCheckBoxow).get(0)),Integer.parseInt((String) ZwrocListeTekstow(e).get(2))));
            System.out.println(ZwrocListeTekstow(e));
            System.out.println(ZwrocCheckBoxy(ListaCheckBoxow));



        }else if (e.getSource()== wyjdzStworz) {
            StworzMenu();
        } else if (e.getSource()==wyjdzUsun) {
            UsunMenu();

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
        centrumNaglowek.add(WyprintujStudenta);
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

    public void PodwyzkaMenu(){
        CofnijMenu();
        centrumNaglowek.setLayout(new FlowLayout());
        centrumNaglowek.add(PodwyzkaProcent);
        centrumNaglowek.add(PodwyzkaStała);

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

    public void SortowanieOsob(int wybor){
        StrategiaGUI.Wyprintuj.WyprintujOsoby wyprintujOsoby = new WyprintujOsoby();
        ArrayList a = uczelnia.getDane().getOsoby();

        wyprintujOsoby.Posortuj(a,wybor);
        wyprintujOsoby.Wyprintuj(this,a);
        wyprintujOsoby.AllWyprintuj(this);
    }


    public boolean CzyDobreStanowisko(int wyborTypu, ActionEvent e){
        ArrayList<String> Stanowiska;
        switch (wyborTypu){
            case 1:
            Stanowiska = new ArrayList<>(Arrays.asList("asystent", "adiunkt", "profesor nadzwyczajny", "profesor zwyczajny", "wykladowca"));
            if (Stanowiska.contains(ZwrocListeTekstow(e).get(6).toString().toLowerCase())) {
                return true;


            } else {
                return false;
            }
            case 2:
                Stanowiska = new ArrayList<>(Arrays.asList("referent","specjalista","starszy specjalista"));
                System.out.println(ZwrocListeTekstow(e).get(6));
                if(Stanowiska.contains(ZwrocListeTekstow(e).get(6).toString().toLowerCase())){
                    return true;
                } else {
                    return false;
                }


            default:
                return false;
        }

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


    public JButton getHashujStudenta() {
        return HashujStudenta;
    }

    public void setHashujStudenta(JButton hashujStudenta) {
        HashujStudenta = hashujStudenta;
    }

    public JButton getHashujPracownika() {
        return HashujPracownika;
    }

    public void setHashujPracownika(JButton hashujPracownika) {
        HashujPracownika = hashujPracownika;
    }

    public JButton getHashujKurs() {
        return HashujKurs;
    }

    public void setHashujKurs(JButton hashujKurs) {
        HashujKurs = hashujKurs;
    }

    public JButton getHashujOsoby() {
        return HashujOsoby;
    }

    public void setHashujOsoby(JButton hashujOsoby) {
        HashujOsoby = hashujOsoby;
    }

    public JButton getDajPodwyzke() {
        return DajPodwyzke;
    }

    public void setDajPodwyzke(JButton dajPodwyzke) {
        DajPodwyzke = dajPodwyzke;
    }

    public JButton getZatwierdzPodwyzka() {
        return zatwierdzPodwyzka;
    }

    public void setZatwierdzPodwyzka(JButton zatwierdzPodwyzka) {
        this.zatwierdzPodwyzka = zatwierdzPodwyzka;
    }

    public JButton getWyjdzPodwyzka() {
        return WyjdzPodwyzka;
    }

    public void setWyjdzPodwyzka(JButton wyjdzPodwyzka) {
        WyjdzPodwyzka = wyjdzPodwyzka;
    }

    public JButton getPodwyzkaProcent() {
        return PodwyzkaProcent;
    }

    public void setPodwyzkaProcent(JButton podwyzkaProcent) {
        PodwyzkaProcent = podwyzkaProcent;
    }

    public JButton getPodwyzkaStała() {
        return PodwyzkaStała;
    }

    public void setPodwyzkaStała(JButton podwyzkaStała) {
        PodwyzkaStała = podwyzkaStała;
    }

    public JButton getSortowanieNazwisko() {
        return sortowanieNazwisko;
    }

    public void setSortowanieNazwisko(JButton sortowanieNazwisko) {
        this.sortowanieNazwisko = sortowanieNazwisko;
    }

    public JButton getSortowanieNazwiskoImie() {
        return sortowanieNazwiskoImie;
    }

    public void setSortowanieNazwiskoImie(JButton sortowanieNazwiskoImie) {
        this.sortowanieNazwiskoImie = sortowanieNazwiskoImie;
    }

    public JButton getSortowanieNazwiskoWiek() {
        return sortowanieNazwiskoWiek;
    }

    public void setSortowanieNazwiskoWiek(JButton sortowanieNazwiskoWiek) {
        this.sortowanieNazwiskoWiek = sortowanieNazwiskoWiek;
    }

    public JButton getSortowanieECTSNazwisko() {
        return sortowanieECTSNazwisko;
    }

    public void setSortowanieECTSNazwisko(JButton sortowanieECTSNazwisko) {
        this.sortowanieECTSNazwisko = sortowanieECTSNazwisko;
    }

    public JButton getZatwierdzWyprintujStudent() {
        return zatwierdzWyprintujStudent;
    }

    public void setZatwierdzWyprintujStudent(JButton zatwierdzWyprintujStudent) {
        this.zatwierdzWyprintujStudent = zatwierdzWyprintujStudent;
    }

    public JButton getZatwierdzWyprintujPracownik() {
        return zatwierdzWyprintujPracownik;
    }

    public void setZatwierdzWyprintujPracownik(JButton zatwierdzWyprintujPracownik) {
        this.zatwierdzWyprintujPracownik = zatwierdzWyprintujPracownik;
    }

    public JButton getZatwierdzWyprintujKurs() {
        return zatwierdzWyprintujKurs;
    }

    public void setZatwierdzWyprintujKurs(JButton zatwierdzWyprintujKurs) {
        this.zatwierdzWyprintujKurs = zatwierdzWyprintujKurs;
    }

    public JButton getZatwierdzWyprintujOsoby() {
        return zatwierdzWyprintujOsoby;
    }

    public void setZatwierdzWyprintujOsoby(JButton zatwierdzWyprintujOsoby) {
        this.zatwierdzWyprintujOsoby = zatwierdzWyprintujOsoby;
    }

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

    public JButton getWyjdzWyprintuj() {
        return wyjdzWyprintuj;
    }

    public void setWyjdzWyprintuj(JButton wyjdzWyprintuj) {
        this.wyjdzWyprintuj = wyjdzWyprintuj;
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




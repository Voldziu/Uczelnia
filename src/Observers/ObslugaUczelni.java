package Observers;

import Funkcjonalnosci.*;


import Observable.Uczelnia;
import SkladoweUczelni.*;
import Strategia.Komparatory.*;
import Strategia.Wyszukaj.*;
import Strategia.WyszukajID.*;
import Strategia.Usun.*;
import Strategia.Podwyzka.*;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ObslugaUczelni  implements Observer, Menu, GUIterminal {
    private Uczelnia Dane;
    private Scanner scan = new Scanner(System.in);

    private ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
    private ArrayList<Kurs> Kursy = new ArrayList<Kurs>();




    protected Wyszukaj search;
    protected WyszukajID searchID;
    protected Usun delete;

    protected PodwyzkaTerminal RaiseInter;



    public ObslugaUczelni(Uczelnia Dane){
        this.Dane = Dane;
        this.Dane.registerObserver(this);



    }






    @Override
    public void update(ArrayList<Osoba> osoby, ArrayList<Kurs> kursy) {
        this.Osoby = Osoby;
        this.Kursy = Kursy;


    }

    public void SortujKursy(){
        int sortKursswitch = scan.nextInt();
        switch (sortKursswitch){
            case 1:
                Collections.sort(Dane.getKursy(),new KomparatorECTSNazwisko());
                break;
            case 2:
                break;
            default:
                System.out.println("Coś poszło nie tak, (sortowanie kursy)");

        }



    }

    public void SortujOsoby() {
        int sortOsobaswitch = scan.nextInt();
        Comparator<Osoba> kompOsoba=null;
        switch (sortOsobaswitch) {
            case 1:
                kompOsoba = new KomparatorNazwisko();
                break;
            case 2:
                kompOsoba = new KomparatorNazwiskoImie();
                break;
            case 3:
                kompOsoba = new KomparatorNazwiskoWiek();
                break;
            case 4:
                break;
            default:
                System.out.println("Coś poszło nietak, (sortowanie)");
        }
        Collections.sort(Dane.getOsoby(), kompOsoba);

    }

    public ArrayList Wyszukaj(String InPut,int wybor){
        switch (wybor) {
            case 1 -> search = new WyszukajStudenta();
            case 2 -> search = new WyszukajPracownika();
            case 3 -> search = new WyszukajKurs();
        }
        return search.Wyszukaj(InPut,Dane);

    }

    public Creation WyszukajID(String InPut,int wybor){
        switch (wybor) {

            case 2 -> searchID = new WyszukajPracownikaID();
            case 3 -> searchID = new WyszukajKursID();
        }
        return searchID.WyszukajID(InPut,Dane);

    }

    public void Usun(String InPut, int wybor){
        switch (wybor) {
            case 1 -> delete = new UsunStudenta();
            case 2 -> delete = new UsunPracownika();
            case 3 -> delete = new UsunKurs();
        }
        delete.Usun(InPut,Dane);

    }



    //Strategia Podwyzka

    public void wykonajStrategie(int nr_Strategii){
        switch (nr_Strategii){
            case 1:
                RaiseInter = new PodwyzkaTerminalSposob1();
                break;
            case 2:
                RaiseInter = new PodwyzkaTerminalSposob2();

                break;
        }
    }

    public void DajPodwyzke(){
        int podwyzkaScan = scan.nextInt();

        wykonajStrategie(podwyzkaScan);
        Dane.Wyprintuj(Dane.getPracownicy());

        System.out.println("Komu chcesz dać podwyżkę? Podaj PESEL: ");
        String PESELPodwyzka = scan.next();


        try{
            getRaiseInter().SposobNaPodwyzke((PracownikUczelni) Wyszukaj(PESELPodwyzka,2).get(0));
        } catch (Exception e){
            System.out.println("Niepoprawny PESEL");
        }
    }



    @Override
    public void WypiszMenu() {
        System.out.println("--------------MENU--------------\n");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("Dopisz: ");
        System.out.println("\t 101 --- Dopisz Studenta" );
        System.out.println("\t 102 --- Dopisz Pracownika Badawczo-Dydaktycznego");
        System.out.println("\t 103 --- Dopisz Pracownika Administracji");
        System.out.println("\t 104 --- Dopisz Kurs");
        System.out.println("Wyprintuj wszystkich: ");

        System.out.println("\t 201 --- Wyprintuj Studentów");
        System.out.println("\t 202 --- Wyprintuj Pracowników");
        System.out.println("\t 203 --- Wyprintuj Kursy");
        System.out.println("\t 204 --- Wyprintuj Osoby");
        System.out.println("Wyszukaj:");
        System.out.println("\t 301 --- Wyszukaj Studenta");
        System.out.println("\t 302 --- Wyszukaj Pracownika");
        System.out.println("\t 303 --- Wyszukaj Kurs");
        System.out.println("Usun: (Uwazaj)");
        System.out.println("\t 401 --- Usun Studenta");
        System.out.println("\t 402 --- Usun Pracownika");
        System.out.println("\t 403 --- Usun Kurs");
        System.out.println("Daj podwyżkę: ");
        System.out.println("\t 501 --- Daj podwyżkę Pracownikowi");

    }

    @Override
    public void Graj() {
        Dane.odczytaj();

        boolean GameLoop = true;

        while(GameLoop){
            WypiszMenu();

            int wybor = scan.nextInt();

            switch (wybor) {
                case 101:
                    Dane.Add(Dane.Create(1));


                    break;
                case 102:
                    Dane.Add(Dane.Create(2));


                    break;
                case 103:
                    Dane.Add(Dane.Create(3));


                    break;
                case 104:
                    Dane.Add(Dane.Create(4));

                    break;


                case 201:
                    Dane.Wyprintuj(Dane.getStudenci());


                    break;
                case 202:
                    Dane.Wyprintuj(Dane.getPracownicy());
                    break;


                case 203:
                    System.out.println("Podaj Kryterium sortowania: ");
                    System.out.println("\t 1 --- ECTS+/Nazwisko+");
                    System.out.println("\t 2 --- Brak");
                    SortujKursy();
                    Dane.Wyprintuj(Dane.getKursy());
                    break;
                case 204:
                    System.out.println("Podaj kryterium sortowania: ");
                    System.out.println("\t 1 --- Nazwisko+");
                    System.out.println("\t 2 --- Nazwisko+/Imie+");
                    System.out.println("\t 3 --- Nazwisko+/Wiek-");
                    System.out.println("\t 4 --- Brak");

                    SortujOsoby();
                    Dane.Wyprintuj(Dane.getOsoby());
                    break;


                case 301:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<Student> szukaniS = Wyszukaj(scan.next(),1);
                    Dane.Wyprintuj(szukaniS);
                    if(szukaniS.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 302:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<PracownikUczelni> szukaniP = Wyszukaj(scan.next(),2);
                    Dane.Wyprintuj(szukaniP);
                    if(szukaniP.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 303:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<Kurs> szukaniK = Wyszukaj(scan.next(),3);
                    Dane.Wyprintuj(szukaniK);
                    if(szukaniK.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 401:
                    Usun(scan.next(),1);




                    break;
                case 402:
                    Usun(scan.next(),2);






                    break;
                case 403:
                    Usun(scan.next(),3);

                    break;
                case 501:

                    System.out.println("W jaki sposób chcesz dać podwyżkę?");
                    System.out.println("\t 1 --- Procentowo");
                    System.out.println("\t 2 --- Stale");
                    DajPodwyzke();
                    break;



                default:
                    System.out.println("Coś poszło nie tak......., wpisz dobre wartości");


            }

            System.out.println("\n\nCo chcesz dalej robić? \n" +"\t1 --- Wróć do Menu" + "\n\t2 --- Zakończ Program");
            int decyzja = scan.nextInt();
            if (decyzja==2){
                GameLoop=false;
                Dane.zapisz();
            }





        }
    }




    //Gettery


    public Uczelnia getDane() {
        return Dane;
    }

    public void setDane(Uczelnia dane) {
        Dane = dane;
    }

    public Scanner getScan() {
        return scan;
    }

    public void setScan(Scanner scan) {
        this.scan = scan;
    }

    public ArrayList<Osoba> getOsoby() {
        return Osoby;
    }

    public void setOsoby(ArrayList<Osoba> osoby) {
        Osoby = osoby;
    }

    public ArrayList<Kurs> getKursy() {
        return Kursy;
    }

    public void setKursy(ArrayList<Kurs> kursy) {
        Kursy = kursy;
    }



    public Wyszukaj getSearch() {
        return search;
    }

    public void setSearch(Wyszukaj search) {
        this.search = search;
    }

    public Usun getDelete() {
        return delete;
    }

    public void setDelete(Usun delete) {
        this.delete = delete;
    }

    public PodwyzkaTerminal getRaiseInter() {
        return RaiseInter;
    }

    public void setRaiseInter(PodwyzkaTerminal raiseInter) {
        RaiseInter = raiseInter;
    }
}

import Komparatory.KomparatorECTSNazwisko;
import Komparatory.KomparatorNazwisko;
import Komparatory.KomparatorNazwiskoImie;
import Komparatory.KomparatorNazwiskoWiek;
import SkladoweUczelni.*;
import Strategia.PodwyzkaInterface;

import java.util.*;


public class InferfejsUzytkownika {
    private Uczelnia Dane;
    private Scanner scan = new Scanner(System.in);
    protected PodwyzkaInterface RaiseInter;
    protected Comparator<Osoba> kompOsoba;



    //Constructor
    public InferfejsUzytkownika(Uczelnia dane){
        Dane = dane;
    }

    //Settery i Gettery

    public Uczelnia getDane() {
        return Dane;
    }

    public void setDane(Uczelnia dane) {
        Dane = dane;
    }


    public void Menu(){
        System.out.println("--------------MENU--------------\n");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("Dopisz: ");
        System.out.println("\t 101 --- Dopisz Studenta" );
        System.out.println("\t 102 --- Dopisz Pracownika Administracji");
        System.out.println("\t 103 --- Dopisz Pracownika Badawczo-Dydaktycznego");
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

    public void Graj(){



        Dane.odczytaj();

        boolean GameLoop = true;

        while(GameLoop){
            Menu();

            int wybor = scan.nextInt();

            switch (wybor) {
                case 101:
                    Dane.DodajStudenta(StworzStudenta());


                    break;
                case 102:
                    Dane.DodajPracownikaA(StworzPracownikaA());


                    break;
                case 103:
                    Dane.DodajPracownikaBD(StworzPracownikaBD());


                    break;
                case 104:
                    Dane.DodajKurs(StworzKurs());

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
//                    int sortKursswitch = scan.nextInt();
//                    switch (sortKursswitch){
//                        case 1:
//                            Collections.sort(Dane.getKursy(),new KomparatorECTSNazwisko());
//                            break;
//                        case 2:
//                            break;
//                        default:
//                            System.out.println("Coś poszło nie tak, (sortowanie kursy)");
//
//                    }
                    Dane.SortujKursy();
                    Dane.Wyprintuj(Dane.getKursy());
                    break;
                case 204:
                    System.out.println("Podaj kryterium sortowania: ");
                    System.out.println("\t 1 --- Nazwisko+");
                    System.out.println("\t 2 --- Nazwisko+/Imie+");
                    System.out.println("\t 3 --- Nazwisko+/Wiek-");
                    System.out.println("\t 4 --- Brak");
//                    int sortOsobaswitch = scan.nextInt();
//                    switch (sortOsobaswitch){
//                        case 1:
//                            kompOsoba = new KomparatorNazwisko();
//                            break;
//                        case 2:
//                            kompOsoba = new KomparatorNazwiskoImie();
//                            break;
//                        case 3:
//                            kompOsoba = new KomparatorNazwiskoWiek();
//                         break;
//                        case 4:
//                        break;
//                        default:
//                            System.out.println("Coś poszło nietak, (sortowanie)");
//                    }
//                    Collections.sort(Dane.getOsoby(),kompOsoba);
                    Dane.SortujOsoby();
                    Dane.Wyprintuj(Dane.getOsoby());
                    break;


                case 301:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<Student> szukaniS = Dane.WyszukajStudenta(scan.next());
                    Dane.Wyprintuj(szukaniS);
                    if(szukaniS.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 302:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<PracownikUczelni> szukaniP = Dane.WyszukajPracownika(scan.next());
                    Dane.Wyprintuj(szukaniP);
                    if(szukaniP.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 303:
                    System.out.println("Wpisz szukane: ");
                    ArrayList<Kurs> szukaniK = Dane.WyszukajKurs(scan.next());
                    Dane.Wyprintuj(szukaniK);
                    if(szukaniK.isEmpty()){
                        System.out.println("Brak");

                    }
                    break;
                case 401:
                    Dane.UsunStudenta();
                    //                    System.out.println("Wpisz szukane: ");
//                    ArrayList<Student> UsuwaniS = Dane.WyszukajStudenta(scan.next());
//                    System.out.println("Usunąłeś poniższych studentów: ");
//                    Dane.Wyprintuj(UsuwaniS);
//                    if(UsuwaniS.isEmpty()){
//                        System.out.println("Brak");
//                    }
//                    Dane.getOsoby().removeAll(UsuwaniS);
//                    Dane.setOsoby(Dane.getOsoby());
//                    Dane.getStudenci().removeAll(UsuwaniS);
//                    Dane.setStudenci(Dane.getStudenci());



                    break;
                case 402:
                    Dane.UsunPracownika();
                    //                    System.out.println("Wpisz szukane: ");
//                    ArrayList<PracownikUczelni> UsuwaniP = Dane.WyszukajPracownika(scan.next());
//                    System.out.println("Usunąłeś poniższych pracowników: ");
//                    Dane.Wyprintuj(UsuwaniP);
//                    if(UsuwaniP.isEmpty()){
//                        System.out.println("Brak");
//                    }
//                    Dane.getOsoby().removeAll(UsuwaniP);
//                    Dane.setOsoby(Dane.getOsoby());
//                    Dane.getPracownicy().removeAll(UsuwaniP);
//                    Dane.setPracownicy(Dane.getPracownicy());
//
//                    ArrayList<Kurs> UsuwaneKursy= new ArrayList<Kurs>();
//                    for (int i = 0; i <UsuwaniP.size() ; i++) {
//                        for (int j = 0; j <Dane.getKursy().size() ; j++) {
//                            if (Objects.equals(UsuwaniP.get(i), Dane.getKursy().get(j).getProwadzacy())){
//                                UsuwaneKursy.add(Dane.getKursy().get(j));
//                            }
//
//
//                        }
//
//                    }
//                    Dane.getKursy().removeAll(UsuwaneKursy);
//                    Dane.setKursy(Dane.getKursy());
//                    for (int i = 0; i <Dane.getStudenci().size() ; i++) {
//                        Student obecnyStudent = Dane.getStudenci().get(i);
//                        obecnyStudent.getListaKursow().removeAll(UsuwaneKursy);
//                        obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());
//
//
//
//
//                    }




                    break;
                case 403:
                    Dane.UsunKurs();
//                    System.out.println("Wpisz szukane: ");
//                    ArrayList<Kurs> UsuwaniK = Dane.WyszukajKurs(scan.next());
//                    System.out.println("Usunąłeś poniższe kursy: ");
//                    Dane.Wyprintuj(UsuwaniK);
//                    if(UsuwaniK.isEmpty()){
//                        System.out.println("Brak");
//                    }
//
//                    Dane.getKursy().removeAll(UsuwaniK);
//                    Dane.setKursy(Dane.getKursy());
//
//
//                    for (int i = 0; i <Dane.getStudenci().size() ; i++) {
//                        Student obecnyStudent = Dane.getStudenci().get(i);
//                        obecnyStudent.getListaKursow().removeAll(UsuwaniK);
//                        obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());
//                    }
                    break;
                case 501:

                    System.out.println("W jaki sposób chcesz dać podwyżkę?");
                    System.out.println("\t 1 --- Procentowo");
                    System.out.println("\t 2 --- Stale");
                    Dane.DajPodwyzke();
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
    public PracownikBD StworzPracownikaBD() {
        System.out.println("ID: ");
        int ID = scan.nextInt();
        while (Dane.getPracownicyID().contains(ID)) {
            System.out.println("Podaj unikatowe ID");
            ID = scan.nextInt();
        }
        System.out.println("Imie: ");
        String imie = scan.next();
        System.out.println("Nazwisko: ");
        String nazwisko = scan.next();
        System.out.println("PESEL: ");
        String PESEL = scan.next();
        System.out.println("Wiek: ");
        int wiek = scan.nextInt();
        System.out.println("Plec: ");
        String plec = scan.next();
        System.out.println("Stanowisko: (Asystent, Adiunkt, ProfesorNadzwyczajny, ProfesorZwyczajny, Wykladowca)");
        String stanowisko = scan.next();

        while (!Dane.getStanowiskaBD().contains(stanowisko)) {
            System.out.println("Wprowadz poprawne stanowisko");
            stanowisko = scan.next();
        }
        System.out.println("StazPracy (double): ");;
        double stazPracy = scan.nextDouble();
        System.out.println("Pensja (double): ");;
        double pensja = scan.nextDouble();
        System.out.println("Liczba Publikacji: ");
        int liczbaPublikacji= scan.nextInt();
        return new PracownikBD(ID,imie,  nazwisko,  PESEL, wiek, plec, stanowisko,  stazPracy,  pensja,  liczbaPublikacji);


        }
    public PracownikA StworzPracownikaA(){
        System.out.println("ID: ");
        int ID = scan.nextInt();
        while (Dane.getPracownicyID().contains(ID)) {
            System.out.println("Podaj unikatowe ID");
            ID = scan.nextInt();
        }
        System.out.println("Imie: ");
        String imie = scan.next();
        System.out.println("Nazwisko: ");
        String nazwisko = scan.next();
        System.out.println("PESEL: ");
        String PESEL = scan.next();
        System.out.println("Wiek: ");
        int wiek = scan.nextInt();
        System.out.println("Plec: ");
        String plec = scan.next();
        System.out.println("Stanowisko: (Referent, Specjalista, StarszySpecjalista)");
        String stanowisko = scan.next();

        while (!Dane.getStanowiskaA().contains(stanowisko)) {
            System.out.println("Wprowadz poprawne stanowisko");
            stanowisko = scan.next();
        }
        System.out.println("StazPracy (double): ");;
        double stazPracy = scan.nextDouble();
        System.out.println("Pensja (double): ");;
        double pensja = scan.nextDouble();
        System.out.println("Liczba Nadgodzin: ");
        int liczbaNadgodzin= scan.nextInt();
        return new PracownikA(ID,imie,  nazwisko,  PESEL, wiek, plec, stanowisko,  stazPracy,  pensja,  liczbaNadgodzin);





    }
    public Kurs StworzKurs(){
        System.out.println("ID: ");
        int ID = scan.nextInt();
        if(!Dane.getKursyID().contains(ID)){
            System.out.println("Nazwa Kursu:");
            String nazwaKursu = scan.next();
            System.out.println("Co chcesz zrobić?");
            System.out.println("\t"+"1 --- Stwórz teraz prowadzącego");
            System.out.println("\t"+"2 --- Podepnij Istniejącego Pracownika");
            PracownikBD Prowadzacy=null;
            int wybor = scan.nextInt();
            switch(wybor){
                case 1:
                    Prowadzacy = StworzPracownikaBD();
                    while(Prowadzacy==null){
                        System.out.println("Wprowadź unikatowe ID");

                        Prowadzacy = StworzPracownikaBD(); //do skutku
                    }

                    Dane.DodajPracownikaBD(Prowadzacy);
                    break;
                case 2:
                    Dane.Wyprintuj(Dane.getPracownicy());
                    System.out.println("Wprowadź ID prowadzącego:");
                    String IDPro=scan.next();
                    try{
                        Prowadzacy = ((PracownikBD) Dane.WyszukajPracownikaID(IDPro));

                    } catch (Exception e){
                        System.out.println("Nie ma prowadzącego o takim ID");
                    }

                    break;
                default:
                    System.out.println("Coś poszło nie tak.... (wyszukiwanie prowadzacego)");


            }



            System.out.println();

            System.out.println("ECTS: ");
            int ECTS = scan.nextInt();


            return new Kurs(ID,nazwaKursu,Prowadzacy,ECTS);
        } else{
            System.out.println("Istnieje kurs o takim ID (" + ID+")");
            System.out.println((Dane.WyszukajKursID(String.valueOf(ID))));
            return null;
        }



    }
    public  Student StworzStudenta(){
        System.out.println("ID: ");
        int ID = scan.nextInt();
        if(!Dane.getStudenciID().contains(ID)){
            System.out.println("Imie: ");
            String imie = scan.next();
            System.out.println("Nazwisko: ");
            String nazwisko = scan.next();;
            System.out.println("PESEL: ");
            String PESEL= scan.next();;
            System.out.println("Wiek: ");
            int wiek = scan.nextInt();;
            System.out.println("Plec: ");
            String plec = scan.next();;
            System.out.println("Index");
            int index = scan.nextInt();
            System.out.println("rok");
            int rok =scan.nextInt();

            System.out.println("Tworzysz liste kursow. Podaj liczbę kursów: ");
            int wybor = scan.nextInt();
            ArrayList<Kurs> listaKursow = new ArrayList<Kurs>();
            for (int i = 0; i <wybor ; i++) {
                System.out.println("Co chcesz zrobić? " + "Kurs: "+(i+1));
                System.out.println("\t1 --- Stworz Kurs");
                System.out.println("\t2 --- Podepnij Istniejący Kurs");
                int wybor1 = scan.nextInt();
                switch (wybor1){
                    case 1:
                        System.out.println("Tworzysz Kurs: " + (i+1));
                        Kurs obecnykurs = StworzKurs();
                        while(obecnykurs==null){
                            System.out.println("Wprowadź unikatowe ID");

                            obecnykurs = StworzKurs(); //do skutku
                        }
                        listaKursow.add(obecnykurs);
                        Dane.DodajKurs(obecnykurs);
                        break;
                    case 2:
                        Dane.Wyprintuj(Dane.getKursy());
                        System.out.println();
                        System.out.println("Podpinasz Kurs: " +(i+1));
                        System.out.println("Wprowadz ID Kursu");
                        String IDKur = scan.next();

                        try {
                            listaKursow.add(Dane.WyszukajKursID(IDKur));
                        } catch (Exception e){
                            System.out.println("Nie ma kursu o takim ID");
                        }
                        break;
                    default:
                        System.out.println("cos poszlo nie tak....(wyszukiwanie kursu)");


                }



            }

            System.out.println("CzyErasmus");
            boolean czyErasmus = scan.nextBoolean();
            System.out.println("czyIstopien");
            boolean czyPierwszyStopien =scan.nextBoolean();
            System.out.println("czy2Stopien");
            boolean czyDrugiStopien = scan.nextBoolean();
            System.out.println("CzyStacjo");
            boolean czyStacjonarne = scan.nextBoolean();
            System.out.println("CzyNIestacjo");
            boolean czyNiestacjonarne = scan.nextBoolean();

            return new Student(ID,imie, nazwisko, PESEL, wiek, plec, index, rok, listaKursow, czyErasmus, czyPierwszyStopien, czyDrugiStopien, czyStacjonarne, czyNiestacjonarne);


        } else{
            System.out.println("Istnieje takie ID studenta ("+  ID+")");
            Dane.Wyprintuj(Dane.WyszukajStudenta(String.valueOf(ID)));
            return null;
        }




    }



}

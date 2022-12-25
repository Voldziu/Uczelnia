package Strategia.Creation;

import Observable.Uczelnia;
import Observers.ObslugaUczelni;
import SkladoweUczelni.Creation;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class CreateStudent implements CreationInterface {
    Scanner scan = new Scanner(System.in);
    @Override
    public Creation create(Uczelnia Dane) {
        System.out.println("ID: ");
        int ID = scan.nextInt();
        while(Dane.getStudenciID().contains(ID)){
            System.out.println("Podaj unikatowe ID");
            ID = scan.nextInt();
        }
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

                        Kurs obecnykurs = new CreateKurs().create(Dane);
                        while(obecnykurs==null){
                            System.out.println("Wprowadź unikatowe ID");

                            obecnykurs = new CreateKurs().create(Dane); //do skutku
                        }
                        listaKursow.add(obecnykurs);
                        Dane.Add(obecnykurs);
                        break;
                    case 2:
                        Dane.Wyprintuj(Dane.getKursy());
                        System.out.println();
                        System.out.println("Podpinasz Kurs: " +(i+1));
                        System.out.println("Wprowadz ID Kursu");
                        String IDKur = scan.next();

                        try {
                          //  Dane.getObserverList().get(0).Wyszukaj.........
                            listaKursow.add((Kurs)((ObslugaUczelni)Dane.getObserverList().get(0)).WyszukajID(IDKur,3)); //Dodac w funkcjonalnosci Obserwatora
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











    }
}

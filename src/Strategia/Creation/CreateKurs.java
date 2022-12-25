package Strategia.Creation;

import Observers.ObslugaUczelni;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.PracownikBD;
import Observable.*;
import Strategia.Creation.CreatePracownikBD;
import Strategia.Creation.CreationInterface;

import java.util.Scanner;

public class CreateKurs implements CreationInterface {
    private Scanner scan = new Scanner(System.in);
    @Override
    public Kurs create(Uczelnia Dane) {
        System.out.println("ID: ");
        int ID = scan.nextInt();
        while(Dane.getKursyID().contains(ID)){
            System.out.println("Podaj unikatowe ID");
            ID = scan.nextInt();

        }

            System.out.println("Nazwa Kursu:");
            String nazwaKursu = scan.next();
            System.out.println("Co chcesz zrobić?");
            System.out.println("\t"+"1 --- Stwórz teraz prowadzącego");
            System.out.println("\t"+"2 --- Podepnij Istniejącego Pracownika");
            PracownikBD Prowadzacy=null;
            int wybor = scan.nextInt();
            switch(wybor){
                case 1:
                    Prowadzacy = new CreatePracownikBD().create(Dane);
                    while(Prowadzacy==null){
                        System.out.println("Wprowadź unikatowe ID");

                        Prowadzacy = new CreatePracownikBD().create(Dane); //do skutku
                    }

                    Dane.Add(Prowadzacy);
                    break;
                case 2:
                    Dane.Wyprintuj(Dane.getPracownicy());
                    System.out.println("Wprowadź ID prowadzącego:");
                    String IDPro=scan.next();
                    try{

                        // Wyszukiwanie od obserwatora
                        Prowadzacy = (PracownikBD) ((ObslugaUczelni)Dane.getObserverList().get(0)).WyszukajID(IDPro,2);

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

        }


    }


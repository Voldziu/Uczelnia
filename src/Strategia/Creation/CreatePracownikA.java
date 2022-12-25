package Strategia.Creation;

import SkladoweUczelni.PracownikA;
import Observable.*;
import Strategia.Creation.CreationInterface;

import java.util.Scanner;

public class CreatePracownikA implements CreationInterface {
    private Scanner scan = new Scanner(System.in);
    public PracownikA create(Uczelnia Dane){
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
}

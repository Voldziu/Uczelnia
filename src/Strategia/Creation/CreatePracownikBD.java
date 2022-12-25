package Strategia.Creation;

import SkladoweUczelni.PracownikBD;
import Observable.*;
import Strategia.Creation.CreationInterface;

import java.util.Scanner;

public class CreatePracownikBD implements CreationInterface {
    private Scanner scan = new Scanner(System.in);
    @Override
    public  PracownikBD create(Uczelnia Dane) {
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
}

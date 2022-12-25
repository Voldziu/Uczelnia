package Strategia.Usun;

import Strategia.Wyszukaj.WyszukajStudenta;
import Observable.Uczelnia;
import SkladoweUczelni.Student;

import java.util.ArrayList;

public class UsunStudenta implements Usun {
    @Override
    public void Usun(String InPut, Uczelnia dane ) {
        System.out.println("Wpisz szukane: ");
        ArrayList<Student> UsuwaniS = new WyszukajStudenta().Wyszukaj(InPut,dane);
        System.out.println("Usunąłeś poniższych studentów: ");
        dane.Wyprintuj(UsuwaniS);
        if(UsuwaniS.isEmpty()){
            System.out.println("Brak");
        }
        dane.getOsoby().removeAll(UsuwaniS);
        dane.setOsoby(dane.getOsoby());
        dane.getStudenci().removeAll(UsuwaniS);
        dane.setStudenci(dane.getStudenci());

    }
}

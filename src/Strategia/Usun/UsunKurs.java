package Strategia.Usun;

import Strategia.Wyszukaj.WyszukajKurs;
import Observable.Uczelnia;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.Student;

import java.util.ArrayList;

public class UsunKurs implements Usun {
    @Override
    public void Usun(String InPut, Uczelnia dane) {
        System.out.println("Wpisz szukane: ");
        ArrayList<Kurs> UsuwaniK = new WyszukajKurs().Wyszukaj(InPut,dane);
        System.out.println("Usunąłeś poniższe kursy: ");
        dane.Wyprintuj(UsuwaniK);
        if(UsuwaniK.isEmpty()){
            System.out.println("Brak");
        }
        dane.getKursy().removeAll(UsuwaniK);
        dane.setKursy(dane.getKursy());


        for (int i = 0; i <dane.getStudenci().size() ; i++) {
            Student obecnyStudent = dane.getStudenci().get(i);
            obecnyStudent.getListaKursow().removeAll(UsuwaniK);
            obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());
        }
    }
}

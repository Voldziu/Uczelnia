package Strategia.Wyszukaj;

import Observable.Uczelnia;
import SkladoweUczelni.Kurs;
import Strategia.Wyszukaj.Wyszukaj;

import java.util.ArrayList;

public class WyszukajKurs implements Wyszukaj {
    @Override
    public ArrayList<Kurs> Wyszukaj(String InPut, Uczelnia dane) {
        ArrayList<Kurs> Wyszukane = new ArrayList<Kurs>();
        for (int i = 0; i< dane.getKursy().size() ; i++) {
            Kurs obecnyKurs = dane.getKursy().get(i);
            if( InPut.equals(String.valueOf(obecnyKurs.getECTS())) || InPut.equals(obecnyKurs.getNazwaKursu()) || InPut.equals(obecnyKurs.getProwadzacy().getNazwisko()) ||  InPut.equals(obecnyKurs.getProwadzacy().getImie()) ){
                Wyszukane.add(obecnyKurs);
            }
        } return Wyszukane;

    }
}

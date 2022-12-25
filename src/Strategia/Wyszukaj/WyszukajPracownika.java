package Strategia.Wyszukaj;

import Observable.Uczelnia;
import SkladoweUczelni.PracownikA;
import SkladoweUczelni.PracownikBD;
import SkladoweUczelni.PracownikUczelni;
import Strategia.Wyszukaj.Wyszukaj;

import java.util.ArrayList;

public class WyszukajPracownika implements Wyszukaj {
    @Override
    public ArrayList<PracownikUczelni> Wyszukaj(String InPut, Uczelnia dane) {
        ArrayList<PracownikUczelni> Wyszukani = new ArrayList<PracownikUczelni>();
        for (int i = 0; i <dane.getPracownicy().size() ; i++) {
            PracownikUczelni obecnyPracownik = dane.getPracownicy().get(i);

            if( InPut.equals(obecnyPracownik.getNazwisko()) || InPut.equals(obecnyPracownik.getImie())|| InPut.equals(obecnyPracownik.getStanowisko()) || (InPut.equals(String.valueOf(obecnyPracownik.getStazPracy())))  ||  (InPut.equals(String.valueOf(obecnyPracownik.getPensja())))){
                Wyszukani.add(obecnyPracownik);




            } else if(obecnyPracownik instanceof PracownikBD && (InPut.equals(String.valueOf(((PracownikBD)obecnyPracownik).getLiczbaPublikacji()))) ) {
                Wyszukani.add((PracownikBD)obecnyPracownik);

            } else if (obecnyPracownik instanceof PracownikA && (InPut.equals(String.valueOf(((PracownikA)obecnyPracownik).getLiczbaNadgodzin())))) {
                Wyszukani.add((PracownikA)obecnyPracownik);

            }

        }
        return Wyszukani;
    }
}

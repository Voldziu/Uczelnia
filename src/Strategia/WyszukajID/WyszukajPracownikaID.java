package Strategia.WyszukajID;


import Observable.Uczelnia;
import SkladoweUczelni.*;
import Strategia.WyszukajID.WyszukajID;

public class WyszukajPracownikaID implements WyszukajID {
    @Override
    public PracownikUczelni WyszukajID(String InPut, Uczelnia dane) {
        PracownikUczelni szukany;
        PracownikUczelni wynik=null;
        for (int i = 0; i <dane.getPracownicy().size() ; i++) {
            szukany = dane.getPracownicy().get(i);
            if (String.valueOf(szukany.getID()).equals(InPut)){
                wynik= szukany;


            }

        }  return wynik;

    }
}

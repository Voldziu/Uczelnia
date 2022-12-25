package Strategia.WyszukajID;

import Observable.Uczelnia;
import SkladoweUczelni.Kurs;
import Strategia.WyszukajID.WyszukajID;

public class WyszukajKursID implements WyszukajID {
    @Override
    public Kurs WyszukajID(String InPut, Uczelnia dane) {
        Kurs szukany;
        for (int i = 0; i <dane.getKursy().size() ; i++) {
            szukany = dane.getKursy().get(i);
            if (String.valueOf(szukany.getID()).equals(InPut)){
                return szukany;
            }

        }  return null;
    }
}

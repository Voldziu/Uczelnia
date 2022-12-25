package Strategia.Komparatory;

import SkladoweUczelni.Osoba;

import java.util.Comparator;

public class KomparatorNazwiskoWiek implements Comparator<Osoba> {
    public int compare(Osoba o1, Osoba o2){
        int result = o1.getNazwisko().compareTo(o2.getNazwisko());
        if(result==0){
            result = o2.getWiek() - o1.getWiek();
            return result;
        }
        return result;
    }

}

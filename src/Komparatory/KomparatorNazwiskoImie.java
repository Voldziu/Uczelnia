package Komparatory;

import SkladoweUczelni.Osoba;

import java.util.Comparator;

public class KomparatorNazwiskoImie implements Comparator<Osoba> {
    public int compare(Osoba o1, Osoba o2){
        int result = o1.getNazwisko().compareTo(o2.getNazwisko());
        if(result==0){
            result = o1.getImie().compareTo(o2.getImie());
            return result;
        }
        return result;
    }
}

package Strategia.Komparatory;
import SkladoweUczelni.*;


import java.util.Comparator;

public class KomparatorNazwisko implements Comparator<Osoba> {
    public int compare(Osoba o1, Osoba o2){
        int result = o1.getNazwisko().compareTo(o2.getNazwisko());
        return  result;
    }

}

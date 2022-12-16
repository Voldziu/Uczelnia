package Komparatory;

import SkladoweUczelni.Kurs;

import java.util.Comparator;

public class KomparatorECTSNazwisko implements Comparator<Kurs> {
    public int compare(Kurs k1, Kurs k2){
        int result = k1.getECTS()-k2.getECTS();
        if (result==0){
            result = k1.getProwadzacy().getNazwisko().compareTo(k2.getProwadzacy().getNazwisko());
            return  result;
        }

        return  result;

    }
}

package Strategia.Usun;

import SkladoweUczelni.Osoba;
import Strategia.Wyszukaj.WyszukajPracownika;
import Observable.Uczelnia;
import SkladoweUczelni.Kurs;
import SkladoweUczelni.PracownikUczelni;
import SkladoweUczelni.Student;

import java.util.ArrayList;
import java.util.Objects;

public class UsunPracownika implements Usun {
    @Override
    public void Usun(String InPut, Uczelnia dane) {
        System.out.println("Wpisz szukane: ");
        ArrayList<PracownikUczelni> UsuwaniP = new WyszukajPracownika().Wyszukaj(InPut,dane);



        System.out.println("Usunąłeś poniższych pracowników: ");
        dane.Wyprintuj(UsuwaniP);

        if(UsuwaniP.isEmpty()){
            System.out.println("Brak");
        }
        dane.getOsoby().removeAll(UsuwaniP);
        dane.setOsoby(dane.getOsoby());
        dane.getPracownicy().removeAll(UsuwaniP);
        dane.setPracownicy(dane.getPracownicy());

        ArrayList<Kurs> UsuwaneKursy = new ArrayList<Kurs>();
        for (int i = 0; i < UsuwaniP.size() ; i++) {
            for (int j = 0; j <dane.getKursy().size() ; j++) {
                if(Objects.equals(UsuwaniP.get(i),dane.getKursy().get(j).getProwadzacy())){
                    UsuwaneKursy.add(dane.getKursy().get(j));
                }

            }

        }
        dane.getKursy().removeAll(UsuwaneKursy);
        dane.setKursy(dane.getKursy());
        for (int i = 0; i <dane.getStudenci().size() ; i++) {
            Student obecnyStudent = dane.getStudenci().get(i);
            obecnyStudent.getListaKursow().removeAll(UsuwaneKursy);
            obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());

        }
    }
}

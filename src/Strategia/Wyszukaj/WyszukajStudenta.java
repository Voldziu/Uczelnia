package Strategia.Wyszukaj;

import Observable.Uczelnia;
import SkladoweUczelni.Student;
import Strategia.Wyszukaj.Wyszukaj;

import java.util.ArrayList;

public class WyszukajStudenta implements Wyszukaj {
    @Override
    public ArrayList<Student> Wyszukaj(String InPut, Uczelnia dane) {
        ArrayList<Student> Wyszukani = new ArrayList<Student>();
        for (int i = 0; i <dane.getStudenci().size(); i++) {
            Student obecnyStudent = dane.getStudenci().get(i);
            if ( InPut.equals(obecnyStudent.getNazwisko())  ||  InPut.equals(obecnyStudent.getImie())  ||  InPut.equals(String.valueOf(obecnyStudent.getIndex()))  ||  InPut.equals(String.valueOf(obecnyStudent.getRok()))){
                Wyszukani.add(obecnyStudent);
            } else  {
                for (int j = 0; j <obecnyStudent.getListaKursow().size() ; j++) {
                    if(InPut.equals(obecnyStudent.getListaKursow().get(j).getNazwaKursu())) {
                        Wyszukani.add(obecnyStudent);
                    }


                }

            }

        } return Wyszukani;
    }
}

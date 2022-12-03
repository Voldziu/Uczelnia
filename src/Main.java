import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {




    public static void main(String[] args) {
        PracownikUczelni Michalik = new PracownikBD("K","Michalik","31312",11,"chuj","dupa",11.1f,3131,3);
        PracownikUczelni Bielik = new PracownikA("Anna","Bielik","321312",55,"Kobieta","Nie wiem",15.1f,5555,13);
        PracownikUczelni Bogus = new PracownikBD("Bogusław","Merdzinski","3123123",66,"M","Wysokie",30,10000,10);


        ArrayList<PracownikUczelni> Pracownicy = new ArrayList<PracownikUczelni>();
        Pracownicy.add(Michalik);
        Pracownicy.add(Bielik);
        Pracownicy.add(Bogus);




        ArrayList<Kurs> Kursy = new ArrayList<Kurs>();
        Kurs Algebra = new Kurs("Algebra",Michalik,5);
        Kurs Analiza = new Kurs("Analiza",Michalik,10);
        Kurs Geometria = new Kurs("Geometria",Bogus,5);

        Kursy.add(Algebra);
        Kursy.add(Analiza);
        Kursy.add(Geometria);

//        ArrayList<Kurs> KursyMacka = new ArrayList<Kurs>();
//        KursyMacka.add(Analiza);
//        KursyMacka.add(Algebra)

        ArrayList<Student> Studenci = new ArrayList<Student>();
        Student Maciek = new Student("Maciek","Dudziak","31321",19,"M",242422,2,new ArrayList<Kurs>(Arrays.asList(Analiza,Algebra)),false,true,false,true,false);
        Studenci.add(Maciek);

        Uczelnia Pwr = new Uczelnia(Kursy,Studenci,Pracownicy);

        Pwr.Wyprintuj(Pwr.WyszukajKurs("Michalik"));
        Pwr.Wyprintuj(Pwr.WyszukajStudenta("Analiza"));


    }
}
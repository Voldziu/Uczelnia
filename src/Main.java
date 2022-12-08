import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) {

        //Tworzenie Pracownikow


        PracownikUczelni Michalik = new PracownikBD("K","Michalik","31312",11,"M","Nie wiem",11.1f,3131,3);
        PracownikUczelni Bielik = new PracownikA("Anna","Bielik","321312",55,"Kobieta","Nie wiem",15.1f,5555,13);
        PracownikUczelni Bogus = new PracownikBD("Bogusław","Merdzinski","3123123",66,"M","Wysokie",30,10000,10);


        ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
        Osoby.add(Michalik);
        Osoby.add(Bielik);
        Osoby.add(Bogus);


        //Tworzenie kursów

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

        //Tworzenie studentów


        Student Maciek = new Student("Maciek","Dudziak","31321",19,"M",242422,2,new ArrayList<Kurs>(Arrays.asList(Analiza,Algebra)),false,true,false,true,false);
        Osoby.add(Maciek);









        Uczelnia Pwr = new Uczelnia(Kursy,Osoby);

        Pwr.Wyprintuj(Pwr.WyszukajKurs("Michalik"));
        Pwr.Wyprintuj(Pwr.WyszukajStudenta("Analiza"));






    }
}
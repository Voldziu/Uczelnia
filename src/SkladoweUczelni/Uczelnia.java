package SkladoweUczelni;

import SkladoweUczelni.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Uczelnia {

    private  ArrayList<Kurs> Kursy = new ArrayList<Kurs>();
    private ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
    private ArrayList<Student> Studenci = new ArrayList<Student>();
    private  ArrayList<PracownikUczelni> Pracownicy = new ArrayList<PracownikUczelni>();
    private ArrayList<String> StanowiskaBD = new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykladowca"));
    private ArrayList<String> StanowiskaA = new ArrayList<>(Arrays.asList("Referent","Specjalista","StarszySpecjalista"));



    private static ArrayList<Osoba>  OsobyOdczyt= null;
    private  static  ArrayList<Kurs>  KursyOdczyt = null;



    public Uczelnia() {
        Kursy = new ArrayList<Kurs>();
        Osoby = new ArrayList<Osoba>();
        Studenci=GetStudenci();
        Pracownicy = GetPracownicy();
    }

    public ArrayList<PracownikUczelni> GetPracownicy(){
        ArrayList<PracownikUczelni> Pracownicy = new ArrayList<PracownikUczelni>();
        for (int i = 0; i <Osoby.size() ; i++) {
            Osoba obecnaOsoba = Osoby.get(i);
            if(obecnaOsoba instanceof PracownikUczelni){
                Pracownicy.add((PracownikUczelni) obecnaOsoba);
            }

        } return Pracownicy;
    }
    public ArrayList<Student> GetStudenci(){
        ArrayList<Student> Studenci = new ArrayList<Student>();
        for (int i = 0; i <Osoby.size(); i++) {
            Osoba obecnaOsoba = Osoby.get(i);
            if(obecnaOsoba instanceof Student){
                Studenci.add((Student) obecnaOsoba);
            }

        } return Studenci;
    }

    public ArrayList<PracownikUczelni> WyszukajPracownika(String InPut){
        ArrayList<PracownikUczelni> Wyszukani = new ArrayList<PracownikUczelni>();
        for (int i = 0; i <Pracownicy.size() ; i++) {
            PracownikUczelni obecnyPracownik = Pracownicy.get(i);

            if( InPut.equals(obecnyPracownik.getNazwisko()) || InPut.equals(obecnyPracownik.getImie())|| InPut.equals(obecnyPracownik.getStanowisko()) || (InPut.equals(String.valueOf(obecnyPracownik.getStazPracy())))  ||  (InPut.equals(String.valueOf(obecnyPracownik.getPensja())))){
                Wyszukani.add(obecnyPracownik);




        } else if(obecnyPracownik instanceof PracownikBD && (InPut.equals(String.valueOf(((PracownikBD)obecnyPracownik).getLiczbaPublikacji()))) ) {
                Wyszukani.add((PracownikBD)obecnyPracownik);

            } else if (obecnyPracownik instanceof PracownikA && (InPut.equals(String.valueOf(((PracownikA)obecnyPracownik).getLiczbaNadgodzin())))) {
                Wyszukani.add((PracownikA)obecnyPracownik);

            }

        }
        return Wyszukani;

        }
    public PracownikUczelni WyszukajPracownikaID(String InPut){
        PracownikUczelni szukany;
        PracownikUczelni wynik=null;
        for (int i = 0; i <Pracownicy.size() ; i++) {
            szukany = Pracownicy.get(i);
            if (String.valueOf(szukany.getID()).equals(InPut)){
                wynik= szukany;


            }

        }  return wynik;

    }

    public  ArrayList<Kurs> WyszukajKurs(String InPut){
        ArrayList<Kurs> Wyszukane = new ArrayList<Kurs>();
        for (int i = 0; i <Kursy.size() ; i++) {
            Kurs obecnyKurs = Kursy.get(i);
            if( InPut.equals(String.valueOf(obecnyKurs.getECTS())) || InPut.equals(obecnyKurs.getNazwaKursu()) || InPut.equals(obecnyKurs.getProwadzacy().getNazwisko()) ||  InPut.equals(obecnyKurs.getProwadzacy().getImie()) ){
                Wyszukane.add(obecnyKurs);
            }
        } return Wyszukane;
    }
    public Kurs WyszukajKursID(String InPut){
        Kurs szukany;
        for (int i = 0; i <Kursy.size() ; i++) {
            szukany = Kursy.get(i);
            if (String.valueOf(szukany.getID()).equals(InPut)){
                return szukany;
            }

        }  return null;

    }


    public  ArrayList<Student> WyszukajStudenta(String InPut){
        ArrayList<Student> Wyszukani = new ArrayList<Student>();
        for (int i = 0; i <Studenci.size(); i++) {
            Student obecnyStudent = Studenci.get(i);
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
    // Metoda ta będzie używana do usuwania


//    public  ArrayList<Student> WyszukajStudentaBezKursow(String InPut){
//        ArrayList<Student> Wyszukani = new ArrayList<Student>();
//        for (int i = 0; i <Studenci.size(); i++) {
//            Student obecnyStudent = Studenci.get(i);
//            if ( InPut.equals(obecnyStudent.getNazwisko())  ||  InPut.equals(obecnyStudent.getImie())  ||  InPut.equals(String.valueOf(obecnyStudent.getIndex()))  ||  InPut.equals(String.valueOf(obecnyStudent.getRok()))){
//                Wyszukani.add(obecnyStudent);
//            }
//
//        } return Wyszukani;
//    }
    public Student WyszukajStudentaID(String InPut){
        Student szukany;
        for (int i = 0; i <Studenci.size() ; i++) {
            szukany = Studenci.get(i);
            if (String.valueOf(szukany.getID()).equals(InPut)){
                return szukany;
            }

        }  return null;

    }
    public void DodajPracownikaBD(PracownikBD p){
       Osoby.add(p);
        setPracownicy(GetPracownicy());

    }
    public void DodajPracownikaA(PracownikA p){
        Osoby.add(p);
        setPracownicy(GetPracownicy());

    }
    public void DodajStudenta(Student s){
        Osoby.add(s);
        setStudenci(GetStudenci());




    }
    public void DodajKurs(Kurs k){
        Kursy.add(k);
        setKursy(Kursy);



    }

    public  void Wyprintuj(ArrayList Lista){
        for (int i = 0; i <Lista.size() ; i++) {
            System.out.println(Lista.get(i).toString());

        }




    }

    // ZAPISYWANIE

    public void zapiszPuste(){
        try (ObjectOutputStream zapisz = new ObjectOutputStream(new FileOutputStream("BazaDanych.ser"))){
            zapisz.writeObject(new ArrayList<Kurs>());
            zapisz.writeObject(new ArrayList<Osoba>());



        } catch (IOException e){
            e.printStackTrace();
        }


    }


    public void zapisz(){
        try (ObjectOutputStream zapisz = new ObjectOutputStream(new FileOutputStream("BazaDanych.ser"))){
            zapisz.writeObject(Kursy);
            zapisz.writeObject(Osoby);



        } catch (IOException e){
            e.printStackTrace();
        }


    }

    public  void odczytaj(){
        try(ObjectInputStream odczytaj = new ObjectInputStream(new FileInputStream("BazaDanych.ser"))){

            Object ob1 = odczytaj.readObject();
            Object ob2 = odczytaj.readObject();


            KursyOdczyt = (ArrayList<Kurs>) ob1;
            OsobyOdczyt = (ArrayList<Osoba>) ob2;

            setKursy(KursyOdczyt);
            setOsoby(OsobyOdczyt);
            setPracownicy(GetPracownicy());
            setStudenci(GetStudenci());

        } catch (IOException | ClassNotFoundException e){
            zapiszPuste();
        }

    }


    //GETTERY I SETTERY

    public ArrayList<Kurs> getKursy() {
        return Kursy;
    }

    public void setKursy(ArrayList<Kurs> kursy) {
        Kursy = kursy;
    }

    public ArrayList<Osoba> getOsoby() {
        return Osoby;
    }

    public void setOsoby(ArrayList<Osoba> osoby) {
        Osoby = osoby;
    }

    public ArrayList<Student> getStudenci() {
        return Studenci;
    }

    public void setStudenci(ArrayList<Student> studenci) {
        Studenci = studenci;
    }

    public ArrayList<PracownikUczelni> getPracownicy() {
        return Pracownicy;
    }

    public void setPracownicy(ArrayList<PracownikUczelni> pracownicy) {
        Pracownicy = pracownicy;
    }

    public ArrayList<String> getStanowiskaBD() {
        return StanowiskaBD;
    }

    public void setStanowiskaBD(ArrayList<String> stanowiskaBD) {
        StanowiskaBD = stanowiskaBD;
    }

    public ArrayList<String> getStanowiskaA() {
        return StanowiskaA;
    }

    public void setStanowiskaA(ArrayList<String> stanowiskaA) {
        StanowiskaA = stanowiskaA;
    }

    public ArrayList<Integer> getKursyID(){
        ArrayList<Integer> Lista = new ArrayList<Integer>();
        for (int i = 0; i <Kursy.size() ; i++) {
            Lista.add(Kursy.get(i).getID());


        } return Lista;
    }
    public ArrayList<Integer> getStudenciID(){
        ArrayList<Integer> Lista = new ArrayList<Integer>();
        for (int i = 0; i <Studenci.size() ; i++) {
            Lista.add(Studenci.get(i).getID());


        } return Lista;
    }
    public ArrayList<Integer> getPracownicyID(){
        ArrayList<Integer> Lista = new ArrayList<Integer>();
        for (int i = 0; i <Pracownicy.size() ; i++) {
            Lista.add(Pracownicy.get(i).getID());


        } return Lista;
    }

}

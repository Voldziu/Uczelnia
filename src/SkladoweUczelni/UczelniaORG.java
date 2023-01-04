package SkladoweUczelni;

import Strategia.Podwyzka.PodwyzkaTerminal;
import Strategia.Podwyzka.PodwyzkaTerminalSposob1;
import Strategia.Podwyzka.PodwyzkaTerminalSposob2;
import Strategia.Komparatory.KomparatorECTSNazwisko;
import Strategia.Komparatory.KomparatorNazwisko;
import Strategia.Komparatory.KomparatorNazwiskoImie;
import Strategia.Komparatory.KomparatorNazwiskoWiek;

import java.io.*;
import java.util.*;




//KLASA NIEUZYWANA





































































public class UczelniaORG {
    private Scanner scan = new Scanner(System.in);

    private  ArrayList<Kurs> Kursy = new ArrayList<Kurs>();
    private ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
    private ArrayList<Student> Studenci = new ArrayList<Student>();
    private  ArrayList<PracownikUczelni> Pracownicy = new ArrayList<PracownikUczelni>();
    private ArrayList<String> StanowiskaBD = new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykladowca"));
    private ArrayList<String> StanowiskaA = new ArrayList<>(Arrays.asList("Referent","Specjalista","StarszySpecjalista"));

    protected Comparator<Osoba> kompOsoba;
    protected PodwyzkaTerminal RaiseInter;






    private static ArrayList<Osoba>  OsobyOdczyt= null;
    private  static  ArrayList<Kurs>  KursyOdczyt = null;



    public UczelniaORG() {
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
    public void UsunStudenta(){
        System.out.println("Wpisz szukane: ");
        ArrayList<Student> UsuwaniS = WyszukajStudenta(scan.next());
        System.out.println("Usunąłeś poniższych studentów: ");
        Wyprintuj(UsuwaniS);
        if(UsuwaniS.isEmpty()){
            System.out.println("Brak");
        }
        getOsoby().removeAll(UsuwaniS);
        setOsoby(getOsoby());
        getStudenci().removeAll(UsuwaniS);
        setStudenci(getStudenci());

    }

    public void UsunPracownika(){
        System.out.println("Wpisz szukane: ");
        ArrayList<PracownikUczelni> UsuwaniP = WyszukajPracownika(scan.next());
        System.out.println("Usunąłeś poniższych pracowników: ");
        Wyprintuj(UsuwaniP);
        if(UsuwaniP.isEmpty()){
            System.out.println("Brak");
        }
        getOsoby().removeAll(UsuwaniP);
        setOsoby(getOsoby());
        getPracownicy().removeAll(UsuwaniP);
        setPracownicy(getPracownicy());

        ArrayList<Kurs> UsuwaneKursy = new ArrayList<Kurs>();
        for (int i = 0; i < UsuwaniP.size() ; i++) {
            for (int j = 0; j <getKursy().size() ; j++) {
                if(Objects.equals(UsuwaniP.get(i),getKursy().get(j).getProwadzacy())){
                    UsuwaneKursy.add(getKursy().get(j));
                }

            }

        }
        getKursy().removeAll(UsuwaneKursy);
        setKursy(getKursy());
        for (int i = 0; i <getStudenci().size() ; i++) {
            Student obecnyStudent = getStudenci().get(i);
            obecnyStudent.getListaKursow().removeAll(UsuwaneKursy);
            obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());

        }

    }

    public void UsunKurs(){
        System.out.println("Wpisz szukane: ");
        ArrayList<Kurs> UsuwaniK = WyszukajKurs(scan.next());
        System.out.println("Usunąłeś poniższe kursy: ");
        Wyprintuj(UsuwaniK);
        if(UsuwaniK.isEmpty()){
            System.out.println("Brak");
        }
        getKursy().removeAll(UsuwaniK);
        setKursy(getKursy());


        for (int i = 0; i <getStudenci().size() ; i++) {
            Student obecnyStudent = getStudenci().get(i);
            obecnyStudent.getListaKursow().removeAll(UsuwaniK);
            obecnyStudent.setListaKursow(obecnyStudent.getListaKursow());
        }

    }



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

    // STRATEGIA

    public void wykonajStrategie(int nr_Strategii){
        switch (nr_Strategii){
            case 1:
                RaiseInter = new PodwyzkaTerminalSposob1();
                break;
            case 2:
                RaiseInter = new PodwyzkaTerminalSposob2();

                break;
        }
    }

    public void SortujKursy(){
        int sortKursswitch = scan.nextInt();
        switch (sortKursswitch){
            case 1:
                Collections.sort(getKursy(),new KomparatorECTSNazwisko());
                break;
            case 2:
                break;
            default:
                System.out.println("Coś poszło nie tak, (sortowanie kursy)");

        }



    }

    public void SortujOsoby(){
        int sortOsobaswitch = scan.nextInt();
        switch (sortOsobaswitch){
            case 1:
                kompOsoba = new KomparatorNazwisko();
                break;
            case 2:
                kompOsoba = new KomparatorNazwiskoImie();
                break;
            case 3:
                kompOsoba = new KomparatorNazwiskoWiek();
                break;
            case 4:
                break;
            default:
                System.out.println("Coś poszło nietak, (sortowanie)");
        }
        Collections.sort(getOsoby(),kompOsoba);






    }

    public void DajPodwyzke(){

        int podwyzkaScan = scan.nextInt();

        wykonajStrategie(podwyzkaScan);
        Wyprintuj(getPracownicy());

        System.out.println("Komu chcesz dać podwyżkę? Podaj ID: ");
        String IDPodwyzka = scan.next();


        try{
            getRaiseInter().SposobNaPodwyzke(WyszukajPracownikaID(IDPodwyzka));
        } catch (Exception e){
            System.out.println("Niepoprawne ID");
        }


    }






    //GETTERY I SETTERY


    public PodwyzkaTerminal getRaiseInter() {
        return RaiseInter;
    }

    public void setRaiseInter(PodwyzkaTerminal raiseInter) {
        RaiseInter = raiseInter;
    }

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

package Observable;

import Observers.Observer;
import SkladoweUczelni.*;
import Strategia.Creation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Uczelnia implements ObservableClass{
    private ArrayList<Osoba> Osoby = new ArrayList<Osoba>();
    private ArrayList<Kurs> Kursy = new ArrayList<Kurs>();
    private ArrayList<Student> Studenci = GetStudenci();
    private  ArrayList<PracownikUczelni> Pracownicy = GetPracownicy();

    private ArrayList<Kurs> KursyOdczyt = new ArrayList<Kurs>();

    private ArrayList<Osoba> OsobyOdczyt = new ArrayList<Osoba>();
    private ArrayList<String> StanowiskaBD = new ArrayList<>(Arrays.asList("Asystent", "Adiunkt", "ProfesorNadzwyczajny", "ProfesorZwyczajny", "Wykladowca"));
    private ArrayList<String> StanowiskaA = new ArrayList<>(Arrays.asList("Referent","Specjalista","StarszySpecjalista"));

    protected CreationInterface creation;


    ArrayList<Observer> ObserverList = new ArrayList<>();



    @Override
    public void registerObserver(Observer observer) {
        ObserverList.add(observer);

    }

    @Override
    public void removeObserver(Observer observer) {
        ObserverList.remove(observer);

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i <ObserverList.size() ; i++) {
            ObserverList.get(i).update(Osoby,Kursy);

        }

    }

    public void parametersChanged(){
        notifyObservers();
    }

    public  void setNewParameters(ArrayList<Osoba> osoby, ArrayList<Kurs> kursy){
        this.Osoby = osoby;
        this.Kursy = kursy;

        parametersChanged();
    }



    //METODY FUNCKJONALNE

    public void Add(Creation c){
        if(c instanceof Kurs){
            Kursy.add((Kurs) c);
            notifyObservers();


        } else if (c instanceof Student) {
            Osoby.add((Student) c);
            Studenci.add((Student) c);
            notifyObservers();

        } else if (c instanceof PracownikBD) {
            Pracownicy.add((PracownikBD) c);
            Osoby.add((PracownikBD)c);
            notifyObservers();

        }else if (c instanceof PracownikA) {
            Pracownicy.add((PracownikA) c);
            Osoby.add((PracownikA) c);
            notifyObservers();
        }



    }
    public Creation Create(int wybor){
        switch (wybor){
            case 1:
                creation = new CreateStudent();
                break;
            case 2:
                creation = new CreatePracownikBD();
                break;
            case 3:
                creation = new CreatePracownikA();
                break;
            case 4:
                creation = new CreateKurs();
                break;

        }



    return creation.create(this); // return Creation !
    }

    public  void Wyprintuj(ArrayList Lista) {
        for (int i = 0; i < Lista.size(); i++) {
            System.out.println(Lista.get(i).toString());

        }
    }



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

    public  void odczytaj() {
        try (ObjectInputStream odczytaj = new ObjectInputStream(new FileInputStream("BazaDanych.ser"))) {

            Object ob1 = odczytaj.readObject();
            Object ob2 = odczytaj.readObject();


            KursyOdczyt = (ArrayList<Kurs>) ob1;
            OsobyOdczyt = (ArrayList<Osoba>) ob2;

            setKursy(KursyOdczyt);
            setOsoby(OsobyOdczyt);
            setPracownicy(GetPracownicy());
            setStudenci(GetStudenci());

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

            zapiszPuste();
        }
    }





    //GETTERY I SETTERY


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

    public ArrayList<Osoba> getOsoby() {
        return Osoby;
    }

    public void setOsoby(ArrayList<Osoba> osoby) {
        Osoby = osoby;
    }

    public ArrayList<Kurs> getKursy() {
        return Kursy;
    }

    public void setKursy(ArrayList<Kurs> kursy) {
        Kursy = kursy;
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

    public ArrayList<Observer> getObserverList() {
        return ObserverList;
    }

    public void setObserverList(ArrayList<Observer> observerList) {
        ObserverList = observerList;
    }
}

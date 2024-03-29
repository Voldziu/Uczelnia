package SkladoweUczelni;

import java.util.ArrayList;

public class Student extends Osoba {

    //Skladowe
    private static final long serialVersionUID = 2255387357392705765L;


    private int Index;
    private int Rok;
    private ArrayList<Kurs> ListaKursow;
    private boolean CzyErasmus;
    private boolean CzyPierwszyStopien;
    private boolean CzyDrugiStopien;
    private boolean CzyStacjonarne;
    private boolean CzyNiestacjonarne;


    //Konstruktor


    public Student(int ID, String imie, String nazwisko, String PESEL, int wiek, String plec, int index, int rok, ArrayList<Kurs> listaKursow, boolean czyErasmus, boolean czyPierwszyStopien, boolean czyDrugiStopien, boolean czyStacjonarne, boolean czyNiestacjonarne) {
        super(ID, imie, nazwisko, PESEL, wiek, plec);
        Index = index;
        Rok = rok;
        ListaKursow = listaKursow;
        CzyErasmus = czyErasmus;
        CzyPierwszyStopien = czyPierwszyStopien;
        CzyDrugiStopien = czyDrugiStopien;
        CzyStacjonarne = czyStacjonarne;
        CzyNiestacjonarne = czyNiestacjonarne;
    }


    //Gettery Settery


    public int getIndex() {
        return Index;
    }

    public void setIndex(int index) {
        Index = index;
    }

    public int getRok() {
        return Rok;
    }

    public void setRok(int rok) {
        Rok = rok;
    }

    public ArrayList<Kurs> getListaKursow() {
        return ListaKursow;
    }

    public void setListaKursow(ArrayList<Kurs> listaKursow) {
        ListaKursow = listaKursow;
    }

    public boolean GetCzyErasmus() {
        return CzyErasmus;
    }

    public void setCzyErasmus(boolean czyErasmus) {
        CzyErasmus = czyErasmus;
    }

    public boolean GetCzyPierwszyStopien() {
        return CzyPierwszyStopien;
    }

    public void setCzyPierwszyStopien(boolean czyPierwszyStopien) {
        CzyPierwszyStopien = czyPierwszyStopien;
    }

    public boolean GetCzyDrugiStopien() {
        return CzyDrugiStopien;
    }

    public void setCzyDrugiStopien(boolean czyDrugiStopien) {
        CzyDrugiStopien = czyDrugiStopien;
    }

    public boolean GetCzyStacjonarne() {
        return CzyStacjonarne;
    }

    public void setCzyStacjonarne(boolean czyStacjonarne) {
        CzyStacjonarne = czyStacjonarne;
    }

    public boolean GetCzyNiestacjonarne() {
        return CzyNiestacjonarne;
    }

    public void setCzyNiestacjonarne(boolean czyNiestacjonarne) {
        CzyNiestacjonarne = czyNiestacjonarne;
    }


    @Override
    public String toString() {
        return (super.toString() + "\t" +
                Index + "\t" +
                Rok + "\t" +
                ListaKursow + "\t" +
                CzyErasmus + "\t" +
                CzyPierwszyStopien + "\t" +
                CzyDrugiStopien + "\t" +
                CzyStacjonarne + "\t" +
                CzyNiestacjonarne + "\t"
        );
    }

    @Override
    public int hashCode() {

        return this.getIndex();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Student) {
            Student other = (Student) obj;
            if (this.getIndex() == (other.getIndex())) {
                return true;
            } else {
                return false;
            }
        } else {
        return false;
        }
    }









}

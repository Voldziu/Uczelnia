package SkladoweUczelni;

import java.io.Serial;
import java.io.Serializable;

public abstract class  Osoba  extends Creation implements Serializable {

    //Skladowe
    private static final long serialVersionUID = 5567566049324461550L;

    private int ID;
    private  String Imie;
    private  String Nazwisko;
    private  String PESEL;
    private  int Wiek;
    private String Plec;

    //Konstruktor

    public Osoba(int ID,String imie, String nazwisko, String PESEL, int wiek, String plec) {
        this.ID= ID;
        Imie = imie;
        Nazwisko = nazwisko;
        this.PESEL = PESEL;
        Wiek = wiek;
        Plec = plec;
    }



    //Gettery Settery


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getImie() {
        return Imie;
    }

    public void setImie(String imie) {
        Imie = imie;
    }

    public String getNazwisko() {
        return Nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        Nazwisko = nazwisko;
    }

    public String getPESEL() {
        return PESEL;
    }

    public void setPESEL(String PESEL) {
        this.PESEL = PESEL;
    }

    public int getWiek() {
        return Wiek;
    }

    public void setWiek(int wiek) {
        Wiek = wiek;
    }

    public String getPlec() {
        return Plec;
    }

    public void setPlec(String plec) {
        Plec = plec;
    }

    @Override
    public String toString() {
        return (ID +"\t"+Imie + "\t" + Nazwisko + "\t" + PESEL + "\t" + Wiek + "\t" + Plec );

    }


}

package SkladoweUczelni;

import java.io.Serializable;

public class Kurs implements Serializable {

    private static final long serialVersionUID = 5567566049323461550L;

    //Skladowe

    private int ID;
    private  String NazwaKursu;
    private PracownikUczelni Prowadzacy;
    private int ECTS;

    //Konstruktor

    public Kurs(int ID,String nazwaKursu, PracownikUczelni prowadzacy, int ECTS) {
        this.ID = ID;
        NazwaKursu = nazwaKursu;
        Prowadzacy = prowadzacy;
        this.ECTS = ECTS;
    }



    //GETERY I SETTERY


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNazwaKursu() {
        return NazwaKursu;
    }

    public void setNazwaKursu(String nazwaKursu) {
        NazwaKursu = nazwaKursu;
    }

    public PracownikUczelni getProwadzacy() {
        return Prowadzacy;
    }

    public void setProwadzacy(PracownikUczelni prowadzacy) {
        Prowadzacy = prowadzacy;
    }

    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }


    @Override
    public String toString() {
        return (ID+ "\t"+NazwaKursu +"\t"+ Prowadzacy +"\t"+ ECTS + "\t");
    }
}

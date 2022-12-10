import java.io.Serializable;

public class Kurs implements Serializable {

    private static final long serialVersionUID = 5567566049323461550L;

    //Skladowe
    private  String NazwaKursu;
    private PracownikUczelni Prowadzacy;
    private int ECTS;

    //Konstruktor

    public Kurs(String nazwaKursu, PracownikUczelni prowadzacy, int ECTS) {
        NazwaKursu = nazwaKursu;
        Prowadzacy = prowadzacy;
        this.ECTS = ECTS;
    }



    //GETERY I SETTERY


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
        return (NazwaKursu +"\t"+ Prowadzacy +"\t"+ ECTS + "\t");
    }
}

package SkladoweUczelni;

public class PracownikBD extends PracownikUczelni {

    //Skladowe

    private int LiczbaPublikacji;

    //Konstruktor

    public PracownikBD(int ID,String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, double stazPracy, double pensja, int liczbaPublikacji) {
        super(ID,imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        LiczbaPublikacji = liczbaPublikacji;
    }

    //Gettery Settery


    public int getLiczbaPublikacji() {
        return LiczbaPublikacji;
    }

    public void setLiczbaPublikacji(int liczbaPublikacji) {
        LiczbaPublikacji = liczbaPublikacji;
    }

    @Override
    public String toString() {
        return  (super.toString() + LiczbaPublikacji + "\t");
    }
}

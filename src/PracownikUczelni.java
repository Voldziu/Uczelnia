public abstract class PracownikUczelni extends  Osoba {

    //Skladowe

    private String Stanowisko;
    private float StazPracy;
    private float Pensja;


    // Konstruktor


    public PracownikUczelni(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, float stazPracy, float pensja) {
        super(imie, nazwisko, PESEL, wiek, plec);
        Stanowisko = stanowisko;
        StazPracy = stazPracy;
        Pensja = pensja;
    }



    //Gettery Settery


    public String getStanowisko() {
        return Stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        Stanowisko = stanowisko;
    }

    public float getStazPracy() {
        return StazPracy;
    }

    public void setStazPracy(float stazPracy) {
        StazPracy = stazPracy;
    }

    public float getPensja() {
        return Pensja;
    }

    public void setPensja(float pensja) {
        Pensja = pensja;
    }

    @Override
    public String toString() {
        return "Pracownik" + super.toString()+
                ", Stanowisko='" + Stanowisko + '\'' +
                ", StazPracy=" + StazPracy +
                ", Pensja=" + Pensja;

    }
}

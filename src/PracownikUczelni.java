public abstract class PracownikUczelni extends  Osoba {

    //Skladowe

    private String Stanowisko;
    private double StazPracy;
    private double Pensja;


    // Konstruktor


    public PracownikUczelni(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, double stazPracy, double pensja) {
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

    public double getStazPracy() {
        return StazPracy;
    }

    public void setStazPracy(float stazPracy) {
        StazPracy = stazPracy;
    }

    public double getPensja() {
        return Pensja;
    }

    public void setPensja(float pensja) {
        Pensja = pensja;
    }

    @Override
    public String toString() {
        return ( super.toString()+ "\t"+
               Stanowisko +  "\t"+
                StazPracy + "\t"+
                Pensja + "\t");

    }
}

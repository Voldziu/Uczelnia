package SkladoweUczelni;

public abstract class PracownikUczelni extends Osoba {

    //Skladowe

    private static final long serialVersionUID = 5713886696566790870L;

    private String Stanowisko;
    private double StazPracy;
    private double Pensja;


    // Konstruktor


    public PracownikUczelni(int ID,String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, double stazPracy, double pensja) {
        super(ID,imie, nazwisko, PESEL, wiek, plec);
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

    public void setStazPracy(double stazPracy) {
        StazPracy = stazPracy;
    }

    public double getPensja() {
        return Pensja;
    }

    public void setPensja(double pensja) {
        Pensja = pensja;
    }

    @Override
    public String toString() {
        return ( super.toString()+ "\t"+
               Stanowisko +  "\t"+
                StazPracy + "\t"+
                Pensja + "\t");

    }

    @Override
    public int hashCode() {
        return this.getPESEL().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof PracownikUczelni) {
            PracownikUczelni other = (PracownikUczelni) obj;
            if(this.getPESEL().equals(other.getPESEL())){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }


    }
}

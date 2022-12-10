public class PracownikA extends  PracownikUczelni{

    //Skladowe

    private int LiczbaNadgodzin;

    //Konstruktor

    public PracownikA(String imie, String nazwisko, String PESEL, int wiek, String plec, String stanowisko, double stazPracy, double pensja, int liczbaNadgodzin) {
        super(imie, nazwisko, PESEL, wiek, plec, stanowisko, stazPracy, pensja);
        LiczbaNadgodzin = liczbaNadgodzin;
    }









    //Gettery Settery


    public int getLiczbaNadgodzin() {
        return LiczbaNadgodzin;
    }

    public void setLiczbaNadgodzin(int liczbaNadgodzin) {
        LiczbaNadgodzin = liczbaNadgodzin;
    }


    public String toString(){
        return (super.toString()+ LiczbaNadgodzin +"\t");

    }
}

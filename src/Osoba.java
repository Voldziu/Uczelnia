public abstract class  Osoba {

    //Skladowe

    private  String Imie;
    private  String Nazwisko;
    private  String PESEL;
    private  int Wiek;
    private String Plec;

    //Konstruktor

    public Osoba(String imie, String nazwisko, String PESEL, int wiek, String plec) {
        Imie = imie;
        Nazwisko = nazwisko;
        this.PESEL = PESEL;
        Wiek = wiek;
        Plec = plec;
    }


    //Gettery Settery



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
        return "{" +
                "Imie='" + Imie + '\'' +
                ", Nazwisko='" + Nazwisko + '\'' +
                ", PESEL='" + PESEL + '\'' +
                ", Wiek=" + Wiek +
                ", Plec='" + Plec + '\''
                ;
    }
}

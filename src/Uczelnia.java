import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.WeakHashMap;

public class Uczelnia {

    private  ArrayList<Kurs> Kursy = new ArrayList<Kurs>();
    private ArrayList<Osoba> Osoby = new ArrayList<Osoba>();


    public Uczelnia(ArrayList<Kurs> kursy,ArrayList<Osoba> osoby) {
        Kursy = kursy;
        Osoby = osoby;
    }

    public ArrayList<PracownikUczelni> GetPracownicy(){
        ArrayList<PracownikUczelni> Pracownicy = new ArrayList<PracownikUczelni>();
        for (int i = 0; i <Osoby.size() ; i++) {
            Osoba obecnaOsoba = Osoby.get(i);
            if(obecnaOsoba instanceof PracownikUczelni){
                Pracownicy.add((PracownikUczelni) obecnaOsoba);
            }

        } return Pracownicy;
    }
    public ArrayList<Student> GetStudenci(){
        ArrayList<Student> Studenci = new ArrayList<Student>();
        for (int i = 0; i <Osoby.size(); i++) {
            Osoba obecnaOsoba = Osoby.get(i);
            if(obecnaOsoba instanceof Student){
                Studenci.add((Student) obecnaOsoba);
            }

        } return Studenci;
    }

    public ArrayList<PracownikUczelni> WyszukajPracownika(String InPut){
        ArrayList<PracownikUczelni> Wyszukani = new ArrayList<PracownikUczelni>();
        for (int i = 0; i <GetPracownicy().size() ; i++) {
            PracownikUczelni obecnyPracownik = GetPracownicy().get(i);

            if(InPut.equals(obecnyPracownik.getNazwisko()) || InPut.equals(obecnyPracownik.getImie())|| InPut.equals(obecnyPracownik.getStanowisko()) || (InPut.equals(String.valueOf(obecnyPracownik.getStazPracy())))  ||  (InPut.equals(String.valueOf(obecnyPracownik.getPensja())))){
                Wyszukani.add(obecnyPracownik);




        } else if(obecnyPracownik instanceof PracownikBD && (InPut.equals(String.valueOf(((PracownikBD)obecnyPracownik).getLiczbaPublikacji()))) ) {
                Wyszukani.add((PracownikBD)obecnyPracownik);

            } else if (obecnyPracownik instanceof PracownikA && (InPut.equals(String.valueOf(((PracownikA)obecnyPracownik).getLiczbaNadgodzin())))) {
                Wyszukani.add((PracownikA)obecnyPracownik);

            }

        }
        return Wyszukani;

        }

    public  ArrayList<Kurs> WyszukajKurs(String InPut){
        ArrayList<Kurs> Wyszukane = new ArrayList<Kurs>();
        for (int i = 0; i <Kursy.size() ; i++) {
            Kurs obecnyKurs = Kursy.get(i);
            if(InPut.equals(String.valueOf(obecnyKurs.getECTS())) || InPut.equals(obecnyKurs.getNazwaKursu()) || InPut.equals(obecnyKurs.getProwadzacy().getNazwisko()) ||  InPut.equals(obecnyKurs.getProwadzacy().getImie()) ){
                Wyszukane.add(obecnyKurs);
            }
        } return Wyszukane;
    }


    public  ArrayList<Student> WyszukajStudenta(String InPut){
        ArrayList<Student> Wyszukani = new ArrayList<Student>();
        for (int i = 0; i <GetStudenci().size(); i++) {
            Student obecnyStudent = GetStudenci().get(i);
            if (InPut.equals(obecnyStudent.getNazwisko())  ||  InPut.equals(obecnyStudent.getImie())  ||  InPut.equals(String.valueOf(obecnyStudent.getIndex()))  ||  InPut.equals(String.valueOf(obecnyStudent.getRok()))){
                Wyszukani.add(obecnyStudent);
            } else  {
                for (int j = 0; j <obecnyStudent.getListaKursow().size() ; j++) {
                    if(InPut.equals(obecnyStudent.getListaKursow().get(j).getNazwaKursu())) {
                        Wyszukani.add(obecnyStudent);
                    }


                }

            }

        } return Wyszukani;
    }

    public  void Wyprintuj(ArrayList Lista){
        for (int i = 0; i <Lista.size() ; i++) {
            System.out.println(Lista.get(i).toString());

        }




    }







}

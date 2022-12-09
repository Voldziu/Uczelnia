import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Scanner;



public class InferfejsUzytkownika {
    private Uczelnia Dane;
    private Scanner scan = new Scanner(System.in);



    public InferfejsUzytkownika(Uczelnia dane){
        Dane = dane;



    }

    public void Menu(){
        System.out.println("--------------MENU--------------\n");
        System.out.println("Wybierz co chcesz zrobić:");
        System.out.println("Dopisz: ");
        System.out.println("\t 101 --- Dopisz studenta" );
        System.out.println("\t 102 --- Dopisz Pracownika Administracji");
        System.out.println("\t 103 --- Dopisz Pracownika Badawczo-Dydaktycznego");
        System.out.println("\t 104 --- Dopisz Kurs");
        System.out.println("Wyprintuj wszystkich: ");
        System.out.println("\t 201 --- Wyprintuj Studentów");
        System.out.println("\t 202 --- Wyprintuj Pracowników");
        System.out.println("\t 203 --- Wyprintuj Kursy");
        System.out.println("Wyszukaj:");
        System.out.println("\t 301 --- Wyszukaj Studenta");
        System.out.println("\t 302 --- Wyszukaj Pracownika");
        System.out.println("\t 303 --- Wyszukaj Kurs");




    }

    public void Wybor(){
        boolean GameLoop = true;

        while(GameLoop){
            Menu();

            int wybor = scan.nextInt();

            switch (wybor) {
                case 101:
                    Dane.DodajStudenta(StworzStudenta());

                    break;
                case 102:
                    Dane.DodajPracownikaA(StworzPracownikaA());

                    break;
                case 103:
                    Dane.DodajPracownikaBD(StworzPracownikaBD());

                    break;
                case 104:
                    Dane.DodajKurs(StworzKurs());

                    break;


                case 201:
                    Dane.Wyprintuj(Dane.getStudenci());


                    break;
                case 202:
                    Dane.Wyprintuj(Dane.getPracownicy());
                    break;


                case 203:
                    Dane.Wyprintuj(Dane.getKursy());
                    break;


                case 301:
                    System.out.println("Wpisz kryterium: ");
                    Dane.Wyprintuj(Dane.WyszukajStudenta(scan.next()));
                    break;
                case 302:
                    System.out.println("Wpisz kryterium: ");
                    Dane.Wyprintuj(Dane.WyszukajPracownika(scan.next()));
                    break;
                case 303:
                    System.out.println("Wpisz kryterium: ");
                    Dane.Wyprintuj(Dane.WyszukajKurs(scan.next()));
                    break;
                default:
                    System.out.println("Coś poszło nie tak......., wpisz dobre wartości");


            }

            System.out.println("\n\nCo chcesz dalej robić? \n" +"\t1 --- Wróć do Menu" + "\n\t2 --- Zakończ Program");
            int decyzja = scan.nextInt();
            if (decyzja==2){
                GameLoop=false;
            }





        }



    }
    public PracownikBD StworzPracownikaBD(){

        System.out.println("Imie: ");
        String imie = scan.next();
        System.out.println("Nazwisko: ");
        String nazwisko = scan.next();;
        System.out.println("PESEL: ");
        String PESEL= scan.next();;
        System.out.println("Wiek: ");
        int wiek = scan.nextInt();;
        System.out.println("Plec: ");
        String plec = scan.next();;
        System.out.println("Stanowisko: ");
        String stanowisko = scan.next();
        System.out.println("StazPracy (double): ");;
        double stazPracy = scan.nextDouble();
        System.out.println("Pensja (double): ");;
        double pensja = scan.nextDouble();
        System.out.println("Liczba Publikacji: ");
        int liczbaPublikacji = scan.nextInt();

        return new PracownikBD(imie,  nazwisko,  PESEL, wiek, plec, stanowisko,  stazPracy,  pensja,  liczbaPublikacji);


    }
    public  PracownikA StworzPracownikaA(){


        System.out.println("Imie: ");
        String imie = scan.next();
        System.out.println("Nazwisko: ");
        String nazwisko = scan.next();;
        System.out.println("PESEL: ");
        String PESEL= scan.next();;
        System.out.println("Wiek: ");
        int wiek = scan.nextInt();;
        System.out.println("Plec: ");
        String plec = scan.next();;
        System.out.println("Stanowisko: ");
        String stanowisko = scan.next();
        System.out.println("StazPracy (double): ");;
        double stazPracy = scan.nextDouble();
        System.out.println("Pensja (double): ");;
        double pensja = scan.nextDouble();
        System.out.println("Liczba Nadgodzin: ");
        int liczbaNadgodzin= scan.nextInt();




        return new PracownikA(imie,  nazwisko,  PESEL, wiek, plec, stanowisko,  stazPracy,  pensja,  liczbaNadgodzin);

    }
    public Kurs StworzKurs(){
        System.out.println("Nazwa Kursu:");
        String nazwaKursu = scan.next();
        System.out.println("Teraz tworzysz prowadzącego");
        PracownikBD Prowadzacy =StworzPracownikaBD();
        System.out.println("ECTS: ");
        int ECTS = scan.nextInt();


        return new Kurs(nazwaKursu,Prowadzacy,ECTS);


    }

    public  Student StworzStudenta(){

        System.out.println("Imie: ");
        String imie = scan.next();
        System.out.println("Nazwisko: ");
        String nazwisko = scan.next();;
        System.out.println("PESEL: ");
        String PESEL= scan.next();;
        System.out.println("Wiek: ");
        int wiek = scan.nextInt();;
        System.out.println("Plec: ");
        String plec = scan.next();;
        System.out.println("Index");
        int index = scan.nextInt();
        System.out.println("rok");
        int rok =scan.nextInt();
        System.out.println("Tworzysz liste kursow");
        ArrayList<Kurs> listaKursow = new ArrayList<Kurs>();
        do{
            listaKursow.add(StworzKurs());
        }
        while(!scan.next().equals("koniec"));





        System.out.println("CzyErasmus");
        boolean czyErasmus = scan.nextBoolean();
        System.out.println("czyIstopien");
        boolean czyPierwszyStopien =scan.nextBoolean();
        System.out.println("czy2Stopien");
        boolean czyDrugiStopien = scan.nextBoolean();
        System.out.println("CzyStacjo");
        boolean czyStacjonarne = scan.nextBoolean();
        System.out.println("CzyNIestacjo");
        boolean czyNiestacjonarne = scan.nextBoolean();


        return new Student(imie, nazwisko, PESEL, wiek, plec, index, rok, listaKursow, czyErasmus, czyPierwszyStopien, czyDrugiStopien, czyStacjonarne, czyNiestacjonarne);
    }

}

import java.util.Scanner;

public class InferfejsUzytkownika {
    private Uczelnia Dane;
    private Scanner Scan;


    public InferfejsUzytkownika(Uczelnia dane){
        Dane = dane;
        Scan = new Scanner(System.in);


    }

    public void Menu(){
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

}

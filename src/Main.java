import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {


    //Obsluzyc jakos bledy
    // Czemu stworzyl sie kurs 8 analiza bez prowadzacego?





    public static void main(String[] args) {
        Uczelnia Pwr = new Uczelnia();
        InferfejsUzytkownika gui = new InferfejsUzytkownika(Pwr);
        try {
            gui.Graj();
        } catch (Exception e){
            e.printStackTrace();
            gui.getDane().zapisz();
        }








    }
}
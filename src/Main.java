import SkladoweUczelni.Uczelnia;
import Komparatory.*;

import java.util.Collections;
import java.util.List;

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
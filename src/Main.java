import Observable.Uczelnia;
import Observers.ObslugaUczelni;
import SkladoweUczelni.UczelniaORG;

public class Main {







    public static void main(String[] args) {
        Uczelnia pwr = new Uczelnia();
        ObslugaUczelni gui = new ObslugaUczelni(pwr);
        try {
            gui.Graj();


        } catch (Exception e){
            e.printStackTrace();
            gui.getDane().zapisz();
        }










    }
}
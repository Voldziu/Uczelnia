package Strategia;
import SkladoweUczelni.*;

public class PodwyzkaSposob2 implements PodwyzkaInterface{
    @Override
    public void SposobNaPodwyzke(PracownikUczelni p) {
        System.out.println("Sposob2");
        double pensja = p.getPensja();
        p.setPensja(pensja+1000);

    }
}

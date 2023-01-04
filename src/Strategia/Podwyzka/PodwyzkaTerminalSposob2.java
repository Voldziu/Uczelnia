package Strategia.Podwyzka;
import SkladoweUczelni.*;

public class PodwyzkaTerminalSposob2 implements PodwyzkaTerminal {
    @Override
    public void SposobNaPodwyzke(PracownikUczelni p) {
        System.out.println("Sposob2");
        double pensja = p.getPensja();
        p.setPensja(pensja+1000);

    }
}

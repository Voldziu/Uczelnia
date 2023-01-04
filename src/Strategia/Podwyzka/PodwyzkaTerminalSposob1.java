package Strategia.Podwyzka;
import SkladoweUczelni.*;

public class PodwyzkaTerminalSposob1 implements PodwyzkaTerminal {
    @Override
    public void SposobNaPodwyzke(PracownikUczelni p) {
        System.out.println("Podwyzka1");
        double pensja = p.getPensja();
        double pensjaPodwyzka;
        if(pensja <5000 ){
            pensjaPodwyzka = pensja+2000;

        } else if (pensja<10000) {
            pensjaPodwyzka = pensja*(1.20);

        } else if (pensja<15000) {
            pensjaPodwyzka = pensja *(1.10);

        } else{
            pensjaPodwyzka = pensja * (1.03);

        }
        p.setPensja(pensjaPodwyzka);
    }
}

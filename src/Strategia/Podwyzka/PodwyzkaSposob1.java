package Strategia.Podwyzka;
import Strategia.Podwyzka.PodwyzkaInterface;
import SkladoweUczelni.*;

public class PodwyzkaSposob1 implements PodwyzkaInterface {
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

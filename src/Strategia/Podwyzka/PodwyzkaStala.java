package Strategia.Podwyzka;

import SkladoweUczelni.PracownikUczelni;

public class PodwyzkaStala implements PodwyzkaInterfejs {
    @Override
    public void DajPodwyzke(PracownikUczelni p, String InPut) {

            double zmiana = Double.parseDouble(InPut);
            double pensja = p.getPensja();
            double pensjaNowa = pensja+zmiana;
            p.setPensja(pensjaNowa);



    }
}

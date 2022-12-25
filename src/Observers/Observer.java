package Observers;

import SkladoweUczelni.Kurs;
import SkladoweUczelni.Osoba;

import java.util.ArrayList;

public interface Observer {

    public void update(ArrayList<Osoba> osoby, ArrayList<Kurs> kursy);
}

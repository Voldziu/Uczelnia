package SkladoweUczelni;

import Strategia.Creation.CreationInterface;
import Observable.*;

import java.util.Scanner;

public abstract class Creation {
    private Scanner scan = new Scanner(System.in);
    protected  CreationInterface CreInt;

    public void Create(Uczelnia Dane){
        CreInt.create(Dane);
    } // -- nie wiem po co to wszystko ,ale jest

    public CreationInterface getCreInt() {
        return CreInt;
    }
}

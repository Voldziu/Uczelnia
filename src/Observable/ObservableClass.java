package Observable;
import  Observers.*;


public interface ObservableClass {
    public void registerObserver(Observer observer);
    public void removeObserver(Observer observer);
    public void notifyObservers();

}

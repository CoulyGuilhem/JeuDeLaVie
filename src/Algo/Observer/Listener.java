package Algo.Observer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.List;

public class Listener {

    /**
     * Class Listener du design patern Observer
     */
    private final List<Observer> observers = new ArrayList<>();

    /**
     * Permet d'ajouter une Cellule dans l'observer
     * @param observer
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
        System.out.println(observers.size());
    }

    /**
     * Permet de supprimer une Cellule dans l'observer
     * @param observer
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Permet de mettre a jour les cellules
     */
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

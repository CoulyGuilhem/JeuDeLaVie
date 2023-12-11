package Algo;

import Algo.Observer.Cellule;

import java.awt.*;

/**
 * Singleton
 */
public final class Data {
    private static Data instance;
    public int generation;
    public Cellule[][] grid;
    public int minCellule;
    public int maxCellule;
    public int createCellule;
    public Color color;
    public boolean run;
    public int time;
    public int celluleVivante;

    /**
     * Singleton de la classe Data()
     * Contient la majorité des valeurs de l'UI ainsi que des valeur du tableau de jeu
     */
    private Data(){

        this.celluleVivante = 0;
        this.run = false;
        this.generation = 0;
        this.grid = new Cellule[10][10];
        this.minCellule = 2;
        this.maxCellule = 3;
        this.createCellule = 3;
        this.color = Color.GREEN;
        this.time = 1000;
    }

    public static Data getInstance() {
        if (instance == null) {
            instance = new Data();
        }
        return instance;
    }

}

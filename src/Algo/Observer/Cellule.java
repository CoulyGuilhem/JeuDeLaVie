package Algo.Observer;

import java.util.ArrayList;
import java.util.List;
import Algo.Data;

public class Cellule implements Observer {
    private final int x;
    private final int y;
    private boolean isAlive;
    private boolean nextState;
    private final List<Cellule> voisins;

    private final Data data = Data.getInstance();

    private static final int[] DX = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] DY = {-1, 0, 1, -1, 1, -1, 0, 1};

    /**
     * Classe Cellule faisant partie du design pattern Observer
     * @param x coordonnée x dans le tableau
     * @param y coordonnée y dans le tableau
     */
    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
        this.isAlive = false;
        this.nextState = false;
        this.voisins = new ArrayList<>();
    }

    /**
     * isAlive() renvoie l'état de vie de la cellule
     * @return
     */
    public boolean isAlive() {
        return isAlive;
    }

    /**
     * setAlive() permet de choisir l'état de vie de la cellule
     * @param isAlive futur etat de vie de la cellule
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    /**
     * addVoisin() permet de definir une liste de cellule voisine afin de simplifier les algorithmes
     * @param board tableau actuel
     * @param width largeur
     * @param height hauteur
     */
    public void addVoisin(Cellule[][] board, int width, int height) {
        for (int i = 0; i < DX.length; i++) {
            int newX = x + DX[i];
            int newY = y + DY[i];
            if (newX >= 0 && newX < width && newY >= 0 && newY < height) {
                voisins.add(board[newX][newY]);
            }
        }
    }

    /**
     * updateNextState() permet de definir le prochain état de la cellule
     */
    public void updateNextState() {
        int voisinEnVie = 0;
        for (Cellule voisin : voisins) {
            if (voisin.isAlive()) {
                voisinEnVie++;
            }
        }

        if (isAlive) {
            // Si en vie alors le nombre de voisins doit etre compris entre 2 valeurs
            nextState = voisinEnVie >= data.minCellule && voisinEnVie <= data.maxCellule;
        } else {
            // Sinon le nombre de voisin doit etre egal a une valeur
            nextState = voisinEnVie == data.createCellule;
        }
    }

    /**
     * update()
     * Appel de la fonction update de l'observer
     */
    @Override
    public void update() {
        isAlive = nextState;
    }
}

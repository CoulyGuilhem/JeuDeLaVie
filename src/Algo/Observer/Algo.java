package Algo.Observer;
import Algo.Data;
public class Algo extends Listener {
    public Data data;

    /**
     * Classe Algo
     *
     * Possède les fonctions algorithmique du jeu de la vie
     */
    public Algo() {
        this.data = Data.getInstance();
    }

    /**
     * initializeBoard
     * Met en place un tableau vide en fonction de la taille séléctionnée dans l'UI
     */
    public void initializeBoard() {

        data.generation = 0;

        for (int i = 0; i < data.grid.length; i++) {
            for (int j = 0; j < data.grid[0].length; j++) {
                Cellule cell = new Cellule(i, j);
                addObserver(cell);
                data.grid[i][j] = cell;
            }
        }
        for (int i = 0; i < data.grid.length; i++) {
            for (int j = 0; j < data.grid.length; j++) {
                data.grid[i][j].addVoisin(data.grid, data.grid.length, data.grid.length);
            }
        }
    }

    /**
     * nextGeneration()
     *
     * Calcule le prochain etat du tableau
     */
    public void nextGeneration() {
        for (Cellule[] row : data.grid) {
            for (Cellule cell : row) {
                cell.updateNextState();
            }
        }
        for (Cellule[] row : data.grid) {
            for (Cellule cell : row) {
                cell.update();
            }
        }
        data.generation = data.generation + 1;
        data.celluleVivante = nombreCelluleVivante();
        notifyObservers();
    }

    /**
     * nombreCelluleVivante() renvoie le nombre de cellules vivantes
     * @return int (total de cellules en vie)
     */
    public int nombreCelluleVivante() {
        int count = 0;
        for (Cellule[] row : data.grid) {
            for (Cellule cell : row) {
                if (cell.isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}


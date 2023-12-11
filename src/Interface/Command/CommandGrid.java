package Interface.Command;

import Algo.Observer.Algo;
import Algo.Data;
import Algo.Observer.Cellule;
import Interface.Fenetre;

public class CommandGrid implements Command {
        private final int taille;
        private Algo algo;


    /**
     * Classe CommandGrid provenant du design pattern Command
     * @param taille nouvelle taille du plateau jeu
     */
    public CommandGrid(int taille) {
        this.taille = taille;
    }

    @Override
    public void execute() {
        Data data = Data.getInstance();
        data.run = false;
        Fenetre fenetre = Fenetre.getInstance();
        data.grid = new Cellule[taille][taille];
        algo = new Algo();
        algo.initializeBoard();
        fenetre.generateFenetre();
    }
}

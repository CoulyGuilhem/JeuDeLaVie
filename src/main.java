import Algo.Observer.*;
import Algo.Data;
import Interface.Fenetre;

public class main {
    public static void main(String[] args) {
        Data data = Data.getInstance();
        new Algo().initializeBoard();
        Fenetre fenetre = Fenetre.getInstance();
        fenetre.generateFenetre();
    }
}


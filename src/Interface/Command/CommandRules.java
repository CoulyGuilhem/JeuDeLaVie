package Interface.Command;

import Algo.Observer.Algo;
import Interface.Fenetre;
import Algo.Data;

public class CommandRules implements Command{

    private final int value;
    private final String rule;
    private Algo algo;

    /**
     * Classe CommandRules provenant du design pattern Command
     * @param rule (nombre de cellules min et max pour la survie
     *              nombre cellule pour la creation d'une cellule)
     * @param value chiffre a attribuer a ces regles
     */

    public CommandRules(String rule, int value){
        this.rule = rule;
        this.value = value;
    }

    @Override
    public void execute() {
        Data data = Data.getInstance();
        Fenetre fenetre = Fenetre.getInstance();
        switch (rule){
            case "min":
                data.minCellule = this.value;
                break;
            case "max":
                data.maxCellule = this.value;
                break;
            case "create":
                data.createCellule = this.value;
                break;
        }
        fenetre.generateFenetre();
    }
}

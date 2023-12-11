package Interface.Command;

import Algo.Data;
import Interface.Fenetre;

import javax.swing.*;
import java.awt.*;

public class CommandColor implements Command {

    private Data data = Data.getInstance();
    private final Color color;

    /**
     * Classe CommandColor provenant du design pattern Command
     * @param color nouvelle couleur du jeu
     */

    public CommandColor(Color color) {
        this.color = color;
    }

    @Override
    public void execute() {
        data.color = this.color;
        Fenetre.getInstance().generateFenetre();
    }
}

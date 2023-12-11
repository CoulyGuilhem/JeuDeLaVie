package Interface.Command;

import Algo.Data;
import Algo.Observer.Algo;
import Interface.Fenetre;

import javax.swing.*;


public class CommandButton implements Command {
    private final String message;
    private final Algo algo = new Algo();

    /**
     * Classe CommandButton provenant du design pattern Command
     * @param message type de commande a executer
     */
    public CommandButton(String message) {
        this.message = message;
    }

    /**
     * Execute une commande en fonction du message attribué au bouton
     */
    @Override
    public void execute() {
        Data data = Data.getInstance();

        switch (this.message){
            case "Run":
                data.run = true;
                SwingWorker<Void, Void> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() {
                        while (data.run) {
                            algo.nextGeneration();
                            System.out.println(data.generation);
                            Fenetre.getInstance().generateFenetre();
                            try {
                                Thread.sleep(data.time); // Ajoute un délai d'une seconde entre chaque génération
                            } catch (InterruptedException interruptedException) {
                                interruptedException.printStackTrace();
                            }
                        }
                        return null;
                    }
                };
                worker.execute();
                break;
            case "Pause":
                data.run = false;
                System.out.println();
                break;
            case "Reset":
                data.run = false;
                data.celluleVivante = 0;
                algo.initializeBoard();
                Fenetre.getInstance().generateFenetre();
                break;
            case "Next":
                data.run = false;
                algo.nextGeneration();
                Fenetre.getInstance().generateFenetre();
                break;
        }
    }
}

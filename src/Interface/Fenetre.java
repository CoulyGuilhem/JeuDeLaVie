package Interface;

import Algo.Data;
import Algo.Observer.Cellule;
import Interface.Command.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Fenetre {

    static Fenetre instance;
    JFrame frame;
    JPanel panel;

    Data data;

    /**
     * Classe Fenetre
     * Interface de l'application
     */
    private Fenetre() {
        this.frame = new JFrame("Jeu de la vie");
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public static Fenetre getInstance() {
        if (instance == null) {
            instance = new Fenetre();
        }
        return instance;
    }

    public void generateFenetre() {
        this.frame.getContentPane().removeAll();
        this.frame.repaint();
        this.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.data = Data.getInstance();
        this.panel = new JPanel(new GridLayout(this.data.grid.length, this.data.grid.length));
        generateGrid();
        generateInformations();
    }

    public void generateGrid() {
        Color color = this.data.color;

        // Grid of Color Changing Panels
        for (int i = 0; i < this.data.grid.length; i++) {
            for (int j = 0; j < this.data.grid.length; j++) {
                JPanel cell = new JPanel();
                Cellule cellule = this.data.grid[i][j];;
                if(cellule.isAlive()){
                    cell.setBackground(this.data.color);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));

                int x = i;
                int y = j;
                cell.addMouseListener(new java.awt.event.MouseAdapter() {

                    public void mouseClicked(java.awt.event.MouseEvent evt) {
                        Data data1 = Data.getInstance();
                        if (cellule.isAlive()){
                            cell.setBackground(Color.WHITE);
                            data1.grid[x][y].setAlive(false);
                        } else {
                            cell.setBackground(color);
                            data1.grid[x][y].setAlive(true);
                            System.out.println("x ="+x+" y = "+y);
                        }
                    }
                });
                this.panel.add(cell);
            }
        }
    }

    public void generateInformations(){

        // Side Panel
        JPanel sidePanel = new JPanel();
        sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

        // Texts with respective components
        addTextWithComponent(sidePanel, " Generation : "+data.generation+"      Nombre de cellules vivantes : "+data.celluleVivante,null);
        addTextWithComponent(sidePanel, "Demarre/Pause", new CommandButton[]{new CommandButton("Run"), new CommandButton("Pause")}, new JButton("Run"),new JButton("Pause"));
        addTextWithComponent(sidePanel, "Reset/Next Gen", new CommandButton[]{new CommandButton("Reset"), new CommandButton("Next")}, new JButton("Reset"), new JButton("Next Gen"));
        addTextWithComponent(sidePanel, "Grille",new CommandGrid[]{new CommandGrid(10),new CommandGrid(20),new CommandGrid(30),new CommandGrid(40),new CommandGrid(50)}, createButtons(new String[]{"10x10","20x20","30x30","40x40","50x50"}));
        addTextWithComponent(sidePanel, "Nombre cellule mini vie : "+data.minCellule,new CommandRules[]{new CommandRules("min",0),new CommandRules("min",1),new CommandRules("min",2)
                                                                                         ,new CommandRules("min",3),new CommandRules("min",4),new CommandRules("min",5)
                                                                                         ,new CommandRules("min",6),new CommandRules("min",7),new CommandRules("min",8)},createButtons(new String[]{"0","1","2","3","4","5","6","7","8"}));
        addTextWithComponent(sidePanel, "Nombre cellule max vie : "+data.maxCellule, new CommandRules[]{new CommandRules("max",0),new CommandRules("max",1),new CommandRules("max",2)
                                                                                         ,new CommandRules("max",3),new CommandRules("max",4),new CommandRules("max",5)
                                                                                         ,new CommandRules("max",6),new CommandRules("max",7),new CommandRules("max",8)},createButtons(new String[]{"0","1","2","3","4","5","6","7","8"}));
        addTextWithComponent(sidePanel, "Nombre cellule max vie : "+data.createCellule, new CommandRules[]{new CommandRules("create",0),new CommandRules("create",1),new CommandRules("create",2)
                                                                                         ,new CommandRules("create",3),new CommandRules("create",4),new CommandRules("create",5)
                                                                                         ,new CommandRules("create",6),new CommandRules("create",7),new CommandRules("create",8)},createButtons(new String[]{"0","1","2","3","4","5","6","7","8"}));
        addTextWithComponent(sidePanel, "Couleur",new CommandColor[]{new CommandColor(Color.GREEN), new CommandColor(Color.RED), new CommandColor(Color.YELLOW), new CommandColor(Color.BLUE), new CommandColor(Color.ORANGE)}, createButtons(new String[]{"Green","Red","Yellow","Blue","Orange"}));

        addTextWithComponent(sidePanel,"Timer",null,createSlider());

        frame.add(panel, BorderLayout.CENTER);
        frame.add(sidePanel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void addTextWithComponent(JPanel panel, String text, Command[] command, JComponent... components) {
        JPanel subPanel = new JPanel();
        JLabel label = new JLabel(text);
        subPanel.add(label);
        for (int i = 0; i < components.length; i++) {
            if (components[i] instanceof JButton button) {
                int finalI = i;
                button.addActionListener(e -> command[finalI].execute());
            }
            subPanel.add(components[i]);
        }
        panel.add(subPanel);
    }


    /**
     * DESIGN PATTERN COMMANDE A IMPLEMENTER TODO
     */
    private static JButton[] createButtons(String[] texte) {
        JButton[] buttons = new JButton[texte.length];
        for (int i = 0; i < texte.length; i++) {
            buttons[i] = new JButton(texte[i]);
        }
        return buttons;
    }

    private static JSlider createSlider(){
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 5, Data.getInstance().time/1000);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setFont(new Font("Arial", Font.PLAIN, 14));
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                JSlider source = (JSlider) e.getSource();
                int value = source.getValue();
                Data.getInstance().time = value * 1000;
            }
        });
        return slider;
    }
}

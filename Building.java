package Citysimulator;

import javax.swing.ImageIcon;

public class Building {
    private String name;
    private ImageIcon imageIcon;
    private int cost;
    // happiness, energy, etc

    public Building(String name, String imagePath, int cost) {
        this.name = name;
        this.cost = cost;
        // add image scaling
        ImageIcon originalIcon = new ImageIcon(getClass().getResource(imagePath));
        this.imageIcon = new ImageIcon(originalIcon.getImage());
    }

    public String getName() {
        return this.name;
    }

    public ImageIcon getImageIcon() {
        return this.imageIcon;
    }

    public int getCost() {
        return this.cost;
    }

    public boolean build(Building[][] gameGrid, int row, int column) {
        // maybe add check for if row/column exist
        if (gameGrid[row][column] == null) {
            gameGrid[row][column] = this;
            return true;
        } else {
            System.out.println("Cell (" + row + ", " + column + ") is already occupied.");
            return false;
        }
    }

    public Building delete(Building[][] gameGrid, int row, int column) {
        Building removedBuilding = gameGrid[row][column];
        if (removedBuilding != null) {
            gameGrid[row][column] = null;
            return removedBuilding; //output deleted building
        } else {
            return null;
        }
    }
}

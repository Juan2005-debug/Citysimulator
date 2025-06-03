package com.Group57;

import java.awt.Color;

public abstract class Building {
    private final String name;
    //private ImageIcon imageIcon; uncomment for images
    private int cost;
    private final Color color = Color.BLACK;
    // happiness, energy, etc

    public Building(String name, String imagePath, int cost) {
        this.name = name;
        this.cost = cost;
        // add image scaling
        /* ImageIcon originalIcon = new ImageIcon(Objects.requireNonNull(getClass().getResource(imagePath)));
        this.imageIcon = new ImageIcon(originalIcon.getImage()); */
    }

    public String getName() {
        return this.name;
    }

/*     public ImageIcon getImageIcon() {
        return this.imageIcon;
    } */

    public int getCost() {
        return this.cost;
    }

    public Color getColor() {
            return this.color;
        }

    public abstract String getType(); //added to each specific building, can be useful later

    public boolean build(Building[][] gameGrid, int row, int column) {
        // maybe add check for if row/column exist
        if (row < 0 || row >= gameGrid.length || column < 0 || column >= gameGrid[0].length) {
            System.out.println("Build attempt outside grid boundaries.");
            return false;
        }
        if (gameGrid[row][column] == null) {
            gameGrid[row][column] = this; // 'this' will be the specific instance like new Shed()
            return true;
        } else {
            System.out.println("Cell (" + row + ", " + column + ") is already occupied.");
            return false;
        }
    }

    public Building delete(Building[][] gameGrid, int row, int column) {
        if (row < 0 || row >= gameGrid.length || column < 0 || column >= gameGrid[0].length) {
            System.out.println("Delete attempt outside grid boundaries.");
            return null;
        }
        Building removedBuilding = gameGrid[row][column];
        if (removedBuilding != null) {
            gameGrid[row][column] = null;
            return removedBuilding; //output deleted building
        } else {
            return null;
        }
    }
}

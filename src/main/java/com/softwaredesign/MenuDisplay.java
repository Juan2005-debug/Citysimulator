package com.softwaredesign;

import java.awt.*;
import javax.swing.*;

/**
 * Displays the menu with buttons in a grid formation in order to build or remove objects.
 */
public class MenuDisplay {
    //Use a panel for the menu
    static JPanel menuPanel = new JPanel();
    static GridBagConstraints gbc = new GridBagConstraints(); //Menu buttons go in a grid

    //Table for buttons in menu
    static MenuButton[][] MenuList = {
        {new ItemButton("happ.png", 0), new ItemButton("happ.png", 0), 
            new ItemButton("happ.png", 0)},
        {new WideButton("happ.png")}};
    
    /**
     * Create panel and add buttons.
     * @post panel is created, buttons are added in grid 
     */
    public MenuDisplay(int width, int height) {
        setMenuPanel(width, height);
        setGridLayout(5);
        addButtonsToMenu();
    }

    /**
     * Sets bounds for menuPanel. 
     * @param width  panel width in pixels
     * @param height panel height in pixels
     * @param x x coordinate in pixels
     * @param y y coordinate in pixels
     * @pre x, y, width and height are positive
     * //TODO: Setup handling of negative/zero numbers
     */
    static void setMenuPanel(int width, int height) {
        menuPanel.setPreferredSize(new Dimension(width, height));
    }

    /**
     * Makes the menuPanel a grid.
     * @param margin positive integer for margin in pixels around the buttons in grid
     * //TODO: setup negative 
     */
    static void setGridLayout(int margin) {
        menuPanel.setLayout(new GridBagLayout());
        gbc.insets = new Insets(margin, margin, margin, margin); // Margin around the component
    }

    /**
     * Add the buttons to the menu, by looping through all elements in MenuButton[][] table.
     */
    static void addButtonsToMenu() {
        for (int i = 0; i < MenuList.length; ++i) {
            for (int j = 0; j < MenuList[i].length; ++j) {
                MenuButton currentButton = MenuList[i][j];
                gbc.gridwidth = currentButton.width;
                gbc.gridx = j;
                gbc.gridy = i;
                
                currentButton.setPreferredSize(currentButton.getSize());
                menuPanel.add(currentButton, gbc);
            }
        }
    }


}

//Superclass for the menubuttons
class MenuButton extends JButton {
    public int width;
    public String imageAddress;
    public Boolean blank;

    /**
     * Constructor for the super calss MenuButton. 
     * @pre imageAdress is a valid path
     * @param imageAddress string containing the path to the image
     * TODO: Set up invalid adress handling
     */
    public MenuButton(String imageAddress) {
        this.width = 1;
        this.blank = false;
        this.setIcon(new ImageIcon(imageAddress));
        this.setSize(new Dimension(30, 30));
    }
}

//Wide button spanning the whole width of the menu, used for headers
class WideButton extends MenuButton{
    /**
     * Constructor setting width in grid to 3 and the dimensions so that it spans the whole menu.
     * @param imageAddress string containing the path to the image
     */
    public WideButton(String imageAddress) {
        super(imageAddress);
        this.width = 3;
        this.setSize(new Dimension(110, 30));
    }
}

class ItemButton extends MenuButton {
    public int cost;

    /**
     * Constructor setting up the image in the button.
     * @param imageAddress string containing path to the image
     * @param cost integer, cost of constructing the building
     */
    public ItemButton(String imageAddress, int cost) {
        super(imageAddress);
        this.cost = cost;
    }

}
class BlankButton extends MenuButton{
    int width;
    public BlankButton(int width){
        super("");
        this.width = width;
        this.blank = true;

    }
}

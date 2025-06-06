package com.Group57;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ImageManager {
    private static final String[] statImages = {"images/mn.png", "images/happ.png", "images/sc.png", "images/pops.png"};
    private static final ImageManager IM = new ImageManager();

    private static ImageIcon fIcon;
    private static ImageIcon hIcon;
    private static ImageIcon sIcon;
    private static ImageIcon pIcon;

    private static final int ICON_DIM = 32;

    /**
     * Constructor for the ImageManager class
     * @pre statImages contains valid image paths
     * @pre ICON_DIM is an integer
     * @post all ImageIcon variables are correctly scaled versions of the corresponding images
     * TODO: Set up rescaling for building images
     */
    private ImageManager() {
        for (int i = 0; i < statImages.length; i++) {
            ImageIcon Original = new ImageIcon( statImages[i] );
            Image Image = Original.getImage(); 
            Image ScaledImage = Image.getScaledInstance(ICON_DIM, ICON_DIM, Image.SCALE_SMOOTH);
            switch (i) {
                case 0 -> fIcon = new ImageIcon(ScaledImage);
                case 1 -> hIcon = new ImageIcon(ScaledImage);
                case 2 -> sIcon = new ImageIcon(ScaledImage);
                case 3 -> pIcon = new ImageIcon(ScaledImage);
            }
        }
    }

    /**
     * Returns the singleton object
     * @pre IM is an object of the class ImageManager
     * @return IM
     */
    public static ImageManager getIM() {
        return IM;
    }

    /**
     * Returns the Icon Dimensions for Stat icons
     * @pre ICON_DIM is an integer
     * @return ICON_DIM
     */
    public static int getIconDim() {
        return ICON_DIM;
    }

    /**
     * Returns the ImageIcon object for a requested corresponding stat
     * @param type letter representing corresponding stat
     * @pre all Icon variables are valid ImageIcon objects
     * @return corresponding ImageIcon object
     */
    public ImageIcon getStatIcon(String type) {
        return (
            switch (type) {
                case "f" -> fIcon;
                case "h" -> hIcon;
                case "s" -> sIcon;
                case "p" -> pIcon;
                default -> throw new IllegalArgumentException("Invalid icon type");
            }
        );
    }
}

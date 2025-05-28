package Citysimulator;

import java.awt.*;
import javax.swing.*;

public class ImageManager {
    private static final String[] statImages = {"mn.png", "happ.png", "sc.png", "pops.png"};
    private static final ImageManager IM = new ImageManager();

    private static ImageIcon fIcon;
    private static ImageIcon hIcon;
    private static ImageIcon sIcon;
    private static ImageIcon pIcon;

    private ImageManager() {
        for (int i = 0; i < statImages.length; i++) {
            ImageIcon Original = new ImageIcon( statImages[i] );
            Image Image = Original.getImage(); 
            Image ScaledImage = Image.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            switch (i) {
                case 0 -> fIcon = new ImageIcon(ScaledImage);
                case 1 -> hIcon = new ImageIcon(ScaledImage);
                case 2 -> sIcon = new ImageIcon(ScaledImage);
                case 3 -> pIcon = new ImageIcon(ScaledImage);
            }
        }
    }

    public static ImageManager getIM() {
        return IM;
    }

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

package src.main.java.com.softwaredesign;

import java.awt.Color;

public class Flat extends Building {
    public static final String FLAT_NAME = "Flat";
    public static final int FLAT_COST = 100;
    public static final Color FLAT_COLOR = new Color(173, 216, 230); // Light Blue

    public Flat() {
        super(FLAT_NAME, FLAT_COST, FLAT_COLOR);
    }

    @Override
    public String getType() {
        return "Flat";
    }
}
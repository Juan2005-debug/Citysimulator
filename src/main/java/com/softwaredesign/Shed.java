package src.main.java.com.softwaredesign;

import java.awt.Color;

public class Shed extends Building {
    public static final String SHED_NAME = "Shed";
    public static final int SHED_COST = 10;
    public static final Color SHED_COLOR = Color.YELLOW;
    public static 

    public Shed() {
        super(SHED_NAME, SHED_COST, SHED_COLOR);
    }

    @Override
    public String getType() {
        return "Shed";
    }
}
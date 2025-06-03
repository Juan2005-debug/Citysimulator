package src.main.java.com.softwaredesign;

import java.awt.Color;

public class Road extends Building {
    public static final String ROAD_NAME = "Road";
    public static final int ROAD_COST = 5;
    public static final Color ROAD_COLOR = Color.BLACK;

    public Road() {
        super(ROAD_NAME, ROAD_COST, ROAD_COLOR);
    }

    @Override
    public String getType() {
        return "Road";
    }
}
package com.softwaredesign;

import java.awt.Color;

public class House extends Building {
    public static final String HOUSE_NAME = "House";
    public static final int HOUSE_COST = 25;
    public static final Color HOUSE_COLOR = Color.ORANGE;

    public House() {
        super(HOUSE_NAME, HOUSE_COST, HOUSE_COLOR);
    }

    @Override
    public String getType() {
        return "House";
    }
}
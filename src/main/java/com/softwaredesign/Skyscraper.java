package com.softwaredesign;

import java.awt.Color;

public class Skyscraper extends Building {
    public static final String SKYSCRAPER_NAME = "Skyscraper";
    public static final int SKYSCRAPER_COST = 500;
    public static final Color SKYSCRAPER_COLOR = new Color(128, 0, 128); // Purple

    public Skyscraper() {
        super(SKYSCRAPER_NAME, SKYSCRAPER_COST, SKYSCRAPER_COLOR);
    }

    @Override
    public String getType() {
        return "Skyscraper";
    }
}
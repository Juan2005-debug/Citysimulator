package com.softwaredesign;

import java.awt.Color;

public class Villa extends Building {
    public static final String VILLA_NAME = "Villa";
    public static final int VILLA_COST = 50;
    public static final Color VILLA_COLOR = Color.RED;

    public Villa() {
        super(VILLA_NAME, VILLA_COST, VILLA_COLOR);
    }

    @Override
    public String getType() {
        return "Villa";
    }
}
package com.Group57;

import javax.swing.*;
import java.awt.Color;

public class House extends Building {
    public static final String HOUSE_NAME = "House";
    private static final String HOUSE_IMAGE_PATH = "images/house.png";
    public static final int HOUSE_COST = 25;
    public static final Color HOUSE_COLOR = Color.ORANGE;

    public House() {
        super(HOUSE_NAME, HOUSE_IMAGE_PATH, HOUSE_COST);
    }

    @Override
    public String getType() {
        return "House";
    }
}
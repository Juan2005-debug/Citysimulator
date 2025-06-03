package com.Group57;

import java.awt.*;
import javax.swing.*;

public class UIDisplay {
    private static JLabel fundsLabel;
    private static JLabel happinessLabel;
    private static JLabel securityLabel;
    private static JLabel populationLabel;

    private static ImageIcon fIcon;
    private static ImageIcon hIcon;
    private static ImageIcon sIcon;
    private static ImageIcon pIcon;

    private static int fundsStat;
    private static int fundsGain;
    private static int happinessStat;
    private static int securityStat;
    private static int populationStat;

    private static final Color UI_PANEL_COLOR = Color.LIGHT_GRAY;
    private static final String STAT_FONT = "Times New Roman";
    private static final int STAT_SIZE = 18;

    static JPanel UIPanel = new JPanel();

    /**
     * Constructor method for stats UI bar
     * @param uiHeight height of the UI bar
     * @param panelWidth width of the GUI window on startup
     * @param startup whether new game or not
     * @post stats are set if new game, then panel with all JLabels and icons is created
     */
    public UIDisplay(int uiHeight, int panelWidth, boolean startup) {
        if (startup) {
            fundsStat = 5000;
            fundsGain = 100;
            happinessStat = 0;
            securityStat = 0;
            populationStat = 0;
        }

        setDisplayPanel(uiHeight, panelWidth);
        displayStats(uiHeight, panelWidth);

    }


    /**
     * Create UI display panel
     * @param height height of the ui panel
     * @param width width of the ui panel
     * @post ui panel is created with specified dimensions and predetermined panel color
     */
    static void setDisplayPanel(int height, int width) {
        UIPanel.setLayout(null); 
        UIPanel.setPreferredSize(new Dimension(width, height)); 
        UIPanel.setBackground(UI_PANEL_COLOR);
    }
    
    /**
     * Creates the visual display of stats in the UI panel
     * @param uiHeight height of the ui panel
     * @param panelWidth width of the GUI window
     * @post Stat labels and icons are created and added to the UI panel
     */
    static void displayStats(int uiHeight, int panelWidth) {

        funds = new JLabel(Integer.toString(fundsStat) + '(' + Integer.toString(fundsGain) + ')', ImageManager.getIM().getStatIcon("f"), SwingConstants.LEFT);
        happiness = new JLabel(happinessStat + "%", ImageManager.getIM().getStatIcon("h"), SwingConstants.LEFT);
        security = new JLabel(securityStat + "%", ImageManager.getIM().getStatIcon("s"), SwingConstants.LEFT);
        population = new JLabel(populationStat + "%", ImageManager.getIM().getStatIcon("p"), SwingConstants.LEFT);


        JLabel[] labels = {funds, happiness, security, population};
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(( panelWidth * ( i + 1 ) / 5) - ImageManager.getIconDim(), ( uiHeight / 2 ) - ImageManager.getIconDim(), 150, 60 );
            labels[i].setFont(new Font(STAT_FONT, Font.BOLD, STAT_SIZE));
            UIPanel.add(labels[i]);
        }
    }

    static void updateStats() {

    }
}
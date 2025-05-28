package Citysimulator;

import java.awt.*;
import javax.swing.*;

public class UIDisplay {
    private static JLabel funds;
    private static JLabel happiness;
    private static JLabel security;
    private static JLabel population;

    private static int fundsStat;
    private static int fundsGain;
    private static int happinessStat;
    private static int securityStat;
    private static int populationStat;

    static JPanel UIPanel = new JPanel();

    public UIDisplay(int uiHeight, int panelWidth, boolean Startup) {
        if (Startup) {
            fundsStat = 5000;
            fundsGain = 100;
            happinessStat = 0;
            securityStat = 0;
            populationStat = 0;
        }

        setDisplayPanel(uiHeight, panelWidth);
        updateStats(uiHeight, panelWidth);

    }

    static void setDisplayPanel(int height, int width) {
        UIPanel.setLayout(null); 
        UIPanel.setPreferredSize(new Dimension(width, height)); 
        UIPanel.setBackground(Color.LIGHT_GRAY);
    }

    static void updateStats(int uiHeight, int panelWidth) {

        funds = new JLabel(Integer.toString(fundsStat) + '(' + Integer.toString(fundsGain) + ')', ImageManager.getIM().getStatIcon("f"), SwingConstants.LEFT);
        happiness = new JLabel(happinessStat + "%", ImageManager.getIM().getStatIcon("h"), SwingConstants.LEFT);
        security = new JLabel(securityStat + "%", ImageManager.getIM().getStatIcon("s"), SwingConstants.LEFT);
        population = new JLabel(populationStat + "%", ImageManager.getIM().getStatIcon("p"), SwingConstants.LEFT);


        JLabel[] labels = {funds, happiness, security, population};
        for (int i = 0; i < labels.length; i++) {
            labels[i].setBounds(( panelWidth * ( i + 1 ) / 5) - 32, ( uiHeight / 2 ) - 32, 150, 60 );
            labels[i].setFont(new Font("Times New Roman", Font.BOLD, 18));
            UIPanel.add(labels[i]);
        }

    }
}
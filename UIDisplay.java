package Citysimulator;

import java.awt.*;
import javax.swing.*;

public class UIDisplay {
    private static JLabel funds;
    private static JLabel happiness;
    private static JLabel security;
    private static JLabel population;

    private static ImageIcon fIcon;
    private static ImageIcon hIcon;
    private static ImageIcon sIcon;
    private static ImageIcon pIcon;

    private static int fundsStat;
    private static int fundsGain;
    private static int happinessStat;
    private static int securityStat;
    private static int populationStat;

    static JPanel UIPanel = new JPanel();

    public UIDisplay(int UIHeight, int PanelWidth, boolean Startup) {
        if (Startup) {
            fundsStat = 5000;
            fundsGain = 100;
            happinessStat = 0;
            securityStat = 0;
            populationStat = 0;
        }

        ImageIcon fundOriginal = new ImageIcon("Citysimulator\\mn.jpg");
        Image fImage =fundOriginal.getImage(); 
        Image fScaledImage = fImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        fIcon = new ImageIcon(fScaledImage);

        ImageIcon happinessOriginal = new ImageIcon("Citysimulator\\happ.jpg");
        Image hImage =happinessOriginal.getImage(); 
        Image hScaledImage = hImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        hIcon = new ImageIcon(hScaledImage);

        ImageIcon securityOriginal = new ImageIcon("Citysimulator\\sc.jpg");
        Image sImage = securityOriginal.getImage(); 
        Image sScaledImage = sImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        sIcon = new ImageIcon(sScaledImage);

        ImageIcon populationOriginal = new ImageIcon("Citysimulator/pops.jpg");
        Image pImage = populationOriginal.getImage(); 
        Image pScaledImage = pImage.getScaledInstance(32, 32, Image.SCALE_SMOOTH);
        pIcon = new ImageIcon(pScaledImage);

        funds = new JLabel(Integer.toString(fundsStat) + '(' + Integer.toString(fundsGain) + ')', fIcon, SwingConstants.LEFT);
        funds.setBounds((PanelWidth/5) - 32, (UIHeight/2) - 32, 150, 60);
        funds.setFont(new Font("Times New Roman", Font.BOLD, 18));
        happiness = new JLabel(happinessStat + "%", hIcon, SwingConstants.LEFT);
        happiness.setBounds(((PanelWidth*2)/5) - 32, (UIHeight/2) - 32, 150, 60);
        happiness.setFont(new Font("Times New Roman", Font.BOLD, 18));
        security = new JLabel(securityStat + "%", sIcon, SwingConstants.LEFT);
        security.setBounds(((PanelWidth*3)/5) - 32, (UIHeight/2) - 32, 150, 60);
        security.setFont(new Font("Times New Roman", Font.BOLD, 18));
        population = new JLabel(populationStat + "%", pIcon, SwingConstants.LEFT);
        population.setBounds(((PanelWidth*4)/5) - 32, (UIHeight/2) - 32, 150, 60);
        population.setFont(new Font("Times New Roman", Font.BOLD, 18));
        
        UIPanel.add(funds);
        UIPanel.add(happiness);
        UIPanel.add(security);
        UIPanel.add(population);
        

    }
}
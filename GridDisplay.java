package Citysimulator;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class GridDisplay { 

    private static final int GRID_ROWS = 15;  // # of grid rows
    private static final int GRID_COLS = 15;  // # of grid columns
    private static final int CELL_SIZE = 40; // Side dimension of cells
    private static final Color GRID_LINE_COLOR = Color.BLACK; // Color of grid lines 
    private static final int BUILDING_SELECTOR_WIDTH = 250; // Width of Side Building Selector Element
    private static final int UI_HEIGHT = 100; // Height of Upper UI Element
    private static final Color BACKGROUND_COLOR = Color.WHITE; // Background Color

    private static final Color DEFAULT_CELL_COLOR = Color.GREEN; // Default color for cells
    private static final Color CLICKED_CELL_COLOR = Color.ORANGE;   // Color for clicked cells

    private static final int PANEL_WIDTH = (GRID_COLS * CELL_SIZE) + BUILDING_SELECTOR_WIDTH; // width of window
    private static final int PANEL_HEIGHT = (GRID_ROWS * CELL_SIZE) + UI_HEIGHT;  // height of window

    static GridPanel mainPanel = new GridPanel(); 
    static JFrame frame = new JFrame("CitySim");

    public static Building selectedBuildingType = null;
    // buildings
    public static final Building HOUSE = new Building("House", "house.png", 100);
    public static final Building FACTORY = new Building("Factory", "factory.png", 500);
    public static final Building ROAD = new Building("Road", "road.png", 10);

    static class GridPanel extends JPanel {

        // private Color[][] cellColors; // Placeholder to contain cell state / can be used for savestates / change to an int or str matrix
        private Building[][] buildingGrid;  // 2D array to store buildings

        public GridPanel() {
            setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
            setBackground(BACKGROUND_COLOR);

            buildingGrid = new Building[GRID_ROWS][GRID_COLS];

            // Initialize cell colors
//            cellColors = new Color[GRID_ROWS][GRID_COLS];
//            for (int r = 0; r < GRID_ROWS; r++) {
//                for (int c = 0; c < GRID_COLS; c++) {
//                    cellColors[r][c] = DEFAULT_CELL_COLOR; // All cells start with default color
//                }
//            }

            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Calculate which cell was clicked
                    int clickedCol = e.getX() / CELL_SIZE;
                    int clickedRow = (e.getY() - UI_HEIGHT) / CELL_SIZE;

                    // Check if the click is within the grid boundaries
                    if (clickedRow >= 0 && clickedRow < GRID_ROWS &&
                        clickedCol >= 0 && clickedCol < GRID_COLS) {

                        System.out.println("Clicked cell: Row " + clickedRow + ", Col " + clickedCol);

                        if (selectedBuildingType != null) {
                            boolean built = selectedBuildingType.build(buildingGrid, clickedRow, clickedCol);
                            if (built) {
                                System.out.println("Successfully placed " + selectedBuildingType.getName());
                                // deduct cost
                            } else {
                                System.out.println("Failed to place " + selectedBuildingType.getName());
                                // cell occupied, broke ahh, etc
                            }
                        } else {
                            // no building selected while clicking, maybe for selection/viewing
                            if (buildingGrid[clickedRow][clickedCol] != null) {
                                // for now just delete
                                Building buildingToDelete = buildingGrid[clickedRow][clickedCol];
                                Building deleted = buildingToDelete.delete(buildingGrid, clickedRow, clickedCol);
                                if (deleted != null) {
                                    System.out.println("Deleted " + deleted.getName());
                                    // refund cost
                                }
                            } else {
                                System.out.println("Cell is empty, nothing to delete or inspect.");
                            }
                        }

                        repaint();


                        // --- CLICK LOGIC HERE / REPLACE RECOLORING / CREATE CONSTRUCTOR CLASS  ---

//                        if (cellColors[clickedRow][clickedCol].equals(DEFAULT_CELL_COLOR)) {
//                            cellColors[clickedRow][clickedCol] = CLICKED_CELL_COLOR;
//                        } else {
//                            cellColors[clickedRow][clickedCol] = DEFAULT_CELL_COLOR;
//                        }
                    }
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); // Clears the panel with its background color

            Graphics2D g2d = (Graphics2D) g;

            for (int r = 0; r < GRID_ROWS; r++) {
                for (int c = 0; c < GRID_COLS; c++) {
                    Building building = buildingGrid[r][c];
                    if (building != null && building.getImageIcon() != null) {
                        g2d.drawImage(building.getImageIcon().getImage(),
                                c * CELL_SIZE,
                                (r * CELL_SIZE) + UI_HEIGHT,
                                CELL_SIZE, CELL_SIZE, this);
                    } else {
                        // no building on cell
                        g2d.setColor(DEFAULT_CELL_COLOR);
                        g2d.fillRect(c * CELL_SIZE, (r * CELL_SIZE) + UI_HEIGHT, CELL_SIZE, CELL_SIZE);
                    }
                }
            }

//            // 1. Fill cells with their current colors
//            for (int r = 0; r < GRID_ROWS; r++) {
//                for (int c = 0; c < GRID_COLS; c++) {
//                    g2d.setColor(cellColors[r][c]);
//                    g2d.fillRect(c * CELL_SIZE, (r * CELL_SIZE) + UI_HEIGHT, CELL_SIZE, CELL_SIZE);
//                }
//            }

            // 2. Draw grid lines on top
            g2d.setColor(GRID_LINE_COLOR);
            // Draw horizontal lines
            for (int i = 0; i <= GRID_ROWS; i++) {
                int y = i * CELL_SIZE;
                g2d.drawLine(0, y + UI_HEIGHT, PANEL_WIDTH-BUILDING_SELECTOR_WIDTH, y + UI_HEIGHT);
            }
            // Draw vertical lines
            for (int j = 0; j <= GRID_COLS; j++) {
                int x = j * CELL_SIZE;
                g2d.drawLine(x, UI_HEIGHT, x, PANEL_HEIGHT);
            }
        }
    }

    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(() -> {
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            mainPanel.setLayout(new BorderLayout());

            MenuDisplay menu = new MenuDisplay();
            mainPanel.add(menu.menuPanel, BorderLayout.EAST);

            UIDisplay ui = new UIDisplay(UI_HEIGHT, PANEL_WIDTH, true);
            mainPanel.add(ui.UIPanel, BorderLayout.NORTH);

            frame.setContentPane(mainPanel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            // FOR TESTING, implement with menudisplay buttons later
            GridDisplay.selectedBuildingType = GridDisplay.HOUSE;
        });
    }
}

package com.tigerbuddha.sudoku;

import javax.swing.*;
import java.awt.*;


/**
 * Created by shanthan on 7/19/14.
 */
public class GridPanel extends JPanel {

    public static final int GRID_PANEL_WIDTH = 450;
    private static final long serialVersionUID = 0;
    public static boolean doGenerate;
    private JButton f[][] = new JButton[9][9];
    private JPanel p[][] = new JPanel[3][3];


    public GridPanel(int[][] guiGrid) {


        setSize(GRID_PANEL_WIDTH, 450);
        createGridPanel(guiGrid);
        setVisible(true);


    }

    public void changeText(int[][] guiGrid) {

        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                f[x][y].setText(Integer.toString(guiGrid[x][y]));
            }
        }

        repaint();
    }


    public void createGridPanel(int[][] guiGrid) {


        for (int x = 0; x <= 8; x++) {
            for (int y = 0; y <= 8; y++) {
                f[x][y] = new JButton();
                f[x][y].setText(Integer.toString(guiGrid[x][y]));

            }
        }

        for (int x = 0; x <= 2; x++) {
            for (int y = 0; y <= 2; y++) {
                p[x][y] = new JPanel(new GridLayout(3, 3));
            }
        }

        setLayout(new GridLayout(3, 3, 5, 5));


        for (int u = 0; u <= 2; u++) {
            for (int i = 0; i <= 2; i++) {
                for (int x = 0; x <= 2; x++) {
                    for (int y = 0; y <= 2; y++) {
                        p[u][i].add(f[y + u * 3][x + i * 3]);
                    }
                }
                add(p[u][i]);

            }
        }


    }

}

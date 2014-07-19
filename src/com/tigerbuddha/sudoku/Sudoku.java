package com.tigerbuddha.sudoku;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Created by Tiger Buddha on 7/19/2014.
 */
public class Sudoku extends JFrame {


    public static int userGrid[][] = new int[][]{
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,},
            {0, 0, 0, 0, 0, 0, 0, 0, 0,}
    };
    public static int grid[][] = new int[9][9]; // the grid that the program experiments on
    public static int guiGrid[][] = new int[9][9];
    public static boolean doGenerate;
    private static GridPanel gp;
    private static Sidepanel sp;
    private static Sudoku s;
    public int frameWidth = Sidepanel.SIDE_PANEL_WIDTH + GridPanel.GRID_PANEL_WIDTH;
    Scanner scanner = new Scanner(System.in);

//Constructor

    public Sudoku() {


        super("Sudoku");


        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
        }


        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(frameWidth, 480);
        setResizable(false);


        this.gp = new GridPanel(guiGrid);
        this.sp = new Sidepanel();

        add(gp, BorderLayout.CENTER);
        add(sp, BorderLayout.EAST);

        this.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {


                    case KeyEvent.VK_G:
                        doGenerate = true;
                        break;


                }
            }

        });

        setLocationRelativeTo(null);
        setVisible(true);

        doGenerate = true;

        if (doGenerate) {

            copyGrid(userGrid, grid);

            print(grid);

            print(loop(0, 0, grid));

            gp.changeText(grid);


        }
        System.out.println(doGenerate);


    }

    public static void main(String[] args) {

        s = new Sudoku();

    }


    public static int[][] loop(int y, int x, int[][] grid) {

        // goes through each one and checks if it is less than 9
        // now is it valid
        // go next

        while (!validity(8, 8, grid) || grid[8][8] == 0) { // While not solved
            if (grid[y][x] < 9) {
                grid[y][x]++;
                if (validity(y, x, grid)) {

                    //print(grid);

                    int yy, xx;
                    if (x == 8) {
                        yy = y + 1;
                        xx = 0;
                    } else {
                        yy = y;
                        xx = x + 1;
                    }
                    loop(yy, xx, grid);
                }
            } else {
                grid[y][x] = 0;
                break;
            }
        }

        return grid;
    }

    public static boolean validity(int x, int y, int[][] grid) {
        //Are there more than one of these in row, column or square
        String temp = "";
        for (int i = 0; i < 9; i++) {
            temp += Integer.toString(grid[i][y]); //Horizontal
            temp += Integer.toString(grid[x][i]); //Vertical
            temp += Integer.toString(grid[(x / 3) * 3 + i / 3][(y / 3) * 3 + i % 3]); //Square : We are using narrowing
        }

        int count = 0, idx = 0;

        while ((idx = temp.indexOf(Integer.toString(grid[x][y]), idx)) != -1) {
            idx++;
            count++;
        }
        return count == 3;
    }

    public static void print(int[][] grid) {
        System.out.println();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(grid[i][j]);
                System.out.print(" ");
                if (j == 2 || j == 5) {
                    System.out.print("| ");

                }
            }
            System.out.println();
            if (i == 2 || i == 5) {
                System.out.println("---------------------");
            }

        }
        System.out.println();
    }

    public static void copyGrid(int[][] inputGrid, int[][] outputGrid) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                outputGrid[i][j] = inputGrid[i][j];
            }
        }

    }


}

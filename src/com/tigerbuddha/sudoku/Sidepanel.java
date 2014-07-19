package com.tigerbuddha.sudoku;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by shanthan on 7/19/14.
 */
public class Sidepanel extends JPanel {


    public static final int SIDE_PANEL_WIDTH = 100;

    JPanel sidePanel = new JPanel();
    JButton generate = new JButton("GENERATE");


    public Sidepanel() {


        setSize(SIDE_PANEL_WIDTH, 450);

        sidePanel.add(generate, BorderLayout.CENTER);
        add(sidePanel);

        generate.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e
            ) {
                Sudoku.doGenerate = true;
            }
        });


        setVisible(true);

    }

}

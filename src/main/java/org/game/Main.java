package org.game;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RockPaperScissor rockPaperScissor = new RockPaperScissor();
                rockPaperScissor.setVisible(true);
            }
        });
    }
}
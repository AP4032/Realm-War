package org.realm_war;

import org.realm_war.Views.GameFrame;

import javax.swing.*;

public class Launcher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(GameFrame::new);
    }
}

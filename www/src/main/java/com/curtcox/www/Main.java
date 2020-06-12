package com.curtcox.www;

import javax.swing.*;
import java.awt.*;

class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> showGui() );
    }

    static void showGui() {
        JFrame frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new App());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}
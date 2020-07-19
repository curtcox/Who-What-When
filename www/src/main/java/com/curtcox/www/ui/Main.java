package com.curtcox.www.ui;

import com.curtcox.www.data.Edges;
import com.curtcox.www.model.Graph;

import javax.swing.*;
import java.awt.*;

class Main {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> showGui() );
    }

    static final Graph graph = buildGraph();

    static Graph buildGraph() {
        var builder = Graph.builder();
        for (var edge : Edges.edges()) {
            builder = builder.edge(edge);
        }
        return builder.build();
    }

    static void showGui() {
        JFrame frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new App(graph));
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}
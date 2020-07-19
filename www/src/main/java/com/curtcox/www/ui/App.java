package com.curtcox.www.ui;

import com.curtcox.www.model.Graph;

import javax.swing.JPanel;
import java.util.List;
import java.util.stream.Collectors;

final class App extends JPanel {

    App(Graph graph) {
        List<Row> rows = graph.nodes
                .stream()
                .map(n -> Row.at(n))
                .sorted()
                .collect(Collectors.toList());
        var at = rows.iterator().next();
        add(AppPanel.at(at));
    }

}
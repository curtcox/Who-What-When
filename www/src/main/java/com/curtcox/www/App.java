package com.curtcox.www;

import javax.swing.JPanel;
import java.util.List;
import java.util.stream.Collectors;

class App extends JPanel {

    App() {
        List rows = Data.graph.nodes
                .stream()
                .map(n -> Row.of(n))
                .collect(Collectors.toList());
        add(AppPanel.fromRows(rows));
    }

}
package com.curtcox.www;

import javax.swing.JPanel;
import java.util.List;
import java.util.stream.Collectors;

class App extends JPanel {

    App() {
        List<Row> rows = Data.graph.nodes
                .stream()
                .map(n -> Row.at(n))
                .collect(Collectors.toList());
        var at = rows.iterator().next();
        add(AppPanel.at(at));
    }

}
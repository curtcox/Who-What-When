package com.curtcox.www;

import com.curtcox.www.data.Data;
import com.curtcox.www.model.Graph;

import javax.swing.JPanel;
import java.util.List;
import java.util.stream.Collectors;

class App extends JPanel {

    static final Graph graph = buildGraph();

    App() {
        List<Row> rows = graph.nodes
                .stream()
                .map(n -> Row.at(n))
                .collect(Collectors.toList());
        var at = rows.iterator().next();
        add(AppPanel.at(at));
    }

    static Graph buildGraph() {
        var builder = Graph.builder();
        for (var edge : Data.edges()) {
            builder = builder.edge(edge);
        }
        return builder.build();
    }


}
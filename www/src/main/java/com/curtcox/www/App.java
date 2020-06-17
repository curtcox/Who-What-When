package com.curtcox.www;

import javax.swing.JPanel;
import java.util.List;
import java.util.stream.Collectors;

class App extends JPanel {

    final Graph graph = Graph.builder()
            .nodes("me","my wife","my son","my daughter")
            .build();

    App() {
        List rows = graph.nodes
                .stream()
                .map(n -> Row.of(n))
                .collect(Collectors.toList());
        add(AppTable.fromRows(rows));
    }

//    String[] columnNames = {"Picture", "Text"};
//    Object[][] data = {
//            {icon("http://placekitten.com/100/200"), "Text 1"},
//            {icon("http://placekitten.com/100/200"), "Text 2"},
//            {icon("http://placekitten.com/100/200"), "Text 3"},
//    };

}
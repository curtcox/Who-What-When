package com.curtcox.www.ui;

import com.curtcox.www.model.*;

import java.util.Collection;
import java.util.stream.Collectors;

abstract class Row {

    abstract Node getValueAt(int columnIndex);
    abstract String[] columnNames();
    abstract AppTableModel asAppTableModel();

    static Row at(Node node) { return new NodeRow(node); }

    static Row from(Node node, Edge edge) {
        if (node==edge.to) {
            return new EdgeRow(edge.from,edge.via);
        }
        return node == edge.via ? new EdgeRow(edge.from,edge.to) : new EdgeRow(edge.via,edge.to);
    }

    static AppTableModel toAppTableModel(Node node) {
        return AppTableModel.fromRows(rows(node));
    }

    private static Collection<Row> rows(Node node) {
        return App.graph
                .getEdges(node)
                .stream()
                .map(e -> Row.from(node,e))
                .distinct()
                .collect(Collectors.toList());
    }

    //    String[] columnNames = {"Picture", "Text"};
//    Object[][] data = {
//            {icon("http://placekitten.com/100/200"), "Text 1"},
//            {icon("http://placekitten.com/100/200"), "Text 2"},
//            {icon("http://placekitten.com/100/200"), "Text 3"},
//    };

//    private static ImageIcon icon(String url) {
//        try {
//            return new ImageIcon(new URL(url));
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }

}

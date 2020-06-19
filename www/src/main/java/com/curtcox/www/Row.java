package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.stream.Collectors;

abstract class Row {

    abstract Object getValueAt(int columnIndex);
    abstract String[] columnNames();
    abstract AppTableModel asAppTableModel();

    static Row of(Node node) { return new NodeRow(node); }
    static Row of(Edge edge) { return new EdgeRow(edge); }

    private static class NodeRow extends Row {

        final Node node;

        public NodeRow(Node node) {
          this.node = node;
        }

        @Override Object getValueAt(int columnIndex) { return node.name; }
        @Override String[] columnNames()             { return new String[] {"name"}; }
        @Override AppTableModel asAppTableModel() {
            return AppTableModel.fromRows(rows());
        }
        @Override public String toString()           { return node.toString(); }
        Collection<Row> rows() {
            return Data.graph
                    .getEdges(node)
                    .stream()
                    .map(e -> Row.of(e.to))
                    .collect(Collectors.toList());
        }
    }

    private static class EdgeRow extends Row {

        final Edge edge;

        public EdgeRow(Edge edge) {
            this.edge = edge;
        }

        @Override Object getValueAt(int columnIndex) { return columnIndex == 0 ? edge.via : edge.to; }
        @Override String[] columnNames()             { return new String[] {"via","to"}; }
        @Override AppTableModel asAppTableModel() {
            return AppTableModel.fromRows(rows());
        }
        @Override public String toString()           { return edge.toString(); }
        Collection<Row> rows() {
            throw new IllegalArgumentException();
        }
    }



    //    String[] columnNames = {"Picture", "Text"};
//    Object[][] data = {
//            {icon("http://placekitten.com/100/200"), "Text 1"},
//            {icon("http://placekitten.com/100/200"), "Text 2"},
//            {icon("http://placekitten.com/100/200"), "Text 3"},
//    };

    private static ImageIcon icon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

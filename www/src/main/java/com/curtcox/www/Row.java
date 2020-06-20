package com.curtcox.www;

import java.util.Collection;
import java.util.stream.Collectors;

abstract class Row {

    abstract Row primarySelection();
    abstract Object getValueAt(int columnIndex);
    abstract String[] columnNames();
    abstract AppTableModel asAppTableModel();

    static Row at(Node node) { return new NodeRow(node); }

    static Row from(Node node, Edge edge) {
        var other = edge.to == node ? edge.from : edge.to;
        return new EdgeRow(edge.via,other);
    }

    private static class NodeRow extends Row {

        final Node node;

        NodeRow(Node node) {
          this.node = node;
        }

        @Override Row primarySelection()             { return Row.at(node); }
        @Override Object getValueAt(int columnIndex) { return node.name; }
        @Override String[]          columnNames()    { return new String[] {"name"}; }
        @Override AppTableModel asAppTableModel()    { return toAppTableModel(node); }
        @Override public String toString()           { return node.toString(); }
    }

    private static class EdgeRow extends Row {

        final Node via;
        final Node other;

        EdgeRow(Node via, Node other) {
            this.via = via;
            this.other = other;
        }

        @Override Row primarySelection()             { return Row.at(other); }
        @Override Object getValueAt(int columnIndex) { return columnIndex == 0 ? via : other; }
        @Override String[]          columnNames()    { return new String[] {"via","to"}; }
        @Override AppTableModel asAppTableModel()    { return toAppTableModel(other); }
        @Override public String toString()           { return via + other.toString(); }
        @Override public int hashCode()              { return other.hashCode();}
        @Override public boolean equals(Object o) {
            EdgeRow that = (EdgeRow) o;
            return via == that.via && other == that.other;
        }
    }

    private static AppTableModel toAppTableModel(Node node) {
        return AppTableModel.fromRows(rows(node));
    }

    private static Collection<Row> rows(Node node) {
        return Data.graph
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

package com.curtcox.www;

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

    private static class NodeRow extends Row {

        final Node node;

        NodeRow(Node node) {
          this.node = node;
        }

        @Override Node getValueAt(int columnIndex)   { return node; }
        @Override String[]          columnNames()    { return new String[] {"name"}; }
        @Override AppTableModel asAppTableModel()    { return toAppTableModel(node); }
        @Override public String toString()           { return node.toString(); }
    }

    private static class EdgeRow extends Row {

        final Node left;
        final Node right;

        EdgeRow(Node left, Node right) {
            this.left = left;
            this.right = right;
        }

        @Override Node getValueAt(int columnIndex)   { return columnIndex == 0 ? left : right; }
        @Override String[]          columnNames()    { return new String[] {"via","to"}; }
        @Override AppTableModel asAppTableModel()    { return toAppTableModel(right); }
        @Override public String toString()           { return left + right.toString(); }
        @Override public int hashCode()              { return right.hashCode();}
        @Override public boolean equals(Object o) {
            EdgeRow that = (EdgeRow) o;
            return left == that.left && right == that.right;
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

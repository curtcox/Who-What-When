package com.curtcox.www.ui;

import com.curtcox.www.model.*;

import java.util.Collection;
import java.util.stream.Collectors;

abstract class Row implements Comparable<Row> {

    abstract Node getValueAt(int columnIndex);
    abstract String[] columnNames();
    abstract AppTableModel asAppTableModel();
    abstract int getHeight();

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
        return node
                .getEdges()
                .stream()
                .map(e -> Row.from(node,e))
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public int compareTo(Row that) {
        return toString().compareTo(that.toString());
    }

}

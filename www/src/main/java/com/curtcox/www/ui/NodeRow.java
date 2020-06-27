package com.curtcox.www.ui;

import com.curtcox.www.model.Node;

final class NodeRow extends Row {

    final Node node;

    NodeRow(Node node) {
      this.node = node;
    }

    @Override Node getValueAt(int columnIndex)   { return node; }
    @Override String[]          columnNames()    { return new String[] {"name"}; }
    @Override AppTableModel asAppTableModel()    { return toAppTableModel(node); }
    @Override public String toString()           { return node.toString(); }

}

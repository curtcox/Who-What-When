package com.curtcox.www.ui;

import com.curtcox.www.model.Node;

final class EdgeRow extends Row {

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
    @Override public int    hashCode()           { return right.hashCode(); }
                     int   getHeight()           { return Math.max(left.getHeight(),right.getHeight()); }

    @Override public boolean equals(Object o) {
        EdgeRow that = (EdgeRow) o;
        return left == that.left && right == that.right;
    }

}

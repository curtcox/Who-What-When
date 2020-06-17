package com.curtcox.www;

abstract class Row {

    public static Object of(Node n) {
        return new Row() {
            @Override
            Object getValueAt(int columnIndex) {
                return n.name;
            }
        };
    }

    abstract Object getValueAt(int columnIndex);

}

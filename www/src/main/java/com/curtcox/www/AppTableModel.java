package com.curtcox.www;

import javax.swing.*;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.net.MalformedURLException;
import java.net.URL;

class AppTableModel implements TableModel {

    String[] columnNames = {"Picture", "Text"};
    Object[][] data = {
            {icon("http://placekitten.com/100/200"), "Text 1"},
            {icon("http://placekitten.com/100/200"), "Text 2"},
            {icon("http://placekitten.com/100/200"), "Text 3"},
    };

    private static ImageIcon icon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static TableModel tableModel() {
        return new AppTableModel();
    }

    @Override public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

    @Override public int     getRowCount()                 { return data.length; }
    @Override public int     getColumnCount()              { return columnNames.length; }

    @Override public String getColumnName(int columnIndex) { return columnNames[columnIndex]; }
    @Override public Class<?> getColumnClass(int column)   { return getValueAt(0, column).getClass(); }

    @Override public Object getValueAt(int rowIndex, int columnIndex) { return data[rowIndex][columnIndex]; }
    @Override public void   setValueAt(Object aValue, int rowIndex, int columnIndex) { never(); }

    @Override public void    addTableModelListener(TableModelListener l) { }
    @Override public void removeTableModelListener(TableModelListener l) { }

    private void never() {
        throw new UnsupportedOperationException();
    }
}

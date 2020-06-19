package com.curtcox.www;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

final class AppTableModel implements TableModel {

    final List<Row> rows;
    final String[] columnNames;

    AppTableModel(Collection<Row> rows) {
        this.rows = new ArrayList(rows);
        columnNames = this.rows.get(0).columnNames();
    }

    static TableModel fromRows(Collection<Row> rows) {
        return new AppTableModel(rows);
    }

    @Override public boolean isCellEditable(int rowIndex, int columnIndex) { return false; }

    @Override public int     getRowCount()                 { return rows.size(); }
    @Override public int     getColumnCount()              { return columnNames.length; }

    @Override public String getColumnName(int columnIndex) { return columnNames[columnIndex]; }
    @Override public Class<?> getColumnClass(int column)   { return getValueAt(0, column).getClass(); }

    @Override public Object getValueAt(int rowIndex, int columnIndex) {
        return rows.get(rowIndex).getValueAt(columnIndex);
    }
    @Override public void   setValueAt(Object aValue, int rowIndex, int columnIndex) { never(); }

    @Override public void    addTableModelListener(TableModelListener l) { }
    @Override public void removeTableModelListener(TableModelListener l) { }

    private void never() {
        throw new UnsupportedOperationException();
    }
}

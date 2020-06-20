package com.curtcox.www;

import javax.swing.*;

final class AppTable extends JTable {

    RowSelectionListener listener;

    private AppTable() {}

    static AppTable empty() {
        var table = new AppTable();
        table.setModel(AppTableModel.empty());
        table.setRowHeight(50);
        table.addListSelectionListener();
        return table;
    }

    private void addListSelectionListener() {
        getSelectionModel().addListSelectionListener(event -> {
            Row row = getSelectedRowObject();
            if (row!=null) {
                listener.onRowSelected(row);
            }
        });
    }

    private Row getSelectedRowObject() {
        int row = getSelectedRow();
        return row < 0 ? null : appTableModel().getRow(row);
    }

    private AppTableModel appTableModel() {
        return (AppTableModel) getModel();
    }

}

package com.curtcox.www;

import javax.swing.*;
import java.util.Collection;

final class AppTable extends JTable {

    interface RowSelectionListener {
        void onRowSelected(Row row);
    }

    RowSelectionListener listener;

    private AppTable() {}

    static AppTable fromRows(Collection<Row> rows) {
        var table = new AppTable();
        var model = AppTableModel.fromRows(rows);
        table.setModel(model);
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
        return row < 0 ? null : appTableModel().rows.get(row);
    }

    private AppTableModel appTableModel() {
        return (AppTableModel) getModel();
    }

}

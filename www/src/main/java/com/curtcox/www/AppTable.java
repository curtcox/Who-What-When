package com.curtcox.www;

import javax.swing.*;
import java.util.Collection;

final class AppTable extends JTable {

    interface RowSelectionListener {
        void onRowSelected(Row row);
    }

    private final RowSelectionListener listener;

    private AppTable(RowSelectionListener listener) {
        this.listener = listener;
    }

    static AppTable fromRows(Collection<Row> rows,RowSelectionListener listener) {
        var table = new AppTable(listener);
        var model = AppTableModel.fromRows(rows);
        table.setModel(model);
        table.setRowHeight(50);
        table.addListSelectionListener();
        return table;
    }

    private void addListSelectionListener() {
        getSelectionModel().addListSelectionListener(event -> listener.onRowSelected(getSelectedRowObject()));
    }

    private Row getSelectedRowObject() {
        return appTableModel().rows.get(getSelectedRow());
    }

    private AppTableModel appTableModel() {
        return (AppTableModel) getModel();
    }

}

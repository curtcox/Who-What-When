package com.curtcox.www;

import javax.swing.*;
import java.util.Collection;

final class AppTable extends JTable {

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
            System.out.println(getSelectedRowObject());
        });
    }

    private Row getSelectedRowObject() {
        return appTableModel().rows.get(getSelectedRow());
    }

    private AppTableModel appTableModel() {
        return (AppTableModel) getModel();
    }

}

package com.curtcox.www.ui;

import com.curtcox.www.model.Node;

import javax.swing.*;

final class AppTable extends JTable {

    RowSelectionListener listener;

    private AppTable() {}

    static AppTable empty() {
        var table = new AppTable();
        table.setModel(AppTableModel.empty());
        table.setRowHeight(50);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setTableHeader(null);
        table.addListSelectionListener();
        return table;
    }

    private void addListSelectionListener() {
        getSelectionModel().addListSelectionListener(event -> {
            Node node = getSelectedNode();
            if (node!=null) {
                listener.onNodeSelected(node);
            }
        });
    }

    private Node getSelectedNode() {
        int row = getSelectedRow();
        int col = getSelectedColumn();
        boolean invalidSelection = row < 0 || col < 0;
        return invalidSelection ? null : appTableModel().getValueAt(row,col);
    }

    private AppTableModel appTableModel() {
        return (AppTableModel) getModel();
    }

}

package com.curtcox.www.ui;

import com.curtcox.www.model.Node;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import java.awt.*;

final class AppTable extends JTable {

    RowSelectionListener listener;

    private AppTable() {}

    static AppTable empty() {
        var table = new AppTable();
        table.setModel(AppTableModel.empty());
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        table.setColumnSelectionAllowed(true);
        table.setRowSelectionAllowed(true);
        table.setCellSelectionEnabled(true);
        table.setTableHeader(null);
        table.addListSelectionListener();
        table.setDefaultRenderer(Node.class, new NodeRenderer());
        return table;
    }

    @Override
    public void setModel(TableModel model) {
        super.setModel(model);
        if (model instanceof  AppTableModel) {
            setAppTableModel((AppTableModel) model);
        }
    }

    private void setAppTableModel(AppTableModel model) {
        for (int row=0; row<model.getRowCount(); row++) {
            super.setRowHeight(row,model.getRowHeight(row));
        }
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

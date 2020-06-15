package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;

class AppTable {

    static JTable newInstance() {
        TableModel model = AppTableModel.tableModel();
        JTable table = new JTable(model);

        configureTable(model, table);

        return table;
    }

    private static void configureTable(TableModel model, JTable table) {
        table.setPreferredSize(new Dimension(500, 500));
        table.getColumn(model.getColumnName(0)).setPreferredWidth(100);
        table.getColumn(model.getColumnName(1)).setPreferredWidth(400);
        table.setRowHeight(100);
    }

}
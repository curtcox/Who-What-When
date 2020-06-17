package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.util.Collection;

class AppTable extends JPanel {

    JScrollPane scroll;
    JTable table;
    JButton forward = new JButton(">");
    JButton back = new JButton("<");

    AppTable(JTable table) {
        this.table = table;
        scroll = new JScrollPane(table);
        setLayout(new BorderLayout());
        var buttons = new JPanel();
        buttons.add(back);
        buttons.add(forward);
        add(buttons, BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
    }

    static AppTable fromRows(Collection<Row> rows) {
        TableModel model = AppTableModel.fromRows(rows);
        JTable table = new JTable(model);
        configureTable(model, table);
        return new AppTable(table);
    }

    private static void configureTable(TableModel model, JTable table) {
        table.setPreferredSize(new Dimension(500, 500));
        table.getColumn(model.getColumnName(0)).setPreferredWidth(100);
        table.getColumn(model.getColumnName(1)).setPreferredWidth(400);
        table.setRowHeight(100);
    }

}

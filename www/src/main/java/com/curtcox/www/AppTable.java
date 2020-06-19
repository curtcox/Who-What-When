package com.curtcox.www;

import javax.swing.*;
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
        table.setRowHeight(50);
    }

    static AppTable fromRows(Collection<Row> rows) {
        return new AppTable(new JTable(AppTableModel.fromRows(rows)));
    }

}

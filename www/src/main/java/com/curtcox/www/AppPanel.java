package com.curtcox.www;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

final class AppPanel extends JPanel {

    final JScrollPane scroll;
    final AppTable table;
    final JButton forward = new JButton(">");
    final JButton back = new JButton("<");

    private AppPanel(AppTable table) {
        this.table = table;
        scroll = new JScrollPane(table);
        setLayout(new BorderLayout());
        var buttons = new JPanel();
        buttons.add(back);
        buttons.add(forward);
        add(buttons, BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
    }

    static AppPanel fromRows(Collection<Row> rows) {
        return new AppPanel(AppTable.fromRows(rows, row -> System.out.println(row)));
    }

}

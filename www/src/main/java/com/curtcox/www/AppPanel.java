package com.curtcox.www;

import javax.swing.*;
import java.awt.*;

final class AppPanel extends JPanel
    implements RowSelectionListener
{

    final JScrollPane scroll;
    final AppTable table;
    final JButton forward = new JButton(">");
    final JButton back = new JButton("<");
    final JButton at = new JButton();

    private AppPanel(AppTable table) {
        this.table = table;
        scroll = new JScrollPane(table);
        setLayout(new BorderLayout());
        var buttons = new JPanel();
        buttons.add(back);
        buttons.add(forward);
        buttons.add(at);
        add(buttons, BorderLayout.NORTH);
        add(scroll,BorderLayout.CENTER);
    }

    static AppPanel at(Row row) {
        var table = AppTable.empty();
        var panel = new AppPanel(table);
        panel.setAtRow(row);
        table.listener = panel;
        return panel;
    }

    @Override public void onRowSelected(Row row) {
        setAtRow(row.primarySelection());
    }

    private void setAtRow(Row row) {
        at.setText(row.toString());
        table.setModel(row.asAppTableModel());
    }

}

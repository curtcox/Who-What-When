package com.curtcox.www;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

final class AppPanel extends JPanel
    implements RowSelectionListener
{

    final JScrollPane scroll;
    final AppTable table;
    final JButton forward = new JButton(">");
    final JButton back = new JButton("<");
    final JButton at = new JButton();
    final List<Row> history = new ArrayList<>();
    int historyIndex;

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
        panel.addListeners();
        panel.goForwardTo(row);
        return panel;
    }

    private void addListeners() {
        table.listener = this;
        forward.addActionListener(e -> onForwardButton());
        back.addActionListener(e -> onBackButton());
    }

    private void onForwardButton() {
        if (historyIndex < history.size() - 1) {
            goForward();
        }
    }

    private void onBackButton() {
        if (historyIndex > 0) {
            goBackward();
        }
    }

    private void goForwardTo(Row row) {
        history.add(row);
        historyIndex = history.size() - 1;
        setAtRow(row);
    }

    private void goForward() {
        historyIndex ++;
        setAtRow(history.get(historyIndex));
    }

    private void goBackward() {
        historyIndex --;
        setAtRow(history.get(historyIndex));
    }

    @Override public void onRowSelected(Row row) {
        goForwardTo(row.primarySelection());
    }

    private void setAtRow(Row row) {
        at.setText(row.toString());
        table.setModel(row.asAppTableModel());
    }

}

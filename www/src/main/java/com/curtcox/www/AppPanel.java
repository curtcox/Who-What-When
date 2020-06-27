package com.curtcox.www;

import com.curtcox.www.model.Node;

import javax.swing.*;
import java.awt.*;

final class AppPanel extends JPanel
    implements RowSelectionListener
{

    final JScrollPane scroll;
    final AppTable table;
    final JButton forward = new JButton(">");
    final JButton    back = new JButton("<");
    final JButton      at = new JButton();
    final History history = new History();

    private AppPanel(AppTable table) {
        this.table = table;
        scroll = new JScrollPane(table);
        setLayout(new BorderLayout());
        var buttons = new JPanel();
        buttons.add(back);
        buttons.add(forward);
        buttons.add(at);
        add(buttons, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
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
        if (history.canGoForward()) {
            setAtRow(history.goForward());
        }
    }

    private void onBackButton() {
        if (history.canGoBack()) {
            setAtRow(history.goBackward());
        }
    }

    private void goForwardTo(Row row) {
        history.addNew(row);
        setAtRow(row);
    }

    @Override public void onNodeSelected(Node node) {
        goForwardTo(Row.at(node));
    }

    private void setAtRow(Row row) {
        forward.setEnabled(history.canGoForward());
        back.setEnabled(history.canGoBack());
        at.setText(row.toString());
        table.setModel(row.asAppTableModel());
    }

}

package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

class AppTable {

    private static ImageIcon icon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static JTable newInstance() {
        String[] columnNames = {"Picture", "Text"};
        Object[][] data = {
            {icon("http://placekitten.com/100/200"), "Text 1"},
            {icon("http://placekitten.com/100/200"), "Text 2"},
            {icon("http://placekitten.com/100/200"), "Text 3"},
        };

        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
        JTable table = new JTable(model);

        table.setPreferredSize(new Dimension(500, 500));
        table.getColumn(model.getColumnName(0)).setPreferredWidth(100);
        table.getColumn(model.getColumnName(1)).setPreferredWidth(400);
        table.setRowHeight(100);

        return table;
    }

}

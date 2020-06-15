package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.net.MalformedURLException;
import java.net.URL;

class AppTableModel {

    private static ImageIcon icon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static DefaultTableModel tableModel() {
        String[] columnNames = {"Picture", "Text"};
        Object[][] data = {
                {icon("http://placekitten.com/100/200"), "Text 1"},
                {icon("http://placekitten.com/100/200"), "Text 2"},
                {icon("http://placekitten.com/100/200"), "Text 3"},
        };

        return new DefaultTableModel(data, columnNames) {
            public Class getColumnClass(int column) {
                return getValueAt(0, column).getClass();
            }
        };
    }

}

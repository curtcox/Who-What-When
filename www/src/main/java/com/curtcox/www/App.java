package com.curtcox.www;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class App extends JPanel {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                showGui();
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private ImageIcon icon(String url) throws MalformedURLException {
        return new ImageIcon(new URL(url));
    }

    public App() throws MalformedURLException {
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
        table.getColumn(columnNames[0]).setPreferredWidth(100);
        table.getColumn(columnNames[1]).setPreferredWidth(400);
        table.setRowHeight(100);

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
    }

    private static void showGui() throws MalformedURLException {
        JFrame frame = new JFrame("Images");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new App());
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

}
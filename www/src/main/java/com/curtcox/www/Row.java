package com.curtcox.www;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

abstract class Row {

    public static Object of(Node n) {
        return new Row() {
            @Override
            Object getValueAt(int columnIndex) {
                return n.name;
            }

            @Override
            String[] columnNames() {
                return new String[] {"name"};
            }
        };
    }

    abstract Object getValueAt(int columnIndex);

    abstract String[] columnNames();
//    {
//        return new String[] {"edge","node"};
//    }

    //    String[] columnNames = {"Picture", "Text"};
//    Object[][] data = {
//            {icon("http://placekitten.com/100/200"), "Text 1"},
//            {icon("http://placekitten.com/100/200"), "Text 2"},
//            {icon("http://placekitten.com/100/200"), "Text 3"},
//    };

    private static ImageIcon icon(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

}

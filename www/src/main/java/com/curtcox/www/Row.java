package com.curtcox.www;

import javax.swing.*;
import java.net.MalformedURLException;
import java.net.URL;

abstract class Row {

    private static class NodeRow extends Row {

        final Node node;

        public NodeRow(Node node) {
          this.node = node;
        }

        @Override Object getValueAt(int columnIndex) { return node.name; }
        @Override String[] columnNames()             { return new String[] {"name"}; }
        @Override public String toString()           { return node.toString(); }
    }

    public static Object of(Node node) {
        return new NodeRow(node);
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

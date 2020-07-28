package com.curtcox.www.ui;

import com.curtcox.www.model.Node;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

final class NodeRenderer extends JLabel
    implements TableCellRenderer
{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setNode((Node)value);
        return this;
    }

    void setAt(Row row) {
        if (row instanceof NodeRow) {
            setNode(((NodeRow) row).node);
        } else {
            throw new IllegalArgumentException();
        }
    }

    private void setNode(Node node) {
        setText(node.toString());
        var image = node.toImage();
        setImage(image);
    }

    private void setImage(String image) {
        if (image == null) {
            setIcon(null);
        } else if (Image.isValid(image)){
            setIcon(Image.of(image));
        } else {
            setText(image);
        }
    }

}

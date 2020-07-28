package com.curtcox.www.ui;

import com.curtcox.www.model.Name;

import javax.swing.*;
import java.net.*;

final class Image {

    static ImageIcon of(String url) {
        try {
            return new ImageIcon(new URL(url));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isValid(String name) {
        return Name.isImage(name);
    }
}

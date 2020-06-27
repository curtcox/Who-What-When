package com.curtcox.www.ui;

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

}

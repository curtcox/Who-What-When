package com.curtcox.www.model;

public final class Name {

    final static String IMAGE = "image";

    public static boolean isImage(String name) {
        return name.startsWith("http");
    }

}

package com.curtcox.www.model;

import java.util.*;

public final class Node {

    final String name;
    private static Map<String,Node> all = new HashMap<>();

    private Node(String name) {
        this.name = name;
    }

    static Node of(String name) {
        if (all.containsKey(name)) {
            return all.get(name);
        }
        Node node = new Node(name);
        all.put(name,node);
        return node;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toImage() {
        return "http://placekitten.com/50/50";
    }
}

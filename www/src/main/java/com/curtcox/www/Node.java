package com.curtcox.www;

import java.util.HashMap;
import java.util.Map;

final class Node {

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
}

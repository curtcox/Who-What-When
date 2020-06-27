package com.curtcox.www.model;

import java.util.*;

public final class Node {

    final String name;
    Graph graph;

    private static Map<String, Node> all = new HashMap<>();

    private Node(String name) {
        this.name = name;
    }

    static Node of(String name) {
        if (all.containsKey(name)) {
            return all.get(name);
        }
        Node node = new Node(name);
        all.put(name, node);
        return node;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toImage() {
        for (var edge : getEdges()) {
            if (edge.via.name.equals("image")) {
                return edge.to.toString();
            }
        }
        return null;
    }

    public int getHeight() {
        return toImage() == null ? 30 : 100;
    }

    public List<Edge> getEdges() {
        return graph.getEdges(this);
    }
}
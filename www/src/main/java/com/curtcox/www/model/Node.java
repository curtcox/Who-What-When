package com.curtcox.www.model;

import java.util.*;

public final class Node {

    final String name;
    Graph graph;

    private static Map<String, Node> all = new HashMap<>();
    private static String HOME = home();
    private static String IMAGE = "image";

    private static String home() {
        int[] emojis = { 0x1F3E0 };
        String text = new String(emojis, 0, emojis.length);
        return text;
    }

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
        if (isImage())  { return name;      }
        if (hasImage()) { return imageOf(); }
        return null;
    }

    public int getHeight() {
        return toImage() == null ? 30 : 100;
    }

    public List<Edge> getEdges() {
        return graph.getEdges(this);
    }

    private boolean isImage() {
        return name.startsWith("http");
    }

    private boolean hasImage() {
        for (var edge : getEdges()) {
            if (leadsToAnImage(edge)) {
                return true;
            }
        }
        return false;
    }

    private String imageOf() {
        for (var edge : getEdges()) {
            if (leadsToAnImage(edge)) {
                return edge.to.toString();
            }
        }
        return null;
    }

    private boolean leadsToAnImage(Edge edge) {
        return IMAGE.equals(edge.via.toString());
    }

}
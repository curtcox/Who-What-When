package com.curtcox.www.model;

import java.util.*;

import static com.curtcox.www.model.Name.IMAGE;

public final class Node {

    final String name;
    Graph graph;

    private static final int TEXT_HEIGHT = 30;
    private static final int IMAGE_HEIGHT = 100;

    private static Map<String, Node> all = new HashMap<>();
    private static String HOME = home();

    private static String home() {
        return "*";
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
        if (isHome())   { return HOME;      }
        if (isImage())  { return name;      }
        if (hasImage()) { return imageOf(); }
        return null;
    }

    public int getHeight() {
        return isHome() || toImage() == null ? TEXT_HEIGHT : IMAGE_HEIGHT;
    }

    public List<Edge> getEdges() {
        return graph.getEdges(this);
    }

    private boolean isImage() {
        return Name.isImage(name);
    }

    private boolean isHome() {
        return name.equals("");
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
package com.curtcox.www.model;

import java.util.*;

public final class Edge {

    public final Node to;
    public final Node from;
    public final Node via; // edge type

    private static final List<Edge> all = new ArrayList<>();

    private Edge(Node from, Node via, Node to) {
        this.from = from;
        this.via = via;
        this.to = to;
    }

    public static Edge fromViaTo(String from, String via, String to) {
        return fromViaTo(Node.of(from),Node.of(via),Node.of(to));
    }

    public static Edge fromViaTo(Node from, Node via, Node to) {
        var existing = find(from,via,to);
        if (existing!=null) {
            return existing;
        }
        return create(from,via,to);
    }

    private static Edge create(Node from, Node via, Node to) {
        var created = new Edge(from,via,to);
        all.add(created);
        return created;
    }

    private static Edge find(Node from, Node via, Node to) {
        for (var edge : all) {
            if (edge.from==from && edge.via==via && edge.to == to) {
                return edge;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return from + " " + via + " " + to;
    }

}

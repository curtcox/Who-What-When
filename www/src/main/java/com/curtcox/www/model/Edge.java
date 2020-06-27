package com.curtcox.www.model;

public final class Edge {

    public final Node to;
    public final Node from;
    public final Node via; // edge type

    private Edge(Node to, Node from, Node via) {
        this.to = to;
        this.from = from;
        this.via = via;
    }

    public static Edge fromViaTo(String from, String via, String to) {
        return new Edge(Node.of(to),Node.of(from),Node.of(via));
    }

    @Override
    public String toString() {
        return from + " " + via + " " + to;
    }
}

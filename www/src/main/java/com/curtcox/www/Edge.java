package com.curtcox.www;

final class Edge {

    final Node to;
    final Node from;
    final Node via; // edge type

    private Edge(Node to, Node from, Node via) {
        this.to = to;
        this.from = from;
        this.via = via;
    }

    static Edge fromViaTo(String from, String via, String to) {
        return new Edge(Node.of(to),Node.of(from),Node.of(via));
    }
}

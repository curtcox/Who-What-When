package com.curtcox.www;

final class Edge {

    final Node to;
    final Node from;
    final Node via; // edge type

    Edge(Node to, Node from, Node via) {
        this.to = to;
        this.from = from;
        this.via = via;
    }
}

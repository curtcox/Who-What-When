package com.curtcox.www.model;

import java.util.*;

public final class Graph {

    public final List<Node> nodes;
    private final Map<Node, List<Edge>> edges;

    Graph(Collection<Node> nodes, Map<Node,List<Edge>> edges) {
        this.nodes = new ArrayList(nodes);
        this.edges = edges;
    }

    List<Edge> getEdges(Node node) {
        if (edges.containsKey(node)) {
            return edges.get(node);
        }
        var message = "There is no " + node + " in " + edges;
        System.out.println(message);
        return Collections.emptyList();
    }

    public static GraphBuilder builder() {
        return GraphBuilder.of();
    }

    @Override public String toString() {
        return "nodes = " + nodes + " edges = " + edges;
    }
}

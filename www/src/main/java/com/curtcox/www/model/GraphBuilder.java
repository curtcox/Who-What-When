package com.curtcox.www.model;

import java.util.*;

public final class GraphBuilder {

    private Set<Node> nodes = new HashSet<>();
    private Map<Node, List<Edge>> edges = new HashMap<>();

    public GraphBuilder edge(Edge edge) {
        addEdgeToNode(edge,edge.to);
        addEdgeToNode(edge,edge.via);
        addEdgeToNode(edge,edge.from);
        return this;
    }
    void addEdgeToNode(Edge edge, Node node) {
        nodes.add(node);
        if (!edges.containsKey(node)) {
            edges.put(node,new ArrayList());
        }
        edges.get(node).add(edge);
    }
    public Graph build() {
        var graph = new Graph(nodes,edges);
        for (var node : nodes) {
            node.graph = graph;
        }
        return graph;
    }

    public static GraphBuilder of() {
        return new GraphBuilder();
    }
}

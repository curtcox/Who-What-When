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
        return new Graph(nodes,edges);
    }

    public static GraphBuilder of() {
        return new GraphBuilder();
    }
}

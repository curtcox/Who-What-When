package com.curtcox.www.model;

import java.util.*;

public final class GraphBuilder {

    private final Node blank = Node.of("");
    private Set<Node> nodes = new HashSet<>();
    private Map<Node, Set<Edge>> edges = new HashMap<>();

    private GraphBuilder() {
        edges.put(blank,new HashSet());
    }

    public GraphBuilder edge(Edge edge) {
        edge0(edge);
        edge0(Edge.fromViaTo(edge.from,blank,blank));
        edge0(Edge.fromViaTo(edge.via,blank,blank));
        edge0(Edge.fromViaTo(edge.to,blank,blank));
        return this;
    }

    private void edge0(Edge edge) {
        addEdgeToNode(edge,edge.to);
        addEdgeToNode(edge,edge.via);
        addEdgeToNode(edge,edge.from);
    }

    private void addEdgeToNode(Edge edge, Node node) {
        nodes.add(node);
        if (!edges.containsKey(node)) {
            edges.put(node,new HashSet<>());
        }
        edges.get(blank).add(edge);
        edges.get(node).add(edge);
    }

    public Graph build() {
        var graph = new Graph(nodes,listOf(edges));
        for (var node : nodes) {
            node.graph = graph;
        }
        return graph;
    }

    private Map<Node, List<Edge>> listOf(Map<Node, Set<Edge>> edges) {
        var map = new HashMap<Node, List<Edge>>();
        for (var entry : edges.entrySet()) {
            map.put(entry.getKey(),new ArrayList<>(entry.getValue()));
        }
        return map;
    }

    static GraphBuilder of() {
        return new GraphBuilder();
    }
}

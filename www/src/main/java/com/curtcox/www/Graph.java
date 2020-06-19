package com.curtcox.www;

import java.util.*;

final class Graph {

    final List<Node> nodes;
    final Map<Node, List<Edge>> edges;

    Graph(Collection<Node> nodes, Map<Node,List<Edge>> edges) {
        this.nodes = new ArrayList(nodes);
        this.edges = edges;
    }

    static final class Builder {
        private Set<Node> nodes = new HashSet<>();
        private Map<Node, List<Edge>> edges = new HashMap<>();

        Builder nodes(String... names) {
            for (var name : names) {
                nodes.add(Node.of(name));
            }
            return this;
        }
        Builder edge(String from, String via, String to) {
            var edge = Edge.fromViaTo(from,via,to);
            var node = edge.from;
            if (!edges.containsKey(node)) {
                edges.put(node,new ArrayList());
            }
            edges.get(node).add(edge);
            return this;
        }
        Graph build() {
            return new Graph(nodes,edges);
        }
    }

    static final Builder builder() {
        return new Builder();
    }
}
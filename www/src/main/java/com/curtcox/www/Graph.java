package com.curtcox.www;

import java.util.*;

final class Graph {

    final List<Node> nodes;
    final Map<Node, List<Edge>> edges;

    Graph(List<Node> nodes, Map<Node,List<Edge>> edges) {
        this.nodes = nodes;
        this.edges = edges;
    }

    static final class Builder {
        private List<Node> nodes = new ArrayList<>();
        private Map<Node, List<Edge>> edges = new HashMap<>();

        Builder nodes(String... names) {
            for (var name : names) {
                nodes.add(new Node(name));
            }
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

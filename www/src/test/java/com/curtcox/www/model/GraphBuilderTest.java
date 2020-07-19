package com.curtcox.www.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GraphBuilderTest {

    @Test public void empty_graph() {
        var graph = Graph.builder().build();
        assertTrue(graph!=null);
        assertTrue(graph.nodes.isEmpty());
    }

    @Test public void graph_with_one_edge() {
        var graph = Graph.builder()
                .edge(Edge.fromViaTo("from","via","to"))
                .build();
        assertTrue(graph!=null);
        assertTrue(graph.nodes.size()==4);
        assertGraphContainsAllNodes(graph,"from","via","to","");
        assertGraphContainsEdge(graph,"from","from","via","to");
    }

    private void assertGraphContainsAllNodes(Graph graph, String... names) {
        for (var name : names) {
            assertTrue(graph.nodes.contains(Node.of(name)));
        }
    }

    private void assertGraphContainsEdge(
            Graph graph, String name,String from, String via, String to)
    {
        var edges = graph.getEdges(Node.of(name));
        var edge = Edge.fromViaTo(from,via,to);
        var message = edges + " should contain " + edge;
        assertTrue(message,edges.contains(edge));
    }

}

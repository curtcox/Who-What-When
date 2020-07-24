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
        assertEdgeCountAt(graph,"from",2);
        assertEdgeCountAt(graph,"via",2);
        assertEdgeCountAt(graph,"to",2);
        assertEdgeCountAt(graph,"",4);
        assertGraphContainsEdge(graph,"from","from","via","to");
        assertGraphContainsEdge(graph,"from","from","","");
    }

    @Test public void graph_with_two_edges() {
        var graph = Graph.builder()
                .edge(Edge.fromViaTo("a","-","b"))
                .edge(Edge.fromViaTo("b","-","c"))
                .build();
        assertTrue(graph!=null);
        assertTrue(graph.nodes.size()==5);
        assertGraphContainsAllNodes(graph,"a","b","c","-","");
        assertEdgeCountAt(graph,"a",2);
        assertEdgeCountAt(graph,"b",3);
        assertEdgeCountAt(graph,"c",2);
        assertEdgeCountAt(graph,"",6);
        assertGraphContainsEdge(graph,"a","a","-","b");
        assertGraphContainsEdge(graph,"a","a","","");
        assertGraphContainsEdge(graph,"b","b","-","c");
        assertGraphContainsEdge(graph,"b","b","","");
        assertGraphContainsEdge(graph,"c","c","","");
    }

    void assertEdgeCountAt(Graph graph,String name,int expected) {
        int actual = graph.getEdges(Node.of(name)).size();
        var message = "Expected " + graph + " to have " + expected + " edges but had " + actual;
        assertEquals(message,expected,actual);
    }

    void assertGraphContainsAllNodes(Graph graph, String... names) {
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

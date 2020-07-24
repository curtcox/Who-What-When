package com.curtcox.www.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    @Test public void can_create() {
        assertTrue(Edge.fromViaTo("x","y","z")!=null);
    }

    @Test public void edge_equality_is_identity() {
        var a = Edge.fromViaTo("x","y","z");
        var b = Edge.fromViaTo("x","y","z");
        assertTrue(a==b);
    }

}

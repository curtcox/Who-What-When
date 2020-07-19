package com.curtcox.www.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class EdgeTest {

    @Test public void can_create() {
        assertTrue(Edge.fromViaTo("x","y","z")!=null);
    }
}

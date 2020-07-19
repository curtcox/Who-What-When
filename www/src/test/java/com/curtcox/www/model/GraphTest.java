package com.curtcox.www.model;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;

public class GraphTest {

    @Test public void can_create() {
        var nodes = Collections.EMPTY_LIST;
        var edges = Collections.EMPTY_MAP;
        assertTrue(new Graph(nodes,edges)!=null);
    }
}

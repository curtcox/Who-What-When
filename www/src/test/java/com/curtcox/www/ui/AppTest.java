package com.curtcox.www.ui;

import com.curtcox.www.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test public void can_create() {
        Graph graph = Graph.builder()
                .edge(Edge.fromViaTo("from","via","to"))
                .build();
        App app = new App(graph);
        assertTrue(app != null);
    }

}

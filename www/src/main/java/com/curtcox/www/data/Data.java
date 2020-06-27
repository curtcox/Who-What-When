package com.curtcox.www.data;

import com.curtcox.www.model.Edge;

import java.util.HashSet;

public final class Data {

    private static final String data = SampleData.data;

    public static Iterable<Edge> edges() {
        var edges = new HashSet<Edge>();
        for (var parts : csv(data)) {
            if (parts.length==3) {
                String from = parts[0];
                String via = parts[1];
                String to = parts[2];
                edges.add(Edge.fromViaTo(from,via,to));
            }
        }
        return edges;
    }

    static Iterable<String[]> csv(String source) {
        var values = new HashSet<String[]>();
        for (var line : source.split("\\r?\\n")) {
            values.add(line.split(","));
        }
        return values;
    }

}

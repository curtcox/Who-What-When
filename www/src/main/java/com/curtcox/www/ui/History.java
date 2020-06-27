package com.curtcox.www.ui;

import java.util.*;

final class History {

    private final List<Row> history = new ArrayList<>();
    private int historyIndex;

    boolean canGoForward() {
        return historyIndex < history.size() - 1;
    }

    boolean canGoBack() {
        return historyIndex > 0;
    }

    void addNew(Row row) {
        history.add(row);
        historyIndex = history.size() - 1;
    }

    Row goForward() {
        historyIndex ++;
        return current();
    }

    Row goBackward() {
        historyIndex --;
        return current();
    }

    private Row current() {
        return history.get(historyIndex);
    }

}

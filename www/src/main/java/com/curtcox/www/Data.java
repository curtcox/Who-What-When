package com.curtcox.www;

class Data {

    static final String me = "me";
    static final String wife = "my wife";
    static final String father = "father of";
    static final String mother = "mother of";
    static final String brother = "brother of";
    static final String sister = "sister of";
    static final String married = "married to";

    static final Graph graph = Graph.builder()
        .nodes(me,wife,"my son","my daughter","my father","my mother","my brother","my sister")
            .edge(me,married,wife)
            .edge(wife,married,me)
            .edge(me,brother,"my brother")
            .edge(me,sister,"my sister")
            .edge(me,father,"my son")
            .edge(me,father,"my daughter")
            .edge(wife,mother,"my son")
            .edge(wife,mother,"my daughter")
            .edge("my father",married,"my mother")
            .edge("my father",father,me)
            .edge("my mother",mother,me)
            .edge("my father",father,"my brother")
            .edge("my mother",mother,"my brother")
            .edge("my father",father,"my sister")
            .edge("my mother",mother,"my sister")
            .edge(wife,brother,"my wife's brother")
            .edge(wife,sister,"my wife's sister")
            .edge("my wife's father",father,wife)
            .edge("my wife's mother",mother,wife)
        .build();

}

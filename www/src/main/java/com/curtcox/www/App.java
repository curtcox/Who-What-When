package com.curtcox.www;

import javax.swing.*;

class App extends JPanel {

    App() {
        add(new JScrollPane(AppTable.newInstance()));
    }

}
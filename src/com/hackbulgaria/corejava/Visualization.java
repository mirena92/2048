package com.hackbulgaria.corejava;

import java.io.IOException;

public interface Visualization {

    public void displayBoard() throws IOException;

    public boolean displayLoseMessage();

    public boolean displayWinMessage();
}

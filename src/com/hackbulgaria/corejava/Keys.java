package com.hackbulgaria.corejava;

public enum Keys {
    UP_ARROW(16), DOWN_ARROW(14), RIGHT_ARROW(6), LEFT_ARROW(2), S(115), U(117), R(114), Q(113), L(108), N(110);
    
    private Keys(int keyNumber) {
        this.keyNumber = keyNumber;
    }
    
    private final int keyNumber;
    
    public int getNumber() {
        return keyNumber;
    }
}

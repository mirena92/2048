package com.hackbulgaria.corejava;

import java.io.Serializable;

public class Player implements Serializable {
    private int score;
    private final int winningScore = 16;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return this.score;
    }

    public boolean isWinning() {
        return score == winningScore;
    }

    public void setScore(int newScore) {
        this.score = newScore;
    }
}

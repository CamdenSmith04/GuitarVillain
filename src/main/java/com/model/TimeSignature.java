package com.model;

public class TimeSignature {
    
    private final int topNumber;
    private final int bottomNumber;

    public TimeSignature(int topNumber, int bottomNumber) {
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
    }

    public int getTopNumber(){
        return topNumber;
    }

    public int getBottomeNumber(){
        return bottomNumber;
    }

    @Override
    public String toString(){
        return Integer.toString(topNumber) + "/" + Integer.toString(bottomNumber);
    }
}

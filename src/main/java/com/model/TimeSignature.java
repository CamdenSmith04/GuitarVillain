package com.model;
/**
 * @author Andrew Goad
 * This class represents a time signature
 */
public class TimeSignature {
    /**
     * The top number in the time signature, or the number of beats in a measure of the song
     */
    private final int topNumber;
    /**
     * The bottom number in the time signature, or the value of each beat in the song 
     */
    private final int bottomNumber;

    /**
     * TimeSignature constructor
     * @param topNumber parameter for the top number 
     * @param bottomNumber parameter for the bottom number
     */
    public TimeSignature(int topNumber, int bottomNumber) {
        this.topNumber = topNumber;
        this.bottomNumber = bottomNumber;
    }

    /**
     * accessor for the top number 
     * @return top number of time signature
     */
    public int getTopNumber(){
        return topNumber;
    }
    /**
     * accessur for bottom number
     * @return bottom number of timesignature
     */
    public int getBottomNumber(){
        return bottomNumber;
    }
    /**
     * returns time signature as a string
     */
    @Override
    public String toString(){
        return Integer.toString(topNumber) + "/" + Integer.toString(bottomNumber);
    }
}

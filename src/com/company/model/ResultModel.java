package com.company.model;

public class ResultModel {
    private int triesWithSwitching;
    private int triesWithOutSwitching;
    private int winWithSwitching;
    private int winWithOutSwitching;

    /**
     * Class for finding out if switching or not switching is the best option.
     */
    public ResultModel() {
        this.triesWithSwitching = 0;
        this.winWithSwitching = 0;
        this.triesWithOutSwitching = 0;
        this.winWithOutSwitching = 0;
    }

    public int getTriesWithSwitching() {
        return triesWithSwitching;
    }

    public void incrementTriesWithSwitching() {
        triesWithSwitching++;
    }

    public int getTriesWithOutSwitching() {
        return triesWithOutSwitching;
    }

    public void incrementTriesWithOutSwitching() {
        triesWithOutSwitching++;
    }

    public int getWinWithSwitching() {
        return winWithSwitching;
    }

    public void incrementWinWithSwitching() {
        winWithSwitching++;
    }

    public int getWinWithOutSwitching() {
        return winWithOutSwitching;
    }

    public void incrementWinWithOutSwitching() {
        winWithOutSwitching++;
    }


}

package com.company.model;

import java.util.Random;

public class MontyHallModel {

    private int[] doors;// 0 for goats, 1 for money.
    private int playerPick;
    private int computerPick;

    /**
     * Model for the Monty Hall Problem containing all the states
     * @param numberOfDoors If more than three doors are to be used
     */
    public MontyHallModel(int numberOfDoors) {
        this.doors = new int[numberOfDoors];
        this.playerPick = -1;
        this.computerPick = -1;
    }

    public void setMoneyInDoor(int index){
        doors[index]++;
    }

    public boolean isDoorMoney(int index){
        return doors[index] == 1;
    }

    public void setPlayerPick(int playerPick) {
        this.playerPick = playerPick;
    }

    public int getPlayerPick() {
        return playerPick;
    }

    public int doorSize(){
        return doors.length;
    }

    public int getComputerPick() {
        return computerPick;
    }

    public void setComputerPick(int computerPick) {
        this.computerPick = computerPick;
    }

}

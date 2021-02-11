package com.company.model;

import java.util.Random;

public class MontyHallModel {

    private int[] doors;// 0 for goats, 1 for money.
    private int playerPick;
    private int computerPick;

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

    //Helper method for expanding array
   /* private static int[] expandArray(int array[]){
        int newArray[] = new int[array.length + 1];
        for(int i = 0; i < array.length; i++){
            newArray[0] = array[0];
        }

        return newArray;
    }*/
}

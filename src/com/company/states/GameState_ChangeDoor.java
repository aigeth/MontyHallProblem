package com.company.states;

import com.company.model.MontyHallModel;

import java.util.Random;

public class GameState_ChangeDoor extends GameState{

    protected GameState_ChangeDoor(MontyHallModel montyHallModel) {
        super(montyHallModel);
    }

    @Override
    public void run() {
        Random random = new Random();
        setRandomComputerChoice();
        System.out.println("Computer opened the " + (montyHallModel.getComputerPick() +1) + " door.");
        System.out.println("Want to switch?");
    }

    @Override
    public GameState handleInput(String input) {
        return null;
    }

    /**
     * Helper method for generating random choice for PC depending on choices available
     * and converting them to the corresponding door.
     */
    private void setRandomComputerChoice(){
        int[] choices = new int[NumberOfDoors-1]; //Choices will always be a maximum of NumberOfDoors -1
        int nrOfChoices = 0;
        for (int i = 0; i < NumberOfDoors; i++){
            if(montyHallModel.isDoorMoney(i)){
                continue;
            }
            if(i == montyHallModel.getPlayerPick()){
                continue;
            }
            choices[nrOfChoices] = i;
            nrOfChoices++;
        }

        Random random = new Random();
        int computerPick = random.nextInt(nrOfChoices);

        montyHallModel.setComputerPick(choices[computerPick]);

    }

    /**
     * Helper method to check if user has a valid pick
     * @param index The door to pick
     * @return True or false
     */
    private boolean isValidChoice(int index){
        if(index == montyHallModel.getComputerPick()){
            return false;
        }
        if(index < 0 || index >= NumberOfDoors){
            return false;
        }
        return true;
    }


    public void printAvailableChoicesForPlayer(){
        int[] choices = new int[NumberOfDoors-1];
        int nrOfChoices = 0;
        for (int i = 0; i < NumberOfDoors; i++){
            if(montyHallModel.isDoorMoney(i)){
                continue;
            }
            if(i == montyHallModel.getComputerPick()){
                continue;
            }
            choices[nrOfChoices] = i;
            nrOfChoices++;
        }

    }

    public GameState error(String errorText) {
        return null;
    }
}

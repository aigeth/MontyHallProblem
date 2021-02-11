package com.company.states;

import com.company.model.MontyHallModel;
import com.company.model.ResultModel;

import java.util.Random;

public class GameState_ChangeDoor extends GameState{

    /**
     * Stateful Design Pattern.
     * All state setup should be done here.
     * @param montyHallModel The model that is passed on to different states
     */
    protected GameState_ChangeDoor(MontyHallModel montyHallModel, ResultModel resultModel) {
        super(montyHallModel, resultModel);
    }


    @Override
    public void run() {
        System.out.println("Computer opened the door " + (montyHallModel.getComputerPick() +1) + ".");
        System.out.println("Want to switch to the other one? Type Yes/y or No/n: ");
    }

    @Override
    public GameState handleInput(String input) {
        if(input == null){
            return error("Invalid Input!");
        }

        if(input.equalsIgnoreCase("yes") ||
        input.equalsIgnoreCase("y")){
            chooseRemainingBox();
            return new GameState_Results(montyHallModel, resultModel, true);
        }

        if(input.equalsIgnoreCase("no") ||
                input.equalsIgnoreCase("n")){
            return new GameState_Results(montyHallModel, resultModel, false);
        }

        return error("Invalid Input!");
    }

    @Override
    protected GameState error(String errorText) {
        System.out.println(errorText);
        return this;
    }

    /**
     * Helper method to switch to the remaining box.
     * This needs to be changed if more than three doors are available.
     */
    private void chooseRemainingBox(){
        int remainingBox = 0;
        for (int i = 0; i < NumberOfDoors; i++){
            if(i == montyHallModel.getPlayerPick()){
                continue;
            }
            if(i == montyHallModel.getComputerPick()){
                continue;
            }
            remainingBox = i;
        }

        montyHallModel.setPlayerPick(remainingBox);
    }


    /**
     * If the game was ever to expand beyond 3 doors, this method will become useful.
     * @param index The door to pick
     * @return True or false
     */
    private boolean isValidChoice(int index){
        if(index == montyHallModel.getComputerPick()){
            return false;
        }
        return index >= 0 && index < NumberOfDoors;
    }

}

package com.company.states;

import com.company.model.MontyHallModel;
import com.company.model.ResultModel;

import java.util.Random;

public class GameState_NewGame extends GameState{

    /**
     * Stateful Design Pattern.
     * This is the first state that is initialized.
     * All state setup should be done here.
     */
    public GameState_NewGame(ResultModel resultModel) {
        super(new MontyHallModel(NumberOfDoors), resultModel);
        Random random = new Random();
        int index = random.nextInt(NumberOfDoors);
        montyHallModel.setMoneyInDoor(index);
    }

    @Override
    public void run() {
        System.out.println("Pick a door between 1-" + NumberOfDoors + ": ");
    }

    @Override
    public GameState handleInput(String input) {
        int playerChoice;
        if(GameState.isInteger(input)){
            playerChoice = Integer.parseInt(input);
        }else {
            return error("Invalid input!");
        }

        if(playerChoice < 1 || playerChoice > NumberOfDoors){
            return error("Invalid input! Number out of range!");
        }

        playerChoice--; //Convert to match the array in the MontyHallModel class.
        montyHallModel.setPlayerPick(playerChoice);
        setRandomComputerChoice();

        return new GameState_ChangeDoor(montyHallModel, resultModel); //Move to change door state (State where user is asked to change his/her mind.)
    }

    @Override
    protected GameState error(String errorText) {  //Handle error and return to a viable state
        System.out.println(errorText);
        return this; //Return to same state
    }

    /**
     * Helper method for generating random choice for PC depending on choices available
     * and converting them to the corresponding door.
     */
    private void setRandomComputerChoice(){
        int[] choices = new int[NumberOfDoors-1]; //Array containing choices for the computer. Choices will always be a maximum of NumberOfDoors -1
        int nrOfChoices = 0;
        //Loop through each door and skip doors containing money or a player pick
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

        //Generating random choice for the computer based on the available ones
        Random random = new Random();
        int computerPick = random.nextInt(nrOfChoices);

        montyHallModel.setComputerPick(choices[computerPick]);

    }
}

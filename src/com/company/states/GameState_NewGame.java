package com.company.states;

import com.company.model.MontyHallModel;

import java.util.Random;

public class GameState_NewGame extends GameState{

    public GameState_NewGame() {
        super(new MontyHallModel(NumberOfDoors));
        Random random = new Random();
        int index = random.nextInt(3);
        montyHallModel.setMoneyInDoor(index);
    }

    @Override
    public void run() {
        System.out.println("Pick a door between 1-" + NumberOfDoors + ": ");
    }

    @Override
    public GameState handleInput(String input) {
        int playerPick = 0;
        if(GameState.isInteger(input)){
            playerPick = Integer.parseInt(input);
        }else {
            return error("Invalid input!");
        }

        if(playerPick < 1 || playerPick > NumberOfDoors){
            return error("Invalid input! Please pick a door between 1-" + NumberOfDoors + "!");
        }

        playerPick--; //Convert to match the array in the MontyHallModel class.
        montyHallModel.setPlayerPick(playerPick);

        return new GameState_ChangeDoor(montyHallModel); //Move to change door state (State where user is asked to change his/her mind.)
    }

    public GameState error(String errorText) {  //Handle error and return to a viable state
        System.out.println(errorText);
        return this; //Return to same state
    }
}

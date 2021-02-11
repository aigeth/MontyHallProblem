package com.company.states;

import com.company.model.MontyHallModel;
import com.company.model.ResultModel;

public class GameState_Results extends GameState{

    /**
     * Stateful Design Pattern.
     * Final state that returns to either NewGame or Null.
     * All state setup should be done here.
     * @param montyHallModel The model that is passed on to different states
     */
    protected GameState_Results(MontyHallModel montyHallModel, ResultModel resultModel, Boolean switched) {
        super(montyHallModel, resultModel);

        //Increment total tries depending on if the user switched or not
        if (switched) {
            resultModel.incrementTriesWithSwitching();
        } else {
            resultModel.incrementTriesWithOutSwitching();
        }

        //Increment total wins depending on if the user switched or not
        if(montyHallModel.isDoorMoney(montyHallModel.getPlayerPick())){
            if(switched){
                resultModel.incrementWinWithSwitching();
            }else {
                resultModel.incrementWinWithOutSwitching();
            }
        }
    }

    @Override
    public void run() {
        if(montyHallModel.isDoorMoney(montyHallModel.getPlayerPick())){
            System.out.println("Congratulations, you just won!");
        }else{
            System.out.println("Sorry you get the goat!");
        }
        System.out.println("Want to try again? Type Yes/y or No/n: ");
    }

    @Override
    public GameState handleInput(String input) {
        if(input == null){
            return error("Invalid input!");
        }

        if(input.equalsIgnoreCase("yes") ||
                input.equalsIgnoreCase("y")){
            return new GameState_NewGame(resultModel);
        }

        if(input.equalsIgnoreCase("no") ||
                input.equalsIgnoreCase("n")){
            return null;
        }

        return error("Invalid input!");
    }

    /**
     * If an error occurred during handling of user input.
     *
     * @param errorText The text to display
     * @return Return to the viable state (Usually the same state);
     */
    @Override
    protected GameState error(String errorText) {
        System.out.println(errorText);
        return this;
    }


}

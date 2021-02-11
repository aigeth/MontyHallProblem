package com.company.states;

import com.company.model.MontyHallModel;
import com.company.model.ResultModel;

import java.util.Random;

public abstract class GameState {
    protected static final int NumberOfDoors = 3;
    protected MontyHallModel montyHallModel;
    protected ResultModel resultModel;

    /**
     * Abstract class.
     * Stateful Design Pattern.
     * All state setup should be done here.
     * @param montyHallModel The model that is passed on to different states
     */
    protected GameState(MontyHallModel montyHallModel, ResultModel resultModel){
        this.montyHallModel = montyHallModel;
        this.resultModel = resultModel;
    }

    /**
     * This method must be run everytime following by handleInput()
     * All pre input logic is handled here
     */
    public abstract void run();

    /**
     * Method for choosing the next state
     * @param input Input to handle
     * @return next GameState
     */
    public abstract GameState handleInput(String input);

    /**
     * If an error occurred during handling of user input.
     * @param errorText The text to display
     * @return Return to the viable state (Usually the same state);
     */
    protected abstract GameState error(String errorText);


    /**
     * Helper method for verifying input is integer (this is the most efficient way).
     * @param string String to check
     * @return True or False
     */
    protected static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }
        int length = string.length();
        if (length == 0) {
            return false;
        }
        int i = 0;
        if (string.charAt(0) == '-') {
            if (length == 1) {
                return false;
            }
            i = 1;
        }
        for (; i < length; i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

}

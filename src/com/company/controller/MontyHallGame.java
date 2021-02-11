package com.company.controller;

import com.company.model.ResultModel;
import com.company.states.GameState;
import com.company.states.GameState_NewGame;

import java.util.Scanner;

public class MontyHallGame {
    public void play(){
        Scanner scanner = new Scanner(System.in);

        ResultModel resultModel = new ResultModel();
        GameState gameState = new GameState_NewGame(resultModel);

        while (gameState != null){
            gameState.run();
            gameState = gameState.handleInput(scanner.nextLine());
        }

        printStatistics(resultModel);
    }

    public void printStatistics(ResultModel resultModel){
        int triesWithOutSwitching = resultModel.getTriesWithOutSwitching();
        int winWithOutSwitching = resultModel.getWinWithOutSwitching();
        int triesWithSwitching = resultModel.getTriesWithSwitching();
        int winWithSwitching = resultModel.getWinWithSwitching();

        double winPercentWithOutSwitch;
        double winPercentWithSwitch;

        if(triesWithOutSwitching == 0){
            winPercentWithOutSwitch = 0;
        }else{
            winPercentWithOutSwitch = ((double) (winWithOutSwitching)/(double)triesWithOutSwitching) * 100;
        }

        if(triesWithSwitching == 0){
            winPercentWithSwitch = 0;
        }else {
            winPercentWithSwitch = ((double) (winWithSwitching)/(double) triesWithSwitching) * 100;
        }

        System.out.println("Without switching you won: " + winWithOutSwitching + " out of " + triesWithOutSwitching + " which is: " + winPercentWithOutSwitch + "%.");
        System.out.println("With switching you won: " + winWithSwitching + " out of " + triesWithSwitching + " which is: " + winPercentWithSwitch + "%.");
    }
}

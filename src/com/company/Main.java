package com.company;

import com.company.controller.MontyHallGame;
import com.company.model.ResultModel;
import com.company.states.GameState;
import com.company.states.GameState_NewGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        MontyHallGame montyHallGame = new MontyHallGame();
        montyHallGame.play();
    }

}

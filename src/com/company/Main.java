package com.company;

import com.company.states.GameState;
import com.company.states.GameState_NewGame;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        GameState gameState = new GameState_NewGame();

       /* int doors[] = new int[3];
        Random random = new Random();
        int car = random.nextInt(3);
        doors[car]++;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pick a door between 1-3:");
        int pick = scanner.nextInt();
        scanner.nextLine();
        pick--; //1
        int temp[] = new int[0];
        int count = 0;
        for(int i = 0; i< doors.length; i++){
            if(doors[i] == 1){
                continue;
            }
            if(i == pick){
                continue;
            }
            temp = expandArray(temp);
            temp[count] = i;
            count++;
        }
        int computerpick = random.nextInt(temp.length);
        System.out.println("Computer opened the " + (temp[computerpick] +1) + " door.");
        System.out.println("Wanna switch?");
        pick = scanner.nextInt();
        scanner.nextLine();
        pick--;
        if(doors[pick] == 1){
            System.out.println("Congratulations you won!");
        }else {
            System.out.println("You lost!");
        }*/
    }

}

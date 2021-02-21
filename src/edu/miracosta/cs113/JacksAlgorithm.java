package edu.miracosta.cs113;

import java.util.Random;
import java.util.Scanner;
import model.Theory;
import model.AssistantJack;

public class JacksAlgorithm {

    public static void main(String[] args) {
        // DECLARATION + INITIALIZATION
        int answerSet, solution, murder, weapon, location;
        Theory answer;
        AssistantJack jack;
        Scanner keyboard = new Scanner(System.in);
        Random random = new Random();

        // INPUT
        System.out.print("Which theory would like you like to test? (1, 2, 3[JacksAlgorithm]): ");
        //answerSet = keyboard.nextInt();
        answerSet = 3;
        keyboard.close();

        // PROCESSING
        jack = new AssistantJack(answerSet);
        weapon = murder = 1 ;
        location = 10 ;

        do {
            solution = jack.checkAnswer(weapon, location, murder);
            switch(solution)
            {
                case 0 :
                    break ;
                case 1 :
                    weapon++;
                    continue;
                case 2 :
                    location-- ;
                    continue;
                case 3:
                    murder++ ;
                    continue;
                default:
                    System.out.println("?");
            }

        } while (solution != 0);

        answer = new Theory(weapon, location, murder);

        // OUTPUT
        System.out.println("Total Checks = " + jack.getTimesAsked() + ", Solution " + answer);

        if (jack.getTimesAsked() > 20) {
            System.out.println("FAILED!! You're a horrible Detective...");
        } else {
            System.out.println("WOW! You might as well be called Batman!");
        }

    }

}
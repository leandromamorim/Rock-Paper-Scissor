package org.example;

import java.util.Random;

public class RockPaperScissorLogic {
    //computer choice options
    private static final String[] computerChoices = {"Rock", "Paper", "Scissor"};

    public String getComputerChoice() {
        return computerChoice;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    //store computer choice & display
    private String computerChoice;

    //store the scores & display
    private int computerScore, playerScore;

    //random computer choice
    private Random random;

    //code to init random
    public RockPaperScissorLogic(){
        random = new Random();
    }

    public String playRockPaperScissorLogic(String playerChoice) {
        //generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //show game result
        String result = null;

        //game logic
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Scissor")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                result = "Player Wins";
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if(computerChoice.equals("Scissor")) {
                if (playerChoice.equals("Rock")) {
                    result = "Player Wins";
                    playerScore++;
                } else if (playerChoice.equals("Paper")) {
                    result = "Computer Wins";
                    computerScore++;
                } else {
                    result = "Draw";
                }
            }

        //game result
        return result;
        }
}
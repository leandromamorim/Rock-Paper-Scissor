package org.game;

import org.game.classes.PopUpStyles;

import java.awt.*;
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

    public PopUpStyles playRockPaperScissorLogic(String playerChoice) {
        //generate computer choice
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];

        //show game result
        PopUpStyles result = new PopUpStyles(null, null);

        //game logic
        if (computerChoice.equals("Rock")) {
            if (playerChoice.equals("Paper")) {
                result.setText("Player Wins");
                result.setColor(Color.GREEN);
                playerScore++;
            } else if (playerChoice.equals("Scissor")) {
                result.setText("Computer Wins");
                result.setColor(Color.RED);
                computerScore++;
            } else {
                result.setText("Draw");
            }
        } else if (computerChoice.equals("Paper")) {
            if (playerChoice.equals("Scissor")) {
                result.setText("Player Wins");
                result.setColor(Color.GREEN);
                playerScore++;
            } else if (playerChoice.equals("Rock")) {
                result.setText("Computer Wins");
                result.setColor(Color.RED);
                computerScore++;
            } else {
                result.setText("Draw");
            }
        } else if(computerChoice.equals("Scissor")) {
                if (playerChoice.equals("Rock")) {
                    result.setText("Player Wins");
                    result.setColor(Color.GREEN);
                    playerScore++;
                } else if (playerChoice.equals("Paper")) {
                    result.setText("Computer Wins");
                    result.setColor(Color.RED);
                    computerScore++;
                } else {
                    result.setText("Draw");
                }
            }

        //game result
        return result;
        }
}
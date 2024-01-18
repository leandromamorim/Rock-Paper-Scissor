package org.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissor extends JFrame implements ActionListener{

    //player buttons
    JButton rockButton, paperButton, scissorButton;
    //computer choice
    JLabel computerChoice;
    //display score of the computer & player
    JLabel computerScoreLabel, playerScoreLabel;
    //game logic
    RockPaperScissorLogic rockPaperScissor;

    public RockPaperScissor() {
        setTitle("Rock Paper Scissor");
        setSize(450, 574);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        rockPaperScissor = new RockPaperScissorLogic(); //init game logic
        addGuiComponents();
    }

    private void addGuiComponents() {
        //computer score label
        computerScoreLabel = new JLabel("Computer: 0");
        computerScoreLabel.setBounds(0, 43, 450, 30);
        computerScoreLabel.setFont(new Font("Arial", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        //computer score choice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175, 118, 98, 81);
        computerChoice.setFont(new Font("Arial", Font.PLAIN, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //player score label
        playerScoreLabel = new JLabel("Player: 0");
        playerScoreLabel.setBounds(0, 317, 450, 30);
        playerScoreLabel.setFont(new Font("Arial", Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //rock button
        rockButton = new JButton("Rock");
        rockButton.setBounds(40, 387, 105, 81);
        rockButton.setFont(new Font("Arial", Font.PLAIN, 18));
        rockButton.addActionListener(this);
        add(rockButton);

        //paper button
        paperButton = new JButton("Paper");
        paperButton.setBounds(165, 387, 105, 81);
        paperButton.setFont(new Font("Arial", Font.PLAIN, 18));
        paperButton.addActionListener(this);
        add(paperButton);

        //scissor button
        scissorButton = new JButton("Scissor");
        scissorButton.setBounds(290, 387, 105, 81);
        scissorButton.setFont(new Font("Arial", Font.PLAIN, 18));
        scissorButton.addActionListener(this);
        add(scissorButton);
    }

    private void showDialog(String message){
        //box that show result & button "try again"
        JDialog resultDialog = new JDialog(this, "Result", true);
        resultDialog.setSize(227, 124);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        //message
        JLabel resultLabel = new JLabel(message);
        resultLabel.setFont(new Font("Arial", Font.BOLD, 18));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel, BorderLayout.CENTER);

        //try again button
        JButton tryAgainButton = new JButton("Try Again?");
        tryAgainButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                computerChoice.setText("?");

                // close the dialog box
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton, BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //get player choice
        String playerChoice = e.getActionCommand().toString();

        //play & show result
        String result = rockPaperScissor.playRockPaperScissorLogic(playerChoice);

        //load computer choice
        computerChoice.setText(rockPaperScissor.getComputerChoice());

        //update score
        computerScoreLabel.setText("Computer: " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player: " + rockPaperScissor.getPlayerScore());

        //show result
        showDialog(result);
    }
}

package com.example.jsu.cs408lab2;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;

public class Lab2 extends AppCompatActivity {

    public enum Weapon {

        ROCK("Rock"),
        PAPER("Paper"),
        SCISSORS("Scissors");

        private String message;

        private Weapon(String msg) { message = msg; }

        @Override
        public String toString() { return message; }

    };

    private Weapon playerWeapon;
    private Weapon computerWeapon;
    private int playerWins;
    private int computerWins;
    private static int selectionSize;

    private String scoreMessage;
    private String playerChoiceMessage;
    private String computerChoiceMessage;
    private String resultMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        selectionSize = 3;
    }

    public void rockButtonClicked (View v) {
        playerWeapon = Weapon.ROCK;
        chooseComputerWeapon();
        playerChoiceMessage = "Player's Weapon: Rock";
        determineWinner();
        updateMessages();
    }

    public void paperButtonClicked (View v) {
        playerWeapon = Weapon.PAPER;
        chooseComputerWeapon();
        playerChoiceMessage = "Player's Weapon: Paper";
        determineWinner();
        updateMessages();
    }

    public void scissorsButtonClicked (View v) {
        playerWeapon = Weapon.SCISSORS;
        chooseComputerWeapon();
        playerChoiceMessage = "Player's Weapon: Scissors";
        determineWinner();
        updateMessages();
    }

    private void chooseComputerWeapon() {
        int choice = (int)(Math.random() * selectionSize);

        switch (choice) {
            case 0: computerWeapon = Weapon.ROCK;
                    computerChoiceMessage = "Computer's Weapon: Rock";
                    break;
            case 1: computerWeapon = Weapon.PAPER;
                    computerChoiceMessage = "Computer's Weapon: Paper";
                    break;
            default: computerWeapon = Weapon.SCISSORS;
                    computerChoiceMessage = "Computer's Weapon: Scissors";
                    break;
        }
    }

    private void displayPlayerChoice() {
        TextView t = (TextView) findViewById(R.id.playerWeaponLabel);
        t.setText(playerChoiceMessage);
    }

    private void displayComputerChoice() {
        TextView t = (TextView) findViewById(R.id.computerWeaponLabel);
        t.setText(computerChoiceMessage);
    }

    private void determineWinner() {
        if(playerWeapon == computerWeapon) {
            resultMessage = "It was a draw!";
        }
        if(playerWeapon == Weapon.ROCK) {
            if(computerWeapon == Weapon.SCISSORS) {
                resultMessage = "Player wins ... Rock blunts scissors!";
                playerWins++;
            }
            if(computerWeapon == Weapon.PAPER) {
                resultMessage = "Computer wins ... Paper covers rock!";
                computerWins++;
            }
        }

        if(playerWeapon == Weapon.PAPER) {
            if(computerWeapon == Weapon.ROCK) {
                resultMessage = "Player wins ... Paper covers rock!";
                playerWins++;
            }
            if(computerWeapon == Weapon.SCISSORS) {
                resultMessage = "Computer wins ... Scissors cuts paper!";
                computerWins++;
            }
        }

        if(playerWeapon == Weapon.SCISSORS) {
            if(computerWeapon == Weapon.PAPER) {
                resultMessage = "Player wins ... Scissors cuts paper!";
                playerWins++;
            }
            if(computerWeapon == Weapon.ROCK) {
                resultMessage = "Computer wins ... Rock blunts scissors!";
                computerWins++;
            }
        }
    }

    private void displayScore() {
        scoreMessage = "Player: " + String.valueOf(playerWins) + ", Computer: " + String.valueOf(computerWins);
        TextView t = (TextView) findViewById(R.id.scoreLabel);
        t.setText(scoreMessage);
    }

    private void displayWinner() {
        TextView t = (TextView) findViewById(R.id.winnerLabel);
        t.setText(resultMessage);
    }

    private void updateMessages() {
        displayScore();
        displayPlayerChoice();
        displayComputerChoice();
        displayWinner();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_lab2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

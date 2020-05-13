package com.example.diceefinal;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton;//this is the variable of type button and having name as rollbuttonn.
        rollButton = (Button) findViewById(R.id.rollButton);//this is used to read the button or we can say that this is the way to link with the xml file.
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);//this is the way to declare the view of left dice
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);//this is the way to declare the left dice
        final int[] diceArray = {

                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6

        };

        rollButton.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              //Log.d("Dicee","Ze button has been pressed");
                                              Random randomNumberGenerator = new Random();
                                              int number1 = randomNumberGenerator.nextInt(6);//this is used to store a number betwwn 0 and 5
                                              int number2 = randomNumberGenerator.nextInt(6);


                                              //Log.d("Dicee","The random number is :"+number);

                                              leftDice.setImageResource(diceArray[number1]);
                                              //number=randomNumberGenerator.nextInt(6);//this is done to create a diffreent number on right dice
                                              rightDice.setImageResource(diceArray[number2]);

                                              if(number1==number2) {
                                                  AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                                  alert.setTitle("what to do next");
                                                  alert.setCancelable(false);
                                                  alert.setNegativeButton("Close application", new DialogInterface.OnClickListener() {
                                                      @Override
                                                      public void onClick(DialogInterface dialog, int which) {
                                                          finish();
                                                      }
                                                  });
                                                  alert.setPositiveButton("continue application", new DialogInterface.OnClickListener() {
                                                      @Override
                                                      public void onClick(DialogInterface dialog, int which) {

                                                      }
                                                  });

                                               alert.show();
                                              }
                                          }


                                      }
        );


    }
}
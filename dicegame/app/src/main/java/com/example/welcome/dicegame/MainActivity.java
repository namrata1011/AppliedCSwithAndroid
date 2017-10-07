package com.example.welcome.dicegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static java.lang.System.exit;

public class MainActivity extends AppCompatActivity {

    private int diceValue;
    TextView ys, cs, ts;
    Button roll, hold, reset;
    ImageView dice;
    Boolean isPlayerTurn=true;
    private String yscore = "Your Score: ";
    private String cscore = "Computer Score: ";
    private String tscore = "Turn Score: ";
    int yourscore;
    int compscore;
    int turnscore;
    int images[] = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6, R.drawable.dice_s};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ys = (TextView) findViewById(R.id.YourScore);
        cs = (TextView) findViewById(R.id.CompScore);
        ts = (TextView) findViewById(R.id.TurnScore);
        dice = (ImageView) findViewById(R.id.dice);
        roll = (Button) findViewById(R.id.roll);
        hold = (Button) findViewById(R.id.hold);
        reset = (Button) findViewById(R.id.reset);
    }

    public void roll(View v) {
        Random r = new Random();
        diceValue = r.nextInt(6) + 1;
        if (diceValue == 1) {
            turnscore = 0;
            hold(null);
        } else {
            turnscore += diceValue;
        }
        new android.os.Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                dice.setImageResource(images[6]);
            }
        }, 1000);
        updateUi(null);
    }

    public void hold(View v) {
        if (isPlayerTurn == true) {
            Toast.makeText(MainActivity.this,"Computer's turn now",Toast.LENGTH_SHORT).show();
            yourscore += turnscore;
            isPlayerTurn = false;
        } else {
            Toast.makeText(MainActivity.this,"Player's turn now",Toast.LENGTH_SHORT).show();
            compscore += turnscore;
            isPlayerTurn = true;
            computerTurn(null);
        }
        updateUi(null);
        diceValue=1;
        turnscore = 0;

        if (compscore>100 || yourscore>100) {
            Toast.makeText(MainActivity.this,(compscore>100?"Computer":"Player")+" won",Toast.LENGTH_LONG).show();
            reset(null);
        }

        if (!isPlayerTurn) {
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    computerTurn(null);
                }
            }, 1000);
        }
    }

    public void reset(View v) {
        yourscore = compscore = turnscore = 0;
        isPlayerTurn = true;
        updateUi(null);
    }

    public void computerTurn(View v) {
        //roll.isEnabled();
        if (!isPlayerTurn) {
            if (turnscore < 20) {
                roll(null);
                new android.os.Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        computerTurn(null);
                    }
                }, 1000);
            } else hold(null);
        }
    }

    public void updateUi(View v) {
        ys.setText(yscore + yourscore);
        cs.setText(cscore + compscore);
        ts.setText(tscore + turnscore);
        //Animation shake = AnimationUtils.loadAnimation(v.getContext(),R.anim.shake);

        dice.setImageResource(images[diceValue - 1]);
    }
}

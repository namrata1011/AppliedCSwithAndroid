package com.example.teasers;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class TeasersActivity extends AppCompatActivity {

    TextView display;
    ArrayList<String> description = new ArrayList<>();
    Button D1,D2, D3, D4, D5, D6, start;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teasers);

        D1 = (Button) findViewById(R.id.Day1);
        D2 = (Button) findViewById(R.id.Day2);
        D3 = (Button) findViewById(R.id.Day3);
        D4 = (Button) findViewById(R.id.Day4);
        D5 = (Button) findViewById(R.id.Day5);
        D6 = (Button) findViewById(R.id.Day6);
        //start = (Button) findViewById(R.id.start);

    }


    public void showDescription(View sender){

        //day1 pe click = description show (use Intent) description.xml
        //button id se
        Intent i = new Intent(TeasersActivity.this, DescriptionActivity.class);
        int id= sender.getId();
        Bundle bundle = new Bundle();
        String res = getResources().getResourceEntryName(sender.getId());
        bundle.putString("button_id",res);
        switch(id){

            case R.id.Day1 :

                i.putExtra("desc", "On Day1 we learnt about what is android, it's origin and details and how can one built an android app using Android Studio. Let's check out how much you know!");
                break;

            case R.id.Day2 :
                i.putExtra("desc", "Today we learnt about Anagrams and how can they be deployed as an android game using Hashmaps. We learnt about Hash maps and Hash keys. Let's see how much you remember.");
                break;

            case R.id.Day3 :
                i.putExtra("desc", "Making your UI presentable is as much important as building your backend. Scarne's dice taught us to create the game more interesting by using animations and different logics.");
                break;

            case R.id.Day4 :
                i.putExtra("desc", "Today's game is developed using binary search. Let's see how much you know about the Algo and its implementation.");
                break;

            case R.id.Day5 :
                i.putExtra("desc", "Data Structures is an essential part of coding. TRIE helped us built today's game. Let's check out some interesting questions.");
                break;

            case R.id.Day6 :
                i.putExtra("desc", "Puzzle8! You surely have levelled up. Let' see how much you remember about making the app dynamic and creating the computer smart enough to solve the puzzle itself.");
                break;

            default: i.putExtra("desc", "error : Id not valid");
                break;
        }
        startActivity(i);



    }





}

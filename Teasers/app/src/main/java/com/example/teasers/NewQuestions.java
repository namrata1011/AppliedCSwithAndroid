package com.example.teasers;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class NewQuestions extends AppCompatActivity {
    ArrayList<Questions> Day1 = new ArrayList<>();
    TextView question;
    Button button1, button2, button3, button4, next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);       //file
        question = (TextView) findViewById(R.id.ques); //text view
        next = (Button) findViewById(R.id.next);
        button1 = (Button) findViewById(R.id.opta);
        button2 = (Button) findViewById(R.id.optb);
        button3 = (Button) findViewById(R.id.optc);
        button4 = (Button) findViewById(R.id.optd);

        String id = getIntent().getStringExtra("button_id");
        //id k acc apt function call ho addQuestions ka
        switch (id) {
            case "Day1": addQuestions1();
                break;

            default: break;
        }
    }

    private void addQuestions1()
    {
        Questions q1=new Questions("Which company is the largest manufacturer" +
                " of network equipment?","HP", "IBM", "CISCO", "TCS", "C");

        Questions q2=new Questions("Which of the following is NOT " +
                "an operating system?", "SuSe", "BIOS", "DOS","Linux", "B");

        Questions q3=new Questions("Which of the following is the fastest" +
                " writable memory?","RAM", "FLASH","Register","", "C");

        Questions q4=new Questions("Which of the following device" +
                " regulates internet traffic?","Router", "Bridge", "Hub"," ", "A");

        Questions q5=new Questions("Which of the following is NOT an" +
                " interpreted language?","Ruby","Python","BASIC", "", "C");

        Day1.add(q1);
        Day1.add(q2);
        Day1.add(q3);
        Day1.add(q4);
        Day1.add(q5);

    }

    public void start(View view){
        int score =0,i=0;
        for (i=0; i<Day1.size(); i++) {

            String newQues = Day1.get(i).getQUESTION();
            question.setText(newQues);
            button1.setText(Day1.get(i).getOPTA());
            button2.setText(Day1.get(i).getOPTB());
            button3.setText(Day1.get(i).getOPTC());
            button4.setText(Day1.get(i).getOPTD());

            //onclick listener me onclick func hoga
            final int finalI = i;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Handle view click here
                    String answer = Day1.get(finalI).getANSWER();

                }
            });


            //onclick func me - correct h and toh green bg.. else red bg

                    //getText button id se
                    //compare the string values - if true then green, score++ else red
                    //
            //wait android.hndler.postDelayed() - & toast
            //score update
        }
    }

    public void correctAnswer(){
        //

    }

}

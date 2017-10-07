package com.example.teasers;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    TextView display;
    Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);      //file
        display = (TextView)findViewById(R.id.description); //text view
        start = (Button)findViewById(R.id.start);

        String id = getIntent().getStringExtra("desc"); //DESC : key of putExtra
        display.setText(id);

    }

    public void start(View view) {

        String id = getIntent().getExtras().getString("button_id");
        Intent i = new Intent(DescriptionActivity.this, NewQuestions.class);
        i.putExtra("button_id", id);
        startActivity(i);

    }
}
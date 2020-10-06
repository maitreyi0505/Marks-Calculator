package com.example.experiment3;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;


public class MainActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button enterMarksButton = (Button) findViewById(R.id.enterMarksButton);
        enterMarksButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        Intent i = new Intent(MainActivity.this, EnterMarks.class);
                        startActivity(i);
                    }
                }
        );

        Button viewMarksButton = (Button) findViewById(R.id.viewAllMarksButton);
        viewMarksButton.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        Intent i = new Intent(MainActivity.this, ViewMarks.class);
                        startActivity(i);
                    }
                }
        );
    }
}

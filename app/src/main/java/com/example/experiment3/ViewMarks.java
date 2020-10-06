package com.example.experiment3;


import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewMarks extends Activity {


    TextView textView;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_marks);

        dbHandler = new DatabaseHandler(this, null, null, 2);

        textView=(TextView) findViewById(R.id.textView);
        String dbstring = dbHandler.databaseToString();
        textView.setText(dbstring);
    }
}

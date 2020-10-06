package com.example.experiment3;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class EnterMarks extends Activity {

    EditText enterName;
    EditText MC;
    EditText ACA;
    EditText FA;
    EditText ET;
    EditText deleteName;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_marks);
        enterName = (EditText) findViewById(R.id.name);
        MC= (EditText) findViewById(R.id.MC_marks);
        ACA= (EditText) findViewById(R.id.ACA_marks);
        FA= (EditText) findViewById(R.id.FA_marks);
        ET= (EditText) findViewById(R.id.ET_marks);
        deleteName=(EditText) findViewById(R.id.deleteName);
        dbHandler = new DatabaseHandler(this, null, null, 2);

    }

    public void reset() {
        // using this function to reset the string as empty
        enterName.setText("");
        MC.setText("");
        ACA.setText("");
        FA.setText("");
        ET.setText("");
        deleteName.setText("");
    }
    public void onAddEntryClick(View view){

        Marks marks = new Marks( enterName.getText().toString(), MC.getText().toString(),
                 ACA.getText().toString(), FA.getText().toString()
                , ET.getText().toString());
        dbHandler.addMarks(marks);
        reset();
    }
    public void onDeleteClick(View view){
        dbHandler.deleteMarks(deleteName.getText().toString());
        reset();
    }
}

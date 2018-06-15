package com.safdar.medicento.salesappmedicento;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class NewArea extends AppCompatActivity {
    EditText area,city,state,pincode;
    String areas,citys,states,pincodes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_area);
        area = (EditText) findViewById(R.id.newArea);
        city = (EditText) findViewById(R.id.newCity);
        state = (EditText) findViewById(R.id.newState);
        pincode = (EditText) findViewById(R.id.newPincode);
    }
    public void submitArea(View view) {
        areas = area.getText().toString();
        citys = city.getText().toString();
        states = state.getText().toString();
        pincodes = pincode.getText().toString();
        area.onEditorAction(EditorInfo.IME_ACTION_DONE);
        String method = "area";
        BackgroundTask backgroundTask = new BackgroundTask(this);
        backgroundTask.execute(method,areas,citys,states,pincodes);
        Intent intent = new Intent(NewArea.this,MainActivity.class);
        startActivity(intent);
    }
}

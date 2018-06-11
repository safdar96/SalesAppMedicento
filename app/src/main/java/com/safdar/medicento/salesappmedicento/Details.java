package com.safdar.medicento.salesappmedicento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Details extends AppCompatActivity {
    TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        text = (TextView) findViewById(R.id.details);
        Intent intent = getIntent();
        String texte = intent.getStringExtra("text");
        text.setText(texte);
    }
    public void goBack(View view) {
        Intent intent = new Intent(Details.this, MainActivity.class);
        startActivity(intent);
    }
}

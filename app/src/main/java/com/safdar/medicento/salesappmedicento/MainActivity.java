package com.safdar.medicento.salesappmedicento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mUsernameEditText,newPharma,newArea;
    EditText mPasswordEditText;
    TextWatcher mTextWatcher;
    TextView pharma,area;
    Button mSignInButton,addPharma,addArea;
    Spinner slots;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_area_details);
        slots = (Spinner) findViewById(R.id.slots);
        addArea = (Button) findViewById(R.id.area_button);
        addPharma = (Button) findViewById(R.id.pharma_button);
        newPharma = (EditText) findViewById(R.id.added_pharmacy);
        newArea = (EditText) findViewById(R.id.added_area);
        pharma = (TextView) findViewById(R.id.pharma);
        area = (TextView) findViewById(R.id.area);

        // Slots Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.slots,android.R.layout.simple_list_item_1);
        slots.setAdapter(adapter);

        //
        addArea.setOnClickListener(this);
        addPharma.setOnClickListener(this);

       /* initializeDataMembers();

        mSignInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean result = checkIfTheUserIsAuthenticated();
                if (result) {
                    Intent intent = new Intent();
                    startActivity(intent);
                }
            }
        });
    }
    private void initializeDataMembers() {
        mUsernameEditText = findViewById(R.id.username_edit_tv);
        mPasswordEditText = findViewById(R.id.password_edit_tv);
        mSignInButton = findViewById(R.id.sign_in_btn);

        mTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (mUsernameEditText.getText().toString().trim().length() > 0 &&
                        mPasswordEditText.getText().toString().trim().length() > 0) {
                    mSignInButton.setEnabled(true);
                } else {
                    mSignInButton.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
            }
        };

    }

    private boolean checkIfTheUserIsAuthenticated() {
        //To be implemented
        return true;
    }*/
    }

    @Override
    public void onClick(View v) {
        newPharma = (EditText) findViewById(R.id.added_pharmacy);
        newArea = (EditText) findViewById(R.id.added_area);
        pharma = (TextView) findViewById(R.id.pharma);
        area = (TextView) findViewById(R.id.area);
        switch(v.getId()) {
            case R.id.pharma_button:
                pharma.setText(newPharma.getText());
                break;
            case R.id.area_button:
                area.setText(newArea.getText());
                break;
        }
    }
}

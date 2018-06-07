package com.safdar.medicento.salesappmedicento;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText mUsernameEditText;
    EditText mPasswordEditText;
    TextWatcher mTextWatcher;
    Button mSignInButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDataMembers();

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
    }
}

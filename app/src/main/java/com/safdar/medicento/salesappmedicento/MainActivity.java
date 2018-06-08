package com.safdar.medicento.salesappmedicento;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText mUsernameEditText;
    EditText mPasswordEditText;
    TextWatcher mTextWatcher;
    Button mSignInButton,totalSales, oredrs, returns, earnings,profile;
    Spinner slots,pharma_spinner,area_spinner;
    CoordinatorLayout coordinatorLayout;
    View sales_person;
    BottomSheetBehavior bottomSheetBehavior;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_area_details);
        totalSales = (Button) findViewById(R.id.totalSales);
        oredrs = (Button) findViewById(R.id.orders);
        returns = (Button) findViewById(R.id.returns);
        earnings = (Button) findViewById(R.id.earnings);
        profile = (Button) findViewById(R.id.profile);
        slots = (Spinner) findViewById(R.id.slots);
        pharma_spinner = (Spinner) findViewById(R.id.pharmacy_spinner);
        area_spinner = (Spinner) findViewById(R.id.area_spinner);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.colayout);
        sales_person = coordinatorLayout.findViewById(R.id.bottom_sheet);

        bottomSheetBehavior = BottomSheetBehavior.from(sales_person);
        bottomSheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        //Spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.slots,android.R.layout.simple_list_item_1);
        slots.setAdapter(adapter);

        ArrayAdapter<CharSequence> padapter = ArrayAdapter.createFromResource(this,R.array.pharma,android.R.layout.simple_list_item_1);
        pharma_spinner.setAdapter(padapter);

        ArrayAdapter<CharSequence> aadapter = ArrayAdapter.createFromResource(this,R.array.area,android.R.layout.simple_list_item_1);
        area_spinner.setAdapter(aadapter);

        totalSales.setOnClickListener(this);
        oredrs.setOnClickListener(this);
        returns.setOnClickListener(this);
        earnings.setOnClickListener(this);
        profile.setOnClickListener(this);
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
        Intent intent;
        switch (v.getId()) {
            case R.id.totalSales: intent = new Intent(MainActivity.this, Details.class);
                                  intent.putExtra("text", ((Button)v).getText().toString());
                                  startActivity(intent);
                                  break;
            case R.id.orders:     intent = new Intent(MainActivity.this, Details.class);
                                  intent.putExtra("text", ((Button)v).getText().toString());
                                  startActivity(intent);
                                  break;

            case R.id.returns:    intent = new Intent(MainActivity.this, Details.class);
                                  intent.putExtra("text", ((Button)v).getText().toString());
                                  startActivity(intent);
                                  break;

            case R.id.earnings:   intent = new Intent(MainActivity.this, Details.class);
                                  intent.putExtra("text", ((Button)v).getText().toString());
                                  startActivity(intent);
                                  break;

            case R.id.profile:    intent = new Intent(MainActivity.this, SalesPersonDetails.class);
                                  intent.putExtra("text",((Button)v).getText());
                                  startActivity(intent);
                                  break;
        }
    }
}

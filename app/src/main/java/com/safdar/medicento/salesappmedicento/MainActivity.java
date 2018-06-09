package com.safdar.medicento.salesappmedicento;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button totalSales, oredrs, returns, earnings,profile,pharmab,areab;
    AutoCompleteTextView pharma_spinner,area_spinner;
    Spinner slots;
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
        pharmab = (Button) findViewById(R.id.pharmacyb);
        areab = (Button) findViewById(R.id.areab);
        pharma_spinner = (AutoCompleteTextView) findViewById(R.id.pharmacy_spinner);
        area_spinner = (AutoCompleteTextView) findViewById(R.id.area_spinner);
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

        Button btn = findViewById(R.id.add_new_area);
        btn.setOnClickListener(this);

        //Spinners
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.slots, android.R.layout.simple_list_item_1);
        slots.setAdapter(adapter);

        ArrayAdapter<CharSequence> padapter = ArrayAdapter.createFromResource(this, R.array.pharma, android.R.layout.simple_list_item_1);
        pharma_spinner.setAdapter(padapter);

        ArrayAdapter<CharSequence> aadapter = ArrayAdapter.createFromResource(this, R.array.area, android.R.layout.simple_list_item_1);
        area_spinner.setAdapter(aadapter);
        Button btn2 = findViewById(R.id.openPlaceOrder);

        btn2.setOnClickListener(this);
        totalSales.setOnClickListener(this);
        oredrs.setOnClickListener(this);
        returns.setOnClickListener(this);
        earnings.setOnClickListener(this);
        profile.setOnClickListener(this);
        areab.setOnClickListener(this);
        pharmab.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        pharma_spinner = (AutoCompleteTextView) findViewById(R.id.pharmacy_spinner);
        area_spinner = (AutoCompleteTextView) findViewById(R.id.area_spinner);
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
            case R.id.pharmacyb:  pharma_spinner.showDropDown();
                                  break;
            case R.id.areab:      area_spinner.showDropDown();
                                  break;
            case R.id.openPlaceOrder:
                intent = new Intent(this, PlaceOrderActivity.class);
                startActivity(intent);
                break;
        }
    }
}
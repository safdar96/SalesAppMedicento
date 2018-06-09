package com.safdar.medicento.salesappmedicento;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaceOrderActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String SELECTED_PHARMACY = "selected_pharmacy";
    AutoCompleteTextView mSelectPharmacyTv;
    TextView mErrorInPharmacyTv;
    AutoCompleteTextView mSelectMedicineTv;
    TextView mErrorInMedicineTv;
    TextView mSelectedMedicineTv;
    TextView mSelectedMedicineCompanyTv;
    TextView mSelectedMedicineRateTv;
    Button mIncQty;
    Button mDecQty;
    int mSelectedMedicineIndex;
    ListView mOrderedMedicinesListView;
    Spinner mPharmacySpinner, mMedicineSpinner;
    ArrayAdapter<CharSequence> mMedicineAdapter;
    ArrayAdapter<CharSequence> mPharmacyAdapter;
    public static OrderedMedicineAdapter mOrderedMedicineAdapter;
    InputMethodManager im;
    FloatingActionButton mProceedBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        setContentView(R.layout.activity_place_order);
        im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);

        setupGUIAndInitializeDataMembers();


        List<OrderedMedicine> medicines = new ArrayList<>();
        mOrderedMedicineAdapter = new OrderedMedicineAdapter(this, R.layout.item_ordered_medicine, medicines);
        mOrderedMedicinesListView.setAdapter(mOrderedMedicineAdapter);
    }

    private void showSelectedItemDetails(int pos) {
        mSelectedMedicineTv.setText(mMedicineAdapter.getItem(pos));
        mSelectedMedicineCompanyTv.setText("Cipla");
        mSelectedMedicineRateTv.setText("20");
        mSelectedMedicineIndex = pos;
    }

    private void setupGUIAndInitializeDataMembers() {

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_MODE_CHANGED);
        //Views Initialization////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mSelectPharmacyTv = findViewById(R.id.pharmacy_edit_tv);
        mErrorInPharmacyTv = findViewById(R.id.error_in_pharmacy_edit_tv);
        mSelectMedicineTv = findViewById(R.id.medicine_edit_tv);
        mErrorInMedicineTv = findViewById(R.id.error_in_medicine_edit_tv);
        mSelectedMedicineTv = findViewById(R.id.selected_medicine);
        mSelectedMedicineCompanyTv = findViewById(R.id.selected_medicine_company);
        mSelectedMedicineRateTv = findViewById(R.id.selected_medicine_rate);
        mIncQty = findViewById(R.id.inc_qty);
        mDecQty = findViewById(R.id.dec_qty);
        mOrderedMedicinesListView = findViewById(R.id.ordered_medicines_list);
        mProceedBtn = findViewById(R.id.proceed);

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        mIncQty.setOnClickListener(this);
        mDecQty.setOnClickListener(this);
        mProceedBtn.setOnClickListener(this);

        mPharmacyAdapter = ArrayAdapter.createFromResource(this, R.array.pharma, android.R.layout.simple_list_item_1);
        mSelectPharmacyTv.setAdapter(mPharmacyAdapter);
        mSelectPharmacyTv.setThreshold(0);

        mMedicineAdapter = ArrayAdapter.createFromResource(this, R.array.medicines, android.R.layout.simple_list_item_1);
        mSelectMedicineTv.setAdapter(mMedicineAdapter);
        mSelectMedicineTv.setThreshold(0);

        mSelectPharmacyTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectPharmacyTv.clearFocus();
            }
        });

        mSelectPharmacyTv.setValidator(new AutoCompleteTextView.Validator() {
            @Override
            public boolean isValid(CharSequence text) {
                if (mPharmacyAdapter.getPosition(text.toString()) == -1) {
                    mErrorInPharmacyTv.setVisibility(View.VISIBLE);
                    clearOrderShowcase();
                    return false;
                } else {
                    mErrorInPharmacyTv.setVisibility(View.GONE);
                    return true;
                }
            }

            @Override
            public CharSequence fixText(CharSequence invalidText) {
                return null;
            }
        });
        mSelectMedicineTv.setValidator(new AutoCompleteTextView.Validator() {
            @Override
            public boolean isValid(CharSequence text) {
                if (mMedicineAdapter.getPosition(text.toString()) == -1) {
                    mErrorInMedicineTv.setVisibility(View.VISIBLE);
                    clearOrderShowcase();
                    return false;
                } else {
                    mErrorInMedicineTv.setVisibility(View.GONE);
                    return true;
                }
            }

            @Override
            public CharSequence fixText(CharSequence invalidText) {
                return null;
            }
        });
        mSelectMedicineTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectMedicineTv.clearFocus();
                showSelectedItemDetails(position);
            }
        });
    }

    @Override
    public void onClick(View v) {
        OrderedMedicine orderedMedicine;
        im.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        if (v.getId() == R.id.proceed) {
            Intent intent = new Intent(this, ConfirmOrderActivity.class);
            intent.putExtra(SELECTED_PHARMACY, mSelectPharmacyTv.getText().toString());
            startActivity(intent);
            return;
        }
        if (isOrderShowcaseEmpty()) {
            Toast.makeText(this, "Please select some medicine!!", Toast.LENGTH_SHORT).show();
            return;
        }
        switch (v.getId()) {
            case R.id.inc_qty:
                orderedMedicine = new OrderedMedicine(mSelectedMedicineTv.getText().toString(),
                        mSelectedMedicineCompanyTv.getText().toString(),
                        1,
                        20,
                        20
                );
                mOrderedMedicineAdapter.add(orderedMedicine);
                break;
            case R.id.dec_qty:
                orderedMedicine = new OrderedMedicine(mSelectedMedicineTv.getText().toString(),
                        mSelectedMedicineCompanyTv.getText().toString(),
                        1,
                        20,
                        20
                );
                int qtyLeft = mOrderedMedicineAdapter.sub(orderedMedicine);
                if (qtyLeft == 0) {
                    clearOrderShowcase();
                }
                break;
        }
    }

    private void clearOrderShowcase() {
        mSelectedMedicineTv.setText("Name");
        mSelectedMedicineCompanyTv.setText("Company");
        mSelectedMedicineRateTv.setText("Rate");
        mSelectMedicineTv.setText("");
    }

    private boolean isOrderShowcaseEmpty() {
        if (mSelectedMedicineTv.getText().equals("Name") &&
                mSelectedMedicineCompanyTv.getText().equals("Company")) {
            return true;
        } else
            return false;
    }
}

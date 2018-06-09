package com.safdar.medicento.salesappmedicento;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ConfirmOrderActivity extends AppCompatActivity {
    TextView mSelectedPharmacyName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_order);

        Bundle b = getIntent().getExtras();

        mSelectedPharmacyName = findViewById(R.id.pharmacy_selected);
        mSelectedPharmacyName.setText(b.getString(PlaceOrderActivity.SELECTED_PHARMACY, ""));
        ListView listView = findViewById(R.id.ordered_medicines_list_confirmation);
        listView.setAdapter(PlaceOrderActivity.mOrderedMedicineAdapter);

        List<OrderedMedicine> list = PlaceOrderActivity.mOrderedMedicineAdapter.mList;


        float total = 0;
        for (OrderedMedicine ordMed: list) {
            total = total + ordMed.getCost();
        }
        TextView totalTv = findViewById(R.id.total_cost);
        totalTv.setText(String.valueOf(total));
    }
}
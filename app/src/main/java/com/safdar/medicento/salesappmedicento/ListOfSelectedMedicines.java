package com.safdar.medicento.salesappmedicento;

/*import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class ListOfSelectedMedicines implements Parcelable {
    private String name;
    private ArrayList<OrderedMedicine> mOrderedMedicines;

    public String getListName() {
        return name;
    }

    public void setListName(String name) {
        this.name = name;
    }

    protected ListOfSelectedMedicines(Parcel in) {
    }

    public static final Creator<ListOfSelectedMedicines> CREATOR = new Creator<ListOfSelectedMedicines>() {
        @Override
        public ListOfSelectedMedicines createFromParcel(Parcel in) {
            return new ListOfSelectedMedicines(in);
        }

        @Override
        public ListOfSelectedMedicines[] newArray(int size) {
            return new ListOfSelectedMedicines[size];
        }
    };

    public ArrayList<OrderedMedicine> getList() {
        return mOrderedMedicines;
    }

    public void setList(ArrayList<OrderedMedicine> list) {
        mOrderedMedicines = list;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        Bundle b = new Bundle();
        b.putParcelableArrayList("ordered_medicines", mOrderedMedicines);
        dest.writeBundle(b);
    }

}
*/
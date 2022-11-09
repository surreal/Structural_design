package com.itcm.structural_design.adapters;

import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;

import com.itcm.structural_design.R;

import static com.itcm.structural_design.activities.BasicActivity.context;

public class ArrayAdapterSpinner extends ArrayAdapter {
    public ArrayAdapterSpinner(@NonNull Object[] objects) {
        super(context, R.layout.layout_spinner_main_item, objects);
        setDropDownViewResource(R.layout.layout_spinner_dropdown_menu_item);
    }
}

package com.itcm.structural_design.interfaces;

import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public interface FragmentListener {
    void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition);
    void setRecycleView(RecyclerView relevantRecycleView, boolean isForSetValues, TextView secondaryTitle);
}

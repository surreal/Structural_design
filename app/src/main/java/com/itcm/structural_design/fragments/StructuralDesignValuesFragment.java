package com.itcm.structural_design.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.interfaces.FragmentListener;

import static com.itcm.structural_design.activities.BasicActivity.TAG_CHECK_VALUES;
import static com.itcm.structural_design.activities.BasicActivity.context;

public class StructuralDesignValuesFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) { super.onCreate(savedInstanceState); }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d("checkOnCreateView", "StructuralDesignValuesFragment{}");
        View inflateView = inflater.inflate(R.layout.fragment_sub_categories, container, false);
        RecyclerView recyclerView = inflateView.findViewById(R.id.fragment_structural_design_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        Log.d("checkOnCreateView", String.format("setRecycleView() -> values_RV.getId(): %s", recyclerView.getId()));
        TextView secondaryTitle_TV = inflateView.findViewById(R.id.fragment_sub_categories_secondary_title);
        ((FragmentListener) context).setRecycleView(recyclerView, true, secondaryTitle_TV);
        Log.d("checkOnCreateView", "StructuralDesignValuesFragment{} CREATED");
        return inflateView;
    }
}

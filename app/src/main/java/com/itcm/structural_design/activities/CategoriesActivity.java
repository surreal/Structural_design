package com.itcm.structural_design.activities;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.adapters.AdapterERV;
import com.itcm.structural_design.helpers_abstract.ArraysHelper;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;
import com.itcm.structural_design.models.ExGroupChildModel;
import com.itcm.structural_design.models.ExGroupGroupModel;

import java.util.ArrayList;

public class CategoriesActivity extends BasicActivity implements OnAsyncPostListener {

    public static final String CATEGORIES_ACTIVITY = "categories_activity";
    private boolean isFromDrawerRequested;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
    }

    private String getRelevantTitle() {
        switch (moduleActiveId) {
            case DESIGN_MODULE:
                return "תכן קונסטרוקציה";
            case CONCRETE_MODULE:
                return "בטון";
            case STEEL_MODULE:
                return "פלדה";
            default:
                return "";
        }
    }

    private void addGroupToArray(ArrayList<ExGroupGroupModel> groupList, String groupTitle, int arrayResourceId, int categoryId) {
        ArrayList<String> list = ArraysHelper.getResourceAList(arrayResourceId);
        ArrayList<ExGroupChildModel> childList = new ArrayList<>();
        int i = 0;
        for (String s : list) {
            i++;
            childList.add(new ExGroupChildModel(s, i));
        }
        groupList.add(new ExGroupGroupModel(childList, groupTitle, categoryId));
    }

    @Override
    protected void onStart() {
        super.onStart();
        castingBasic(getRelevantTitle(), categoryActiveId, CATEGORIES_ACTIVITY, null, this, this);
        RecyclerView recyclerView = findViewById(R.id.activity_structural_design_math_units_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        isFromDrawerRequested = getIntent().getBooleanExtra(IS_FROM_DRAWER_REQUESTED, false);
        ArrayList<ExGroupGroupModel> groupList = new ArrayList<>();
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                addGroupToArray(groupList, "תסבולת כפיפה", R.array.bending_tolerance_sub_categories,BENDING_TOLERANCE_CATEGORY);
                addGroupToArray(groupList, "אורכי חפיה", R.array.canopy_lengths_sub_categories, CANOPY_LENGTHS_CATEGORY);
                addGroupToArray(groupList, "חדירה", R.array.penetration_sub_categories, PENETRATION_CATEGORY);
                addGroupToArray(groupList, "עמוד", R.array.paging_sub_categories, PAGING_CATEGORY);
                break;
            case STEEL_MODULE:
                addGroupToArray(groupList, "תסבולת קורות", R.array.steel_ceiling_sub_categories, STEEL_CEILING_CATEGORY);
//                titles.add("תסבולת קורות");
                break;
        }

        AdapterERV adapterERV = new AdapterERV(groupList);
        recyclerView.setAdapter(adapterERV);

    }

    @Override
    public void onBackPressed() {
        if (isFromDrawerRequested) {
            context.startActivity(new Intent(context, ModulesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
        super.onBackPressed();
    }

    @Override
    public void onAsyncPostResult(String... result) {

    }
}

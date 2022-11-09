package com.itcm.structural_design.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.adapters.AdapterVersionsRV;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;

public class SavedVersionsActivity extends BasicActivity implements OnAsyncPostListener {

    public final static String SAVED_VERSIONS_ACTIVITY = "saved_versions_activity";
    private String title, secondaryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_versions);
        secondaryTitle = getIntent().getStringExtra(TITLE);
        title = toolbarTitle;
    }

    @Override
    protected void onStart() {
        super.onStart();
        castingBasic(title, categoryActiveId, SAVED_VERSIONS_ACTIVITY, null, this, this);
        casting();
    }

    private void casting() {
        TextView newVersion_TV = findViewById(R.id.layout_one_button_btn_tv);
        newVersion_TV.setText(getString(R.string.new_math_version));
        Log.d("checkContext", "context == " + context);
        newVersion_TV.setOnClickListener(view -> { if (context == SavedVersionsActivity.this) activity.startActivityForResult(new Intent(context, SubCategoriesManagerActivity.class), 0); });
        ((TextView) findViewById(R.id.activity_saved_versions_secondary_title_tv)).setText(secondaryTitle);
        setAdapter();
    }

    private void setAdapter() {
        RecyclerView recyclerView = findViewById(R.id.activity_saved_versions_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        sql = String.format("SELECT * FROM %s WHERE %s=%s AND %s=%s", DBModel.VALUES_TABLE, DBModel.COLUMN_MODULE_ID, moduleActiveId, DBModel.COLUMN_CATEGORY_ID, categoryActiveId);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        Log.d("checkSetValues", "; cursor.getCount() == " + cursor.getCount() + "; moduleActiveId == " + moduleActiveId  + "; categoryActiveId == " + categoryActiveId);
        recyclerView.setAdapter(new AdapterVersionsRV(cursor));
    }

    @Override
    public void onAsyncPostResult(String... result) {

    }
}

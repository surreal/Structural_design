package com.itcm.structural_design.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.itcm.structural_design.R;

public class AboutActivity extends BasicActivity {

    public static final String ABOUT_ACTIVITY = "ABOUT_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        castingBasic(getString(R.string.about), categoryActiveId, ABOUT_ACTIVITY, null, this, this);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startRelevantActivityCloseDrawerStartActivity(ModulesActivity.class, -1);
    }
}
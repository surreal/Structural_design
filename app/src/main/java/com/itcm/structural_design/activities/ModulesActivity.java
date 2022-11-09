package com.itcm.structural_design.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.cardview.widget.CardView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.SQLChecker;
import com.itcm.structural_design.firebase_and_google.FirebaseHelper;
import com.itcm.structural_design.helpers.Internet;

import java.math.RoundingMode;

public class ModulesActivity extends BasicActivity {

    public static final String MODULES_ACTIVITY = "MODULES_ACTIVITY";
    private CardView design_CV, steel_CV, concrete_CV, statics_CV;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules);
        double d = 2.0;
        int i;

        Log.d("checkOnCreateSomeVal", "i == " + formatNumberDecimal(12.0, RoundingMode.UP, "#"));
        //firebaseHelper.sendGCM("");
        activity = this;
        context = this;
        activityActiveId = MODULES_ACTIVITY;
        Internet.checkPermissions();
        Internet.isInternetConnected();
        new FirebaseHelper().setAnalyticsSelectContentEvent(ModulesActivity.MODULES_ACTIVITY);
        SQLChecker.checkTable();
//        mathId_12();
//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_APP_CALCULATOR);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }

    private String mathId_12() {
        try {
            double id_12_value = -1 / 0.0;
            Log.d("checkMath", "mathId_12() -> id_12_value == " + id_12_value);
            if (Double.isNaN(id_12_value) || id_12_value == Double.POSITIVE_INFINITY || id_12_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_12_value) + "";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_12() -> EXCEPTION -> " + e.getMessage());
            return getString(R.string.not_valid_cut);
        }
    }

    private void setRunningMessage() {
        TextView runningText_TV = findViewById(R.id.activity_modules_running_text_tv);
        runningText_TV.setMovementMethod(new ScrollingMovementMethod());
        handler = new Handler();
        runnable = () -> {
            runningText_TV.scrollBy(0, 1);
            if (context == ModulesActivity.this){
                if (runningText_TV.canScrollVertically(1)) {
                    handler.postDelayed(runnable,50);
                } else {
                    runningText_TV.scrollTo(0,0);
                    handler.postDelayed(runnable,50);
                }
            } else {
                handler.post(null);
            }
            Log.d("checkRunnable", "RUNNING..." + context);
        };
        handler.post(runnable);
    }


    @Override
    protected void onStart() {
        super.onStart();
        moduleActiveId = 0;
        castingBasic(getString(R.string.building_engineering_design), 0, MODULES_ACTIVITY, null, this, this);
        casting();
        //setRunningMessage();
    }

    private void casting() {
        design_CV = findViewById(R.id.activity_modules_concrete_card_view);
        steel_CV = findViewById(R.id.activity_modules_steel_card_view);
        concrete_CV = findViewById(R.id.activity_modules_design_card_view);
        statics_CV = findViewById(R.id.activity_modules_statics_card_view);
        ((TextView) findViewById(R.id.activity_modules_hello_msg_tv)).setText(getString(R.string.hello_msg, currentUserNameGlobal));
        initListeners();
    }

    private void initListeners() {
        design_CV.setOnClickListener(onClickListener);
        steel_CV.setOnClickListener(onClickListener);
        concrete_CV.setOnClickListener(onClickListener);
        statics_CV.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = view -> {
        switch (view.getId()){
            case R.id.activity_modules_design_card_view:
                if (context == ModulesActivity.this) {
                    moduleActiveId = DESIGN_MODULE;
                    //startActivityForResult(new Intent(context, CategoriesActivity.class), 0);
                    dialogHelper.initOneButtonDialog("המודול בבניה");
                }
                break;
            case R.id.activity_modules_concrete_card_view:
                if (context == ModulesActivity.this) {
                    moduleActiveId = CONCRETE_MODULE;
                    startActivityForResult(new Intent(context, CategoriesActivity.class), 0);
                }
                break;
            case R.id.activity_modules_steel_card_view:
                moduleActiveId = STEEL_MODULE;
                if (context == ModulesActivity.this){
                    startActivityForResult(new Intent(context, CategoriesActivity.class), 0);
                }
                break;
            case R.id.activity_modules_statics_card_view:
                    if (context == ModulesActivity.this){
//                        startActivityForResult(new Intent(context, ProfessionalRecommendationsActivity.class), 0);
                        dialogHelper.initOneButtonDialog("המודול בבניה");
                    }
                break;
        }
    };


}

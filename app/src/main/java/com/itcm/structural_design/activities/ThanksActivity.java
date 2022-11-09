package com.itcm.structural_design.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.itcm.structural_design.R;

public class ThanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);
        Toast.makeText(this, R.string.request_received, Toast.LENGTH_LONG).show();
        new Handler().postDelayed(() -> startActivity(new Intent(ThanksActivity.this, ModulesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK)),6000);
    }
}
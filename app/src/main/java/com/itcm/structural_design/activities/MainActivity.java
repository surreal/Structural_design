package com.itcm.structural_design.activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseUser;
import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLLocal;
import com.itcm.structural_design.firebase_and_google.FirebaseHelper;

import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.cursor;
import static com.itcm.structural_design.activities.BasicActivity.currentUserEmailGlobal;
import static com.itcm.structural_design.activities.BasicActivity.currentUserNameGlobal;

@SuppressLint("Range")
public class MainActivity extends AppCompatActivity {

    public static final String MAIN_ACTIVITY = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        activityActiveId = MAIN_ACTIVITY;
        FirebaseHelper firebaseHelper = new FirebaseHelper();
        FirebaseUser currentUser = firebaseHelper.getCurrentUser();
//        currentUser.sendEmailVerification().addOnFailureListener(e -> {
//            Log.d("checkLoginDetails", "ERROR sendEmailVerification() == " + e.getMessage());
//        }).addOnSuccessListener(aVoid -> {
//            Log.d("checkLoginDetails", "SUCCESSFUL sendEmailVerification()");
//        });
        if (currentUser == null){
            Log.d("checkLoginDetails", "currentUser.getEmail() == NULL");
            startActivity(new Intent(this, AuthenticationActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        } else {
//            firebaseHelper.getTokeId();
            Log.d("checkLoginDetails", "currentUser.getEmail() == " + currentUser.getEmail() + "; currentUser.getMetadata().getLastSignInTimestamp() == " + currentUser.getMetadata().getLastSignInTimestamp() + "; currentUser.getMetadata().getCreationTimestamp() == " + currentUser.getMetadata().getCreationTimestamp());
            Log.d("checkLoginDetails", "currentUser.getDisplayName() == " + currentUser.getDisplayName() + "; currentUser.getPhoneNumber() == " + currentUser.getPhoneNumber() + "; currentUser.getUid() == " + currentUser.getUid());
            SQLLocal sqlLocal = new SQLLocal();
            cursor = sqlLocal.selectAllFromCursor(DBModel.USERS_TABLE);
            cursor.moveToLast();
            currentUserEmailGlobal = cursor.getString(cursor.getColumnIndex(DBModel.COLUMN_EMAIL));
            currentUserNameGlobal = cursor.getString(cursor.getColumnIndex(DBModel.COLUMN_NAME));
            startActivity(new Intent(this, ModulesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        }
        finish();
    }

}

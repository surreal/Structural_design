package com.itcm.structural_design.activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.email_helpers.SendEmailAsyncTask;
import com.itcm.structural_design.helpers.ProgressD;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;

public class ContactActivity extends BasicActivity implements OnAsyncPostListener {

    public static final String CONTACT_ACTIVITY = "ContactActivity";
    private TextView sendBtn_TV, subject_ET, description_ET;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        castingBasic(getString(R.string.contact), categoryActiveId, CONTACT_ACTIVITY, null, this, this);
        casting();
    }

    private void casting() {
        subject_ET = findViewById(R.id.activity_contact_subject_et);
        description_ET = findViewById(R.id.activity_contact_description_et);
        sendBtn_TV = findViewById(R.id.layout_one_button_btn_tv);
        sendBtn_TV.setText(getString(R.string.send));
        sendBtn_TV.setOnClickListener(view -> sendEmail());
    }

    @Override
    protected void onPause() {
        super.onPause();
        ProgressD.dismissDialog();
    }

    private void sendEmail() {

        if (subject_ET.getText().toString().isEmpty()) {
            subject_ET.requestFocus();
            subject_ET.setError(getString(R.string.cannot_be_empty));
            return;
        } else if (description_ET.getText().toString().isEmpty()){
            description_ET.requestFocus();
            description_ET.setError(getString(R.string.cannot_be_empty));
            return;
        }

        Log.d("checkSendEmail", "sendEmail()");
        ProgressD.showProgressDialog(getString(R.string.wait_please_sending_request), false);
        String content =
                "שם: " + currentUserNameGlobal +
                        "<br>" +
                        "דוא\"ל: " + currentUserEmailGlobal +
                        "<br>" +
                        "נושא הפניה: " + subject_ET.getText() +
                        "<br>" +
                        "תיאור הפניה: " + description_ET.getText().toString();
        String subject = "Build It -> " + "פנית הלקוח: " + currentUserEmailGlobal;
        new SendEmailAsyncTask().execute("realnameing@gmail.com", content);
    }

    @Override
    public void onAsyncPostResult(String... result) {
        switch (result[0]) {
            case SUCCESSFUL_EMAIL_SENT:
                startActivity(new Intent(context, ThanksActivity.class));
                finish();
                break;
            case EMAIL_SENT_ERROR:
                dialogHelper.initOneButtonDialog(getString(R.string.request_not_sent_try_again));
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startRelevantActivityCloseDrawerStartActivity(ModulesActivity.class, -1);
    }
}

package com.itcm.structural_design.helpers;

import android.app.ProgressDialog;
import android.content.DialogInterface;

import com.itcm.structural_design.R;

import static com.itcm.structural_design.activities.BasicActivity.context;

public abstract class ProgressD {

    private static ProgressDialog progressDialog;

    public static void showProgressDialog() {
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage(context.getString(R.string.wait_please_checking_data));
        progressDialog.show();
    }

    public static void showProgressDialog(String msg, DialogInterface.OnDismissListener onDismissListener) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setOnDismissListener(onDismissListener);
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    public static void showProgressDialog(boolean isCancelable) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(isCancelable);
        progressDialog.setMessage(context.getString(R.string.wait_please_checking_data));
        progressDialog.show();
    }

    public static void showProgressDialog(String msg, boolean isCancelable) {
        progressDialog = new ProgressDialog(context);
        progressDialog.setCancelable(isCancelable);
        progressDialog.setMessage(msg);
        progressDialog.show();
    }

    public static void dismissDialog() {
        if (progressDialog != null) progressDialog.dismiss();
    }

}

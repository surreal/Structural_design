package com.itcm.structural_design.activities;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.firebase_and_google.FirebaseHelper;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.helpers.Internet;
import com.itcm.structural_design.helpers.ProgressD;
import com.itcm.structural_design.interfaces.FirebaseResponseListener;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;

import java.io.File;
import java.util.Arrays;

public class ProfileActivity extends BasicActivity implements OnAsyncPostListener, FirebaseResponseListener {

    public final static String PROFILE_ACTIVITY = "ProfileActivity";
    private FirebaseHelper firebaseHelper;
    private EditText currentPassword_ET;
    private String currentPassword;
    private String newPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Internet.checkPermissions();
        firebaseHelper = new FirebaseHelper();
    }

    @Override
    protected void onStart() {
        super.onStart();
        castingBasic(getString(R.string.profile), 0, PROFILE_ACTIVITY, onToolBarBtnClickListener, this, this);
        casting();
    }

    View.OnClickListener onToolBarBtnClickListener = v -> {
        if (Internet.isInternetConnected()) {
            new DialogHelper().initTwoButtonsDialog(getString(R.string.logout_msg), getString(R.string.logout), getString(R.string.cancel), view -> {
                firebaseHelper.signOut();
                startActivity(new Intent(context, AuthenticationActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                sqlLocal.clearAllDBData();
                dialog.dismiss();
            }, null, R.color.colorRed);
        }
    };

    private void casting() {
        ((TextView) findViewById(R.id.activity_profile_name_tv)).setText(currentUserNameGlobal);
        ((TextView) findViewById(R.id.activity_profile_email_tv)).setText(currentUserEmailGlobal);
        LinearLayout resetPassBtnLayout = findViewById(R.id.activity_profile_reset_password_btn_ll);
        int authOption = sqlLocal.getIntFromUsersTable(DBModel.COLUMN_AUTH_OPTION);
        resetPassBtnLayout.setVisibility(authOption == 0 ? View.VISIBLE : View.GONE);
        findViewById(R.id.activity_profile_reset_password_btn_tv).setOnClickListener(view -> initResetPasswordDialog());
        findViewById(R.id.activity_profile_image_rl).setOnClickListener(view -> selectImageIntent());
        ImageView profileImage_IV = findViewById(R.id.activity_profile_image_iv);
        if (profileImageLocalPath != null && new File(profileImageLocalPath).exists())
            Glide.with(context).load(profileImageLocalPath).centerCrop().into(profileImage_IV);
    }

    public String getSelectedImagePathFromIntentData(Intent data) {
        Uri selectedImageUri = data.getData();
        String[] filePathColumn = {MediaStore.Images.Media.DATA};
        Cursor cursor = BasicActivity.context.getContentResolver().query(selectedImageUri, filePathColumn, null, null, null);
        cursor.moveToFirst();
        String picturePath = cursor.getString(cursor.getColumnIndexOrThrow(filePathColumn[0]));
        cursor.close();
        Log.i("checkImageHelper", "getSelectedImagePathFromIntentData() - > filePathColumn == " + Arrays.toString(filePathColumn));
        Log.i("checkImageHelper", "getSelectedImagePathFromIntentData() - > selectedImageUri == " + selectedImageUri);
        Log.i("checkImageHelper", "getSelectedImagePathFromIntentData() - > picturePath == " + picturePath);
        return picturePath;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG_CHECK_VALUES, String.format("requestCode: %s", requestCode));
        if (data != null) {
            profileImageLocalPath = getSelectedImagePathFromIntentData(data);
            Log.d("checkPaths", "userLogoLocalPath == " + profileImageLocalPath);
            sqlLocal.updateSet(DBModel.USERS_TABLE, DBModel.COLUMN_PROFILE_IMAGE_LOCAL_PATH, profileImageLocalPath);
            new SQLRemote(QUERY_TYPE_SYNC_USERS_TABLE_SINGLE_VAL, false).execute(DBModel.COLUMN_PROFILE_IMAGE_LOCAL_PATH, profileImageLocalPath);
//            new UploadFileAsyncTask(userPictureLocalPath, UPLOAD_PROFILE_PICTURE_REQUEST_CODE, false).execute("", "", getCurrentUserEmail(), "", userIdGlobal + "", "0");
        }
    }

    public void selectImageIntent() {
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        Log.d("checkImageHelper", "selectImageIntent() -> BasicActivity.activity == " + BasicActivity.activity);
        BasicActivity.activity.startActivityForResult(intent, 0);
    }

    private void initResetPasswordDialog() {
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_reset_password);
        TextView setPasswordBtn_TV;
        currentPassword_ET = dialog.findViewById(R.id.dialog_reset_password_current_password_et);
        EditText newPassword_ET = dialog.findViewById(R.id.dialog_reset_password_new_password_et);
        EditText confirmNewPassword_ET = dialog.findViewById(R.id.dialog_reset_password_new_password_confirm_et);
        setPasswordBtn_TV = dialog.findViewById(R.id.dialog_reset_password_reset_password_btn_tv);
        setPasswordBtn_TV.setOnClickListener(view -> {
            currentPassword = currentPassword_ET.getText().toString();
            newPassword = newPassword_ET.getText().toString();
            String confirmNewPassword = confirmNewPassword_ET.getText().toString();
            if (currentPassword.equals("")) {
                currentPassword_ET.setError(getString(R.string.cannot_be_empty));
                currentPassword_ET.requestFocus();
            } else if (currentPassword.length() < 6) {
                currentPassword_ET.setError(getString(R.string.minimum_6_characters));
                currentPassword_ET.requestFocus();
            } else if (newPassword.equals("")) {
                newPassword_ET.setError(getString(R.string.cannot_be_empty));
                newPassword_ET.requestFocus();
            } else if (!newPassword.equals(confirmNewPassword)) {
                confirmNewPassword_ET.setError(getString(R.string.passwords_not_match));
                confirmNewPassword_ET.requestFocus();
            } else {
                ProgressD.showProgressDialog(false);
                new SQLRemote(QUERY_TYPE_CHANGE_PASSWORD, false).execute("0", currentUserEmailGlobal, currentPassword, newPassword);
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(context, ModulesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }

    @Override
    public void onAsyncPostResult(String... result) {
        Log.d("checkResult", "result[0] == " + result[0]);
        if (result[0].equals(WRONG_PASSWORD)) {
            ProgressD.dismissDialog();
            currentPassword_ET.setError(getString(R.string.wrong_password));
            Toast.makeText(context, context.getString(R.string.wrong_password), Toast.LENGTH_LONG).show();
        } else if (result[0].equals(UPDATED)) {
            Log.d("checkResult", "currentPassword == " + currentPassword + "; newPassword == " + newPassword + "; currentUserEmailGlobal == " + currentUserEmailGlobal);
            new FirebaseHelper().updatePassword(currentUserEmailGlobal, currentPassword, newPassword);
        }
    }

    @Override
    public void onFirebaseResponse(String... result) {
        ProgressD.dismissDialog();
        if (result[0].equals(UPDATE_PASSWORD_SUCCESSFUL)) {
            Toast.makeText(context, "סיסמה הוחלפה", Toast.LENGTH_LONG).show();
            dialog.dismiss();
            Log.d("checkResult", "Password updated");
        } else Toast.makeText(context, R.string.password_is_not_changed, Toast.LENGTH_LONG).show();
    }

}

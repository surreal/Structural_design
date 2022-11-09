package com.itcm.structural_design.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.email_helpers.MessagesContentHelper;
import com.itcm.structural_design.email_helpers.SendEmailAsyncTask;
import com.itcm.structural_design.firebase_and_google.FirebaseHelper;
import com.itcm.structural_design.firebase_and_google.GoogleHelper;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.helpers.Internet;
import com.itcm.structural_design.helpers.KeyboardHelper;
import com.itcm.structural_design.helpers.ProgressD;
import com.itcm.structural_design.interfaces.FirebaseResponseListener;
import com.itcm.structural_design.interfaces.OnAsyncPostUserDetailsListener;
import com.itcm.structural_design.models.UserModel;

import java.util.regex.Pattern;

import static com.itcm.structural_design.activities.BasicActivity.EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.FOUND;
import static com.itcm.structural_design.activities.BasicActivity.INSERT_USER_SUCCESSFUL;
import static com.itcm.structural_design.activities.BasicActivity.INTERNET_EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.NOT_FOUND;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_LOGIN_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_INSERT_USER;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_SEND_PASSWORD_EMAIL;
import static com.itcm.structural_design.activities.BasicActivity.SUCCESSFUL_EMAIL_SENT;
import static com.itcm.structural_design.activities.BasicActivity.SUCCESSFUL_LOGIN;
import static com.itcm.structural_design.activities.BasicActivity.TAG_CHECK_VALUES;
import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.currentUserEmailGlobal;
import static com.itcm.structural_design.activities.BasicActivity.currentUserNameGlobal;
import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.sqLiteDatabase;
import static com.itcm.structural_design.activities.BasicActivity.sql;
import static com.itcm.structural_design.firebase_and_google.GoogleHelper.GOOGLE_RC;

public class AuthenticationActivity extends AppCompatActivity implements OnAsyncPostUserDetailsListener, FirebaseResponseListener {

    public static final String AUTHENTICATION_ACTIVITY = "AUTHENTICATION_ACTIVITY";

    private EditText name_ET, email_ET, password_ET, confirmPassword_ET;
    private TextView loginBtn_TV, registerBtn_TV, forgotPassword_TV;
    private TextInputLayout name_TIL, password_TIL, confirmPassword_TIL;

    private String email, password, name, tokenID, profileImagePath;
    private boolean isOnRequestSent = false;
    private FirebaseHelper firebaseHelper;
    private int authOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication);
        activityActiveId = AUTHENTICATION_ACTIVITY;
        context = this;
        activity = this;
        new GoogleHelper().signOut();
        casting();
    }

    private void casting() {
        email_ET = findViewById(R.id.activity_login_email_et);
        name_ET = findViewById(R.id.activity_login_name_et);
        password_ET = findViewById(R.id.activity_login_password_et);
        confirmPassword_ET = findViewById(R.id.activity_authentication_confirm_password_et);
        loginBtn_TV = findViewById(R.id.layout_two_buttons_btn_2_tv);
        registerBtn_TV = findViewById(R.id.layout_two_buttons_btn_1_tv);
        name_TIL = findViewById(R.id.activity_login_name_text_til);
        password_TIL = findViewById(R.id.activity_login_password_til);
        confirmPassword_TIL = findViewById(R.id.activity_authentication_confirm_password_til);
        View relView = findViewById(R.id.activity_login_layout_one_button_forgot_password_view);
        forgotPassword_TV = relView.findViewById(R.id.layout_one_button_btn_tv);
        relView = findViewById(R.id.activity_login_layout_one_button_verify_and_continue_view);
        TextView continue_TV = relView.findViewById(R.id.layout_one_button_btn_tv);
        continue_TV.setText(R.string.next);
        continue_TV.setOnClickListener(onContinueClickListener);
        continue_TV.setOnClickListener(onContinueClickListener);

        loginBtn_TV.setText(R.string.login);
        registerBtn_TV.setText(R.string.register);
        forgotPassword_TV.setText(R.string.forgot_password);

        loginBtn_TV.setSelected(true);

        loginBtn_TV.setOnClickListener(onOptionsClickListener);
        registerBtn_TV.setOnClickListener(onOptionsClickListener);
        forgotPassword_TV.setOnClickListener(onOptionsClickListener);
        findViewById(R.id.activity_login_google_sign_in_tv).setOnClickListener(v -> new GoogleHelper().signIn());
    }

    View.OnClickListener onOptionsClickListener = view -> {
        loginBtn_TV.setSelected(view == loginBtn_TV);
        registerBtn_TV.setSelected(view == registerBtn_TV);
        forgotPassword_TV.setSelected(view == forgotPassword_TV);
        password_TIL.setVisibility(view != forgotPassword_TV ? View.VISIBLE : View.GONE);
        confirmPassword_TIL.setVisibility(view == registerBtn_TV ? View.VISIBLE : View.GONE);
        name_TIL.setVisibility(view == registerBtn_TV ? View.VISIBLE : View.GONE);
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d(TAG_CHECK_VALUES, String.format("requestCode: %s; resultCode: %s;", requestCode, resultCode));
        if (requestCode == GOOGLE_RC && resultCode != 0) getGoogleProfileProperties(data);
    }

    private void getGoogleProfileProperties(Intent data) {
        Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
        try {
            GoogleSignInAccount account = task.getResult(ApiException.class);
            Log.d("googleSignInStatus", "account.getId(): " + account.getId());
            Log.d("googleSignInStatus", "account.getEmail(): " + account.getEmail());
            Log.d("googleSignInStatus", "account.getGivenName(): " + account.getGivenName());
            Log.d("googleSignInStatus", "account.getDisplayName(): " + account.getDisplayName());
            Log.d("googleSignInStatus", "account.getIdToken(): " + account.getIdToken());
            email = account.getEmail();
            name = account.getDisplayName();
            tokenID = account.getIdToken();
            checkUserOutside(QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE);
            currentUserEmailGlobal = account.getEmail();
            currentUserNameGlobal = account.getGivenName();
        } catch (ApiException e) {
            tokenID = null;
            Toast.makeText(context, R.string.sign_in_isnt_complete_try_again, Toast.LENGTH_LONG).show();
            Log.e("googleSIgnInStatus", "Google sign in failed", e);
        }
    }

    private boolean getIsEmailWrong(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return !pattern.matcher(email).matches();
    }

    private void checkUserOutside(String queryType) {
        if (Internet.isInternetConnected()) {
            authOption = queryType.equals(QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE) ? 1 : 0;
            if (!isOnRequestSent) {
                isOnRequestSent = true;
                ProgressD.showProgressDialog(false);
                new SQLRemote(queryType, false).execute(email, password);
            }
        }
    }

    private void sendPassword() {
        email = email_ET.getText().toString().toLowerCase().trim();
        if (email.equals("") || getIsEmailWrong(email)) {
            email_ET.requestFocus();
            email_ET.setError(getString(R.string.email_wrong));
        } else checkUserOutside(QUERY_TYPE_SEND_PASSWORD_EMAIL);
    }

    private void login() {
        email = email_ET.getText().toString().toLowerCase().trim();
        password = password_ET.getText().toString().trim();
        if (email.equals("") || getIsEmailWrong(email)) {
            email_ET.setError(getString(R.string.email_wrong));
        } else if (password.equals("")) {
            password_ET.setError(getString(R.string.cant_be_empty));
        } else if (password.length() < 6) {
            password_ET.setError(getString(R.string.minimum_6_characters));
        } else {
            Log.d("checkIsRequestSent", "isOnRequestSent == " + isOnRequestSent + "; Internet.isInternetConnected(context) == " + Internet.isInternetConnected());
            Log.d("checkLogin", "password == " + password + "; password.length() == " + password.length());
            checkUserOutside(QUERY_TYPE_CHECK_LOGIN_AVAILABLE);
        }
    }

    private void signUp() {
        name = name_ET.getText().toString().toLowerCase();
        email = email_ET.getText().toString().toLowerCase();
        password = password_ET.getText().toString().trim();
        String passwordConfirm = confirmPassword_ET.getText().toString().trim();
        if (Internet.isInternetConnected()) {
            if (name.equals("")) {
                name_ET.setError(getString(R.string.cannot_be_empty));
            } else if (email.equals("") || getIsEmailWrong(email)) {
                email_ET.setError(getString(R.string.email_wrong));
            } else if (password.trim().equals("")) {
                password_ET.setError(getString(R.string.cant_be_empty));
            } else if (password_ET.getText().toString().length() < 6) {
                password_ET.setError(getString(R.string.minimum_6_characters));
            } else if (!passwordConfirm.equals(password)) {
                confirmPassword_ET.setError(getString(R.string.passwords_not_match));
            } else {
                Log.d("checkIsRequestSent", "isOnRequestSent == " + isOnRequestSent);
                checkUserOutside(QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE);
            }
        }
    }

    View.OnClickListener onContinueClickListener = view -> {
        if (loginBtn_TV.isSelected())
            login();
        else if (registerBtn_TV.isSelected())
            signUp();
        else if (forgotPassword_TV.isSelected())
            sendPassword();
    };

    @Override
    public void onAsyncPostUserDetailsResult(UserModel userModel, String request, String response) {
        new KeyboardHelper().hideKeyboard();
//        email = userModel.getEmail();
        Log.d("checkAsyncFinishAction", "AuthenticationActivity{} -> email == " + email + "; password == " + password + "; request == " + request + "; response == " + response);
        isOnRequestSent = false;
        firebaseHelper = new FirebaseHelper();
        switch (request) {
            case EXCEPTION:
            case INTERNET_EXCEPTION:
                Toast.makeText(context, R.string.unexpected_error, Toast.LENGTH_LONG).show();
                ProgressD.dismissDialog();
                break;
            case QUERY_TYPE_INSERT_USER:
                if (response.equals(INSERT_USER_SUCCESSFUL)) {
                    profileImagePath = userModel.getProfileImagePath();
                    if (userModel.getAuthOption() == 0)
                        firebaseHelper.createStandardUser(email, password);
                    else firebaseHelper.authWithGoogle(tokenID);
                } else {
                    ProgressD.dismissDialog();
                    Toast.makeText(context, R.string.unexpected_error, Toast.LENGTH_LONG).show();
                }
                break;
            case QUERY_TYPE_CHECK_LOGIN_AVAILABLE:
                if (response.equals(NOT_FOUND)) {
                    Toast.makeText(context, getString(R.string.email_not_registered), Toast.LENGTH_LONG).show();
                    email_ET.setError(getString(R.string.email_not_registered));
                    email_ET.requestFocus();
                    ProgressD.dismissDialog();
                } else if (userModel.getAuthOption() != 0) {
                    new DialogHelper().initOneButtonDialog(getString(R.string.authenticated_with_google_msg));
                    ProgressD.dismissDialog();
                } else if (!userModel.getPassword().equals(password)) {
                    Toast.makeText(context, getString(R.string.wrong_password), Toast.LENGTH_LONG).show();
                    password_ET.setError(getString(R.string.wrong_password));
                    password_ET.requestFocus();
                    ProgressD.dismissDialog();
                } else {
                    profileImagePath = userModel.getProfileImagePath();
                    name = userModel.getFullName();
                    firebaseHelper.authWithEmailAndPassword(email, password);
                }
                break;
            case QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE:
                if (response.equals(NOT_FOUND))
                    new SQLRemote(QUERY_TYPE_INSERT_USER, false).execute(email, password, name, "0");
                else if (response.equals(FOUND)) {
                    email_ET.requestFocus();
                    email_ET.setError(getString(R.string.email_already_registered));
                    Toast.makeText(context, R.string.email_already_registered, Toast.LENGTH_LONG).show();
                    ProgressD.dismissDialog();
                }
                break;
            case QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE:
                if (response.equals(NOT_FOUND))
                    new SQLRemote(QUERY_TYPE_INSERT_USER, false).execute(email, password, name, "1");
                else if (response.equals(FOUND))
                    if (userModel.getAuthOption() == 0) {
                        new GoogleHelper().signOut();
                        new DialogHelper().initOneButtonDialog(getString(R.string.authenticated_with_email_password_msg));
                        ProgressD.dismissDialog();
                    } else {
                        profileImagePath = userModel.getProfileImagePath();
                        firebaseHelper.authWithGoogle(tokenID);
                    }
                break;
            case QUERY_TYPE_SEND_PASSWORD_EMAIL:
                ProgressD.dismissDialog();
                switch (response) {
                    case NOT_FOUND:
                        Toast.makeText(context, R.string.email_not_registered, Toast.LENGTH_LONG).show();
                        email_ET.setError(getString(R.string.email_not_registered));
                        break;
                    case FOUND:
                        Log.d("checkAsyncFinishAction", "AuthenticationActivity{} -> userModel.getAuthOption() == " + userModel.getAuthOption());
                        if (userModel.getAuthOption() != 0) {
                            Toast.makeText(context, getString(R.string.password_isnt_required_for_google_auth), Toast.LENGTH_LONG).show();
                            new DialogHelper().initOneButtonDialog(getString(R.string.password_isnt_required_for_google_auth));
                        } else {
                            new KeyboardHelper().hideKeyboard();
                            MessagesContentHelper messagesContentHelper = new MessagesContentHelper(userModel.getFullName(), userModel.getPassword());
                            new SendEmailAsyncTask().execute(email, messagesContentHelper.getRestorePasswordContent());
                        }
                        break;
                    case SUCCESSFUL_EMAIL_SENT:
//                        Toast.makeText(this, getString(R.string.email_sent), Toast.LENGTH_LONG).show();
//                        Toast.makeText(this,"hello",Toast.LENGTH_LONG).show();
                        Log.d("checkAsyncFinishAction", "AuthenticationActivity{} -> request == " + request + "; response == " + response);
                        break;
                    default:

                        break;
                }
                break;
        }
    }

    @Override
    public void onFirebaseResponse(String... result) {
        ProgressD.dismissDialog();
        Log.d("checkAuthResponseReceived", "result == " + result[0]);
        if (result[0].equals(SUCCESSFUL_LOGIN)) {
            new KeyboardHelper().hideKeyboard();
            onSuccessfulLoginAction();
        } else if (result[0].equals(INSERT_USER_SUCCESSFUL)) {
            Toast.makeText(getApplicationContext(), R.string.successfully_sign_up, Toast.LENGTH_LONG).show();
            firebaseHelper.authWithEmailAndPassword(email, password);
        }
    }

    public void onSuccessfulLoginAction() {
        sqLiteDatabase = new DBModel(context).getWritableDatabase();
        currentUserEmailGlobal = email;
        currentUserNameGlobal = name;
        sql = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s')",
                DBModel.USERS_TABLE, DBModel.COLUMN_EMAIL, DBModel.COLUMN_NAME, DBModel.COLUMN_PROFILE_IMAGE_LOCAL_PATH, DBModel.COLUMN_AUTH_OPTION,
                email, name, profileImagePath, authOption);
        sqLiteDatabase.execSQL(sql);
        Log.d("checkPhoneNumberKey", "BasicActivity{} -> email == " + email + "; name == " + name + "; authOption == " + authOption);
        Toast.makeText(this, getString(R.string.successfully_connected), Toast.LENGTH_LONG).show();
        startActivity(new Intent(context, ModulesActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
    }
}
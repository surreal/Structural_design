package com.itcm.structural_design.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLLocal;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.firebase_and_google.FirebaseHelper;
import com.itcm.structural_design.firebase_and_google.GoogleHelper;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.helpers.ProgressD;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.itcm.structural_design.activities.BasicActivity.FOUND;
import static com.itcm.structural_design.activities.BasicActivity.EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.INSERT_USER_SUCCESSFUL;
import static com.itcm.structural_design.activities.BasicActivity.INTERNET_EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_INSERT_USER;
import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.handler;
import static com.itcm.structural_design.activities.BasicActivity.sql;

public class RegistrationActivity extends AppCompatActivity implements OnAsyncPostListener {

    private static final String TAG = "GoogleActivity";

    private EditText email_ET, password_TV, confirmPassword_TV, name_TV;
    private FirebaseAuth firebaseAuth;
    private GoogleHelper googleHelper;
    private FirebaseHelper firebaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        casting();
        context = this;
        activity = this;
        handler = new Handler();
        firebaseAuth = FirebaseAuth.getInstance();
        googleHelper = new GoogleHelper();
        firebaseHelper = new FirebaseHelper();
    }

    private void casting() {
        email_ET = findViewById(R.id.activity_registration_email_et);
        password_TV = findViewById(R.id.activity_registration_password_et);
        confirmPassword_TV = findViewById(R.id.activity_authentication_confirm_password_et);
        name_TV = findViewById(R.id.activity_registration_name_et);
        findViewById(R.id.activity_registration_verify_and_continue).setOnClickListener(onClickListener);
        findViewById(R.id.activity_registration_login_tv).setOnClickListener(onClickListener);
        //findViewById(R.id.activity_registration_google_sign_in_tv).setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = view -> {
        switch (view.getId()){
            case R.id.activity_registration_verify_and_continue:
                registerNewUser();
                break;
            case R.id.activity_registration_login_tv:
                startActivity(new Intent(context, AuthenticationActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                break;
//            case R.id.activity_registration_google_sign_in_tv:
//                Intent signInIntent = googleHelper.getGoogleSignInClient().getSignInIntent();
//                startActivityForResult(signInIntent, RC_SIGN_IN);
//                break;
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());
        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(this, task -> {
                if (task.isSuccessful()) {
                    firebaseHelper = new FirebaseHelper();
                    // Sign in success, update UI with the signed-in user's information
                    firebaseHelper.subscribeToTopic("structural_design");
                    firebaseHelper.subscribeToTopic(firebaseHelper.getCurrentUser().getEmail().replace("@", "."));
                    firebaseHelper.setAnalyticsLogEvent("sign_up");
                    Log.d(TAG, "signInWithCredential:success");
                    Toast.makeText(context, "ההרשמה הצליחה", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.getException());
                    Toast.makeText(context, "שגיע! ההרשמה לא הצליחה אנא נסה שוב", Toast.LENGTH_LONG).show();
                }
        });
    }

    private boolean getIsEmailCorrect(String email){
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    public boolean isValidPassword(final String password) {
        Pattern pattern;
        Matcher matcher;
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{4,}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static boolean isPasswordValid(String password){
        // UserName Validation Pattern String
        final Pattern USER_NAME_PATTERN = Pattern.compile("^[a-zA-Z0-9@.#$%^&*_&\\\\]+$");

        if(USER_NAME_PATTERN.matcher(password).matches()){
            return true;
        }
        return false;
    }

    private void registerNewUser() {
        String name, email, password, confirmPassword;
        email = email_ET.getText().toString();
        password = password_TV.getText().toString();
        confirmPassword = confirmPassword_TV.getText().toString();
        name = name_TV.getText().toString();

        if (name.equals("")){
            email_ET.setError("שם לא יכול להיות ריק");
        } else if (!getIsEmailCorrect(email) || email.equals("")){
            email_ET.setError("דוא\"ל לא תקין");
            Toast.makeText(getApplicationContext(), "דוא\"ל לא תקין", Toast.LENGTH_LONG).show();
            return;
        } else if (password.length() < 6){
            password_TV.setError("סיסמה חייבת להיות 6 תוים");
            Toast.makeText(getApplicationContext(), "סיסמה חייבת להיות 6 תוים", Toast.LENGTH_LONG).show();
            return;
        } else if (!confirmPassword.equals(password)){
            confirmPassword_TV.setError("סיסמאות לא תואמות");
            Toast.makeText(getApplicationContext(), "סיסמאות לא תואמות", Toast.LENGTH_LONG).show();
            return;
        }
        ProgressD.showProgressDialog(false);
        new SQLRemote(QUERY_TYPE_INSERT_USER, false).execute(email, password, name);
    }

    @Override
    public void onAsyncPostResult(String... result) {
        Log.d("checkSetAsyncOnPostAction", "RegistrationActivity{}");
        ProgressD.dismissDialog();
        switch (result[0]){
            case EXCEPTION: case INTERNET_EXCEPTION: break;
            default:
                Log.d("checkSetAsyncOnPostAction", "RegistrationActivity{} email == " + result[1] + "; password == " + result[2] + "; name == " + result[3]);
                switch (result[0]){
                    case INSERT_USER_SUCCESSFUL:
                        firebaseAuth.createUserWithEmailAndPassword(result[1], result[2]).addOnCompleteListener(taskCUWAP -> {
                            if (taskCUWAP.isSuccessful()) {
                                //Toast.makeText(getApplicationContext(), "רגיסטרציה הצליחה!", Toast.LENGTH_LONG).show();
                                firebaseAuth.signInWithEmailAndPassword(result[1], result[2]).addOnCompleteListener(task -> {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(getApplicationContext(), "ההרשמה הציחה", Toast.LENGTH_LONG).show();
                                        Log.d("checkAsyncFinishAction", "signInWithCredential: success");
                                        firebaseHelper = new FirebaseHelper();
                                        firebaseHelper.subscribeToTopic("build_it");
                                        firebaseHelper.subscribeToTopic(firebaseHelper.getCurrentUser().getEmail().replace("@", "."));
                                        firebaseHelper.setAnalyticsLogEvent("sign_up");
                                        InputMethodManager inputManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                                        inputManager.hideSoftInputFromWindow(email_ET.getWindowToken(),0);
                                        sql = String.format("INSERT INTO %s (%s,%s) VALUES ('%s','%s')", DBModel.USERS_TABLE, DBModel.COLUMN_EMAIL, DBModel.COLUMN_NAME, result[1], result[3]);
                                        new SQLLocal().getSQLDatabase().execSQL(sql);
                                        Toast.makeText(getApplicationContext(), "ההרשמה בוצע", Toast.LENGTH_LONG).show();
                                        startActivity(new Intent(context, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK));
                                    } else {
                                        Toast.makeText(getApplicationContext(), "ההרשמה לא בוצע!", Toast.LENGTH_LONG).show();
                                        Log.d("checkAsyncFinishAction", "signInWithCredential: failure", task.getException());
                                    }
                                });
                            } else {
                                Toast.makeText(getApplicationContext(), "ההרשמה לא הצליחה!", Toast.LENGTH_LONG).show();
                            }
                        }).addOnFailureListener(e -> {
                            Log.d("checkSignUp", e.getMessage());
                        });

                        break;
                    case FOUND:
                        new DialogHelper().initOneButtonDialog("דוא\"ל זה רשום כבר במערכת שלנו, בצע התחברות או הרשם עם דו\"ל אחר.");
                        break;
                }
                break;
        }
    }
}

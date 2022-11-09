package com.itcm.structural_design.firebase_and_google;

import android.content.Intent;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.itcm.structural_design.R;

import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.context;

public class GoogleHelper {

    private final GoogleSignInClient mGoogleSignInClient;
    public static final int GOOGLE_RC = 9001;

    public GoogleHelper(){
        // Configure Google Sign In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(context.getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        // [END config_signin]
        mGoogleSignInClient = GoogleSignIn.getClient(activity, gso);
    }

    public GoogleSignInClient getGoogleSignInClient() { return mGoogleSignInClient; }

//    private void signIn() {
//        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
//        activity.startActivityForResult(signInIntent, RC_SIGN_IN);
//    }

    public void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        activity.startActivityForResult(signInIntent, GOOGLE_RC);
    }

    public void signOut() {
        // Google sign out
        mGoogleSignInClient.signOut();
    }
//    private void revokeAccess() {
//        // Google revoke access
//        mGoogleSignInClient.revokeAccess().addOnCompleteListener(this, task -> updateUI(null));
//    }
}

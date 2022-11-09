package com.itcm.structural_design.firebase_and_google;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
//import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;
import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.AuthenticationActivity;
import com.itcm.structural_design.activities.BasicActivity;
import com.itcm.structural_design.activities.ProfileActivity;
import com.itcm.structural_design.interfaces.FirebaseResponseListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import static com.itcm.structural_design.activities.BasicActivity.INSERT_USER_SUCCESSFUL;
import static com.itcm.structural_design.activities.BasicActivity.SUCCESSFUL_LOGIN;
import static com.itcm.structural_design.activities.BasicActivity.EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;

public class FirebaseHelper {

    public static final String TAG_CHECK_AUTHENTICATION = "TAG_CHECK_AUTHENTICATION";
    private final String TAG = "checkFirebaseHelper";
    private FirebaseResponseListener firebaseResponseListener;
    String token;
    private static FirebaseAuth firebaseAuth;
    private static FirebaseUser currentUser;
    private static FirebaseAnalytics mFirebaseAnalytics;
    private Bundle bundle;

    public FirebaseHelper() {
        // [START initialize_auth] Firebase Auth
        FirebaseApp.initializeApp(context);
        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
        switch (activityActiveId) {
            case AuthenticationActivity.AUTHENTICATION_ACTIVITY:
            case ProfileActivity.PROFILE_ACTIVITY:
                firebaseResponseListener = (FirebaseResponseListener) context;
                break;
        }
        Log.d("checkFirebaseUser", "FirebaseHelper{} getCurrentUser() -> " + currentUser);
        // [END initialize_auth]
    }

    public FirebaseAuth getFirebaseAuth() {
        return firebaseAuth;
    }

    public FirebaseUser getCurrentUser() {
        return currentUser;
    }

    public void createStandardUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(taskCUWAP -> {
            if (taskCUWAP.isSuccessful()) {
                Log.d(TAG_CHECK_AUTHENTICATION, "createStandardUser() -> SUCCESS");
//                authWithEmailAndPassword(email, password);
                firebaseResponseListener.onFirebaseResponse(INSERT_USER_SUCCESSFUL);
            }
//            else {
//                firebaseResponseListener.responseReceived(EXCEPTION_TAG);
//                Log.e(CHECK_AUTHENTICATION_TAG, "FAILURE -> createStandardUser() -> EXCEPTION -> taskCUWAP is not successful");
//            }
        }).addOnFailureListener(e -> {
            firebaseResponseListener.onFirebaseResponse(EXCEPTION);
            Log.e(TAG_CHECK_AUTHENTICATION, "FAILURE -> createStandardUser() -> exception == ", e);
        });
    }

    public void authWithEmailAndPassword(String email, String password) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Log.d(TAG_CHECK_AUTHENTICATION, "authWithEmailAndPassword() -> SUCCESS");
                currentUser = firebaseAuth.getCurrentUser();
                subscribeToTopic("build_it");
                subscribeToTopic(currentUser.getEmail().replace("@", "."));
                setAnalyticsLogEvent("sign_in");
                firebaseResponseListener.onFirebaseResponse(SUCCESSFUL_LOGIN);
            } else {
                Log.e(TAG_CHECK_AUTHENTICATION, "FAILURE -> authWithEmailAndPassword() -> exception == ", task.getException());
            }
        }).addOnFailureListener(e -> {
            firebaseResponseListener.onFirebaseResponse(EXCEPTION);
            Log.e(TAG_CHECK_AUTHENTICATION, "FAILURE -> authWithEmailAndPassword() -> exception == " + e.getMessage());
            e.printStackTrace();
        });
    }

    public void authWithGoogle(String idToken) {
        Log.d(TAG_CHECK_AUTHENTICATION, "authWithGoogle() -> idToken: " + idToken);
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(activity, task -> {
            if (task.isSuccessful()) {
                Log.d(TAG_CHECK_AUTHENTICATION, "authWithGoogle() -> OnCompleteListener() -> SUCCESSFUL_LOGIN");
                firebaseResponseListener.onFirebaseResponse(SUCCESSFUL_LOGIN);
            } else {
                firebaseResponseListener.onFirebaseResponse(EXCEPTION);
                Log.e(TAG_CHECK_AUTHENTICATION, "authWithGoogle() -> FAILURE exception == ", task.getException());
            }
        });
//        .addOnFailureListener(e -> {
//            Log.e(TAG_CHECK_AUTHENTICATION, "FAILURE -> authWithGoogle() -> exception == " + e.getMessage());
//            firebaseResponseListener.onFirebaseResponse(EXCEPTION);
//            e.printStackTrace();
//        });
//        .addOnSuccessListener(authResult -> {
//            Log.d(TAG_CHECK_AUTHENTICATION, "authWithGoogle() -> OnSuccessListener() -> SUCCESSFUL_LOGIN -> authResult: " + authResult.getUser().getDisplayName());
////            authWithGoogle(idToken);
//            firebaseResponseListener.onFirebaseResponse(SUCCESSFUL_LOGIN);
//        });
    }

    public void updatePassword(String email, String password, String newPassword) {
        AuthCredential credential = EmailAuthProvider.getCredential(email, password);
        currentUser.reauthenticate(credential).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                currentUser.updatePassword(newPassword).addOnCompleteListener(task1 -> {
                    if (task1.isSuccessful()) {
                        Log.d(TAG_CHECK_AUTHENTICATION, "updatePassword() -> SUCCESS");
                        firebaseResponseListener.onFirebaseResponse(BasicActivity.UPDATE_PASSWORD_SUCCESSFUL);
                    } else {
                        Log.e(TAG_CHECK_AUTHENTICATION, "updatePassword() -> EXCEPTION");
                    }
                });
            }
        }).addOnFailureListener(e -> {
            firebaseResponseListener.onFirebaseResponse(EXCEPTION);
            Log.e(TAG_CHECK_AUTHENTICATION, "updatePassword() -> EXCEPTION: ", e);
        });
    }


    // [END signin]
    public void signOut() {
        // Firebase sign out
        firebaseAuth.signOut();
    }

//    public String getTokeId() {
//        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(task -> {
//            if (!task.isSuccessful()) {
//                Log.w(TAG, "getTokeId() -> getInstanceId() ->  EXCEPTION: ", task.getException());
//                return;
//            }
//            // Get new Instance ID token
//            token = task.getResult().getToken();
//            String msg = context.getString(R.string.msg_token_fmt, token);
//            Log.d(TAG, "getTokeId() -> msg == " + msg);
//        });
//        return token;
//    }

    public void setAnalyticsSelectContentEvent(String activityActive) {
        mFirebaseAnalytics.setUserId(currentUser.getEmail());
        bundle = new Bundle();
        Log.d("setAnalyticsLogEvent", "currentUser.getEmail() == " + currentUser.getEmail());
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "activity_started");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, activityActive);
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);
    }

    public void setAnalyticsLogEvent(String login_sign_Up) {
        mFirebaseAnalytics.setUserId(currentUser.getEmail());
        bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.METHOD, login_sign_Up);
        mFirebaseAnalytics.logEvent(login_sign_Up, bundle);
    }

    // subscribeToTopic() used for sending notifications to users from Firebase console (topic can be group or single user)
    public void subscribeToTopic(String topic) {
        Log.d(TAG, "subscribeToTopic() -> Subscribing to " + topic + " topic");
        // [START subscribe_topics]
        FirebaseMessaging.getInstance().subscribeToTopic(topic).addOnCompleteListener(task -> {
            String msg = "subscribed";
            if (!task.isSuccessful()) {
                msg = "subscribe failed";
            }
            Log.d(TAG, "subscribeToTopic() -> msg == " + msg);
        });
    }

    public void unsubscribeToTopic(String topic) {
        Log.d(TAG, "unsubscribeToTopic() -> unSubscribing from " + topic);
        // [START subscribe_topics]
        FirebaseMessaging.getInstance().unsubscribeFromTopic(topic).addOnCompleteListener(task -> {
            String msg = "unsubscribed";
            if (!task.isSuccessful()) {
                msg = "unsubscribe failed";
            }
            Log.d(TAG, "unsubscribeToTopic() -> msg == " + msg);
//            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
        });
    }

    public void sendGCM(String tokenId) {
        try {
            String API_KEY = "AAAAKsHKInA:APA91bGP4fah0nj1nHbrH2sw7Y3oMh-jxNT9z91cHusodslf6ZtVLL5RiGu5gWOw9bmpKT4nDtzDSKR5zapoO16WOxaICKeKkM6ghBhEfRv47GiscRwEqZGY49M4Gz6Vwn9JWZXpvNkO";
            String tokenIdTest = "c0fPjlRhSByHQIuQqwjx0u:APA91bHKJ4f0XIL_KljsE75x3nbYKogMQIlATpv4OapaSDSTJMTCmTPVn7VX_UdWS4csFj7F04aDdOEK4jUzqg8_4Y8AkE1PrWutwfan3dQOLesdZWUr1AcwlpdZn78UeIG8CLeGX1vt";
            URL url = new URL("https://fcm.googleapis.com/fcm/send");
            // 2. Open connection
            HttpURLConnection urlConnection;
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            // 4. Set the headers
            urlConnection.setRequestProperty("Content-Type", "application/json");
            urlConnection.setRequestProperty("Authorization", "key=" + API_KEY);
            urlConnection.setDoOutput(true);
            // 5. Add JSON data into POST request body
            JSONObject obj = new JSONObject("{" +
                    "\"to\" : \"" + tokenIdTest + "\"," +
                    "\"collapse_key\" : \"type_a\"," +
                    "\"data\" : {" +
                    "\"body\" : \"Sending Notification Body From Data\"," +
                    "\"title\": \"Notification Title from Data\"," +
                    "\"key_1\" : \"Value for key_1\"," +
                    "\"key_2\" : \"Value for key_2\"" +
                    "}" +
                    "}");
            // 6. Get connection output stream
            OutputStreamWriter out = new OutputStreamWriter(urlConnection.getOutputStream());
            out.write(obj.toString());
            out.close();

            int responseCode = urlConnection.getResponseCode();
            BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            Log.d("checkSendGCM", "response == " + response + "; responseCode == " + responseCode);
            in.close();
        } catch (IOException | JSONException e) {
            Log.d("checkSendGCM", "EXCEPTION == " + e.getMessage());
            e.printStackTrace();
        }
    }

}

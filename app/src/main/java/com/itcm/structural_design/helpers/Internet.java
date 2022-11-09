package com.itcm.structural_design.helpers;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import androidx.core.app.ActivityCompat;

import com.itcm.structural_design.R;

import java.lang.reflect.Method;

import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.context;

public abstract class Internet {

  public static boolean isInternetConnected(){
    ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
    if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting()){
      Handler handler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(Message msg) {
          Toast.makeText(context, context.getString(R.string.network_error), Toast.LENGTH_LONG).show();
        }
      };
      handler.obtainMessage().sendToTarget();
    }
    return activeNetwork != null && activeNetwork.isConnectedOrConnecting();
  }

  public static void checkPermissions() {
    if (Build.VERSION.SDK_INT >= 23) {
      StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
      StrictMode.setThreadPolicy(policy);
    }
    if(Build.VERSION.SDK_INT>=24){
      try{
        Method m = StrictMode.class.getMethod("disableDeathOnFileUriExposure");
        m.invoke(null);
        Log.d("checkPermissions", "checkPermissions()");
        int isHasPermissionsWriteStorage = ActivityCompat.checkSelfPermission(context, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int isHasPermissionsReadStorage = ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE);
        int isHasPermissionsInternet = ActivityCompat.checkSelfPermission(context, Manifest.permission.INTERNET);
        if (isHasPermissionsWriteStorage != PackageManager.PERMISSION_GRANTED){
          activity.requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
        }
        if (isHasPermissionsReadStorage != PackageManager.PERMISSION_GRANTED){
          activity.requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }
        if (isHasPermissionsInternet != PackageManager.PERMISSION_GRANTED){
          activity.requestPermissions(new String[]{Manifest.permission.INTERNET}, 2);
        }
      }catch(Exception e){ e.printStackTrace(); }
    }
  }

}

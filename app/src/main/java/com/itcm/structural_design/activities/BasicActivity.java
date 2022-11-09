package com.itcm.structural_design.activities;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLHelper;
import com.itcm.structural_design.database.SQLLocal;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.views.Drawer;
import com.itcm.structural_design.views.ToolbarCustom;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class BasicActivity extends AppCompatActivity {

    public static final int BENDING_TOLERANCE_CATEGORY = 1;
    public static final int CANOPY_LENGTHS_CATEGORY = 2;
    public static final int PENETRATION_CATEGORY = 3;
    public static final int PAGING_CATEGORY = 4;
    public static final int STEEL_CEILING_CATEGORY = 1;
    public static final int DESIGN_MODULE = 1;
    public static final int CONCRETE_MODULE = 2;
    public static final int STEEL_MODULE = 3;

    public static final String OK = "OK";
    public static final String DIVIDE_BY_ZERO_EXCEPTION = "#/0";

    public static final String FROM_DRAWER_REQUEST = "FROM_DRAWER_REQUEST";
    public static final String NaN = "NaN";
    public static final String NEGATIVE_INFINITY = "NEGATIVE_INFINITY";
    public static final String IS_FROM_DRAWER_REQUESTED = "isFromDrawerRequested";
    public static final String INFINITY = "INFINITY";
    public static final String EXCEPTION = "EXCEPTION";
    public static final String SUCCESSFUL = "SUCCESSFUL";
    public static final String INTERNET_EXCEPTION = "INTERNET_EXCEPTION";
    public static final String QUERY_TYPE_INSERT_USER = "QUERY_TYPE_INSERT_USER";
    public static final String NOT_FOUND = "NOT_FOUND";
    public static final String FOUND = "FOUND";
    public static final String PASSWORD = "PASSWORD";
    public static final String CORRECT_PASSWORD = "CORRECT_PASSWORD";
    public static final String WRONG_PASSWORD = "WRONG_PASSWORD";
    public static final String UPDATED = "UPDATED";
    public static final String INSERT_USER_SUCCESSFUL = "INSERT_USER_SUCCESSFUL";
    public static final String INSERT_USER_ERROR = "INSERT_USER_ERROR";
    public static final String SAVED_VERSION_TITLE = "SAVED_VERSION_TITLE";
    public static final String SUB_CATEGORY_POSITION = "SUB_CATEGORY_POSITION";
    public static final String TITLE = "title";
    public static final String QUERY_TYPE_CHANGE_PASSWORD = "CHANGE_PASSWORD";
    public static final String QUERY_TYPE_INSERT_VALUES_OUTSIDE = "INSERT_VALUES_OUTSIDE";
    public static final String QUERY_TYPE_UPDATE_VALUES_OUTSIDE = "UPDATE_VALUES_OUTSIDE";
    public static final String QUERY_TYPE_SYNCHRONIZE_ALL_DATA_INSIDE = "SYNCHRONIZE_ALL_DATA_INSIDE";
    public static final String SUCCESSFUL_EMAIL_SENT = "SUCCESSFUL_EMAIL_SENT";
    public static final String PORT_CLOSED_ERROR = "PORT_CLOSED_ERROR";
    public static final String EMAIL_SENT_ERROR = "EMAIL_SENT_ERROR";
    public static final String SYNC_INSIDE_SUCCESS = "SYNC_INSIDE_SUCCESS";

    public static final String QUERY_TYPE_SEND_PASSWORD_EMAIL = "QUERY_TYPE_SEND_PASSWORD_EMAIL";
    public static final String QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE = "QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE";
    public static final String QUERY_TYPE_CHECK_LOGIN_AVAILABLE = "QUERY_TYPE_CHECK_LOGIN_AVAILABLE";
    public static final String QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE = "QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE";
    public static final String QUERY_TYPE_SYNC_USERS_TABLE_SINGLE_VAL = "QUERY_TYPE_SYNC_USERS_TABLE_SINGLE_VAL";

    public static final String SUCCESSFUL_LOGIN = "SUCCESSFUL_LOGIN";
    public static final String TAG_CHECK_VALUES = "TAG_CHECK_VALUES";
    public static final String UPDATE_PASSWORD_SUCCESSFUL = "UPDATE_PASSWORD_SUCCESSFUL";

    public static Context context;
    public static Activity activity;
    public static Handler handler;
    public static Dialog dialog;
    public static ArrayList<String> negativeResults;
    public static int categoryActiveId = 1, moduleActiveId = 1, subCategoryActiveId = 0;

    public static String currentUserNameGlobal = "", currentUserEmailGlobal = "", activityActiveId = "";
    public static DialogHelper dialogHelper;

    public static DrawerLayout drawerLayout;
    public static ActionBarDrawerToggle toggle;
    public static String toolbarTitle = "";
    public static String sql = "";
    public static Cursor cursor;
    public static SQLiteDatabase sqLiteDatabase;
    public static SQLLocal sqlLocal;
    public static ArrayList<String> secondaryTitles;
    public static String profileImageLocalPath;
    public static SQLHelper sqlHelper;

    public void castingBasic(String title, int categoryActive, String activityActiveId, View.OnClickListener onToolbarClickListener, Context context, Activity activity){
        this.categoryActiveId = categoryActive;
        this.activityActiveId = activityActiveId;
        this.context = context;
        this.activity = activity;
        handler = new Handler();
        setSupportActionBar(findViewById(R.id.toolbar_custom));
        new ToolbarCustom(this, getSupportActionBar(), title, onToolbarClickListener);
        dialogHelper = new DialogHelper();
        sqlLocal = new SQLLocal();
        sqlHelper = new SQLHelper();
        DBModel DBModel = new DBModel(context);
        sqLiteDatabase = DBModel.getWritableDatabase();
        new Drawer(activity);
        toggle.syncState();
        Log.d("checkCastingBasic", "title == " + title);
    }

    private String removeZeroesAtEnd(String number){
        String numberForReturn ="";
        int count = 0;
        for (int i = number.length()-1; i >= 1; i--){
            if((number.charAt(i)+"").equals("0")){
                count ++;
            } else { break; }
        }
        numberForReturn = number.substring(0, number.length()-count);
        Log.d("checkNumberFormat", "removeZeroesAtEnd() ->  == " + numberForReturn);
        return numberForReturn;
    }

    public String formatNumberDecimal(double number){
        Log.d("checkNumberFormat", "formatNumberDecimal() -> number == " + number);
        String numberForReturn;
        if (number == -0){ return "0.0"; }
        numberForReturn = String.format("%.4f", number);
        String decimalPart = (numberForReturn+"").split("\\.")[1];
        Log.d("checkNumberFormat", "formatNumberDecimal() -> numberForReturn == " + numberForReturn + "; decimalPart == " + decimalPart + "; decimalPart.length() == " + decimalPart.length());
        if (!(decimalPart.charAt(0) + "").equals("0") || !(decimalPart.charAt(1) + "").equals("0")) {
            decimalPart = decimalPart.substring(0, 2);
        }
        numberForReturn = numberForReturn.split("\\.")[0] + "." + removeZeroesAtEnd(decimalPart);
        return numberForReturn;
    }

    public String formatNumberDecimal(double number, int amountOfNumbersAfterDot){
        if (number == -0){ return "0.0"; }
        return String.format("%."+amountOfNumbersAfterDot+"f", number);
    }

    public double formatNumberDecimal(double number, RoundingMode roundingMode, String pattern){
        Log.d("formatNumberDecimal", "number == " + number);
        DecimalFormat df = new DecimalFormat(pattern);
        df.setRoundingMode(roundingMode);
        return Double.parseDouble(df.format(number));
    }

    public int convertDoubleToInt(double number){
        DecimalFormat df = new DecimalFormat("#");
        df.setRoundingMode(RoundingMode.CEILING);
        return Integer.parseInt(df.format(number));
    }

    public boolean getIsNegativeResult(String result){
        Log.d("checkIsNaN", "result == " + result);
        try {
            Log.d("checkIsNaN", "getIsNumber(result) == " + getIsNumber(result));
            if (getIsNumber(result) && Double.parseDouble(result) < 0) {
                Log.d("checkIsNaN", "!(Double.isNaN(Double.parseDouble(result))) && Double.parseDouble(result) < 0");
                return true;
            } else {
                if (negativeResults.contains(result)){
                    Log.d("checkIsNaN", "negativeResults.contains(result) == true");
                    return true;
                }
                Log.d("checkIsNaN", "negativeResults.contains(result) == false");
                return false;
            }
        } catch (NumberFormatException e) {
            Log.d("checkIsNaN", "ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public boolean getIsNumber(String value){
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public void initNegativeResults(){
        negativeResults = new ArrayList<>();
        negativeResults.add(getString(R.string.armament_dose_is_too_big));
        negativeResults.add(getString(R.string.amount_is_not_enough));
        negativeResults.add(getString(R.string.not_valid_cut));
        negativeResults.add(getString(R.string.pressure_required));
        negativeResults.add(getString(R.string.cut_of_conrette_is_not_enough));
        negativeResults.add(getString(R.string.spacing_between_rods_not_proper));
        negativeResults.add(getString(R.string.amount_of_branches_not_proper));
        negativeResults.add(getString(R.string.armament_cut_dose_is_not_valid));
        negativeResults.add(getString(R.string.not_valid_femail));
    }

    public boolean isKindOfNull(String value){
        boolean isKindOfNull = value == null || value.trim().equals("") || value.equals("null");
        Log.d("checkKindOfNull", "isKindOfNull == " + isKindOfNull);
        return isKindOfNull;
    }


    public void startRelevantActivityCloseDrawerStartActivity(Class relevantClass, int moduleForActivate) {
        if (moduleForActivate == moduleActiveId && drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawers();
        } else {
            moduleActiveId = moduleForActivate;
            context.startActivity(new Intent(context, relevantClass).addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK).putExtra(IS_FROM_DRAWER_REQUESTED, true));
        }
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        toggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}

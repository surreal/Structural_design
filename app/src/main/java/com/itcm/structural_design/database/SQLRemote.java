package com.itcm.structural_design.database;

import android.database.Cursor;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import com.itcm.structural_design.activities.AuthenticationActivity;
import com.itcm.structural_design.activities.ModulesActivity;
import com.itcm.structural_design.helpers.Internet;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;
import com.itcm.structural_design.interfaces.OnAsyncPostUserDetailsListener;
import com.itcm.structural_design.models.UserModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.itcm.structural_design.activities.BasicActivity.BENDING_TOLERANCE_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.CANOPY_LENGTHS_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.CONCRETE_MODULE;
import static com.itcm.structural_design.activities.BasicActivity.CORRECT_PASSWORD;
import static com.itcm.structural_design.activities.BasicActivity.DESIGN_MODULE;
import static com.itcm.structural_design.activities.BasicActivity.FOUND;
import static com.itcm.structural_design.activities.BasicActivity.NOT_FOUND;
import static com.itcm.structural_design.activities.BasicActivity.EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.INSERT_USER_SUCCESSFUL;
import static com.itcm.structural_design.activities.BasicActivity.INTERNET_EXCEPTION;
import static com.itcm.structural_design.activities.BasicActivity.PAGING_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.PASSWORD;
import static com.itcm.structural_design.activities.BasicActivity.PENETRATION_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHANGE_PASSWORD;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_LOGIN_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_INSERT_USER;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_INSERT_VALUES_OUTSIDE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_SEND_PASSWORD_EMAIL;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_SYNCHRONIZE_ALL_DATA_INSIDE;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_SYNC_USERS_TABLE_SINGLE_VAL;
import static com.itcm.structural_design.activities.BasicActivity.QUERY_TYPE_UPDATE_VALUES_OUTSIDE;
import static com.itcm.structural_design.activities.BasicActivity.STEEL_MODULE;
import static com.itcm.structural_design.activities.BasicActivity.SUCCESSFUL;
import static com.itcm.structural_design.activities.BasicActivity.SYNC_INSIDE_SUCCESS;
import static com.itcm.structural_design.activities.BasicActivity.UPDATED;
import static com.itcm.structural_design.activities.BasicActivity.WRONG_PASSWORD;
import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.currentUserEmailGlobal;
import static com.itcm.structural_design.activities.BasicActivity.sqLiteDatabase;
import static com.itcm.structural_design.activities.BasicActivity.sqlHelper;
import static com.itcm.structural_design.activities.BasicActivity.sqlLocal;
import static com.itcm.structural_design.database.DBModel.COLUMN_AUTH_OPTION;
import static com.itcm.structural_design.database.DBModel.COLUMN_EMAIL;
import static com.itcm.structural_design.database.DBModel.COLUMN_PROFILE_IMAGE_LOCAL_PATH;
import static com.itcm.structural_design.database.DBModel.USERS_TABLE;

public class SQLRemote extends AsyncTask<String, Void, String> {

    private final String requestType;
    private Statement statement;
    private String result, sql, email, name, password, profileImagePath;
    private int authOption = 0;
    private ResultSet resultSet;

    private double id_1_value = 1, id_2_value = 20, id_3_value = 1, id_4_value = 1, id_5_value = 1, id_6_value = 1,
            id_7_value = 0, id_8_value = 20, id_9_value = 8.7, id_10_value = 400, id_14_value, id_15_value = 1, id_16_value = 1, id_17_value = 1, id_20_value,
            id_22_value = 1, id_23_value = 1, id_24_value = 1, id_25_value = 2, id_26_value = 2, id_27_value = 8, id_28_value = 8, id_29_value, id_34_value, id_35_value,
            id_36_value = 0, id_38_value = 0, id_39_value = 1, id_40_value = 1, id_41_value = 1, id_42_value, id_43_value = 1, id_45_value = 1, id_47_value, id_50_value,
            id_52_value, id_53_value, id_54_value, id_56_value = 1, id_57_value = 8, id_58_value = 8, id_60_value, id_61_value, id_62_value = 1, id_63_value = 1,
            id_64_value, id_65_value, id_66_value = 1, id_69_value, id_70_value = 1, id_71_value = 1, id_72_value = 1, id_73_value, id_74_value, id_75_value, id_76_value, id_77_value, id_78_value,
            id_87_value = 1, id_88_value = 8, id_91_value = 1, id_92_value = 8, id_100_value = 1, id_101_value = 1, id_103_value = 1, id_104_value = 1,
            id_105_value = 1, id_106_value = 1, id_107_value = 1, id_108_value = 1, id_122_value = 1, id_123_value = 1, id_125_value = 1,
            id_1001_value = 1, id_1002_value = 1, id_4001_value = 1, id_4002_value = 1, id_4003_value = 1, id_4004_value = 1, id_4005_value = 1,
            id_4006_value = 1, id_4007_value = 1, id_4008_value = 1, id_4009_value = 1, id_4010_value = 1, id_2026_value = 1, id_2027_value = 1,
            id_2034_value = 1, id_2035_value = 1, id_2042_value = 1, id_2043_value = 1, id_2048_value = 1, id_2049_value = 1, id_21_value, id_400_value, id_44_value,
            id_48_value, id_49_value, id_55_value, id_67_value, id_68_value, id_82_value, id_80_value, id_81_value, id_89_value, id_90_value, id_96_value,
            id_97_value, id_115_value, id_116_value, id_270_value;
    private int id_1_position = 0, id_4_position = 0, id_17_position, id_30_position, id_37_position, id_102_position = 0, id_10_position = 0,
            id_15_position = 0, id_69_position = 0, id_1000_position = 0, id_42_position, id_47_position, id_51_position, id_58_position, id_59_position, id_70_position, id_77_position,
            id_85_position, id_86_position, id_94_position;
    private Cursor cursor;
    private String title;
    private int subcategory;
    private int category;
    private int module;

    public SQLRemote(String requestType, boolean isSynchronizingInside) {
        this.requestType = requestType;
        sqLiteDatabase = new SQLLocal().getSQLDatabase();
    }

    private Statement getStatement() {
        try {
            final String url = "jdbc:mysql://35.192.41.8:3306/Structural_design_db";
            final String user = "test_user";
            final String pass = "Test2022";
            Class.forName("com.mysql.jdbc.Driver");
            if (!DriverManager.getConnection(url, user, pass).isClosed()) {
                Connection connection = DriverManager.getConnection(url, user, pass);
                Log.d("checkingDB", "Database -> Connection Success");
                statement = connection.createStatement();
            }
        } catch (com.mysql.jdbc.exceptions.jdbc4.CommunicationsException e) {
            e.printStackTrace();
            Log.d("checkingDB", "getStatement() -> CommunicationsException EXCEPTION == " + e);
            result = EXCEPTION;
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "getStatement() -> Exception EXCEPTION == " + e);
            e.printStackTrace();
        }
        return statement;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.d("checkingDB", "onPreExecute() requestType == " + requestType);
    }

    @Override
    protected String doInBackground(String... values) {
        if (!Internet.isInternetConnected()) {
            Log.d("checkingDB", "doInBackground() NO INTERNET requestType == " + requestType);
            return INTERNET_EXCEPTION;
        } else {
            try {
                statement = getStatement();
                Log.d("checkingDB", "doInBackground() statement == " + (statement == null ? " NULL " : " NOT NULL"));
                if (statement != null) {
                    return backgroundAction(values);
                } else {
                    return EXCEPTION;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return EXCEPTION;
            }
        }
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        Log.d("checkingDB", "onPostExecute() requestType == " + requestType + "; result[0] == " + result);
        switch (result) {
            case EXCEPTION:
                Toast.makeText(context, "שגיע!", Toast.LENGTH_LONG).show();
                switch (activityActiveId) {
                    case ModulesActivity.MODULES_ACTIVITY:
                    case AuthenticationActivity.AUTHENTICATION_ACTIVITY:
                        break;
                    default:
                        ((OnAsyncPostListener) context).onAsyncPostResult(EXCEPTION);
                        break;
                }
                break;
            case INTERNET_EXCEPTION:
                Toast.makeText(context, "שגיעת אינטרנט!", Toast.LENGTH_LONG).show();
                if (!activityActiveId.equals(ModulesActivity.MODULES_ACTIVITY))
                    ((OnAsyncPostListener) context).onAsyncPostResult(INTERNET_EXCEPTION);
                break;
            default:
                switch (requestType) {
                    case QUERY_TYPE_SEND_PASSWORD_EMAIL:
                    case QUERY_TYPE_CHECK_LOGIN_AVAILABLE:
                    case QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE:
                    case QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE:
                    case QUERY_TYPE_INSERT_USER:
                        ((OnAsyncPostUserDetailsListener) context).onAsyncPostUserDetailsResult(new UserModel(email, password, name, profileImagePath, authOption), requestType, result);
                        break;
                    default:
                        if (!activityActiveId.equals(ModulesActivity.MODULES_ACTIVITY))
                            ((OnAsyncPostListener) context).onAsyncPostResult(result);
                        break;
                }
//                Toast.makeText(context, "סנכרון הסתיים.", Toast.LENGTH_LONG).show();
        }
    }

    private String syncUsersTableSingleVal(String... values) {
        try {
            Log.d("checkingDB", "updatePagingSecond() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateSetWhereSQL(USERS_TABLE, values[0], values[1], COLUMN_EMAIL, currentUserEmailGlobal));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updatePagingSecond() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updatePagingSecond() -> EXCEPTION == " + e.toString());
            e.printStackTrace();
        }
        return result;
    }

    private String backgroundAction(String[] values) {
        switch (requestType) {
            case QUERY_TYPE_SEND_PASSWORD_EMAIL:
            case QUERY_TYPE_CHECK_LOGIN_AVAILABLE:
            case QUERY_TYPE_CHECK_GOOGLE_AUTH_AVAILABLE:
            case QUERY_TYPE_CHECK_SIGN_UP_AVAILABLE:
                result = checkEmailOutside(values[0]);
                if (result.equals(FOUND)) getUserDataOutside(values[0]);
                return result;
            case QUERY_TYPE_INSERT_USER:
            case QUERY_TYPE_CHANGE_PASSWORD:
                switch (requestType) {
                    case QUERY_TYPE_INSERT_USER:
                        getUserDataOutside(values[0]);
                        if (result.equals(NOT_FOUND)) {
                            email = values[0];
                            password = values[1];
                            name = values[2];
                            authOption = Integer.parseInt(values[3]);
                            insertUserOutsideDB();
                        } else result = FOUND;
                        return result;
                    case QUERY_TYPE_CHANGE_PASSWORD:
                        getUserDataOutside(values[1]);
                        result = password.equals(values[2]) ? CORRECT_PASSWORD : WRONG_PASSWORD;
                        if (result.equals(CORRECT_PASSWORD)) {
                            updateUserOutsideDB(DBModel.COLUMN_PASSWORD, values[3]);
                        }
                        break;
                }
//                return new String[]{result, email, password, name};
                return result;
            case QUERY_TYPE_INSERT_VALUES_OUTSIDE:
            case QUERY_TYPE_UPDATE_VALUES_OUTSIDE:
                module = Integer.parseInt(values[0]);
                category = Integer.parseInt(values[1]);
                subcategory = Integer.parseInt(values[2]);
                title = values[3];
                switch (requestType) {
                    case QUERY_TYPE_INSERT_VALUES_OUTSIDE:
                        insertUpdateValuesOutside(values, true);
                        break;
                    case QUERY_TYPE_UPDATE_VALUES_OUTSIDE:
                        insertUpdateValuesOutside(values, false);
                        break;
                }
                return result;
            case QUERY_TYPE_SYNCHRONIZE_ALL_DATA_INSIDE:
                synchronizeAllDataInside();
                return result;
            case QUERY_TYPE_SYNC_USERS_TABLE_SINGLE_VAL:
                return syncUsersTableSingleVal(values);
            default:
                return "null";
        }
    }


    private String checkEmailOutside(String email) {
        try {
            Log.d("checkingDB", "checkEmailOutside() -> email: " + email);
            sql = String.format("SELECT password FROM %s WHERE %s='%s'", USERS_TABLE, COLUMN_EMAIL, email);
            ResultSet resultSet = statement.executeQuery(sql);
            email = resultSet.first() ? email : null;
            password = resultSet.first() ? resultSet.getString(resultSet.findColumn(PASSWORD)) : null;
            Log.d("checkingDB", "checkEmailOutside() -> resultSet.first() == " + resultSet.first() + "; result == " + result + "; creatorEmail == " + email);
            return resultSet.first() ? FOUND : NOT_FOUND;
        } catch (Exception e) {
            Log.d("checkingDB", "checkEmailOutside() -> EXCEPTION == " + e);
            e.printStackTrace();
            return EXCEPTION;
        }
    }

    private void synchronizeAllDataInside() {
        try {
            int i = 0;
            resultSet = statement.executeQuery(sqlLocal.selectAllSQL());
            while (resultSet.next()) {
                i++;
                title = resultSet.getString(resultSet.findColumn(DBModel.COLUMN_TITLE));
                module = resultSet.getInt(resultSet.findColumn(DBModel.COLUMN_MODULE_ID));
                category = resultSet.getInt(resultSet.findColumn(DBModel.COLUMN_CATEGORY_ID));
                subcategory = resultSet.getInt(resultSet.findColumn(DBModel.COLUMN_SUB_CATEGORY_POSITION));
                Log.d("checkingDB", "synchronizeAllDataInside() currentUserEmailGlobal == " + currentUserEmailGlobal + "; title == " + title + "; module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; i == " + i);
                setAllValues();
                sqLiteDatabase.execSQL(sqlHelper.insertAllValuesSQL(
                        title, module, category, subcategory,
                        id_1_value, id_2_value, id_3_value, id_4_value, id_5_value, id_6_value, id_7_value, id_8_value, id_9_value, id_10_value, id_14_value,
                        id_15_value, id_16_value, id_17_value, id_20_value, id_21_value, id_22_value, id_23_value, id_24_value, id_25_value, id_26_value,
                        id_27_value, id_28_value, id_29_value, id_34_value, id_35_value, id_38_value, id_39_value, id_40_value, id_41_value, id_42_value,
                        id_43_value, id_44_value, id_45_value, id_47_value, id_50_value, id_52_value, id_53_value, id_54_value, id_55_value, id_56_value, id_57_value, id_36_value,
                        id_60_value, id_61_value, id_62_value, id_63_value, id_64_value, id_65_value, id_66_value, id_69_value, id_70_value, id_71_value,
                        id_72_value, id_75_value, id_76_value, id_73_value, id_78_value, id_74_value, id_88_value, id_91_value, id_92_value, id_100_value,
                        id_101_value, id_103_value, id_104_value, id_105_value, id_106_value, id_58_value, id_108_value, id_122_value, id_123_value, id_77_value,
                        id_1001_value, id_87_value, id_2026_value, id_2027_value, id_107_value,
                        id_2035_value, id_2042_value, id_2043_value, id_2048_value, id_2049_value, id_4001_value, id_4002_value, id_4003_value, id_4004_value,
                        id_4005_value, id_2034_value, id_1002_value, id_4008_value, id_4009_value, id_4010_value, id_1_position, id_4_position, id_10_position,
                        id_17_position, id_37_position, id_47_position, id_59_position, id_102_position, id_1000_position, id_4007_value, id_4006_value,
                        id_125_value, id_30_position, id_69_position
                ));
            }
            result = SYNC_INSIDE_SUCCESS;
        } catch (SQLException e) {
            result = EXCEPTION;
            e.printStackTrace();
        }
    }


    private void setAllValues() {
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_5_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_5);
        id_6_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_6);
        id_7_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_7);
        id_8_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_8);
        id_9_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_9);
        id_10_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_10);
        id_14_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_14);
        id_15_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_15);
        id_16_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_16);
        id_17_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_17);
        id_20_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_20);
        id_21_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_21);
        id_22_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_22);
        id_23_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_23);
        id_24_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_24);
        id_25_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_25);
        id_26_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_26);
        id_27_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_27);
        id_28_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_28);
        id_29_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_29);
        id_34_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_34);
        id_35_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_35);
        id_36_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_36);
        id_38_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_38);
        id_39_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_39);
        id_40_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_40);
        id_41_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_41);
        id_42_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_42);
        id_43_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_43);
        id_44_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_44);
        id_45_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_45);
        id_47_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_47);
        id_50_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_50);
        id_52_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_52);
        id_53_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_53);
        id_54_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_54);
        id_55_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_55);
        id_56_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_56);
        id_57_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_57);
        id_58_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_58);
        id_60_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_60);
        id_61_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_61);
        id_62_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_62);
        id_63_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_63);
        id_64_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_64);
        id_65_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_65);
        id_66_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_66);
        id_69_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_69);
        id_70_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_70);
        id_71_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_71);
        id_72_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_72);
        id_73_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_73);
        id_74_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_74);
        id_75_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_75);
        id_76_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_76);
        id_77_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_77);
        id_78_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_78);
        id_87_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_87);
        id_88_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_88);
        id_91_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_91);
        id_92_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_92);
        id_100_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_100);
        id_101_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_101);
        id_103_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_103);
        id_104_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_104);
        id_105_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_105);
        id_106_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_106);
        id_107_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_107);
        id_108_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_108);
        id_122_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_122);
        id_123_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_123);
        id_125_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_125);
        id_1001_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1001);
        id_1002_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1002);
        id_2026_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2026);
        id_2027_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2027);
        id_2034_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2034);
        id_2035_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2035);
        id_2042_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2042);
        id_2043_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2043);
        id_2048_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2048);
        id_2049_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2049);
        id_4001_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4001);
        id_4002_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4002);
        id_4003_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4003);
        id_4004_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4004);
        id_4005_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4005);
        id_4006_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4006);
        id_4007_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4007);
        id_4008_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4008);
        id_4009_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4009);
        id_4010_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4010);
        id_1000_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_1000_POSITION);
        id_1_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_1_POSITION);
        id_4_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_4_POSITION);
        id_10_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_10_POSITION);
        id_17_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_17_POSITION);
        id_30_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_30_POSITION);
        id_37_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_37_POSITION);
        id_47_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_47_POSITION);
        id_59_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_59_POSITION);
        id_69_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_69_POSITION);
        id_102_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_102_POSITION);
    }

    private void insertUpdateValuesOutside(String[] values, boolean isForInsert) {
        cursor = sqlLocal.selectFiveComparesCursor("*", title);
        cursor.moveToFirst();
        switch (Integer.parseInt(values[0])) {
            case CONCRETE_MODULE:
                switch (Integer.parseInt(values[1])) {
                    case BENDING_TOLERANCE_CATEGORY:
                        switch (Integer.parseInt(values[2])) {
                            case 0:
                            case 1:
                                setBTValues();
                                if (isForInsert) {
                                    insertBT();
                                } else {
                                    updateBT();
                                }
                                break;
                            case 2:
                                setBTThirdValues();
                                if (isForInsert) {
                                    insertBTThird();
                                } else {
                                    updateBTThird();
                                }
                                break;
                        }
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        switch (Integer.parseInt(values[2])) {
                            case 0:
                            case 1:
                            case 2:
                                setCLValues();
                                if (isForInsert) {
                                    insertCL();
                                } else {
                                    updateCL();
                                }
                                break;
                            case 3:
                                setCLFourthValues();
                                if (isForInsert) {
                                    insertCLThird();
                                } else {
                                    updateCLFourth();
                                }
                                break;
                        }
                        break;
                    case PENETRATION_CATEGORY:
                        setPenetrationValues();
                        if (isForInsert) {
                            insertPenetration();
                        } else {
                            updatePenetration();
                        }
                        break;
                    case PAGING_CATEGORY:
                        switch (Integer.parseInt(values[2])) {
                            case 0:
                                setPagingValuesFirst();
                                if (isForInsert) {
                                    insertPagingFirst();
                                } else {
                                    updatePagingFirst();
                                }
                                break;
                            case 1:
                                setPagingValuesSecond();
                                if (isForInsert) {
                                    insertPagingSecond();
                                } else {
                                    updatePagingSecond();
                                }
                                break;
                        }
                        break;
                }
                break;
            case DESIGN_MODULE:

                break;
            case STEEL_MODULE:
                setSteelCeilingValues();
                if (isForInsert) {
                    insertSteelCeiling();
                } else {
                    updateSteelCeiling();
                }
                break;
        }
    }

    private void updateSteelCeiling() {
        try {
            Log.d("checkingDB", "updatePagingSecond() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateSteelCeiling_SQL(title, module, category, subcategory, id_1_value, id_14_value, id_15_value, id_17_value, id_21_value, id_22_value, id_23_value, id_27_value, id_43_value,
                    id_44_value, id_55_value, id_56_value, id_66_value, id_71_value, id_72_value, id_47_position, id_59_position));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updatePagingSecond() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updatePagingSecond() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void insertSteelCeiling() {
        try {
            Log.d("checkingDB", "insertSteelCeiling() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertSteelCeiling_SQL(title, module, category, subcategory, id_1_value, id_14_value, id_15_value, id_17_value, id_21_value, id_22_value, id_23_value, id_27_value, id_43_value,
                    id_44_value, id_55_value, id_56_value, id_66_value, id_71_value, id_72_value, id_47_position, id_59_position));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertSteelCeiling() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertSteelCeiling() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void setSteelCeilingValues() {
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_14_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_14);
        id_15_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_15);
        id_17_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_17);
        id_21_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_21);
        id_22_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_22);
        id_23_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_23);
        id_27_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_27);
        id_43_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_43);
        id_44_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_44);
        id_47_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_47_POSITION);
        id_55_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_55);
        id_56_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_56);
        id_59_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_59_POSITION);
        id_66_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_66);
        id_71_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_71);
        id_72_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_72);
    }

    private void setPagingValuesSecond() {
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_400_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_400);
        id_6_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_6);
        id_9_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_9);
        id_21_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_21);
        id_22_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_22);
        id_27_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_27);
        id_34_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_34);
        id_35_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_35);
        id_42_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_42_POSITION);
        id_43_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_43);
        id_44_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_44);
        id_45_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_45);
        id_48_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_48);
        id_49_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_49);
        id_50_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_50);
        id_51_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_51_POSITION);
        id_55_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_55);
        id_56_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_56);
        id_57_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_57);
        id_58_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_58_POSITION);
        id_61_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_61);
        id_62_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_62);
        id_63_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_63);
        id_67_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_67);
        id_68_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_68);
        id_69_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_69);
        id_70_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_70_POSITION);
        id_74_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_74);
        id_75_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_75);
        id_76_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_76);
        id_77_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_77_POSITION);
        id_80_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_80);
        id_81_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_81);
        id_82_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_82);
        id_85_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_85_POSITION);
        id_86_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_86_POSITION);
        id_88_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_88);
        id_89_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_89);
        id_90_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_90);
        id_94_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_94_POSITION);
        id_96_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_96);
        id_97_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_97);
        id_115_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_115);
        id_116_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_116);
        id_270_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_270);
    }

    private void setPagingValuesFirst() {
        id_1_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_1_POSITION);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_7_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_7);
        id_8_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_8);
        id_9_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_9);
        id_10_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_10_POSITION);
        id_14_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_14);
        id_15_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_15);
        id_16_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_16);
        id_17_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_17_POSITION);
        id_20_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_20);
        id_22_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_22);
        id_23_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_23);
        id_27_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_27);
        id_28_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_28);
        id_29_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_29);
        id_30_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_30_POSITION);
        id_34_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_34);
        id_35_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_35);
        id_36_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_36);
        id_37_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_37_POSITION);
        id_40_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_40);
        id_41_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_41);
        id_42_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_42);
        id_45_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_45);
        id_47_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_47);
        id_50_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_50);
        id_52_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_52);
        id_53_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_53);
        id_54_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_54);
        id_58_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_58);
        id_60_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_60);
        id_61_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_61);
        id_62_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_62);
        id_64_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_64);
        id_65_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_65);
        id_66_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_66);
        id_69_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_69);
        id_70_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_70);
        id_73_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_73);
        id_74_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_74);
        id_75_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_75);
        id_76_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_76);
        id_77_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_77);
        id_78_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_78);
    }

    private void setPenetrationValues() {
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_9_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_9);
        id_10_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_10);
        id_15_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_15);
        id_16_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_16);
        id_100_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_100);
        id_101_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_101);
        id_103_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_103);
        id_104_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_104);
        id_105_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_105);
        id_106_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_106);
        id_107_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_107);
        id_108_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_108);
        id_22_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_22);
        id_23_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_23);
        id_24_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_24);
        id_25_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_25);
        id_36_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_36);
        id_38_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_38);
        id_41_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_41);
        id_43_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_43);
        id_45_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_45);
        id_62_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_62);
        id_63_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_63);
        id_66_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_66);
        id_69_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_69_POSITION);
        id_4001_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4001);
        id_4002_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4002);
        id_4003_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4003);
        id_4004_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4004);
        id_4005_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4005);
        id_4006_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4006);
        id_4007_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4007);
        id_4008_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4008);
        id_4009_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4009);
        id_4010_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4010);
    }

    private void insertPagingFirst() {
        try {
            Log.d("checkingDB", "insertCLThird() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertPagingCategoryOne_SQL(title, module, category, subcategory,
                    id_1_position, id_2_value, id_3_value, id_4_value, id_7_value, id_8_value, id_9_value, id_10_position, id_14_value, id_15_value, id_16_value,
                    id_17_position, id_20_value, id_22_value, id_23_value, id_27_value, id_28_value, id_29_value, id_30_position, id_34_value, id_35_value,
                    id_36_value, id_37_position, id_40_value, id_41_value, id_42_value, id_45_value, id_47_value, id_50_value, id_52_value, id_53_value,
                    id_54_value, id_58_value, id_60_value, id_61_value, id_62_value, id_64_value, id_65_value, id_66_value, id_69_value, id_70_value, id_73_value,
                    id_74_value, id_75_value, id_76_value, id_77_value, id_78_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertCLThird() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertCLThird() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }


    private void insertPagingSecond() {
        try {
            Log.d("checkingDB", "insertPagingSecond() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertPagingCategoryTwo_SQL(title, module, category, subcategory, id_1_value, id_2_value,
                    id_3_value, id_4_value, id_400_value, id_6_value, id_9_value, id_21_value, id_22_value, id_27_value, id_34_value, id_35_value, id_42_position,
                    id_43_value, id_44_value, id_45_value, id_48_value, id_49_value, id_50_value, id_51_position, id_55_value, id_56_value, id_57_value,
                    id_58_position, id_61_value, id_62_value, id_63_value, id_67_value, id_68_value, id_69_value, id_70_position, id_74_value, id_75_value, id_76_value,
                    id_77_position, id_80_value, id_81_value, id_82_value, id_85_position, id_86_position, id_88_value, id_89_value, id_90_value, id_94_position, id_96_value,
                    id_97_value, id_115_value, id_116_value, id_270_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertPagingSecond() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertPagingSecond() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void insertPenetration() {
        try {
            Log.d("checkingDB", "insertCLThird() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertPenetration_SQL(title, module, category, subcategory,
                    id_1_value, id_2_value, id_3_value, id_108_value,
                    id_9_value, id_10_value, id_15_value, id_16_value,
                    id_100_value, id_101_value, id_103_value, id_104_value, id_105_value, id_106_value, id_107_value,
                    id_22_value, id_23_value,
                    id_24_value, id_25_value, id_36_value, id_38_value,
                    id_41_value, id_43_value, id_45_value, id_62_value,
                    id_63_value, id_66_value, id_69_position, id_4001_value,
                    id_4002_value, id_4003_value, id_4004_value, id_4005_value,
                    id_4006_value, id_4007_value, id_4008_value, id_4009_value,
                    id_4010_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertCLThird() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertCLThird() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updatePagingSecond() {
        try {
            Log.d("checkingDB", "updatePagingSecond() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updatePagingCategoryTwo_SQL(title, module, category, subcategory, id_1_value, id_2_value,
                    id_3_value, id_4_value, id_400_value, id_6_value, id_9_value, id_21_value, id_22_value, id_27_value, id_34_value, id_35_value, id_42_position,
                    id_43_value, id_44_value, id_45_value, id_48_value, id_49_value, id_50_value, id_51_position, id_55_value, id_56_value, id_57_value,
                    id_58_position, id_61_value, id_62_value, id_63_value, id_67_value, id_68_value, id_69_value, id_70_position, id_74_value, id_75_value, id_76_value,
                    id_77_position, id_80_value, id_81_value, id_82_value, id_85_position, id_86_position, id_88_value, id_89_value, id_90_value, id_94_position, id_96_value,
                    id_97_value, id_115_value, id_116_value, id_270_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updatePagingSecond() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updatePagingSecond() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updatePagingFirst() {
        try {
            Log.d("checkingDB", "updatePenetration() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updatePaging_SQL(title, module, category, subcategory,
                    id_1_position, id_2_value, id_3_value, id_4_value, id_7_value, id_8_value, id_9_value, id_10_position, id_14_value, id_15_value, id_16_value,
                    id_17_position, id_20_value, id_22_value, id_23_value, id_27_value, id_28_value, id_29_value, id_30_position, id_34_value, id_35_value,
                    id_36_value, id_37_position, id_40_value, id_41_value, id_42_value, id_45_value, id_47_value, id_50_value, id_52_value, id_53_value,
                    id_54_value, id_58_value, id_60_value, id_61_value, id_62_value, id_64_value, id_65_value, id_66_value, id_69_value, id_70_value, id_73_value,
                    id_74_value, id_75_value, id_76_value, id_77_value, id_78_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updatePenetration() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updatePenetration() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updatePenetration() {
        try {
            Log.d("checkingDB", "updatePenetration() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateCL_SQL(
                    id_1_value, id_2_value, id_3_value, id_108_value, id_9_value, id_10_value, id_15_value, id_16_value,
                    id_100_value, id_101_value, id_103_value, id_104_value, id_105_value, id_106_value, id_107_value,
                    id_22_value, id_23_value,
                    id_24_value, id_25_value, id_36_value, id_38_value, id_41_value, id_43_value, id_45_value, id_62_value, id_63_value,
                    id_66_value, id_69_position, id_4001_value, id_4002_value, id_4003_value, id_4004_value, id_4005_value, id_4006_value,
                    id_4007_value, id_4008_value, id_4009_value, id_4010_value,
                    title,
                    module,
                    category,
                    subcategory));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updatePenetration() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updatePenetration() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updateCLFourth() {
        try {
            Log.d("checkingDB", "updateCLFourth() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateCLFourth_SQL(title, module, category, subcategory, id_122_value, id_123_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updateCLFourth() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updateCLFourth() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void insertCLThird() {
        try {
            Log.d("checkingDB", "insertCLThird() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertCLFourth_SQL(title, module, category, subcategory, id_122_value, id_123_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertCLThird() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertCLThird() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void setCLFourthValues() {
        id_122_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_122);
        id_123_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_123);
    }

    private void updateCL() {
        try {
            Log.d("checkingDB", "updateCL() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateCL_SQL(
                    id_101_value, id_1_position, id_2_value, id_3_value, id_4_position, id_102_position, id_5_value,
                    id_125_value, id_6_value, id_7_value, id_8_value, id_104_value, id_15_value,
                    title, module, category, subcategory));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updateCL() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updateCL() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void insertCL() {
        try {
            Log.d("checkingDB", "insertCL() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertCL_SQL(
                    title, module, category, subcategory,
                    id_101_value, id_1_position, id_2_value, id_3_value, id_4_position,
                    id_102_position, id_5_value, id_125_value, id_6_value,
                    id_7_value, id_8_value, id_104_value, id_15_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertCL() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertCL() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void setCLValues() {
        id_101_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_101);
        id_1_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_1_POSITION);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_4_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_4_POSITION);
        id_102_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_102_POSITION);
        id_5_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_5);
        id_125_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_125);
        id_6_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_6);
        id_7_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_7);
        id_8_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_8);
        id_104_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_104);
        id_15_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_15);
    }

    private void updateBTThird() {
        try {
            Log.d("checkingDB", "updateBTThird() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateBTThird_SQL(
                    id_1000_position, id_1_value, id_2_value, id_3_value, id_4_value, id_5_value, id_6_value, id_10_value, id_2026_value,
                    id_2027_value, id_2034_value, id_2035_value, id_2042_value, id_2043_value, id_2048_value, id_2049_value, id_39_value,
                    id_40_value, title, module, category, subcategory));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updateBTThird() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updateBTThird() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updateBT() {
        try {
            Log.d("checkingDB", "updateBT() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.updateBT_SQL(
                    id_1_value, id_2_value, id_3_value, id_1001_value, id_1002_value, id_4_value, id_5_value, id_6_value, id_10_value, id_25_value,
                    id_26_value, id_27_value, id_28_value, id_39_value, id_40_value, id_56_value, id_57_value, id_58_value, id_63_value, id_70_value,
                    id_87_value, id_88_value, id_91_value, id_92_value, title, module, category, subcategory));
            result = SUCCESSFUL;
            Log.d("checkingDB", "updateBT() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "updateBT() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void insertBTThird() {
        try {
            Log.d("checkingDB", "insertBTThird() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertBTThird_SQL(title, module, category, subcategory,
                    id_1000_position, id_1_value, id_2_value, id_3_value, id_4_value,
                    id_5_value, id_6_value, id_10_value,
                    id_2026_value, id_2027_value, id_2034_value, id_2035_value,
                    id_2042_value, id_2043_value, id_2048_value, id_2049_value,
                    id_39_value, id_40_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertBTThird() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertBT() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void setBTThirdValues() {
        id_1000_position = sqlLocal.getRelevantIntValue(cursor, resultSet, DBModel.COLUMN_ID_1000_POSITION);
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_5_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_5);
        id_6_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_6);
        id_10_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_10);
        id_2026_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2026);
        id_2027_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2027);
        id_2034_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2034);
        id_2035_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2035);
        id_2042_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2042);
        id_2043_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2043);
        id_2048_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2048);
        id_2049_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2049);
        id_39_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_39);
        id_40_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_40);
    }

    private void insertBT() {
        try {
            Log.d("checkingDB", "insertBT() -> module == " + module + "; category == " + category + "; subcategory == " + subcategory + "; title == " + title);
            statement.execute(sqlHelper.insertBT_SQL(
                    title, module, category, subcategory,
                    id_1_value, id_2_value, id_3_value, id_1001_value,
                    id_1002_value, id_4_value, id_5_value, id_6_value,
                    id_10_value, id_25_value, id_26_value, id_27_value,
                    id_28_value, id_39_value, id_40_value, id_56_value,
                    id_57_value, id_58_value, id_63_value, id_70_value,
                    id_87_value, id_88_value, id_91_value, id_92_value));
            result = SUCCESSFUL;
            Log.d("checkingDB", "insertBT() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertBT() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void setBTValues() {
        id_1_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1);
        id_2_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_2);
        id_3_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_3);
        id_1001_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1001);
        id_1002_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_1002);
        id_4_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_4);
        id_5_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_5);
        id_6_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_6);
        id_10_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_10);
        id_25_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_25);
        id_26_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_26);
        id_27_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_27);
        id_28_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_28);
        id_39_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_39);
        id_40_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_40);
        id_56_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_56);
        id_57_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_57);
        id_58_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_58);
        id_63_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_63);
        id_70_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_70);
        id_87_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_87);
        id_88_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_88);
        id_91_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_91);
        id_92_value = sqlLocal.getRelevantDoubleValue(cursor, resultSet, DBModel.COLUMN_VAL_ID_92);
    }

    private String getUserDataOutside(String userEmail) {
        try {
            Log.d("checkingDB", "findValueInUsersTableOutside()");
            sql = String.format("SELECT * FROM %s WHERE %s='%s'", USERS_TABLE, COLUMN_EMAIL, userEmail);
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.first()) {
                email = userEmail;
                name = resultSet.getString(resultSet.findColumn(DBModel.COLUMN_NAME));
                password = resultSet.getString(resultSet.findColumn(DBModel.COLUMN_PASSWORD));
                authOption = resultSet.getInt(resultSet.findColumn(COLUMN_AUTH_OPTION));
                profileImagePath = resultSet.getString(resultSet.findColumn(COLUMN_PROFILE_IMAGE_LOCAL_PATH));
                result = FOUND;
            } else result = NOT_FOUND;
            Log.d("checkingDB", "getUserDataOutside() -> resultSet.first() == " + resultSet.first() + "; result == " + result + "; creatorEmail == " + userEmail + "; profileImagePath == " + profileImagePath);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "getUserDataOutside() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
        return result;
    }

    private void insertUserOutsideDB() {
        try {
            sql = String.format("INSERT INTO %s (%s,%s,%s,%s) VALUES ('%s','%s','%s','%s')", USERS_TABLE,
                    "auth_option", COLUMN_EMAIL, PASSWORD, DBModel.COLUMN_NAME,
                    authOption, email, password, name);
            Log.d("checkingDB", "insertUserOutsideDB() -> email == " + email + "; password == " + password + "; name == " + name);
            statement.execute(sql);
            Log.d("checkingDB", "insertUserOutsideDB() -> result == " + INSERT_USER_SUCCESSFUL);
            result = INSERT_USER_SUCCESSFUL;
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertUserOutsideDB() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }

    private void updateUserOutsideDB(String columnIndex, String value) {
        try {
            sql = String.format("UPDATE %s SET %s='%s' WHERE %s='%s'", USERS_TABLE, columnIndex, value, COLUMN_EMAIL, email);
            Log.d("checkingDB", "insertUserOutsideDB() -> email == " + email + "; password == " + password + "; name == " + name);
            statement.execute(sql);
            result = UPDATED;
            Log.d("checkingDB", "insertUserOutsideDB() -> result == " + result);
        } catch (Exception e) {
            result = EXCEPTION;
            Log.d("checkingDB", "insertUserOutsideDB() -> EXCEPTION == " + e);
            e.printStackTrace();
        }
    }
}

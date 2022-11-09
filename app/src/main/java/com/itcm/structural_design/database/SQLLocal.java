package com.itcm.structural_design.database;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.itcm.structural_design.activities.BasicActivity.categoryActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.currentUserEmailGlobal;
import static com.itcm.structural_design.activities.BasicActivity.moduleActiveId;
import static com.itcm.structural_design.activities.BasicActivity.sqLiteDatabase;
import static com.itcm.structural_design.activities.SubCategoriesManagerActivity.subCategoryActiveId;

public class SQLLocal {

    private String sql;
    private Cursor cursor;

    public SQLLocal() {
        DBModel DBModel = new DBModel(context);
        sqLiteDatabase = DBModel.getWritableDatabase();
    }

    public SQLiteDatabase getSQLDatabase() {
        return sqLiteDatabase;
    }

    public void clearAllDBData() {
        sqLiteDatabase.execSQL("DELETE FROM " + DBModel.USERS_TABLE);
        sqLiteDatabase.execSQL("DELETE FROM " + DBModel.USERS_TABLE);
        sqLiteDatabase.execSQL("DELETE FROM " + DBModel.VALUES_TABLE);
        Log.d("checkingDB", "clearAllDataInsideDB() ALL DATA CLEARED");
    }

    public void updateSetWhereId(String table, String columnIndex, String value, int id) {
        Log.d("checkUpdateSetWhereId", "table == " + table + "; columnIndex == " + columnIndex + "; value == " + value + "; id == " + id);
        sql = String.format("UPDATE %s SET %s='%s' WHERE %s=%s", table, columnIndex, value, DBModel.COLUMN_ID, id);
        sqLiteDatabase.execSQL(sql);
    }

    public void updateSet(String table, String columnIndex, String value) {
        Log.d("checkUpdateSetWhereId", "table == " + table + "; columnIndex == " + columnIndex + "; value == " + value);
        sql = String.format("UPDATE %s SET %s='%s'", table, columnIndex, value);
        sqLiteDatabase.execSQL(sql);
    }

    public void updateSetWhere(String table, String columnIndexToSet, String valueToSet, String whereColumnIndex, String whereValue) {
        Log.d("checkUpdateSetWhereId", "table == " + table + "; columnIndexToSet == " + columnIndexToSet + "; valueToSet == " + valueToSet + "; whereValue == " + whereValue);
        sql = String.format("UPDATE %s SET %s='%s' WHERE %s='%s'", table, columnIndexToSet, valueToSet, whereColumnIndex, whereValue);
        sqLiteDatabase.execSQL(sql);
    }

    public void deleteFromWhere(String table, String columnIndex, String value) {
        sql = String.format("DELETE FROM %s WHERE %s='%s'", table, columnIndex, value);
        sqLiteDatabase.execSQL(sql);
    }

    public Cursor selectFromWhereCursor(String table, String selectedColumnIndex, String compareColumnIndex, String compareValue) {
        sql = String.format("SELECT %s FROM %s WHERE %s='%s'", selectedColumnIndex, table, compareColumnIndex, compareValue);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectAllFromWhereCursor(String table, String firstCompareColumnIndex, String firstCompareValue) {
        sql = String.format("SELECT * FROM %s WHERE %s=%s", table, firstCompareColumnIndex, firstCompareValue);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public String selectAllSQL() {
        return String.format("SELECT * FROM %s WHERE %s='%s'", DBModel.VALUES_TABLE, DBModel.COLUMN_EMAIL, currentUserEmailGlobal);
    }

    public Cursor selectFiveComparesCursor(String selectIndex, String titleCompareValue) {
        Log.d("checkSelectFourCompares", "selectFourComparesCursor() -> moduleActiveId == " + moduleActiveId + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; titleCompareValue == " + titleCompareValue);
        sql = String.format("SELECT %s FROM %s WHERE %s='%s' AND %s='%s' AND %s='%s' AND %s='%s' AND %s='%s'", selectIndex, DBModel.VALUES_TABLE,
                DBModel.COLUMN_MODULE_ID, moduleActiveId,
                DBModel.COLUMN_CATEGORY_ID, categoryActiveId,
                DBModel.COLUMN_SUB_CATEGORY_POSITION, subCategoryActiveId,
                DBModel.COLUMN_TITLE, titleCompareValue,
                DBModel.COLUMN_EMAIL, currentUserEmailGlobal);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectFourComparesCursor(String selectIndex, String titleCompareValue) {
        Log.d("checkSelectFourCompares", "selectThreeComparesCursor() -> moduleActiveId == " + moduleActiveId + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; titleCompareValue == " + titleCompareValue);
        sql = String.format("SELECT %s FROM %s WHERE %s='%s' AND %s='%s' AND %s='%s' AND %s='%s'", selectIndex, DBModel.VALUES_TABLE,
                DBModel.COLUMN_MODULE_ID, moduleActiveId,
                DBModel.COLUMN_CATEGORY_ID, categoryActiveId,
                DBModel.COLUMN_TITLE, titleCompareValue,
                DBModel.COLUMN_EMAIL, currentUserEmailGlobal
        );
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectFiveComparesCursor(String selectIndex, String titleCompareValue, int moduleActiveId, int categoryActiveId, int subCategoryActiveId) {
        Log.d("checkSelectFourCompares", "selectFourComparesCursor() -> moduleActiveId == " + moduleActiveId + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; titleCompareValue == " + titleCompareValue);
        sql = String.format("SELECT %s FROM %s WHERE %s='%s' AND %s='%s' AND %s='%s' AND %s='%s'", selectIndex, DBModel.VALUES_TABLE,
                DBModel.COLUMN_MODULE_ID, moduleActiveId,
                DBModel.COLUMN_CATEGORY_ID, categoryActiveId,
                DBModel.COLUMN_SUB_CATEGORY_POSITION, subCategoryActiveId,
                DBModel.COLUMN_TITLE, titleCompareValue);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public Cursor selectFourComparesCursor(String selectIndex, String titleCompareValue, int moduleActiveId, int categoryActiveId) {
        Log.d("checkSelectFourCompares", "selectThreeComparesCursor() -> moduleActiveId == " + moduleActiveId + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; titleCompareValue == " + titleCompareValue);
        sql = String.format("SELECT %s FROM %s WHERE %s='%s' AND %s='%s' AND %s='%s'", selectIndex, DBModel.VALUES_TABLE,
                DBModel.COLUMN_MODULE_ID, moduleActiveId,
                DBModel.COLUMN_CATEGORY_ID, categoryActiveId,
                DBModel.COLUMN_TITLE, titleCompareValue);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

    public double getRelevantDoubleValue(Cursor cursor, ResultSet resultSet, String columnIndex) {
        try {
            return resultSet == null ? cursor.getDouble(cursor.getColumnIndexOrThrow(columnIndex)) : resultSet.getDouble(resultSet.findColumn(columnIndex));
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getRelevantIntValue(Cursor cursor, ResultSet resultSet, String columnIndex) {
        try {
            return resultSet == null ? cursor.getInt(cursor.getColumnIndexOrThrow(columnIndex)) : resultSet.getInt(resultSet.findColumn(columnIndex));
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getIntFromUsersTable(String columnIndex) {
        sql = String.format("SELECT %s FROM %s", columnIndex, DBModel.USERS_TABLE);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor.moveToLast() ? cursor.getInt(cursor.getColumnIndexOrThrow(columnIndex)) : null;
    }

    public String getStringFromUsersTable(String columnIndex) {
        sql = String.format("SELECT %s FROM %s", columnIndex, DBModel.USERS_TABLE);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor.moveToLast() ? cursor.getString(cursor.getColumnIndexOrThrow(columnIndex)) : null;
    }

    public Cursor selectAllFromCursor(String table) {
        sql = String.format("SELECT * FROM %s", table);
        cursor = sqLiteDatabase.rawQuery(sql, null);
        return cursor;
    }

}

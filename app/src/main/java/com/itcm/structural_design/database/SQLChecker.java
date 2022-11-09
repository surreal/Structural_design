package com.itcm.structural_design.database;

import android.database.Cursor;
import android.util.Log;

import static com.itcm.structural_design.activities.BasicActivity.sqLiteDatabase;

public class SQLChecker {

    private static final String TAG = "checkSQLChecker";

    public static void checkTable(){
        String title;
        int module, category, subcategory;
        String sql = String.format("SELECT * FROM %s", DBModel.VALUES_TABLE);
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        Log.d(TAG, "SQLChecker{} -> cursor.getCount() == " + cursor.getCount());
        while (cursor.moveToNext()){
            title = cursor.getString(cursor.getColumnIndexOrThrow(DBModel.COLUMN_TITLE));
            module = cursor.getInt(cursor.getColumnIndexOrThrow(DBModel.COLUMN_MODULE_ID));
            category = cursor.getInt(cursor.getColumnIndexOrThrow(DBModel.COLUMN_CATEGORY_ID));
            subcategory = cursor.getInt(cursor.getColumnIndexOrThrow(DBModel.COLUMN_SUB_CATEGORY_POSITION));
            Log.d(TAG, "SQLChecker{} -> title == " + title + "; module == " + module + "; category == " + category + "; subcategory == " + subcategory);
        }
    }
}

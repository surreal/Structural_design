package com.itcm.structural_design.modules.concrete.canopy_length;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class CanopyLengthsCategory_SubCategoryFour extends CanopyLengthsCategory {

    public CanopyLengthsCategory_SubCategoryFour(){
        resetValues();
        setValues();
        initSpinnerPositions();
        setAllAdapters();
    }

    public void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    private void initSpinnerPositions() { }

    public void resetValues() { id_122_value = 1; id_123_value = 1; }

    private void setValues() {
        if (savedVersionTitle != null) {
            cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
            cursor.moveToFirst();
            id_122_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_122);
            id_123_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_123);
        }
    }


    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels) {
            valuesModels = new ArrayList<>();
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels.add(new StructuralDesignModel(122, "קוטר ברזל המחלק", "Ø", "mm", id_122_value+"", 0));
            valuesModels.add(new StructuralDesignModel(123, "מקצב מוטות הזיון ראשי", "@", "cm", id_123_value+"", 0));
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            resultPositionsByIds = new ArrayMap<>();
            resultModels.add(new StructuralDesignModel(124, "אורך חפייה לביצוע", "lv", "cm", mathId_124(), 0));
            setResultItemsPositionsById();
            return resultModels;
        }
    }

    public View.OnClickListener onSaveClickListener = view -> insertOrUpdateVersion(savedVersionTitle == null);
    public void insertOrUpdateVersion(boolean isForInsert) {
        if (!isForInsert){
            updateDB();
            activity.finish();
            return;
        }
        dialogHelper.initInputDialog(view1 -> {
            Log.d("checkDialogBtnClicked", "categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId + "; DialogHelper.input == " + DialogHelper.input + "; cursor.getCount() == " + cursor.getCount() + "; cursor.moveToFirst() == " + cursor.moveToFirst());
            if (setDialogInputReturnMsgIfErr()) return;
            insertToDB();
            dialog.dismiss();
            activity.finish();
        });
    }

    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updateCLFourth_SQL(savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId, id_122_value, id_123_value));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private void insertToDB() {
        sqLiteDatabase.execSQL(sqlHelper.insertCLFourth_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId, id_122_value, id_123_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private String mathId_124(){
        id_124_value = Math.max(id_123_value, Math.max(id_122_value * 30 / 10, 20));
        return formatNumberDecimal(id_124_value) + "";
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (valueItemId) {
            case 122:
                id_122_value = valueItemNumber;
                setRelevantResultItem_value(124, mathId_124(), "");
                break;
            case 123:
                id_123_value = valueItemNumber;
                setRelevantResultItem_value(124, mathId_124(), "");
                break;
        }
    }

}

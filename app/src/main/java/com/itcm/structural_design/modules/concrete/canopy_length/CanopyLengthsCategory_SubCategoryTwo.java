package com.itcm.structural_design.modules.concrete.canopy_length;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class CanopyLengthsCategory_SubCategoryTwo extends CanopyLengthsCategory {

    public CanopyLengthsCategory_SubCategoryTwo(){
        resetValues();
        setValues();
        initSpinnerPositions();
        setAllAdapters();
    }

    public void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    public void initSpinnerPositions() {
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1,0);
        spinnerPositionsArray.put(2,0);
        spinnerPositionsArray.put(3,0);
        spinnerPositionsArray.put(4,0);
    }

    public void resetValues() {
        id_2_value = 30; id_3_value = 200; id_5_value = 1;  id_6_value = 1; id_7_value = 1; id_8_value = 1; id_101_value = 1;
        id_1_position = 0; id_2_position = 1; id_3_position = 0; id_4_position = 0; id_102_position = 0;
    }

    private void setValues() {
        if (savedVersionTitle != null) {
            cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
            cursor.moveToFirst();
            id_101_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_101);
            id_1_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_1_POSITION);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_4_POSITION);
            id_5_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_5);
            id_6_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_6);
            id_7_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_7);
            id_8_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_8);
            id_15_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_15);
        }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1, id_1_position);
        spinnerPositionsArray.put(2, getPositionByValue(getConcreteTypeDoubleValues(), id_2_value));
        spinnerPositionsArray.put(3, getPositionByValue(getId_3_doubleValues(), id_3_value));
        spinnerPositionsArray.put(4, id_4_position);
        spinnerPositionsArray.put(15, getPositionByValue(getId_15_doubleValues(), id_15_value));
        Log.d("checkSetValues", "id_10_value == " + id_10_value + "; getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value) == " + getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value));
        id_2_position = spinnerPositionsArray.get(2);
        id_3_position = spinnerPositionsArray.get(3);
        id_15_position = spinnerPositionsArray.get(15);
    }

    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels) {
            valuesModels = new ArrayList<>();
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels.add(new StructuralDesignModel(101, "מקצב מוטות הזיון המחלק", "@", "", id_101_value+"", 0));
            valuesModels.add(new StructuralDesignModel(1, "סוג פלדה", "", "cm", "", id_1_position));
            valuesModels.add(new StructuralDesignModel(2, "סוג בטון", "ב", "ב-", "", id_2_position));
            valuesModels.add(new StructuralDesignModel(3, "חוזק תכן של הפלדה", "fsd", "kg \\ cm^2", "", id_3_position));
            valuesModels.add(new StructuralDesignModel(4, "תנאי הדיבקות", "Asact", "טוב/נחות", "", id_4_position));
            valuesModels.add(new StructuralDesignModel(5, " כיסוי בטון", "ds", "cm", id_5_value+"", 0));
            valuesModels.add(new StructuralDesignModel(6, " מקצב מוטות הזיון", "@", "cm", id_6_value+"", 0));
            valuesModels.add(new StructuralDesignModel(7, "קוטר", " Ø", "mm", id_7_value+"", 0));
            valuesModels.add(new StructuralDesignModel(8, "שטח חתך מחושב", "Asact", "cm^2", id_8_value+"", 0));
            valuesModels.add(new StructuralDesignModel(15, "מנת מוטות בחפייה לכלל המוטות הדרוש תמיד מעל 60% על פי תקן", "%", "d", "", id_15_position));
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            resultPositionsByIds = new ArrayMap<>();
            resultModels.add(new StructuralDesignModel(9, "זיון מחושב סופי", "סופי", "", mathId_9(), 0));
            resultModels.add(new StructuralDesignModel(10, "שטח חתך מוט בודד", "As'", "cm^2", mathId_10(), 0));
            resultModels.add(new StructuralDesignModel(11, "שטח חתך כולל", "Asact", "cm^2", mathId_11(), 0));
            resultModels.add(new StructuralDesignModel(12, "ערכי חוזק תכן של הבטון בהידבקות", "Fbd", "t / m^2", getRelevantValueForId_12(), 0));
            resultModels.add(new StructuralDesignModel(13, "אורך עיגון בסיסי", "Lb", "cm", mathId_13(), 0));
            resultModels.add(new StructuralDesignModel(14, "אורך בסיסי מתואם", "L,ao", "cm", mathId_14(), 0));
            resultModels.add(new StructuralDesignModel(111, "מקדם לקביעת אורך חפייה של מוטות מתיחה", "α3", "α", mathId_111(), 0));
            resultModels.add(new StructuralDesignModel(112, "אורך חפייה מינמאלי", "lv, min", "cm", mathId_112(), 0));
            resultModels.add(new StructuralDesignModel(113, "אורך חפייה", "lv, min", "cm", mathId_113(), 0));
            resultModels.add(new StructuralDesignModel(114, "", "בדיקה", "", mathId_114(), 0));
            resultModels.add(new StructuralDesignModel(115, "אורך חפייה לביצוע לברזל מתוח", "סופי מתוח", "cm", mathId_115(), 0));
            resultModels.add(new StructuralDesignModel(23, "אורך חפייה לביצוע לברזל לחוץ", "סופי לחוץ", "cm", mathId_23(), 0));
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
        sqLiteDatabase.execSQL(sqlHelper.updateCL_SQL(
                id_101_value, id_1_position, id_2_value, id_3_value, id_4_position, 0, id_5_value,
                id_125_value, id_6_value, id_7_value, id_8_value, 1, id_15_value,
                savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private void insertToDB() {
        sqLiteDatabase.execSQL(sqlHelper.insertCL_SQL(DialogHelper.input, moduleActiveId,
                categoryActiveId, subCategoryActiveId,
                id_101_value, id_1_position,
                id_2_value, id_3_value,
                id_4_position, 0, id_5_value,
                1,id_6_value, id_7_value,
                id_8_value, 1,id_15_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private String mathId_112() {
        id_112_value = Math.max(20, Math.max(0.6 *  id_13_value, id_101_value));
        Log.d("checkMath", "mathId_112() -> id_112_value == " + id_112_value + "; id_13_value == " + id_13_value + "; id_101_value == " + id_101_value);
        return formatNumberDecimal(id_112_value);
    }

    private String mathId_113() {
        id_113_value = 2 * id_14_value;
        Log.d("checkMath", "mathId_113() -> id_113_value == " + id_113_value + "; id_14_value == " + id_14_value);
        return formatNumberDecimal(id_113_value);
    }

    private String mathId_114() {
        Log.d("checkMath", "mathId_114() -> id_113_value == " + id_113_value + "; id_112_value == " + id_112_value);
        return id_113_value > id_112_value ? "אורך חפייה לפי חישוב" : "אורך חפייה מינמאלי";
    }

    private String mathId_115() {
        id_115_value = Math.max(id_112_value, id_113_value);
        Log.d("checkMath", "mathId_115() -> id_115_value == " + id_115_value + "; id_14_value == " + id_14_value);
        return formatNumberDecimal(id_115_value) + "";
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("numberChangedListener", "CanopyLengthsCategory{} -> valueItemNumber == " + valueItemNumber + "; valueItemId == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);

        switch (valueItemId) {
            case 1:
                id_1_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 2:
                id_2_position = spinnerPosition;
                id_2_value = getConcreteTypeDoubleValues()[id_2_position];
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 3:
                id_3_position = spinnerPosition;
                id_3_value = getId_3_doubleValues()[id_3_position];;
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 4:
                id_4_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 5:
                id_5_value = valueItemNumber;
                break;
            case 6:
                id_6_value = valueItemNumber;
                setRelevantResultItem_value(9, mathId_9(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                break;
            case 7:
                id_7_value = valueItemNumber;
                setRelevantResultItem_value(9, mathId_9(), "");
                setRelevantResultItem_value(10, mathId_10(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 8:
                id_8_value = valueItemNumber;
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(115, mathId_115(), "");
                break;
            case 101:
                id_101_value = valueItemNumber;
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                break;
            case 15:
                id_15_position = spinnerPosition;
                id_15_value = getId_15_doubleValues()[spinnerPosition];
                Log.d("numberChangedListener", "id_15_position == " + id_15_position + "; id_15_value == " + id_15_value);
                break;
        }
    }
}

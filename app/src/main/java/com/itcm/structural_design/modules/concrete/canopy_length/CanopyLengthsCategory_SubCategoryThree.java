package com.itcm.structural_design.modules.concrete.canopy_length;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class CanopyLengthsCategory_SubCategoryThree extends CanopyLengthsCategory {

    public CanopyLengthsCategory_SubCategoryThree(){
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
        spinnerPositionsArray.put(102,0);
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
            id_102_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_102_POSITION);
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
        spinnerPositionsArray.put(102, id_102_position);
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
            valuesModels.add(new StructuralDesignModel(102, "מצב מוט", "", "לחוץ\\מתוח", "", id_102_position));
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
            resultModels.add(new StructuralDesignModel(10, "שטח חתך  מוט בודד", "As'", "cm^2", mathId_10(), 0));
            resultModels.add(new StructuralDesignModel(11, "שטח חתך כולל", "Asact", "cm^2", mathId_11(), 0));
            resultModels.add(new StructuralDesignModel(12, "ערכי חוזק תכן של הבטון בהידבקות", "Fbd", "t / m^2", getRelevantValueForId_12(), 0));
            resultModels.add(new StructuralDesignModel(103, "אורך עיגון מינימלי", "Lmin", "cm", mathId_103(), 0));
            resultModels.add(new StructuralDesignModel(13, "אורך עיגון בסיסי", "Lb", "cm", mathId_13(), 0));
            resultModels.add(new StructuralDesignModel(14, "אורך  בסיסי מתואם", "L,ao", "cm", mathId_14(), 0));
            resultModels.add(new StructuralDesignModel(111, "מקדם לקביעת אורך חפייה של מוטות מתיחה", "α", "α", mathId_111(), 0));
            resultModels.add(new StructuralDesignModel(118, "אורך חפייה מינמאלי", "lv, min", "cm", mathId_118(), 0));
            resultModels.add(new StructuralDesignModel(119, "אורך חפייה", "lv, min", "cm", mathId_119(), 0));
            resultModels.add(new StructuralDesignModel(120, "", "בדיקה", "", mathId_120(), 0));
            resultModels.add(new StructuralDesignModel(121, "אורך חפייה לביצוע לברזל מתוח", "סופי מתוח", "cm", mathId_121(), 0));
            resultModels.add(new StructuralDesignModel(129, "אורך חפייה לביצוע לברזל לחוץ", "סופי לחוץ", "cm", mathId_129(), 0));
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
                id_101_value, id_1_position, id_2_value, id_3_value, id_4_position, id_102_position, id_5_value,
                1, id_6_value, id_7_value, id_8_value, 1, id_15_value,
                savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private void insertToDB() {
        sqLiteDatabase.execSQL(sqlHelper.insertCL_SQL(DialogHelper.input, moduleActiveId,
                categoryActiveId, subCategoryActiveId,
                id_101_value, id_1_position,
                id_2_value, id_3_value,
                id_4_position, id_102_position, id_5_value,
                1,id_6_value, id_7_value,
                id_8_value, 1,id_15_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private String mathId_118() {
        id_118_value = Math.max(20, Math.max(0.3 *  id_111_value * id_13_value, id_101_value));
        Log.d("checkMath", "mathId_118() -> id_118_value == " + id_118_value + "; id_13_value == " + id_13_value + "; id_101_value == " + id_101_value);
        return formatNumberDecimal(id_118_value) + "";
    }

    private String mathId_119() {
        id_119_value = id_111_value * id_14_value;
        Log.d("checkMath", "mathId_119() -> id_119_value == " + id_119_value + "; id_117_value == " + id_117_value + "; id_14_value == " + id_14_value);
        return formatNumberDecimal(id_119_value) + "";
    }

    private String mathId_120() {
        Log.d("checkMath", "mathId_120() -> id_119_value == " + id_119_value + "; id_118_value == " + id_118_value);
        return id_119_value > id_118_value ? "אורך חפייה לפי חישוב" : "אורך חפייה מינמאלי";
    }

    private String mathId_121() {
        id_121_value = Math.max(id_118_value,id_119_value);
        Log.d("checkMath", "mathId_121() -> id_121_value == " + id_121_value + "; id_119_value == " + id_119_value);
        return formatNumberDecimal(id_121_value) + "";
    }

    private String mathId_129() {
        id_129_value = Math.max(id_118_value,id_13_value);
        Log.d("checkMath", "mathId_129() -> id_129_value == " + id_129_value + "; id_118_value == " + id_118_value + "; id_13_value == " + id_13_value);
        return formatNumberDecimal(id_129_value) + "";
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (valueItemId) {
            case 1:
                id_1_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(129, mathId_129(), "");
                break;
            case 2:
                id_2_position = spinnerPosition;
                id_2_value = getConcreteTypeDoubleValues()[spinnerPosition];
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(129, mathId_129(), "");
                break;
            case 3:
                id_3_position = spinnerPosition;
                id_3_value = getId_3_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(129, mathId_129(), "");
                break;
            case 4:
                id_4_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(129, mathId_129(), "");
                break;
            case 5:
                id_5_value = valueItemNumber;
                setRelevantResultItem_value(103, mathId_103(), "");
                break;
            case 6:
                id_6_value = valueItemNumber;
                setRelevantResultItem_value(9, mathId_9(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                break;
            case 7:
                id_7_value = valueItemNumber;
                setRelevantResultItem_value(9, mathId_9(), "");
                setRelevantResultItem_value(10, mathId_10(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(129, mathId_129(), "");
                break;
            case 8:
                id_8_value = valueItemNumber;
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                break;
            case 101:
                id_101_value = valueItemNumber;
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                break;
            case 102:
                id_102_position = spinnerPosition;
                setRelevantResultItem_value(103, mathId_103(), "");
                break;
            case 15:
                id_15_position = spinnerPosition;
                id_15_value = getId_15_doubleValues()[spinnerPosition];
                Log.d("numberChangedListener", "id_15_position == " + id_15_position + "; id_15_value == " + id_15_value);
                break;
        }
    }

}

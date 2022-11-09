package com.itcm.structural_design.modules.concrete.canopy_length;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class CanopyLengthsCategory_SubCategoryOne extends CanopyLengthsCategory {

    public CanopyLengthsCategory_SubCategoryOne(){
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
        spinnerPositionsArray.put(104,0);
        spinnerPositionsArray.put(15,0);
    }

    public void resetValues() {
        id_2_value = 30; id_3_value = 200; id_5_value = 1; id_6_value = 1; id_7_value = 1; id_8_value = 1;
        id_15_value = 30; id_125_value = 1; id_104_value = 0.5;
        id_1_position = 0; id_2_position = 1; id_3_position = 0; id_4_position = 0; id_102_position = 0;
    }

    private void setValues() {
        if (savedVersionTitle != null) {
            cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
            cursor.moveToFirst();
            id_1_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_1_POSITION);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_4_POSITION);
            id_102_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_102_POSITION);
            id_5_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_5);
            id_125_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_125);
            id_6_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_6);
            id_7_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_7);
            id_8_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_8);
            id_104_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_104);
            id_15_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_15);
        }
        Log.d("checkSetValues", "savedVersionTitle == " + savedVersionTitle + "; cursor.moveToFirst() == " + cursor.moveToFirst() + "; savedVersionTitle == " + savedVersionTitle + "; moduleActiveId == " + moduleActiveId  + "; categoryActiveId == " + categoryActiveId + "; subCategoryActiveId == " + subCategoryActiveId);
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1, id_1_position);
        spinnerPositionsArray.put(2, getPositionByValue(getConcreteTypeDoubleValues(), id_2_value));
        spinnerPositionsArray.put(3, getPositionByValue(getId_3_doubleValues(), id_3_value));
        spinnerPositionsArray.put(4, id_4_position);
        spinnerPositionsArray.put(102, id_102_position);
        spinnerPositionsArray.put(104, getPositionByValue(getId_104_doubleValues(), id_104_value));
        spinnerPositionsArray.put(15, getPositionByValue(getId_15_doubleValues(), id_15_value));
        id_2_position = spinnerPositionsArray.get(2);
        id_3_position = spinnerPositionsArray.get(3);
        id_104_position = spinnerPositionsArray.get(104);
        id_15_position = spinnerPositionsArray.get(15);
    }

    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels){
            valuesModels = new ArrayList<>();
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels.add(new StructuralDesignModel(1, "סוג פלדה", "", "cm", "", id_1_position));
            valuesModels.add(new StructuralDesignModel(2, "סוג בטון", "ב", "ב-", "", id_2_position));
            valuesModels.add(new StructuralDesignModel(3, "חוזק תכן של הפלדה", "fsd", "kg \\ cm^2", "", id_3_position));
            valuesModels.add(new StructuralDesignModel(4, "תנאי הדיבקות", "Asact", "טוב/נחות", "", id_4_position));
            valuesModels.add(new StructuralDesignModel(102, "מצב מוט", "", "לחוץ\\מתוח", "", id_102_position));
            valuesModels.add(new StructuralDesignModel(5, " כיסוי בטון", "ds", "cm", id_5_value+"", 0));
            valuesModels.add(new StructuralDesignModel(125, "מרחק הנקי בין שתי חפיות סמוכות (בניצב למוט)", "ds", "cm", id_125_value+"", 0));
            valuesModels.add(new StructuralDesignModel(6, "מס' מוטות הזיון", "@", "כמות", id_6_value+"", 0));
            valuesModels.add(new StructuralDesignModel(7, "קוטר", " Ø", "mm", id_7_value+"", 0));
            valuesModels.add(new StructuralDesignModel(8, "שטח חתך מחושב", "Asact", "cm^2", id_8_value+"", 0));
            valuesModels.add(new StructuralDesignModel(104, "מקדם", "α1", "", "",  id_104_position));
            valuesModels.add(new StructuralDesignModel(15, "מנת מוטות בחפייה לכלל המוטות הדרוש תמיד מעל 60% על פי תקן", "%", "d", "", id_15_position));
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            resultPositionsByIds = new ArrayMap<>();
            resultModels.add(new StructuralDesignModel(10, "שטח חתך מוט בודד", "As'", "cm^2", mathId_10(), 0));
            resultModels.add(new StructuralDesignModel(126, "שטח חתך כולל", "Asact", "cm^2", mathId_126(), 0));
            resultModels.add(new StructuralDesignModel(12, "ערכי חוזק תכן של הבטון בהידבקות", "Fbd", "t / m^2", getRelevantValueForId_12(), 0));
            resultModels.add(new StructuralDesignModel(13, "אורך עיגון בסיסי", "Lb", "cm", mathId_13(), 0));
            resultModels.add(new StructuralDesignModel(103, "אורך עיגון מינימלי", "Lmin", "cm", mathId_103(), 0));
            resultModels.add(new StructuralDesignModel(127, "אורך בסיסי מתואם", "L,ao", "cm", mathId_127(), 0));
            resultModels.add(new StructuralDesignModel(105, "אורך העיגון", "La", "cm", mathId_105(), 0));
            resultModels.add(new StructuralDesignModel(106, "מקדם לקביעת אורך חפייה של מוטות מתיחה", "α", "α", mathId_106(), 0));
            resultModels.add(new StructuralDesignModel(107, "אורך חפייה מינמאלי (במתיחה)", "lv, min", "cm", mathId_107(), 0));
            resultModels.add(new StructuralDesignModel(108, "אורך חפייה", "lv", "cm", mathId_108(), 0));
            resultModels.add(new StructuralDesignModel(109, "lv > lv,min", "בדיקה", "", mathId_109(), 0));
            resultModels.add(new StructuralDesignModel(110, "אורך חפייה לביצוע לברזל מתוח", "סופי מתוח", "cm", mathId_110(), 0));
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

    private void insertToDB() {
        Log.d("checkInsertUpdate", "insertToDB() -> currentUserEmailGlobal == " + currentUserEmailGlobal);
        sqLiteDatabase.execSQL(sqlHelper.insertCL_SQL(
                DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId,
                1, id_1_position, id_2_value, id_3_value, id_4_position,
                id_102_position, id_5_value, id_125_value, id_6_value,
                id_7_value, id_8_value, id_104_value, id_15_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updateCL_SQL(
                1, id_1_position, id_2_value, id_3_value, id_4_position, id_102_position, id_5_value,
                id_125_value, id_6_value, id_7_value, id_8_value, id_104_value, id_15_value,
                savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private String mathId_105() {
        try {
            id_105_value = id_104_value * id_127_value;
            if (Double.isNaN(id_105_value) || id_105_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            Log.d("checkMath", "mathId_105() -> id_105_value == " + id_105_value + "; id_104_value == " + id_104_value + "; id_127_value == " + id_127_value);
            return formatNumberDecimal(id_105_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_105() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_106() {
        id_106_value = id_125_value <= id_7_value && id_5_value <= id_7_value ? 2 : 1.4;
        Log.d("checkMath", "mathId_106() -> id_106_value == " + id_106_value + "; id_6_value == " + id_6_value + "; id_7_value == " + id_7_value + "; id_5_value == " + id_5_value);
        return formatNumberDecimal(id_106_value) + "";
    }

    private String mathId_107() {
        id_107_value = Math.max(1.5 * id_7_value,Math.max(20, 0.3 * id_106_value * id_13_value));
        Log.d("checkMath", "mathId_21() -> id_107_value == " + id_107_value + "; id_7_value == " + id_7_value + "; id_106_value == " + id_106_value + "; id_13_value == " + id_13_value);
        return formatNumberDecimal(id_107_value) + "";
    }

    private String mathId_108() {
        try {
            id_108_value = id_106_value * id_127_value;
            Log.d("checkMath", "mathId_108() -> id_108_value == " + id_108_value + "; id_106_value == " + id_106_value + "; id_127_value == " + id_127_value);
            if (Double.isNaN(id_108_value) || id_108_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_108_value) + "";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_108() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_109() {
        Log.d("checkMath", "mathId_109() -> id_22_value == " + id_22_value);
        return id_108_value > id_107_value ? "אורך חפייה לפי חישוב" : "אורך חפייה מינמאלי";
    }

    private String mathId_110() {
        try {
            id_110_value = Math.max(id_108_value, id_107_value);
            Log.d("checkMath", "mathId_110() -> id_110_value == " + id_110_value + "; id_108_value == " + id_108_value + "; id_107_value == " + id_107_value);
            if (Double.isNaN(id_110_value) || id_110_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_110_value) + "";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_110() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_126(){
        id_126_value = Math.PI * Math.pow(id_7_value,2) / 4 * id_6_value / 100;
        Log.d("checkMath", "mathId_126() -> id_126_value == " + id_126_value + "; id_7_value == " + id_7_value + "; id_6_value == " + id_6_value);
        return formatNumberDecimal(id_126_value) + "";
    }

    public String mathId_127() {
        try {
            id_127_value = id_13_value * (id_8_value / id_126_value);
            Log.d("checkMath", "mathIdId_127() -> id_127_value == " + id_127_value + "; id_13_value == " + id_13_value + "; id_8_value == " + id_8_value + "; id_126_value == " + id_126_value);
            if (Double.isNaN(id_127_value) || id_127_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_127_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_127() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("numberChangedListener", "CanopyLengthsCategory{} -> valueItemNumber == " + valueItemNumber + "; valueItemId == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);

        switch (valueItemId) {
            case 1:
                id_1_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 2:
                id_2_position = spinnerPosition;
                id_2_value = getConcreteTypeDoubleValues()[spinnerPosition];
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                Log.d("numberChangedListener", "id_2_value == " + id_2_value);
                break;
            case 3:
                id_3_position = spinnerPosition;
                id_3_value = getId_3_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 4:
                id_4_position = spinnerPosition;
                setRelevantResultItem_value(12, getRelevantValueForId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 102:
                id_102_position = spinnerPosition;
                setRelevantResultItem_value(103, mathId_103(), "");
                Log.d("numberChangedListener", "id_102_position == " + id_102_position);
                break;
            case 5:
                id_5_value = valueItemNumber;
                Log.d("numberChangedListener", "id_5_value == " + id_5_value);
                setRelevantResultItem_value(106, mathId_106(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 125:
                id_125_value = valueItemNumber;
                Log.d("numberChangedListener", "id_5_value == " + id_5_value);
                setRelevantResultItem_value(106, mathId_106(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                break;
            case 6:
                id_6_value = valueItemNumber;
                setRelevantResultItem_value(126, mathId_126(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 7:
                id_7_value = valueItemNumber;
                setRelevantResultItem_value(10, mathId_10(), "");
                setRelevantResultItem_value(126, mathId_126(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                Log.d("numberChangedListener", "id_7_value == " + id_7_value);
                break;
            case 8:
                id_8_value = valueItemNumber;
                setRelevantResultItem_value(127, mathId_127(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                Log.d("numberChangedListener", "id_8_value == " + id_8_value);
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                break;
            case 104:
                id_104_value = getId_104_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(105, mathId_105(), "");
                Log.d("numberChangedListener", "id_104_position == " + id_104_position + "; id_104_value == " + id_104_value);
                break;
            case 15:
                id_15_position = spinnerPosition;
                id_15_value = getId_15_doubleValues()[spinnerPosition];
                Log.d("numberChangedListener", "id_15_position == " + id_15_position + "; id_15_value == " + id_15_value);
                break;
        }
    }

}

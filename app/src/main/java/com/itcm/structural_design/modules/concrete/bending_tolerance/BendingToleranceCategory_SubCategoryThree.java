package com.itcm.structural_design.modules.concrete.bending_tolerance;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class BendingToleranceCategory_SubCategoryThree extends BendingToleranceCategory {


    public BendingToleranceCategory_SubCategoryThree(){
        resetValues();
        setValues();
        initSpinnerPositions();
        setAllAdapters();
    }

    private void initSpinnerPositions() {
        spinnerPositionsArray.put(1000,0);
        spinnerPositionsArray.put(2,0);
        spinnerPositionsArray.put(10,0);
        spinnerPositionsArray.put(2026,0);
        spinnerPositionsArray.put(2034,0);
        spinnerPositionsArray.put(2042,0);
        spinnerPositionsArray.put(2048,0);
        spinnerPositionsArray.put(2027,0);
        spinnerPositionsArray.put(2035,0);
        spinnerPositionsArray.put(2043,0);
        spinnerPositionsArray.put(2049,0);
    }

    public void resetValues() {
        id_1_value = 1; id_2_value = 30; id_3_value = 1; id_4_value = 1; id_5_value = 1; id_6_value = 1; id_10_value = 400; id_102_value = 1;
        id_2026_value = 10; id_2034_value = 10; id_2042_value = 10; id_2048_value = 10; id_2027_value = 8; id_2035_value = 8;
        id_2043_value = 8; id_2049_value = 8;
        id_1000_position = 0; id_2_position = 1; id_10_position = 0; id_25_position = 0; id_26_position = 0; id_27_position = 0; id_28_position = 0;
        id_57_position = 0; id_58_position = 0; id_88_position = 0; id_92_position = 0;
        id_2026_position = 0; id_2027_position = 0; id_2034_position = 0; id_2035_position = 0;
        id_2042_position = 0; id_2043_position = 0; id_2048_position = 0; id_2049_position = 0;
    }

    public void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    private void setValues() {
        if (savedVersionTitle != null) {
            cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
            cursor.moveToFirst();
            id_1000_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_1000_POSITION);
            id_1_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_1);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_4);
            id_4_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_4);
            id_5_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_5);
            id_6_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_6);
            id_10_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_10);
            id_2026_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2026);
            id_2027_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2027);
            id_2034_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2034);
            id_2035_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2035);
            id_2042_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2042);
            id_2043_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2043);
            id_2048_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2048);
            id_2049_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2049);
            id_39_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_39);
            id_40_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_40);
        }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1000, id_1000_position);
        spinnerPositionsArray.put(2, getPositionByValue(getConcreteTypeDoubleValues(), id_2_value));
        spinnerPositionsArray.put(10,getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value));
        spinnerPositionsArray.put(2026,getPositionByValue(getFrom_2_to_9_stringValues(), id_2026_value));
        spinnerPositionsArray.put(2027,getPositionByValue(getFrom_8_to_25_stringValues(), id_2027_value));
        spinnerPositionsArray.put(2034,getPositionByValue(getFrom_2_to_10_stringValues(), id_2034_value));
        spinnerPositionsArray.put(2035,getPositionByValue(getFrom_8_to_25_stringValues(), id_2035_value));
        spinnerPositionsArray.put(2042,getPositionByValue(getFrom_8_to_25_stringValues(), id_2042_value));
        spinnerPositionsArray.put(2043,getPositionByValue(getFrom_8_to_25_stringValues(), id_2043_value));
        spinnerPositionsArray.put(2048,getPositionByValue(getFrom_8_to_25_stringValues(), id_2048_value));
        spinnerPositionsArray.put(2049,getPositionByValue(getFrom_8_to_25_stringValues(), id_2049_value));
        Log.d("checkSetValues", "id_10_value == " + id_10_value + "; getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value) == " + getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value));
        id_1000_position = spinnerPositionsArray.get(1000);
        id_2_position = spinnerPositionsArray.get(2);
        id_10_position = spinnerPositionsArray.get(10);
        id_2026_position = spinnerPositionsArray.get(2026);
        id_2027_position = spinnerPositionsArray.get(2027);
        id_2034_position = spinnerPositionsArray.get(2034);
        id_2035_position = spinnerPositionsArray.get(2035);
        id_2042_position = spinnerPositionsArray.get(2042);
        id_2043_position = spinnerPositionsArray.get(2043);
        id_2048_position = spinnerPositionsArray.get(2048);
        id_2049_position = spinnerPositionsArray.get(2049);
    }

    public void tonOrKnBtnClicked() {
        setRelevantResultItem_value(15, mathId_15(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(16, mathId_16(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(18, mathId_18(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(2056, mathId_2056(), getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(1, getRelevantSecondMeasuringUnit(1));
        setRelevantValueItemMeasuringUnit(39, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(40, getRelevantSecondMeasuringUnit(0));
    }


    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels) {
            valuesModels = new ArrayList<>();
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels.add(new StructuralDesignModel(1000, "סוג העומס", "", "", "", id_1000_position));
            valuesModels.add(new StructuralDesignModel(1, "מומנט תכן", "Md", "[KNm]", id_1_value+"", 0));
            valuesModels.add(new StructuralDesignModel(2, "סוג בטון", "", "", null,id_2_position));
            valuesModels.add(new StructuralDesignModel(3, "גובה חתך", "h", "[cm]", id_3_value+"", 0));
            valuesModels.add(new StructuralDesignModel(4, "עובי כיסוי זיו מתוח", "ds", "[cm]", id_4_value+"", 0));
            valuesModels.add(new StructuralDesignModel(5, "עובי כיסוי זיו לחוץ", "d's", "[cm]", id_102_value+"", 0));
            valuesModels.add(new StructuralDesignModel(6, "רוחב אלמנט", "b", "[cm]", id_6_value+"", 0));
            valuesModels.add(new StructuralDesignModel(10, "חוזק אופייני של הפלדה", "fck", "[Mpa]", "", id_10_position));
            valuesModels.add(new StructuralDesignModel(2026, "פסיעה", "@", "[cm]", "", id_2026_position));
            valuesModels.add(new StructuralDesignModel(2027, "קוטר ברזל מתוח", "Φ", "[mm]", "", id_2027_position));
            valuesModels.add(new StructuralDesignModel(2034, "מס מוטות לחוצים", "@", "[cm]", "", id_2034_position));
            valuesModels.add(new StructuralDesignModel(2035, "קוטר מוט לחוץ", "Φ", "[mm]", "", id_2035_position));
            valuesModels.add(new StructuralDesignModel(2042, "זיון מחלק תחתון", "@", "[cm]", "", id_2042_position));
            valuesModels.add(new StructuralDesignModel(2043, "קוטר זיון מחלק תחתון", "Φ", "[mm]", "", id_2043_position));
            valuesModels.add(new StructuralDesignModel(2048, "זיון מחלק עליון", "@", "[cm]", "", id_2048_position));
            valuesModels.add(new StructuralDesignModel(2049, "קוטר זיון מחלק עליון", "Φ", "[mm]", "", id_2049_position));
            valuesModels.add(new StructuralDesignModel(39, "כוח צירי לתכן בבטון (חיובי = לחיצה)", "Nd", "[KN]", id_39_value+"", 0));
            valuesModels.add(new StructuralDesignModel(40, "כוח גזירה לתכן בבטון", "Vd", "[KN]", id_40_value+"", 0));
            setValuesModelsPositions();
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            resultPositionsByIds = new ArrayMap<>();
            resultModels.add(new StructuralDesignModel(7, "גובה פעיל", "d", "[cm]", mathId_7() + "", 0));
            resultModels.add(new StructuralDesignModel(8, "חוזק אופייני של הבטון", "fck", "[Mpa]", getConcreteTypeDoubleValues()[id_2_position]+"", 0));
            resultModels.add(new StructuralDesignModel(9, "חוזק בטון", "fcd", "[Mpa]", getRelevantValueForId(9), 0));
            resultModels.add(new StructuralDesignModel(11, "חוזק פלדה", "fcd", "[Mpa]", getRelevantValueForId(11), 0));
            resultModels.add(new StructuralDesignModel(12, "חוזק מתיחה צירית ממוצעת לשירות בבטון מזויין", "fctm", " [Mpa]", getRelevantValueForId(12) + "", 0));
            resultModels.add(new StructuralDesignModel(13, "מנת זיון מתוח בחתך בטון מזוין למניעת הרסה פריך(5.4)", "ρ", "-", getRelevantValueForId(13) + "", 0));
            resultModels.add(new StructuralDesignModel(14, "זיון מינמלי לכפיפה (5.3.6)", "ρ", "-", getRelevantValueForId(14) + "", 0));
            resultModels.add(new StructuralDesignModel(15, "מומנט תסבולת מקסימלי", "Mcd,max", "[KNm]", mathId_15(), 0));
            resultModels.add(new StructuralDesignModel(16, "בדיקה מומנט תסבולת מקסימלי", "2*Mcd,max>Md", "[KNm]", mathId_16(), 0));
            resultModels.add(new StructuralDesignModel(17, "בדיקת מומנט התכן מול מומנט התסבולת", "Mcd>Md", "-", mathId_17(), 0));
            resultModels.add(new StructuralDesignModel(18, "מומנט תכן", "DMd", "[KNm]", mathId_18(), 0));
            resultModels.add(new StructuralDesignModel(19, "תוספת  זיון לחוץ", "As'_calc", "[cm²]", mathId_19(), 0));
            resultModels.add(new StructuralDesignModel(20, "שטח חתך זיון מינימלי", "As,min", "[cm²]", mathId_20(), 0));
            resultModels.add(new StructuralDesignModel(2001, "  זיון מחלק עליון דרוש", "As',calc", "[cm²]", mathId_20(), 0));
            resultModels.add(new StructuralDesignModel(21, "יחס איזור לחוץ/מתוח", "ω", "-", mathId_21(), 0));
            resultModels.add(new StructuralDesignModel(22, "גובה אזור לחוץ", "x", "-", mathId_22(), 0));
            resultModels.add(new StructuralDesignModel(23, "זרוע שקול כוחות", "Z", "[сm]", mathId_23(), 0));
            resultModels.add(new StructuralDesignModel(24, "שטח זיון מתוח מחושב", "As'_calc", "[cm²]", mathId_24(), 0));
            resultModels.add(new StructuralDesignModel(2028, "זיון מתוח בתקרה", "", "", mathId_2028(), 0));
            resultModels.add(new StructuralDesignModel(2029, "זיון מתוח בתקרה", "", "", mathId_2029(), 0));
            resultModels.add(new StructuralDesignModel(2030, "בדיקת פסיעת מוטות מתוחים", "\"@,d<@,calc\"", "-", mathId_2030(), 0));
            resultModels.add(new StructuralDesignModel(2031, "בדיקת שטח הזיון  המתוח בפועל מול הזיון המחושב", "As,act>As,calc", "-", mathId_2031(), 0));
            resultModels.add(new StructuralDesignModel(2032, "בדיקת שטח הזיון  המתוח בפועל מול זיון המינימום", "As,act>As,min", "-", mathId_2032(), 0));
            resultModels.add(new StructuralDesignModel(2033, "בדיקת שטח זיון מתוח  מול מקסימום", "Asact<As,max", "-", mathId_2033(), 0));
            resultModels.add(new StructuralDesignModel(234, "זיון מחלק תחתון דרוש", "As',calc", "[cm²]", mathId_234(), 0));
            resultModels.add(new StructuralDesignModel(2036, "זיון מתוח בתקרה", "", "", mathId_2036(), 0));
            resultModels.add(new StructuralDesignModel(2037, "שטח זיון לחוץ בפועל", "As',act", "[cm²]", mathId_2037(), 0));
            resultModels.add(new StructuralDesignModel(2038, "בדיקת פסיעת מוטות לחוצים", "\"@,d<@,calc\"", "-", mathId_2038(), 0));
            resultModels.add(new StructuralDesignModel(2039, "בדיקת שטח הזיון הלחוץ פועל  מול הזיון המחושב", "As',act>As',calc", "-", mathId_2039(), 0));
            resultModels.add(new StructuralDesignModel(2040, "בדיקת שטח הזיון הלחוץ פועל  מול זיון המינימום", "As',act>As,min", "-", mathId_2040(), 0));
            resultModels.add(new StructuralDesignModel(2041, "בדיקת שטח  זיון  לחוץ מול מקסימום", "As'act<As,max", "-", mathId_2041(), 0));
            resultModels.add(new StructuralDesignModel(2044, "זיון מחלק תחתון בתקרה", "", "", mathId_2044(), 0));
            resultModels.add(new StructuralDesignModel(2045, "שטח זיון מחלק תחתון", "As',act", "[cm²]", mathId_2045(), 0));
            resultModels.add(new StructuralDesignModel(2046, "בדיקת פסיעת מוטות מחלק תחתון", "\"@,d<@,calc\"", "-", mathId_2046(), 0));
            resultModels.add(new StructuralDesignModel(2047, "בדיקת שטח הזיון מחלק תחתון", "As,act>As,calc", "-", mathId_2047(), 0));
            resultModels.add(new StructuralDesignModel(2050, "זיון מחלק עליון בתקרה", "", "", mathId_2050(), 0));
            resultModels.add(new StructuralDesignModel(2051, "שטח זיון מחלק עליון", "As',act", "[cm²]", mathId_2051(), 0));
            resultModels.add(new StructuralDesignModel(2052, "בדיקת פסיעת מוטות מחלק עליון", "\"@,d<@,calc\"", "-", mathId_2052(), 0));
            resultModels.add(new StructuralDesignModel(2053, "בדיקת שטח הזיון מחלק עליון", "As,act>As,calc", "-", mathId_2053(), 0));
            resultModels.add(new StructuralDesignModel(41, "שטח חתך", "Ag", "[cm²]", mathId_41(), 0));
            resultModels.add(new StructuralDesignModel(2054, "שטח זיון אורכי", "ΣAs", "[cm²]", mathId_2054(), 0));
            resultModels.add(new StructuralDesignModel(2055, "מנת הזיון האורכית", "ρ", "-", mathId_2055(), 0));
            resultModels.add(new StructuralDesignModel(44, "K", "", "", mathId_44(), 0));
            resultModels.add(new StructuralDesignModel(45, "מאמץ בבטון", "σcp", "[Mpa]", mathId_45(), 0));
            resultModels.add(new StructuralDesignModel(2056, "תסבולת בטון ללא זיון הגזירה", "VRdc", "[KN]", mathId_2056(), 0));
            resultModels.add(new StructuralDesignModel(2057, "בדיקה תסבולת החתך", "", "", mathId_2057(), 0));
            setResultModelsPositions();
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
        sqLiteDatabase.execSQL(sqlHelper.insertBTThird_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId,
                id_1000_position,id_1_value, id_2_value, id_3_value, id_4_value,
                id_5_value, id_6_value, id_10_value,
                id_2026_value, id_2027_value, id_2034_value, id_2035_value,
                id_2042_value, id_2043_value, id_2048_value, id_2049_value,
                id_39_value, id_40_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updateBTThird_SQL(
                id_1000_position, id_1_value, id_2_value, id_3_value, id_4_value, id_5_value, id_6_value, id_10_value, id_2026_value,
                id_2027_value, id_2034_value, id_2035_value, id_2042_value, id_2043_value, id_2048_value, id_2049_value, id_39_value,
                id_40_value, savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    public String mathId_2001(){
        id_2001_value = id_1000_position == 0 ? Math.max(0.2 * id_19_value, 0.5 * id_20_value) : Math.max(0.6 * id_19_value, id_20_value);
        Log.d("checkMath", "mathId_2001() -> id_1000_position == " + id_1000_position + "; id_19_value == " + id_19_value + "; id_20_value == " + id_20_value);
        return formatNumberDecimal(id_2001_value) + "";
    }

    public String mathId_2028(){
        return mathConcatenate(id_2027_value, id_2026_value);
    }

    public String mathId_2029(){
        id_2029_value = (Math.PI * Math.pow(id_2027_value,2)) / 4 * (100 / id_2026_value) * 0.01;
        return formatNumberDecimal(id_2029_value) + "";
    }

    public String mathId_2030(){
        id_2030_value_string = id_1000_position == 0 ? id_2026_value <= Math.min(3 * id_7_value, 30) ? "פסיעה תקינה" : "פסיעת זיון לא תקינה" : id_2026_value <= Math.min(2* id_7_value,25) ? "פסיעה תקינה" : "פסיעת זיון לא תקינה";
        return id_2030_value_string;
    }

    public String mathId_2031(){
        id_2031_value_string = id_24_value_string.equals(context.getString(R.string.not_valid_cut)) ? context.getString(R.string.not_valid_cut) : id_2029_value > id_24_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        Log.d("checkMath", "mathId_2031() -> id_2031_value_string == " + id_2031_value_string + "; id_7_value == " + id_7_value);
        return id_2031_value_string;
    }

    public String mathId_2032(){
        id_2032_value_string = id_2029_value > id_20_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        return id_2032_value_string;
    }

    public String mathId_2033(){
        id_2033_value_string = id_2029_value < 0.04 * id_7_value * id_6_value ? OK : context.getString(R.string.armament_dose_is_too_big);;
        return id_2033_value_string;
    }

    public String mathId_2036(){
        return mathConcatenate(id_2035_value, id_2034_value);
    }

    public String mathId_2037(){
        id_2037_value = (Math.PI * Math.pow(id_2035_value, 2)) / 4 * (100 / id_2034_value) * 0.01;
        return formatNumberDecimal(id_2037_value) + "";
    }

    public String mathId_2038(){
        id_2038_value_string =
                id_1000_position == 0
                ? id_2034_value <= Math.min(3 * id_7_value,30)
                ? "פסיעה תקינה"
                : "פסיעת זיון לא תקינה"
                : id_2034_value <= Math.min(2 * id_7_value,25)
                        ?"פסיעה תקינה"
                        :"פסיעת זיון לא תקינה";
        return id_2038_value_string;
    }

    public String mathId_2039(){
        id_2039_value_string = id_2037_value > id_19_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        return id_2039_value_string;
    }

    public String mathId_2040(){
        id_2040_value_string = id_2037_value > id_20_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        return id_2040_value_string;
    }

    public String mathId_2041(){
        id_2041_value_string = id_2037_value < 0.04 * id_7_value * id_6_value ? OK : context.getString(R.string.armament_dose_is_too_big);
        return id_2041_value_string;
    }

    public String mathId_234(){
        id_234_value = id_1000_position == 0 ? Math.max(0.2 * id_2029_value,0.5 * id_20_value) : Math.max(0.6 * id_2029_value, id_20_value);
        return formatNumberDecimal(id_234_value) + "";
    }

    public String mathId_2044(){
        return mathConcatenate(id_2043_value, id_2042_value);
    }

    public String mathId_2045(){
        id_2045_value = (Math.PI * Math.pow(id_2043_value, 2)) / 4 * (100 / id_2042_value) * 0.01;
        Log.d("checkMath", "mathId_2045() -> id_2045_value == " + id_2045_value + "; id_2043_value == " + id_2043_value + "; id_2042_value == " + id_2042_value + "; firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart);
        return formatNumberDecimal(id_2045_value) + "";
    }

    public String mathId_2046(){
        id_2046_value_string = id_2042_value <= Math.min(3 * id_7_value, 30) ? context.getString(R.string.pitch_is_proper) : context.getString(R.string.pitch_is_not_proper);
        return id_2046_value_string;
    }

    public String mathId_2047(){
        id_2047_value_string = id_2045_value > id_234_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        return id_2047_value_string;
    }

    public String mathId_2050(){
        return mathConcatenate(id_2049_value, id_2048_value);
    }

    public String mathId_2051(){
        id_2051_value = (Math.PI * Math.pow(id_2049_value, 2)) / 4 * (100 / id_2048_value) * 0.01;
        return formatNumberDecimal(id_2051_value) +"";
    }

    public String mathId_2052(){
        id_2052_value_string = id_2048_value <= Math.min(3 * id_7_value, 30) ? context.getString(R.string.pitch_is_proper) : context.getString(R.string.pitch_is_not_proper);
        return id_2052_value_string;
    }

    public String mathId_2053(){
        id_2053_value_string = id_2051_value > id_2001_value? OK : context.getString(R.string.armament_dose_is_not_enough);
        return id_2053_value_string;
    }

    public String mathId_2054(){
        id_2054_value = id_2029_value;
        return formatNumberDecimal(id_2054_value) +"";
    }

    public String mathId_2055(){
        id_2055_value = id_2054_value / id_41_value;
        return formatNumberDecimal(id_2055_value) +"";
    }

    public String mathId_2056(){

        try {
            if (Double.isNaN(id_44_value)) throw new NumberFormatException(NaN);
            id_2056_value = Math.max(
                    (0.12 * id_44_value * (Math.pow(100 * id_2055_value * 0.7 * id_8_value, 1.0 / 3.0)) + (0.15 * id_45_value)) * (id_6_value * id_7_value * 100),
                    (0.035 * id_44_value * (Math.pow((0.7 * id_8_value), 0.5)) + (0.15 * id_45_value)) * (id_6_value * id_7_value * 100)) / 1000;
            return formatNumberDecimal(id_2056_value) + "";
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_2056_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_2057(){
        Log.d("checkMath", "mathId_2057 -> id_2056_value == " + id_2056_value + "; id_40_value == " + id_40_value + "; id_2056_value_string == " + id_2056_value_string);
        if (Double.isNaN(id_2056_value)){ return context.getString(R.string.not_valid_cut); }
        return id_40_value < id_2056_value  ? context.getString(R.string.endurance_of_cut_valid) : context.getString(R.string.endurance_of_cut_not_valid);
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("changedListener", "BendingToleranceCategory{} -> valueItemNumber == " + valueItemNumber + "; id == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);
        switch (valueItemId) {
            case 1000:
                id_1000_position = spinnerPosition;
                spinnerPositionsArray.put(valueItemId, id_1000_position);
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2038, mathId_2038(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                break;
            case 1:
                id_1_value = valueItemNumber;
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                break;
            case 2:
                id_2_position = spinnerPosition;
                spinnerPositionsArray.put(valueItemId, id_2_position);
                id_2_value = getConcreteTypeDoubleValues()[spinnerPosition];
                id_8_value = id_2_value;
                setRelevantResultItem_value(8, id_8_value + "", "");
                setRelevantResultItem_value(9, getRelevantValueForId(9), "");
                setRelevantResultItem_value(12, getRelevantValueForId(12), "");
                setRelevantResultItem_value(13, getRelevantValueForId(13), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 3:
                id_3_value = valueItemNumber;
                setRelevantResultItem_value(7, mathId_7(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2030, mathId_2030(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(2033, mathId_2033(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2038, mathId_2038(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2041, mathId_2041(), "");
                setRelevantResultItem_value(2046, mathId_2046(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2052, mathId_2052(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(2055, mathId_2055(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 4:
                id_4_value = valueItemNumber;
                setRelevantResultItem_value(7, mathId_7(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2030, mathId_2030(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(2033, mathId_2033(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2038, mathId_2038(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2041, mathId_2041(), "");
                setRelevantResultItem_value(2046, mathId_2046(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2052, mathId_2052(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 5:
                id_5_value = valueItemNumber;
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                break;
            case 6:
                id_6_value = valueItemNumber;
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 10:
                id_10_position = spinnerPosition;
                id_10_value = Double.parseDouble(getFrom_400_to_500_stringValues()[id_10_position]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(11, getRelevantValueForId(11), "");
                setRelevantResultItem_value(13, getRelevantValueForId(13), "");
                setRelevantResultItem_value(14, getRelevantValueForId(14), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(2001, mathId_2001(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 2026:
                id_2026_position = spinnerPosition;
                id_2026_value = Double.parseDouble(getFrom_10_to_30_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2028, mathId_2028(), "");
                setRelevantResultItem_value(2029, mathId_2029(), "");
                setRelevantResultItem_value(2030, mathId_2030(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(2033, mathId_2033(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2054, mathId_2054(), "");
                setRelevantResultItem_value(2055, mathId_2055(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 2027:
                id_2027_position = spinnerPosition;
                id_2027_value = Double.parseDouble(getFrom_12_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2028, mathId_2028(), "");
                setRelevantResultItem_value(2029, mathId_2029(), "");
                setRelevantResultItem_value(2031, mathId_2031(), "");
                setRelevantResultItem_value(2032, mathId_2032(), "");
                setRelevantResultItem_value(2033, mathId_2033(), "");
                setRelevantResultItem_value(234, mathId_234(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                setRelevantResultItem_value(2054, mathId_2054(), "");
                setRelevantResultItem_value(2055, mathId_2055(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 2034:
                id_2034_position = spinnerPosition;
                id_2034_value = Double.parseDouble(getFrom_10_to_30_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2036, mathId_2036(), "");
                setRelevantResultItem_value(2037, mathId_2037(), "");
                setRelevantResultItem_value(2038, mathId_2038(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2041, mathId_2041(), "");
                break;
            case 2035:
                id_2035_position = spinnerPosition;
                id_2035_value = Double.parseDouble(getFrom_12_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2036, mathId_2036(), "");
                setRelevantResultItem_value(2037, mathId_2037(), "");
                setRelevantResultItem_value(2039, mathId_2039(), "");
                setRelevantResultItem_value(2040, mathId_2040(), "");
                setRelevantResultItem_value(2041, mathId_2041(), "");
                break;
            case 2042:
                id_2042_position = spinnerPosition;
                id_2042_value = Double.parseDouble(getFrom_10_to_30_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2044, mathId_2044(), "");
                setRelevantResultItem_value(2045, mathId_2045(), "");
                setRelevantResultItem_value(2046, mathId_2046(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                break;
            case 2043:
                id_2043_position = spinnerPosition;
                id_2043_value = Double.parseDouble(getFrom_12_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2044, mathId_2044(), "");
                setRelevantResultItem_value(2045, mathId_2045(), "");
                setRelevantResultItem_value(2047, mathId_2047(), "");
                break;
            case 2048:
                id_2048_position = spinnerPosition;
                id_2048_value = Double.parseDouble(getFrom_10_to_30_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2050, mathId_2050(), "");
                setRelevantResultItem_value(2051, mathId_2051(), "");
                setRelevantResultItem_value(2052, mathId_2052(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                break;
            case 2049:
                id_2049_position = spinnerPosition;
                id_2049_value = Double.parseDouble(getFrom_12_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(2050, mathId_2050(), "");
                setRelevantResultItem_value(2051, mathId_2051(), "");
                setRelevantResultItem_value(2053, mathId_2053(), "");
                break;
            case 39:
                id_39_value = valueItemNumber;
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(2056, mathId_2056(), "");
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
            case 40:
                id_40_value = valueItemNumber;
                setRelevantResultItem_value(2057, mathId_2057(), "");
                break;
        }
    }

}

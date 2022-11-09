package com.itcm.structural_design.modules.concrete.paging;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.math.RoundingMode;
import java.util.ArrayList;

public class PagingSubcategoryTwo extends PagingCategory {

    public PagingSubcategoryTwo() {
        setValues();
        setAllAdapters();
    }

    public View.OnClickListener onSaveClickListener = view -> insertOrUpdateVersion(savedVersionTitle == null);

    public void insertOrUpdateVersion(boolean isForInsert) {
        if (!isForInsert) {
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

    private void resetValues() {
        id_1_value = 1;
        id_2_value = 1;
        id_3_value = 1;
        id_4_value = 1;
        id_6_value = 30;
        id_7_value = 30;
        id_9_value = 400;
        id_21_value = 2;
        id_22_value = 8;
        id_27_value = 1;
        id_270_value = 8;
        id_400_value = 1;
        id_34_value = 2;
        id_35_value = 8;
        id_42_position = 0;
        id_43_value = 1;
        id_44_value = 1;
        id_45_value = 1;
        id_48_value = 1;
        id_49_value = 1;
        id_50_value = 1;
        id_51_position = 0;
        id_55_value = 1;
        id_56_value = 1;
        id_57_value = 1;
        id_58_position = 0;
        id_61_value = 1;
        id_62_value = 1;
        id_63_value = 1;
        id_67_value = 1;
        id_68_value = 1;
        id_69_value = 1;
        id_70_position = 0;
        id_74_value = 1;
        id_75_value = 1;
        id_76_value = 1;
        id_77_position = 0;
        id_80_value = 1;
        id_81_value = 1;
        id_82_value = 1;
        id_85_position = 0;
        id_86_position = 0;
        id_88_value = 1;
        id_89_value = 1;
        id_90_value = 1;
        id_94_position = 1;
        id_96_value = 1;
        id_97_value = 1;
        id_115_value = 1;
        id_116_value = 2;
        id_94_position = 0;
        id_6_position = 1;
        id_9_position = 0;
        id_21_position = 0;
        id_22_position = 0;
        id_34_position = 0;
        id_35_position = 0;
    }

//    private void resetValues() {
//        id_1_value = 10; id_2_value = 20; id_3_value = 30; id_4_value = 40; id_400_value = 50; id_6_value = 50; id_7_value = 50; id_9_value = 500;
//        id_21_value = 4; id_22_value = 25; id_27_value = 60;  id_270_value = 14;  id_270_position = 3;
//        id_34_value = 4; id_34_position = 2; id_35_value = 25; id_42_position = 1; id_43_value = 70; id_44_value = 80; id_45_value = 90; id_48_value = 10;
//        id_49_value = 20; id_50_value = 30; id_51_position = 2; id_55_value = 40; id_56_value = 50; id_57_value = 60; id_58_position = 2; id_61_value = 70;
//        id_62_value = 80; id_63_value = 90; id_67_value = 10; id_68_value = 20; id_69_value = 30; id_70_position = 2; id_74_value = 40; id_75_value = 50;
//        id_76_value = 60; id_77_position = 2; id_80_value = 70; id_81_value = 80; id_82_value = 90; id_85_position = 1; id_86_position = 2; id_88_value = 10;
//        id_89_value = 20; id_90_value = 30; id_94_position = 1; id_96_value = 40; id_97_value = 50; id_115_value = 60; id_116_value = 10;
//        id_6_position = 3; id_9_position = 1; id_21_position = 2; id_22_position = 6;
//        id_35_position = 6;
//    }

    private void insertToDB() {
        Log.d("checkInsertUpdate", "insertToDB() -> currentUserEmailGlobal == " + currentUserEmailGlobal);
        sqLiteDatabase.execSQL(sqlHelper.insertPagingCategoryTwo_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId, id_1_value, id_2_value,
                id_3_value, id_4_value, id_400_value, id_6_value, id_9_value, id_21_value, id_22_value, id_27_value, id_34_value, id_35_value, id_42_position,
                id_43_value, id_44_value, id_45_value, id_48_value, id_49_value, id_50_value, id_51_position, id_55_value, id_56_value, id_57_value,
                id_58_position, id_61_value, id_62_value, id_63_value, id_67_value, id_68_value, id_69_value, id_70_position, id_74_value, id_75_value, id_76_value,
                id_77_position, id_80_value, id_81_value, id_82_value, id_85_position, id_86_position, id_88_value, id_89_value, id_90_value, id_94_position, id_96_value,
                id_97_value, id_115_value, id_116_value, id_270_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId + "", categoryActiveId + "", subCategoryActiveId + "", DialogHelper.input);
    }

    private void updateDB() {
        Log.d("checkInsertUpdate", "insertToDB() -> currentUserEmailGlobal == " + currentUserEmailGlobal);
        sqLiteDatabase.execSQL(sqlHelper.updatePagingCategoryTwo_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId, id_1_value, id_2_value,
                id_3_value, id_4_value, id_400_value, id_6_value, id_9_value, id_21_value, id_22_value, id_27_value, id_34_value, id_35_value, id_42_position,
                id_43_value, id_44_value, id_45_value, id_48_value, id_49_value, id_50_value, id_51_position, id_55_value, id_56_value, id_57_value,
                id_58_position, id_61_value, id_62_value, id_63_value, id_67_value, id_68_value, id_69_value, id_70_position, id_74_value, id_75_value, id_76_value,
                id_77_position, id_80_value, id_81_value, id_82_value, id_85_position, id_86_position, id_88_value, id_89_value, id_90_value, id_94_position, id_96_value,
                id_97_value, id_115_value, id_116_value, id_270_value));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId + "", categoryActiveId + "", subCategoryActiveId + "", DialogHelper.input);
    }

    private void setValues() {
        cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
        if (cursor.moveToFirst()) {
            id_1_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_1);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_4);
            id_400_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_400);
            id_6_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_6);
            id_9_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_9);
            id_21_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_21);
            id_22_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_22);
            id_27_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_27);
            id_34_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_34);
            id_35_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_35);
            id_42_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_42_POSITION);
            id_43_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_43);
            id_44_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_44);
            id_45_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_45);
            id_48_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_48);
            id_49_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_49);
            id_50_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_50);
            id_51_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_51_POSITION);
            id_55_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_55);
            id_56_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_56);
            id_57_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_57);
            id_58_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_58_POSITION);
            id_61_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_61);
            id_62_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_62);
            id_63_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_63);
            id_67_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_67);
            id_68_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_68);
            id_69_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_69);
            id_70_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_70_POSITION);
            id_74_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_74);
            id_75_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_75);
            id_76_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_76);
            id_77_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_77_POSITION);
            id_80_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_80);
            id_81_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_81);
            id_82_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_82);
            id_85_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_85_POSITION);
            id_86_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_86_POSITION);
            id_88_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_88);
            id_89_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_89);
            id_90_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_90);
            id_94_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_94_POSITION);
            id_96_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_96);
            id_97_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_97);
            id_115_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_115);
            id_116_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_116);
            id_270_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_270);

            id_6_position = getPositionByValue(getConcreteTypeDoubleValues(), id_6_value);
            id_9_position = getPositionByValue(getFrom_400_to_500_doubleValues(), id_9_value);
            id_21_position = getPositionByValue(getFrom_2_to_4_doubleValues(), id_21_value);
            id_22_position = getPositionByValue(getFrom_8_to_25_stringValues(), id_22_value);
            id_34_position = getPositionByValue(getFrom_2_to_4_doubleValues(), id_34_value);
            id_35_position = getPositionByValue(getFrom_8_to_25_stringValues(), id_35_value);
            id_270_position = getPositionByValue(getFrom_8_to_25_stringValues(), id_270_value);
        } else {
            resetValues();
        }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(6, id_6_position);
        spinnerPositionsArray.put(9, id_9_position);
        spinnerPositionsArray.put(21, id_21_position);
        spinnerPositionsArray.put(22, id_22_position);
        spinnerPositionsArray.put(34, id_34_position);
        spinnerPositionsArray.put(35, id_35_position);
        spinnerPositionsArray.put(42, id_42_position);
        spinnerPositionsArray.put(51, id_51_position);
        spinnerPositionsArray.put(58, id_58_position);
        spinnerPositionsArray.put(70, id_70_position);
        spinnerPositionsArray.put(77, id_77_position);
        spinnerPositionsArray.put(85, id_85_position);
        spinnerPositionsArray.put(86, id_86_position);
        spinnerPositionsArray.put(94, id_94_position);
        spinnerPositionsArray.put(270, id_270_position);
    }

    private void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    public void tonOrKnBtnClicked() {
        setRelevantResultItem_value(14, mathId_14(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(15, mathId_15(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(151, mathId_151(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(103, mathId_103(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(104, mathId_104(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(121, mathId_121(), getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(1, getRelevantSecondMeasuringUnit(1));
        setRelevantValueItemMeasuringUnit(96, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(97, getRelevantSecondMeasuringUnit(0));
    }

    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels) {
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels = new ArrayList<>();
            valuesModels.add(new StructuralDesignModel(1, "מומנט התכן", "Md", "[KNm]", id_1_value + "", 0));
            valuesModels.add(new StructuralDesignModel(2, "גובה חתך", "h", "[cm]", id_2_value + "", 0));
            valuesModels.add(new StructuralDesignModel(3, "עובי כיסוי זיו מתוח", "ds", "[cm]", id_3_value + "", 0));
            valuesModels.add(new StructuralDesignModel(4, "רוחב אלמנט", "b", "[cm]", id_4_value + "", 0));
            valuesModels.add(new StructuralDesignModel(400, "עובי כיסוי זיו לחוץ", "d's", "[cm]", id_400_value + "", 0));
            valuesModels.add(new StructuralDesignModel(6, "סוג בטון", "", "", "", id_6_position));
            valuesModels.add(new StructuralDesignModel(9, "חוזק אופייני של הפלדה", "fsk", "[Mpa]", "", id_9_position));
            valuesModels.add(new StructuralDesignModel(21, "מס מוטות מתוחים", "", "[cm]", "", id_21_position));
            valuesModels.add(new StructuralDesignModel(22, "קוטר ברזל מתוח", "Φ", "[mm]", "", id_22_position));
            valuesModels.add(new StructuralDesignModel(27, "שכבת כיסוי בטון", "C", "[cm]", id_27_value + "", 0));
            valuesModels.add(new StructuralDesignModel(270, "קוטר ברזל חישוק לגזירה", "Φ", "[mm]", "", id_270_position));
            valuesModels.add(new StructuralDesignModel(34, "מס מוטות לחוצים", "d's", "[cm]", "", id_34_position));
            valuesModels.add(new StructuralDesignModel(35, "קוטר מוט לחוץ", "Φ", "[mm]", "", id_35_position));
            valuesModels.add(new StructuralDesignModel(42, "", "", "", "", id_42_position));
            valuesModels.add(new StructuralDesignModel(43, "גובה עמוד", "hb", "[cm]", id_43_value + "", 0));
            valuesModels.add(new StructuralDesignModel(44, "רוחב עמוד", "bc", "[cm]", id_44_value + "", 0));
            valuesModels.add(new StructuralDesignModel(45, "אורך חופשי של עמוד", "Lc", "[cm]", id_45_value + "", 0));
            valuesModels.add(new StructuralDesignModel(48, "גובה קורה", "hb", "[cm]", id_48_value + "", 0));
            valuesModels.add(new StructuralDesignModel(49, "רוחב קורה", "bb", "[cm]", id_49_value + "", 0));
            valuesModels.add(new StructuralDesignModel(50, "אורך חופשי של קורה", "Lb", "[cm]", id_50_value + "", 0));
            valuesModels.add(new StructuralDesignModel(51, "תנאי הנשעה בקצה קורה", "", "", "", id_51_position));
            valuesModels.add(new StructuralDesignModel(55, "גובה קורה", "hb", "[cm]", id_55_value + "", 0));
            valuesModels.add(new StructuralDesignModel(56, "רוחב קורה", "bb", "[cm]", id_56_value + "", 0));
            valuesModels.add(new StructuralDesignModel(57, "אורך חופשי של קורה", "Lb", "[cm]", id_57_value + "", 0));
            valuesModels.add(new StructuralDesignModel(58, "תנאי הנשעה בקצה קורה", "", "", "", id_58_position));
            valuesModels.add(new StructuralDesignModel(61, "גובה עמוד", "hb", "[cm]", id_61_value + "", 0));
            valuesModels.add(new StructuralDesignModel(62, "רוחב עמוד", "bc", "[cm]", id_62_value + "", 0));
            valuesModels.add(new StructuralDesignModel(63, "אורך חופשי של עמוד", "Lc", "[cm]", id_63_value + "", 0));
            valuesModels.add(new StructuralDesignModel(67, "גובה קורה", "hb", "[cm]", id_67_value + "", 0));
            valuesModels.add(new StructuralDesignModel(68, "רוחב קורה", "bb", "[cm]", id_68_value + "", 0));
            valuesModels.add(new StructuralDesignModel(69, "אורך חופשי של קורה", "Lb", "[cm]", id_69_value + "", 0));
            valuesModels.add(new StructuralDesignModel(70, "תנאי הנשעה בקצה קורה", "", "", "", id_70_position));
            valuesModels.add(new StructuralDesignModel(74, "גובה קורה", "hb", "[cm]", id_74_value + "", 0));
            valuesModels.add(new StructuralDesignModel(75, "רוחב קורה", "bb", "[cm]", id_75_value + "", 0));
            valuesModels.add(new StructuralDesignModel(76, "אורך חופשי של קורה", "Lb", "[cm]", id_76_value + "", 0));
            valuesModels.add(new StructuralDesignModel(77, "תנאי הנשעה בקצה קורה", "", "", "", id_77_position));
            valuesModels.add(new StructuralDesignModel(80, "גובה עמוד", "hb", "[cm]", id_80_value + "", 0));
            valuesModels.add(new StructuralDesignModel(81, "רוחב עמוד", "bc", "[cm]", id_81_value + "", 0));
            valuesModels.add(new StructuralDesignModel(82, "אורך חופשי של עמוד", "Lc", "[cm]", id_82_value + "", 0));
            valuesModels.add(new StructuralDesignModel(85, "", "", "", "", id_85_position));
            valuesModels.add(new StructuralDesignModel(86, "מצב", "", "", "", id_86_position));
            valuesModels.add(new StructuralDesignModel(88, "גובה עמוד", "hb", "[cm]", id_88_value + "", 0));
            valuesModels.add(new StructuralDesignModel(89, "רוחב עמוד", "bc", "[cm]", id_89_value + "", 0));
            valuesModels.add(new StructuralDesignModel(90, "אורך חופשי של עמוד", "Lc", "[cm]", id_90_value + "", 0));
            valuesModels.add(new StructuralDesignModel(94, "", "", "", "", id_94_position));
            valuesModels.add(new StructuralDesignModel(96, "כוח צירי לתכן בבטון (חיובי = לחיצה)", "Nd", "[KN]", id_96_value + "", 0));
            valuesModels.add(new StructuralDesignModel(97, "כוח גזירה לתכן בבטון", "Vd", "[KN]", id_97_value + "", 0));
            valuesModels.add(new StructuralDesignModel(115, "פסיעה בפועל בין חישוקים גזירה", "Sv", "mm", id_115_value + "", 0));
            valuesModels.add(new StructuralDesignModel(116, "מס ענפים", "n,act", "", "", id_116_position));
            setValuesModelsPositions();
            return valuesModels;
        } else {
            resultPositionsByIds = new ArrayMap<>();
            resultModels = new ArrayList<>();
            resultModels.add(new StructuralDesignModel(5, "גובה פעיל", "d", "[cm]", mathId_5() + "", 0));
            resultModels.add(new StructuralDesignModel(7, "חוזק אופייני של הבטון", "fck", "[Mpa]", id_7_value + "", 0));
            resultModels.add(new StructuralDesignModel(8, "חוזק בטון", "fcd", "[Mpa]", mathId_8(), 0));
            resultModels.add(new StructuralDesignModel(10, "חוזק פלדה", "fsd", "[Mpa]", mathId_10(), 0));
            resultModels.add(new StructuralDesignModel(11, "חוזק מתיחה צירית ממוצעת לשירות בבטון מזויין", "fctm", "[Mpa]", mathId_11(), 0));
            resultModels.add(new StructuralDesignModel(12, "מנת זיון מתוח בחתך בטון מזוין למניעת הרסה פריך(5.4)", "ρ", "-", mathId_12(), 0));
            resultModels.add(new StructuralDesignModel(13, "זיון מינמלי לכפיפה (5.3.6)", "ρ", "-", mathId_13(), 0));
            resultModels.add(new StructuralDesignModel(14, "מומנט תסבולת החתך", "Mcd,max", "[KNm]", mathId_14(), 0));
            resultModels.add(new StructuralDesignModel(15, "בדיקה מומנט תסבולת מקסימלי", "2*Mcd,max>Md", "[KNm]", mathId_15(), 0));
            resultModels.add(new StructuralDesignModel(150, "בדיקת מומנט התכן מול מומנט התסבולת", "Mcd>Md", "-", mathId_150(), 0));
            resultModels.add(new StructuralDesignModel(151, "מומנט תכן", "DMd", "[KNm]", mathId_151(), 0));
            resultModels.add(new StructuralDesignModel(152, "תוספת זיון לחוץ", "As',calc", "[cm²]", mathId_152(), 0));
            resultModels.add(new StructuralDesignModel(16, "שטח חתך זיון מינימלי", "As,min", "[cm²]", mathId_16(), 0));
            resultModels.add(new StructuralDesignModel(17, "יחס איזור לחוץ/מתוח", "ω", "-", mathId_17(), 0));
            resultModels.add(new StructuralDesignModel(18, "גובה אזור לחוץ", "X", "-", mathId_18(), 0));
            resultModels.add(new StructuralDesignModel(19, "זרוע שקול כוחות", "Z", "[cm]", mathId_19(), 0));
            resultModels.add(new StructuralDesignModel(20, "שטח זיון מתוח מחושב", "As_calc", "[cm²]", mathId_20(), 0));
            resultModels.add(new StructuralDesignModel(23, "שטח זיון מתוח בפועל", "As,act", "[cm²]", mathId_23(), 0));
            resultModels.add(new StructuralDesignModel(24, "בדיקת שטח הזיון  המתוח בפועל מול הזיון המחושב", "As,act>As,calc", "-", mathId_24(), 0));
            resultModels.add(new StructuralDesignModel(25, "בדיקת שטח הזיון  המתוח בפועל מול זיון המינימום", "As,act>As,min", "-", mathId_25(), 0));
            resultModels.add(new StructuralDesignModel(26, "בדיקת שטח זיון מתוח  מול מקסימום", "Asact<As,max", "-", mathId_26(), 0));
            resultModels.add(new StructuralDesignModel(28, "רווח בין מוטות מתוחים", "a", "[cm]", mathId_28(), 0));
            resultModels.add(new StructuralDesignModel(29, "בדיקת רווח תקין בין מוטות מתוחים", "a,max=3.5", "[cm]", mathId_29(), 0));
            resultModels.add(new StructuralDesignModel(36, "שטח זיון לחוץ בפועל", "As',act", "[cm²]", mathId_36(), 0));
            resultModels.add(new StructuralDesignModel(37, "בדיקת שטח הזיון הלחוץ פועל  מול הזיון המחושב", "As',act>As',calc", "-", mathId_37(), 0));
            resultModels.add(new StructuralDesignModel(38, "בדיקת שטח הזיון הלחוץ פועל  מול זיון המינימום", "As',act>As,min", "-", mathId_38(), 0));
            resultModels.add(new StructuralDesignModel(39, "בדיקת שטח  זיון  לחוץ מול מקסימום", "As'act<As,max", "-", mathId_39(), 0));
            resultModels.add(new StructuralDesignModel(40, "רווח בין מוטות לחוצים", "a", "[cm]", mathId_40(), 0));
            resultModels.add(new StructuralDesignModel(41, "בדיקת רווח תקין בין מוטות לחוצים", "a,max=3.5", "[cm]", mathId_41(), 0));
            resultModels.add(new StructuralDesignModel(46, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_46(), 0));
            resultModels.add(new StructuralDesignModel(47, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_47(), 0));
            resultModels.add(new StructuralDesignModel(52, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_52(), 0));
            resultModels.add(new StructuralDesignModel(53, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_53(), 0));
            resultModels.add(new StructuralDesignModel(59, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_59(), 0));
            resultModels.add(new StructuralDesignModel(60, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_60(), 0));
            resultModels.add(new StructuralDesignModel(64, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_64(), 0));
            resultModels.add(new StructuralDesignModel(65, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_65(), 0));
            resultModels.add(new StructuralDesignModel(66, "מקדם אלפא", "a1", "", mathId_66(), 0));
            resultModels.add(new StructuralDesignModel(71, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_71(), 0));
            resultModels.add(new StructuralDesignModel(72, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_72(), 0));
            resultModels.add(new StructuralDesignModel(78, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_78(), 0));
            resultModels.add(new StructuralDesignModel(79, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_79(), 0));
            resultModels.add(new StructuralDesignModel(83, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_83(), 0));
            resultModels.add(new StructuralDesignModel(84, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_84(), 0));
            resultModels.add(new StructuralDesignModel(840, "מקדם אלפא", "a1", "", mathId_840(), 0));
            resultModels.add(new StructuralDesignModel(841, "אורך פעיל של עמוד", "Le", "[cm]", mathId_841(), 0));
            resultModels.add(new StructuralDesignModel(87, "מקדם אלפא", "a1", "", mathId_87(), 0));
            resultModels.add(new StructuralDesignModel(91, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_91(), 0));
            resultModels.add(new StructuralDesignModel(92, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_92(), 0));
            resultModels.add(new StructuralDesignModel(95, "מקדם אלפא", "a2", "[cm]", mathId_95(), 0));
            resultModels.add(new StructuralDesignModel(950, "אורך פעיל של עמוד", "Le", "[cm]", mathId_950(), 0));
            resultModels.add(new StructuralDesignModel(98, "שטח חתך", "Ag", "[cm²]", mathId_98(), 0));
            resultModels.add(new StructuralDesignModel(99, "שטח זיון אורכי", "ΣAs", "[cm²]", mathId_99(), 0));
            resultModels.add(new StructuralDesignModel(100, "מנת הזיון האורכית", "ρ", "-", mathId_100(), 0));
            resultModels.add(new StructuralDesignModel(101, "K", "", "", mathId_101(), 0));
            resultModels.add(new StructuralDesignModel(102, "מאמץ בבטון", "σcp", "[Mpa]", mathId_102(), 0));
            resultModels.add(new StructuralDesignModel(103, "תסבולת בטון ללא זיון הגזירה", "VRdc", "[KN]", mathId_103(), 0));
            resultModels.add(new StructuralDesignModel(104, "תסבולת מקסימלית לגיזרה", "VRd,max", "[KN]", mathId_104(), 0));
            resultModels.add(new StructuralDesignModel(107, "בדיקת Vd מול Vrdmax", "", "", mathId_107(), 0));
            resultModels.add(new StructuralDesignModel(108, "בדיקת Vd מול Vrdc max", "", "", mathId_108(), 0));
            resultModels.add(new StructuralDesignModel(109, "מנת זיון המינמלית לגזירה", "ρmin", "", mathId_109(), 0));
            resultModels.add(new StructuralDesignModel(110, "היחס המינימלי בין שטח חתך הזיון לגזירה לבין הפסיעה", "ρmin*b=(Asv/sv)min", "mm", mathId_110(), 0));
            resultModels.add(new StructuralDesignModel(111, "היחס בין שטח חתך הזיון הדרוש המקסמלי לגזירה לבין הפסיעה", "ρmin*b=Asv/sv", "mm", mathId_111(), 0));
            resultModels.add(new StructuralDesignModel(112, "פסיעה מקסימלית בין חישוקים", "Svmax", "mm", mathId_112(), 0));
            resultModels.add(new StructuralDesignModel(113, "פסיעה מקסימלית בין ענפי חישוקים", "Stmax", "mm", mathId_113(), 0));
            resultModels.add(new StructuralDesignModel(114, "מספר ענפים מינימלי", "n,d", "", mathId_114(), 0));
            resultModels.add(new StructuralDesignModel(117, "היחס בין מספר ענפי החישוקים וקוטרם לבין הפסיעה", "(Asv_act)", "", mathId_117(), 0));
            resultModels.add(new StructuralDesignModel(118, "בדיקת כמות מינמלית של ענפים", "n,act>n,d", "-", mathId_118(), 0));
            resultModels.add(new StructuralDesignModel(119, "בדיקת שטח זיון לגזירה בפועל מול הזיון המחושב", "(Asv_act)>Asv,calc", "-", mathId_119(), 0));
            resultModels.add(new StructuralDesignModel(120, "בדיקת שטח זיון לגזירה בפועל מול זיון המינימום", "(Asv_act)>As,min", "-", mathId_120(), 0));
            resultModels.add(new StructuralDesignModel(121, "תסבולת לגיזרה בהתחשבות זיון הגזירה", "VRd,s", "[KN]", mathId_121(), 0));
            resultModels.add(new StructuralDesignModel(122, "בדיקה תסבולת החתך", "", "", mathId_122(), 0));
            setResultModelsPositions();
            return resultModels;
        }
    }

    private String mathId_5() {
        id_5_value = id_2_value - id_3_value;
        Log.d("checkMath", "mathId_5() -> id_5_value == " + id_5_value + "; id_3_value == " + id_3_value + "; id_2_value == " + id_2_value);
        return formatNumberDecimal(id_5_value);
    }

    private String mathId_8() {
        id_8_value = getRelevantValueForId(8, id_6_value);
        Log.d("checkMath", "mathId_8() -> id_8_value == " + id_8_value);
        return formatNumberDecimal(id_8_value);
    }

    private String mathId_10() {
        id_10_value = getRelevantValueForId(10, id_9_value);
        Log.d("checkMath", "mathId_10() -> id_10_value == " + id_10_value + "; id_9_value == " + id_9_value);
        return formatNumberDecimal(id_10_value);
    }

    private String mathId_11() {
        id_11_value = getRelevantValueForId(11, id_6_value);
        Log.d("checkMath", "mathId_11() -> id_11_value == " + id_11_value + "; id_6_value == " + id_6_value);
        return formatNumberDecimal(id_11_value);
    }

    private String mathId_12() {
        id_12_value = getRelevantValueForId(12, id_6_value);
        Log.d("checkMath", "mathId_12() -> id_12_value == " + id_12_value);
        return formatNumberDecimal(id_12_value);
    }

    private String mathId_13() {
        id_13_value = getRelevantValueForId(13, id_9_value);
        Log.d("checkMath", "mathId_13() -> id_13_value == " + id_13_value);
        return formatNumberDecimal(id_13_value);
    }

    private String mathId_14() {
        try {
            id_14_value = 0.32 * id_4_value * id_5_value * id_5_value * id_8_value / 1000;
            Log.d("checkMath", "mathId_14() -> id_14_value == " + id_14_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_14_value) || id_14_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_14_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_14() -> EXCEPTION -> " + e.getMessage());
            id_14_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_15() {
        Log.d("checkMath", "mathId_15() -> id_14_value == " + id_14_value + "; id_1_value == " + id_1_value);
        return id_14_value * 2 > id_1_value ? context.getString(R.string.valid_cut) : context.getString(R.string.not_valid_cut);
    }

    private String mathId_150() {
        Log.d("checkMath", "mathId_150() -> id_14_value == " + id_14_value + "; id_1_value == " + id_1_value);
        return id_14_value > id_1_value ? context.getString(R.string.pressure_not_required) : context.getString(R.string.pressure_required);
    }

    private String mathId_151() {
        try {
            id_151_value = mathId_150().equals(context.getString(R.string.pressure_required)) ? (id_1_value - id_14_value) : Double.NaN;
            Log.d("checkMath", "mathId_151() -> id_151_value == " + id_151_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_151_value) || id_151_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_151_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_151() -> EXCEPTION -> " + e.getMessage());
            id_151_value = Double.NaN;
            return context.getString(R.string.pressure_not_required);
        }
    }


    private String mathId_152() {
        try {
            id_152_value = mathId_150().equals(context.getString(R.string.pressure_required))
                    ? ((id_151_value * 1000 * 1000) / ((id_5_value - id_400_value) * id_10_value * 10)) / 100
                    : 0;
            Log.d("checkMath", "mathId_152() -> id_152_value == " + id_152_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_152_value) || id_152_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_152_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_152() -> EXCEPTION -> " + e.getMessage());
            id_152_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_16() {
        try {
            id_16_value = Math.max(id_13_value * id_5_value * id_4_value, id_12_value * id_5_value * id_4_value);
            Log.d("checkMath", "mathId_16() -> id_16_value == " + id_16_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_16_value) || id_16_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_16_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_16() -> EXCEPTION -> " + e.getMessage());
            id_16_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_17() {
        try {
            firstMathPart = id_4_value * id_5_value * id_5_value * id_8_value;
            if (firstMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            secondMathPart = 1 - Math.pow(1 - ((2 * id_1_value * 1000) / firstMathPart), 0.5);
            id_17_value = secondMathPart < 0.1 ? 0.1 : (Math.min(secondMathPart, 0.4));
            Log.d("checkMath", "mathId_17() -> id_17_value == " + id_17_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_17_value) || id_17_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_17_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_17() -> EXCEPTION -> " + e.getMessage());
            id_17_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_18() {
        try {
            id_18_value = id_17_value * id_5_value;
            Log.d("checkMath", "mathId_18() -> id_18_value == " + id_18_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_18_value) || id_18_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_18_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_18() -> EXCEPTION -> " + e.getMessage());
            id_18_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_19() {
        try {
            id_19_value = Math.min(((1 - (id_17_value / 2)) * id_5_value), (0.95 * id_5_value));
            Log.d("checkMath", "mathId_19() -> id_19_value == " + id_19_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_19_value) || id_19_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_19_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_19() -> EXCEPTION -> " + e.getMessage());
            id_19_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_20() {
        try {
            firstMathPart = id_19_value * id_10_value * 10;
            if (firstMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_20_value = mathId_150().equals(context.getString(R.string.pressure_required))
                    ? ((id_14_value * 1000 * 1000) / firstMathPart) / 100 + id_152_value
                    : ((id_1_value * 1000 * 1000) / firstMathPart) / 100;
            Log.d("checkMath", "mathId_20() -> id_20_value == " + id_20_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_20_value) || id_20_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_20_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_20() -> EXCEPTION -> " + e.getMessage());
            id_20_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_23() {
        try {
            id_23_value = Math.PI * Math.pow(id_22_value, 2) / 4 * id_21_value / 100;
            Log.d("checkMath", "mathId_23() -> id_23_value == " + id_23_value + "; id_22_value == " + id_22_value + "; id_21_value == " + id_21_value);
            if (Double.isNaN(id_23_value) || id_23_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_23_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_23() -> EXCEPTION -> " + e.getMessage());
            id_23_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_24() {
        try {
            Log.d("checkMath", "mathId_24() -> id_23_value == " + id_23_value + "; id_20_value == " + id_20_value);
            if (Double.isNaN(id_20_value) || Double.isNaN(id_23_value))
                throw new NumberFormatException(NaN);
            return id_23_value > id_20_value ? OK : context.getString(R.string.armament_dose_is_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_24() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_25() {
        try {
            Log.d("checkMath", "mathId_25() -> id_23_value == " + id_23_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_23_value) || Double.isNaN(id_16_value))
                throw new NumberFormatException(NaN);
            return id_23_value > id_16_value ? OK : context.getString(R.string.armament_dose_is_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_25() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_26() {
        try {
            Log.d("checkMath", "mathId_26() -> id_23_value == " + id_23_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value);
            if (Double.isNaN(id_23_value) || Double.isNaN(id_5_value))
                throw new NumberFormatException(NaN);
            return id_23_value < 0.04 * id_5_value * id_4_value ? OK : context.getString(R.string.armament_dose_is_too_big);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_26() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_28() {
        try {
            firstMathPart = (id_21_value - 1);
            if (firstMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_28_value = (id_4_value - 2 * id_27_value - 2 * id_270_value / 10 - id_21_value * id_22_value / 10) / firstMathPart;
            Log.d("checkMath", "mathId_28() -> id_28_value == " + id_28_value + "; id_21_value == " + id_21_value + "; id_27_value == " + id_27_value + "; id_270_value == " + id_270_value + "; id_4_value == " + id_4_value + "; id_22_value == " + id_22_value);
            if (Double.isNaN(id_28_value) || id_28_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_28_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_28() -> EXCEPTION -> " + e.getMessage());
            id_28_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_29() {
        try {
            Log.d("checkMath", "mathId_29() -> id_28_value == " + id_28_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_28_value)) throw new NumberFormatException(NaN);
            return id_28_value < 3.5 ? context.getString(R.string.spacing_between_rods_not_proper) : context.getString(R.string.proper_spacing);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_29() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_36() {
        try {
            id_36_value = Math.PI * Math.pow(id_35_value, 2) / 4 * id_34_value / 100;
            Log.d("checkMath", "mathId_36() -> id_36_value == " + id_36_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_36_value) || id_36_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_36_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_36() -> EXCEPTION -> " + e.getMessage());
            id_36_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_37() {
        try {
            Log.d("checkMath", "mathId_37() -> id_36_value == " + id_36_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_36_value) || Double.isNaN(id_152_value))
                throw new NumberFormatException(NaN);
            return id_36_value > id_152_value ? OK : context.getString(R.string.armament_dose_is_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_37() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_38() {
        try {
            Log.d("checkMath", "mathId_38() -> id_36_value == " + id_36_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_36_value) || Double.isNaN(id_16_value))
                throw new NumberFormatException(NaN);
            return id_36_value > id_16_value ? OK : context.getString(R.string.armament_dose_is_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_38() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_39() {
        try {
            Log.d("checkMath", "mathId_39() -> id_36_value == " + id_36_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_36_value) || Double.isNaN(id_5_value))
                throw new NumberFormatException(NaN);
            return id_36_value < 0.04 * id_5_value * id_4_value ? OK : context.getString(R.string.armament_dose_is_too_big);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_39() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_40() {
        try {
            firstMathPart = (id_21_value - 1);
            if (firstMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_40_value = (id_4_value - 2 * id_27_value - 2 * id_270_value / 10 - id_34_value * id_35_value / 10) / firstMathPart;
            Log.d("checkMath", "mathId_40() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_40_value) || id_40_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_40_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_40() -> EXCEPTION -> " + e.getMessage());
            id_40_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_41() {
        try {
            Log.d("checkMath", "mathId_41() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_40_value)) throw new NumberFormatException(NaN);
            return id_40_value < 3.5 ? context.getString(R.string.spacing_between_rods_not_proper) : context.getString(R.string.proper_spacing);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_41() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_46() {
        try {
            id_46_value = 0.7 * id_44_value * Math.pow(id_43_value, 3) / 12;
            Log.d("checkMath", "mathId_46() -> id_46_value == " + id_46_value + "; id_44_value == " + id_44_value + "; id_43_value == " + id_43_value);
            if (Double.isNaN(id_46_value) || id_46_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_46_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_46() -> EXCEPTION -> " + e.getMessage());
            id_46_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_47() {
        try {
            id_47_value = id_46_value / id_45_value;
            Log.d("checkMath", "mathId_47() -> id_47_value == " + id_47_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_47_value) || id_47_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_47_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_47() -> EXCEPTION -> " + e.getMessage());
            id_47_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_52() {
        try {
            id_52_value = 0.35 * id_49_value * Math.pow(id_48_value, 3) / 12;
            Log.d("checkMath", "mathId_52() -> id_52_value == " + id_52_value + "; id_49_value == " + id_49_value + "; id_48_value == " + id_48_value);
            if (Double.isNaN(id_52_value) || id_52_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_52_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_52() -> EXCEPTION -> " + e.getMessage());
            id_52_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_53() {
        try {
            id_53_value = id_42_position == 0 ? getRelevantValueForSSCTypes_position(id_51_position) * id_52_value / id_50_value : 6 * id_52_value / id_50_value;
            Log.d("checkMath", "mathId_53() -> id_53_value == " + id_53_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_53_value) || id_53_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_53_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_53() -> EXCEPTION -> " + e.getMessage());
            id_53_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_59() {
        try {
            id_59_value = 0.35 * id_56_value * Math.pow(id_55_value, 3) / 12;
            Log.d("checkMath", "mathId_59() -> id_59_value == " + id_59_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_59_value) || id_59_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_59_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_59() -> EXCEPTION -> " + e.getMessage());
            id_59_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_60() {
        try {
            id_60_value = id_42_position == 0 ? getRelevantValueForSSCTypes_position(id_58_position) * id_59_value / id_57_value : 6 * id_59_value / id_57_value;
            Log.d("checkMath", "mathId_60() -> id_60_value == " + id_60_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_60_value) || id_60_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_60_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_60() -> EXCEPTION -> " + e.getMessage());
            id_60_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_64() {
        try {
            id_64_value = 0.7 * id_62_value * Math.pow(id_61_value, 3) / 12;
            Log.d("checkMath", "mathId_64() -> id_64_value == " + id_64_value + "; id_62_value == " + id_62_value + "; id_61_value == " + id_61_value);
            if (Double.isNaN(id_64_value) || id_64_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_64_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_64() -> EXCEPTION -> " + e.getMessage());
            id_64_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_65() {
        try {
            id_65_value = id_64_value / id_63_value;
            Log.d("checkMath", "mathId_65() -> id_65_value == " + id_65_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_65_value) || id_65_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_65_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_65() -> EXCEPTION -> " + e.getMessage());
            id_65_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_66() {
        try {
            secondMathPart = id_53_value + id_60_value;
            if (secondMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            firstMathPart = (id_47_value + id_65_value) / secondMathPart;
            id_66_value = firstMathPart <= 0.1 ? 0.1 : firstMathPart > 50 ? Double.NEGATIVE_INFINITY : firstMathPart;
            Log.d("checkMath", "mathId_66() -> id_66_value == " + id_66_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_66_value) || id_66_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            if (id_66_value == Double.NEGATIVE_INFINITY)
                throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_66_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_66() -> EXCEPTION -> " + e.getMessage());
            id_66_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "Ꝏ" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_71() {
        try {
            id_71_value = 0.35 * id_68_value * Math.pow(id_67_value, 3) / 12;
            Log.d("checkMath", "mathId_71() -> id_71_value == " + id_71_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_71_value) || id_71_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_71_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_71() -> EXCEPTION -> " + e.getMessage());
            id_71_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_72() {
        try {
            id_72_value = id_42_position == 0 ? getRelevantValueForSSCTypes_position(id_70_position) * id_71_value / id_69_value : 6 * id_71_value / id_69_value;
            Log.d("checkMath", "mathId_72() -> id_72_value == " + id_72_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_72_value) || id_72_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_72_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_72() -> EXCEPTION -> " + e.getMessage());
            id_72_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_78() {
        try {
            id_78_value = 0.35 * id_75_value * Math.pow(id_74_value, 3) / 12;
            Log.d("checkMath", "mathId_78() -> id_78_value == " + id_78_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_78_value) || id_78_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_78_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_78() -> EXCEPTION -> " + e.getMessage());
            id_78_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_79() {
        try {
            id_79_value = id_42_position == 0 ? getRelevantValueForSSCTypes_position(id_77_position) * id_78_value / id_76_value : 6 * id_78_value / id_76_value;
            Log.d("checkMath", "mathId_79() -> id_79_value == " + id_79_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_79_value) || id_79_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_79_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_79() -> EXCEPTION -> " + e.getMessage());
            id_79_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_83() {
        try {
            id_83_value = 0.7 * id_81_value * Math.pow(id_80_value, 3) / 12;
            Log.d("checkMath", "mathId_83() -> id_83_value == " + id_83_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_83_value) || id_83_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_83_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_83() -> EXCEPTION -> " + e.getMessage());
            id_83_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_84() {
        try {
            id_84_value = id_83_value / id_82_value;
            Log.d("checkMath", "mathId_84() -> id_84_value == " + id_84_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_84_value) || id_84_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_84_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_84() -> EXCEPTION -> " + e.getMessage());
            id_84_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_840() {
        try {
            secondMathPart = id_72_value + id_79_value;
            if (secondMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            firstMathPart = (id_65_value + id_84_value) / secondMathPart;
            id_840_value = firstMathPart <= 0.1 ? 0.1 : firstMathPart > 50 ? Double.NEGATIVE_INFINITY : firstMathPart;
            Log.d("checkMath", "mathId_840() -> id_840_value == " + id_840_value + "; id_72_value == " + id_72_value + "; id_79_value == " + id_79_value + "; id_65_value == " + id_65_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_840_value) || id_840_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            if (id_840_value == Double.NEGATIVE_INFINITY)
                throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_840_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_840() -> EXCEPTION -> " + e.getMessage());
            id_840_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "Ꝏ" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_841() {
        try {
            id_841_value = id_42_position == 0
                    ? 0.5 * id_63_value * Math.pow(((1 + id_66_value / (0.45 + id_66_value)) * (1 + id_840_value / (0.45 + id_840_value))), 0.5)
                    : id_63_value * Math.max(Math.pow((1 + 10 * (id_66_value * id_840_value) / (id_66_value + id_840_value)), 0.5),
                    (1 + (id_66_value / (1 + id_66_value))) * (1 + (id_840_value / (1 + id_840_value))));
            Log.d("checkMath", "mathId_841() -> id_841_value == " + id_841_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_841_value) || id_841_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_841_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_841() -> EXCEPTION -> " + e.getMessage());
            id_841_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_87() {
        try {
            id_87_value = getRelevantValueForConnectionTypes_position(id_86_position);
            Log.d("checkMath", "mathId_87() -> id_87_value == " + id_87_value + "; id_86_position == " + id_86_position);
            if (Double.isNaN(id_87_value)) throw new NumberFormatException(NaN);
            if (id_87_value == Double.NEGATIVE_INFINITY)
                throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_87_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_87() -> EXCEPTION -> " + e.getMessage());
            id_87_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "Ꝏ" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_91() {
        try {
            id_91_value = 0.7 * id_89_value * Math.pow(id_88_value, 3) / 12;
            Log.d("checkMath", "mathId_91() -> id_91_value == " + id_91_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_91_value) || id_91_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_91_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_91() -> EXCEPTION -> " + e.getMessage());
            id_91_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_92() {
        try {
            id_92_value = id_91_value / id_90_value;
            Log.d("checkMath", "mathId_92() -> id_92_value == " + id_92_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_92_value) || id_92_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_92_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_92() -> EXCEPTION -> " + e.getMessage());
            id_92_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_95() {
        try {
            id_95_value = mathId_87().equals("Ꝏ") ? Double.NEGATIVE_INFINITY : getRelevantValueForConnectionTypes_position(id_94_position);
            Log.d("checkMath", "mathId_95() -> id_95_value == " + id_95_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_95_value)) throw new NumberFormatException(NaN);
            if (id_95_value == Double.NEGATIVE_INFINITY)
                throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_95_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_95() -> EXCEPTION -> " + e.getMessage());
            id_95_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "ריתום מלא" : context.getString(R.string.not_valid_cut);
        }
    }


    private String mathId_950() {
        try {
            id_950_value = mathId_87().equals("Ꝏ")
                    ? 2 * id_90_value
                    : id_85_position == 0
                    ? 0.5 * id_90_value * Math.pow(((1 + id_87_value / (0.45 + id_87_value)) * (1 + id_95_value / (0.45 + id_95_value))), 0.5)
                    : id_90_value * Math.max(Math.min(Math.pow((1 + 10 * (id_87_value * id_95_value) / (id_87_value + id_95_value)), 0.5), 3.5),
                    (1 + (id_87_value / (1 + id_87_value))) * (1 + (id_95_value / (1 + id_95_value))));
            Log.d("checkMath", "mathId_950() -> id_950_value == " + id_950_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_950_value) || id_950_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_950_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_950() -> EXCEPTION -> " + e.getMessage());
            id_950_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_98() {
        try {
            id_98_value = id_2_value * id_4_value;
            Log.d("checkMath", "mathId_98() -> id_98_value == " + id_98_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_98_value) || id_98_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_98_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_98() -> EXCEPTION -> " + e.getMessage());
            id_98_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_99() {
        try {
            mathId_23();
            id_99_value = id_23_value;
            Log.d("checkMath", "mathId_99() -> id_99_value == " + id_99_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_99_value) || id_99_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_99_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_99() -> EXCEPTION -> " + e.getMessage());
            id_99_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_100() {
        try {
            id_100_value = id_99_value / id_98_value;
            Log.d("checkMath", "mathId_100() -> id_100_value == " + id_100_value + "; id_99_value == " + id_99_value + "; id_98_value == " + id_98_value);
            if (Double.isNaN(id_100_value) || id_100_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_100_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_100() -> EXCEPTION -> " + e.getMessage());
            id_100_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_101() {
        try {
            if (id_5_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_101_value = (1 + Math.pow((200 / (10 * id_5_value)), 0.5)) > 2 ? 2 : (1 + Math.pow((200 / (10 * id_5_value)), 0.5));
            Log.d("checkMath", "mathId_101() -> id_101_value == " + id_101_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_101_value) || id_101_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_101_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_101() -> EXCEPTION -> " + e.getMessage());
            id_101_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_102() {
        try {
            if (id_98_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_102_value = Math.min(id_96_value * 10 / id_98_value, 0.2 * id_10_value);
            Log.d("checkMath", "mathId_102() -> id_102_value == " + id_102_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_102_value) || id_102_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_102_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_102() -> EXCEPTION -> " + e.getMessage());
            id_102_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_103() {
        try {
            id_103_value = Math.max(((0.12 * id_101_value * ((Math.pow((100 * id_100_value * 0.7 * id_7_value), (1.0 / 3.0)))) + (0.15 * id_102_value)) * (id_4_value * id_5_value * 100)),
                    (0.035 * id_101_value * ((Math.pow((0.7 * id_7_value), 0.5))) + (0.15 * id_102_value)) * (id_4_value * id_5_value * 100)) / 1000;
            Log.d("checkMath", "mathId_103() -> id_103_value == " + id_103_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_103_value) || id_103_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_103_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_103() -> EXCEPTION -> " + e.getMessage());
            id_103_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_104() {
        try {
            id_104_value = 0.6 * (1 - (0.7 * id_7_value / 250)) * id_8_value * id_4_value * 0.9 * id_5_value * 0.5 / 10;
            Log.d("checkMath", "mathId_104() -> id_104_value == " + id_104_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_104_value) || id_104_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_104_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_104() -> EXCEPTION -> " + e.getMessage());
            id_104_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_107() {
        try {
            Log.d("checkMath", "mathId_107() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_104_value)) throw new NumberFormatException(NaN);
            return id_97_value < id_104_value ? context.getString(R.string.cut_is_valid_can_be_planned_for_cutting) : context.getString(R.string.concrete_cut_is_not_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_107() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_108() {
        try {
            Log.d("checkMath", "mathId_108() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_103_value)) throw new NumberFormatException(NaN);
            return id_97_value < id_103_value ? context.getString(R.string.cut_is_valid_can_be_planned_for_cutting) : context.getString(R.string.concrete_cut_is_not_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_107() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_109() {
        try {
            id_109_value = getRelevantValueForId(109, id_6_value);
            Log.d("checkMath", "mathId_109() -> id_109_value == " + id_109_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_109_value) || id_109_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_109_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_109() -> EXCEPTION -> " + e.getMessage());
            id_109_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_110() {
        try {
            id_110_value = id_109_value * id_4_value / 10;
            Log.d("checkMath", "mathId_110() -> id_110_value == " + id_110_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_110_value) || id_110_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_110_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_110() -> EXCEPTION -> " + e.getMessage());
            id_110_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_111() {
        try {
            secondMathPart = 0.9 * id_10_value * id_5_value;
            if (secondMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_111_value = Math.max((id_97_value / secondMathPart), id_110_value);
            Log.d("checkMath", "mathId_111() -> id_111_value == " + id_111_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_111_value) || id_111_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_111_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_111() -> EXCEPTION -> " + e.getMessage());
            id_111_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_112() {
        try {
            id_112_value = Math.min(0.75 * id_5_value * 10, 300);
            Log.d("checkMath", "mathId_112() -> id_112_value == " + id_112_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_112_value) || id_112_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_112_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_112() -> EXCEPTION -> " + e.getMessage());
            id_112_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_113() {
        try {
            id_113_value = Math.min(0.75 * id_5_value * 10, 400);
            Log.d("checkMath", "mathId_113() -> id_113_value == " + id_113_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_113_value) || id_113_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_113_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_113() -> EXCEPTION -> " + e.getMessage());
            id_113_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_114() {
        try {
            if (id_113_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_114_value = (id_4_value * 10 / id_113_value) + 1;
            id_114_value = formatNumberDecimal(id_114_value, RoundingMode.UP, "#");
            Log.d("checkMath", "mathId_114() -> id_114_value == " + id_114_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_114_value) || id_114_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return id_114_value + "";
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_114() -> EXCEPTION -> " + e.getMessage());
            id_114_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_117() {
        try {
            if (id_115_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_117_value = ((((Math.PI * Math.pow(id_270_value, 2)) / 4) * id_116_value)) / id_115_value;
            Log.d("checkMath", "mathId_117() -> id_117_value == " + id_117_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_117_value) || id_117_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_117_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_117() -> EXCEPTION -> " + e.getMessage());
            id_117_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_118() {
        try {
            Log.d("checkMath", "mathId_118() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_114_value)) throw new NumberFormatException(NaN);
            return id_116_value > id_114_value ? OK : context.getString(R.string.amount_of_branches_is_proper);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_118() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_119() {
        try {
            Log.d("checkMath", "mathId_119() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_104_value)) throw new NumberFormatException(NaN);
            return id_117_value / id_115_value > id_110_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_119() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_120() {
        try {
            Log.d("checkMath", "mathId_119() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_104_value)) throw new NumberFormatException(NaN);
            return id_117_value / id_115_value > id_109_value ? OK : context.getString(R.string.armament_dose_is_not_enough);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_119() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_121() {
        try {
            id_121_value = id_117_value * 0.9 * id_5_value * 10 * id_10_value / 1000;
            Log.d("checkMath", "mathId_105() -> id_121_value == " + id_121_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_121_value) || id_121_value == Double.POSITIVE_INFINITY)
                throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_121_value);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_105() -> EXCEPTION -> " + e.getMessage());
            id_121_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_122() {
        try {
            Log.d("checkMath", "mathId_41() -> id_40_value == " + id_40_value + "; id_4_value == " + id_4_value + "; id_5_value == " + id_5_value + "; id_8_value == " + id_8_value);
            if (Double.isNaN(id_40_value)) throw new NumberFormatException(NaN);
            return id_97_value < id_121_value ? context.getString(R.string.armament_cut_dose_is_valid) : context.getString(R.string.armament_cut_dose_is_not_valid);
        } catch (NumberFormatException e) {
            Log.d("checkMath", "mathId_41() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("numberChangedListener", "CanopyLengthsCategory{} -> valueItemNumber == " + valueItemNumber + "; valueItemId == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);
        switch (valueItemId) {
            case 1:
                id_1_value = valueItemNumber;
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(150, mathId_150(), "");
                setRelevantResultItem_value(151, mathId_151(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(17, mathId_117(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                break;
            case 2:
                id_2_value = valueItemNumber;
                setRelevantResultItem_value(5, mathId_5(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(150, mathId_150(), "");
                setRelevantResultItem_value(151, mathId_151(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 3:
                id_3_value = valueItemNumber;
                setRelevantResultItem_value(5, mathId_5(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(150, mathId_150(), "");
                setRelevantResultItem_value(151, mathId_151(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(112, mathId_112(), "");
                setRelevantResultItem_value(113, mathId_113(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 4:
                id_4_value = valueItemNumber;
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(150, mathId_150(), "");
                setRelevantResultItem_value(151, mathId_151(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(114, mathId_114(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                break;
            case 400:
                id_400_value = valueItemNumber;
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                break;
            case 6:
                id_6_position = spinnerPosition;
                id_6_value = getConcreteTypeDoubleValues()[spinnerPosition];
                id_7_value = id_6_value;
                setRelevantResultItem_value(7, id_7_value + "", "");
                setRelevantResultItem_value(8, mathId_8(), "");
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(14, mathId_14(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(150, mathId_150(), "");
                setRelevantResultItem_value(151, mathId_151(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                break;
            case 9:
                id_9_position = spinnerPosition;
                id_9_value = getFrom_400_to_500_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(10, mathId_10(), "");
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(13, mathId_13(), "");
                setRelevantResultItem_value(152, mathId_152(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(109, mathId_109(), "");
                setRelevantResultItem_value(110, mathId_110(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 21:
                id_21_position = spinnerPosition;
                id_21_value = getFrom_2_to_4_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(23, mathId_23(), "");
                id_99_value = id_23_value;
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                break;
            case 22:
                id_22_position = spinnerPosition;
                id_22_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                setRelevantResultItem_value(23, mathId_23(), "");
                id_99_value = id_23_value;
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(26, mathId_26(), "");
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                break;
            case 27:
                id_27_value = valueItemNumber;
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                break;
            case 270:
                id_270_position = spinnerPosition;
                id_270_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                setRelevantResultItem_value(28, mathId_28(), "");
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(117, mathId_117(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 34:
            case 35:
                switch (valueItemId) {
                    case 34:
                        id_34_position = spinnerPosition;
                        id_34_value = getFrom_2_to_4_doubleValues()[spinnerPosition];
                        break;
                    case 35:
                        id_35_position = spinnerPosition;
                        id_35_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                        break;
                }
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(37, mathId_37(), "");
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(40, mathId_40(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                break;
            case 42:
                id_42_position = spinnerPosition;
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(72, mathId_72(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 43:
            case 44:
                switch (valueItemId) {
                    case 43:
                        id_43_value = valueItemNumber;
                        break;
                    case 44:
                        id_44_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 45:
                id_45_value = valueItemNumber;
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 48:
            case 49:
                switch (valueItemId) {
                    case 48:
                        id_48_value = valueItemNumber;
                        break;
                    case 49:
                        id_49_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 50:
            case 51:
                switch (valueItemId) {
                    case 50:
                        id_50_value = valueItemNumber;
                        break;
                    case 51:
                        id_51_position = spinnerPosition;
                        break;
                }
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 55:
            case 56:
                switch (valueItemId) {
                    case 55:
                        id_55_value = valueItemNumber;
                        break;
                    case 56:
                        id_56_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 57:
            case 58:
                switch (valueItemId) {
                    case 57:
                        id_57_value = valueItemNumber;
                        break;
                    case 58:
                        id_58_position = spinnerPosition;
                        break;
                }
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 61:
            case 62:
                switch (valueItemId) {
                    case 61:
                        id_61_value = valueItemNumber;
                        break;
                    case 62:
                        id_62_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 63:
                id_63_value = valueItemNumber;
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 67:
            case 68:
                switch (valueItemId) {
                    case 67:
                        id_67_value = valueItemNumber;
                        break;
                    case 68:
                        id_68_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(71, mathId_71(), "");
                setRelevantResultItem_value(72, mathId_72(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 69:
            case 70:
                switch (valueItemId) {
                    case 69:
                        id_69_value = valueItemNumber;
                        break;
                    case 70:
                        id_70_position = spinnerPosition;
                        break;
                }
                setRelevantResultItem_value(72, mathId_72(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 74:
            case 75:
                switch (valueItemId) {
                    case 74:
                        id_74_value = valueItemNumber;
                        break;
                    case 75:
                        id_75_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(78, mathId_78(), "");
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 76:
            case 77:
                switch (valueItemId) {
                    case 76:
                        id_76_value = valueItemNumber;
                        break;
                    case 77:
                        id_77_position = spinnerPosition;
                        break;
                }
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 80:
            case 81:
                switch (valueItemId) {
                    case 80:
                        id_80_value = valueItemNumber;
                        break;
                    case 81:
                        id_81_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(84, mathId_84(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 82:
                id_82_value = valueItemNumber;
                setRelevantResultItem_value(84, mathId_84(), "");
                setRelevantResultItem_value(840, mathId_840(), "");
                setRelevantResultItem_value(841, mathId_841(), "");
                break;
            case 85:
                id_85_position = spinnerPosition;
                setRelevantResultItem_value(950, mathId_950(), "");
                break;
            case 86:
                id_86_position = spinnerPosition;
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(95, mathId_95(), "");
                setRelevantResultItem_value(950, mathId_950(), "");
                break;
            case 88:
            case 89:
                switch (valueItemId) {
                    case 88:
                        id_88_value = valueItemNumber;
                        break;
                    case 89:
                        id_89_value = valueItemNumber;
                        break;
                }
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(92, mathId_92(), "");
                break;
            case 90:
                id_90_value = valueItemNumber;
                setRelevantResultItem_value(92, mathId_92(), "");
                setRelevantResultItem_value(950, mathId_950(), "");
                break;
            case 94:
                id_94_position = spinnerPosition;
                setRelevantResultItem_value(95, mathId_95(), "");
                setRelevantResultItem_value(950, mathId_950(), "");
                break;
            case 96:
                id_96_value = valueItemNumber;
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                break;
            case 97:
                id_97_value = valueItemNumber;
                setRelevantResultItem_value(107, mathId_107(), "");
                setRelevantResultItem_value(108, mathId_108(), "");
                setRelevantResultItem_value(111, mathId_111(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 115:
                id_115_value = valueItemNumber;
                setRelevantResultItem_value(117, mathId_117(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;
            case 116:
                id_116_position = spinnerPosition;
                id_116_value = Double.parseDouble(getFrom_2_to_10_stringValues()[spinnerPosition]);
                setRelevantResultItem_value(117, mathId_117(), "");
                setRelevantResultItem_value(118, mathId_118(), "");
                setRelevantResultItem_value(119, mathId_119(), "");
                setRelevantResultItem_value(120, mathId_120(), "");
                setRelevantResultItem_value(121, mathId_121(), "");
                setRelevantResultItem_value(122, mathId_122(), "");
                break;

        }
    }

    public int getRelevantValueForSSCTypes_position(int position) {
        switch (position) {
            case 1:
                return 4;
            case 2:
                return 2;
            case 0:
            default:
                return 3;
        }
    }

    public double getRelevantValueForConnectionTypes_position(int position) {
        switch (position) {
            case 1:
                return 10;
            case 2:
                return Double.NEGATIVE_INFINITY;
            case 0:
            default:
                return 0.1;
        }
    }

    public double getRelevantValueForId(int id, double compareValue) {
        int relevantIdIntValue;
        Log.d("checkFormatNumber", "id == " + id + "; compareValue == " + compareValue);
        relevantIdIntValue = convertDoubleToInt(compareValue);
        switch (id) {
            case 8:
                switch (relevantIdIntValue) {
                    case 20:
                        return 8.7;
                    case 30:
                        return 13;
                    case 40:
                        return 17.4;
                    case 50:
                        return 21.7;
                    case 60:
                        return 26;
                    default:
                        return 0;
                }
            case 10:
                switch (relevantIdIntValue) {
                    case 400:
                        return 350;
                    case 500:
                        return 435;
                    default:
                        return 0;
                }
            case 85:
            case 11:
                switch (relevantIdIntValue) {
                    case 20:
                        return 1.7;
                    case 30:
                        return 2.3;
                    case 40:
                        return 2.8;
                    case 50:
                        return 3.2;
                    case 60:
                        return 3.6;
                    default:
                        return 0;
                }
            case 12:
                if (id_9_value == 400) {
                    switch (relevantIdIntValue) {
                        case 20:
                            return 0.0012;
                        case 30:
                            return 0.0016;
                        case 40:
                            return 0.002;
                        case 50:
                            return 0.0022;
                        case 60:
                            return 0.0025;
                        default:
                            return 0;
                    }
                } else {
                    switch (relevantIdIntValue) {
                        case 20:
                            return 0.001;
                        case 30:
                            return 0.0013;
                        case 40:
                            return 0.0016;
                        case 50:
                            return 0.0018;
                        case 60:
                            return 0.002;
                        default:
                            return 0;
                    }
                }
            case 13:
                switch (relevantIdIntValue) {
                    case 400:
                        return 0.0015;
                    case 500:
                        return 0.0013;
                    default:
                        return 0;
                }
            case 109:
                if (id_9_value == 400) {
                    switch (relevantIdIntValue) {
                        case 20:
                        case 30:
                            return 0.001;
                        case 40:
                            return 0.0013;
                        case 50:
                            return 0.0015;
                        case 60:
                            return 0.0016;
                        default:
                            return 0;
                    }
                } else {
                    switch (relevantIdIntValue) {
                        case 20:
                        case 30:
                        case 40:
                        case 50:
                            return 0.001;
                        case 60:
                            return 0.0013;
                        default:
                            return 0;
                    }
                }
            default:
                return 0;
        }
    }
}

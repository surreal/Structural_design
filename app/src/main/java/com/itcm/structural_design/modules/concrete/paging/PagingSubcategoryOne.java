package com.itcm.structural_design.modules.concrete.paging;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class PagingSubcategoryOne extends PagingCategory {

    public PagingSubcategoryOne(){
        setValues();
        setAllAdapters();
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

    private void resetValues() {
        id_2_value = 1; id_3_value = 1; id_4_value = 1; id_7_value = 1; id_8_value = 1; id_9_value = 1; id_14_value = 1; id_15_value = 1; id_16_value = 1;
        id_20_value = 1; id_22_value = 1;id_23_value = 1; id_27_value = 1; id_28_value = 1; id_29_value = 1; id_34_value = 1; id_35_value = 1; id_36_value = 1;
        id_40_value = 1; id_41_value = 1;id_42_value = 1; id_45_value = 1; id_47_value = 30; id_48_value = 30; id_50_value = 400; id_52_value = 1; id_53_value = 1;
        id_54_value = 1; id_58_value = 1;id_60_value = 1; id_61_value = 1; id_62_value = 1;id_64_value = 1; id_65_value = 1; id_66_value = 8; id_69_value = 1;
        id_70_value = 30; id_71_value = 30; id_73_value = 1; id_74_value = 1; id_75_value = 1;id_76_value = 1; id_77_value = 1; id_78_value = 400; id_79_value = 350;
        id_1_position = 0;id_17_position = 0; id_30_position = 0; id_37_position = 0; id_47_position = 1; id_50_position = 0; id_66_position = 0; id_70_position = 1;
        id_78_position = 0;
    }
//    private void resetValues() {
//        id_2_value = 10; id_3_value = 20; id_4_value = 30; id_7_value = 40; id_8_value = 50; id_9_value = 60; id_14_value = 70; id_15_value = 80; id_16_value = 90;
//        id_20_value = 10; id_22_value = 20;id_23_value = 30; id_27_value = 40; id_28_value = 50; id_29_value = 60; id_34_value = 70; id_35_value = 80; id_36_value = 90;
//        id_40_value = 10; id_41_value = 20;id_42_value = 30; id_45_value = 40; id_47_value = 20; id_48_value = 20; id_50_value = 500; id_51_value = 435; id_52_value = 50;
//        id_53_value = 60; id_54_value = 70; id_58_value = 80; id_60_value = 90; id_61_value = 10; id_62_value = 20; id_64_value = 30; id_65_value = 40;
//        id_66_value = 10; id_69_value = 10; id_70_value = 50; id_71_value = 50; id_73_value = 40;id_74_value = 20; id_75_value = 5; id_76_value = 30;
//        id_77_value = 10;  id_78_value = 500; id_79_value = 435;
//        id_1_position = 1; id_17_position = 2; id_30_position = 2; id_37_position = 2; id_47_position = 3;id_50_position = 1; id_66_position = 1;
//        id_70_position = 3; id_78_position = 1;
//    }

    private void insertToDB() {
        Log.d("checkInsertUpdate", "insertToDB() -> currentUserEmailGlobal == " + currentUserEmailGlobal);
        sqLiteDatabase.execSQL(sqlHelper.insertPagingCategoryOne_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId, id_1_position, id_2_value,
                id_3_value, id_4_value, id_7_value, id_8_value, id_9_value, id_10_position, id_14_value, id_15_value, id_16_value, id_17_position, id_20_value,
                id_22_value, id_23_value, id_27_value, id_28_value, id_29_value, id_30_position, id_34_value, id_35_value, id_36_value, id_37_position,
                id_40_value, id_41_value, id_42_value, id_45_value, id_47_value, id_50_value, id_52_value, id_53_value, id_54_value, id_58_value, id_60_value,
                id_61_value, id_62_value, id_64_value, id_65_value, id_66_value, id_69_value, id_70_value, id_73_value, id_74_value, id_75_value, id_76_value,
                id_77_value, id_78_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updatePaging_SQL(savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId, id_1_position, id_2_value,
                id_3_value, id_4_value, id_7_value, id_8_value, id_9_value, id_10_position, id_14_value, id_15_value, id_16_value, id_17_position, id_20_value,
                id_22_value, id_23_value, id_27_value, id_28_value, id_29_value, id_30_position, id_34_value, id_35_value, id_36_value, id_37_position, id_40_value,
                id_41_value, id_42_value, id_45_value, id_47_value, id_50_value, id_52_value, id_53_value, id_54_value, id_58_value, id_60_value, id_61_value,
                id_62_value, id_64_value, id_65_value, id_66_value, id_69_value, id_70_value, id_73_value, id_74_value, id_75_value, id_76_value, id_77_value,
                id_78_value));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    private void setValues() {
        cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
        if (cursor.moveToFirst()) {
            id_1_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_1_POSITION);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_4);
            id_7_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_7);
            id_8_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_8);
            id_9_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_9);
            id_10_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_10_POSITION);
            id_14_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_14);
            id_15_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_15);
            id_16_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_16);
            id_17_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_17_POSITION);
            id_20_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_20);
            id_22_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_22);
            id_23_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_23);
            id_27_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_27);
            id_28_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_28);
            id_29_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_29);
            id_30_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_30_POSITION);
            id_34_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_34);
            id_35_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_35);
            id_36_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_36);
            id_37_position = sqlLocal.getRelevantIntValue(cursor, null, DBModel.COLUMN_ID_37_POSITION);
            id_40_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_40);
            id_41_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_41);
            id_42_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_42);
            id_45_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_45);
            id_47_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_47);
            id_47_position = getPositionByValue(getConcreteTypeDoubleValues(), id_47_value);
            id_50_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_50);
            id_50_position = getPositionByValue(getFrom_400_to_500_stringValues(), id_50_value);
            id_52_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_52);
            id_53_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_53);
            id_54_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_54);
            id_58_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_58);
            id_60_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_60);
            id_61_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_61);
            id_62_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_62);
            id_64_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_64);
            id_65_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_65);
            id_66_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_66);
            id_66_position = getPositionByValue(getFrom_8_to_10_stringValues(), id_66_value);
            id_69_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_69);
            id_70_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_70);
            id_70_position = getPositionByValue(getConcreteTypeDoubleValues(), id_70_value);
            id_73_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_73);
            id_74_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_74);
            id_75_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_75);
            id_76_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_76);
            id_77_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_77);
            id_78_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_78);
            id_78_position = getPositionByValue(getFrom_400_to_500_stringValues(), id_78_value);
        } else { resetValues(); }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(1, id_1_position);
        spinnerPositionsArray.put(17, id_17_position);
        spinnerPositionsArray.put(30, id_30_position);
        spinnerPositionsArray.put(37, id_37_position);
        spinnerPositionsArray.put(47, id_47_position);
        spinnerPositionsArray.put(50, id_50_position);
        spinnerPositionsArray.put(66, id_66_position);
        spinnerPositionsArray.put(70, id_70_position);
        spinnerPositionsArray.put(78, id_78_position);
    }

    private void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

    public void tonOrKnBtnClicked() {
        setRelevantResultItem_value(86, mathId_86(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(87, mathId_87(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(89, mathId_89(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(90, mathId_90(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(91, mathId_91(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(98, mathId_98(), getRelevantSecondMeasuringUnit(1));
        setRelevantValueItemMeasuringUnit(45, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(60, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(61, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(76, getRelevantSecondMeasuringUnit(1));
        setRelevantValueItemMeasuringUnit(77, getRelevantSecondMeasuringUnit(0));
    }


    public ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels){
            valuesPositionsByIds = new ArrayMap<>();
            valuesModels = new ArrayList<>();
            valuesModels.add(new StructuralDesignModel(1, "", "", "", "", id_1_position));
            valuesModels.add(new StructuralDesignModel(2, "גובה עמוד", "hb", "[сm]", id_2_value+"", 0));
            valuesModels.add(new StructuralDesignModel(3, "רוחב עמוד", "bc", "[сm]", id_3_value+"", 0));
            valuesModels.add(new StructuralDesignModel(4, "אורך חופשי של עמוד", "bc", "[сm]", id_4_value+"", 0));
            valuesModels.add(new StructuralDesignModel(7, "גובה קורה", "hb", "[сm]", id_7_value+"", 0));
            valuesModels.add(new StructuralDesignModel(8, "רוחב קורה", "bb", "[сm]", id_8_value+"", 0));
            valuesModels.add(new StructuralDesignModel(9, "אורך חופשי של קורה", "Lb", "[сm]", id_9_value+"", 0));
            valuesModels.add(new StructuralDesignModel(14, "גובה קורה", "hb", "[сm]", id_14_value+"", 0));
            valuesModels.add(new StructuralDesignModel(15, "רוחב קורה", "bb", "[сm]", id_15_value+"", 0));
            valuesModels.add(new StructuralDesignModel(16, "אורך חופשי של קורה", "Lb", "[сm]", id_16_value+"", 0));
            valuesModels.add(new StructuralDesignModel(17, "תנאי הנשעה בקצה קורה", "", "", "", id_17_position));
            valuesModels.add(new StructuralDesignModel(20, "גובה עמוד", "hb", "[сm]", id_20_value+"", 0));
            valuesModels.add(new StructuralDesignModel(22, "רוחב עמוד", "bc", "[сm]", id_22_value+"", 0));
            valuesModels.add(new StructuralDesignModel(23, "אורך חופשי של עמוד", "Lc", "[сm]", id_23_value+"", 0));
            valuesModels.add(new StructuralDesignModel(27, "אורך חופשי של עמוד", "hb", "[сm]", id_27_value+"", 0));
            valuesModels.add(new StructuralDesignModel(28, "רוחב קורה", "bb", "[сm]", id_28_value+"", 0));
            valuesModels.add(new StructuralDesignModel(29, "אורך חופשי של קורה", "Lb", "[сm]", id_29_value+"", 0));
            valuesModels.add(new StructuralDesignModel(30, "תנאי הנשעה בקצה קורה", "", "", "", id_30_position));
            valuesModels.add(new StructuralDesignModel(34, "גובה קורה", "hb", "[сm]", id_34_value+"", 0));
            valuesModels.add(new StructuralDesignModel(35, "רוחב קורה", "bb", "[сm]", id_35_value+"", 0));
            valuesModels.add(new StructuralDesignModel(36, "אורך חופשי של קורה", "Lb", "[сm]", id_36_value+"", 0));
            valuesModels.add(new StructuralDesignModel(37, "תנאי הנשעה בקצה קורה", "", "", "", id_37_position));
            valuesModels.add(new StructuralDesignModel(40, "גובה עמוד", "hb", "[сm]", id_40_value+"", 0));
            valuesModels.add(new StructuralDesignModel(41, "רוחב עמוד", "bc", "[сm]", id_41_value+"", 0));
            valuesModels.add(new StructuralDesignModel(42, "אורך חופשי של עמוד", "Lc", "[сm]", id_42_value+"", 0));
            valuesModels.add(new StructuralDesignModel(45, "עומס תכן", "Nd", "[KN]", id_45_value+"", 0));
            valuesModels.add(new StructuralDesignModel(47, "סוג בטון", "", "", "", id_47_position));
            valuesModels.add(new StructuralDesignModel(50, "חוזק אופייני של הפלדה", "fsk", "[Mpa]", "", id_50_position));
            valuesModels.add(new StructuralDesignModel(52, "A", "מקדם השפעת זחילה", "", id_52_value+"", 0));
            valuesModels.add(new StructuralDesignModel(53, "B", "מקדם ניצול החתך", "", id_53_value+"", 0));
            valuesModels.add(new StructuralDesignModel(54, "C", "מקדם השפעת  מומנטי קצה", "", id_54_value+"", 0));
            valuesModels.add(new StructuralDesignModel(58, "תמירות מקסמלית", "λ,max", "", id_58_value+"", 0));
            valuesModels.add(new StructuralDesignModel(60, "חישוב אקסצנטריות הנובעת מחישובים סטטיים", "Nd", "[KN]", id_60_value+"", 0));
            valuesModels.add(new StructuralDesignModel(61, "חישוב אקסצנטריות הנובעת מחישובים סטטיים", "Md", "[KN]", id_61_value+"", 0));
            valuesModels.add(new StructuralDesignModel(62, "חישוב אקסצנטריות הנובעת מחישובים סטטיים", "Md", "[mm]", id_62_value+"", 0));
            valuesModels.add(new StructuralDesignModel(64, "מקדם הקטנת עקמומיות", "Kj", "", id_64_value+"", 0));
            valuesModels.add(new StructuralDesignModel(65, "מקדם הקטנה עקמומיות", "Kr", "", id_65_value+"", 0));
            valuesModels.add(new StructuralDesignModel(66, "מקדם אינטגרציה", "\"חתך קבוע  ומומנט משתנה  לאורך הרכיב C= 8  \n" + "חתך קבוע ומומנט קבוע לאורך הרכיב C=10\"\n", "", "", id_66_position));
            valuesModels.add(new StructuralDesignModel(69, "פסיעת ברזל אופקי לחוץ", "@", "[cm]", id_69_value+"", 0));
            valuesModels.add(new StructuralDesignModel(70, "", "סוג בטון", "ב-", "", id_70_position));
            valuesModels.add(new StructuralDesignModel(73, "גובה חתך", "h", "[cm]", id_73_value+"", 0));
            valuesModels.add(new StructuralDesignModel(74, "רוחב חתך", "b", "[cm]", id_74_value+"", 0));
            valuesModels.add(new StructuralDesignModel(75, "עובי כיסוי", "ds", "[cm]", id_75_value+"", 0));
            valuesModels.add(new StructuralDesignModel(76, "מומנט התכן", "Md", "[KNm]", id_76_value+"", 0));
            valuesModels.add(new StructuralDesignModel(77, "כוח צירי", "Nd", "[kn]", id_77_value+"", 0));
            valuesModels.add(new StructuralDesignModel(78, "חוזק תכן פלדה", "fsk", "[Mpa]", "", id_78_position));
            setValuesModelsPositions();
            return valuesModels;
        } else {
            resultPositionsByIds = new ArrayMap<>();
            resultModels = new ArrayList<>();
            resultModels.add(new StructuralDesignModel(5, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_5(), 0));
            resultModels.add(new StructuralDesignModel(6, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_6(), 0));
            resultModels.add(new StructuralDesignModel(11, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_11(), 0));
            resultModels.add(new StructuralDesignModel(12, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_12(), 0));
            resultModels.add(new StructuralDesignModel(18, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_18(), 0));
            resultModels.add(new StructuralDesignModel(19, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_19(), 0));
            resultModels.add(new StructuralDesignModel(21, "", "", "", mathId_21(), 0));
            resultModels.add(new StructuralDesignModel(24, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_24(), 0));
            resultModels.add(new StructuralDesignModel(25, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_25(), 0));
            resultModels.add(new StructuralDesignModel(250, "מקדם אלפא", "a1", "", mathId_250(), 0));
            resultModels.add(new StructuralDesignModel(31, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_31(), 0));
            resultModels.add(new StructuralDesignModel(32, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_32(), 0));
            resultModels.add(new StructuralDesignModel(38, "מומנט אירציה בהתחשבות בסדיקה", "Icr,b", "[сm^4]", mathId_38(), 0));
            resultModels.add(new StructuralDesignModel(39, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_39(), 0));
            resultModels.add(new StructuralDesignModel(43, "מומנט אירציה בהתחשבות בסדיקה", "Icr,c", "[сm^4]", mathId_43(), 0));
            resultModels.add(new StructuralDesignModel(44, "קשיחות לכפיפה לפי תנאי ההשענה", "Kb", "", mathId_44(), 0));
            resultModels.add(new StructuralDesignModel(440, "מקדם אלפא", "a2", "", mathId_440(), 0));
            resultModels.add(new StructuralDesignModel(441, "אורך פעיל של עמוד", "Le", "[сm]", mathId_441(), 0));
            resultModels.add(new StructuralDesignModel(46, "עומס תכן", "Ag", "[сm^2]", mathId_46(), 0));
            resultModels.add(new StructuralDesignModel(48, "חוזק אופייני של הבטון", "fck", "[Mpa]", id_48_value+"", 0));
            resultModels.add(new StructuralDesignModel(49, "חוזק בטון", "fcd", "[Mpa]", mathId_49(), 0));
            resultModels.add(new StructuralDesignModel(51, "חוזק פלדה", "fsd", "[Mpa]", mathId_51(), 0));
            resultModels.add(new StructuralDesignModel(55, "תמירות מינמלית", "λ,min", "", mathId_55(), 0));
            resultModels.add(new StructuralDesignModel(56, "רדיוס אינרציה של העמוד", "i", "", mathId_56(), 0));
            resultModels.add(new StructuralDesignModel(57, "תמירות מינמלית", "λ", "", mathId_57(), 0));
            resultModels.add(new StructuralDesignModel(59, "בדיקה", "", "", mathId_59(), 0));
            resultModels.add(new StructuralDesignModel(63, "חישוב אקסצנטריות הנובעת מאי דיוק בביצוע", "", "[mm]", mathId_63(), 0));
            resultModels.add(new StructuralDesignModel(67, "מקדם אינטגרציה", "העקמומיות בחתך ללא השפעות הזחילה וכוח","", mathId_67(),0));
            resultModels.add(new StructuralDesignModel(68, "חישוב אקסצנטריות הנובעת מתמירות העמוד", "","[mm]", mathId_68(),0));
            resultModels.add(new StructuralDesignModel(71, "חוזק אופייני של הבטון", "fck","[Mpa]", id_71_value+"",0));
            resultModels.add(new StructuralDesignModel(72, "חוזק בטון", "fcd","[Mpa]",mathId_72(),0));
            resultModels.add(new StructuralDesignModel(79, "חוזק פלדה אופייני", "fsd","[Mpa]", mathId_79(),0));
            resultModels.add(new StructuralDesignModel(80, "גובה חתך", "y","[cm]",mathId_80(),0));
            resultModels.add(new StructuralDesignModel(81, "גובה חתך פעיל", "d","[cm]", mathId_81(),0));
            resultModels.add(new StructuralDesignModel(82, "שטח חתך", "Ac","[cm^2]", mathId_82(),0));
            resultModels.add(new StructuralDesignModel(83, "אקסנטריות כוח הלחיצה", "ea","[cm^2]", mathId_83(),0));
            resultModels.add(new StructuralDesignModel(84, "חוזק תכן בטון לחיצה", "fcd","[Mpa]", mathId_84(),0));
            resultModels.add(new StructuralDesignModel(85, "חוזק תכן בטון מתיחה", "fctm","[Mpa]", mathId_85(),0));
            resultModels.add(new StructuralDesignModel(86, "מומנט תסבולת החתך", "mcd,max","[KNm]", mathId_86(),0));
            resultModels.add(new StructuralDesignModel(87, "יחס", "w(5.9)","[KNm]", mathId_87(),0));
            resultModels.add(new StructuralDesignModel(88, "יחס נבחר", "w","", mathId_88(),0));
            resultModels.add(new StructuralDesignModel(89, "מומנט פנימי בחתך", "mcd(5.8)","[KNm]", mathId_89(),0));
            resultModels.add(new StructuralDesignModel(90, "מומנט עקב אקסצנ'", "m'sd(5.24)","[KNm]", mathId_90(),0));
            resultModels.add(new StructuralDesignModel(91, "מומנט עקב אקסצנ'", "msd(5.21)","[KNm]", mathId_91(),0));
            resultModels.add(new StructuralDesignModel(93, "ברזל לחוץ מינימלי", "As',min","[cm^2]", mathId_93(),0));
            resultModels.add(new StructuralDesignModel(94, "שטח חתך ברזל לחוץ", "As'(5.23)","[cm^2]", mathId_94(),0));
            resultModels.add(new StructuralDesignModel(95, "זרוע שקול כוחות", "z","[cm]", mathId_95(),0));
            resultModels.add(new StructuralDesignModel(96, "שטח חתך ברזל מתוח", "As(5.22)","[cm^2]", mathId_96(),0));
            resultModels.add(new StructuralDesignModel(97, "ברזל מיני' במתיחה", "As,min","[cm^2]", mathId_97(),0));
            resultModels.add(new StructuralDesignModel(970, "שטח חתך ברזל מתוח", "As(5.25)","[cm^2]", mathId_970(),0));
            resultModels.add(new StructuralDesignModel(98, "מומנט פנימי בחתך", "mcd*","[KNm]", mathId_98(),0));
            resultModels.add(new StructuralDesignModel(99, "שטח חתך ברזל מתוח מחושב", "As*(5.22*)","[cm^2]", mathId_99(),0));
            resultModels.add(new StructuralDesignModel(100, "שטח חתך זיון  נבחר", "As,total","[cm^2]", mathId_100(),0));
            resultModels.add(new StructuralDesignModel(101, "שטח חתך נבחר", "As',total","[cm^2]", mathId_101(),0));
            resultModels.add(new StructuralDesignModel(102, "", "סוג","אקסצנטריות", mathId_102(),0));
            resultModels.add(new StructuralDesignModel(103, "קוטר מוט ברזל לחוץ", "ᴓ","[mm]", mathId_103(),0));
            resultModels.add(new StructuralDesignModel(104, "קוטר מוט ברזל מתוח", "ᴓ","[mm]", mathId_104(),0));
            resultModels.add(new StructuralDesignModel(105, "פירוט ברזל לחוץ", "","", mathId_105(),0));
            resultModels.add(new StructuralDesignModel(106, "פירוט ברזל מתוח", "","", mathId_106(),0));
            setResultModelsPositions();
            return resultModels;
        }
    }

    private String mathId_5() {
        id_5_value = 0.7 * id_3_value * Math.pow(id_2_value, 3) / 12;
        Log.d("checkMath", "mathId_5() -> id_5_value == " + id_5_value + "; id_3_value == " + id_3_value + "; id_2_value == " + id_2_value);
        return formatNumberDecimal(id_5_value);
    }

    private String mathId_6() {
        id_6_value = id_5_value / id_4_value;
        Log.d("checkMath", "mathId_6() -> id_6_value == " + id_6_value + "; id_5_value == " + id_5_value + "; id_4_value == " + id_4_value);
        return formatNumberDecimal(id_6_value);
    }

    private String mathId_11() {
        id_11_value = 0.35 * id_8_value * Math.pow(id_7_value, 3) / 12;
        Log.d("checkMath", "mathId_11() -> id_11_value == " + id_11_value + "; id_8_value == " + id_8_value + "; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_11_value);
    }

    private String mathId_12() {
        try {
            id_12_value = id_1_position == 0
                    ? getRelevantValueForSSCTypes_position() * id_11_value / id_9_value
                    : 6 * id_11_value / id_9_value;
            Log.d("checkMath", "mathId_12() -> id_12_value == " + id_12_value + "; id_11_value == " + id_11_value + "; id_9_value == " + id_9_value);
            if (Double.isNaN(id_12_value) || id_12_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_12_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_12() -> EXCEPTION -> " + e.getMessage());
            id_12_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_250() {
        firstMathPart = (id_6_value + id_25_value) / (id_12_value + id_19_value);
        try {
            id_250_value =
                    firstMathPart <= 0.1
                    ? 0.1
                    : firstMathPart > 50
                    ? Double.NEGATIVE_INFINITY
                    : firstMathPart;
            Log.d("checkMath", "mathId_13() -> id_250_value == " + id_250_value + "; id_6_value == " + id_6_value + "; id_25_value == " + id_25_value + "; id_12_value == " + id_12_value + "; id_19_value == " + id_19_value);
            if (Double.isNaN(id_250_value) || id_250_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_250_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_250_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_13() -> EXCEPTION -> " + e.getMessage());
            id_250_value = e.getMessage().equals(NEGATIVE_INFINITY) ? Double.NaN : 1;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "Ꝏ" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_18() {
        try {
            id_18_value = 0.35 * id_15_value * Math.pow(id_14_value, 3) / 12;
            Log.d("checkMath", "mathId_18() -> id_18_value == " + id_18_value + "; id_15_value == " + id_15_value + "; id_14_value == " + id_14_value);
            if (Double.isNaN(id_18_value) || id_18_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_18_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_18() -> EXCEPTION -> " + e.getMessage());
            id_18_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_19() {
        try {
            id_19_value = id_1_position == 0
                    ? getRelevantValueForSSCTypes_position() * id_18_value / id_16_value
                    : 6 * id_18_value / id_16_value;
            Log.d("checkMath", "mathId_19() -> id_19_value == " + id_19_value + "; id_18_value == " + id_18_value + "; id_16_value == " + id_16_value);
            if (Double.isNaN(id_19_value) || id_19_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_19_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_19() -> EXCEPTION -> " + e.getMessage());
            id_19_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_21() {
        try {
            id_21_value = id_20_value / 3;
            Log.d("checkMath", "mathId_21() -> id_21_value == " + id_21_value + "; id_20_value == " + id_20_value);
            if (Double.isNaN(id_21_value) || id_21_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_21_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_21() -> EXCEPTION -> " + e.getMessage());
            id_21_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_24() {
        try {
            id_24_value = 0.7 * id_22_value * Math.pow(id_20_value, 3) / 12;
            Log.d("checkMath", "mathId_24() -> id_24_value == " + id_24_value + "; id_22_value == " + id_22_value + "; id_20_value == " + id_20_value);
            if (Double.isNaN(id_24_value) || id_24_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_24_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_24() -> EXCEPTION -> " + e.getMessage());
            id_24_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_25() {
        try {
            id_25_value = id_24_value / id_23_value;
            Log.d("checkMath", "mathId_25() -> id_25_value == " + id_25_value + "; id_24_value == " + id_24_value + "; id_23_value == " + id_23_value);
            if (Double.isNaN(id_25_value) || id_25_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_25_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_25() -> EXCEPTION -> " + e.getMessage());
            id_25_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_31() {
        try {
            id_31_value = 0.35 * id_28_value * Math.pow(id_27_value, 3) / 12;
            Log.d("checkMath", "mathId_31() -> id_31_value == " + id_31_value + "; id_28_value == " + id_28_value + "; id_27_value == " + id_27_value);
            if (Double.isNaN(id_31_value) || id_31_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_31_value);
        } catch (NumberFormatException e){
            id_31_value = Double.NaN;
            Log.d("checkMath", "mathId_31() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_32() {
        try {
            id_32_value = id_1_position == 0
                    ? getRelevantValueForSSCTypes_position() * id_31_value / id_29_value
                    : 6 * id_31_value / id_29_value;
            Log.d("checkMath", "mathId_32() -> id_32_value == " + id_32_value + "; id_28_value == " + id_28_value + "; id_27_value == " + id_27_value);
            if (Double.isNaN(id_32_value) || id_32_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_32_value);
        } catch (NumberFormatException e){
            id_39_value = Double.NaN;
            Log.d("checkMath", "mathId_32() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_38() {
        try {
            id_38_value = 0.35 * id_35_value * Math.pow(id_34_value, 3) / 12;
            Log.d("checkMath", "mathId_38() -> id_38_value == " + id_38_value + "; id_35_value == " + id_35_value + "; id_34_value == " + id_34_value);
            if (Double.isNaN(id_38_value) || id_38_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_38_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_38() -> EXCEPTION -> " + e.getMessage());
            id_38_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_39() {
        try {
            id_39_value = id_1_position == 0
                    ? getRelevantValueForSSCTypes_position() * id_38_value / id_36_value
                    : 6 * id_38_value / id_36_value;
            Log.d("checkMath", "mathId_39() -> id_39_value == " + id_39_value + "; id_38_value == " + id_38_value + "; id_36_value == " + id_36_value);
            if (Double.isNaN(id_39_value) || id_39_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_39_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_39() -> EXCEPTION -> " + e.getMessage());
            id_39_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_43() {
        try {
            id_43_value = 0.7 * id_41_value * Math.pow(id_40_value, 3) / 12;
            Log.d("checkMath", "mathId_43() -> id_43_value == " + id_43_value + "; id_41_value == " + id_41_value + "; id_40_value == " + id_40_value);
            if (Double.isNaN(id_43_value) || id_43_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_43_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_43() -> EXCEPTION -> " + e.getMessage());
            id_43_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }
    private String mathId_44() {
        try {
            id_44_value = id_43_value / id_42_value;
            Log.d("checkMath", "mathId_44() -> id_44_value == " + id_44_value + "; id_43_value == " + id_43_value + "; id_42_value == " + id_42_value);
            if (Double.isNaN(id_44_value) || id_44_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_44_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_44() -> EXCEPTION -> " + e.getMessage());
            id_44_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_440() {
        try {
            firstMathPart = ((id_25_value + id_44_value) / (id_32_value + id_39_value));
            id_440_value = firstMathPart <= 0.1
                    ? 0.1
                    : firstMathPart > 50
                    ? Double.NEGATIVE_INFINITY
                    : firstMathPart;
            Log.d("checkMath", "mathId_440() -> id_440_value == " + id_440_value + "; id_28_value == " + id_28_value + "; id_27_value == " + id_27_value);
            if (Double.isNaN(id_440_value) || id_440_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_440_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_440_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_440() -> EXCEPTION -> " + e.getMessage());
            id_440_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "Ꝏ" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_441() {
        try {
            id_441_value =
                    id_1_position == 0
                            ? 0.5 * id_23_value * Math.pow((1 + id_250_value / (0.45 + id_250_value)) * (1 + id_440_value / (0.45 + id_440_value)), 0.5)
                            : id_23_value * Math.max(
                            Math.pow(1 + 10 * (id_250_value * id_440_value) / (id_250_value + id_440_value), 0.5),
                            (1 + (id_250_value / (1 + id_250_value))) * (1 + (id_440_value / (1 + id_440_value))));
            Log.d("checkMath", "mathId_441() -> id_441_value == " + id_441_value + "; id_1_position == " + id_1_position + "; id_23_value == " + id_23_value + "; id_250_value == " + id_250_value + "; id_440_value == " + id_440_value);
            if (Double.isNaN(id_441_value) || id_441_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            id_441_value = Double.parseDouble(formatNumberDecimal(id_441_value));
            Log.d("checkMath", "mathId_441() -> id_441_value == " + id_441_value);
            return formatNumberDecimal(id_441_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_441() -> EXCEPTION -> " + e.getMessage());
            id_441_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_46() {
        try {
            id_46_value = id_22_value * id_20_value;
            Log.d("checkMath", "mathId_46() -> id_46_value == " + id_46_value + "; id_22_value == " + id_22_value + "; id_21_value == " + id_21_value);
            if (Double.isNaN(id_46_value) || id_46_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_46_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_46() -> EXCEPTION -> " + e.getMessage());
            id_46_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_49() {
        id_49_value = getRelevantValueForId(49, id_47_value);
        return formatNumberDecimal(id_49_value);
    }

    private String mathId_51() {
        id_51_value = getRelevantValueForId(51, id_50_value);
        return formatNumberDecimal(id_51_value);
    }

    private String mathId_55() {
        try {
            id_55_value = (20 * id_52_value * id_53_value * id_54_value) / Math.pow(id_45_value * 10 / (id_46_value * id_49_value), 0.5);
            Log.d("checkMath", "mathId_55() -> id_55_value == " + id_55_value + "; id_22_value == " + id_22_value + "; id_21_value == " + id_21_value);
            if (Double.isNaN(id_55_value) || id_55_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_55_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_55() -> EXCEPTION -> " + e.getMessage());
            id_55_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_56() {
        try {
            id_56_value = id_20_value / 100 / Math.pow(12, 0.5);
            Log.d("checkMath", "mathId_56() -> id_56_value == " + id_56_value + "; id_21_value == " + id_21_value);
            if (Double.isNaN(id_56_value) || id_56_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_56_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_56() -> EXCEPTION -> " + e.getMessage());
            id_56_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_57() {
        try {
            id_57_value = id_441_value / 100 / id_56_value;
            Log.d("checkMath", "mathId_57() -> id_57_value == " + id_57_value + "; id_441_value == " + id_441_value + "; id_56_value == " + id_56_value);
            if (Double.isNaN(id_57_value) || id_57_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_57_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_57() -> EXCEPTION -> " + e.getMessage());
            id_57_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_59() {
        try {
            Log.d("checkMath", "mathId_59() -> id_57_value == " + id_57_value + "; id_55_value == " + id_55_value + "; id_58_value == " + id_58_value);
            if (Double.isNaN(id_55_value) || Double.isNaN(id_57_value) || Double.isNaN(id_58_value)) throw new NumberFormatException(NaN);
            return id_57_value <= id_55_value && id_57_value < id_58_value ? "לא תמיר" : id_57_value < id_58_value && id_57_value > id_55_value ? " עמוד תמיר" : "יש לחשב לפי השיטה הכללית";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_59() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_63() {
        try {
            id_63_value = 0.5 * id_441_value * 10 / 200 * (2 / Math.pow(id_23_value / 100, 0.5) <= (2.0 / 3) ? 2 / 3.0 : (2 / Math.pow(id_23_value / 100, 0.5) >= 1 ? 1 : 2 / Math.pow(id_23_value / 100, 0.5)));
            Log.d("checkMath", "mathId_63() -> id_63_value == " + id_63_value + "; id_441_value == " + id_441_value + "; id_23_value == " + id_23_value);
            if (Double.isNaN(id_63_value) || id_63_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_63_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_63() -> EXCEPTION -> " + e.getMessage());
            id_63_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_67() {
        try {
            id_67_value = (id_51_value / 200000) / (0.45 * id_20_value * 10 / 2);
            Log.d("checkMath", "mathId_67() -> id_67_value == " + formatNumberDecimal(id_67_value, 6) + "; id_51_value == " + id_51_value + "; id_20_value == " + id_20_value);
            if (Double.isNaN(id_67_value) || id_67_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            id_67_value = Double.parseDouble(formatNumberDecimal(id_67_value));
            return formatNumberDecimal(id_67_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_67() -> EXCEPTION -> " + e.getMessage());
            id_67_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_68() {
        try {
            firstMathPart = id_64_value * id_65_value * id_67_value;
            secondMathPart = Math.pow(id_441_value * 10, 2) / id_66_value;
            id_68_value = firstMathPart * secondMathPart;
            Log.d("checkMath", "mathId_68() -> id_68_value == " + id_68_value + "; id_64_value == " + id_64_value + "; id_65_value == " + id_65_value + "; id_66_value == " + id_66_value + "; id_67_value == " + id_67_value + "; id_441_value == " + id_441_value);
            Log.d("checkMath", "mathId_68() -> firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart + "; (firstMathPart * secondMathPart) == " + (firstMathPart * secondMathPart));
            if (Double.isNaN(id_68_value) || id_68_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_68_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_68() -> EXCEPTION -> " + e.getMessage());
            id_68_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_72() {
        id_72_value = getRelevantValueForId(72, id_70_value);
        return formatNumberDecimal(id_72_value);
    }

    private String mathId_79() {
        id_79_value = getRelevantValueForId(79, id_78_value);
        return formatNumberDecimal(id_79_value);
    }

    private String mathId_80() {
        try {
            id_80_value = id_73_value / 2;
            Log.d("checkMath", "mathId_80() -> id_80_value == " + id_80_value + "; id_73_value == " + id_73_value);
            if (Double.isNaN(id_80_value) || id_80_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_80_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_80() -> EXCEPTION -> " + e.getMessage());
            id_80_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_81() {
        try {
            id_81_value = id_73_value - id_75_value;
            Log.d("checkMath", "mathId_81() -> id_81_value == " + id_81_value + "; id_73_value == " + id_73_value + "; id_75_value == " + id_75_value);
            if (Double.isNaN(id_81_value) || id_81_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_81_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_81() -> EXCEPTION -> " + e.getMessage());
            id_81_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_82() {
        try {
            id_82_value = id_73_value * id_74_value;
            Log.d("checkMath", "mathId_82() -> id_82_value == " + id_82_value + "; id_73_value == " + id_73_value + "; id_74_value == " + id_74_value);
            if (Double.isNaN(id_82_value) || id_82_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_82_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_82() -> EXCEPTION -> " + e.getMessage());
            id_82_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_83() {
        try {
            id_83_value = (id_76_value * 100 / id_77_value) + Math.max(2, id_73_value / 30) + id_68_value;
            Log.d("checkMath", "mathId_83() -> id_83_value == " + id_83_value + "; id_73_value == " + id_73_value + "; id_76_value == " + id_76_value + "; id_77_value == " + id_77_value + "; id_68_value == " + id_68_value);
            if (Double.isNaN(id_83_value) || id_83_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_83_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_83() -> EXCEPTION -> " + e.getMessage());
            id_83_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_84() {
        try {
            id_84_value = getRelevantValueForId(84, id_70_value);
            Log.d("checkMath", "mathId_84() -> id_84_value == " + id_84_value + "; id_70_value == " + id_70_value);
            return id_84_value == 0 ? "ערכי סוג הבטון אינם בטבלאות" : id_84_value +"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_84() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_85() {
        try {
            id_85_value = getRelevantValueForId(85, id_70_value);
            Log.d("checkMath", "mathId_85() -> id_84_value == " + id_85_value);
            return id_85_value == 0 ? "ערכי סוג הבטון אינם בטבלאות" : id_85_value +"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_85() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_86() {
        try {
            id_86_value = 0.32 * id_74_value * id_81_value * id_81_value * id_84_value * Math.pow(10,-3);
            Log.d("checkMath", "mathId_86() -> id_86_value == " + id_86_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_86_value) || id_86_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_86_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_86() -> EXCEPTION -> " + e.getMessage());
            id_86_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_87() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = 1 - (Math.pow(1 - fourthMathPart / thirdMathPart, 0.5));
            id_87_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_87() -> id_87_value == " + id_87_value + "; id_76_value == " + id_76_value  + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            Log.d("checkMath", "mathId_87() -> firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart);
            if (Double.isNaN(id_87_value) || id_87_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_87_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_87_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_87() -> EXCEPTION -> " + e.getMessage());
            id_87_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "להגדיל חתך" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_88() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_87_value < 0.1 ? 0.1 : Math.min(id_87_value, 0.4);
            id_88_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_88() -> id_87_value == " + id_87_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_88_value) || id_88_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_88_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_88_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_88() -> EXCEPTION -> " + e.getMessage());
            id_88_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_89() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            fifthMathPart = id_74_value * id_81_value * id_81_value * id_87_value;
            if (thirdMathPart == 0 || fifthMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = fifthMathPart * (1-(id_87_value / 2)) * id_84_value * Math.pow(10, -3);
            id_89_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_89() -> id_89_value == " + id_89_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            Log.d("checkMath", "mathId_89() -> firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart + "; thirdMathPart == " + thirdMathPart + "; fourthMathPart == " + fourthMathPart);
            if (Double.isNaN(id_89_value) || id_89_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_89_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_89_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_89() -> EXCEPTION -> " + e.getMessage());
            id_89_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_90() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = Math.abs(1.4 * id_77_value * (id_80_value - id_83_value - id_75_value) * Math.pow(10,-2));
            id_90_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_90() -> id_90_value == " + id_90_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            Log.d("checkMath", "mathId_90() -> id_77_value == " + id_77_value + "; id_80_value == " + id_80_value + "; id_83_value == " + id_83_value + "; id_75_value == " + id_75_value);
            Log.d("checkMath", "mathId_90() -> firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart + "; thirdMathPart == " + thirdMathPart + "; fourthMathPart == " + fourthMathPart);
            if (Double.isNaN(id_90_value) || id_90_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_90_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_90_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_90() -> EXCEPTION -> " + e.getMessage());
            id_90_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_91() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = 1.4 * id_77_value * (id_83_value + (id_80_value - id_75_value)) * Math.pow(10, -2);
            id_91_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_91() -> id_91_value == " + id_87_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_91_value) || id_91_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_91_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_91_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_91() -> EXCEPTION -> " + e.getMessage());
            id_91_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_93() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = 0.004 * id_81_value * id_74_value;
            id_93_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_93() -> id_93_value == " + id_87_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_93_value) || id_93_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_93_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_93_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_93() -> EXCEPTION -> " + e.getMessage());
            id_93_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_94() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = ((id_91_value - id_86_value) * Math.pow(10, 3) / ((id_81_value - id_75_value) * id_79_value)) > 0 ? (id_91_value - id_86_value) * Math.pow(10, 3) / (( id_81_value - id_75_value) * id_79_value) : id_93_value;
            id_94_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_94() -> id_94_value == " + id_94_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_94_value) || id_94_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_94_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_94_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_94() -> EXCEPTION -> " + e.getMessage());
            id_94_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_95() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_81_value - id_75_value;
            id_95_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_95() -> id_95_value == " + id_95_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_95_value) || id_95_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_95_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_95_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_95() -> EXCEPTION -> " + e.getMessage());
            id_95_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_96() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_94_value + ((id_89_value * 100 / id_95_value) - id_77_value) * (10 / id_79_value);
            id_96_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_96() -> id_96_value == " + id_96_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_96_value) || id_96_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_96_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_96_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_96() -> EXCEPTION -> " + e.getMessage());
            id_96_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_97() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = 0.28 * (id_85_value / id_78_value) * id_74_value * id_81_value;
            id_97_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_97() -> id_97_value == " + id_97_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_97_value) || id_97_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_97_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_97_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_97() -> EXCEPTION -> " + e.getMessage());
            id_97_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_970() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = (id_90_value - id_89_value) * 1000 / ((id_81_value - id_75_value) * id_79_value) < 0 ? id_97_value : (id_90_value - id_89_value) * 1000 / ((id_81_value - id_75_value) * id_79_value);
            id_970_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_970() -> id_970_value == " + id_970_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_970_value) || id_970_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_970_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_970_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_970() -> EXCEPTION -> " + e.getMessage());
            id_970_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_98() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_91_value - (id_93_value * (id_81_value - id_75_value) * id_79_value) / 1000;
            id_98_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_98() -> id_98_value == " + id_98_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_98_value) || id_98_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_98_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_98_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_98() -> EXCEPTION -> " + e.getMessage());
            id_98_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_99() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_93_value + ((id_98_value * 100 / id_95_value) - id_77_value) * (10 / id_79_value);
            id_99_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_99() -> id_99_value == " + id_99_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_99_value) || id_99_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_99_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_99_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_99() -> EXCEPTION -> " + e.getMessage());
            id_99_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_100() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart =
                    id_83_value > id_80_value - id_75_value
                    ? (id_91_value > id_86_value
                            ? Math.max(id_96_value,id_97_value)
                            : Math.max(id_99_value, id_97_value))
                    : Math.max(id_970_value, id_97_value);
            id_100_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_100() -> id_100_value == " + id_100_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_100_value) || id_100_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_100_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_100_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_100() -> EXCEPTION -> " + e.getMessage());
            id_100_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_101() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = id_83_value > id_80_value - id_75_value ? (id_91_value <= id_86_value ? id_93_value : Math.max(id_94_value, id_93_value)) : Math.max(id_94_value, id_93_value);
            id_101_value = firstMathPart > 1 ? Double.NEGATIVE_INFINITY : secondMathPart;
            Log.d("checkMath", "mathId_101() -> id_101_value == " + id_101_value + "; id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value);
            if (Double.isNaN(id_101_value) || id_101_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(NaN);
            if (id_101_value == Double.NEGATIVE_INFINITY) throw new NumberFormatException(NEGATIVE_INFINITY);
            return formatNumberDecimal(id_101_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_101() -> EXCEPTION -> " + e.getMessage());
            id_101_value = Double.NaN;
            return e.getMessage().equals(NEGATIVE_INFINITY) ? "-" : context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_102() {
        try {
            Log.d("checkMath", "mathId_102() -> id_83_value == " + id_83_value + "; id_80_value == " + id_80_value + "; id_75_value == " + id_75_value);
            if (Double.isNaN(id_83_value) || Double.isNaN(id_80_value) || Double.isNaN(id_75_value)) throw new NumberFormatException(NaN);
            return id_83_value > id_80_value - id_75_value ? "גדולה" : "קטנה";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_102() -> EXCEPTION -> " + e.getMessage());
            id_102_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_103() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = 2 * Math.pow(id_101_value / Math.PI * id_69_value, 0.5);
            thirdMathPart = mathEven(2 * Math.pow(id_101_value / Math.PI * id_69_value,0.5));
            Log.d("checkMath", "mathId_103() -> id_83_value == " + id_83_value + "; id_80_value == " + id_80_value + "; id_75_value == " + id_75_value);
            if (Double.isNaN(firstMathPart) || firstMathPart == Double.POSITIVE_INFINITY ||
                    Double.isNaN(secondMathPart) || secondMathPart == Double.POSITIVE_INFINITY ||
                    Double.isNaN(thirdMathPart) || thirdMathPart == Double.POSITIVE_INFINITY ||
                    Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);
            return firstMathPart > 1 ? "-" : secondMathPart < 12 ? "נדרש קוטר מיני' של 12 " : id_69_value > 30 ? "נדרש להקטין פסיעה" : thirdMathPart + "";
        } catch (NumberFormatException e){
            id_103_value = Double.NaN;
            Log.d("checkMath", "mathId_103() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_104() {
        try {
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            secondMathPart = mathEven(2 * Math.pow(id_100_value / Math.PI * id_69_value, 0.5) + 2);
            Log.d("checkMath", "mathId_104() -> id_74_value == " + id_74_value + "; id_81_value == " + id_81_value + "; id_84_value == " + id_84_value + "; id_76_value == " + id_76_value + "; id_69_value == " + id_69_value);
            Log.d("checkMath", "mathId_104() -> secondMathPart == " + secondMathPart + "; firstMathPart == " + firstMathPart);
            if (Double.isNaN(firstMathPart) || firstMathPart == Double.POSITIVE_INFINITY ||
                    Double.isNaN(secondMathPart) || secondMathPart == Double.POSITIVE_INFINITY ||
                    Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);
            return firstMathPart > 1 ? "-" : id_69_value > 30 ? "נדרש להקטין פסיעה" : secondMathPart + "";
        } catch (NumberFormatException e){
            id_104_value = Double.NaN;
            Log.d("checkMath", "mathId_104() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_105() {
        try {
            if (Double.isNaN(id_103_value) || Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            Log.d("checkMath", "mathId_105() -> id_83_value == " + id_83_value + "; id_80_value == " + id_80_value + "; id_75_value == " + id_75_value);
            Log.d("checkMath", "mathId_105() -> id_103_value == " + id_103_value + "; id_69_value == " + id_69_value + "; firstMathPart == " + firstMathPart);
            if (Double.isNaN(firstMathPart) || firstMathPart == Double.POSITIVE_INFINITY || Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);
            return firstMathPart > 1 ? "-" : mathId_103() + "@ " + id_69_value + " ᴓ";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_105() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    private String mathId_106() {
        try {
            if (Double.isNaN(id_104_value) || Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);
            thirdMathPart = id_74_value * id_81_value * id_81_value * id_84_value;
            if (thirdMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            fourthMathPart = 2 * id_76_value * Math.pow(10, 3);
            firstMathPart = fourthMathPart / thirdMathPart;
            Log.d("checkMath", "mathId_106() -> id_83_value == " + id_83_value + "; id_80_value == " + id_80_value + "; id_75_value == " + id_75_value);
            if (Double.isNaN(firstMathPart) || firstMathPart == Double.POSITIVE_INFINITY || Double.isNaN(id_69_value)) throw new NumberFormatException(NaN);

            return firstMathPart > 1 ? "-" : mathId_104() + "@ " + id_69_value + " ᴓ";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_106() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("numberChangedListener", "PagingSubcategoryOne{} -> valueItemNumber == " + valueItemNumber + "; valueItemId == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);
        switch (valueItemId) {
            case 1:
                id_1_position = spinnerPosition;
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 2:
                id_2_value = valueItemNumber;
                setRelevantResultItem_value(5, mathId_5(), "");
                setRelevantResultItem_value(6, mathId_6(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 3:
                id_3_value = valueItemNumber;
                setRelevantResultItem_value(5, mathId_5(), "");
                setRelevantResultItem_value(6, mathId_6(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 4:
                id_4_value = valueItemNumber;
                setRelevantResultItem_value(6, mathId_6(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 7:
                id_7_value = valueItemNumber;
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 8:
                id_8_value = valueItemNumber;
                setRelevantResultItem_value(11, mathId_11(), "");
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 9:
                id_9_value = valueItemNumber;
                setRelevantResultItem_value(12, mathId_12(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 14:
                id_14_value = valueItemNumber;
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 15:
                id_15_value = valueItemNumber;
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 16:
                id_16_value = valueItemNumber;
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 17:
                id_17_position = spinnerPosition;
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 20:
                id_20_value = valueItemNumber;
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(56, mathId_56(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 22:
                id_22_value = valueItemNumber;
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 23:
                id_23_value = valueItemNumber;
                setRelevantResultItem_value(25, mathId_25(), "");
                setRelevantResultItem_value(250, mathId_250(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 27:
                id_27_value = valueItemNumber;
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 28:
                id_28_value = valueItemNumber;
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 29:
                id_29_value = valueItemNumber;
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 30:
                id_30_position = spinnerPosition;
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 34:
                id_34_value = valueItemNumber;
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 35:
                id_35_value = valueItemNumber;
                setRelevantResultItem_value(38, mathId_38(), "");
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 36:
                id_36_value = valueItemNumber;
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 37:
                id_37_position = spinnerPosition;
                setRelevantResultItem_value(39, mathId_39(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 40:
                id_40_value = valueItemNumber;
                setRelevantResultItem_value(43, mathId_43(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 41:
                id_41_value = valueItemNumber;
                setRelevantResultItem_value(43, mathId_43(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 42:
                id_42_value = valueItemNumber;
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(440, mathId_440(), "");
                setRelevantResultItem_value(441, mathId_441(), "");
                setRelevantResultItem_value(57, mathId_57(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(63, mathId_63(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 45:
                id_45_value = valueItemNumber;
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 47:
                id_47_position = spinnerPosition;
                id_47_value = getConcreteTypeDoubleValues()[spinnerPosition];
                id_48_value = id_47_value;
                setRelevantResultItem_value(48,id_48_value+"", "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 50:
                id_50_position = spinnerPosition;
                id_50_value = getFrom_400_to_500_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 52:
                id_52_value = valueItemNumber;
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 53:
                id_53_value = valueItemNumber;
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 54:
                id_54_value = valueItemNumber;
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 58:
                id_58_value = valueItemNumber;
                setRelevantResultItem_value(59, mathId_59(), "");
                break;
            case 60:
                id_60_value = valueItemNumber;
                break;
            case 61:
                id_61_value = valueItemNumber;
                break;
            case 62:
                id_62_value = valueItemNumber;
                break;
            case 64:
                id_64_value = valueItemNumber;
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 65:
                id_65_value = valueItemNumber;
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 66:
                id_66_position = spinnerPosition;
                id_66_value = getFrom_8_to_10_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 69:
                id_69_value = valueItemNumber;
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 70:
                id_70_position = spinnerPosition;
                id_70_value = getConcreteTypeDoubleValues()[spinnerPosition];
                id_71_value = id_70_value;
                setRelevantResultItem_value(71, id_71_value +"", "");
                setRelevantResultItem_value(72, mathId_72(), "");
                setRelevantResultItem_value(84, mathId_84(), "");
                setRelevantResultItem_value(85, mathId_85(), "");
                setRelevantResultItem_value(86, mathId_86(), "");
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(88, mathId_88(), "");
                setRelevantResultItem_value(89, mathId_89(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 73:
                id_73_value = valueItemNumber;
                setRelevantResultItem_value(80, mathId_80(), "");
                setRelevantResultItem_value(81, mathId_81(), "");
                setRelevantResultItem_value(82, mathId_82(), "");
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(86, mathId_86(), "");
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(88, mathId_88(), "");
                setRelevantResultItem_value(89, mathId_89(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 74:
                id_74_value = valueItemNumber;
                setRelevantResultItem_value(82, mathId_82(), "");
                setRelevantResultItem_value(86, mathId_86(), "");
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(88, mathId_88(), "");
                setRelevantResultItem_value(89, mathId_89(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 75:
                id_75_value = valueItemNumber;
                setRelevantResultItem_value(81, mathId_81(), "");
                setRelevantResultItem_value(86, mathId_86(), "");
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(88, mathId_88(), "");
                setRelevantResultItem_value(89, mathId_89(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 76:
                id_76_value = valueItemNumber;
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(87, mathId_87(), "");
                setRelevantResultItem_value(88, mathId_88(), "");
                setRelevantResultItem_value(89, mathId_89(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 77:
                id_77_value = valueItemNumber;
                setRelevantResultItem_value(83, mathId_83(), "");
                setRelevantResultItem_value(90, mathId_90(), "");
                setRelevantResultItem_value(91, mathId_91(), "");
                setRelevantResultItem_value(93, mathId_93(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
            case 78:
                id_78_position = spinnerPosition;
                id_78_value = getFrom_400_to_500_doubleValues()[spinnerPosition];
                setRelevantResultItem_value(79, mathId_79(), "");
                setRelevantResultItem_value(94, mathId_94(), "");
                setRelevantResultItem_value(96, mathId_96(), "");
                setRelevantResultItem_value(970, mathId_970(), "");
                setRelevantResultItem_value(98, mathId_98(), "");
                setRelevantResultItem_value(99, mathId_99(), "");
                setRelevantResultItem_value(100, mathId_100(), "");
                setRelevantResultItem_value(101, mathId_101(), "");
                setRelevantResultItem_value(102, mathId_102(), "");
                setRelevantResultItem_value(103, mathId_103(), "");
                setRelevantResultItem_value(104, mathId_104(), "");
                setRelevantResultItem_value(105, mathId_105(), "");
                setRelevantResultItem_value(106, mathId_106(), "");
                break;
        }
    }

    public int getRelevantValueForSSCTypes_position() {
        switch (id_10_position){
            case 1:
                return 4;
            case 2:
                return 2;
            case 0: default:
                return 3;
        }
    }

    public double getRelevantValueForId(int id, double compareValue){
        int relevantIdIntValue;
        Log.d("checkFormatNumber", "id == " + id + "; compareValue == " + compareValue);
        relevantIdIntValue = convertDoubleToInt(compareValue);
        switch (id){
            case 49: case 72:
                switch (relevantIdIntValue){
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
            case 51: case 79:
                switch (relevantIdIntValue){
                    case 500:
                        return 435;
                    case 400:
                    default:
                        return 350;
                }
            case 84:
                switch (relevantIdIntValue){
                    case 20:
                        return 8.6;
                    case 30:
                        return 13;
                    case 40:
                        return 17.5;
                    case 50:
                        return 22.1;
                    case 60:
                        return 26.9;
                    default:
                        return 0;
                }
                case 85:
                switch (relevantIdIntValue){
                    case 20:
                        return 1.72;
                    case 30:
                        return 2.33;
                    case 40:
                        return 2.77;
                    case 50:
                        return 3.24;
                    case 60:
                        return 3.78;
                    default:
                        return 0;
                }
            default:
                return 0;
        }
    }

}

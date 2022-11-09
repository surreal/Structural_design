package com.itcm.structural_design.modules.concrete.bending_tolerance;

import android.util.ArrayMap;
import android.util.Log;
import android.view.View;

import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.database.SQLRemote;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.models.StructuralDesignModel;

import java.util.ArrayList;

public class BendingToleranceCategory_SubCategoryOne extends BendingToleranceCategory {

    BendingToleranceCategory_SubCategoryOne(){
        resetValues();
        setValues();
        setAllAdapters();
        Log.d("checkLifeCycle", "BendingToleranceCategory_SubCategoryOne()");
    }

    public void resetValues() {
        id_1_value = 1; id_2_value = 30; id_3_value = 1; id_4_value = 1; id_5_value = 1; id_6_value = 1; id_7_value = 0;
        id_8_value = 30; id_9_value = 8.7; id_10_value = 400; id_11_value = 350; id_12_value = 1.7; id_13_value = 0.0012; id_14_value = 0.0015;
        id_15_value = 0; id_20_value = 1; id_21_value = 1; id_19_value = 1; id_18_value = 1;
        id_24_value = 1; id_25_value = 2; id_26_value = 2; id_27_value = 8; id_28_value = 8; id_29_value = 0; id_30_value = 0;
        id_39_value = 1; id_40_value = 1; id_41_value = 1; id_42_value = 1; id_43_value = 1; id_44_value = 1;
        id_45_value = 1; id_46_value = 1; id_47_value = 1; id_50_value = 1; id_51_value = 1; id_52_value = 1; id_53_value = 1; id_54_value = 1;
        id_55_value = 1; id_56_value = 1; id_57_value = 2; id_58_value = 8; id_59_value = 1; id_63_value = 1; id_64_value = 1; id_65_value = 1;
        id_68_value = 1; id_70_value = 1; id_72_value = 1; id_73_value = 1; id_74_value = 1; id_75_value = 1; id_76_value = 1; id_77_value = 1;
        id_78_value = 1; id_79_value = 1; id_80_value = 1; id_81_value = 1; id_82_value = 1; id_83_value = 1; id_84_value = 1; id_85_value = 1;
        id_87_value = 1; id_88_value = 8; id_89_value = 1; id_91_value = 1; id_92_value = 8; id_93_value = 1; id_94_value = 1;
        id_2_position = 1; id_10_position = 0; id_25_position = 0; id_26_position = 0; id_27_position = 0; id_28_position = 0;
        id_57_position = 0; id_58_position = 0; id_88_position = 0; id_92_position = 0;
    }

    private void setValues() {
        if (savedVersionTitle != null) {
            cursor = sqlLocal.selectFiveComparesCursor("*", savedVersionTitle);
            cursor.moveToFirst();
            id_1_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_1);
            id_2_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_2);
            id_3_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_3);
            id_4_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_4);
            id_5_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_5);
            id_6_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_6);
            id_10_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_10);
            id_25_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_25);
            id_26_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_26);
            id_27_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_27);
            id_28_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_28);
            id_39_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_39);
            id_40_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_40);
            id_56_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_56);
            id_57_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_57);
            id_58_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_58);
            id_63_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_63);
            id_70_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_70);
            id_87_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_87);
            id_88_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_88);
            id_91_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_91);
            id_92_value = sqlLocal.getRelevantDoubleValue(cursor, null, DBModel.COLUMN_VAL_ID_92);
        }
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(2, getPositionByValue(getConcreteTypeDoubleValues(), id_2_value));
        spinnerPositionsArray.put(10,getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value));
        Log.d("checkSetValues", "id_10_value == " + id_10_value + "; getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value) == " + getPositionByValue(getFrom_400_to_500_stringValues(), id_10_value));
        spinnerPositionsArray.put(25,getPositionByValue(getFrom_2_to_9_stringValues(), id_25_value));
        spinnerPositionsArray.put(26,getPositionByValue(getFrom_2_to_9_stringValues(), id_26_value));
        spinnerPositionsArray.put(27,getPositionByValue(getFrom_8_to_25_stringValues(), id_27_value));
        spinnerPositionsArray.put(28,getPositionByValue(getFrom_8_to_25_stringValues(), id_28_value));
        spinnerPositionsArray.put(57,getPositionByValue(getFrom_2_to_10_stringValues(), id_57_value));
        spinnerPositionsArray.put(58,getPositionByValue(getFrom_8_to_25_stringValues(), id_58_value));
        spinnerPositionsArray.put(88,getPositionByValue(getFrom_8_to_25_stringValues(), id_88_value));
        spinnerPositionsArray.put(92,getPositionByValue(getFrom_8_to_25_stringValues(), id_92_value));
        id_2_position = spinnerPositionsArray.get(2);
        id_10_position = spinnerPositionsArray.get(10);
        id_25_position = spinnerPositionsArray.get(25);
        id_26_position = spinnerPositionsArray.get(26);
        id_27_position = spinnerPositionsArray.get(27);
        id_28_position = spinnerPositionsArray.get(28);
        id_57_position = spinnerPositionsArray.get(57);
        id_58_position = spinnerPositionsArray.get(58);
        id_88_position = spinnerPositionsArray.get(88);
        id_92_position = spinnerPositionsArray.get(92);
    }

    public void tonOrKnBtnClicked() {
        setRelevantResultItem_value(15, mathId_15(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(16, mathId_16(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(18, mathId_18(), getRelevantSecondMeasuringUnit(1));
        setRelevantResultItem_value(46, mathId_46(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(47, mathId_47(), getRelevantSecondMeasuringUnit(0));
        setRelevantResultItem_value(68, mathId_68(), getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(1, getRelevantSecondMeasuringUnit(1));
        setRelevantValueItemMeasuringUnit(39, getRelevantSecondMeasuringUnit(0));
        setRelevantValueItemMeasuringUnit(40, getRelevantSecondMeasuringUnit(0));
//        if (isPitulSelected) setRelevantResultItem_value(80, mathId_80(), getRelevantSecondMeasuringUnit(1));
    }

    private ArrayList<StructuralDesignModel> initModels(boolean isForSetValuesModels) {
        if (isForSetValuesModels) {
            valuesModels = new ArrayList<>();
            valuesPositionsByIds = new ArrayMap<>();
//            Log.d("checkPickerPosition", "numberPickerPositions.get(2) == " + spinnerPositionsArray.get(2) + "; numberPickerPositions == " + spinnerPositionsArray);
            valuesModels.add(new StructuralDesignModel(1, "מומנט תכן", "Md", "[KNm]", id_1_value+"", 0));
            valuesModels.add(new StructuralDesignModel(2, "סוג בטון", "", "", "", id_2_position));
            valuesModels.add(new StructuralDesignModel(3, "גובה חתך", "h", "[cm]", id_3_value+"", 0));
            valuesModels.add(new StructuralDesignModel(4, "עובי כיסוי זיו מתוח", "ds", "[cm]", id_4_value+"", 0));
            valuesModels.add(new StructuralDesignModel(5, "עובי כיסוי זיו לחוץ", "d's", "[cm]", id_5_value+"", 0));
            valuesModels.add(new StructuralDesignModel(6, "רוחב אלמנט", "b", "[cm]", id_6_value+"", 0));
            valuesModels.add(new StructuralDesignModel(10, "חוזק אופייני של הפלדה", "fck", "[Mpa]", "", id_10_position));
            valuesModels.add(new StructuralDesignModel(25, "מס מוטות מתוחים", "", "[cm]", "", id_25_position));
            valuesModels.add(new StructuralDesignModel(26 , "מס מוטות לחוצים", "", "[cm]", "", id_26_position));
            valuesModels.add(new StructuralDesignModel(27, "קוטר ברזל מתוח", "Φ", "[mm]", "", id_27_position));
            valuesModels.add(new StructuralDesignModel(28, "קוטר מוט לחוץ", "Φ", "[mm]", "", id_28_position));
            valuesModels.add(new StructuralDesignModel(39, "כוח צירי לתכן בבטון (חיובי = לחיצה)", "Nd", "[KN]", id_39_value+"", 0));
            valuesModels.add(new StructuralDesignModel(40, "כוח גזירה לתכן בבטון", "Vd", "[KN]", id_40_value+"", 0));
            valuesModels.add(new StructuralDesignModel(56, "פסיעה בפועל בין חישוקים גזירה", "Sv", "mm", id_56_value+"", 0));
            valuesModels.add(new StructuralDesignModel(57, "מס ענפים", "n,act", "", "", id_57_position));
            valuesModels.add(new StructuralDesignModel(58, "קוטר ברזל חישוק לגזירה", "Φ", "[mm]", "", id_58_position));
            valuesModels.add(new StructuralDesignModel(63, "שכבת כיסוי בטון", "C", "[cm]", id_63_value+"", 0));
//            if(isPitulSelected) {
//                valuesModels.add(new StructuralDesignModel(70, "מומנט פיתול", "Td", "[KNm]", id_70_value+"", 0));
//                valuesModels.add(new StructuralDesignModel(87, "מס מוטות נוספי דרושים", "n", "", id_87_value+"", 0));
//                valuesModels.add(new StructuralDesignModel(88, "קוטר מוט אורכי נוסף לקבלת כוחות הפיתול", "Φ", "[mm]", "", id_88_position));
//                valuesModels.add(new StructuralDesignModel(91, "פסיעה בפועל בין חישוקים כפיפה", "Sv", "mm", id_91_value+"", 0));
//                valuesModels.add(new StructuralDesignModel(92, "קוטר מוט חישוק לקבלת כוחות הפיתול", "Φ", "[mm]", "", id_92_position));
//            }
            setValuesModelsPositions();
            return valuesModels;
        } else {
            resultModels = new ArrayList<>();
            resultPositionsByIds = new ArrayMap<>();
            resultModels.add(new StructuralDesignModel(7, "גובה פעיל", "d", "[cm]", mathId_7(), 0));
            resultModels.add(new StructuralDesignModel(8, "חוזק אופייני של הבטון", "fck", "[Mpa]", getConcreteTypeDoubleValues()[id_2_position]+"", 0));
            resultModels.add(new StructuralDesignModel(9, "חוזק בטון", "fcd", "[Mpa]", getRelevantValueForId(9), 0));
            resultModels.add(new StructuralDesignModel(11, "חוזק פלדה", "fcd", "[Mpa]", getRelevantValueForId(11), 0));
            resultModels.add(new StructuralDesignModel(12, "חוזק מתיחה צירית ממוצעת לשירות בבטון מזויין", "fctm", " [Mpa]", getRelevantValueForId(12), 0));
            resultModels.add(new StructuralDesignModel(13, "מנת זיון מתוח בחתך בטון מזוין למניעת הרסה פריך(5.4)", "ρ", "-", getRelevantValueForId(13) + "", 0));
            resultModels.add(new StructuralDesignModel(14, "זיון מינמלי לכפיפה (5.3.6)", "ρ", "-", getRelevantValueForId(14) + "", 0));
            resultModels.add(new StructuralDesignModel(15, "מומנט תסבולת מקסימלי", "Mcd,max", "[KNm]", mathId_15(), 0));
            resultModels.add(new StructuralDesignModel(16, "בדיקה מומנט תסבולת מקסימלי", "2*Mcd,max>Md", "[KNm]", mathId_16(), 0));
            resultModels.add(new StructuralDesignModel(17, "בדיקת מומנט התכן מול מומנט התסבולת", "Mcd>Md", "-", mathId_17(), 0));
            resultModels.add(new StructuralDesignModel(18, "מומנט תכן", "DMd", "[KNm]", mathId_18(), 0));
            resultModels.add(new StructuralDesignModel(19, "תוספת  זיון לחוץ", "As'_calc", "[cm²]", mathId_19(), 0));
            resultModels.add(new StructuralDesignModel(20, "שטח חתך זיון מינימלי", "As,min", "[cm²]", mathId_20(), 0));
            resultModels.add(new StructuralDesignModel(21, "יחס איזור לחוץ/מתוח", "ω", "-", mathId_21(), 0));
            resultModels.add(new StructuralDesignModel(22, "גובה אזור לחוץ", "x", "-", mathId_22(), 0));
            resultModels.add(new StructuralDesignModel(23, "זרוע שקול כוחות", "Z", "[сm]", mathId_23(), 0));
            resultModels.add(new StructuralDesignModel(24, "שטח זיון מתוח מחושב", "As'_calc", "[cm²]", mathId_24(), 0));
            resultModels.add(new StructuralDesignModel(29, "שטח זיון מתוח בפועל", "As,act", "[cm²]", mathId_29(), 0));
            resultModels.add(new StructuralDesignModel(30, "שטח זיון לחוץ בפועל", "As',act", "[cm²]", mathId_30(), 0));
            resultModels.add(new StructuralDesignModel(31, "בדיקת שטח הזיון  המתוח בפועל מול הזיון המחושב", "As,act>As,calc", "-", mathId_31(), 0));
            resultModels.add(new StructuralDesignModel(32, "בדיקת שטח הזיון הלחוץ פועל  מול הזיון המחושב", "As,act>As,calc", "-", mathId_32(), 0));
            resultModels.add(new StructuralDesignModel(33, "בדיקת שטח הזיון  המתוח בפועל מול זיון המינימום", "As,act>As,calc", "-", mathId_33(), 0));
            resultModels.add(new StructuralDesignModel(34, "בדיקת שטח הזיון הלחוץ פועל  מול זיון המינימום", "As,act>As,calc", "-", mathId_34(), 0));
            resultModels.add(new StructuralDesignModel(35, "בדיקת שטח זיון מתוח מול מקסימום", "Asact<As,max", "-", mathId_35(), 0));
            resultModels.add(new StructuralDesignModel(36, "בדיקת שטח  זיון  לחוץ מול מקסימום", "As'act<As,max", "-", mathId_36(), 0));
            resultModels.add(new StructuralDesignModel(41, "שטח חתך", "Ag", "[cm²]", mathId_41(), 0));
            resultModels.add(new StructuralDesignModel(42, "שטח זיון אורכי", "ΣAs", "[cm²]", mathId_42(), 0));
            resultModels.add(new StructuralDesignModel(43, "מנת הזיון האורכית", "ρ", "-", mathId_43(), 0));
            resultModels.add(new StructuralDesignModel(44, "K", "", "", mathId_44(), 0));
            resultModels.add(new StructuralDesignModel(45, "מאמץ בבטון", "σcp", "[Mpa]", mathId_45(), 0));
            resultModels.add(new StructuralDesignModel(46, "תסבולת בטון ללא זיון הגזירה", "VRdc", "[KN]", mathId_46(), 0));
            resultModels.add(new StructuralDesignModel(47, "תסבולת מקסימלית לגיזרה", "VRd,max", "[KN]", mathId_47(), 0));
            resultModels.add(new StructuralDesignModel(48, "בדיקת Vd מול Vrdmax", "", "", mathId_48(), 0));
            resultModels.add(new StructuralDesignModel(49, "בדיקת Vd מול Vrdc max", "", "", mathId_49(), 0));
            Log.d("checkRelevantValue", "getRelevantValueForId(50) == " + getRelevantValueForId(50));
            resultModels.add(new StructuralDesignModel(50, "מנת זיון המינמלית לגזירה", "ρmin", "mm", getRelevantValueForId(50), 0));
            resultModels.add(new StructuralDesignModel(51, "היחס המינימלי בין שטח חתך הזיון לגזירה לבין הפסיעה", "ρmin*b=(Asv/sv)min", "mm", mathId_51(), 0));
            resultModels.add(new StructuralDesignModel(52, "היחס בין שטח חתך הזיון הדרוש המקסמלי לגזירה לבין הפסיעה", "ρmin*b=Asv/sv", "mm", mathId_52(), 0));
            resultModels.add(new StructuralDesignModel(53, "פסיעה מקסימלית בין חישוקים", "Svmax", "mm", mathId_53(), 0));
            resultModels.add(new StructuralDesignModel(54, "פסיעה מקסימלית בין ענפי חישוקים", "Svmax", "mm", mathId_54(), 0));
            resultModels.add(new StructuralDesignModel(55, "מספר ענפים מינימלי", "Svmax", "n,d", mathId_55(), 0));
            resultModels.add(new StructuralDesignModel(59, "היחס בין מספר ענפי החישוקים וקוטרם לבין הפסיעה", "(Asv_act)", "", mathId_59(), 0));
            resultModels.add(new StructuralDesignModel(60, "בדיקת כמות מינמלית של ענפים", "n,act>n,d", "-", mathId_60(), 0));
            resultModels.add(new StructuralDesignModel(61, "בדיקת שטח זיון לגזירה בפועל מול הזיון המחושב", "(Asv_act)>Asv,calc", "-", mathId_61(), 0));
            resultModels.add(new StructuralDesignModel(62, "בדיקת שטח זיון לגזירה בפועל   מול זיון המינימום", "(Asv_act)>As,min", "-", mathId_62(), 0));
            resultModels.add(new StructuralDesignModel(64, "רווח בין מוטות מתוחים", "a", "cm", mathId_64(), 0));
            resultModels.add(new StructuralDesignModel(65, "רווח בין מוטות לחוצים", "a", "cm", mathId_65(), 0));
            resultModels.add(new StructuralDesignModel(66, "בדיקת רווח תקין בין מוטות מתוחים", "a,max=3.5", "[cm]", mathId_66(), 0));
            resultModels.add(new StructuralDesignModel(67, "רווח בין מוטות לחוצים", "a,max=3.5", "[cm]", mathId_67(), 0));
            resultModels.add(new StructuralDesignModel(68, "תסבולת לגיזרה בהתחשבות זיון הגזירה", "VRd,s", "[KN]", mathId_68(), 0));
            resultModels.add(new StructuralDesignModel(69, "בדיקה תסבולת החתך", "", "", mathId_69(), 0));
//            if (isPitulSelected) {
//                resultModels.add(new StructuralDesignModel(72, "גובה מלבן", "h", "m", mathId_72(), 0));
//                resultModels.add(new StructuralDesignModel(73, "עובי מלבן", "ti", "m", mathId_73(), 0));
//                resultModels.add(new StructuralDesignModel(74, "שטח מלבן", "A", "m^2", mathId_74(), 0));
//                resultModels.add(new StructuralDesignModel(75, "עובי דופ החתך", "te", "m", mathId_75(), 0));
//                resultModels.add(new StructuralDesignModel(76, "עובי פעיל שקיל", "tr", "m", mathId_76(), 0));
//                resultModels.add(new StructuralDesignModel(77, "היקף שקול מלבן", "Uk", "m", mathId_77(), 0));
//                resultModels.add(new StructuralDesignModel(78, "שטח שקול מלבן", "Ak", "m^2", mathId_78(), 0));
//                resultModels.add(new StructuralDesignModel(79, "תסבולת החתך לפיתול", "Ak", "m^2", mathId_79(), 0));
//                resultModels.add(new StructuralDesignModel(80, "מומנט הפיתול על המלבן", "Tdi", "[KNm]", mathId_80(), 0));
//                resultModels.add(new StructuralDesignModel(81, "בדיקת אינטרקציה", "<1", "-", mathId_81(), 0));
//                resultModels.add(new StructuralDesignModel(82, "מקדם בטחון", "h", "-", getRelevantValueForId(82) + "", 0));
//                resultModels.add(new StructuralDesignModel(83, "חישוב זיון אורכי מינימלי לפיתול", "Ast,lmin", "cm^2", mathId_83() + "", 0));
//                resultModels.add(new StructuralDesignModel(84, "חישוב זיון אורכי לפיתול", "Ast,l", "cm^2", mathId_84() + "", 0));
//                resultModels.add(new StructuralDesignModel(85, "חישוב זיון חישוק מינימלי לפיתול", "Ast,lmin", "cm^2", mathId_85() + "", 0));
//                resultModels.add(new StructuralDesignModel(89, "שטח מוטות נוספים הנדרשים לקבלת כוחות פיתול", "Astl_act", "cm^4", mathId_89() + "", 0));
//                resultModels.add(new StructuralDesignModel(90, "", "בדיקה", "מנת זיון ראשי לפיתול", mathId_90() + "", 0));
//                resultModels.add(new StructuralDesignModel(93, "שטח ענף אחד בחישוק נוסף לקבלת כוחות פיתול", "astv,min", "cm^2", mathId_93() + "", 0));
//                resultModels.add(new StructuralDesignModel(94, "שטח חישור נוספים הנדרשים לקבלת כוחות פיתול", "Astl_act", "cm^4", mathId_94() + "", 0));
//                resultModels.add(new StructuralDesignModel(95, "", "בדיקה", "מנת זיון החישוק לפיתול", mathId_95() + "", 0));
//            }
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
        sqLiteDatabase.execSQL(sqlHelper.insertBT_SQL(DialogHelper.input, moduleActiveId, categoryActiveId, subCategoryActiveId,
                id_1_value, id_2_value, id_3_value, 1,1, id_4_value,
                id_5_value, id_6_value, id_10_value, id_25_value,
                id_26_value, id_27_value, id_28_value, id_39_value,
                id_40_value, id_56_value, id_57_value, id_58_value,
                id_63_value, id_70_value, id_87_value, id_88_value,
                id_91_value, id_92_value));
        new SQLRemote(QUERY_TYPE_INSERT_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", DialogHelper.input);
    }

    private void updateDB() {
        sqLiteDatabase.execSQL(sqlHelper.updateBT_SQL(
                id_1_value, id_2_value, id_3_value, 1, 1, id_4_value, id_5_value, id_6_value, id_10_value, id_25_value,
                id_26_value, id_27_value, id_28_value, id_39_value, id_40_value, id_56_value, id_57_value, id_58_value, id_63_value, id_70_value,
                id_87_value, id_88_value, id_91_value, id_92_value, savedVersionTitle, moduleActiveId, categoryActiveId, subCategoryActiveId));
        new SQLRemote(QUERY_TYPE_UPDATE_VALUES_OUTSIDE, false).execute(moduleActiveId+"", categoryActiveId +"", subCategoryActiveId +"", savedVersionTitle);
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        Log.d("changedListener", "BendingToleranceCategory{} -> valueItemNumber == " + valueItemNumber + "; id == " + valueItemId + "; numberPickerPosition == " + spinnerPosition);
        switch (valueItemId){
            case 1:
                id_1_value = valueItemNumber;
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                break;
            case 2:
                id_2_position = spinnerPosition;
                id_2_value = getConcreteTypeDoubleValues()[spinnerPosition];
                id_8_value = id_2_value;
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                Log.d("checkPickerPositions", "numberPickerPositions == " + spinnerPositionsArray);
                setRelevantResultItem_value(8, id_8_value+"", "");
                setRelevantResultItem_value(9, getRelevantValueForId(9), "");
                setRelevantResultItem_value(12, getRelevantValueForId(12), "");
                setRelevantResultItem_value(13, getRelevantValueForId(13), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, getRelevantValueForId(50), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(79, mathId_79(), "");
//                    setRelevantResultItem_value(81, mathId_81(), "");
//                    setRelevantResultItem_value(82, getRelevantValueForId(82), "");
//                    setRelevantResultItem_value(83, mathId_83(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                    setRelevantResultItem_value(93, mathId_93(), "");
//                }
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
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(54, mathId_54(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(72, mathId_72(), "");
//                    setRelevantResultItem_value(74, mathId_74(), "");
//                    setRelevantResultItem_value(75, mathId_75(), "");
//                    setRelevantResultItem_value(76, mathId_76(), "");
//                    setRelevantResultItem_value(77, mathId_77(), "");
//                    setRelevantResultItem_value(78, mathId_78(), "");
//                    setRelevantResultItem_value(79, mathId_79(), "");
//                    setRelevantResultItem_value(80, mathId_80(), "");
//                    setRelevantResultItem_value(81, mathId_81(), "");
//                    setRelevantResultItem_value(83, mathId_83(), "");
//                    setRelevantResultItem_value(84, mathId_84(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                }
                break;
            case 4:
                id_4_value = valueItemNumber;
                setRelevantResultItem_value(7,  mathId_7(), "");
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(44, mathId_44(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(53, mathId_53(), "");
                setRelevantResultItem_value(54, mathId_54(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
//                if (isPitulSelected) setRelevantResultItem_value(81, mathId_81(), "");
                break;
            case 5:
                id_5_value = valueItemNumber;
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                break;
            case 6:
                id_6_value = valueItemNumber;
                setRelevantResultItem_value(15, mathId_15(), "");
                setRelevantResultItem_value(16, mathId_16(), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(21, mathId_21(), "");
                setRelevantResultItem_value(22, mathId_22(), "");
                setRelevantResultItem_value(23, mathId_23(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(41, mathId_41(), "");
                setRelevantResultItem_value(43, mathId_43(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(47, mathId_47(), "");
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(55, mathId_55(), "");
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(73, mathId_73(), "");
//                    setRelevantResultItem_value(74, mathId_74(), "");
//                    setRelevantResultItem_value(76, mathId_76(), "");
//                    setRelevantResultItem_value(77, mathId_77(), "");
//                    setRelevantResultItem_value(78, mathId_78(), "");
//                    setRelevantResultItem_value(79, mathId_79(), "");
//                    setRelevantResultItem_value(80, mathId_80(), "");
//                    setRelevantResultItem_value(81, mathId_81(), "");
//                    setRelevantResultItem_value(83, mathId_83(), "");
//                    setRelevantResultItem_value(84, mathId_84(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                    setRelevantResultItem_value(93, mathId_93(), "");
//                }

                break;
            case 10:
                id_10_position = spinnerPosition;
                id_10_value = Double.parseDouble(getFrom_400_to_500_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(11, getRelevantValueForId(11), "");
                setRelevantResultItem_value(13, getRelevantValueForId(13), "");
                setRelevantResultItem_value(14, getRelevantValueForId(14), "");
                setRelevantResultItem_value(17, mathId_17(), "");
                setRelevantResultItem_value(18, mathId_18(), "");
                setRelevantResultItem_value(19, mathId_19(), "");
                setRelevantResultItem_value(20, mathId_20(), "");
                setRelevantResultItem_value(24, mathId_24(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(50, getRelevantValueForId(50), "");
                setRelevantResultItem_value(51, mathId_51(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(84, mathId_84(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                }
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_9_value == " + id_9_value + "; id_11_value == " + id_11_value);
                break;
            case 25:
                id_25_position = spinnerPosition;
                id_25_value = Double.parseDouble(getFrom_2_to_9_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(43, mathId_43(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_25_value == " + id_25_value);
                break;
            case 26:
                id_26_position = spinnerPosition;
                id_26_value = Double.parseDouble(getFrom_2_to_9_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_26_value == " + id_26_value);
                break;
            case 27:
                id_27_position = spinnerPosition;
                id_27_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(29, mathId_29(), "");
                setRelevantResultItem_value(31, mathId_31(), "");
                setRelevantResultItem_value(33, mathId_33(), "");
                setRelevantResultItem_value(35, mathId_35(), "");
                setRelevantResultItem_value(36, mathId_36(), "");
                setRelevantResultItem_value(42, mathId_42(), "");
                setRelevantResultItem_value(43, mathId_43(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_27_value == " + id_27_value);
                break;
            case 28:
                id_28_position = spinnerPosition;
                id_28_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_28_value == " + id_28_value);
                setRelevantResultItem_value(30, mathId_30(), "");
                setRelevantResultItem_value(32, mathId_32(), "");
                setRelevantResultItem_value(34, mathId_34(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(67, mathId_67(), "");
                break;
            case 39:
                id_39_value = valueItemNumber;
                setRelevantResultItem_value(45, mathId_45(), "");
                setRelevantResultItem_value(46, mathId_46(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_39_value == " + id_39_value);
                break;
            case 40:
                id_40_value = valueItemNumber;
                setRelevantResultItem_value(48, mathId_48(), "");
                setRelevantResultItem_value(49, mathId_49(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                setRelevantResultItem_value(52, mathId_52(), "");
//                if (isPitulSelected) setRelevantResultItem_value(81, mathId_81(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_40_value == " + id_40_value);
                break;
            case 56:
                id_56_value = valueItemNumber;
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_56_value == " + id_56_value);
                break;
            case 57:
                id_57_position = spinnerPosition;
                id_57_value = Double.parseDouble(getFrom_2_to_10_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(60, mathId_60(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_57_value == " + id_57_value);
                break;
            case 58:
                id_58_position = spinnerPosition;
                id_58_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
                setRelevantResultItem_value(59, mathId_59(), "");
                setRelevantResultItem_value(61, mathId_61(), "");
                setRelevantResultItem_value(62, mathId_62(), "");
                setRelevantResultItem_value(68, mathId_68(), "");
                setRelevantResultItem_value(69, mathId_69(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_58_value == " + id_58_value);
                break;
            case 63:
                id_63_value = valueItemNumber;
                setRelevantResultItem_value(64, mathId_64(), "");
                setRelevantResultItem_value(65, mathId_65(), "");
                setRelevantResultItem_value(66, mathId_66(), "");
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(76, mathId_76(), "");
//                    setRelevantResultItem_value(77, mathId_77(), "");
//                    setRelevantResultItem_value(78, mathId_78(), "");
//                    setRelevantResultItem_value(79, mathId_79(), "");
//                    setRelevantResultItem_value(81, mathId_81(), "");
//                    setRelevantResultItem_value(84, mathId_84(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                    setRelevantResultItem_value(93, mathId_93(), "");
//                }
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_63_value == " + id_63_value);
                break;
            case 70:
                id_70_value = valueItemNumber;
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(80, mathId_80(), "");
//                    setRelevantResultItem_value(81, mathId_81(), "");
//                    setRelevantResultItem_value(84, mathId_84(), "");
//                    setRelevantResultItem_value(85, mathId_85(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                }
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_70_value == " + id_70_value);
                break;
            case 87:
                id_87_value = valueItemNumber;
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(89, mathId_89(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                }
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_87_value == " + id_87_value);
                break;
            case 88:
                id_88_position = spinnerPosition;
                id_88_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
//                if (isPitulSelected) {
//                    setRelevantResultItem_value(89, mathId_89(), "");
//                    setRelevantResultItem_value(90, mathId_90(), "");
//                }
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_88_value == " + id_88_value);
                break;
            case 91:
                id_91_value = valueItemNumber;
//                if (isPitulSelected) setRelevantResultItem_value(93, mathId_93(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_91_value == " + id_91_value);
                break;
            case 92:
                id_92_position = spinnerPosition;
                id_92_value = Double.parseDouble(getFrom_8_to_25_stringValues()[spinnerPosition]);
                spinnerPositionsArray.put(valueItemId, spinnerPosition);
//                if (isPitulSelected) setRelevantResultItem_value(94, mathId_94(), "");
                Log.d("numberChangedListener", "valueNumberChangedListener() -> id_92_value == " + id_92_value);
                break;
        }
    }

    public void setAllAdapters() {
        setAdapter(true, initModels(true));
        setAdapter(false, initModels(false));
    }

}

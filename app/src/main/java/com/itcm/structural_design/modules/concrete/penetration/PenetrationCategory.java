package com.itcm.structural_design.modules.concrete.penetration;

import android.util.ArrayMap;
import android.util.Log;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;

public class PenetrationCategory extends SubCategoriesManagerActivity {

    public PenetrationCategory_SubCategoryOne subCategoryOne;
    public PenetrationCategory_SubCategoryTwo subCategoryTwo;
    public PenetrationCategory_SubCategoryThree subCategoryThree;
    public PenetrationCategory_SubCategoryFour subCategoryFour;
    public PenetrationCategory_SubCategoryFive subCategoryFive;
    public PenetrationCategory_SubCategorySix subCategorySix;
    public PenetrationCategory_SubCategorySeven subCategorySeven;
    public String[] from_2_to_24_stringValues, from_7_5_to_20_stringValues,scopeNumbers_stringValues, from_45_to_90_stringValues, from_1_4_to_1_5_stringValues, from_1_15_to_1_15_stringValues;
    private double[] from_1_4_to_1_5_doubleValues;
    public PenetrationCategory(){
        initAllArrays();
        initSpinnerPositions();
    }

    private void initSpinnerPositions() {
        spinnerPositionsArray = new ArrayMap<>();
        spinnerPositionsArray.put(9,0);
        spinnerPositionsArray.put(10,0);
        spinnerPositionsArray.put(15,0);
        spinnerPositionsArray.put(16,0);
        spinnerPositionsArray.put(22,0);
        spinnerPositionsArray.put(23,0);
        spinnerPositionsArray.put(36,0);
        spinnerPositionsArray.put(43,0);
        spinnerPositionsArray.put(62,0);
        spinnerPositionsArray.put(69,0);
        spinnerPositionsArray.put(4000,0);
    }

    public void resetValues() {
        id_1_value = 1; id_2_value = 1; id_3_value = 1; id_108_value = 1; id_9_value = 7.5; id_10_value = 8; id_15_value = 7.5; id_16_value = 8;
        id_22_value = 30; id_23_value = 400; id_24_value = 1; id_25_value = 1.15; id_26_value = 30; id_36_value = 8; id_38_value = 1; id_41_value = 1;
        id_43_value = 45;id_45_value = 1; id_62_value = 8; id_63_value = 1; id_66_value = 1; id_100_value = 1; id_101_value = 1; id_103_value = 1;
        id_104_value = 1; id_105_value = 1; id_106_value = 1; id_107_value = 1;
        id_9_position = 0; id_10_position = 0; id_15_position = 0; id_16_position = 0; id_22_position = 1; id_23_position = 0; id_25_position = 0;
        id_36_position = 0;id_43_position = 0; id_62_position = 0; id_69_position = 0;id_4001_position = 0; id_4002_position = 0; id_4003_position = 0;
        id_4004_position = 0; id_4005_position = 0; id_4006_position = 0; id_4007_position = 0; id_4008_position = 0; id_4009_position = 0;
        id_4010_position = 0;id_4001_value = 2; id_4002_value= 2; id_4003_value = 2; id_4004_value = 2; id_4005_value = 2; id_4006_value = 2;
        id_4007_value = 2; id_4008_value = 2; id_4009_value = 2; id_4010_value = 2;
    }

    public void initAllArrays() {
        from_2_to_24_stringValues = new String[]{"2","4","6","16","18","20","22","24"};
        scopeNumbers_stringValues = new String[]{"ראשון","שני","שלישי","רביעי","חמישי","שישי","שביעי","שמיני","תשיעי","עשירי"};
        from_7_5_to_20_stringValues = new String[]{"7.5","10","12","15","18","20"};
        from_45_to_90_stringValues = new String[]{"45","90"};
        from_1_4_to_1_5_stringValues = new String[]{"1.4","1.5"};
        from_1_4_to_1_5_doubleValues = new double[]{1.4,1.5};
        from_1_15_to_1_15_stringValues = new String[]{"1.15"};
    }

    public String[] getFrom_1_4_to_1_5_stringValues(){ return from_1_4_to_1_5_stringValues; }
    public double[] getFrom_1_4_to_1_5_doubleValues(){ return from_1_4_to_1_5_doubleValues; }
    public String[] getFrom_1_15_to_1_15_stringValues(){ return from_1_15_to_1_15_stringValues; }
    public String[] getFrom_2_to_24_stringValues(){ return from_2_to_24_stringValues; }
    public String[] getFrom_7_5_to_20_stringValues(){ return from_7_5_to_20_stringValues; }
    public String[] getFrom_45_to_90_stringValues(){ return from_45_to_90_stringValues; }
    public String[] getScopeNumbers_stringValues(){ return scopeNumbers_stringValues; }

    public void initSubcategory(){
        switch (subCategoryActiveId){
            case 0:
                subCategoryOne = new PenetrationCategory_SubCategoryOne();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryOne.tonOrKnBtnClicked();
                break;
            case 1:
                subCategoryTwo = new PenetrationCategory_SubCategoryTwo();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryTwo.tonOrKnBtnClicked();
                break;
            case 2:
                subCategoryThree = new PenetrationCategory_SubCategoryThree();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryThree.tonOrKnBtnClicked();
                break;
            case 3:
                subCategoryFour = new PenetrationCategory_SubCategoryFour();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryFour.tonOrKnBtnClicked();
                break;
            case 4:
                subCategoryFive = new PenetrationCategory_SubCategoryFive();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryFive.tonOrKnBtnClicked();
                break;
            case 5:
                subCategorySix = new PenetrationCategory_SubCategorySix();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategorySix.tonOrKnBtnClicked();
                break;
            case 6:
                subCategorySeven = new PenetrationCategory_SubCategorySeven();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategorySeven.tonOrKnBtnClicked();
                break;
        }
    }

    public int get_4000_relevantPosition() {
        switch (id_69_position){
            case 0:
                return id_4001_position;
            case 1:
                return id_4002_position;
            case 2:
                return id_4003_position;
            case 3:
                return id_4004_position;
            case 4:
                return id_4005_position;
            case 5:
                return id_4006_position;
            case 6:
                return id_4007_position;
            case 7:
                return id_4008_position;
            case 8:
                return id_4009_position;
            case 9:
                return id_4010_position;
        }
        return 0;
    }

    public void set_4000_valueAndPosition(int position){
        switch (id_69_position){
            case 0:
                id_4001_position = position;
                id_4001_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 1:
                id_4002_position = position;
                id_4002_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 2:
                id_4003_position = position;
                id_4003_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 3:
                id_4004_position = position;
                id_4004_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);

                break;
            case 4:
                id_4005_position = position;
                id_4005_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 5:
                id_4006_position = position;
                id_4006_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 6:
                id_4007_position = position;
                id_4007_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 7:
                id_4008_position = position;
                id_4008_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 8:
                id_4009_position = position;
                id_4009_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
            case 9:
                id_4010_position = position;
                id_4010_value = Double.parseDouble(getFrom_2_to_24_stringValues()[position]);
                break;
        }
    }

    public void insertOrUpdateVersion(boolean isForInsert) {
        switch (subCategoryActiveId){
            case 0:
                subCategoryOne.insertOrUpdateVersion(isForInsert);
                break;
            case 1:
                subCategoryTwo.insertOrUpdateVersion(isForInsert);
                break;
            case 2:
                subCategoryThree.insertOrUpdateVersion(isForInsert);
                break;
            case 3:
                subCategoryFour.insertOrUpdateVersion(isForInsert);
                break;
            case 4:
                subCategoryFive.insertOrUpdateVersion(isForInsert);
                break;
            case 5:
                subCategorySix.insertOrUpdateVersion(isForInsert);
                break;
            case 6:
                subCategorySeven.insertOrUpdateVersion(isForInsert);
                break;
        }
    }
    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (subCategoryActiveId){
            case 0:
                subCategoryOne.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 1:
                subCategoryTwo.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 2:
                subCategoryThree.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 3:
                subCategoryFour.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 4:
                subCategoryFive.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 5:
                subCategorySix.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 6:
                subCategorySeven.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
        }
    }


    public String mathId_4() { return id_1_value > 16 ? context.getString(R.string.proper_ceiling_height) : context.getString(R.string.not_proper_ceiling_height); }

    public String mathId_5() {
        id_5_value = id_1_value - id_2_value;
        Log.d("checkMath", "mathId_5 -> id_5_value == " + id_5_value +"; id_1_value == " + id_1_value +"; id_2_value == " + id_2_value);
        return formatNumberDecimal(id_5_value);
    }

    public String mathId_6() {
        id_6_value = id_1_value - id_3_value;
        Log.d("checkMath", "mathId_6 -> id_6_value == " + id_6_value +"; id_1_value == " + id_1_value +"; id_3_value == " + id_3_value);
        return formatNumberDecimal(id_6_value);
    }
    public String mathId_7() {
        id_7_value = (id_6_value + id_5_value) * 0.5;
        Log.d("checkMath", "mathId_7 -> id_7_value == " + id_7_value +"; id_6_value == " + id_6_value +"; id_5_value == " + id_5_value);
        return formatNumberDecimal(id_7_value);
    }

    public String mathId_11() { return mathConcatenate(id_10_value, id_9_value); }

    public String mathId_12() {
        id_12_value = (Math.PI * Math.pow(id_10_value,2)) / 4 * (100 / id_9_value) * 0.01;
        Log.d("checkMath", "mathId_12 -> id_12_value == " + id_12_value +"; id_10_value == " + id_10_value +"; id_9_value == " + id_9_value);
        return formatNumberDecimal(id_12_value);
    }

    public String mathId_13() {
        try {
            id_13_value = id_12_value / (100 * id_5_value);
            Log.d("checkMath", "mathId_13 -> id_13_value == " + id_13_value +"; id_12_value == " + id_12_value +"; id_5_value == " + id_5_value);
            if (Double.isNaN(id_13_value)) throw new NumberFormatException(NaN);
            if (id_13_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(INFINITY);
            return formatNumberDecimal(id_13_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_13 -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_14() {
        try {
            if (Double.isNaN(id_13_value)) throw new NumberFormatException(NaN);
            return id_13_value >= 0.005 ? context.getString(R.string.armament_dose_is_enough) : context.getString(R.string.armament_dose_is_not_enough);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_14 -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_17() { return mathConcatenate(id_16_value, id_15_value); }

    public String mathId_18() {
        id_18_value = (Math.PI * Math.pow(id_16_value, 2)) / 4 * (100 / id_15_value) * 0.01;
        return formatNumberDecimal(id_18_value)+"";
    }

    public String mathId_19() {
        try {
            id_19_value = id_18_value / (100 * id_6_value);
            if (id_19_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(INFINITY);
            id_19_value_string = formatNumberDecimal(id_19_value)+"";
            Log.d("checkMath", "mathId_19 -> id_19_value == " + id_19_value +"; id_18_value == " + id_18_value +"; id_6_value == " + id_6_value);
        } catch (NumberFormatException e){
            id_19_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_19 -> EXCEPTION -> id_19_value_string == " + id_19_value_string);
        }
        return id_19_value_string;
    }

    public String mathId_20() {
        if (id_19_value_string.equals(context.getString(R.string.not_valid_cut))){
            return context.getString(R.string.not_valid_cut);
        }
        return id_19_value >= 0.005 ? context.getString(R.string.armament_dose_is_enough) : context.getString(R.string.armament_dose_is_not_enough);
    }

    public String mathId_21() {
        try {
            id_21_value = (id_13_value + id_19_value) * 0.5;
            if (id_21_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(INFINITY);
            id_21_value_string = formatNumberDecimal(id_21_value)+"";
        } catch (NumberFormatException e){
            id_21_value_string = context.getString(R.string.not_valid_cut);
        }
        return id_21_value_string;
    }

    public String mathId_27() {
        switch (convertDoubleToInt(id_22_value)){
            case 30:
                id_27_value = 13;
                break;
            case 40:
                id_27_value = 17.4;
                break;
            case 50:
                id_27_value = 21.7;
                break;
            case 60:
                id_27_value = 26;
                break;
            case 20:
            default:
                id_27_value = 8.7;
                break;
        }
        return id_27_value+"";
    }

    public String mathId_28() {
        id_28_value = id_23_value == 400 ? 350 : 435;
        return id_28_value+"";
    }

    public String mathId_29() {
        id_29_value = id_24_value * id_25_value;
        Log.d("checkMath", "mathId_29 -> id_29_value == " + id_29_value +"; id_24_value == " + id_24_value +"; id_25_value == " + id_25_value);
        return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_29_value)))+"";
    }

    public String mathId_30() {
        try {
            if (id_7_value == 0){
                return context.getString(R.string.not_valid_cut);
            }
            id_30_value = 1 + Math.pow((200 / (10 * id_7_value)), 0.5) > 2 ? 2 : 1 + Math.pow((200 / (10 * id_7_value)), 0.5);
            Log.d("checkMath", "mathId_30 -> id_30_value == " + id_30_value +"; id_7_value == " + id_7_value);
            if (Double.isNaN(id_30_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_30_value)+"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_30 -> EXCEPTION! -> id_30_value == " + id_30_value +"; id_7_value == " + id_7_value);
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_31(double v) {
        id_31_value = id_108_value + (2 * (2 * Math.PI * id_7_value)) * v;
        Log.d("checkMath", "mathId_31 -> id_31_value == " + id_31_value +"; id_108_value == " + id_108_value +"; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_31_value)+"";
    }

    public String mathId_32() {
        try {
            id_32_value = Math.max(((0.12 * id_30_value * (Math.pow((100 * id_21_value * 0.7 * id_26_value), (1.0/3.0)))) * (id_31_value * id_7_value)), (0.035 * id_30_value * (3.0/2.0) * (Math.pow((0.7 * id_26_value), 0.5))) * (id_31_value * id_7_value)) / 10;
            Log.d("checkMath", "mathId_32 -> id_32_value == " + id_32_value +"; id_7_value == " + id_7_value +"; id_30_value == " + id_30_value +"; id_21_value == " + id_21_value +"; id_26_value == " + id_26_value +"; id_31_value == " + id_31_value);
            return Double.isNaN(id_32_value) ? context.getString(R.string.not_valid_cut) : formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_32_value)))+"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_32 -> EXCEPTION! -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_33() {
        if (Double.isNaN(id_32_value)){
            return context.getString(R.string.not_valid_cut);
        }
        return id_32_value < id_29_value ? context.getString(R.string.armament_penetration_required) : context.getString(R.string.armament_penetration_not_required);
    }

    public String mathId_34() {
        try {
            id_34_value = Math.min(0.3 * (1 - (0.7 * id_26_value / 250)) * id_27_value * id_108_value * 10 * id_7_value * 10,1.5 * id_32_value);
            Log.d("checkMath", "mathId_34 -> id_26_value == " + id_26_value +"; id_27_value == " + id_27_value +"; id_108_value == " + id_108_value +"; id_7_value == " + id_7_value +"; id_32_value == " + id_32_value);
            return Double.isNaN(id_34_value) ? context.getString(R.string.not_valid_cut) : formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_34_value)));
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_34 -> EXCEPTION! -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_35() {
        try {
            Log.d("checkMath", "mathId_35() -> id_34_value == " + id_34_value +"; id_29_value == " + id_29_value);
            if (Double.isNaN(id_34_value) || Double.isNaN(id_29_value)) throw new NumberFormatException(NaN);
            return id_34_value > id_29_value ? context.getString(R.string.cut_is_proper_possible_to_plan_penetration) : context.getString(R.string.concrete_cut_is_not_enough);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_35 -> EXCEPTION! -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_37() {
        id_37_value = id_7_value * 0.75;
        return formatNumberDecimal(id_37_value)+"";
    }

    public String mathId_39() {
        Log.d("checkMath", "mathId_39() -> id_38_value == " + id_38_value +"; id_7_value == " + id_7_value);
        return id_38_value <= id_7_value ? context.getString(R.string.radial_distance_is_proper) : context.getString(R.string.radial_distance_is_not_proper);
    }

    public String mathId_40() {
        id_40_value = id_7_value * 1.5;
        return formatNumberDecimal(id_40_value)+"";
    }

    public String mathId_42() {
        return id_41_value < id_7_value ? context.getString(R.string.tangential_distance_is_proper) : context.getString(R.string.tangential_distance_is_not_proper);
    }

    public String mathId_44() {
        id_44_value = id_7_value * 2;
        return formatNumberDecimal(id_44_value)+"";
    }

    public String mathId_46() {
        return id_45_value < id_7_value ? context.getString(R.string.tangential_distance_is_proper) : context.getString(R.string.tangential_distance_is_not_proper);
    }

    public String mathId_47() {
        id_47_value = Math.max(0.1 * Math.pow(0.7 * id_26_value, 0.5) / id_23_value, 0.001);
        return formatNumberDecimal(id_47_value)+"";
    }

    public String mathId_48() {
        try {
            id_48_value = (((Math.PI * Math.pow(id_36_value, 2)) / 4)) / (id_38_value * id_41_value * 100 * Math.sin(Math.toRadians(id_43_value)));
            Log.d("checkMath", "mathId_48 -> id_48_value == " + id_48_value + "; id_36_value == " + id_36_value + "; id_38_value == " + id_38_value + "; id_41_value == " + id_41_value + "; id_43_value == " + id_43_value);
            id_48_value_string = Double.isNaN(id_48_value) ? context.getString(R.string.not_valid_cut) : formatNumberDecimal(id_48_value)+"";
        } catch (NumberFormatException e){
            id_48_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_48 -> EXCEPTION! -> id_48_value_string == " + id_48_value_string +"; id_34_value == " + id_34_value +"; id_7_value == " + id_7_value);
        }
        return id_48_value_string;
    }

    public String mathId_49() {
        Log.d("checkMath", "mathId_49 -> id_48_value == " + id_48_value +"; id_47_value == " + id_47_value);
        return id_48_value > id_47_value ? context.getString(R.string.armament_amount_for_penetration_is_enough) : context.getString(R.string.armament_amount_for_penetration_is_not_enough);
    }

    public String mathId_50() {
        try {
            secondMathPart = id_37_value * id_47_value;
            if (secondMathPart == 0) {
                id_50_value = Double.NaN;
                throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            }
            firstMathPart = (Math.PI * Math.pow(id_36_value / 10, 2)) / 4;
            id_50_value =  firstMathPart / secondMathPart;
            Log.d("checkMath", "mathId_50() -> id_50_value == " + id_50_value +"; id_36_value == " + id_36_value + "; id_37_value == " + id_37_value + "; id_47_value == " + id_47_value);
            if (Double.isNaN(id_50_value)) {throw new NumberFormatException(NaN);}
            return formatNumberDecimal(id_50_value)+"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_50() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }
    public String mathId_51() {
        try {
            secondMathPart = id_37_value * id_47_value;
            if (secondMathPart == 0) {
                id_51_value = Double.NaN;
                throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            }
            firstMathPart = (Math.PI * Math.pow(id_36_value / 10, 2) / 4);
            id_51_value = firstMathPart / secondMathPart;
            Log.d("checkMath", "mathId_51() -> id_51_value == " + id_51_value +"; id_36_value == " + id_36_value + "; id_37_value == " + id_37_value + "; id_47_value == " + id_47_value + "; id_41_value == " + id_41_value + "; Double.isNaN(id_51_value) == " + Double.isNaN(22));
            if (Double.isNaN(id_51_value)) throw new NumberFormatException(NaN);
            return id_41_value < id_51_value ? context.getString(R.string.tangential_distance_is_proper) : context.getString(R.string.tangential_distance_is_not_proper);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_51() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_52() {
        try {
            id_52_value = id_29_value - 0.75 * id_32_value;
            Log.d("checkMath", "mathId_52() -> id_52_value == " + id_52_value +"; id_29_value == " + id_29_value + "; id_32_value == " + id_32_value);
            if (Double.isNaN(id_52_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_52_value)));
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_52() -> EXCEPTION -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_53() {
        id_53_value = Math.min((250 + 0.25 * id_7_value * 10), id_28_value);
        return formatNumberDecimal(id_53_value)+"";
    }

    public String mathId_54() {
        try {
            firstMathPart = id_52_value * (id_38_value * 10);
            secondMathPart = 1.5 * id_53_value * id_7_value * Math.sin(Math.toRadians(id_43_value));
            id_54_value = firstMathPart / secondMathPart;
            Log.d("checkMath", "mathId_54 -> id_48_value == " + id_48_value +"; id_36_value == " + id_36_value);
            id_54_value_string = Double.isNaN(id_54_value) ? context.getString(R.string.not_valid_cut) : formatNumberDecimal(id_54_value)+"";
        } catch (NumberFormatException e){
            id_54_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_54 -> EXCEPTION! -> id_52_value_string == " + id_52_value_string +"; id_34_value == " + id_34_value +"; id_7_value == " + id_7_value);
        }
        return id_54_value_string;
    }

    public String mathId_55() {
        try {
            id_55_value = (id_29_value * id_31_value) / id_32_value;
            Log.d("checkMath", "mathId_55 -> id_55_value == " + id_55_value +"; id_29_value == " + id_29_value +"; id_31_value == " + id_31_value +"; id_32_value == " + id_32_value);
            if(id_55_value == Double.POSITIVE_INFINITY) throw new NumberFormatException(INFINITY);
            if(Double.isNaN(id_55_value)) throw new NumberFormatException(NaN);
            if (id_32_value == 0) {
                id_55_value = Double.NaN;
                throw new NumberFormatException(NaN);
            }
            return formatNumberDecimal(id_55_value);
        } catch (NumberFormatException e){
            id_55_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_56() {
        try {
            id_56_value = id_55_value - id_108_value;
            Log.d("checkMath", "mathId_56 -> id_55_value == " + id_55_value +"; v == " + id_108_value);
            if (Double.isNaN(id_56_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_56_value);
        } catch (NumberFormatException e){
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_57() {
        id_57_value = id_7_value * 0.5;
        Log.d("checkMath", "mathId_57 -> id_57_value == " + id_57_value +"; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_57_value)+"";
    }

    public String mathId_58(double v) {
        try {
            id_58_value = (id_31_value - id_108_value) / (v * Math.PI);
            id_58_value_string = formatNumberDecimal(id_58_value)+"";
            if (Double.isNaN(id_58_value)) throw new NumberFormatException(NaN);
        } catch (NumberFormatException e){
            id_58_value_string = context.getString(R.string.not_valid_cut);
        }
        return id_58_value_string;
    }

    public String mathId_59(double v) {
        try {
            id_59_value = (id_55_value - id_108_value) / (v * Math.PI);
            if (Double.isNaN(id_59_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_59_value)+"";
        } catch (NumberFormatException e){
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_60() {
        try {
            id_60_value = id_59_value - 1.5 * id_7_value;
            if (Double.isNaN(id_60_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_60_value)+"";
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public String mathId_61() {
        try {
            id_61_value = id_29_value * 10 / id_28_value;
            if (Double.isNaN(id_61_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_61_value)+"";
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public String mathId_64() {
        try {
            id_64_value = (((Math.PI * Math.pow(id_62_value / 10, 2)) / 4) * id_63_value * 2);
            Log.d("checkMath", "mathId_64 -> id_64_value == " + id_64_value +"; id_62_value == " + id_62_value +"; id_63_value == " + id_63_value);
            if (Double.isNaN(id_64_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_64_value)+"";
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_54 -> EXCEPTION! -> " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_65() {
        return id_64_value > id_61_value / 2 ? context.getString(R.string.armament_dose_is_enough) : context.getString(R.string.armament_dose_is_not_enough);
    }

    public String mathId_67() {
        try {
            id_67_value = ((Math.PI * Math.pow(id_62_value / 10, 2)) / 4) * id_66_value * 2;
            if (Double.isNaN(id_67_value)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(id_67_value)+"";
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public String mathId_68() {
        return id_67_value > id_61_value / 2 ? context.getString(R.string.armament_dose_is_enough) : context.getString(R.string.armament_dose_is_not_enough);
    }

    private double getMathId_1000(double value){ return value + id_38_value; }
    public String mathId_1000() {
        double numberForReturn = 0;
        try {
            switch (id_69_position){
                case 0:
                    id_1001_value = 0.5 * id_7_value;
                    numberForReturn = id_1001_value;
                    break;
                case 1:
                    id_1002_value = getMathId_1000(id_1001_value);
                    numberForReturn = id_1002_value;
                    break;
                case 2:
                    id_1003_value = getMathId_1000(id_1002_value);
                    numberForReturn = id_1003_value;
                    break;
                case 3:
                    id_1004_value = getMathId_1000(id_1003_value);
                    numberForReturn = id_1004_value;
                    break;
                case 4:
                    id_1005_value = getMathId_1000(id_1004_value);
                    numberForReturn = id_1005_value;
                    break;
                case 5:
                    id_1006_value = getMathId_1000(id_1005_value);
                    numberForReturn = id_1006_value;
                    break;
                case 6:
                    id_1007_value = getMathId_1000(id_1006_value);
                    numberForReturn = id_1007_value;
                    break;
                case 7:
                    id_1008_value = getMathId_1000(id_1007_value);
                    numberForReturn = id_1008_value;
                    break;
                case 8:
                    id_1009_value = getMathId_1000(id_1008_value);
                    numberForReturn = id_1009_value;
                    break;
                case 9:
                    id_1010_value = getMathId_1000(id_1009_value);
                    numberForReturn = id_1010_value;
                    break;
            }
            if (Double.isNaN(numberForReturn)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(numberForReturn);
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    private double getMathId_2000(double v1, double v2){
        Log.d("checkMath", "mathId_2000() -> id_108_value == " + id_108_value + "; v1 == " + v1 + "; v2 == " + v2 + "; result == " + (id_108_value + 2 * Math.PI * v1 * v2));
        return id_108_value + 2 * Math.PI * v1 * v2;
    }
    public String mathId_2000(double v2) {
        double numberForReturn = 0;
        try {
            switch (id_69_position){
                case 0:
                    id_2001_value = getMathId_2000(id_1001_value, v2);
                    numberForReturn = id_2001_value;
                    break;
                case 1:
                    id_2002_value = getMathId_2000(id_1002_value, v2);
                    numberForReturn = id_2002_value;
                    break;
                case 2:
                    id_2003_value = getMathId_2000(id_1003_value, v2);
                    numberForReturn = id_2003_value;
                    break;
                case 3:
                    id_2004_value = getMathId_2000(id_1004_value, v2);
                    numberForReturn = id_2004_value;
                    break;
                case 4:
                    id_2005_value = getMathId_2000(id_1005_value, v2);
                    numberForReturn = id_2005_value;
                    break;
                case 5:
                    id_2006_value = getMathId_2000(id_1006_value, v2);
                    numberForReturn = id_2006_value;
                    break;
                case 6:
                    id_2007_value = getMathId_2000(id_1007_value, v2);
                    numberForReturn = id_2007_value;
                    break;
                case 7:
                    id_2008_value = getMathId_2000(id_1008_value, v2);
                    numberForReturn = id_2008_value;
                    break;
                case 8:
                    id_2009_value = getMathId_2000(id_1009_value, v2);
                    numberForReturn = id_2009_value;
                    break;
                case 9:
                    id_2010_value = getMathId_2000(id_1010_value, v2);
                    numberForReturn = id_2010_value;
                    break;
            }
            if (Double.isNaN(numberForReturn)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(numberForReturn);
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    private double getMathId_3000(double v1){
        Log.d("checkMath", "mathId_3000 -> v1 == " + v1 +"; id_31_value == " + id_31_value +"; id_45_value == " + id_45_value +"; id_41_value == " + id_41_value +"; (v1 / id_45_value) == " + (v1 / id_45_value) + "; (v1 / id_41_value) == " + (v1 / id_41_value));
        return v1 <= id_31_value ? mathEven(mathEven(v1 / id_45_value) / 2) : mathEven(mathEven(v1 / id_41_value) / 2);
    }
    public String mathId_3000() {
        double numberForReturn = 0;
        try {
            switch (id_69_position){
                case 0:
                    id_3001_value = getMathId_3000(id_2001_value);
                    numberForReturn = id_3001_value;
                    break;
                case 1:
                    id_3002_value = getMathId_3000(id_2002_value);
                    numberForReturn = id_3002_value;
                    break;
                case 2:
                    id_3003_value = getMathId_3000(id_2003_value);
                    numberForReturn = id_3003_value;
                    break;
                case 3:
                    id_3004_value = getMathId_3000(id_2004_value);
                    numberForReturn = id_3004_value;
                    break;
                case 4:
                    id_3005_value = getMathId_3000(id_2005_value);
                    numberForReturn = id_3005_value;
                    break;
                case 5:
                    id_3006_value = getMathId_3000(id_2006_value);
                    numberForReturn = id_3006_value;
                    break;
                case 6:
                    id_3007_value = getMathId_3000(id_2007_value);
                    numberForReturn = id_3007_value;
                    break;
                case 7:
                    id_3008_value = getMathId_3000(id_2008_value);
                    numberForReturn = id_3008_value;
                    break;
                case 8:
                    id_3009_value = getMathId_3000(id_2009_value);
                    numberForReturn = id_3009_value;
                    break;
                case 9:
                    id_3010_value = getMathId_3000(id_2010_value);
                    numberForReturn = id_3010_value;
                    break;
            }
            Log.d("checkMath", "mathId_3000 -> numberForReturn == " + numberForReturn);
            if (Double.isNaN(numberForReturn)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(numberForReturn);
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public String mathId_5000() {
        try {
            switch (id_69_position){
                case 0:
                    return id_4001_value >= id_3001_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 1:
                    return id_4002_value >= id_3002_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 2:
                    return id_4003_value >= id_3003_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 3:
                    return id_4004_value >= id_3004_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 4:
                    return id_4005_value >= id_3005_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 5:
                    return id_4006_value >= id_3006_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 6:
                    return id_4007_value >= id_3007_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 7:
                    return id_4008_value >= id_3008_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 8:
                    return id_4009_value >= id_3009_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
                case 9:
                    return id_4010_value >= id_3010_value ? context.getString(R.string.amount_of_branches_is_proper) : context.getString(R.string.amount_of_branches_is_not_proper);
            }
            return null;
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public double getMathId_6000(double value){
        Log.d("checkMath", "getMathId_6000() -> value == " + value + "; id_36_value == " + id_36_value);
        return ((Math.PI * Math.pow(id_36_value / 10, 2)) / 4) * value * 2;
    }

    public String mathId_6000() {
        double numberForReturn = 0;
        try {
            switch (id_69_position){
                case 0:
                    id_6001_value = getMathId_6000(id_4001_value);
                    numberForReturn = id_6001_value;
                    break;
                case 1:
                    id_6002_value = getMathId_6000(id_4002_value);
                    numberForReturn = id_6002_value;
                    break;
                case 2:
                    id_6003_value = getMathId_6000(id_4003_value);
                    numberForReturn = id_6003_value;
                    break;
                case 3:
                    id_6004_value = getMathId_6000(id_4004_value);
                    numberForReturn = id_6004_value;
                    break;
                case 4:
                    id_6005_value = getMathId_6000(id_4005_value);
                    numberForReturn = id_6005_value;
                    break;
                case 5:
                    id_6006_value = getMathId_6000(id_4006_value);
                    numberForReturn = id_6006_value;
                    break;
                case 6:
                    id_6007_value = getMathId_6000(id_4007_value);
                    numberForReturn = id_6007_value;
                    break;
                case 7:
                    id_6008_value = getMathId_6000(id_4008_value);
                    numberForReturn = id_6008_value;
                    break;
                case 8:
                    id_6009_value = getMathId_6000(id_4009_value);
                    numberForReturn = id_6009_value;
                    break;
                case 9:
                    id_6010_value = getMathId_6000(id_4010_value);
                    numberForReturn = id_6010_value;
                    break;
            }
            Log.d("checkMath", "MathId_6000() -> numberForReturn == " + numberForReturn);
            if (Double.isNaN(numberForReturn)) throw new NumberFormatException(NaN);
            return formatNumberDecimal(numberForReturn);
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    private String getMathId_7000(double v) {
        try {
            Log.d("checkMath", "MathId_7000() -> v == " + v + "; id_54_value == " + id_54_value);
            return v > id_54_value ? context.getString(R.string.armament_dose_is_enough) : context.getString(R.string.armament_dose_is_not_enough);
        } catch (NumberFormatException e){
            return context.getString(R.string.not_valid_cut);
        }
    }
    public String mathId_7000() {
        try {
            if (Double.isNaN(id_54_value)) throw new NumberFormatException(NaN);
            switch (id_69_position){
                case 0:
                    return getMathId_7000(id_6001_value);
                case 1:
                    return getMathId_7000(id_6002_value);
                case 2:
                    return getMathId_7000(id_6003_value);
                case 3:
                    return getMathId_7000(id_6004_value);
                case 4:
                    return getMathId_7000(id_6005_value);
                case 5:
                    return getMathId_7000(id_6006_value);
                case 6:
                    return getMathId_7000(id_6007_value);
                case 7:
                    return getMathId_7000(id_6008_value);
                case 8:
                    return getMathId_7000(id_6009_value);
                case 9:
                    return getMathId_7000(id_6010_value);
            }
            return null;
        } catch (NumberFormatException e){ return context.getString(R.string.not_valid_cut); }
    }

    public void setOnId_69_ChangedAction(double v2_for_2000) {
        setRelevantResultItem_value(1000, mathId_1000(), "");

        setRelevantResultItem_value(2000, mathId_2000(v2_for_2000), "");
        setRelevantResultItem_value(3000, mathId_3000(), "");
        setRelevantValueItem_position(4000, get_4000_relevantPosition());
        setRelevantResultItem_value(5000, mathId_5000(), "");
        setRelevantResultItem_value(6000, mathId_6000(), "");
        setRelevantResultItem_value(7000, mathId_7000(), "");
    }

    public void setTonOrKnBtn() {
        tonKnBtn_TV.setOnClickListener(view -> {
            tonKnBtn_TV.setSelected(isTonSelected = !isTonSelected);
            tonOrKN = isTonSelected ? TON : KN;
            tonKnBtn_TV.setText(tonOrKN);
            tonKnBtn_TV.setTextColor(isTonSelected ? context.getColor(R.color.colorWhite) : context.getColor(android.R.color.black));
            switch (subCategoryActiveId){
                case 0:
                    subCategoryOne.tonOrKnBtnClicked();
                    break;
                case 1:
                    subCategoryTwo.tonOrKnBtnClicked();
                    break;
                case 2:
                    subCategoryThree.tonOrKnBtnClicked();
                    break;
                case 3:
                    subCategoryFour.tonOrKnBtnClicked();
                    break;
                case 4:
                    subCategoryFive.tonOrKnBtnClicked();
                    break;
                case 5:
                    subCategorySix.tonOrKnBtnClicked();
                    break;
                case 6:
                    subCategorySeven.tonOrKnBtnClicked();
                    break;
            }
        });

    }
}

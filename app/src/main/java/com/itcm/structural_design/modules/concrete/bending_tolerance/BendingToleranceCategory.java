package com.itcm.structural_design.modules.concrete.bending_tolerance;

import android.util.Log;
import android.view.View;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;

import java.math.RoundingMode;

public class BendingToleranceCategory extends SubCategoriesManagerActivity {

    private String[] from_2_to_9_stringValues, from_2_to_10_stringValues, id_1000_stringValues,
            from_10_to_30_stringValues, from_12_to_25_stringValues;
    private BendingToleranceCategory_SubCategoryOne bendingToleranceCategory_SubCategoryOne;
    private BendingToleranceCategory_SubCategoryTwo bendingToleranceCategory_SubCategoryTwo;
    private BendingToleranceCategory_SubCategoryThree bendingToleranceCategory_SubCategoryThree;

    public BendingToleranceCategory(){
        initAllArrays();
    }

    public void setTonOrKnBtn(){
//        firstActionBtn_TV.setOnClickListener(view -> {
//            firstActionBtn_TV.setSelected(isPitulSelected = !isPitulSelected);
//            firstActionBtn_TV.setText(isPitulSelected ? context.getString(R.string.hide_pitul) : context.getString(R.string.show_pitul));
//            firstActionBtn_TV.setTextColor(isPitulSelected ? context.getColor(R.color.colorWhite) : context.getColor(android.R.color.black));
//            switch (subCategoryActiveId){
//                case 0:
//                    bendingToleranceCategory_SubCategoryOne.setAllAdapters();
//                    bendingToleranceCategory_SubCategoryOne.actionBtnClicked();
//                    break;
//                case 1:
//                    bendingToleranceCategory_SubCategoryTwo.setAllAdapters();
//                    bendingToleranceCategory_SubCategoryTwo.actionBtnClicked();
//                    break;
//                case 2:
//                    break;
//            }
//        });
        tonKnBtn_TV.setText(tonOrKN);

        tonKnBtn_TV.setOnClickListener(view -> {
            tonKnBtn_TV.setSelected(isTonSelected = !isTonSelected);
            tonOrKN = isTonSelected ? TON : KN;
            tonKnBtn_TV.setText(tonOrKN);
            tonKnBtn_TV.setTextColor(isTonSelected ? context.getColor(R.color.colorWhite) : context.getColor(android.R.color.black));
            switch (subCategoryActiveId){
                case 0:
                    bendingToleranceCategory_SubCategoryOne.tonOrKnBtnClicked();
                    break;
                case 1:
                    bendingToleranceCategory_SubCategoryTwo.tonOrKnBtnClicked();
                    break;
                case 2:
                    bendingToleranceCategory_SubCategoryThree.tonOrKnBtnClicked();
                    break;
            }
        });
    }

    public void initAllArrays() {
        from_2_to_9_stringValues = new String[]{"2","3","4","5","6","7","8","9"};
        from_2_to_10_stringValues = new String[]{"2","4","6","8","10"};
        from_10_to_30_stringValues = new String[]{"10","15","20","25","30"};
        from_12_to_25_stringValues = new String[]{"12","14","16","18","20","22","25"};
        id_1000_stringValues = context.getResources().getStringArray(R.array.load_types);
    }

    public String[] getFrom_2_to_9_stringValues(){ return from_2_to_9_stringValues; }
    public String[] getFrom_2_to_10_stringValues(){ return from_2_to_10_stringValues; }
    public String[] getFrom_12_to_25_stringValues(){ return from_12_to_25_stringValues; }
    public String[] getFrom_10_to_30_stringValues(){ return from_10_to_30_stringValues; }
    public String[] getId_1000_stringValues(){ return id_1000_stringValues; }

    public void initSubcategory(){
        switch (subCategoryActiveId){
            case 0:
                bendingToleranceCategory_SubCategoryOne = new BendingToleranceCategory_SubCategoryOne();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                bendingToleranceCategory_SubCategoryOne.tonOrKnBtnClicked();
                break;
            case 1:
                bendingToleranceCategory_SubCategoryTwo = new BendingToleranceCategory_SubCategoryTwo();
                saveBtn_TV.setOnClickListener(bendingToleranceCategory_SubCategoryTwo.onSaveClickListener);
                bendingToleranceCategory_SubCategoryTwo.tonOrKnBtnClicked();
                break;
            case 2:
                bendingToleranceCategory_SubCategoryThree = new BendingToleranceCategory_SubCategoryThree();
                saveBtn_TV.setOnClickListener(bendingToleranceCategory_SubCategoryThree.onSaveClickListener);
                bendingToleranceCategory_SubCategoryThree.tonOrKnBtnClicked();
                break;
        }
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (subCategoryActiveId){
            case 0:
                bendingToleranceCategory_SubCategoryOne.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 1:
                bendingToleranceCategory_SubCategoryTwo.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 2:
                bendingToleranceCategory_SubCategoryThree.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
        }
    }

    public View.OnClickListener onToolbarClickListener = view -> {

    };

    public String mathId_7(){
        id_7_value = id_3_value - id_4_value;
        Log.d("checkMath", "mathId_7() -> id_7_value == " + id_7_value + "; id_3_value == " + id_3_value + "; id_4_value == " + id_4_value);
        return id_7_value == 0 ? 0.0  + "": formatNumberDecimal(id_7_value) + "";
    }

    public String mathId_15(){
        id_15_value = 0.32 * id_6_value * id_7_value * id_7_value * id_9_value / 1000;
        Log.d("checkMath", "mathId_15 -> id_15_value == " + id_15_value + "; Double.parseDouble(getTonOrKtonVal(id_15_value) == " + Double.parseDouble(getTonOrKnVal(id_15_value)) + "; id_6_value == " + id_6_value + "; id_7_value == " + id_7_value + "; id_9_value == " + id_9_value);
        return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_15_value)));
    }

    public String mathId_16(){
        Log.d("checkMath", "mathId_16 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        return id_15_value * 2 > id_1_value ? context.getString(R.string.valid_cut) : context.getString(R.string.not_valid_cut);
    }

    public String mathId_17(){
        try {
            Log.d("checkMath", "mathId_17() -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
            id_17_value_string = id_15_value > id_1_value ? context.getString(R.string.pressure_not_required) : context.getString(R.string.pressure_required);
            return id_17_value_string;
        } catch (NumberFormatException e){
            id_17_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_17 -> EXCEPTION -> " + e.getMessage());
            return id_17_value_string;
        }
    }

    public String mathId_18(){
        Log.d("checkMath", "mathId_18 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        id_18_value = id_17_value_string.equals(context.getString(R.string.pressure_required)) ? Double.parseDouble(getTonOrKnVal(id_1_value - id_15_value)) : 0.0;
        return id_17_value_string.equals(context.getString(R.string.pressure_required)) ? (formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_1_value - id_15_value)))) +"": context.getString(R.string.pressure_not_required);
    }

    public String mathId_19(){
        Log.d("checkMath", "mathId_19() -> id_17_value_string == " + id_17_value_string);
        if (id_17_value_string.equals(context.getString(R.string.pressure_required))){
            firstMathPart = id_18_value * 1000 * 1000;
            secondMathPart = (id_7_value - id_5_value) * id_11_value * 10;
            try {
                id_19_value = firstMathPart / secondMathPart / 100;
                id_19_value = Double.isNaN(id_19_value) ? 0.0 : id_19_value;
                Log.d("checkMath", "mathId_19() -> try{} id_19_value == " + id_19_value + "; firstMathPart == " + firstMathPart + "; secondMathPart == " + secondMathPart + "; (firstMathPart / secondMathPart) == " + (firstMathPart / secondMathPart));
                Log.d("checkMath", "mathId_19() -> id_19_value == " + id_19_value + "; id_18_value == " + id_18_value + "; id_7_value == " + id_7_value + "; id_5_value == " + id_5_value + "; id_11_value == " + id_11_value);
                if (id_19_value == Double.POSITIVE_INFINITY) {
                    Log.d("checkMath", "mathId_19() -> isFinite == true -> id_19_value == " + id_19_value);
                    throw new NumberFormatException(NaN);
                } else {
                    Log.d("checkMath", "mathId_19() -> isFinite == false -> id_19_value == " + id_19_value);
                }
                return formatNumberDecimal(id_19_value) +"";
            } catch (ArithmeticException | NumberFormatException e){
                Log.d("checkMath", "mathId_19() -> catch{} id_19_value == " + id_19_value);
                e.printStackTrace();
                return context.getString(R.string.not_valid_cut);
            }
        } else { id_19_value = 0; }
        return formatNumberDecimal(id_19_value) +"";
    }

    public String mathId_20(){
        id_20_value = Math.max(id_14_value * id_7_value * id_6_value, id_13_value * id_7_value * id_6_value);
        Log.d("checkMath", "mathId_20() -> id_20_value == " + id_20_value + "; id_13_value == " + id_13_value + "; id_14_value == " + id_14_value + "; id_6_value == " + id_6_value + "; id_7_value == " + id_7_value);
        Log.d("checkMath", "mathId_20() -> firstVal == " + (id_14_value * id_7_value * id_6_value) + "; secondVal == " + (id_13_value * id_7_value * id_6_value));
        return formatNumberDecimal(id_20_value) + "";
    }

    public String mathId_21(){
        firstMathPart = 2 * id_1_value * 1000;
        secondMathPart = id_6_value * id_7_value * id_7_value * id_9_value;
        Log.d("checkMath", "mathId_21() -> id_21_value == " + id_21_value + "; id_1_value == " + id_1_value + "; id_6_value == " + id_6_value + "; id_7_value == " + id_7_value + "; id_9_value == " + id_9_value);
        Log.d("checkMath", "mathId_21() -> firstPart == " + firstMathPart + "; secondPart == " + secondMathPart + "; allParts == " + (1-(Math.pow(1-((firstMathPart) / (secondMathPart)),0.5))));
        try {
            if (secondMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_21_value = 1-(Math.pow(1-((firstMathPart) / (secondMathPart)),0.5)) < 0.1
                    ? 0.1
                    : Math.min(1 - (Math.pow(1 - ((firstMathPart) / (secondMathPart)), 0.5)), 0.4);
            return Double.isNaN(id_21_value) ? context.getString(R.string.not_valid_cut) : formatNumberDecimal(id_21_value) + "";
        } catch (NumberFormatException e){
            id_21_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_22(){
        try {
            if (Double.isNaN(id_21_value)) throw new NumberFormatException(NaN);
            id_22_value = id_21_value * id_7_value;
            Log.d("checkMath", "mathId_22() -> id_22_value == " + id_22_value + "; id_21_value == " + id_21_value + "; id_7_value == " + id_7_value);
            return formatNumberDecimal(id_22_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_22() -> " + context.getString(R.string.not_valid_cut));
            id_22_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_23(){
        try {
            if (Double.isNaN(id_21_value) || Double.isNaN(id_23_value)) throw new NumberFormatException(NaN);
            id_23_value = Math.min((1-(id_21_value / 2)) * id_7_value, 0.95 * id_7_value);
            Log.d("checkMath", "mathId_23 -> id_23_value == " + id_23_value + "; id_21_value == " + id_21_value + "; id_7_value == " + id_7_value);
            return formatNumberDecimal(id_23_value);
        } catch (NumberFormatException e){
            Log.d("checkMath", "mathId_23() -> " + context.getString(R.string.not_valid_cut));
            id_23_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_24(){
        id_24_value_string = "";
        if (id_17_value_string.equals(context.getString(R.string.pressure_required))){
            firstMathPart = id_15_value * 1000 * 1000;
            secondMathPart = id_23_value * id_11_value * 10;
            try {
                id_24_value = (firstMathPart / secondMathPart / 100 + id_16_value);
                Log.d("checkMath", "mathId_24() -> try{} id_24_value == " + id_24_value);
            } catch (ArithmeticException | NumberFormatException e){
                id_24_value = 0.0;
                Log.d("checkMath", "mathId_24() -> catch{} id_24_value == " + id_24_value);
                e.printStackTrace();
                id_24_value_string = context.getString(R.string.not_valid_cut);
                return id_24_value_string;
            }
        } else {
            firstMathPart = id_1_value * 1000 * 1000;
            secondMathPart = id_23_value * id_11_value * 10;
            try {
                id_24_value = (firstMathPart / secondMathPart / 100);
                Log.d("checkMath", "mathId_24() -> try{} id_24_value == " + id_24_value);
            } catch (ArithmeticException | NumberFormatException e){
                id_24_value = 0.0;
                Log.d("checkMath", "mathId_24() -> catch{} id_24_value == " + id_24_value);
                e.printStackTrace();
                id_24_value_string = context.getString(R.string.not_valid_cut);
                return id_24_value_string;            }
        }
        Log.d("checkMath", "mathId_24() -> id_24_value == " + id_24_value + "; id_15_value == " + id_15_value + "; id_23_value == " + id_23_value + "; id_11_value == " + id_11_value + "; id_24_value_string == " + id_24_value_string);
        if (Double.isNaN(id_24_value) || id_24_value_string.equals(context.getString(R.string.not_valid_cut))){
            id_24_value_string = context.getString(R.string.not_valid_cut);
            return id_24_value_string;
        }
        id_24_value_string = formatNumberDecimal(id_24_value) +"";
        return id_24_value_string;
    }

    public String mathId_29(){
        id_29_value = Math.PI * Math.pow(id_27_value,2) / 4 * id_25_value / 100;
        Log.d("checkMath", "mathId_29() -> id_29_value == " + id_29_value + "; id_27_value == " + id_27_value + "; id_25_value == " + id_25_value);
        return formatNumberDecimal(id_29_value) + "";
    }

    public String mathId_30(){
        id_30_value = Math.PI * Math.pow(id_28_value,2) / 4 * id_26_value / 100;
        Log.d("checkMath", "mathId_30() -> id_30_value == " + id_30_value + "; id_27_value == " + id_27_value + "; id_25_value == " + id_25_value);
        return formatNumberDecimal(id_30_value) + "";
    }

    public String mathId_31(){
        Log.d("checkMath", "mathId_31 -> id_29_value == " + id_29_value + "; id_24_value == " + id_24_value + "; id_24_value_string == " + id_24_value_string);
        if (id_24_value_string.equals(context.getString(R.string.not_valid_cut))){
            return context.getString(R.string.not_valid_cut);
        }
        return id_29_value > id_24_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_32(){
        Log.d("checkMath", "mathId_16 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        return id_30_value > id_19_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_33(){
        Log.d("checkMath", "mathId_16 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        return id_29_value > id_20_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_34(){
        Log.d("checkMath", "mathId_16 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        return id_30_value > id_20_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_35(){
        Log.d("checkMath", "mathId_16 -> id_15_value == " + id_15_value + "; id_1_value == " + id_1_value);
        return id_29_value < 0.04 * id_7_value * id_6_value ? OK : context.getString(R.string.armament_dose_is_too_big);
    }

    public String mathId_36(){
        Log.d("checkMath", "mathId_36() -> id_30_value == " + id_30_value + "; id_7_value == " + id_7_value + "; id_6_value == " + id_6_value);
        return id_30_value < 0.04 * id_7_value * id_6_value ? OK : context.getString(R.string.armament_dose_is_too_big);
    }

    public String mathId_41(){
        id_41_value = id_6_value * id_3_value;
        Log.d("checkMath", "mathId_41() -> id_41_value == " + id_41_value + "; id_6_value == " + id_6_value + "; id_3_value == " + id_3_value);
        return formatNumberDecimal(id_41_value) + "";
    }

    public String mathId_42(){
        id_42_value = id_29_value;
        Log.d("checkMath", "mathId_42() -> id_42_value == " + id_42_value + "; id_29_value == " + id_29_value);
        return formatNumberDecimal(id_42_value) + "";
    }

    public String mathId_43(){
        id_43_value = id_42_value / id_41_value;
        Log.d("checkMath", "mathId_43() -> id_43_value == " + id_43_value);
        return formatNumberDecimal(id_43_value) + "";
    }


    public String mathId_44(){
        try {
            id_44_value = 1 + (Math.pow(200 / (10 * id_7_value),0.5)) > 2
                    ? 2
                    : 1+(Math.pow(200 / (10 * id_7_value),0.5));
            Log.d("checkMath", "mathId_44() -> id_44_value == " + id_44_value + "; id_7_value == " + id_7_value);
            if(Double.isNaN(id_44_value)) throw new NumberFormatException(NaN);
            if(id_7_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            return formatNumberDecimal(id_44_value);
        } catch (NumberFormatException e){
            id_44_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_45(){
        id_45_value = Math.min(id_39_value * 10 / id_41_value, 0.2 * id_11_value);
        Log.d("checkMath", "mathId_45() -> id_45_value == " + id_45_value + "; id_39_value == " + id_39_value + "; id_41_value == " + id_41_value + "; id_11_value == " + id_11_value);
        return formatNumberDecimal(id_45_value) + "";
    }

    public String mathId_46(){
        try {
            if (Double.isNaN(id_44_value)) throw new NumberFormatException(NaN);
            id_46_value = Math.max(
                    (0.12 * id_44_value * (Math.pow(100 * id_43_value * 0.7 * id_8_value, 1.0 / 3.0)) + (0.15 * id_45_value)) * (id_6_value * id_7_value * 100),
                    (0.035 * id_44_value * (Math.pow((0.7 * id_8_value), 0.5)) + (0.15 * id_45_value)) * (id_6_value * id_7_value * 100)) / 1000;
            Log.d("checkMath", "mathId_46() -> id_43_value == " + id_43_value);
            return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_46_value)));
        } catch (NumberFormatException e){
            id_46_value = Double.NaN;
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_47(){
        id_47_value = 0.6 * (1-(0.7 * id_8_value / 250)) * id_9_value * id_6_value * 0.9 * id_7_value * 0.5 / 10;
        Log.d("checkMath", "mathId_47() -> id_47_value == " + id_47_value);
        return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_47_value))) + "";
    }

    public String mathId_48(){
        Log.d("checkMath", "mathId_48 -> id_40_value == " + id_40_value +"; id_47_value == " + id_47_value);
        return id_40_value < id_47_value ? context.getString(R.string.cut_is_valid_can_be_planned_for_cutting) : context.getString(R.string.cut_of_conrette_is_not_enough);
    }

    public String mathId_49(){
        Log.d("checkMath", "mathId_49 -> id_40_value == " + id_40_value + "; id_46_value == " + id_46_value);
        if (Double.isNaN(id_46_value)){
            return context.getString(R.string.not_valid_cut);
        }
        return id_40_value < id_46_value ? context.getString(R.string.minimal_armament_required) : context.getString(R.string.calculated_cut_out);
    }

    public String mathId_51(){
        id_51_value = id_50_value * id_6_value / 10;
        Log.d("checkMath", "mathId_51() -> id_51_value == " + id_51_value + "; id_50_value == " + id_50_value + "; id_6_value == " + id_6_value);
        return formatNumberDecimal(id_51_value);
    }

    public String mathId_52(){
        try {
            secondMathPart = 0.9 * id_11_value * id_7_value;
            Log.d("checkMath", "mathId_52() -> id_11_value == " + id_11_value + "; id_7_value == " + id_7_value + "; secondMathPart == " + secondMathPart);
            if (secondMathPart == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_52_value = id_40_value / secondMathPart;
            id_52_value = Math.max(id_52_value, id_51_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_52_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_52() -> ERROR == " + e.getMessage());
            return id_52_value_string;
        }
        Log.d("checkMath", "mathId_52() -> id_52_value == " + id_52_value + "; id_51_value == " + id_51_value + "; id_40_value == " + id_40_value + "; id_11_value == " + id_11_value + "; id_7_value == " + id_7_value + "; secondMathPart == " + secondMathPart + "; (0.9 * id_11_value * id_7_value) == " + (0.9 * id_11_value * id_7_value));
        id_52_value_string = formatNumberDecimal(id_52_value) + "";
        return id_52_value_string;
    }

    public String mathId_53(){
        id_53_value = Math.min(0.75 * id_7_value * 10, 300);
        Log.d("checkMath", "mathId_53() -> id_53_value == " + id_53_value + "; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_53_value) + "";
    }

    public String mathId_54(){
        id_54_value = Math.min(0.75 * id_7_value * 10, 400);
        Log.d("checkMath", "mathId_54() -> id_54_value == " + id_54_value + "; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_54_value) + "";
    }

    public String mathId_55(){
        try {
            if (id_54_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
            id_55_value = (id_6_value * 10 / id_54_value) + 1;
            if (Double.isNaN(id_55_value)) throw new NumberFormatException(NaN);
            Log.d("checkMath", "mathId_55() -> id_55_value == " + id_55_value);
            id_55_value = formatNumberDecimal(id_55_value, RoundingMode.UP, "#");
            Log.d("checkMath", "mathId_55() -> id_55_value == " + id_55_value + "; id_54_value == " + id_54_value + "; id_6_value == " + id_6_value);
            return id_55_value + "";
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_55_value = Double.NaN;
            Log.d("checkMath", "mathId_55() -> ERROR == " + e.getMessage());
            return  context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_59(){
        id_59_value = Math.PI * Math.pow(id_58_value, 2) / 4 * id_57_value / id_56_value;
        Log.d("checkMath", "mathId_59() -> id_59_value == " + id_59_value + "; id_58_value == " + id_58_value + "; id_57_value == " + id_57_value + "; id_56_value == " + id_56_value);
        return formatNumberDecimal(id_59_value) + "";
    }

    public String mathId_60(){
        Log.d("checkMath", "mathId_60 -> id_57_value == " + id_57_value + "; id_55_value == " + id_55_value);
        if (Double.isNaN(id_55_value)){
            return context.getString(R.string.not_valid_cut);
        }
        return id_57_value > id_55_value ? OK : context.getString(R.string.amount_of_branches_not_proper);
    }

    public String mathId_61(){
        Log.d("checkMath", "mathId_61() -> id_59_value == " + id_59_value + "; id_58_value == " + id_58_value + "; id_57_value == " + id_57_value + "; id_56_value == " + id_56_value);
        return id_59_value / id_56_value > id_51_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_62(){
        Log.d("checkMath", "mathId_62() -> id_59_value == " + id_59_value + "; id_58_value == " + id_58_value + "; id_57_value == " + id_57_value + "; id_56_value == " + id_56_value);
        return id_59_value / id_56_value > id_50_value ? OK : context.getString(R.string.amount_is_not_enough);
    }

    public String mathId_64(){
        try {
            id_64_value = (id_6_value - 2 * id_63_value - 2 * id_58_value / 10 - id_25_value * id_27_value / 10) / (id_25_value -1);
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_64_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_64() -> ERROR == " + e.getMessage());
            return id_64_value_string;
        }
        Log.d("checkMath", "mathId_64() -> id_64_value == " + id_64_value + "; id_6_value == " + id_6_value + "; id_63_value == " + id_63_value + "; id_58_value == " + id_58_value + "; id_25_value == " + id_25_value + "; id_27_value == " + id_27_value);
        id_64_value_string = formatNumberDecimal(id_64_value) + "";
        return id_64_value_string;
    }

    public String mathId_65(){
        id_65_value_string = "";
        try {
            id_65_value = (id_6_value - 2 * id_63_value - 2 * id_58_value / 10 - id_26_value * id_28_value / 10) / (id_25_value -1);
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_65_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_65() -> ERROR == " + e.getMessage());
            return id_65_value_string;
        }
        Log.d("checkMath", "mathId_65() -> id_65_value == " + id_65_value + "; id_6_value == " + id_6_value + "; id_63_value == " + id_63_value + "; id_58_value == " + id_58_value + "; id_25_value == " + id_26_value + "; id_27_value == " + id_28_value);
        id_65_value_string = formatNumberDecimal(id_65_value) + "";
        return id_65_value_string;
    }

    public String mathId_66(){
        Log.d("checkMath", "mathId_66() -> id_64_value == " + id_64_value);
        return id_64_value < 3.5 ? context.getString(R.string.spacing_between_rods_not_proper) : context.getString(R.string.proper_spacing);
    }

    public String mathId_67(){
        Log.d("checkMath", "mathId_67() -> id_65_value == " + id_65_value);
        return id_65_value < 3.5 ? context.getString(R.string.spacing_between_rods_not_proper) : context.getString(R.string.proper_spacing);
    }

    public String mathId_68(){
        id_68_value = id_59_value * 0.9 * id_7_value * 10 * id_11_value / 1000;
        id_68_value = formatNumberDecimal(id_68_value, RoundingMode.HALF_UP, "#");
        Log.d("checkMath", "mathId_68() -> id_68_value == " + id_68_value + "; id_59_value == " + id_59_value + "; id_7_value == " + id_7_value + "; id_11_value == " + id_11_value);
        return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_68_value))) + "";
    }

    public String mathId_69(){
        Log.d("checkMath", "mathId_69 -> id_40_value == " + id_40_value + "; id_68_value == " + id_68_value);
        return id_40_value < id_68_value ? context.getString(R.string.armament_cut_dose_is_valid) : context.getString(R.string.armament_cut_dose_is_not_valid);
    }

    public String mathId_72(){
        id_72_value = id_3_value / 100;
        Log.d("checkMath", "mathId_72() -> id_72_value == " + id_72_value + "; id_3_value == " + id_3_value);
        return formatNumberDecimal(id_72_value) + "";
    }

    public String mathId_73(){
        id_73_value = id_6_value / 100;
        Log.d("checkMath", "mathId_73() -> id_73_value == " + id_73_value + "; id_3_value == " + id_3_value);
        return formatNumberDecimal(id_73_value);
    }

    public String mathId_74(){
        id_74_value = id_73_value * id_72_value;
        Log.d("checkMath", "mathId_74() -> id_74_value == " + id_74_value + "; id_73_value == " + id_73_value + "; id_72_value == " + id_72_value + "; formatNumberDecimal(id_73_value, ##0.###) == " + formatNumberDecimal(id_73_value));
        return formatNumberDecimal(id_74_value);
    }

    public String mathId_75(){
        id_75_value = id_72_value / 12;
        Log.d("checkMath", "mathId_75() -> id_75_value == " + id_75_value + "; id_72_value == " + id_72_value);
        return formatNumberDecimal(id_75_value);
    }

    public String mathId_76(){
        try {
            id_76_value = Math.min((id_74_value / ((id_3_value * 2) / 100 + (id_6_value * 2) / 100)), id_75_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_76_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_76() -> ERROR == " + e.getMessage());
            return id_76_value_string;
        }
        Log.d("checkMath", "mathId_76() -> id_76_value == " + id_76_value + "; id_6_value == " + id_6_value + "; id_3_value == " + id_3_value + "; id_63_value == " + id_63_value + "; id_74_value == " + id_74_value + "; id_75_value == " + id_75_value);
        id_76_value_string = formatNumberDecimal(id_76_value) + "";
        return id_76_value_string;
    }

    public String mathId_77(){
        try {
            id_77_value = ((id_72_value - id_76_value) + (id_73_value - id_76_value)) * 2;
        } catch (NumberFormatException e){
            e.printStackTrace();
            id_77_value_string = context.getString(R.string.not_valid_cut);
            Log.d("checkMath", "mathId_77() -> ERROR == " + e.getMessage());
            return id_77_value_string;
        }
        Log.d("checkMath", "mathId_77() -> id_77_value == " + id_77_value + "; id_72_value == " + id_72_value + "; id_76_value == " + id_76_value + "; id_73_value == " + id_73_value);
        id_77_value_string = formatNumberDecimal(id_77_value) + "";
        return id_77_value_string;
    }

    public String mathId_78(){
        try {
            id_78_value = (id_72_value - id_76_value)*(id_73_value - id_76_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_78() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_78() -> id_78_value == " + id_78_value + "; id_72_value == " + id_72_value + "; id_76_value == " + id_76_value + "; id_73_value == " + id_73_value);
        return formatNumberDecimal(id_78_value) + "";
    }

    public String mathId_79(){
        try {
            id_79_value = 0.6 * (1-(0.7 * id_8_value) / 250) * id_9_value * Math.pow(10,6) * id_78_value * id_76_value / 1000;
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_77() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_79() -> id_79_value == " + id_79_value + "; id_72_value == " + id_72_value + "; id_76_value == " + id_76_value + "; id_73_value == " + id_73_value);
        return formatNumberDecimal(id_79_value) + "";
    }

    public String mathId_80(){
        try {
            id_80_value = (((Math.pow(id_73_value, 3) * id_72_value ) / 3) / (((Math.pow(id_73_value, 3) * id_72_value) / 3))) * id_70_value;
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_77() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_80() -> id_80_value == " + id_80_value + "; id_72_value == " + id_72_value + "; id_73_value == " + id_73_value + "; id_70_value == " + id_70_value);
        return formatNumberDecimal(Double.parseDouble(getTonOrKnVal(id_80_value))) + "";
    }

    public String mathId_81(){
        try {
            id_81_value = (id_80_value / id_79_value) + (id_40_value / id_47_value);
            if (id_79_value == 0 || id_47_value == 0) throw new NumberFormatException(DIVIDE_BY_ZERO_EXCEPTION);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_81() -> ERROR == " + e.getMessage());
            id_81_value_string = context.getString(R.string.not_valid_cut);
            return id_81_value_string;
        }
        Log.d("checkMath", "mathId_81() -> id_81_value == " + id_80_value + "; id_72_value == " + id_72_value + "; id_73_value == " + id_73_value + "; id_70_value == " + id_70_value);
        id_81_value_string = formatNumberDecimal(id_81_value) + "";
        return id_81_value_string;
    }

    public String mathId_83(){
        try {
            id_83_value = id_82_value * id_76_value * 100 * id_77_value * 100;
            Log.d("checkMath", "mathId_83() -> id_83_value == " + id_83_value + "; id_72_value == " + id_72_value + "; id_73_value == " + id_73_value + "; id_70_value == " + id_70_value);
            return formatNumberDecimal(id_83_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_83() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
    }

    public String mathId_84(){
        try {
            id_84_value = (id_80_value * id_77_value * 10) / (2 * id_78_value * id_11_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_84() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_84() -> id_84_value == " + id_84_value + "; id_80_value == " + id_80_value + "; id_77_value == " + id_77_value + "; id_78_value == " + id_78_value + "; id_11_value == " + id_11_value);
        return formatNumberDecimal(id_84_value) + "";
    }

    public String mathId_85(){
        try {
            id_85_value = id_84_value * id_77_value * 100 * id_79_value * 100;
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_85() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_85() -> id_85_value == " + id_85_value + "; id_84_value == " + id_84_value + "; id_77_value == " + id_77_value + "; id_79_value == " + id_79_value);
        return String.format("%.2f", id_85_value);
    }

    public String mathId_89(){
        try {
            id_89_value = (((Math.PI * Math.pow(id_88_value / 10,2)) / 4) * id_87_value);
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_89() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_89() -> id_89_value == " + id_89_value + "; id_88_value == " + id_88_value + "; id_87_value == " + id_87_value);
        return formatNumberDecimal(id_89_value) + "";
    }

    public String mathId_90(){
        Log.d("checkMath", "mathId_90() -> id_84_value == " + id_84_value + "; id_83_value == " + id_83_value + "; id_89_value == " + id_89_value);
        return Math.max(id_84_value, id_83_value) < id_89_value ? context.getString(R.string.valid_femail) : context.getString(R.string.not_valid_femail);
    }

    public String mathId_93(){
        try {
            id_93_value = id_82_value * id_76_value * 10 * id_91_value;
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_93() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_93() -> id_93_value == " + id_93_value + "; id_82_value == " + id_82_value + "; id_76_value == " + id_76_value + "; id_91_value == " + id_91_value);
        return formatNumberDecimal(id_93_value) + "";
    }

    public String mathId_94(){
        try {
            id_94_value = (Math.PI * Math.pow(id_92_value / 10,2)) / 4;
        } catch (NumberFormatException e){
            e.printStackTrace();
            Log.d("checkMath", "mathId_94() -> ERROR == " + e.getMessage());
            return context.getString(R.string.not_valid_cut);
        }
        Log.d("checkMath", "mathId_94() -> id_94_value == " + id_94_value + "; id_92_value == " + id_92_value);
        return formatNumberDecimal(id_94_value) + "";
    }

    public String mathId_95(){
        Log.d("checkMath", "mathId_90() -> id_84_value == " + id_84_value + "; id_83_value == " + id_83_value + "; id_89_value == " + id_89_value);
        return id_93_value < id_94_value ? context.getString(R.string.valid_femail) : context.getString(R.string.not_valid_femail);
    }


    public String getRelevantValueForId(int id){
        int relevantIdIntValue;
        switch (id){
            case 9:
                relevantIdIntValue = convertDoubleToInt(id_2_value);
                Log.d("checkFormatNumber", "id_7_measuring == " + id_7_value + "; relevantIdIntValue == " + relevantIdIntValue);
                switch (relevantIdIntValue){
                    case 30:
                        id_9_value = 13;
                        return id_9_value + "";
                    case 40:
                        id_9_value = 17.4;
                        return id_9_value + "";
                    case 50:
                        id_9_value = 21.7;
                        return id_9_value + "";
                    case 60:
                        id_9_value = 26;
                        return id_9_value + "";
                    case 20:
                    default:
                        id_9_value = 8.7;
                        return id_9_value + "";
                }
            case 11:
                relevantIdIntValue = convertDoubleToInt(id_10_value);
                Log.d("checkFormatNumber", "id_10_value == " + id_10_value + "; relevantIdIntValue == " + relevantIdIntValue);
                switch (relevantIdIntValue){
                    case 500:
                        id_11_value = 435;
                        return id_11_value + "";
                    case 400:
                    default:
                        id_11_value = 350;
                        return id_11_value + "";
                }
            case 12:
                relevantIdIntValue = convertDoubleToInt(id_8_value);
                Log.d("checkFormatNumber", "id_7_value == " + id_8_value + "; relevantIdIntValue == " + relevantIdIntValue);
                switch (relevantIdIntValue){
                    case 30:
                        id_12_value = 2.3;
                        return id_12_value + "";
                    case 40:
                        id_12_value = 2.8;
                        return id_12_value + "";
                    case 50:
                        id_12_value = 3.2;
                        return id_12_value + "";
                    case 60:
                        id_12_value = 3.6;
                        return id_12_value + "";
                    case 20:
                    default:
                        id_12_value = 1.7;
                        return id_12_value + "";
                }
            case 13:
                relevantIdIntValue = convertDoubleToInt(id_10_value);
                Log.d("checkFormatNumber", "id_7_measuring == " + id_7_value + "; relevantIdIntValue == " + relevantIdIntValue);
                switch (relevantIdIntValue){
                    case 400:
                        relevantIdIntValue = convertDoubleToInt(id_2_value);
                        switch (relevantIdIntValue){
                            case 30:
                                id_13_value = 0.0016;
                                return id_13_value + "";
                            case 40:
                                id_13_value = 0.0020;
                                return id_13_value + "";
                            case 50:
                                id_13_value = 0.0022;
                                return id_13_value + "";
                            case 60:
                                id_13_value = 0.0025;
                                return id_13_value + "";
                            case 20:
                            default:
                                id_13_value = 0.0012;
                                return id_13_value + "";
                        }
                    case 500:
                        relevantIdIntValue = convertDoubleToInt(id_2_value);
                        switch (relevantIdIntValue){
                            case 30:
                                id_13_value = 0.0013;
                                return id_13_value + "";
                            case 40:
                                id_13_value = 0.0016;
                                return id_13_value + "";
                            case 50:
                                id_13_value = 0.0018;
                                return id_13_value + "";
                            case 60:
                                id_13_value = 0.0020;
                                return id_13_value + "";
                            case 20:
                            default:
                                id_13_value = 0.0010;
                                return id_13_value + "";
                        }
                }
            case 14:
                relevantIdIntValue = convertDoubleToInt(id_10_value);
                switch (relevantIdIntValue){
                    case 500:
                        id_14_value = 0.0013;
                        return id_14_value + "";
                    case 400:
                    default:
                        id_14_value = 0.0015;
                        return 0.0015 + "";
                }
            case 50:
                relevantIdIntValue = convertDoubleToInt(id_10_value);
                Log.d("checkFormatNumber", "case 50: -> id_2_value == " + id_2_value + "; relevantIdIntValue == " + relevantIdIntValue);
                switch (relevantIdIntValue){
                    case 400:
                        relevantIdIntValue = convertDoubleToInt(id_2_value);
                        switch (relevantIdIntValue){
                            case 40:
                                id_50_value = 0.0013;
                                break;
                            case 50:
                                id_50_value = 0.0015;
                                break;
                            case 60:
                                id_50_value = 0.0016;
                                break;
                            default:
                                id_50_value = 0.0010;
                                break;
                        }
                        return id_50_value + "";
                    case 500:
                        relevantIdIntValue = convertDoubleToInt(id_2_value);
                        switch (relevantIdIntValue){
                            case 60:
                                id_50_value = 0.0013;
                                return id_50_value + "";
                            default:
                                id_50_value = 0.0010;
                                return id_50_value + "";
                        }
                }
            case 82:
                relevantIdIntValue = convertDoubleToInt(id_2_value);
                switch (relevantIdIntValue){
                    case 60:
                    case 50:
                        id_82_value = 0.0045;
                        return id_82_value +"";
                    case 40:
                    case 30:
                        id_82_value = 0.0035;
                        return id_82_value +"";
                    case 20:
                        id_82_value = 0.0025;
                        return id_82_value +"";
                }
            default:
                return "0";
        }
    }

    public void insertOrUpdateVersion(boolean isForInsert) {
        switch (subCategoryActiveId){
            case 0:
                bendingToleranceCategory_SubCategoryOne.insertOrUpdateVersion(isForInsert);
                break;
            case 1:
                bendingToleranceCategory_SubCategoryTwo.insertOrUpdateVersion(isForInsert);
                break;
            case 2:
                bendingToleranceCategory_SubCategoryThree.insertOrUpdateVersion(isForInsert);
                break;
        }
    }

}

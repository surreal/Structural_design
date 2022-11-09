package com.itcm.structural_design.modules.concrete.canopy_length;

import android.util.Log;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;

public class CanopyLengthsCategory extends SubCategoriesManagerActivity {

    private CanopyLengthsCategory_SubCategoryOne canopyLengthsModule_SubCategoryOne;
    private CanopyLengthsCategory_SubCategoryTwo canopyLengthsModule_SubCategoryTwo;
    private CanopyLengthsCategory_SubCategoryThree canopyLengthsModule_SubCategoryThree;
    private CanopyLengthsCategory_SubCategoryFour canopyLengthsModule_SubCategoryFour;

    public CanopyLengthsCategory(){ initAllArrays(); }

    public String[] getId_1_stringValues() { return id_1_stringValues; }
    public String[] getId_3_stringValues() { return id_3_stringValues; }
    public double[] getId_3_doubleValues() { return id_3_doubleValues; }
    public String[] getId_4_stringValues() { return id_4_stringValues; }
    public String[] getId_15_stringValues() { return id_15_stringValues; }
    public double[] getId_15_doubleValues() { return id_15_doubleValues; }
    public String[] getId_102_stringValues() { return id_102_stringValues; }
    public String[] getId_104_stringValues() { return id_104_stringValues; }
    public double[] getId_104_doubleValues() { return id_104_doubleValues; }

    public void insertOrUpdateVersion(boolean isForInsert){
        switch (subCategoryActiveId){
            case 0:
                canopyLengthsModule_SubCategoryOne.insertOrUpdateVersion(isForInsert);
                break;
            case 1:
                canopyLengthsModule_SubCategoryTwo.insertOrUpdateVersion(isForInsert);
                break;
            case 2:
                canopyLengthsModule_SubCategoryThree.insertOrUpdateVersion(isForInsert);
                break;
            case 3:
                canopyLengthsModule_SubCategoryFour.insertOrUpdateVersion(isForInsert);
                break;
        }
    }

    public void initSubcategory(){
        switch (subCategoryActiveId){
            case 0:
                canopyLengthsModule_SubCategoryOne = new CanopyLengthsCategory_SubCategoryOne();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                break;
            case 1:
                canopyLengthsModule_SubCategoryTwo = new CanopyLengthsCategory_SubCategoryTwo();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                break;
            case 2:
                canopyLengthsModule_SubCategoryThree = new CanopyLengthsCategory_SubCategoryThree();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                break;
            case 3:
                canopyLengthsModule_SubCategoryFour = new CanopyLengthsCategory_SubCategoryFour();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                break;
        }
    }

    public void initAllArrays() {
        id_1_stringValues = context.getResources().getStringArray(R.array.steel_types);
        id_3_stringValues = new String[]{"200","350","435"};
        id_3_doubleValues = new double[]{200,350,435};
        id_4_stringValues = context.getResources().getStringArray(R.array.conditions_of_adhesion_types);
        id_15_stringValues = new String[]{"20","30","50","60"};
        id_15_doubleValues = new double[]{20,30,50,60};
        id_102_stringValues = context.getResources().getStringArray(R.array.rod_state_types);
        id_104_stringValues = new String[]{"0.5","0.7","1"};
        id_104_doubleValues = new double[]{0.5,0.7,1.0};
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (subCategoryActiveId){
            case 0:
                canopyLengthsModule_SubCategoryOne.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 1:
                canopyLengthsModule_SubCategoryTwo.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 2:
                canopyLengthsModule_SubCategoryThree.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
            case 3:
                canopyLengthsModule_SubCategoryFour.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                break;
        }
    }

    public String mathId_9() {
        Log.d("checkMath", "mathId_9() -> id_7_value == " + id_7_value + "; id_6_value == " + id_6_value);
        return "Ø" + (id_7_value + "").split("\\.")[0] + "@" + (id_6_value + "").split("\\.")[0];
    }

    public String mathId_10() {
        id_10_value = Math.pow(id_7_value / 10, 2) * (0.25 * Math.PI);
        Log.d("checkMath", "mathId_10() -> id_10_value == " + id_10_value + "; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_10_value)+"";
    }

    public String mathId_11(){
        id_11_value = id_10_value * (100 / id_6_value);
        Log.d("checkMath", "mathId_11() -> id_11_value == " + id_11_value+ "; id_6_value == " + id_6_value);
        return formatNumberDecimal(id_11_value)+"";
    }

    public String getRelevantValueForId_12() {
        int relevantIdIntValue;
        relevantIdIntValue = convertDoubleToInt(id_2_value);
        switch (relevantIdIntValue){
            case 30:
                id_12_value = id_4_position == 0 ? 2.45 : 1.71;
                break;
            case 40:
                id_12_value = id_4_position == 0 ? 2.91 : 2.04;
                break;
            case 50:
                id_12_value = id_4_position == 0 ? 3.4 : 2.38;
                break;
            case 60:
                id_12_value = id_4_position == 0 ? 1.26 : 2.78;
                break;
            case 20:
            default:
                id_12_value = id_4_position == 0 ? 1.81 : 1.26;
                break;
        }
        return id_12_value+"";
    }

    public String mathId_13() {
        id_13_value = (((id_7_value / 10) * id_3_value) / (4 * id_12_value));
        Log.d("checkMath", "mathId_13() -> id_13_value == " + id_13_value + "; id_7_value == " + id_7_value + "; id_3_value == " + id_3_value + "; id_12_value == " + id_12_value);
        return formatNumberDecimal(id_13_value) + "";
    }

    public String mathId_14() {
        id_14_value = id_13_value * (id_8_value / id_11_value);
        Log.d("checkMath", "mathId_14() -> id_14_value == " + id_14_value + "; id_13_value == " + id_13_value + "; id_8_value == " + id_8_value + "; id_11_value == " + id_11_value);
        return formatNumberDecimal(id_14_value);
    }

    public String mathId_23() {
        id_23_value = id_13_value;
        Log.d("checkMath", "mathId_23() -> id_23_value == " + id_23_value + "; id_13_value == " + id_13_value);
        return formatNumberDecimal(id_23_value);
    }

    public String mathId_103() {
        id_103_value = id_102_position == 0 ? Math.max(Math.max(0.3 * id_13_value, 10), id_7_value) : Math.max(Math.max(0.6 * id_13_value,15), id_7_value * 1.5);
        Log.d("checkMath", "mathId_103() -> id_103_value == " + id_103_value + "; id_102_position == " + id_102_position + "; id_13_value == " + id_13_value + "; id_7_value == " + id_7_value);
        return formatNumberDecimal(id_103_value);
    }

    public String mathId_111() {
        id_111_value = (0.4+((id_10_value*100)/(id_6_value/100))/800)>2?2:(0.4+((id_10_value*100)/(id_6_value/100))/800)<1?1:(0.4+((id_10_value*100)/(id_6_value/100))/800);
        Log.d("checkMath", "mathId_111() -> id_111_value == " + id_111_value + "; id_10_value == " + id_10_value + "; id_6_value == " + id_6_value);
        return formatNumberDecimal(id_111_value);
    }

}

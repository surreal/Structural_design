package com.itcm.structural_design.modules.concrete.paging;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;

public class PagingCategory extends SubCategoriesManagerActivity {

    private PagingSubcategoryOne subCategoryOne;
    private PagingSubcategoryTwo subCategoryTwo;
    private String[] suspendedSuspensionCondition, connectionTypes, from_8_to_10_stringValues, from_2_to_4_stringValues, from_2_to_10_stringValues, frameTypes_stringValues;
    private double[] from_8_to_10_doubleValues, from_2_to_4_doubleValues;

    public PagingCategory(){ initAllArrays(); }

    private void initAllArrays() {
        frameTypes_stringValues = context.getResources().getStringArray(R.array.frame_types);
        suspendedSuspensionCondition = context.getResources().getStringArray(R.array.suspendedSuspensionConditionTypes);
        connectionTypes = context.getResources().getStringArray(R.array.connection_types);
        from_8_to_10_stringValues = new String[]{"8","10"};
        from_8_to_10_doubleValues = new double[]{8,10};
        from_2_to_4_stringValues = new String[]{"2","3","4"};
        from_2_to_4_doubleValues = new double[]{2,3,4};
        from_2_to_10_stringValues = new String[]{"2","4","6","8","10"};
    }

    public String[] getFrame_types_stringValues(){ return frameTypes_stringValues; }
    public String[] getSuspendedSuspensionCondition_stringValues(){ return suspendedSuspensionCondition; }
    public String[] getConnectionTypes_stringValues(){ return connectionTypes; }
    public String[] getFrom_8_to_10_stringValues(){ return from_8_to_10_stringValues; }
    public double[] getFrom_8_to_10_doubleValues(){ return from_8_to_10_doubleValues; }
    public String[] getFrom_2_to_4_stringValues(){ return from_2_to_4_stringValues; }
    public double[] getFrom_2_to_4_doubleValues(){ return from_2_to_4_doubleValues; }
    public String[] getFrom_2_to_10_stringValues(){ return from_2_to_10_stringValues; }

    public void insertOrUpdateVersion(boolean isForInsert) {
        switch (subCategoryActiveId){
            case 0:
                subCategoryOne.insertOrUpdateVersion(isForInsert);
                break;
            case 1:
                subCategoryTwo.insertOrUpdateVersion(isForInsert);
                break;
        }
    }

    public void initSubcategory() {
        switch (subCategoryActiveId){
            case 0:
                subCategoryOne = new PagingSubcategoryOne();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryOne.tonOrKnBtnClicked();
                break;
            case 1:
                subCategoryTwo = new PagingSubcategoryTwo();
                saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
                subCategoryTwo.tonOrKnBtnClicked();
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
        }
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
            }
        });

    }
}

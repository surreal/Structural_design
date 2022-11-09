package com.itcm.structural_design.modules.steel;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;
import com.itcm.structural_design.modules.steel.subcategories.SteelCeilingSubcategory_One;

public class SteelCeilingCategory extends SubCategoriesManagerActivity {

    private SteelCeilingSubcategory_One steelCeilingSubcategory_one;
    private String[] ipn_stringValues, hebAndHea_stringValues, steelType_stringValues, fromAToD_stringValues;

    public SteelCeilingCategory(){ initAllArrays(); }

    private void initAllArrays() {
        ipn_stringValues = new String[]{"80","100","120","140","160","180","200","220","240","240","260","280","300","320","340","360","380","400","450","500","550","600"};
        hebAndHea_stringValues = new String[]{"100","120","140","160","180","200","220","240","240","260","280","300","320","340","360","380","400","450","500","550","600","650","700","800","900","1000"};
        steelType_stringValues = new String[]{"195","205","215","225","235","245","255","265","275","325","335","345","355"};
        fromAToD_stringValues = new String[]{"A","B","C","D"};
    }

    public String[] getIPN_stringValues() { return ipn_stringValues; }
    public String[] getHebAndHea_stringValues() { return hebAndHea_stringValues; }
    public String[] getSteelType_stringValues() { return steelType_stringValues; }
    public String[] getFromAToD_stringValues() { return fromAToD_stringValues; }

    public void initRelevantSubCategory() {
        steelCeilingSubcategory_one = new SteelCeilingSubcategory_One();
        saveBtn_TV.setOnClickListener(onDialogBtnClickListener.positiveBtnClicked());
        steelCeilingSubcategory_one.tonOrKnBtnClicked();
    }

    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) { steelCeilingSubcategory_one.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition); }

    public void insertOrUpdateVersion(boolean isForInsert) { steelCeilingSubcategory_one.insertOrUpdateVersion(isForInsert); }

    public void setTonOrKnBtn() {
        tonKnBtn_TV.setText(tonOrKN);
        tonKnBtn_TV.setOnClickListener(view -> {
            tonKnBtn_TV.setSelected(isTonSelected = !isTonSelected);
            tonOrKN = isTonSelected ? TON : KN;
            tonKnBtn_TV.setText(tonOrKN);
            tonKnBtn_TV.setTextColor(isTonSelected ? context.getColor(R.color.colorWhite) : context.getColor(android.R.color.black));
            steelCeilingSubcategory_one.tonOrKnBtnClicked();
        });
    }

}

package com.itcm.structural_design.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.itcm.structural_design.R;
import com.itcm.structural_design.interfaces.OnDialogBtnClickListener;
import com.itcm.structural_design.modules.concrete.bending_tolerance.BendingToleranceCategory;
import com.itcm.structural_design.modules.concrete.canopy_length.CanopyLengthsCategory;
import com.itcm.structural_design.adapters.AdapterSubCategoriesRV;
import com.itcm.structural_design.modules.concrete.paging.PagingCategory;
import com.itcm.structural_design.modules.concrete.penetration.PenetrationCategory;
import com.itcm.structural_design.database.DBModel;
import com.itcm.structural_design.fragments.StructuralDesignResultFragment;
import com.itcm.structural_design.fragments.StructuralDesignValuesFragment;
import com.itcm.structural_design.helpers.DialogHelper;
import com.itcm.structural_design.helpers.KeyboardHelper;
import com.itcm.structural_design.interfaces.FragmentListener;
import com.itcm.structural_design.interfaces.OnAsyncPostListener;
import com.itcm.structural_design.models.StructuralDesignModel;
import com.itcm.structural_design.modules.steel.SteelCeilingCategory;

import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class SubCategoriesManagerActivity extends BasicActivity implements FragmentListener, OnAsyncPostListener, OnDialogBtnClickListener {

    public static final String SUB_CATEGORIES_MANAGER_ACTIVITY = "sub_categories_manager_activity";
    public static final String TON = "ton";
    public static final String KN = "kN";
    public static boolean isTonSelected = false;
    public static RecyclerView result_RV, values_RV;
    public static ArrayList<StructuralDesignModel> valuesModels, resultModels;
    public static AdapterSubCategoriesRV adapterStructuralDesignResult_RV, adapterStructuralDesignValues_RV;
    public static ArrayMap<Integer, Integer> resultPositionsByIds, valuesPositionsByIds;
    public static double secondMathPart, firstMathPart, thirdMathPart, fourthMathPart, fifthMathPart;
    public static ArrayMap<Integer, Integer> spinnerPositionsArray;
    public static ArrayList<String> negativeResults;
    private BendingToleranceCategory bendingToleranceCategory;
    private CanopyLengthsCategory canopyLengthsCategory;
    private PenetrationCategory penetrationCategory;
    private PagingCategory pagingCategory;
    private SteelCeilingCategory steelCeilingCategory;
    public static TextView tonKnBtn_TV, saveBtn_TV;
    public static String tonOrKN = KN;

    public static String[] id_1_stringValues, concreteType_stringValues, id_3_stringValues, id_4_stringValues, from_400_to_500_stringValues,
            id_15_stringValues, id_102_stringValues, id_104_stringValues, from_8_to_25_stringValues;
    public static double[] concreteType_doubleValues, from_400_to_500_doubleValues, id_104_doubleValues, id_3_doubleValues, id_15_doubleValues;
    public static int id_1_position = 0, id_2_position = 0, id_3_position = 0, id_4_position = 0, id_6_position = 0, id_102_position = 0, id_10_position = 0,
            id_9_position = 0, id_14_position = 0, id_15_position = 0, id_16_position = 0, id_17_position = 0, id_21_position = 0, id_22_position = 0, id_23_position = 0,
            id_25_position = 0, id_26_position = 0, id_27_position = 0, id_28_position = 0, id_30_position = 0, id_34_position = 0, id_35_position = 0,
            id_36_position = 0, id_37_position = 0,
            id_42_position, id_43_position = 0, id_47_position = 0, id_50_position = 0, id_51_position = 0, id_57_position = 0, id_58_position = 0, id_59_position = 0,
            id_62_position = 0, id_66_position = 0, id_69_position = 0, id_70_position = 0, id_77_position = 0, id_78_position = 0, id_85_position = 0, id_86_position = 0,
            id_88_position = 0, id_94_position = 0, id_92_position = 0, id_116_position = 0, id_270_position, id_2026_position = 0,
            id_2027_position = 0, id_2034_position = 0, id_2035_position = 0, id_2042_position = 0, id_2043_position = 0, id_2048_position = 0, id_2049_position = 0,
            id_104_position = 0, id_1000_position = 0, id_4001_position = 0, id_4002_position = 0, id_4003_position = 0, id_4004_position = 0, id_4005_position = 0,
            id_4006_position = 0, id_4007_position = 0, id_4008_position = 0, id_4009_position = 0, id_4010_position = 0;
    public static String
            id_17_value_string = "", id_19_value_string = "", id_21_value_string = "", id_24_value_string = "",
            id_48_value_string = "", id_52_value_string = "", id_54_value_string = "", id_58_value_string = "", id_64_value_string = "",
            id_65_value_string = "", id_76_value_string = "", id_77_value_string = "", id_81_value_string = "", id_1008_value_string = "",
            id_1009_value_string = "", id_1017_value_string = "", id_2030_value_string = "", id_2031_value_string = "", id_2032_value_string = "",
            id_2033_value_string = "", id_2038_value_string = "", id_2039_value_string = "", id_2040_value_string = "", id_2041_value_string = "",
            id_2046_value_string = "", id_2047_value_string = "", id_2052_value_string = "", id_2053_value_string = "", id_2056_value_string = "";
    public static double id_1_value = 1, id_2_value = 20, id_3_value = 1, id_4_value = 1, id_5_value = 1, id_6_value = 1,
            id_7_value = 0, id_8_value = 20, id_9_value = 8.7, id_10_value = 400, id_11_value = 350, id_12_value = 1.7, id_13_value = 0.0012,
            id_14_value = 0.0015, id_15_value = 1, id_16_value = 0, id_17_value = 0, id_18_value = 1, id_19_value = 1, id_20_value = 1, id_21_value = 1,
            id_22_value = 1, id_23_value = 1, id_24_value = 1, id_25_value = 2, id_26_value = 2, id_27_value = 8,
            id_28_value = 8, id_29_value = 0, id_30_value = 0, id_31_value = 0, id_32_value = 0, id_33_value = 0, id_34_value = 0, id_35_value = 0, id_36_value = 0,
            id_37_value = 0, id_38_value = 0, id_39_value = 1, id_40_value = 1, id_41_value = 1, id_42_value = 1,
            id_43_value = 1, id_44_value = 1, id_45_value = 1, id_46_value = 1, id_47_value = 1, id_48_value = 1, id_49_value = 1, id_50_value = 1, id_51_value = 1,
            id_52_value = 1, id_53_value = 1, id_54_value = 1, id_55_value = 1, id_56_value = 1, id_57_value = 8, id_58_value = 8,
            id_59_value = 1, id_60_value = 1, id_61_value = 1, id_62_value = 1, id_63_value = 1, id_64_value = 1, id_65_value = 1, id_66_value = 1,
            id_67_value = 1, id_68_value = 1, id_69_value = 1, id_70_value = 1, id_71_value = 1, id_72_value = 1,
            id_73_value = 1, id_74_value = 1, id_75_value = 1, id_76_value = 1, id_77_value = 1, id_78_value = 1, id_79_value = 1,
            id_80_value = 1, id_81_value = 1, id_82_value = 1, id_83_value = 1, id_84_value = 1, id_85_value = 1, id_86_value = 1, id_87_value = 1,
            id_88_value = 8, id_89_value = 1, id_90_value = 1, id_91_value = 1, id_92_value = 8, id_93_value = 1, id_94_value = 1, id_95_value = 1,
            id_96_value = 1, id_97_value = 1, id_970_value = 1, id_98_value = 1, id_99_value = 1, id_100_value = 1, id_101_value = 1,
            id_102_value = 1, id_103_value = 1, id_104_value = 1, id_105_value = 1, id_106_value = 1, id_107_value = 1, id_108_value = 1, id_109_value,
            id_110_value = 1, id_111_value = 1, id_112_value = 1, id_113_value = 1, id_114_value = 1, id_115_value = 1, id_116_value = 1,
            id_117_value = 1, id_118_value = 1, id_119_value = 1, id_121_value = 1, id_122_value = 1, id_123_value = 1, id_124_value = 1, id_125_value = 1,
            id_126_value = 1, id_127_value = 1, id_129_value = 1, id_150_value = 1, id_151_value = 1, id_152_value = 1,
            id_250_value = 1, id_270_value = 8, id_441_value = 1, id_400_value = 1, id_440_value = 1, id_840_value = 1, id_841_value = 1, id_950_value = 1,
            id_1001_value = 1, id_1002_value = 1, id_1003_value = 1, id_1004_value = 1, id_1005_value = 1, id_1006_value = 1, id_1007_value = 1,
            id_1008_value = 1, id_1009_value = 1, id_1010_value = 1, id_1015_value = 1, id_1018_value = 1, id_1019_value = 1, id_1021_value = 1,
            id_1022_value = 1, id_1023_value = 1, id_1024_value = 1, id_2001_value = 1, id_2002_value = 1, id_2003_value = 1, id_2004_value = 1,
            id_2005_value = 1, id_2006_value = 1, id_2007_value = 1, id_2008_value = 1, id_2009_value = 1, id_2010_value = 1, id_3001_value = 1,
            id_3002_value = 1, id_3003_value = 1, id_3004_value = 1, id_3005_value = 1, id_3006_value = 1, id_3007_value = 1, id_3008_value = 1,
            id_3009_value = 1, id_3010_value = 1, id_4001_value = 1, id_4002_value = 1, id_4003_value = 1, id_4004_value = 1, id_4005_value = 1,
            id_4006_value = 1, id_4007_value = 1, id_4008_value = 1, id_4009_value = 1, id_4010_value = 1, id_6001_value = 1, id_6002_value = 1,
            id_6003_value = 1, id_6004_value = 1, id_6005_value = 1, id_6006_value = 1, id_6007_value = 1, id_6008_value = 1, id_6009_value = 1,
            id_6010_value = 1, id_2026_value = 1, id_2027_value = 1, id_2029_value = 1, id_2034_value = 1, id_2035_value = 1, id_2037_value = 1,
            id_2042_value = 1, id_234_value = 1, id_2043_value = 1, id_2045_value = 1, id_2048_value = 1, id_2049_value = 1, id_2051_value = 1,
            id_2054_value = 1, id_2055_value = 1, id_2056_value = 1;
    public static String savedVersionTitle;
    public static int resultsRVPosition, valuesRVPosition;
    public static OnDialogBtnClickListener onDialogBtnClickListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub_categories);
        savedVersionTitle = getIntent().getStringExtra(SAVED_VERSION_TITLE);
        subCategoryActiveId = getIntent().getIntExtra(SUB_CATEGORY_POSITION, 0);
        Log.d("checkLifeCycle", "SubCategoriesManagerActivity{} -> onCreate()");
        context = this;
        activity = this;
        setTopButtons();
        initRelevantCategory();
        initNegativeResults();
        initArrays();
        setViewPager();
//        initRelevantSubcategory();
//        setSpinner();
        Log.d("checkOnCreateValues", "savedVersionTitle == " + savedVersionTitle + "; subCategoryActiveId == " + subCategoryActiveId);
    }

    @Override
    protected void onStart() {
        super.onStart();
        onDialogBtnClickListener = (OnDialogBtnClickListener) context;
        Log.d("checkLifeCycle", "onStart() -> categoryActiveId == " + categoryActiveId);
    }

    public double mathEven(double number) {
        Log.d("checkMath", "mathEven -> number == " + number);
        double i = formatNumberDecimal(number, RoundingMode.UP, "#");
        return i % 2 == 0 ? i : i + 1;
    }

    public int getPositionByValue(double[] valuesArray, double value) {
        for (int i = 0; i < valuesArray.length; i++) {
            if (valuesArray[i] == value) {
                return i;
            }
        }
        return 0;
    }

    public int getPositionByValue(String[] valuesArray, double value) {
        for (int i = 0; i < valuesArray.length; i++) {
            if (valuesArray[i].equals((value + "").split("\\.")[0])) {
                return i;
            }
        }
        return 0;
    }

    private void setTopButtons() {
        saveBtn_TV = findViewById(R.id.layout_two_buttons_btn_1_tv);
        tonKnBtn_TV = findViewById(R.id.layout_two_buttons_btn_2_tv);
        saveBtn_TV.setText(R.string.save);
    }

    private void initArrays() {
        concreteType_stringValues = new String[]{"ב-20", "ב-30", "ב-40", "ב-50", "ב-60"};
        concreteType_doubleValues = new double[]{20, 30, 40, 50, 60};
        from_400_to_500_stringValues = new String[]{"400", "500"};
        from_400_to_500_doubleValues = new double[]{400, 500};
        from_8_to_25_stringValues = new String[]{"8", "10", "12", "14", "16", "22", "25"};
    }

    public String[] getConcreteType_StringValues() {
        return concreteType_stringValues;
    }

    public double[] getConcreteTypeDoubleValues() {
        return concreteType_doubleValues;
    }

    public String[] getFrom_400_to_500_stringValues() {
        return from_400_to_500_stringValues;
    }

    public double[] getFrom_400_to_500_doubleValues() {
        return from_400_to_500_doubleValues;
    }

    public String[] getFrom_8_to_25_stringValues() {
        return from_8_to_25_stringValues;
    }

    public String mathConcatenate(double v1, double v2) {
        String val1 = (v1 + "").split("\\.")[1].equals("0") ? (v1 + "").split("\\.")[0] : v1 + "";
        String val2 = (v2 + "").split("\\.")[1].equals("0") ? (v2 + "").split("\\.")[0] : v2 + "";
        return "Φ" + val1 + "@" + val2;
    }

    public String getRelevantSecondMeasuringUnit(int option) {
        switch (option) {
            case 0:
                return "[" + tonOrKN + "]";
            case 1:
                return "[" + tonOrKN + "m]";
            case 2:
                return "[" + tonOrKN + "*m]";
            case 3:
                return "[" + tonOrKN + "*m^2]";
            case 4:
                return "[" + tonOrKN + "*m^3]";
            default:
                return "------";
        }
    }

    private void initRelevantCategory() {
        Log.d(TAG_CHECK_VALUES, String.format("initCategory() -> moduleActiveId: %s; categoryActiveId: %s; subCategoryActiveId: %s;", moduleActiveId, categoryActiveId, subCategoryActiveId));
//        isPitulSelected = false;
        isTonSelected = false;
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                switch (categoryActiveId) {
                    case BENDING_TOLERANCE_CATEGORY:
                        bendingToleranceCategory = new BendingToleranceCategory();
                        bendingToleranceCategory.setTonOrKnBtn();
                        toolbarTitle = savedVersionTitle != null ? toolbarTitle : getString(R.string.new_math_version);
                        castingBasic(toolbarTitle, categoryActiveId, SUB_CATEGORIES_MANAGER_ACTIVITY, bendingToleranceCategory.onToolbarClickListener, this, this);
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        canopyLengthsCategory = new CanopyLengthsCategory();
                        tonKnBtn_TV.setVisibility(View.GONE);
                        toolbarTitle = savedVersionTitle != null ? toolbarTitle : getString(R.string.new_math_version);
                        castingBasic(toolbarTitle, categoryActiveId, SUB_CATEGORIES_MANAGER_ACTIVITY, null, this, this);
                        break;
                    case PENETRATION_CATEGORY:
                        penetrationCategory = new PenetrationCategory();
                        penetrationCategory.setTonOrKnBtn();
                        toolbarTitle = savedVersionTitle != null ? toolbarTitle : getString(R.string.new_math_version);
                        castingBasic(toolbarTitle, categoryActiveId, SUB_CATEGORIES_MANAGER_ACTIVITY, null, this, this);
                        break;
                    case PAGING_CATEGORY:
                        pagingCategory = new PagingCategory();
                        pagingCategory.setTonOrKnBtn();
                        toolbarTitle = savedVersionTitle != null ? toolbarTitle : getString(R.string.new_math_version);
                        castingBasic(toolbarTitle, categoryActiveId, SUB_CATEGORIES_MANAGER_ACTIVITY, null, this, this);
                        break;
                }
                break;
            case STEEL_MODULE:
                switch (categoryActiveId) {
                    case STEEL_CEILING_CATEGORY:
                        steelCeilingCategory = new SteelCeilingCategory();
                        tonKnBtn_TV.setVisibility(View.VISIBLE);
                        steelCeilingCategory.setTonOrKnBtn();
                        toolbarTitle = savedVersionTitle != null ? toolbarTitle : getString(R.string.new_math_version);
                        castingBasic(toolbarTitle, categoryActiveId, SUB_CATEGORIES_MANAGER_ACTIVITY, null, this, this);
                        break;
                }
                break;
        }
    }

    private void initRelevantSubcategory() {
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                switch (categoryActiveId) {
                    case BENDING_TOLERANCE_CATEGORY:
                        bendingToleranceCategory.initSubcategory();
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        canopyLengthsCategory.initSubcategory();
                        break;
                    case PENETRATION_CATEGORY:
                        penetrationCategory.initSubcategory();
                        break;
                    case PAGING_CATEGORY:
                        pagingCategory.initSubcategory();
                        break;
                }
                break;
            case STEEL_MODULE:
                switch (categoryActiveId) {
                    case STEEL_CEILING_CATEGORY:
                        steelCeilingCategory.initRelevantSubCategory();
                        break;
                }
                break;
        }
    }

    public void initNegativeResults() {
        negativeResults = new ArrayList<>();
        negativeResults.add(getString(R.string.armament_dose_is_too_big));
        negativeResults.add(getString(R.string.amount_is_not_enough));
        negativeResults.add(getString(R.string.not_valid_cut));
        negativeResults.add(getString(R.string.pressure_required));
        negativeResults.add(getString(R.string.cut_of_conrette_is_not_enough));
        negativeResults.add(getString(R.string.spacing_between_rods_not_proper));
        negativeResults.add(getString(R.string.amount_of_branches_not_proper));
        negativeResults.add(getString(R.string.armament_cut_dose_is_not_valid));
        negativeResults.add(getString(R.string.not_valid_femail));
        negativeResults.add(getString(R.string.pitch_is_not_proper));
        negativeResults.add(getString(R.string.armament_dose_is_not_enough));
        negativeResults.add(getString(R.string.armament_amount_for_penetration_is_not_enough));
        negativeResults.add(getString(R.string.tangential_distance_is_not_proper));
        negativeResults.add(getString(R.string.radial_distance_is_not_proper));
        negativeResults.add(getString(R.string.concrete_cut_is_not_enough));
        negativeResults.add(getString(R.string.not_proper_ceiling_height));
        negativeResults.add(getString(R.string.endurance_of_cut_not_valid));
    }

    private void setViewPager() {
        ViewPager viewPager = findViewById(R.id.activity_sub_categories_vp);
        addTabs(viewPager);
        TabLayout tabLayout = findViewById(R.id.activity_sub_categories_tl);
        tabLayout.setBackgroundColor(getColor(R.color.colorSoftWhite));
        tabLayout.setTabTextColors(getColor(android.R.color.black), getColor(R.color.colorWhite));
        tabLayout.setSelectedTabIndicatorHeight(convertDPToInt(40));
        tabLayout.setSelectedTabIndicatorColor(getColor(android.R.color.holo_blue_bright));
        tabLayout.setupWithViewPager(viewPager);
        Log.d("checkHeight", "tabLayout.getHeight() == " + tabLayout.getHeight() + "; convertDPToInt(40) == " + convertDPToInt(40) + "; convertDPToInt() == " + ((getResources().getDisplayMetrics().density + 0.5f) * 40));
    }

    private void addTabs(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new StructuralDesignValuesFragment(), "נתונים משתנים");
        adapter.addFrag(new StructuralDesignResultFragment(), "תוצאות תכן");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                Log.d("checkOnPageScrolled", "scrolled -> position == " + position + "; positionOffset == " + positionOffset + "; positionOffsetPixels == " + positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                Log.d("checkOnPageScrolled", "Selected -> position == " + position);
                if (position == 1) new KeyboardHelper().hideKeyboard();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private int convertDPToInt(int dp) {
        return Integer.parseInt((((getResources().getDisplayMetrics().density + 0.5f) * dp) + "").split("\\.")[0]);
    }

//    private int convertDPToInt(int dp){
//        return Integer.parseInt((TypedValue.applyDimension(
//                TypedValue.COMPLEX_UNIT_DIP,
//                dp,
//                getResources().getDisplayMetrics()) + "").split("\\.")[0]);
//    }

    public void setAdapter(boolean isForSetValues, ArrayList<StructuralDesignModel> models) {
        if (isForSetValues) {
            adapterStructuralDesignValues_RV = new AdapterSubCategoriesRV(models, true);
            Log.d("checkSetAdapter", "isForSetValuesAdapter " + adapterStructuralDesignValues_RV.getItemCount());
            values_RV.setAdapter(adapterStructuralDesignValues_RV);
//            onScrollAction(values_RV, true);
        } else {
            adapterStructuralDesignResult_RV = new AdapterSubCategoriesRV(models, false);
            result_RV.setAdapter(adapterStructuralDesignResult_RV);
//            onScrollAction(result_RV, false);
            Log.d("checkSetAdapter", "isForSetResultAdapter " + adapterStructuralDesignResult_RV.getItemCount());
        }
    }

    private void setOnScrollActions(RecyclerView recyclerViewPassed, boolean isValues, TextView secondaryTitle_TV) {
        recyclerViewPassed.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                switch (moduleActiveId) {
                    case CONCRETE_MODULE:
                        break;
                    case STEEL_MODULE:
                        switch (categoryActiveId) {
                            case STEEL_CEILING_CATEGORY:
                                if (isValues) {
                                    valuesRVPosition = ((LinearLayoutManager) recyclerViewPassed.getLayoutManager()).findFirstVisibleItemPosition();
                                    if (secondaryTitles != null) {
                                        if (valuesRVPosition < 1) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(0));
                                        } else if (valuesRVPosition < 5) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(1));
                                        } else if (valuesRVPosition < 10) {
                                            secondaryTitle_TV.setText("");
                                        } else if (valuesRVPosition < 14) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(6));
                                        } else if (valuesRVPosition < 18) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(7));
                                        } else {
                                            secondaryTitle_TV.setText(secondaryTitles.get(8));
                                        }
                                    }
                                } else {
                                    recyclerView.post(() -> {
                                        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();

                                        resultsRVPosition = linearLayoutManager.findFirstVisibleItemPosition();
                                        Log.d("checkOnScrollStateChanged", "onScrolled -> resultsRVPosition == " + resultsRVPosition);
                                    });

                                    if (secondaryTitles != null) {
                                        if (resultsRVPosition < 12) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(0));
                                        } else if (resultsRVPosition < 16) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(1));
                                        } else if (resultsRVPosition < 18) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(0));
                                        } else if (resultsRVPosition < 22) {
                                            secondaryTitle_TV.setText("");
                                        } else if (resultsRVPosition < 26) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(2));
                                        } else if (resultsRVPosition < 31) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(3));
                                        } else if (resultsRVPosition < 35) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(4));
                                        } else if (resultsRVPosition < 41) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(5));
                                        } else if (resultsRVPosition < 51) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(6));
                                        } else if (resultsRVPosition < 60) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(7));
                                        } else if (resultsRVPosition < 70) {
                                            secondaryTitle_TV.setText(secondaryTitles.get(8));
                                        } else {
                                            secondaryTitle_TV.setText("");
                                        }
                                    }
                                }
                                break;
                        }
                        break;
                }
                Log.d("checkOnScrollStateChanged", "onScrolled -> position == " + ((LinearLayoutManager) recyclerViewPassed.getLayoutManager()).findFirstVisibleItemPosition());
            }
        });
    }

    @Override
    public void valueNumberChangedListener(double valueItemNumber, int valueItemId, int spinnerPosition) {
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                switch (categoryActiveId) {
                    case BENDING_TOLERANCE_CATEGORY:
                        bendingToleranceCategory.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        canopyLengthsCategory.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                        break;
                    case PENETRATION_CATEGORY:
                        penetrationCategory.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                        break;
                    case PAGING_CATEGORY:
                        pagingCategory.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                        break;
                }
                break;
            case STEEL_MODULE:
                switch (categoryActiveId) {
                    case STEEL_CEILING_CATEGORY:
                        steelCeilingCategory.valueNumberChangedListener(valueItemNumber, valueItemId, spinnerPosition);
                        break;
                }
                break;
        }
    }

    @Override
    public void setRecycleView(RecyclerView relevantRecycleView, boolean isForSetValues, TextView secondaryTitle) {
        setOnScrollActions(relevantRecycleView, isForSetValues, secondaryTitle);
        if (isForSetValues) {
            values_RV = relevantRecycleView;
            Log.d(TAG_CHECK_VALUES, String.format("setRecycleView() -> values_RV.getId(): %s", values_RV.getId()));
        } else {
            result_RV = relevantRecycleView;
            Log.d(TAG_CHECK_VALUES, String.format("setRecycleView() -> result_RV.getId(): %s", result_RV.getId()));
            initRelevantSubcategory();
        }
    }

    @Override
    public void onAsyncPostResult(String... result) {

    }

    static class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public boolean getIsNegativeResult(String result) {
        Log.d("checkIsNaN", "result == " + result);
        try {
            Log.d("checkIsNaN", "getIsNumber(result) == " + getIsNumber(result));
            if (getIsNumber(result) && Double.parseDouble(result) < 0) {
                Log.d("checkIsNaN", "!(Double.isNaN(Double.parseDouble(result))) && Double.parseDouble(result) < 0");
                return true;
            } else {
                if (negativeResults.contains(result)) {
                    Log.d("checkIsNaN", "negativeResults.contains(result) == true");
                    return true;
                }
                Log.d("checkIsNaN", "negativeResults.contains(result) == false");
                return false;
            }
        } catch (NumberFormatException e) {
            Log.d("checkIsNaN", "ERROR: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public void setResultModelsPositions() {
        for (int i = 0; i < resultModels.size(); i++) {
            resultPositionsByIds.put(resultModels.get(i).getId(), i);
        }
    }

    public void setValuesModelsPositions() {
        for (int i = 0; i < valuesModels.size(); i++) {
            valuesPositionsByIds.put(valuesModels.get(i).getId(), i);
        }
    }

    public void setRelevantResultItem_value(int itemId, String value, String measuringUnitTwo) {
        Log.d("checkSetRelevantResultItem_value", "itemId == " + itemId + "; value == " + value);
        Log.d("checkSetRelevantResultItem_value", "positionByIds == " + resultPositionsByIds);
        adapterStructuralDesignResult_RV.setRelevantItemValue(resultPositionsByIds.get(itemId), value, measuringUnitTwo);
        adapterStructuralDesignResult_RV.notifyDataSetChanged();
    }

    public void setRelevantValueItemMeasuringUnit(int itemId, String measuringUnitTwo) {
        Log.d("checkSetRelevantResultItem_value", "itemId == " + itemId);
        Log.d("checkSetRelevantResultItem_value", "positionByIds == " + valuesPositionsByIds);
        adapterStructuralDesignValues_RV.setRelevantItemMeasuringUnit(valuesPositionsByIds.get(itemId), measuringUnitTwo);
        adapterStructuralDesignValues_RV.notifyDataSetChanged();
    }

    @SuppressLint("LongLogTag")
    public void setRelevantValueItem_position(int itemId, int position) {
        Log.d("setRelevantPosition", "setRelevantResultItem_position() -> itemId == " + itemId + "; position == " + position);
        Log.d("setRelevantPosition", "setRelevantResultItem_position() -> positionByIds == " + resultPositionsByIds);
        adapterStructuralDesignValues_RV.setRelevantItemPosition(resultPositionsByIds.get(itemId), position);
        adapterStructuralDesignValues_RV.notifyDataSetChanged();
    }

    public void setResultItemsPositionsById() {
        for (int i = 0; i < resultModels.size(); i++) {
            resultPositionsByIds.put(resultModels.get(i).getId(), i);
        }
    }

    public boolean setDialogInputReturnMsgIfErr() {
        cursor = sqlLocal.selectFourComparesCursor(DBModel.COLUMN_ID, DialogHelper.input);
        if (isKindOfNull(DialogHelper.input)) {
            DialogHelper.input_ET.setError(context.getString(R.string.cannot_be_empty));
            DialogHelper.input_ET.requestFocus();
            return true;
        } else if (cursor.moveToFirst()) {
            DialogHelper.input_ET.setError(context.getString(R.string.this_name_exists));
            DialogHelper.input_ET.requestFocus();
            return true;
        }
        return false;
    }

    public String getTonOrKnVal(double v) {
        Log.d("checkMath", "getTonOrKtonVal -> v == " + v + "; isTonSelected == " + isTonSelected);
        return isTonSelected ? (v / 10) + "" : v + "";
    }

    @Override
    public void onBackPressed() {
        Log.d("checkBackPressed", "onBackPressed() savedVersionTitle == " + savedVersionTitle);
        dialogHelper.initThreeButtonsDialog("האם לשמור חישוב זה?",
                onDialogBtnClickListener.positiveBtnClicked(),
                v -> {
                    dialog.dismiss();
                    super.onBackPressed();
                },
                getString(R.string.yes), getString(R.string.no));
    }

    private void insertOrUpdateVersion(boolean isForInsert) {
        Log.d("checkBackPressed", "insertOrUpdateVersion() isForInsert == " + isForInsert);
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                switch (categoryActiveId) {
                    case BENDING_TOLERANCE_CATEGORY:
                        bendingToleranceCategory.insertOrUpdateVersion(isForInsert);
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        canopyLengthsCategory.insertOrUpdateVersion(isForInsert);
                        break;
                    case PENETRATION_CATEGORY:
                        penetrationCategory.insertOrUpdateVersion(isForInsert);
                        break;
                    case PAGING_CATEGORY:
                        pagingCategory.insertOrUpdateVersion(isForInsert);
                        break;
                }
                break;
            case STEEL_MODULE:
                switch (categoryActiveId) {
                    case STEEL_CEILING_CATEGORY:
                        steelCeilingCategory.insertOrUpdateVersion(isForInsert);
                        break;
                }
                break;
        }
    }


    @Override
    public View.OnClickListener positiveBtnClicked() {
        return v -> {
            if (savedVersionTitle != null) {
                dialogHelper.initThreeButtonsDialog("שמור כחישוב:",
                        v1 -> {
                            dialog.dismiss();
                            insertOrUpdateVersion(true);
                        },
                        v1 -> {
                            dialog.dismiss();
                            insertOrUpdateVersion(false);
                        },
                        context.getString(R.string.newV), context.getString(R.string.current));
            } else {
                if (dialog != null) dialog.dismiss();
                insertOrUpdateVersion(true);
            }
        };
    }

}

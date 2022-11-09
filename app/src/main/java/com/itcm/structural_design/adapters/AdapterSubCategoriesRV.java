package com.itcm.structural_design.adapters;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;
import com.itcm.structural_design.modules.concrete.bending_tolerance.BendingToleranceCategory;
import com.itcm.structural_design.modules.concrete.canopy_length.CanopyLengthsCategory;
import com.itcm.structural_design.modules.concrete.paging.PagingCategory;
import com.itcm.structural_design.modules.concrete.penetration.PenetrationCategory;
import com.itcm.structural_design.interfaces.FragmentListener;
import com.itcm.structural_design.models.StructuralDesignModel;
import com.itcm.structural_design.modules.steel.SteelCeilingCategory;

import java.util.ArrayList;
import java.util.Arrays;

import static com.itcm.structural_design.activities.BasicActivity.BENDING_TOLERANCE_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.CANOPY_LENGTHS_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.CONCRETE_MODULE;
import static com.itcm.structural_design.activities.BasicActivity.PAGING_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.PENETRATION_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.STEEL_CEILING_CATEGORY;
import static com.itcm.structural_design.activities.BasicActivity.STEEL_MODULE;
import static com.itcm.structural_design.activities.BasicActivity.categoryActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.moduleActiveId;
import static com.itcm.structural_design.activities.SubCategoriesManagerActivity.subCategoryActiveId;

public class AdapterSubCategoriesRV extends RecyclerView.Adapter<AdapterSubCategoriesRV.ViewHolder> {

    private final ArrayList<StructuralDesignModel> models;
    private final boolean isForSetValues;
    private FragmentListener fragmentListener;
    private ArrayMap<Integer, TextView> editTextsList;
    private StructuralDesignModel structuralDesignModel;
    private boolean isValueNegative;
    private int colorID;
    private SubCategoriesManagerActivity subCategoriesManagerActivity;
    private BendingToleranceCategory bendingToleranceCategory;
    private CanopyLengthsCategory canopyLengthsCategory;
    private PenetrationCategory penetrationCategory;
    private PagingCategory pagingCategory;
    private SteelCeilingCategory steelCeilingCategory;

    public AdapterSubCategoriesRV(ArrayList<StructuralDesignModel> models, boolean isForSetValues) {
        this.models = models;
        this.isForSetValues = isForSetValues;
        init();
        Log.d("checkAdapter", "AdapterSubCategoriesRV() models.size() == " + models.size());
    }

    private void init() {
        subCategoriesManagerActivity = new SubCategoriesManagerActivity();
        fragmentListener = (FragmentListener) context;
        editTextsList = new ArrayMap<>();
        switch (moduleActiveId) {
            case CONCRETE_MODULE:
                switch (categoryActiveId) {
                    case BENDING_TOLERANCE_CATEGORY:
                        bendingToleranceCategory = new BendingToleranceCategory();
                        break;
                    case CANOPY_LENGTHS_CATEGORY:
                        canopyLengthsCategory = new CanopyLengthsCategory();
                        break;
                    case PENETRATION_CATEGORY:
                        penetrationCategory = new PenetrationCategory();
                        break;
                    case PAGING_CATEGORY:
                        pagingCategory = new PagingCategory();
                        break;
                }
                break;
            case STEEL_MODULE:
                switch (categoryActiveId) {
                    case STEEL_CEILING_CATEGORY:
                        steelCeilingCategory = new SteelCeilingCategory();
                        break;
                }
                break;
        }
    }

    private void setNumberPickerVisibilityRelevantAction(ViewHolder holder, boolean isSpinnerVisible) {
        holder.measuringNumber_ET.setVisibility(isSpinnerVisible ? View.GONE : View.VISIBLE);
        holder.spinner_LL.setVisibility(isSpinnerVisible ? View.VISIBLE : View.GONE);
        if (!isSpinnerVisible) {
            holder.measuringNumber_ET.setText(structuralDesignModel.getResultTitle());
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_sub_categories, parent, false));
    }

    public void setRelevantItemValue(int position, String valueString, String measuringUnitTwo) {
        Log.d("checkSetRelevantValue", "position == " + position + "; getId() == " + models.get(position).getId() + "; valueString == " + valueString + "; isNumberNegative == " + isValueNegative);
        colorID = subCategoriesManagerActivity.getIsNegativeResult(valueString) ? R.color.colorRed : R.color.colorGray;
        models.get(position).setResultTitle(valueString);
        if (!measuringUnitTwo.equals("")) {
            models.get(position).setMeasuringUnitTwo(measuringUnitTwo);
        }
    }

    public void setRelevantItemMeasuringUnit(int position, String measuringUnitTwo) {
        Log.d("checkSetRelevantValue", "position == " + position + "; getId() == " + models.get(position).getId() + "; measuringUnitTwo == " + measuringUnitTwo);
        if (!measuringUnitTwo.equals(""))
            models.get(position).setMeasuringUnitTwo(measuringUnitTwo);
    }

    public void setRelevantItemPosition(int itemPosition, int numberPickerPosition) {
        models.get(itemPosition).setPickerPosition(numberPickerPosition);
        Log.d("setRelevantPosition", "Adapter{} -> itemPosition == " + itemPosition + "; getId() == " + models.get(itemPosition).getId() + "; numberPickerPosition == " + numberPickerPosition + "; models.get(itemPosition).getPickerPosition() == " + models.get(itemPosition).getPickerPosition());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        structuralDesignModel = models.get(position);
        holder.setModel(structuralDesignModel);
        if (structuralDesignModel.getId() == 0) {
            setCategoryTitleItem(holder, position);
        } else {
            setStandardItem(holder, position);
        }
        Log.d("checkOnBindViewHolder", "models.get(position).getId() == " + models.get(position).getId() + "; position == " + position + "; isValueNegative == " + isValueNegative + "; getMeasuringNumberNoN() == " + models.get(position).getResultTitle());
    }

    private void setStandardItem(ViewHolder holder, int position) {
        holder.title_TV.setText(models.get(position).getTitle() + "");
        holder.measuringUnitOne_tv.setText(models.get(position).getMeasuringUnitOne());
        holder.measuringUnitTwo_tv.setText(models.get(position).getMeasuringUnitTwo());
        holder.allAreas_LL.setVisibility(View.VISIBLE);
        holder.categoryTitle_TV.setVisibility(View.GONE);
        holder.itemViewMain_LL.setPadding(0, 0, 0, position == models.size() - 1 ? 1000 : 0);
        if (!isForSetValues) {
            holder.measuringNumber_ET.setVisibility(View.GONE);
            holder.result_tv.setVisibility(View.VISIBLE);
            isValueNegative = subCategoriesManagerActivity.getIsNegativeResult(structuralDesignModel.getResultTitle());
            colorID = isValueNegative ? R.color.colorRed : R.color.colorGreenBright;
            holder.result_tv.setTextColor(context.getColor(colorID));
            holder.result_tv.setTextSize(20);
            holder.result_tv.setText(structuralDesignModel.getResultTitle());
            editTextsList.put(position, holder.result_tv);
        } else {
            switch (moduleActiveId) {
                case CONCRETE_MODULE:
                    switch (categoryActiveId) {
                        case BENDING_TOLERANCE_CATEGORY:
                            setValuesOf_BTCategory(holder, position);
                            break;
                        case CANOPY_LENGTHS_CATEGORY:
                            setValuesOf_CLCategory(holder, position);
                            break;
                        case PENETRATION_CATEGORY:
                            setValuesOf_PenetrationCategory(holder, position);
                            break;
                        case PAGING_CATEGORY:
                            switch (subCategoryActiveId) {
                                case 0:
                                    setValuesOf_PagingSubCategory_one(holder, position);
                                    break;
                                case 1:
                                    setValuesOf_PagingSubCategory_two(holder, position);
                                    break;
                            }
                            break;
                    }
                    break;
                case STEEL_MODULE:
                    switch (categoryActiveId) {
                        case STEEL_CEILING_CATEGORY:
                            setValuesOf_SteelCeilingCategory(holder, position);
                            break;
                    }
                    break;
            }
        }
    }

    private void setCategoryTitleItem(ViewHolder holder, int position) {
        holder.allAreas_LL.setVisibility(View.GONE);
        holder.categoryTitle_TV.setVisibility(View.VISIBLE);
        holder.categoryTitle_TV.setText(models.get(position).getTitle() + "");
    }

    private void setValuesOf_SteelCeilingCategory(ViewHolder holder, int position) {
        String[] relevantSubCategoryArray;
        switch (subCategoryActiveId) {
            case 1:
            case 2:
                relevantSubCategoryArray = steelCeilingCategory.getHebAndHea_stringValues();
                break;
            case 0:
            default:
                relevantSubCategoryArray = steelCeilingCategory.getIPN_stringValues();
                break;
        }

        switch (models.get(position).getId()) {
            case 1:
            case 14:
            case 47:
            case 59:
                setNumberPickerVisibilityRelevantAction(holder, true);
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                switch (models.get(position).getId()) {
                    case 1:
                        holder.setSpinner(relevantSubCategoryArray);
                        break;
                    case 14:
                        holder.setSpinner(steelCeilingCategory.getSteelType_stringValues());
                        break;
                    case 47:
                    case 59:
                        holder.setSpinner(steelCeilingCategory.getFromAToD_stringValues());
                        break;
                }
                break;
            default:
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    private void setValuesOf_PagingSubCategory_two(ViewHolder holder, int position) {
        Log.d("setValuesOnBind", "Adapter{} -> subCategoryActive == " + subCategoryActiveId);
        switch (models.get(position).getId()) {
            case 6:
            case 9:
            case 21:
            case 22:
            case 34:
            case 35:
            case 42:
            case 51:
            case 58:
            case 70:
            case 77:
            case 85:
            case 86:
            case 94:
            case 116:
            case 270:
                setNumberPickerVisibilityRelevantAction(holder, true);
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                switch (models.get(position).getId()) {
                    case 6:
                        holder.setSpinner(pagingCategory.getConcreteType_StringValues());
                        break;
                    case 9:
                        holder.setSpinner(pagingCategory.getFrom_400_to_500_stringValues());
                        break;
                    case 21:
                    case 34:
                        holder.setSpinner(pagingCategory.getFrom_2_to_4_stringValues());
                        break;
                    case 22:
                    case 35:
                    case 270:
                        holder.setSpinner(pagingCategory.getFrom_8_to_25_stringValues());
                        break;
                    case 42:
                    case 85:
                        holder.unitOneArea_RL.setVisibility(View.GONE);
                        holder.unitTwoArea_RL.setVisibility(View.GONE);
                        holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 4.0f));
                        holder.setSpinner(pagingCategory.getFrame_types_stringValues());
                        break;
                    case 51:
                    case 58:
                    case 70:
                    case 77:
                        holder.setSpinner(pagingCategory.getSuspendedSuspensionCondition_stringValues());
                        break;
                    case 86:
                    case 94:
                        holder.unitOneArea_RL.setVisibility(View.GONE);
                        holder.unitTwoArea_RL.setVisibility(View.GONE);
                        holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 4.0f));
                        holder.setSpinner(pagingCategory.getConnectionTypes_stringValues());
                        break;
                    case 116:
                        holder.setSpinner(pagingCategory.getFrom_2_to_10_stringValues());
                        break;
                }
                break;
            default:
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    private void setValuesOf_PagingSubCategory_one(ViewHolder holder, int position) {
        Log.d("setValuesOnBind", "Adapter{} -> subCategoryActive == " + subCategoryActiveId);
        switch (models.get(position).getId()) {
            case 1:
            case 17:
            case 30:
            case 37:
            case 47:
            case 50:
            case 66:
            case 70:
            case 78:
                setNumberPickerVisibilityRelevantAction(holder, true);
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                switch (models.get(position).getId()) {
                    case 1:
                        holder.unitOneArea_RL.setVisibility(View.GONE);
                        holder.unitTwoArea_RL.setVisibility(View.GONE);
                        holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 4.0f));
                        holder.setSpinner(pagingCategory.getFrame_types_stringValues());
                        break;
                    case 17:
                    case 30:
                    case 37:
                        holder.setSpinner(pagingCategory.getSuspendedSuspensionCondition_stringValues());
                        break;
                    case 47:
                    case 70:
                        holder.setSpinner(pagingCategory.getConcreteType_StringValues());
                        break;
                    case 66:
                        holder.setSpinner(pagingCategory.getFrom_8_to_10_stringValues());
                        break;
                    case 50:
                    case 78:
                        holder.setSpinner(pagingCategory.getFrom_400_to_500_stringValues());
                        break;
                }
                break;
            default:
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    private void setValuesOf_PenetrationCategory(ViewHolder holder, int position) {
        Log.d("setValuesOnBind", "Adapter{} -> subCategoryActive == " + subCategoryActiveId);
        switch (models.get(position).getId()) {
            case 9:
            case 10:
            case 15:
            case 16:
            case 22:
            case 23:
            case 25:
            case 36:
            case 43:
            case 62:
            case 69:
            case 4000:
                setNumberPickerVisibilityRelevantAction(holder, true);
                switch (models.get(position).getId()) {
                    case 9:
                    case 15:
                        holder.setSpinner(penetrationCategory.getFrom_7_5_to_20_stringValues());
                        break;
                    case 10:
                    case 16:
                    case 36:
                    case 62:
                        holder.setSpinner(penetrationCategory.getFrom_8_to_25_stringValues());
                        break;
                    case 22:
                        holder.setSpinner(penetrationCategory.getConcreteType_StringValues());
                        break;
                    case 23:
                        holder.setSpinner(penetrationCategory.getFrom_400_to_500_stringValues());
                        break;
                    case 25:
                        switch (subCategoryActiveId) {
                            case 3:
                            case 4:
                                holder.setSpinner(penetrationCategory.getFrom_1_4_to_1_5_stringValues());
                                break;
                            default:
                                holder.setSpinner(penetrationCategory.getFrom_1_15_to_1_15_stringValues());
                                break;
                        }
                        break;
                    case 43:
                        holder.setSpinner(penetrationCategory.getFrom_45_to_90_stringValues());
                        break;
                    case 69:
                        holder.setSpinner(penetrationCategory.getScopeNumbers_stringValues());
                        break;
                    case 4000:
                        holder.setSpinner(penetrationCategory.getFrom_2_to_24_stringValues());
                        break;
                }
                break;
            default:
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    private void setValuesOf_BTCategory(ViewHolder holder, int position) {
        switch (models.get(position).getId()) {
            case 1000:
            case 2:
            case 10:
            case 25:
            case 26:
            case 27:
            case 28:
            case 57:
            case 58:
            case 88:
            case 92:
            case 2026:
            case 2034:
            case 2042:
            case 2048:
            case 2027:
            case 2035:
            case 2043:
            case 2049:
                setNumberPickerVisibilityRelevantAction(holder, true);
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                Log.d("checkNumberPicker", "OUTSIDE position == " + position + "; models.get(position).getId() == " + models.get(position).getId() + "; models.get(position).getPickerPosition() == " + models.get(position).getPickerPosition());
                switch (models.get(position).getId()) {
                    case 1000:
                        holder.unitOneArea_RL.setVisibility(View.GONE);
                        holder.unitTwoArea_RL.setVisibility(View.GONE);
                        holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 14.0f));
                        holder.setSpinner(bendingToleranceCategory.getId_1000_stringValues());
                        holder.spinnerTitle_TV.setTextSize(15);
                        break;
                    case 2:
                        holder.setSpinner(bendingToleranceCategory.getConcreteType_StringValues());
                        break;
                    case 10:
                        holder.setSpinner(bendingToleranceCategory.getFrom_400_to_500_stringValues());
                        break;
                    case 25:
                    case 26:
                        holder.setSpinner(bendingToleranceCategory.getFrom_2_to_9_stringValues());
                        break;
                    case 27:
                    case 28:
                    case 88:
                    case 58:
                    case 92:
                        holder.setSpinner(bendingToleranceCategory.getFrom_8_to_25_stringValues());
                        break;
                    case 57:
                        holder.setSpinner(bendingToleranceCategory.getFrom_2_to_10_stringValues());
                        break;
                    case 2026:
                    case 2034:
                    case 2042:
                    case 2048:
                        holder.setSpinner(bendingToleranceCategory.getFrom_10_to_30_stringValues());
                        break;
                    case 2027:
                    case 2035:
                    case 2043:
                    case 2049:
                        holder.setSpinner(bendingToleranceCategory.getFrom_12_to_25_stringValues());
                        break;
                }
                Log.d("checkNumberPicker", "INSIDE  position == " + position + "; models.get(position).getId() == " + models.get(position).getId() + "; models.get(position).getPickerPosition() == " + models.get(position).getPickerPosition());
                break;
            default:
                holder.unitOneArea_RL.setVisibility(View.VISIBLE);
                holder.unitTwoArea_RL.setVisibility(View.VISIBLE);
                holder.resultArea_RL.setLayoutParams(new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT, 2.0f));
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    private void setValuesOf_CLCategory(ViewHolder holder, int position) {
        switch (models.get(position).getId()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 15:
            case 102:
            case 104:
                setNumberPickerVisibilityRelevantAction(holder, true);
                switch (models.get(position).getId()) {
                    case 1:
                        holder.setSpinner(canopyLengthsCategory.getId_1_stringValues());
                        break;
                    case 2:
                        holder.setSpinner(canopyLengthsCategory.getConcreteType_StringValues());
                        break;
                    case 3:
                        holder.setSpinner(canopyLengthsCategory.getId_3_stringValues());
                        break;
                    case 4:
                        holder.setSpinner(canopyLengthsCategory.getId_4_stringValues());
                        break;
                    case 15:
                        holder.setSpinner(canopyLengthsCategory.getId_15_stringValues());
                        break;
                    case 102:
                        holder.setSpinner(canopyLengthsCategory.getId_102_stringValues());
                        break;
                    case 104:
                        holder.setSpinner(canopyLengthsCategory.getId_104_stringValues());
                        break;
                }
                break;
            default:
                setNumberPickerVisibilityRelevantAction(holder, false);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements TextWatcher, View.OnFocusChangeListener, AdapterView.OnItemSelectedListener, View.OnTouchListener {

        private TextView title_TV;
        private TextView result_tv;
        private TextView measuringUnitTwo_tv;
        private TextView measuringUnitOne_tv;
        private RelativeLayout titleArea_RL;
        private EditText measuringNumber_ET;
        private StructuralDesignModel model;
        private double valOnFocus = 0;
        private String onTextChangeVal = "";
        private RelativeLayout unitOneArea_RL, unitTwoArea_RL, resultArea_RL;
        private ArrayList<String> spinnerArray;
        private TextView spinnerTitle_TV;
        private Spinner spinner;
        private ArrayAdapterSpinner arrayAdapter;
        private RelativeLayout spinnerItem;
        private View bottomLine_V;
        private RelativeLayout itemViewMain_LL;
        private LinearLayout allAreas_LL, spinner_LL;
        private TextView categoryTitle_TV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemViewMain_LL = itemView.findViewById(R.id.item_view_sub_categories_main_item);
            title_TV = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_title_tv);
            titleArea_RL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_title_rl);
            result_tv = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_result_tv);
            measuringNumber_ET = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_number_et);
            measuringUnitOne_tv = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_unit_one_tv);
            measuringUnitTwo_tv = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_unit_two_tv);
            resultArea_RL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_result_area_rl);
            unitOneArea_RL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_unit_one_rl);
            unitTwoArea_RL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_measuring_unit_two_rl);
            bottomLine_V = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_bottom_line);
            allAreas_LL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_all_areas_ll);
            categoryTitle_TV = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_category_title_tv);
            Log.d("numberChangedListener", "AdapterSubCategoriesRV{} -> editTextsList.size() == " + editTextsList.size() + "; model == " + model + "; isForSetValues == " + isForSetValues);
            if (isForSetValues) {
                measuringNumber_ET.setOnTouchListener(this);
                measuringNumber_ET.addTextChangedListener(this);
                measuringNumber_ET.setOnFocusChangeListener(this);
                spinnerTitle_TV = itemViewMain_LL.findViewById(R.id.layout_spinner_title_tv);
                spinner = itemViewMain_LL.findViewById(R.id.layout_spinner_spinner);
                spinnerItem = itemViewMain_LL.findViewById(R.id.layout_spinner_main_rl);
                spinner_LL = itemViewMain_LL.findViewById(R.id.item_view_sub_categories_layout_spinner_ll);
            }
        }

        public void setSpinner(String[] spinnerArray) {
            this.spinnerArray = new ArrayList(Arrays.asList(spinnerArray));
            arrayAdapter = new ArrayAdapterSpinner(spinnerArray);
            spinnerTitle_TV.post(() -> {
                spinner.setAdapter(arrayAdapter);
                spinnerItem.setOnClickListener(view -> {
                    Log.d("checkSpinner", "ViewHolder{} -> setSpinner() -> OnClickListener() -> this.spinnerArray == " + this.spinnerArray);
                    spinner.performClick();
                });
                spinner.setOnItemSelectedListener(this);
                spinner.setDropDownWidth(spinnerTitle_TV.getWidth());
                spinnerTitle_TV.setText(spinnerArray[model.getPickerPosition()]);
                spinner.setSelection(model.getPickerPosition());
            });
            Log.d("checkSpinner", "ViewHolder{} setSpinner() -> this.spinnerArray == " + this.spinnerArray);
        }

        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
            if (position != model.getPickerPosition()) {
                spinnerTitle_TV.setText(spinnerArray.get(position));
                Log.d("checkSpinner", "onItemSelected() -> position == " + position + "; l == " + l + "; model.getId() == " + model.getId());
                model.setPickerPosition(position);
                fragmentListener.valueNumberChangedListener(0, model.getId(), position);
            }
        }

        @Override
        public void onFocusChange(View view, boolean isFocused) {
            if (isFocused) {
                valOnFocus = Double.parseDouble(measuringNumber_ET.getText().toString());
                measuringNumber_ET.setSelectAllOnFocus(true);
            } else {
                if (onTextChangeVal.equals("0") || onTextChangeVal.equals("") || onTextChangeVal.equals(".")) {
                    measuringNumber_ET.setText(valOnFocus + "");
                    measuringNumber_ET.setError(null);
                }
            }
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (model != null) {
                onTextChangeVal = charSequence.toString();
                if (!charSequence.toString().equals("") && !charSequence.toString().equals(".")) {
                    if (Double.parseDouble(charSequence.toString()) == 0) {
                        measuringNumber_ET.setError("לא יכול להיות 0");
                    } else {
                        if ((onTextChangeVal.charAt(0) + "").equals(".")) {
                            measuringNumber_ET.setText("0.");
                            measuringNumber_ET.setSelection(2);
                            onTextChangeVal = measuringNumber_ET.getText().toString();
                            Log.d("numberChangedListener", "AdapterSubCategoriesRV{} -> model.getId() == " + model.getId() + "; charSequence == " + charSequence + "; onTextChangeVal == " + onTextChangeVal);
                        }
                        model.setResultTitle(onTextChangeVal);
                        fragmentListener.valueNumberChangedListener(Double.parseDouble(onTextChangeVal), model.getId(), 0);
                    }
                }
            }
        }

        public void setModel(StructuralDesignModel structuralDesignModel) {
            this.model = structuralDesignModel;
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
        }

        @Override
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                measuringNumber_ET.setSelectAllOnFocus(true);
            }
            return false;
        }
    }
}

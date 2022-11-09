package com.itcm.structural_design.views;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.CategoriesActivity;
import com.itcm.structural_design.activities.ModulesActivity;
import com.itcm.structural_design.activities.ProfileActivity;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;

import static com.itcm.structural_design.activities.BasicActivity.activityActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;

public class ToolbarCustom {

  public final TextView positiveBtnTV;

  public ToolbarCustom(Activity activity, ActionBar actionBar, String title, View.OnClickListener onToolbarClickListener){

    String titlePassed = title != null ? title : "תכן הנדסה בניין";
    TextView titleTV = activity.findViewById(R.id.toolbar_custom_title_tv);
    positiveBtnTV = activity.findViewById(R.id.toolbar_custom_positive_btn_tv);
    ImageView logoIV = activity.findViewById(R.id.toolbar_custom_logo_iv);
    titleTV.setText(titlePassed);
    titleTV.setPadding(0,0,140,0);

    switch (activityActiveId){
      case ModulesActivity.MODULES_ACTIVITY:
        logoIV.setVisibility(View.VISIBLE);
        positiveBtnTV.setVisibility(View.GONE);
        break;
      case CategoriesActivity.CATEGORIES_ACTIVITY:
      case SubCategoriesManagerActivity.SUB_CATEGORIES_MANAGER_ACTIVITY:
        positiveBtnTV.setVisibility(View.GONE);
        break;
      case ProfileActivity.PROFILE_ACTIVITY:
        positiveBtnTV.setVisibility(View.VISIBLE);
        positiveBtnTV.setText("התנתק");
        positiveBtnTV.setTextColor(context.getColor(R.color.colorRed));
        positiveBtnTV.setOnClickListener(onToolbarClickListener);
        break;
      default:
        logoIV.setVisibility(View.GONE);
        positiveBtnTV.setVisibility(View.GONE);
        break;
    }

    RelativeLayout.LayoutParams zeroWidthParam = new RelativeLayout.LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
    zeroWidthParam.addRule(RelativeLayout.ALIGN_PARENT_END);
    int options = ActionBar.DISPLAY_SHOW_CUSTOM | ActionBar.DISPLAY_HOME_AS_UP ;
    actionBar.setDisplayOptions(options);
  }
}

package com.itcm.structural_design.views;

import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.ActionBarDrawerToggle;

import com.bumptech.glide.Glide;
import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.AboutActivity;
import com.itcm.structural_design.activities.BasicActivity;
import com.itcm.structural_design.activities.ContactActivity;
import com.itcm.structural_design.activities.ModulesActivity;
import com.itcm.structural_design.activities.CategoriesActivity;
import com.itcm.structural_design.activities.ProfileActivity;
import com.itcm.structural_design.database.DBModel;

import java.io.File;

public class Drawer extends BasicActivity {

    private TextView email_TV, name_TV;

    public Drawer(Activity activity) {
        initDrawer(activity);
    }

    public void initDrawer(final Activity activity) {
        drawerLayout = activity.findViewById(R.id.drawer_layout);
        email_TV = activity.findViewById(R.id.drawer_layout_profile_email);
        profileImageLocalPath = sqlLocal.getStringFromUsersTable(DBModel.COLUMN_PROFILE_IMAGE_LOCAL_PATH);
        ImageView userImage_IV = activity.findViewById(R.id.drawer_layout_profile_image_iv);
        Log.d("checkUserImageLocalPath", "Drawer{} -> userPictureLocalPath == " + profileImageLocalPath);
        if (profileImageLocalPath != null && new File(profileImageLocalPath).exists())
            Glide.with(context).load(profileImageLocalPath).centerCrop().into(userImage_IV);

        name_TV = activity.findViewById(R.id.drawer_layout_profile_name);
        toggle = new ActionBarDrawerToggle(activity, drawerLayout, R.string.open_drawer, R.string.close_drawer);
        drawerLayout.setDrawerListener(toggle);
        LinearLayout
                home_LL = activity.findViewById(R.id.drawer_layout_home_btn_linear_layout),
                design_LL = activity.findViewById(R.id.drawer_layout_design_ll),
                steel_LL = activity.findViewById(R.id.drawer_layout_steel_ll),
                concrete_LL = activity.findViewById(R.id.drawer_layout_concrete_ll),
                contactUs_LL = activity.findViewById(R.id.drawer_layout_contact_ll),
                aboutUs_LL = activity.findViewById(R.id.drawer_layout_about_ll),
                statics_LL = activity.findViewById(R.id.drawer_layout_statics_ll);
        RelativeLayout profile_LL = activity.findViewById(R.id.drawer_layout_profile_rl);

        home_LL.setOnClickListener(onDrawerItemsClickListener);
        design_LL.setOnClickListener(onDrawerItemsClickListener);
        steel_LL.setOnClickListener(onDrawerItemsClickListener);
        concrete_LL.setOnClickListener(onDrawerItemsClickListener);
        statics_LL.setOnClickListener(onDrawerItemsClickListener);
        profile_LL.setOnClickListener(onDrawerItemsClickListener);
        contactUs_LL.setOnClickListener(onDrawerItemsClickListener);
        aboutUs_LL.setOnClickListener(onDrawerItemsClickListener);

        Log.d("checkLoginDetails", "Drawer{} -> currentUserEmailGlobal == " + currentUserEmailGlobal + "; userName == " + currentUserNameGlobal);
        if (currentUserEmailGlobal != null) {
            email_TV.setVisibility(View.VISIBLE);
            name_TV.setVisibility(View.VISIBLE);
            email_TV.setText(currentUserEmailGlobal);
            name_TV.setText(currentUserNameGlobal);
        } else {
            email_TV.setVisibility(View.GONE);
            name_TV.setVisibility(View.GONE);
        }
    }

    View.OnClickListener onDrawerItemsClickListener = view -> {
        switch (view.getId()) {
            case R.id.drawer_layout_home_btn_linear_layout:
                startRelevantActivityCloseDrawerStartActivity(ModulesActivity.class, 0);
                break;
            case R.id.drawer_layout_design_ll:
//        startRelevantActivityCloseDrawerStartActivity(CategoriesActivity.class, DESIGN_MODULE);
                break;
            case R.id.drawer_layout_concrete_ll:
                startRelevantActivityCloseDrawerStartActivity(CategoriesActivity.class, CONCRETE_MODULE);
                break;
            case R.id.drawer_layout_steel_ll:
                startRelevantActivityCloseDrawerStartActivity(CategoriesActivity.class, STEEL_MODULE);
                break;
            case R.id.drawer_layout_statics_ll:
//          startRelevantActivityCloseDrawersOpenedWindows(ProfileActivity.class, ProfileActivity.PROFILE_ACTIVITY);
                break;
            case R.id.drawer_layout_profile_rl:
                startRelevantActivityCloseDrawerStartActivity(ProfileActivity.class, -1);
                break;
            case R.id.drawer_layout_about_ll:
                startRelevantActivityCloseDrawerStartActivity(AboutActivity.class, -2);
                break;
            case R.id.drawer_layout_contact_ll:
                startRelevantActivityCloseDrawerStartActivity(ContactActivity.class, -3);
                break;
        }
    };
}

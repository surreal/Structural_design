package com.itcm.structural_design.adapters;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SubCategoriesManagerActivity;
import com.itcm.structural_design.database.DBModel;

import static com.itcm.structural_design.activities.BasicActivity.SAVED_VERSION_TITLE;
import static com.itcm.structural_design.activities.BasicActivity.SUB_CATEGORY_POSITION;
import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.categoryActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.toolbarTitle;

public class AdapterVersionsRV extends RecyclerView.Adapter<AdapterVersionsRV.ViewHolder> {


    private final Cursor cursor;

    public AdapterVersionsRV(Cursor cursor){
        this.cursor = cursor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_view_text, parent, false);
        return new ViewHolder(itemView);
    }

    @SuppressLint("Range")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        cursor.moveToPosition(position);
        holder.setCursor(cursor);
        holder.setTitle(cursor.getString(cursor.getColumnIndex(DBModel.COLUMN_TITLE)));
        holder.setSubcategoryPosition(cursor.getInt(cursor.getColumnIndex(DBModel.COLUMN_SUB_CATEGORY_POSITION)));
        holder.title_tv.setText(cursor.getString(cursor.getColumnIndex(DBModel.COLUMN_TITLE)));
    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView title_tv;
        private String title;
        private int subcategoryPosition;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title_tv = itemView.findViewById(R.id.item_vew_text_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            toolbarTitle = title_tv.getText().toString();
            Log.d("checkActivityActive", "SubCategoriesManagerActivity{} initRelevantModule() -> activityActive == " + categoryActiveId);
            activity.startActivityForResult(new Intent(context, SubCategoriesManagerActivity.class).putExtra(SAVED_VERSION_TITLE, title).putExtra(SUB_CATEGORY_POSITION, subcategoryPosition), 0);
        }

        private void setCursor(Cursor cursor) {
        }
        private void setTitle(String title) { this.title = title; }
        public void setSubcategoryPosition(int subcategoryPosition) { this.subcategoryPosition = subcategoryPosition; }
    }
}

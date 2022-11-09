package com.itcm.structural_design.adapters;

import static com.itcm.structural_design.activities.BasicActivity.TITLE;
import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.categoryActiveId;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.subCategoryActiveId;
import static com.itcm.structural_design.activities.BasicActivity.toolbarTitle;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.SavedVersionsActivity;
import com.itcm.structural_design.models.ExGroupChildModel;
import com.itcm.structural_design.models.ExGroupGroupModel;
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

import java.util.List;

public class AdapterERV extends ExpandableRecyclerViewAdapter<AdapterERV.GViewHolder, AdapterERV.CViewHolder> {


    public AdapterERV(List<? extends ExpandableGroup> groups) {
        super(groups);
    }

    @Override
    public GViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        return new GViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_text, parent, false));
    }

    @Override
    public CViewHolder onCreateChildViewHolder(ViewGroup parent, int viewType) {
        return new CViewHolder(LayoutInflater.from(context).inflate(R.layout.item_view_text, parent, false));
    }

    @Override
    public void onBindChildViewHolder(CViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final ExGroupChildModel childModel = (ExGroupChildModel) group.getItems().get(childIndex);
//        final ExGroupGroupModel groupModel = (ExGroupGroupModel) group;
        holder.title_TV.setText(childModel.getTitle());
        holder.setGroupModel((ExGroupGroupModel) group);
        holder.setChildModel(childModel);
    }

    @Override
    public void onBindGroupViewHolder(GViewHolder holder, int flatPosition, ExpandableGroup group) {
//        final ExGroupGroupModel groupModel = (ExGroupGroupModel) group;
        holder.title_TV.setText(group.getTitle());
        holder.title_TV.setTextColor(context.getColor(android.R.color.black));
    }

    public static class GViewHolder extends GroupViewHolder {

        private final TextView title_TV;

        public GViewHolder(View itemView) {
            super(itemView);
            title_TV = itemView.findViewById(R.id.item_vew_text_tv);
        }
    }

    public static class CViewHolder extends ChildViewHolder implements View.OnClickListener {

        private final TextView title_TV;
        private ExGroupGroupModel groupModel;
        private ExGroupChildModel childModel;

        public CViewHolder(View itemView) {
            super(itemView);
            title_TV = itemView.findViewById(R.id.item_vew_text_tv);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            categoryActiveId = groupModel.getId();
            subCategoryActiveId = childModel.getId();
            toolbarTitle = groupModel.getTitle();
            activity.startActivityForResult(new Intent(context, SavedVersionsActivity.class).putExtra(TITLE, childModel.getTitle()), 0);
        }

        public void setGroupModel(ExGroupGroupModel group) {
            this.groupModel = group;
        }

        public void setChildModel(ExGroupChildModel childModel) {
            this.childModel = childModel;
        }
    }
}

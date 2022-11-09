package com.itcm.structural_design.helpers;

import android.app.Dialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.itcm.structural_design.R;
import com.itcm.structural_design.activities.BasicActivity;

import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.dialog;

public class DialogHelper {

    public static String input;
    public static EditText input_ET;

    public Dialog initThreeButtonsDialog(String message, View.OnClickListener onPositiveBtnClickListener, View.OnClickListener onNegativeBtnClickListener, String positiveBtnTitle, String negativeBtnTitle) {
        Log.d("checkInitDialog", "checkInitDialog() activity == " + activity);
        Log.d("checkInitDialog", "checkInitDialog() activity.isFinishing() == " + activity.isFinishing());
        Log.d("checkInitDialog", "checkInitDialog() dialog == " + dialog);
        if (!activity.isFinishing() && dialog != null) dialog.dismiss();
        Dialog dialog = new Dialog(context);
        BasicActivity.dialog = dialog;
        dialog.setContentView(R.layout.dialog_three_btns);
        TextView message_TV = dialog.findViewById(R.id.dialog_three_btns_text_tv);
        TextView positiveBtn_TV = dialog.findViewById(R.id.dialog_three_btns_positive_btn_tv);
        TextView negativedBtn_TV = dialog.findViewById(R.id.dialog_three_btns_negative_btn_tv);
        TextView cancelBtn_TV = dialog.findViewById(R.id.dialog_three_btns_cancel_btn_tv);
        positiveBtn_TV.setText(positiveBtnTitle);
        negativedBtn_TV.setText(negativeBtnTitle);
        message_TV.setText(message);
        dialog.show();
        positiveBtn_TV.setOnClickListener(onPositiveBtnClickListener);
        negativedBtn_TV.setOnClickListener(onNegativeBtnClickListener);
        cancelBtn_TV.setOnClickListener(view -> dialog.dismiss());
        return dialog;
    }

    public Dialog initTwoButtonsDialog(String message, String positiveBtnTitle, String negativeBtnTitle, View.OnClickListener onPositiveBtnClickListener, View.OnClickListener onNegativeBtnClickListener, int positiveBtnColor) {
        Log.d("checkInitDialog", "checkInitDialog()");
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_two_btns);
        TextView message_TV = dialog.findViewById(R.id.dialog_text_two_btns_text_tv);
        TextView positiveBtn_TV = dialog.findViewById(R.id.dialog_text_two_btns_positive_btn_tv);
        TextView negativedBtn_TV = dialog.findViewById(R.id.dialog_text_two_btns_negative_btn_tv);
        positiveBtn_TV.setText(positiveBtnTitle);
        negativedBtn_TV.setText(negativeBtnTitle);
        message_TV.setText(message);
        positiveBtn_TV.setTextColor(context.getColor(positiveBtnColor));
        positiveBtn_TV.setOnClickListener(onPositiveBtnClickListener);
        negativedBtn_TV.setOnClickListener(onNegativeBtnClickListener != null ? onNegativeBtnClickListener : (view -> dialog.dismiss()));
        dialog.show();
        return dialog;
    }

    public Dialog initOneButtonDialog(String message) {
        Log.d("checkInitDialog", "checkInitDialog()");
        if (dialog != null) dialog.dismiss();
        Dialog dialog = new Dialog(context);
        BasicActivity.dialog = dialog;
        dialog.setContentView(R.layout.dialog_two_btns);
        TextView message_TV = dialog.findViewById(R.id.dialog_text_two_btns_text_tv);
        TextView positiveBtn_TV = dialog.findViewById(R.id.dialog_text_two_btns_positive_btn_tv);
        TextView negativedBtn_TV = dialog.findViewById(R.id.dialog_text_two_btns_negative_btn_tv);
        negativedBtn_TV.setVisibility(View.GONE);
        positiveBtn_TV.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        message_TV.setText(message);
        positiveBtn_TV.setOnClickListener(view -> dialog.dismiss());
        dialog.show();
        return dialog;
    }

    public Dialog initInputDialog(View.OnClickListener onClickListener) {
        Log.d("checkInitDialog", "checkInitDialog() dialog == " + dialog);
        if (dialog != null) dialog.dismiss();
        Dialog dialog = new Dialog(context);
        BasicActivity.dialog = dialog;
        dialog.setContentView(R.layout.dialog_input);
        input_ET = dialog.findViewById(R.id.dialog_input_text_tv);
        TextView positiveBtn_TV = dialog.findViewById(R.id.dialog_input_positive_btn_tv);
        TextView negativedBtn_TV = dialog.findViewById(R.id.dialog_input_negative_btn_tv);
        negativedBtn_TV.setOnClickListener(view -> dialog.dismiss());
        positiveBtn_TV.setOnClickListener(onClickListener);
        input_ET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().isEmpty()){
                    input_ET.setError("שם לא יכול להיות ריק");
                }
                input = charSequence.toString();
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });
        dialog.show();
        return dialog;
    }
}

package com.itcm.structural_design.helpers;

import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;

import static com.itcm.structural_design.activities.BasicActivity.activity;
import static com.itcm.structural_design.activities.BasicActivity.context;
import static com.itcm.structural_design.activities.BasicActivity.handler;

public class KeyboardHelper {

  public static final String TAG_KEYBOARD_LISTENER = "TAG_KEYBOARD_LISTENER";
  private final InputMethodManager inputManager;
  private static int visibleDecorViewHeight;

  public KeyboardHelper(){
    inputManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
  }

  public void hideKeyboard() {
    Log.d(TAG_KEYBOARD_LISTENER, "hideKeyboard()");
    View view = activity.getCurrentFocus();
    if (view == null) view = new View(activity);
    inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
  }


  public void showKeyboard(View view){
    inputManager.showSoftInput(view, 0);
  }

  public void disableKeyboardUntilTuch(){
    activity.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
  }

  public void initKeyBoardListener(final View view, final boolean isCostTotalAreaHidden) {
    Log.d("checkKeyboardHideShow", "initKeyBoardListener()");

    // Threshold for minimal keyboard height.
    final int MIN_KEYBOARD_HEIGHT_PX = 150;
    // Top-level window decor view.
    final View decorView = activity.getWindow().getDecorView();
    // Register global layout listener.
    decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
      // Retrieve visible rectangle inside window.
      private final Rect windowVisibleDisplayFrame = new Rect();
      private int lastVisibleDecorViewHeight = 0;
      @Override
      public void onGlobalLayout() {
        decorView.getWindowVisibleDisplayFrame(windowVisibleDisplayFrame);
        visibleDecorViewHeight = windowVisibleDisplayFrame.height();
        Log.d("checkKeyboardHideShow", "lastVisibleDecorViewHeight == " + lastVisibleDecorViewHeight + "; visibleDecorViewHeight == " + visibleDecorViewHeight);

        if (lastVisibleDecorViewHeight != 0) {
          // IF SHOW
//                    if (lastVisibleDecorViewHeight > visibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX) {
          if (lastVisibleDecorViewHeight > visibleDecorViewHeight) {
            Log.d("checkKeyboardHideShow", "SHOW - > lastVisibleDecorViewHeight == " + lastVisibleDecorViewHeight + "; visibleDecorViewHeight == " + visibleDecorViewHeight + "; view == " + view);
            // IF HIDE
//                    } else if (lastVisibleDecorViewHeight + MIN_KEYBOARD_HEIGHT_PX < visibleDecorViewHeight) {
          } else if (lastVisibleDecorViewHeight < visibleDecorViewHeight) {
            Log.d("checkKeyboardHideShow", "HIDE - > lastVisibleDecorViewHeight == " + lastVisibleDecorViewHeight + "; visibleDecorViewHeight == " + visibleDecorViewHeight + "; view == " + view);
            view.clearFocus();
//                        inputManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
          }
        }
        // Save current decor view height for the next call.
        lastVisibleDecorViewHeight = visibleDecorViewHeight;
        //Log.d("checkKeyboardHideShow", "lastVisibleDecorViewHeight == " + lastVisibleDecorViewHeight);
      }
    });
  }

}

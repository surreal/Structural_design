package com.itcm.structural_design.interfaces;

import com.itcm.structural_design.models.UserModel;

public interface OnAsyncPostUserDetailsListener {
  void onAsyncPostUserDetailsResult(UserModel userModel, String request, String response);
}

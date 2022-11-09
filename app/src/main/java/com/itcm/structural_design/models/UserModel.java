package com.itcm.structural_design.models;

public class UserModel {
    private final String email, password, fullName;
    private String profileImagePath;
    private final int authOption;

    public UserModel(String email, String password, String fullName, String profileImagePath, int authOption) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.profileImagePath = profileImagePath;
        this.authOption = authOption;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAuthOption() {
        return authOption;
    }

    public String getProfileImagePath() { return profileImagePath; }
}

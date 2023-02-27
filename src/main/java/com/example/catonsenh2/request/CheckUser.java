package com.example.catonsenh2.request;

import jakarta.validation.constraints.NotBlank;

public class CheckUser {

    @NotBlank
    private String email;

    @NotBlank
    private String tel;


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}

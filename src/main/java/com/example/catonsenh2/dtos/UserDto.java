package com.example.catonsenh2.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String email;

    private String tel;

    private String name;

    private MassageDto massage;

    private OnsenDto onsen;

}

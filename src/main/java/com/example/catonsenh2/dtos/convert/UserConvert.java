package com.example.catonsenh2.dtos.convert;

import com.example.catonsenh2.dtos.UserDto;
import com.example.catonsenh2.models.UserModel;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserConvert {

    public UserDto modelToDto(Optional<UserModel> userModel){

        ModelMapper modelMap = new ModelMapper();

        UserDto userDto = modelMap.map(userModel,UserDto.class);

        return userDto;
    }

    public List<UserDto> modelToDto(List<UserModel> userModels) {
        return userModels.stream().map(userModel -> modelToDto(Optional.ofNullable(userModel))).collect(Collectors.toList());
    }

    public UserModel dtoToModel(UserDto userDto) {
        ModelMapper mapper = new ModelMapper();
        UserModel userModel = mapper.map(userDto, UserModel.class);
        return userModel;
    }

    public List<UserModel> dtoToModel(List<UserDto> userDtos) {
        return userDtos.stream().map(user -> dtoToModel(user)).collect(Collectors.toList());
    }
}

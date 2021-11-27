package com.ids.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ids.dto.UserDto;
import com.ids.entity.User;

@Mapper
public interface UserMapper {
 
    UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );
 
    User dtoToUser(UserDto dto);
}
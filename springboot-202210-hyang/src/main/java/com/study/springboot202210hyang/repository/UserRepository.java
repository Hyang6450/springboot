package com.study.springboot202210hyang.repository;

import com.study.springboot202210hyang.web.dto.UserDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    public int saveUser(UserDto userDto);
    public UserDto findUserByUserId(int userId);
}

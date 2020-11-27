package com.dyl.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dyl.model.User;

public interface UserMapper extends BaseMapper<User> {

    public User findById(Integer id);
}

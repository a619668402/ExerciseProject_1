package com.dyl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyl.model.User;
import com.dyl.service.base.BaseService;

public interface UserService extends BaseService<User> {

    public User findByUserNameAndPassword(String userName, String passWord);

    public Integer update(User user);

    public Page<User> listByPage(int page, int pageSize);
}

package com.dyl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyl.dao.UserMapper;
import com.dyl.model.User;
import com.dyl.service.UserService;
import com.dyl.service.base.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findById(Integer id) {
        User user = userMapper.selectById(id);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        userMapper.deleteById(id);
    }

    @Override
    public List<User> findAll() {
        List<User> users = userMapper.selectList(new QueryWrapper<User>());
        return users;
    }

    @Override
    public void insert(User entity) {
        userMapper.insert(entity);
    }

    @Override
    public void update(User user) {
        userMapper.updateById(user);
    }

    @Override
    public Page<User> listByPage(int currentPage, int pageSize) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        Page<User> page = new Page<>(currentPage, pageSize);
        Page<User> selectPage = userMapper.selectPage(page, wrapper);
        return selectPage;
    }

    @Override
    public User findByUserNameAndPassword(String userName, String passWord) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", userName)
               .eq("password", passWord);
        User user = userMapper.selectOne(wrapper);
        return user;
    }
}

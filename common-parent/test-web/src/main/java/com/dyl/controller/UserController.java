package com.dyl.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dyl.model.User;
import com.dyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("list")
    public String userList(Model model) {
//        List<User> all = userService.findAll();
//        model.addAttribute("list", all);
        return "user/list";
    }

    @RequestMapping("listByPage")
    @ResponseBody
    public Map<String, Object> listByPage(int page, int limit) {
        Page<User> userPage = userService.listByPage(page, limit);
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "");
        map.put("count", userPage.getTotal());
        map.put("data", userPage.getRecords());
        return map;
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String addUser() {
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    @ResponseBody
    public String addUser(User user) {
        user.setCreateTime(new Date());
        Integer insert = userService.insert(user);
        if (insert > 0) {
            return "success";
        }
        return "failure";
    }
}

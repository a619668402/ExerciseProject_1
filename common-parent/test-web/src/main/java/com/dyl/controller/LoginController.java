package com.dyl.controller;

import com.dyl.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public User login(String username, String password) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        return user;
    }

    @RequestMapping("index")
    public String index() {
        return "index";
    }

    @RequestMapping("error")
    public String error() {
        return "error";
    }
}
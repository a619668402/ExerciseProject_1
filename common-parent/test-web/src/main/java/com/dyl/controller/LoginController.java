package com.dyl.controller;

import com.dyl.model.User;
import com.dyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    @ResponseBody
    public String login(String username, String password, HttpServletRequest request) {
        User user = userService.findByUserNameAndPassword(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            return "success";
        }
        return "failure";
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
package com.wx.platform.server.controller;

import com.wx.platform.server.security.UserDetail;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class DefaultPageController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/getCurrentUser")
    @ResponseBody
    public UserDetail getCurrentUser() {
        UserDetail userDetail = new UserDetail();
        return userDetail;
    }

    @RequestMapping("/getNav")
    @ResponseBody
    public String getNav() {
        StringBuilder sb = new StringBuilder();
        sb.append("nav");
        return sb.toString();
    }

}

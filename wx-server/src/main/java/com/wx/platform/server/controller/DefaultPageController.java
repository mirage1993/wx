package com.wx.platform.server.controller;

import com.wx.platform.server.security.UserDetail;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@Scope("prototype")
public class DefaultPageController {

    @RequestMapping("/getCurrentUser")
    @ResponseBody
    public UserDetail getCurrentUser() {
        UserDetail userDetail = new UserDetail();
        return userDetail;
    }

}

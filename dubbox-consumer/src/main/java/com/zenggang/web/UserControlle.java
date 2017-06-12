package com.zenggang.web;

import com.alibaba.dubbo.config.annotation.Reference;
import com.zenggang.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserControlle {

    @Reference
    private UserService userService;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List listUsers() {
        return userService.findAll();
    }
}

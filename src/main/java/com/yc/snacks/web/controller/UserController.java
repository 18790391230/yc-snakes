package com.yc.snacks.web.controller;

import com.yc.snacks.model.Response;
import com.yc.snacks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("firstLogin")
    public Response<Boolean> userFirstLogin(Integer empId) {

        return Response.ok(userService.firstLogin(empId), null);
    }

}

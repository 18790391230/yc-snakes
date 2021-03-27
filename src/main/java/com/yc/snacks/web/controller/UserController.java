package com.yc.snacks.web.controller;

import com.yc.snacks.model.Response;
import com.yc.snacks.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("firstLogin")
    public Response<Boolean> userFirstLogin(@RequestParam("empId") Integer empId) {

        return Response.ok(userService.firstLogin(empId), null);
    }

    @PostMapping("saveUserTags")
    public Response<Void> saveUserTags(@RequestParam("empId") int empId, @RequestParam("goodsTypeIds") List<Integer> goodsTypeIds) {
        userService.saveUserTags(empId, goodsTypeIds);
        return Response.ok(null, null);
    }

    @PostMapping("updateLoginStatus")
    public Response<Void> updateLoginStatus(@RequestParam("empId") Integer empId) {
        userService.updateLoginStatus(empId);
        return Response.ok(null, null);
    }
}

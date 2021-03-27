package com.yc.snacks.web.controller;

import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "判断是否是第一次登陆，如果是第一次登陆，则展示标签页，让用户选择自己感兴趣的商品类型")
    @GetMapping("firstLogin")
    public Response<Boolean> userFirstLogin(@RequestParam("empId") Integer empId) {

        return Response.ok(userService.firstLogin(empId), null);
    }

    @ApiOperation(value = "保存用户感兴趣的商品类型")
    @PostMapping("saveUserTags")
    public Response<Void> saveUserTags(@RequestParam("empId") int empId, @RequestParam("goodsTypeIds") List<Integer> goodsTypeIds) {
        userService.saveUserTags(empId, goodsTypeIds);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "更新用户状态为：不是第一次登陆")
    @PostMapping("updateLoginStatus")
    public Response<Void> updateLoginStatus(@RequestParam("empId") Integer empId) {
        userService.updateLoginStatus(empId);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "查询用户周期内可用额度")
    @PostMapping("queryEmpUsableAmount")
    public Response<BigDecimal> queryEmpUsableAmount(@RequestParam("empId") Integer empId) {
        return Response.ok(userService.selectEmpInfo(empId), null);
    }
}

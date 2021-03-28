package com.yc.snacks.web.controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.yc.snacks.domain.EmpGoodsExpenseInfo;
import com.yc.snacks.domain.EmpGroup;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGroupService;
import com.yc.snacks.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpGroupService empGroupService;

    private static class User{
        private String name;
        private String age;
        private String birthday;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public String getBirthday() {
            return birthday;
        }

        public void setBirthday(String birthday) {
            this.birthday = birthday;
        }
    }

    @GetMapping("exportEmpGoodsExpenseInfo")
    public void exportEmpGoodsExpenseInfo(ServletRequest request, HttpServletResponse response) {
        List<EmpGoodsExpenseInfo> empGoodsExpenseInfos = empGroupService.selectEmpGoodsExpenseInfo();

        List<User> list = new ArrayList<>();
        User obj = new User();
        obj.setName("卡卡罗特");
        obj.setAge("25");
        obj.setBirthday("0903");
        list.add(obj);
        list.add(new User());
// 通过工具类创建writer，默认创建xls格式
        ExcelWriter writer = ExcelUtil.getWriter();
//自定义标题别名
        writer.addHeaderAlias("name", "姓名");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("birthDay", "生日");
// 合并单元格后的标题行，使用默认标题样式
        writer.merge(2, "申请人员信息");
        writer.write(list, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String name = "test";
        response.setHeader("Content-Disposition","attachment;filename="+name+".xls");
        ServletOutputStream out= null;
        try {

            out = response.getOutputStream();

            writer.flush(out, true);

        } catch (IOException e) {

            e.printStackTrace();

        }finally {

            writer.close();

        }

        IoUtil.close(out);

    }

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

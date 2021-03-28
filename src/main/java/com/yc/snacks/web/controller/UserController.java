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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping("user")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EmpGroupService empGroupService;

    @ApiOperation("导出零食实际支出汇总")
    @GetMapping("exportEmpGoodsExpenseInfo")
    public void exportEmpGoodsExpenseInfo(HttpServletResponse response) {
        List<EmpGoodsExpenseInfo> empGoodsExpenseInfos = empGroupService.selectEmpGoodsExpenseInfo();

        for (EmpGoodsExpenseInfo empGoodsExpenseInfo : empGoodsExpenseInfos) {
            empGoodsExpenseInfo.setCompanyName("招银云创");
            empGoodsExpenseInfo.setDepartmentName("数据团队");
            BigDecimal bigDecimal = new BigDecimal(200 * 12);
            empGoodsExpenseInfo.setUsedRate(empGoodsExpenseInfo.getEmpTotalUsedAmount().divide(bigDecimal).doubleValue());
            empGoodsExpenseInfo.setYearBudgetAmount(bigDecimal);

        }
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.setOnlyAlias(true);
        writer.addHeaderAlias("companyName", "公司");
        writer.addHeaderAlias("departmentName", "部门");
        writer.addHeaderAlias("groupName", "组别");
        writer.addHeaderAlias("workplaceName", "职场");
        writer.addHeaderAlias("empName", "姓名");
        writer.addHeaderAlias("empId", "员工编号");
        writer.addHeaderAlias("empAmount", "当期费用金额");
        writer.addHeaderAlias("empTotalUsedAmount", "本年累计费用");
        writer.addHeaderAlias("yearBudgetAmount", "本年预算金额");
        writer.addHeaderAlias("usedRate", "预算完成度");

        writer.write(empGoodsExpenseInfos, true);
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        String yyyyMMddHHmmss = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
        response.setHeader("Content-Disposition","attachment;filename="+yyyyMMddHHmmss+".xls");
        try (ServletOutputStream out = response.getOutputStream()){
            writer.flush(out, true);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            writer.close();
        }

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

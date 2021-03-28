package com.yc.snacks.web.controller;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.dto.GroupGoodsListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.GoodsService;
import com.yc.snacks.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    private EmpGoodsService empGoodsServiceImpl;

    @Autowired
    private OrderService orderServiceImpl;

    @GetMapping("/getSelectedGoodsList")
    @ResponseBody
    public Response<SelectedGoodsListDTO> getSelectedGoodsList(@PathVariable(name = "empId")Integer empId){
        SelectedGoodsListDTO result = null;
        try{
            result = empGoodsServiceImpl.getSelectedGoodsList(empId);
        }catch (Exception e){
            return Response.error(e, result);
        }
        return Response.ok(result, null);
    }

    @GetMapping("/getGroupGoodsList")
    @ResponseBody
    public Response<SelectedGoodsListDTO> getGroupGoodsList(@PathVariable(name = "groupId")Integer groupId){
        try{
            SelectedGoodsListDTO dto = empGoodsServiceImpl.getGoodsByGroupId(groupId);
            return Response.ok(dto, null);
        }catch (Exception e){
            return Response.error(e, null);
        }
    }

    @PostMapping("/ensureTakeOver")
    @ResponseBody
    public Response<Boolean> ensureTakeOver(@PathVariable(name = "empId")Long empId, @PathVariable(name = "flag")Long roleId){
        return Response.ok(Boolean.TRUE, null);
    }

    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "根据类型查询商品列表")
    @GetMapping("selectByType")
    public Response<List<Goods>> selectByType(@RequestParam("goodsType") Integer goodsType) {
        return Response.ok(goodsService.selectByType(goodsType), null);
    }


}

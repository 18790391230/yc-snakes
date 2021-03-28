package com.yc.snacks.web.controller;


import com.yc.snacks.domain.GoodTypeNameSale;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("empGoods")
public class EmpGoodsController {

    @Autowired
    private EmpGoodsService empGoodsService;


    @ApiOperation(value = "添加商品到购物车或购物车内添加或减少商品数量")
    @PostMapping("addGoodsToShoppingCart")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empId", paramType = "form"),
            @ApiImplicitParam(name = "goodsId", paramType = "form"),
            @ApiImplicitParam(name = "num", paramType = "form"),
    })
    public Response<Void> addGoodsToShoppingCart(@RequestParam("empId") Integer empId,
                                                 @RequestParam("goodsId") Integer goodsId,
                                                 @RequestParam("num") Integer count) {
        empGoodsService.addGoods2ShoppingCart(empId, goodsId, count);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "提交购物车商品")
    @PostMapping("submitGoodsShopping")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empId", paramType = "form"),
            @ApiImplicitParam(name = "goodsIdList", paramType = "form"),
    })
    public Response<Void> submitGoodsShopping(@RequestParam("empId") Integer empId, @RequestParam("goodsIdList") List<Integer> goodsIdList){
        empGoodsService.submitGoodsShopping(empId, goodsIdList);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "查询商品热度排行榜")
    @GetMapping("queryGoodsHeatRankingList")
    public Response<List<GoodTypeNameSale>> queryGoodsHeatRankingList(@RequestParam(defaultValue = "3") Integer topCount) {
        return Response.ok(empGoodsService.queryGoodsHeatRankingList(topCount), null);
    }
}

package com.yc.snacks.web.controller;


import com.yc.snacks.domain.GoodTypeNameSale;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
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
    public Response<Void> addGoodsToShoppingCart(@Param("empId") @ApiParam(value = "empId") Integer empId,
                                                 @Param("goodsId") @ApiParam(value = "goodsId") Integer goodsId,
                                                 @Param("num") @ApiParam(value = "num") Integer count) {
        empGoodsService.addGoods2ShoppingCart(empId, goodsId, count);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "提交购物车商品")
    @PostMapping("submitGoodsShopping")
    public Response<Void> submitGoodsShopping(Integer empId, List<Integer> goodsIdList){
        empGoodsService.submitGoodsShopping(empId, goodsIdList);
        return Response.ok(null, null);
    }

    @ApiOperation(value = "查询商品热度排行榜")
    @GetMapping("queryGoodsHeatRankingList")
    public Response<List<GoodTypeNameSale>> queryGoodsHeatRankingList(@RequestParam(defaultValue = "3") Integer topCount) {
        return Response.ok(empGoodsService.queryGoodsHeatRankingList(topCount), null);
    }
}

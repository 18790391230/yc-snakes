package com.yc.snacks.web.controller;


import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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


}

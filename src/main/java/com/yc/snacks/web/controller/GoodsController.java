package com.yc.snacks.web.controller;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {


    @Autowired
    private GoodsService goodsService;

    @ApiOperation(value = "根据类型查询商品列表")
    @GetMapping("selectByType")
    public Response<List<Goods>> selectByType(@RequestParam("goodsType") Integer goodsType) {
        return Response.ok(goodsService.selectByType(goodsType), null);
    }

}

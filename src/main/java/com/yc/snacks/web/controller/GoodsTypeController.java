package com.yc.snacks.web.controller;


import com.yc.snacks.domain.GoodsType;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.GoodsTypeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("goodsType")
public class GoodsTypeController {

    @Autowired
    private GoodsTypeService goodsTypeService;

    @ApiOperation(value = "查询所有商品类型")
    @GetMapping("selectAll")
    public Response<List<GoodsType>> selectAll() {
        return Response.ok(goodsTypeService.selectAll(), null);
    }
}

package com.yc.snacks.web.controller;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.dto.GroupGoodsListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.GoodsService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("goods")
public class GoodsController {

    @GetMapping("/getSelectedGoodsList")
    @ResponseBody
    public Response<SelectedGoodsListDTO> getSelectedGoodsList(@PathVariable(name = "empId")Long empId){

        return Response.ok(null, null);
    }

    @GetMapping("/getGroupGoodsList")
    @ResponseBody
    public Response<GroupGoodsListDTO> getGroupGoodsList(@PathVariable(name = "groupId")Long groupId){
        GroupGoodsListDTO result = null;
        return Response.ok(result, null);
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

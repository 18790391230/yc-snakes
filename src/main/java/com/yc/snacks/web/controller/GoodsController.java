package com.yc.snacks.web.controller;

import com.yc.snacks.dto.GroupGoodsListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.model.Response;
import org.springframework.web.bind.annotation.*;

@RequestMapping
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

}

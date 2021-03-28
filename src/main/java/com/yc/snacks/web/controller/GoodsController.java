package com.yc.snacks.web.controller;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.GoodsService;
import com.yc.snacks.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
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

    /**
     *
     * @param empId
     * @param orderId
     * @param status  1表示采购员确认购买  2表示组长确认收货 3表示采购员确认完成
     * @return
     */
    @PostMapping("/ensureTakeOver")
    @ResponseBody
    public Response<Boolean> ensureTakeOver(@RequestParam(name = "empId")Integer empId, @RequestParam(name = "orderId")Integer orderId,
                                            @RequestParam(name = "status")Integer status){
        orderServiceImpl.
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

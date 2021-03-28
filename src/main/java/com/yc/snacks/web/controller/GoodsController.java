package com.yc.snacks.web.controller;

import com.yc.snacks.domain.Goods;
import com.yc.snacks.dto.GroupInfoDTO;
import com.yc.snacks.dto.OrderListDTO;
import com.yc.snacks.dto.SelectedGoodsListDTO;
import com.yc.snacks.model.Response;
import com.yc.snacks.service.EmpGoodsService;
import com.yc.snacks.service.GoodsService;
import com.yc.snacks.service.GroupInfoService;
import com.yc.snacks.service.OrderService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

    @Autowired
    private GroupInfoService groupInfoServiceImpl;

    @Autowired
    private GoodsService goodsService;

    @GetMapping("/getSelectedGoodsList")
    @ResponseBody
    @ApiOperation(value = "组内商品列表")
    public Response<List<OrderListDTO>> getSelectedGoodsList(@RequestParam("empId") Integer empId){
        List<OrderListDTO> result = null;
        try{
            result = empGoodsServiceImpl.getSelectedGoodsList(empId);
        }catch (Exception e){
            return Response.error(e, result);
        }
        return Response.ok(result, null);
    }

    /**
     *
     * @param groupId
     * @param payStatus  1未结算  2已结算
     * @return
     */
    @GetMapping("/getGroupGoodsList")
    @ResponseBody
    @ApiOperation(value = "采购详情列表（每组商品列表）")
    public Response<SelectedGoodsListDTO> getGroupGoodsList(@PathVariable(name = "groupId")Integer groupId,
                                                            @PathVariable(name = "payStatus")Integer payStatus){
        try{
            SelectedGoodsListDTO dto = empGoodsServiceImpl.getGoodsByGroupId(groupId, payStatus);
            return Response.ok(dto, null);
        }catch (Exception e){
            return Response.error(e, null);
        }
    }

    @GetMapping("/getGroupList")
    @ResponseBody
    @ApiOperation(value = "采购详情列表（每组商品列表）")
    public Response<List<GroupInfoDTO>> getGroupInfoList(){
        try{
            List<GroupInfoDTO> result = groupInfoServiceImpl.getGroupInfoList();
            return Response.ok(result, null);
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
    @ApiImplicitParams({
            @ApiImplicitParam(name = "empId", paramType = "form"),
            @ApiImplicitParam(name = "orderId", paramType = "form"),
            @ApiImplicitParam(name = "status", paramType = "form")
    })
    public Response<Boolean> ensureTakeOver(@RequestParam(name = "empId")Integer empId, @RequestParam(name = "orderId")Integer orderId,
                                            @RequestParam(name = "status")Integer status){

        try{
            int updateDatas = orderServiceImpl.updateOrderStatus(orderId, empId, status);
            if(updateDatas > 0){
                return Response.ok(Boolean.TRUE, null);
            }else{
                return Response.error(Boolean.FALSE);
            }
        }catch (Exception e){
            return Response.error(e, Boolean.FALSE);
        }
    }


    @ApiOperation(value = "根据类型查询商品列表")
    @GetMapping("selectByType")
    public Response<List<Goods>> selectByType(@RequestParam("goodsType") Integer goodsType) {
        return Response.ok(goodsService.selectByType(goodsType), null);
    }


}

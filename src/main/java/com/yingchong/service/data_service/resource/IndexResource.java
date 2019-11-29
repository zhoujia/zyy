package com.yingchong.service.data_service.resource;

import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTreadBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppTypeBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.BizBean.biz_interTime.BizInterBean;
import com.yingchong.service.data_service.service.AppTypeService;
import com.yingchong.service.data_service.service.IndexService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Api(value="首页service",tags={"首页操作接口"})
@RestController
@RequestMapping("/index")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class IndexResource {

    @Autowired
    private IndexService indexService;

    @Autowired
    private AppTypeService appTypeService;

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="流量", notes="流量(弃用,参考接口)")
    @RequestMapping(value={"/upFlux"}, method= RequestMethod.GET)
    public ResponseBean<List<BizDataBean>> Flux_1(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.Flux_1(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="上、下行流量", notes="上、下行流量")
    @RequestMapping(value={"/Flux"}, method= RequestMethod.GET)
    public ResponseBean<List<BizDataBean>> Flux(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.Flux(startDate,endDate);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="每日同步上、下行流量", notes="每日同步上、下行流量")
    @RequestMapping(value={"/insertFluxResult"}, method= RequestMethod.GET)
    public ResponseBean<Boolean> insertFluxResult(
            @RequestParam("date") String date
    ){
        boolean b = indexService.insertFluxResult(date);
        return new ResponseBean<>(b);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="上网时长", notes="上网时长")
    @RequestMapping(value={"/Inter"}, method= RequestMethod.GET)
    public ResponseBean<List<BizInterBean>> Inter(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.Inter(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="每日同步上网时长", notes="每日同步上网时长")
    @RequestMapping(value={"/insertOnlineTime"}, method= RequestMethod.GET)
    public ResponseBean<Boolean> insertOnlineTime(
            @RequestParam("date") String date
    ){
        boolean b = indexService.insertOnlineTime(date);
        return new ResponseBean<>(b);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="应用流量", notes="应用流量")
    @RequestMapping(value={"/App"}, method= RequestMethod.GET)
    public ResponseBean<List<BizAppBean>> App(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return indexService.App(startDate,endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="每日同步应用流量", notes="每日同步应用流量")
    @RequestMapping(value={"/insertAppFluxSort"}, method= RequestMethod.GET)
    public ResponseBean<Boolean> insertAppFluxSort(
            @RequestParam("date") String date
    ){
        boolean b = indexService.insertAppFluxSort(date);
        return new ResponseBean<>(b);
    }



    @ApiImplicitParams({
            @ApiImplicitParam(name = "date", value = "date", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="每日同步意识形态分类数据", notes="每日同步意识形态分类数据")
    @RequestMapping(value={"/insertActionType"}, method= RequestMethod.GET)
    public ResponseBean<Boolean> insertActionType(
            @RequestParam("date") String date
    ){
        boolean b = appTypeService.insertActionType(date);
        return new ResponseBean<>(b);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="查询意识形态分类数据", notes="查询意识形态分类数据")
    @RequestMapping(value={"/actionTypeList"}, method= RequestMethod.GET)
    public ResponseBean<List<BizAppTypeBean>> actionTypeList(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return appTypeService.actionTypeList(startDate, endDate);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "startDate", value = "startDate", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "endDate", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(value="查询网络行为趋势", notes="查询网络行为趋势")
    @RequestMapping(value={"/actionTypeTrend"}, method= RequestMethod.GET)
    public ResponseBean<BizAppTreadBean> actionTypeTrend(
            @RequestParam("startDate") String startDate,
            @RequestParam("endDate") String endDate
    ){
        return appTypeService.actionTypeTrend(startDate, endDate);
    }

}

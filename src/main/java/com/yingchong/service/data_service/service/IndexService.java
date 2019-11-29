package com.yingchong.service.data_service.service;


import com.yingchong.service.data_service.BizBean.ResponseBean;
import com.yingchong.service.data_service.BizBean.biz_app.BizAppBean;
import com.yingchong.service.data_service.BizBean.biz_flux.BizDataBean;
import com.yingchong.service.data_service.BizBean.biz_interTime.BizInterBean;
import com.yingchong.service.data_service.mapper.MyAppMapper;
import com.yingchong.service.data_service.mapper.MyFluxMapper;
import com.yingchong.service.data_service.mapper.MyInterMapper;
import com.yingchong.service.data_service.mybatis.mapper.AppFluxSortMapper;
import com.yingchong.service.data_service.mybatis.mapper.FluxResultMapper;
import com.yingchong.service.data_service.mybatis.mapper.OnlineTimeMapper;
import com.yingchong.service.data_service.mybatis.model.*;
import com.yingchong.service.data_service.utils.CodeUtils;
import com.yingchong.service.data_service.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class IndexService {
    private static final Logger logger = LoggerFactory.getLogger(IndexService.class);

    @Autowired
    private MyFluxMapper myFluxMapper;

    @Autowired
    private MyInterMapper myInterMapper;

    @Autowired
    private MyAppMapper myAppMapper;

    @Autowired
    private FluxResultMapper fluxResultMapper;

    @Autowired
    private OnlineTimeMapper onlineTimeMapper;

    @Autowired
    private AppFluxSortMapper appFluxSortMapper;

    /**
     * @param startDate 开始时间 2019-05-01
     * @param endData   结束时间 2019-05-15
     * @return
     */
    public ResponseBean<List<BizDataBean>> Flux_1(String startDate, String endData) {
        int days = DateUtil.differentDays(DateUtil.StringToDate(startDate, "yyyy-MM-dd"), DateUtil.StringToDate(endData, "yyyy-MM-dd"));
        List<BizDataBean> dataList = new ArrayList<>();
        for (int i = 0; i <= days; i++) {
            //String startDate1 = startDate.replaceAll("-", "");
            Date date = DateUtil.addDay(DateUtil.StringToDate(startDate, "yyyy-MM-dd"), i);
            String startDate1 = DateUtil.formatDateStrToString(DateUtil.formatDateToStr(date, "yyyy-MM-dd HH:mm:ss"));
            String param = startDate1.replaceAll("-", "");
            List<BizDataBean> bizDataBeans = myFluxMapper.selectFlux(param + "_flux");
            BizDataBean bizDataBean = bizDataBeans.get(0);
            bizDataBean.setDate(startDate1);
            dataList.add(bizDataBean);
        }
        return new ResponseBean<>(dataList);
    }

    /**
     * 查询指定日期的原始数据
     *
     * @param date 日期 2019-05-17
     * @return 1
     */
    public List<BizDataBean> Flux(String date) {
        String param = date.replaceAll("-", "");
        List<BizDataBean> bizDataBeans = myFluxMapper.selectFlux(param + "_flux");
        for (BizDataBean bizDataBean : bizDataBeans) {
            bizDataBean.setDate(date);
        }
        return bizDataBeans;
    }

    /**
     * 每日同步数据
     *
     * @param date
     * @return
     */
    public boolean insertFluxResult(String date) {
        FluxResultExample example = new FluxResultExample();
        example.createCriteria().andFluxDateEqualTo(DateUtil.StringToDate(date, "yyyy-MM-dd"));
        List<FluxResult> fluxResults = fluxResultMapper.selectByExample(example);
        if (fluxResults != null && fluxResults.size() > 0) {
            logger.info("数据已经插入,不再重复插入");
            return true;
        }
        List<BizDataBean> flux = this.Flux(date);
        try {
            for (BizDataBean bizDataBean : flux) {
                FluxResult fr = new FluxResult();
                fr.setUpload(Double.parseDouble(bizDataBean.getUploadFlux()));
                fr.setDownload(Double.parseDouble(bizDataBean.getDownFlux()));
                fr.setFluxDate(DateUtil.formatStringToDate(bizDataBean.getDate(), "yyyy-MM-dd"));
                Date nowDate = new Date();
                fr.setCreateTime(nowDate);
                fr.setUpdateTime(nowDate);
                int insert = fluxResultMapper.insert(fr);
            }
        } catch (Exception e) {
            logger.error("insertFluxResult error:", e);
            return false;
        }
        return true;
    }


    /**
     * 查询结果集,返回给前端数据
     *
     * @param startDate 开始时间 2019-05-01
     * @param endData   结束时间 2019-05-15
     * @return
     */
    public ResponseBean<List<BizDataBean>> Flux(String startDate, String endData) {
        FluxResultExample example = new FluxResultExample();
        example.createCriteria().andFluxDateBetween(DateUtil.StringToDate(startDate, "yyyy-MM-dd"), DateUtil.StringToDate(endData, "yyyy-MM-dd"));
        example.setOrderByClause("flux_date");
        List<FluxResult> fluxResults = fluxResultMapper.selectByExample(example);
        List<BizDataBean> resultData = new ArrayList<>();
        for (FluxResult fluxResult : fluxResults) {
            BizDataBean dataBean = new BizDataBean();
            dataBean.setDate(DateUtil.formatDateToStr(fluxResult.getFluxDate(), "yyyy-MM-dd"));
            dataBean.setDownFlux(fluxResult.getDownload().toString());
            dataBean.setUploadFlux(fluxResult.getUpload().toString());
            resultData.add(dataBean);
        }
        return new ResponseBean<>(resultData);
    }

    //上网时长,查询指定日期的原始数据
    public List<BizInterBean> Inter(String date) {
        String param = date.replaceAll("-", "");
        List<BizInterBean> bizInterBeans = myInterMapper.selectInter(param + "_time_count");
        for (BizInterBean bizInterBean : bizInterBeans) {
            bizInterBean.setDate(date);
        }
        return bizInterBeans;
    }

    //上网时长,每日同步数据
    public boolean insertOnlineTime(String date) {
        OnlineTimeExample example = new OnlineTimeExample();
        example.createCriteria().andResultDateEqualTo(DateUtil.StringToDate(date, "yyyy-MM-dd"));
        List<OnlineTime> onlineTimes = onlineTimeMapper.selectByExample(example);
        if (onlineTimes != null && onlineTimes.size() > 0) {
            logger.info("数据已经插入,不再重复插入");
            return true;
        }
        List<BizInterBean> inter = this.Inter(date);
        try {
            for (BizInterBean bizInterBean : inter) {
                OnlineTime ot = new OnlineTime();
                ot.setOnlineTime(bizInterBean.getAvgTime());
                ot.setResultDate(DateUtil.formatStringToDate(bizInterBean.getDate(), "yyyy-MM-dd"));
                Date nowDate = new Date();
                ot.setCreateTime(nowDate);
                ot.setUpdateTime(nowDate);
                int insert = onlineTimeMapper.insert(ot);
            }
        } catch (Exception e) {
            logger.error("insertOnlineTime error:", e);
            return false;
        }
        return true;
    }

    //上网时长,查询结果集,返回给前端数据
    public ResponseBean<List<BizInterBean>> Inter(String startDate, String endData) {
        OnlineTimeExample example = new OnlineTimeExample();
        example.createCriteria().andResultDateBetween(DateUtil.StringToDate(startDate, "yyyy-MM-dd"), DateUtil.StringToDate(endData, "yyyy-MM-dd"));
        example.setOrderByClause("result_date");
        List<OnlineTime> onlineTimes = onlineTimeMapper.selectByExample(example);
        List<BizInterBean> resultInter = new ArrayList<>();
        for (OnlineTime onlineTime : onlineTimes) {
            BizInterBean interBean = new BizInterBean();
            interBean.setDate(DateUtil.formatDateToStr(onlineTime.getResultDate(), "yyyy-MM-dd"));
            interBean.setAvgTime(onlineTime.getOnlineTime());
            resultInter.add(interBean);
        }
        return new ResponseBean<>(resultInter);
    }

    //应用流量，查询指定日期的原始数据
    public List<BizAppBean> App(String date) {
        String param = date.replaceAll("-", "");
        List<BizAppBean> bizAppBeans = myAppMapper.selectApp(param + "_flux");
        for (BizAppBean bizAppBean : bizAppBeans) {
            bizAppBean.setDate(date);
        }
        return bizAppBeans;
    }


    //应用流量，每日同步数据
    public boolean insertAppFluxSort(String date) {
        AppFluxSortExample example = new AppFluxSortExample();
        example.createCriteria().andFluxDateEqualTo(date);
        List<AppFluxSort> appFluxSorts = appFluxSortMapper.selectByExample(example);
        if (appFluxSorts != null && appFluxSorts.size() > 0) {
            logger.info("数据已经插入,不再重复插入");
            return true;
        }
        List<BizAppBean> app = this.App(date);
        try {
            for (BizAppBean bizAppBean : app) {
                AppFluxSort afs = new AppFluxSort();
                afs.setAppName(bizAppBean.getAppName());
                afs.setFlux(bizAppBean.getFlux());
                afs.setFluxPercentage(bizAppBean.getFluxPercentage());
                afs.setFluxDate(date);
                Date nowDate = new Date();
                afs.setCreateTime(nowDate);
                afs.setUpdateTime(nowDate);
                int insert = appFluxSortMapper.insert(afs);
            }
        } catch (Exception e) {
            logger.error("insertAppFluxSort error:", e);
            return false;
        }
        return true;
    }

    //应用流量,查询结果集,返回给前端数据
    public ResponseBean<List<BizAppBean>> App(String startdate,String enddate) {
        List<BizAppBean> bizAppBeans = myAppMapper.selectappSort(startdate,enddate);
        List<BizAppBean> result = new ArrayList<>();
        BizAppBean other = new BizAppBean();
        other.setAppName("其他");
        double p = 0,b = 0,c = 0,d = 0;
        DecimalFormat df = new DecimalFormat("#.00");
        for(BizAppBean bizAppBean : bizAppBeans){
            String appName = CodeUtils.convertCharset(bizAppBean.getAppName());
            if (appName.equals("访问网站")
                    || appName.equals("Web流媒体")
                    || appName.equals("P2P")
                    || appName.equals("P2P流媒体")
                    || appName.equals("移动终端应用")) {
                bizAppBean.setAppName(appName);
                String fp = bizAppBean.getFluxPercentage();
                bizAppBean.setFluxPercentage(df.format(Double.parseDouble(fp)));
                result.add(bizAppBean);
                p += Double.parseDouble(bizAppBean.getFluxPercentage());
                d += bizAppBean.getFlux();
                b = bizAppBean.getFlux();
                c = Double.parseDouble(bizAppBean.getFluxPercentage());
            }
        }
        if (c == 0) {
            other.setFluxPercentage("0");
            other.setFlux(0D);
            result.add(other);
            return new ResponseBean<>(result);
        }
        double a = 100 - p;
        String str = df.format(a);
        double e = b/c*100 - d;
        String st = df.format(e);
        other.setFluxPercentage(str);
        other.setFlux(Double.parseDouble(st));
        result.add(other);
        return new ResponseBean<>(result);
    }
}

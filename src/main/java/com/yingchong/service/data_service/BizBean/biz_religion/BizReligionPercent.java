package com.yingchong.service.data_service.BizBean.biz_religion;

import java.util.Date;

public class BizReligionPercent {

    private String religionName;

    private Integer visitTime=0;//次数

    private Double percentage=0D;

    private Date timesDate;

    private String dateStr;

    private String visite_time;//访问时间

    private String url;

    private String title;

    private String terminal;//终端类型

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getVisite_time() {
        return visite_time;
    }

    public void setVisite_time(String visite_time) {
        this.visite_time = visite_time;
    }

    public String getDateStr() {
        return dateStr;
    }

    public void setDateStr(String dateStr) {
        this.dateStr = dateStr;
    }

    public Date getTimesDate() {
        return timesDate;
    }

    public void setTimesDate(Date timesDate) {
        this.timesDate = timesDate;
    }

    public String getReligionName() {
        return religionName;
    }

    public void setReligionName(String religionName) {
        this.religionName = religionName;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }
}

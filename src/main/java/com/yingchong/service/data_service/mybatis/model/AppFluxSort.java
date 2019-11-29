package com.yingchong.service.data_service.mybatis.model;

import java.util.Date;

public class AppFluxSort {
    private Integer id;

    private String appName;

    private Double flux;

    private String fluxPercentage;

    private String fluxDate;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Double getFlux() {
        return flux;
    }

    public void setFlux(Double flux) {
        this.flux = flux;
    }

    public String getFluxPercentage() {
        return fluxPercentage;
    }

    public void setFluxPercentage(String fluxPercentage) {
        this.fluxPercentage = fluxPercentage;
    }

    public String getFluxDate() {
        return fluxDate;
    }

    public void setFluxDate(String fluxDate) {
        this.fluxDate = fluxDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
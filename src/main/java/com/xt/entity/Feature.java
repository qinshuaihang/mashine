package com.xt.entity;

public class Feature {
    private Integer id;

    private Integer unitNum;

    private Integer feaNum;

    private String getMethod;

    private String feaName;

    private String feaDes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getFeaNum() {
        return feaNum;
    }

    public void setFeaNum(Integer feaNum) {
        this.feaNum = feaNum;
    }

    public String getGetMethod() {
        return getMethod;
    }

    public void setGetMethod(String getMethod) {
        this.getMethod = getMethod;
    }

    public String getFeaName() {
        return feaName;
    }

    public void setFeaName(String feaName) {
        this.feaName = feaName;
    }

    public String getFeaDes() {
        return feaDes;
    }

    public void setFeaDes(String feaDes) {
        this.feaDes = feaDes;
    }
}
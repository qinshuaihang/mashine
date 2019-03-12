package com.xt.entity;

public class Rule {
    private Integer unitNum;

    private Integer ruleNum;

    private String ruleName;

    private String ruleExpression;

    private String ruleDec;

    public Integer getUnitNum() {
        return unitNum;
    }

    public void setUnitNum(Integer unitNum) {
        this.unitNum = unitNum;
    }

    public Integer getRuleNum() {
        return ruleNum;
    }

    public void setRuleNum(Integer ruleNum) {
        this.ruleNum = ruleNum;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleExpression() {
        return ruleExpression;
    }

    public void setRuleExpression(String ruleExpression) {
        this.ruleExpression = ruleExpression;
    }

    public String getRuleDec() {
        return ruleDec;
    }

    public void setRuleDec(String ruleDec) {
        this.ruleDec = ruleDec;
    }
}
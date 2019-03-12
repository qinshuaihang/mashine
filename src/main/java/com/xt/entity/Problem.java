package com.xt.entity;

import org.springframework.web.multipart.MultipartFile;

public class Problem {
    private Integer id;

    private Integer unitNum;

    private Integer proNum;

    private String proName;

    private String proDes;

    private String proDeal;
    
    private String mayValue;
    
    private String mustValue;
    
    private MultipartFile errorImage;
    
    public String image;

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

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProDes() {
        return proDes;
    }

    public void setProDes(String proDes) {
        this.proDes = proDes;
    }

    public String getProDeal() {
        return proDeal;
    }

    public void setProDeal(String proDeal) {
        this.proDeal = proDeal;
    }
    
    public String getMayValue() {
		return mayValue;
	}
    
    public void setMayValue(String mayValue) {
		this.mayValue = mayValue;
	}
    
    public String getMustValue() {
		return mustValue;
	}
    
    public void setMustValue(String mustValue) {
		this.mustValue = mustValue;
	}

	public MultipartFile getErrorImage() {
		return errorImage;
	}

	public void setErrorImage(MultipartFile errorImage) {
		this.errorImage = errorImage;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
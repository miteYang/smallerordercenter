package com.demo.user.entity.dto;

import java.util.List;

public class TbProDto {
    private Integer id;
    private String projectName;
    private String projectCode;
    private String parentCode;

    List<TbProDto> childPro ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public List<TbProDto> getChildPro() {
        return childPro;
    }

    public void setChildPro(List<TbProDto> childPro) {
        this.childPro = childPro;
    }
}

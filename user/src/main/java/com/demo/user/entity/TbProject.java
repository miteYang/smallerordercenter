package com.demo.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;

@TableName("tb_project")
public class TbProject {
    private Integer id;
    private String projectName;
    private String projectCode;
    private String parentCode;

    public TbProject(){

    }

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
}

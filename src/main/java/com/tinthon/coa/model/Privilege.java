package com.tinthon.coa.model;

import java.util.Date;

public class Privilege {
    private Integer id;

    private String name;

    private String description;

    private String url;

    private Integer type;

    private Integer status;

    private Date createTime;

    private Date updateTime;

    public Privilege(Integer id, String name, String description, String url, Integer type, Integer status, Date createTime, Date updateTime) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.url = url;
        this.type = type;
        this.status = status;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public Privilege() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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
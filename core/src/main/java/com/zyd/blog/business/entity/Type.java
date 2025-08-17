package com.zyd.blog.business.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.zyd.blog.persistence.beans.BizType;

import java.util.Date;
import java.util.List;

public class Type {
    private BizType bizType;

    public Type() {this.bizType = new BizType();}

    public Type(BizType bizType) {this.bizType = bizType;}

    @JsonIgnore
    public com.zyd.blog.persistence.beans.BizType getBizType() {
        return this.bizType;
    }

    public Long getId() {
        return this.bizType.getId();
    }

    public void setId(Long id) {
        this.bizType.setId(id);
    }

    public Long getPid() {
        return this.bizType.getPid();
    }

    public void setPid(Long pid) {
        this.bizType.setPid(pid);
    }

    public Long getParentId() {
        return this.bizType.getPid();
    }

    public String getName() {
        return this.bizType.getName();
    }

    public void setName(String name) {
        this.bizType.setName(name);
    }

    public String getDescription() {
        return this.bizType.getDescription();
    }

    public void setDescription(String description) {
        this.bizType.setDescription(description);
    }

    public Integer getSort() {
        return this.bizType.getSort();
    }

    public void setSort(Integer sort) {
        this.bizType.setSort(sort);
    }

    public boolean isAvailable() {
        Boolean value = this.bizType.getAvailable();
        return value != null ? value : false;
    }

    public void setAvailable(boolean available) {
        this.bizType.setAvailable(available);
    }

    public String getIcon() {
        return this.bizType.getIcon();
    }

    public void setIcon(String icon) {
        this.bizType.setIcon(icon);
    }

    public String getPosition() {
        return this.bizType.getPosition();
    }

    public void setPosition(String position) {
        this.bizType.setPosition(position);
    }

    public Date getCreateTime() {
        return this.bizType.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.bizType.setCreateTime(createTime);
    }

    public Date getUpdateTime() {
        return this.bizType.getUpdateTime();
    }

    public void setUpdateTime(Date updateTime) {
        this.bizType.setUpdateTime(updateTime);
    }

    public com.zyd.blog.persistence.beans.BizType getParent() {
        return this.bizType.getParent();
    }

    public void setParent(com.zyd.blog.persistence.beans.BizType parent) {
        this.bizType.setParent(parent);
    }

    public List<com.zyd.blog.persistence.beans.BizType> getNodes() {
        return this.bizType.getNodes();
    }

    public void setNodes(List<com.zyd.blog.persistence.beans.BizType> nodes) {
        this.bizType.setNodes(nodes);
    }


}

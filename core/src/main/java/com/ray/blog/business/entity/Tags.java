package com.ray.blog.business.entity;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ray.blog.persistence.beans.BizTags;

public class Tags {
    private BizTags bizTags;

    Tags() {this.bizTags = new BizTags();}

    Tags(BizTags bizTags) {this.bizTags = bizTags;}

    public BizTags getBizTags() {return this.bizTags;}

    @JsonIgnore
    public Long getId() {return this.bizTags.getId();}

    public void setId(Long id) {this.bizTags.setId(id);}

    public String getName() {return this.bizTags.getName();}

    public void setName(String name) {this.bizTags.setName(name);}

    public String getDescription() {return this.bizTags.getDescription();}

    public void setDescription(String description) {this.bizTags.setDescription(description);}

    public Date getCreateTime() {return this.bizTags.getCreateTime();}

    public void setCreateTime(Date createTime) {this.bizTags.setCreateTime(createTime);}

    public Date getUpdateTime() {return this.bizTags.getUpdateTime();}

    public void setUpdateTime(Date updateTime) {this.bizTags.setUpdateTime(updateTime);}
}

package com.zyd.blog.business.entity;

import com.zyd.blog.persistence.beans.BizArticle;

import java.util.Date;
import java.util.List;

public class Article {
    private BizArticle bizArticle;
    private boolean isPrivate;

    puclic Article(BizArticle bizArticle) {
    	this.bizArticle = bizArticle;
    }

    public Article() {this.bizArticle = new BizArticle();}

}
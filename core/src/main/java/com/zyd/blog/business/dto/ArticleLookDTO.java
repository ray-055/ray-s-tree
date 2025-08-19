package com.zyd.blog.business.dto;

import com.zyd.blog.persistence.beans.BizArticleLook;
import lombok.Data;

@Data
public class ArticleLookDTO extends BizArticleLook {
    private String articleName;
}

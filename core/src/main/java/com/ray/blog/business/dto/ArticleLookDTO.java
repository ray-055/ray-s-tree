package com.ray.blog.business.dto;

import com.ray.blog.persistence.beans.BizArticleLook;
import lombok.Data;

@Data
public class ArticleLookDTO extends BizArticleLook {
    private String articleName;
}

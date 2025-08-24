package com.ray.blog.persistence.beans;

import com.ray.blog.framework.object.AbstractDO;
import lombok.Data;

@Data
public class BizArticleLook extends AbstractDO {
    private Long articleId;
    private Integer lookCount = 0;
}

package com.zyd.blog.persistence.beans;

import com.zyd.blog.framework.object.AbstractDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author generate by HouTu Generator
 * @version 1.0
 * @date 2025/02/04 22:31
 * @since 1.8
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BizArticleContent extends AbstractDO {
    private Long articleId;
    private String content;
    private String contentMd;
}

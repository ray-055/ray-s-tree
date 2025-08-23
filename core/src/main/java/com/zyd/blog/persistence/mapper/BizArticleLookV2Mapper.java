package com.zyd.blog.persistence.mapper;

import com.zyd.blog.persistence.beans.BizArticleLookV2;
import com.zyd.blog.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BizArticleLookV2Mapper extends BaseMapper<BizArticleLookV2> {

    int increment(@Param("articleId") Long articleId);
}

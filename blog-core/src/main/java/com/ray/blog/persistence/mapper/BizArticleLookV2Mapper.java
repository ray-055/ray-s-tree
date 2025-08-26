package com.ray.blog.persistence.mapper;

import com.ray.blog.persistence.beans.BizArticleLookV2;
import com.ray.blog.plugin.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface BizArticleLookV2Mapper extends BaseMapper<BizArticleLookV2> {

    int increment(@Param("articleId") Long articleId);
}

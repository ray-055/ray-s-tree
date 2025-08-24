package com.ray.blog.persistence.mapper;

import com.ray.blog.persistence.beans.BizStatistics;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizStatisticsMapper {

    List<BizStatistics> listSpider();

    List<BizStatistics> listType();

    List<BizStatistics> listArticleLookCountByArticleIds(@Param("list") List<Long> articleIds);

    List<BizStatistics> listArticleLoveCountByArticleIds(@Param("list") List<Long> articleIds);

    List<BizStatistics> listArticleCommentCountByArticleIds(@Param("list") List<Long> articleIds);
}

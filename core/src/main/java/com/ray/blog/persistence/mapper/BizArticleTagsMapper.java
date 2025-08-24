package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.ArticleTagsConditionVO;
import com.ray.blog.persistence.beans.BizArticleTags;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizArticleTagsMapper extends BaseMapper<BizArticleTags>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizArticleTags> findPageBreakByCondition(ArticleTagsConditionVO vo);
}

package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.ArticleTagsConditionVO;
import com.zyd.blog.persistence.beans.BizArticleTags;
import com.zyd.blog.plugin.BaseMapper;
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

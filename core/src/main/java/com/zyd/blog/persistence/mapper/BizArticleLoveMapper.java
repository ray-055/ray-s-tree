package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.ArticleLoveConditionVO;
import com.zyd.blog.persistence.beans.BizArticleLove;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizArticleLoveMapper extends BaseMapper<BizArticleLove> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<BizArticleLove> findPageBreakByCondition(ArticleLoveConditionVO vo);
}

package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.ArticleLoveConditionVO;
import com.ray.blog.persistence.beans.BizArticleLove;
import com.ray.blog.plugin.BaseMapper;
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

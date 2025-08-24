package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.TagsConditionVO;
import com.ray.blog.persistence.beans.BizTags;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizTagsMapper extends BaseMapper<BizTags>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizTags> findPageBreakByCondition(TagsConditionVO vo);
}

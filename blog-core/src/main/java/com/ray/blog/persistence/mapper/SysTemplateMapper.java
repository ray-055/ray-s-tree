package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.TemplateConditionVO;
import com.ray.blog.persistence.beans.SysTemplate;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysTemplateMapper extends BaseMapper<SysTemplate>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysTemplate> findPageBreakByCondition(TemplateConditionVO vo);
}

package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.TemplateConditionVO;
import com.zyd.blog.persistence.beans.SysTemplate;
import com.zyd.blog.plugin.BaseMapper;
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

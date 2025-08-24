package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.LinkConditionVO;
import com.ray.blog.persistence.beans.SysLink;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysLinkMapper extends BaseMapper<SysLink>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysLink> findPageBreakByCondition(LinkConditionVO vo);
}

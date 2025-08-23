package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.LinkConditionVO;
import com.zyd.blog.persistence.beans.SysLink;
import com.zyd.blog.plugin.BaseMapper;
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

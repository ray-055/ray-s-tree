package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.NoticeConditionVO;
import com.zyd.blog.persistence.beans.SysNotice;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysNoticeMapper extends BaseMapper<SysNotice>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysNotice> findPageBreakByCondition(NoticeConditionVO vo);
}

package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.NoticeConditionVO;
import com.ray.blog.persistence.beans.SysNotice;
import com.ray.blog.plugin.BaseMapper;
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

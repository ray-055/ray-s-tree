package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.LogConditionVO;
import com.ray.blog.persistence.beans.SysLog;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysLogMapper extends BaseMapper<SysLog> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysLog> findPageBreakByCondition(LogConditionVO vo);
}

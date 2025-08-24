package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.UpdateRecordeConditionVO;
import com.ray.blog.persistence.beans.SysUpdateRecorde;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUpdateRecordeMapper extends BaseMapper<SysUpdateRecorde>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<SysUpdateRecorde> findPageBreakByCondition(UpdateRecordeConditionVO vo);
}

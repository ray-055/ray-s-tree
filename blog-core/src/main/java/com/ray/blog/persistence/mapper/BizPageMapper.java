package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.PageConditionVO;
import com.ray.blog.persistence.beans.BizPage;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizPageMapper extends BaseMapper<BizPage> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<BizPage> findPageBreakByCondition(PageConditionVO vo);
}

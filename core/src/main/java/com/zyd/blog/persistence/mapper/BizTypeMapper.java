package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.TypeConditionVO;
import com.zyd.blog.persistence.beans.BizType;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizTypeMapper extends BaseMapper<BizType> {

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizType> findPageBreakByCondition(TypeConditionVO vo);

    List<BizType> listParent();

    List<BizType> listTypeForMenu();
}


package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.BizAdConditionVO;
import com.ray.blog.persistence.beans.BizAd;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizAdMapper extends BaseMapper<BizAd>{

    /**
     * 分页查询
     * @param vo
     *
     * @return
     */
    List<BizAd> findPageBreakByCondition(BizAdConditionVO vo);
}

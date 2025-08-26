
package com.ray.blog.business.service;


import com.github.pagehelper.PageInfo;
import com.ray.blog.business.entity.BizAdBo;
import com.ray.blog.business.enums.AdPositionEnum;
import com.ray.blog.business.vo.BizAdConditionVO;
import com.ray.blog.framework.object.AbstractService;

import java.util.List;

/**
 *
 *
 * @author generate by HouTu Generator
 * @version 1.0
 * @date 2021/10/27 16:43
 * @since 1.8
 */
public interface BizAdService extends AbstractService<BizAdBo, Long> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<BizAdBo> findPageBreakByCondition(BizAdConditionVO vo);

    BizAdBo getByPosition(AdPositionEnum positionEnum);

    List<BizAdBo> listArticleAds();
}
